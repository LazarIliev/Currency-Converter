package com.example.currencyconverter.ui;

import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.dto.CurrencyDto;
import com.example.currencyconverter.service.CurrenciesBnbLoadingService;
import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    CurrencyService currencyService;

    @Autowired
    CurrenciesBnbLoadingService currenciesBnbLoadingService;

    @GetMapping("/admin/addCurrency")//currency
    public ModelAndView addCurrency() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("currencyDto", new CurrencyDto());

        return modelAndView;
    }

    @PostMapping("/admin/addCurrency")//currency
    public String addCurrency(@Valid CurrencyDto currencyDto, Errors errors) {
        if (errors.hasErrors()) {
            return "add";
        }
        Currency currency = new Currency(//todo
                currencyDto.getCode(), currencyDto.getName(),
                currencyDto.getRate(), currencyDto.getRatio());
        currencyService.addCurrency(currency);
        return "redirect:/";
    }

    @GetMapping("/admin/currencies/refresh")
    public String refreshCurrenciesRates() {
        currenciesBnbLoadingService.reloadCurrencies();//todo rename

        return "redirect:/";
    }
}
