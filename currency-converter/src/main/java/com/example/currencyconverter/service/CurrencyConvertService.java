package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class CurrencyConvertService {
    private static final DecimalFormat df2 = new DecimalFormat("#.####");
    private static final String BULGARIAN_CURRENCY_CODE = "BGN";
    private static final String CURRENCY_CODES_SHOULD_NOT_BE_THE_SAME = "Currency codes should not be the same!";

    public String convertCurrency(Currency currencyFrom, Currency currencyTo, Double amount) {
        Double fromCurrencyAmount = amount;
        Double toCurrencyFactor = 1d;
        if (currencyFrom.getCode().equals(currencyTo.getCode())){
            return CURRENCY_CODES_SHOULD_NOT_BE_THE_SAME;
        }
        if (!currencyFrom.getCode().equals(BULGARIAN_CURRENCY_CODE)) {
            fromCurrencyAmount = convertToBGN(currencyFrom, amount);
        }
        if (!currencyTo.getCode().equals(BULGARIAN_CURRENCY_CODE)) {
            toCurrencyFactor = getToCurrencyFactor(currencyTo);
        }
        df2.setRoundingMode(RoundingMode.DOWN);
        return df2.format(fromCurrencyAmount / toCurrencyFactor);
    }

    private double convertToBGN(Currency codeFrom, Double amount) {
        return codeFrom.getRate() * amount / codeFrom.getRatio();
    }

    private double getToCurrencyFactor(Currency codeTo) {
        return codeTo.getRate() / codeTo.getRatio();
    }
}
