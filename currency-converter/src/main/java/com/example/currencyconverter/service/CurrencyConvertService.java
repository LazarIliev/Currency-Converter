package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConvertService {
    public Double convertCurrencyFromTo(Currency currencyFrom, Currency currencyTo, Double amount) {//todo rename
        Double fromCurrencyAmount = amount;
        Double toCurrencyFactor = 1d;
        if(!currencyFrom.getCode().equals("BGN")){
            //calculate sum from rate*amount*ratio
            fromCurrencyAmount = getFromCurrencyAmount(currencyFrom, currencyTo, amount);
        }
        if (!currencyTo.getCode().equals("BGN")){
            //rate
            toCurrencyFactor = getToCurrencyFactor(currencyFrom, currencyTo);
        }
        return fromCurrencyAmount / toCurrencyFactor; //((amount * codeFrom.getRate()) * codeTo.getRatio()) / (codeTo.getRate() * codeFrom.getRatio());//todo math rounding
    }

    private double getToCurrencyFactor(Currency codeFrom, Currency codeTo) {
        return codeTo.getRate()*codeFrom.getRatio();
    }

    private double getFromCurrencyAmount(Currency codeFrom, Currency codeTo, Double amount) {
        return codeFrom.getRate() * amount * codeTo.getRatio();
    }
}
