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
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    CurrencyService currencyService;

    @Autowired
    CurrenciesBnbLoadingService currenciesBnbLoadingService;

    @GetMapping("/admin/addCurrency")
    public ModelAndView addCurrency() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("currencyDto", new CurrencyDto());

        return modelAndView;
    }

    @PostMapping("/admin/addCurrency")
    public String addCurrency(@Valid CurrencyDto currencyDto, Errors errors) {
        if (errors.hasErrors()) {
            return "add";
        }
        Currency currency = new Currency(
                currencyDto.getCode(), currencyDto.getName(),
                currencyDto.getRate(), currencyDto.getRatio());
        currencyService.addCurrency(currency);
        return "redirect:/";
    }

    @GetMapping("/admin/currencies/refresh")
    public String refreshCurrenciesRates(){
        List<Currency> currencyList =  currenciesBnbLoadingService.getCurrencies();

        for (Currency currency : currencyList){
            currencyService.addCurrency(currency);
        }

        return "redirect:/";
    }
}
