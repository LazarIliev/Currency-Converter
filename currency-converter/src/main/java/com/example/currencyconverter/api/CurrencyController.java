package com.example.currencyconverter.api;

import com.example.currencyconverter.service.CurrencyConvertService;
import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {//CurrencyConvertResource
    @Autowired
    CurrencyConvertService currencyConvertService;

    @GetMapping("api/convert")//api/v1/convert
    @CrossOrigin("*")
    ResponseEntity<Double> convert(@RequestParam String codeFrom, @RequestParam String codeTo, @RequestParam Double amount){
        if (amount <= 0 ){//validate code currencies with dto and validator
            return new ResponseEntity<>((Double) null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(currencyConvertService.convertCurrencyFromTo(codeFrom, codeTo, amount), HttpStatus.OK);
    }
}
