package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrenciesBnbLoadingService {

    @Autowired
    CurrenciesFromBNBService currenciesFromBNBService;

    @Autowired
    CurrencyService currencyService;

    public void reloadCurrencies() {//todo rename reloadCurrencies
        for (Currency currency : currenciesFromBNBService.getCurrencies()){//currencies from bnb
            currencyService.addCurrency(currency);
        }
    }
}
