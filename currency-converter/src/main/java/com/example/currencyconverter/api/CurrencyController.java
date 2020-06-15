package com.example.currencyconverter.api;

import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/api/v1/user/")
@RestController
public class CurrencyController {//CurrencyConvertResource
    @Autowired
    CurrencyService currencyService;

    @GetMapping("api/convert")
    @CrossOrigin("*")
    ResponseEntity<Double> convert(@RequestParam String codeFrom, @RequestParam String codeTo, @RequestParam Double amount){
        //todo here I have to validate data(if data is not valid to return object with the status code),
        // after that when data is valid to use CurrencyService
        //todo to calculate and return the calculated result wrapped into object
        if (amount < 0 ){
            return new ResponseEntity<>((Double) null, HttpStatus.BAD_REQUEST);
        }

        //return ResponseEntity<?>.status.OK or Not
        return new ResponseEntity<>(currencyService.convertCurrencyFromTo(codeFrom, codeTo, amount), HttpStatus.OK);
    }
}
