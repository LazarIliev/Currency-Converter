package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrenciesBnbLoadingService {

    @Autowired
    CurrenciesFromTxtFile currenciesFromTxtFile;

    @Autowired
    CurrencyService currencyService;

    public void getCurrencies() {//todo rename reloadCurrencies
        for (Currency currency : currenciesFromTxtFile.getCurrencies()){//currencies from bnb
            currencyService.addCurrency(currency);
        }
    }
}
