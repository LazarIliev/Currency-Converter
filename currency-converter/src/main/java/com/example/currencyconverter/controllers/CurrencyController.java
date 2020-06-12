package com.example.currencyconverter.controllers;

import com.example.currencyconverter.repositories.CurrencyRepository;
import com.example.currencyconverter.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {//user wants to convert, admin wants to add currency

    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/convert")
    @CrossOrigin("*")
    Double convert(@RequestParam String codeFrom, @RequestParam String codeTo, @RequestParam Integer amount){//@RequestParam String codeFrom, @RequestParam String codeTo, @RequestParam Integer amount

        String a = "sdas";
        //here I have to validate data(if data is not valid to return object with the status code),
        // after that when data is valid to use CurrencyService
        // to calculate and return the calculated result wrapped into object
        Currency currencyFrom = currencyRepository.findById(codeFrom).get();
        Currency currencyTo = currencyRepository.findById(codeTo).get();
        //do the calculation

        return 0d;
    }
}
