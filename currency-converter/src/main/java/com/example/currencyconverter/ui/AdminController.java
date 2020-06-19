package com.example.currencyconverter.ui;

import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.dto.CurrencyDto;
import com.example.currencyconverter.service.CurrenciesLoadingService;
import com.example.currencyconverter.service.CurrencyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdminController {///admin/currency/delete
    @Autowired
    CurrencyService currencyService;
    @Autowired
    CurrenciesLoadingService currenciesLoadingService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/admin/addCurrency")//todo to replace addCurrency with currency
    public ModelAndView addCurrency() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("currencyDto", new CurrencyDto());
        return modelAndView;//todo stay
    }

    @PostMapping("/admin/addCurrency")
    public String addCurrency(@Valid CurrencyDto currencyDto, Errors errors, Model model) {
        String messageExistCode = "";
        model.addAttribute("messageCodeExist", messageExistCode);
        if (errors.hasErrors() || currencyService.isCurrencyExistByCode(currencyDto.getCode())) {
            messageExistCode = "Currency code already exist!";
            model.addAttribute("messageCodeExist", messageExistCode);
            return "add";
        }
        Currency currency = convertToEntity(currencyDto);
        currencyService.addCurrency(currency);
        return "redirect:/";
    }//todo remove

    @GetMapping("/admin/currencies/refresh")
    public String refreshCurrenciesRates() {
        currenciesLoadingService.refreshCurrencies();
        return "redirect:/";
    }

    @GetMapping("/admin/currency/delete/{code}")
    public String deleteCurrency(@PathVariable String code){
        currencyService.delete(code);
        return "redirect:/";
    }//todo remove

    @GetMapping("/admin/currency/update/{code}")
    public ModelAndView updateCurrency(@PathVariable String code){
        Currency currency = currencyService.getByCode(code).get();
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("currency", currency);
        return modelAndView;
    }

    @PostMapping("/admin/currency/update/{code}")
    public String updateCurrency(@Valid CurrencyDto currencyDto, Errors errors){
        if (errors.hasErrors()){
            return "update";
        }
        Currency currency = convertToEntity(currencyDto);
        currencyService.addCurrency(currency);
        return "redirect:/";
    }

    private Currency convertToEntity(CurrencyDto currencyDto){
        return modelMapper.map(currencyDto, Currency.class);
    }
}
