package com.fmellberg.economyapp.taxinformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TaxInformationService {

    @Autowired
    private Environment environment;
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    public List<TaxInformationDTOResponse> getTaxInformation() {
        String apiURL = environment.getProperty("skatteverketAPI.url");

//        ResponseEntity<TaxInformationAPIResponse> responseEntity = restTemplate.exchange(apiURL, HttpMethod.GET, null, TaxInformationAPIResponse.class);
        ResponseEntity<TaxInformationAPIResponse> responseEntity = restTemplate.exchange(apiURL, HttpMethod.GET, null, TaxInformationAPIResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody().getResults();
        } else {
            // Handle error response
            System.out.println("API request failed with status code: " + responseEntity.getStatusCodeValue());
        }

        return null;
    }

    //
}
