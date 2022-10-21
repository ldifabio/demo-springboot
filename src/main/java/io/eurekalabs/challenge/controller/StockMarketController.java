package io.eurekalabs.challenge.controller;

import io.eurekalabs.challenge.service.StockMarketService;
import io.eurekalabs.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
public class StockMarketController {

    private final StockMarketService stockMarketService;
    private final UserService userService;

    @GetMapping("/stock-market")
    public ResponseEntity queryStockMarket(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String apiKey) {
//        log.debug("Stock market {} con los datos {}", request.getUsername(), request);
        userService.validApiKey(apiKey);
        try {
            return ResponseEntity.ok("");
        } catch (Exception e) {
            log.info(e.getMessage());
            throw e;
        }
    }
}
