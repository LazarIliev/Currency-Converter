package com.example.currencyconverter.controller;

import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/api/v1/user/")
@RestController
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @GetMapping("api/convert")
    @CrossOrigin("*")
    Double convert(@RequestParam String codeFrom, @RequestParam String codeTo, @RequestParam Double amount){
        //todo here I have to validate data(if data is not valid to return object with the status code),
        // after that when data is valid to use CurrencyService
        //todo to calculate and return the calculated result wrapped into object
        String str = "a";
        //return ResponseEntity<?>.status.OK or Not
        return currencyService.convertCurrencyFromTo(codeFrom, codeTo, amount);
    }
}
