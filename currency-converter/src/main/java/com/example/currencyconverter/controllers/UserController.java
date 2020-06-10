package com.example.currencyconverter.controllers;

import com.example.currencyconverter.dao.CurrencyRepository;
import com.example.currencyconverter.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Currency> currencyList = currencyRepository.findAll();
//        List<String> codesList = new ArrayList<>();
//        for (Currency currency: currencyList){
//            codesList.add(currency.getCode());
//        }

        model.addAttribute("currencies", currencyList);
        //model.addAttribute("")

        return "index";
    }
}
