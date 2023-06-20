package com.fmellberg.economyapp.taxinformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tax-information")
public class TaxInformationController {


    private final TaxInformationService taxInformationService;

    @Autowired
    public TaxInformationController(TaxInformationService taxInformationService) {
        this.taxInformationService = taxInformationService;
    }

    @GetMapping()
    public ResponseEntity<List<TaxInformationDTOResponse>> getTaxInformation() {
        List<TaxInformationDTOResponse> response = taxInformationService.getTaxInformation();
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
