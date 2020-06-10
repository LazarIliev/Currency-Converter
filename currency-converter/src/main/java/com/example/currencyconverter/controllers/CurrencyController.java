package com.example.currencyconverter.controllers;

import com.example.currencyconverter.dao.CurrencyRepository;
import com.example.currencyconverter.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {

    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/convert")
    @CrossOrigin("*")
    Double convert(@RequestParam String codeFrom, @RequestParam String codeTo, @RequestParam Integer amount){//@RequestParam String codeFrom, @RequestParam String codeTo, @RequestParam Integer amount

        String a = "sdas";

        Currency currencyFrom = currencyRepository.findById(codeFrom).get();
        Currency currencyTo = currencyRepository.findById(codeTo).get();
        //do the calculation

        return 0d;
    }
}
