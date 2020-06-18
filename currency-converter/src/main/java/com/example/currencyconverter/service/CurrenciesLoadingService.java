package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrenciesLoadingService {

    @Autowired
    CurrenciesFromBNBService currenciesFromBNBService;

    @Autowired
    CurrencyService currencyService;

    public void refreshCurrencies() {
        for (Currency currency : currenciesFromBNBService.getCurrencies()){
            currencyService.addCurrency(currency);
        }
    }
}
