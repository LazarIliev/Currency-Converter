package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.currencyconverter.constants.CurrencyConverterAppConstants.XML_FILE_URL_FROM_BNB_CURRENCIES;

@Service
public class CurrenciesBnbLoadingService {

    @Autowired
    CurrenciesFromBnbToTxtFile currenciesFromBnbToTxtFile;

    @Autowired
    CurrenciesFromTxtFile currenciesFromTxtFile;

    @Autowired
    CurrencyService currencyService;

    public Boolean getCurrencies() {
        String url_path = XML_FILE_URL_FROM_BNB_CURRENCIES;
        currenciesFromBnbToTxtFile.write();//rename more general form stream to txt file
        //how to use xml structure without to write to file and validate

        //read node and validate with dto
        for (Currency currency : currenciesFromTxtFile.getCurrencies()){
            currencyService.addCurrency(currency);
        }

        return true;//todo check
    }
}
