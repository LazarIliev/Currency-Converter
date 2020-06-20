package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class CurrencyConvertService {
    private static final DecimalFormat df2 = new DecimalFormat("#.####");
    private static final String BULGARIAN_CURRENCY_CODE = "BGN";

    public String convertCurrencyFromTo(Currency currencyFrom, Currency currencyTo, Double amount) {
        Double fromCurrencyAmount = amount;
        Double toCurrencyFactor = 1d;
        if (!currencyFrom.getCode().equals(BULGARIAN_CURRENCY_CODE)) {
            fromCurrencyAmount = getFromCurrencyAmount(currencyFrom, currencyTo, amount);
        }
        if (!currencyTo.getCode().equals(BULGARIAN_CURRENCY_CODE)) {
            toCurrencyFactor = getToCurrencyFactor(currencyFrom, currencyTo);
        }
        df2.setRoundingMode(RoundingMode.DOWN);
        return df2.format(fromCurrencyAmount / toCurrencyFactor);
    }

    private double getToCurrencyFactor(Currency codeFrom, Currency codeTo) {
        return codeTo.getRate() * codeFrom.getRatio();
    }

    private double getFromCurrencyAmount(Currency codeFrom, Currency codeTo, Double amount) {
        return codeFrom.getRate() * amount * codeTo.getRatio();
    }
}
