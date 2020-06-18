package com.example.currencyconverter.ui;

import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {//todo this should be IndexController
    @Autowired
    CurrencyService currencyService;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Currency> currencyList = currencyService.getAllCurrencies();
        model.addAttribute("currencies", currencyList);
        return "index";
    }
}
