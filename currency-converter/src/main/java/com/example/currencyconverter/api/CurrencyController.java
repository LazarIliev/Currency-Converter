package com.example.currencyconverter.api;

import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.service.CurrencyConvertService;
import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CurrencyController {//todo CurrencyConvertRest
    @Autowired
    CurrencyConvertService currencyConvertService;
    @Autowired
    CurrencyService currencyService;

    @GetMapping("api/convert")//api/v1/convert
    @CrossOrigin("*")
    ResponseEntity<String> convert(@RequestParam String codeFrom, @RequestParam String codeTo, @RequestParam Double amount){
        if (amount <= 0 ){
            return new ResponseEntity<>( null, HttpStatus.BAD_REQUEST);
        }
        Optional<Currency> currencyFrom = currencyService.getByCode(codeFrom);
        Optional<Currency> currencyTo = currencyService.getByCode(codeTo);
        if (currencyFrom.isEmpty() || currencyTo.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(currencyConvertService.convertCurrencyFromTo(currencyFrom.get(), currencyTo.get(), amount), HttpStatus.OK);
    }
}
