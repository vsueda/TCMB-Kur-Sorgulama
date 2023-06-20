package com.example.kurTCMB.controller;

import com.example.kurTCMB.dto.CurrencyDTO;
import com.example.kurTCMB.parameter.CurrencyDateParameter;
import com.example.kurTCMB.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/getCurrencyData")
    public ResponseEntity<Iterable<CurrencyDTO>> getCurrencyData(@RequestBody CurrencyDateParameter dateParameter) {
        Iterable<CurrencyDTO> currencyList = currencyService.getModel(dateParameter);
        return ResponseEntity.ok(currencyList);
    }

    @PostMapping("/getCrossCurrencies")
    public ResponseEntity<Iterable<CurrencyDTO>> getCrossCurrencies(@RequestBody Long currencyDataId) {
        Iterable<CurrencyDTO> currencyList = currencyService.getCrossCurrencies(currencyDataId);
        return ResponseEntity.ok(currencyList);
    }
}
