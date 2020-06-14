package com.example.currencyconverter.controller;

import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.dto.CurrencyDto;
import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

//@RequestMapping("/api/v1/user")
@Controller
public class UserController {//this should be IndexController

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Currency> currencyList = currencyService.getAllCurrencies();

        model.addAttribute("currencies", currencyList);

        return "index";
    }
}
