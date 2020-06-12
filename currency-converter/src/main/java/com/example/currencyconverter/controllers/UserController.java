package com.example.currencyconverter.controllers;

import com.example.currencyconverter.repositories.CurrencyRepository;
import com.example.currencyconverter.models.Currency;
import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {//this should be IndexController

    @Autowired
    CurrencyService currencyService;
    
    @GetMapping("/")
    public String index(Model model){
        Iterable<Currency> currencyList = currencyService.getAllCurrencies();

        model.addAttribute("currencies", currencyList);

        return "index";
    }

    @GetMapping("/admin/addCurrency")
    public String addCurrency(){


        return "add";
    }

    @PostMapping("/admin/addCurrency")
    public String addCurrency(Model model){


        return "index";
    }
}
