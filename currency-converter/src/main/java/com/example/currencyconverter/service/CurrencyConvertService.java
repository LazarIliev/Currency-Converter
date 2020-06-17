package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConvertService {
    public Double convertCurrencyFromTo(Currency codeFrom, Currency codeTo, Double amount) {//todo rename
        return ((amount * codeFrom.getRate()) * codeTo.getRatio()) / (codeTo.getRate() * codeFrom.getRatio());//todo math rounding
    }//todo 2 private methods
}
