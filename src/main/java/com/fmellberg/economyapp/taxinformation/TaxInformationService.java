package com.fmellberg.economyapp.taxinformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.management.Query;
import java.util.List;

@Service
public class TaxInformationService {

    @Autowired
    private Environment environment;
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    public List<TaxInformationDTOResponse> getTaxInformation() {
        String apiURL = environment.getProperty("skatteverketAPI.url");

//        HttpHeaders headers = new HttpHeaders();
//        headers.set... set any header, e.g. Token
//        HttpEntity<String> entity = new HttpEntity<String>(headers); // pass in as http requestEntity

        // Http request using (deprecated) RestTemplate http tool, in this case the exchange method
        // DTO extracts json properties, via TaxInformationAPIResponse.class
        ResponseEntity<TaxInformationAPIResponse> responseEntity = restTemplate.exchange(apiURL, HttpMethod.GET, null, TaxInformationAPIResponse.class);
//        ResponseEntity<TaxInformationAPIResponse> responseEntity = restTemplate.exchange(apiURL, HttpMethod.GET, entity, TaxInformationAPIResponse.class, 1000);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println(responseEntity.getBody().getLimit()); // server returns only 100 by default
            return responseEntity.getBody().getResults(); // Get and return the now extracted and filled response DTO list
        } else {
            // Handle error response
            System.out.println("API request failed with status code: " + responseEntity.getStatusCodeValue());
        }

        return null;
    }

}
