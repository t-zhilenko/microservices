package com.frank.accounts.service.client;

import com.frank.accounts.dto.CardsDTO;
import com.frank.accounts.dto.LoansDTO;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "loans", url = "http://loans:9000", fallback = LoansFallback.class)
public interface LoansFeignClient {

    @GetMapping(value = "/api/fetch", consumes = "application/json")
    public ResponseEntity<LoansDTO> fetchLoanDetails(@RequestHeader("frankbank-correlation-id") String correlationId,
                                                     @RequestParam String mobileNumber);

}
