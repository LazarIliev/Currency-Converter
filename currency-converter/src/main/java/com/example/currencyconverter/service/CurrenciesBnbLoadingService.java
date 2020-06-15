package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrenciesBnbLoadingService {

    @Autowired
    CurrenciesFromBnbToTxtFile currenciesFromBnbToTxtFile;

    @Autowired
    CurrenciesFromTxtFile currenciesFromTxtFile;

    public List<Currency> getCurrencies() {
        currenciesFromBnbToTxtFile.write();

        return currenciesFromTxtFile.getCurrencies();
    }
}
