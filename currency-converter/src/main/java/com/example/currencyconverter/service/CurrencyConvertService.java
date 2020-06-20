package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class CurrencyConvertService {
    private static final DecimalFormat df2 = new DecimalFormat("#.####");
    private static final String BULGARIAN_CURRENCY_CODE = "BGN";
//convertCurrency
    public String convertCurrencyFromTo(Currency currencyFrom, Currency currencyTo, Double amount) {
        Double fromCurrencyAmount = amount;
        Double toCurrencyFactor = 1d;//1.95
                                     //1.74
        if (!currencyFrom.getCode().equals(BULGARIAN_CURRENCY_CODE)) {
            fromCurrencyAmount = getFromCurrencyAmount(currencyFrom, currencyTo, amount);
        }
        if (!currencyTo.getCode().equals(BULGARIAN_CURRENCY_CODE)) {//todo validate for the same currency codes
            toCurrencyFactor = getToCurrencyFactor(currencyFrom, currencyTo);
        }
        df2.setRoundingMode(RoundingMode.DOWN);
        return df2.format(fromCurrencyAmount / toCurrencyFactor);//todo to check
    }

    private double getFromCurrencyAmount(Currency codeFrom, Currency codeTo, Double amount) {//todo rename convertToBGN
        return codeFrom.getRate() * amount * codeTo.getRatio();
    }

    private double getToCurrencyFactor(Currency codeFrom, Currency codeTo) {   //todo convertFromBGN
        return codeTo.getRate() * codeFrom.getRatio();
    }
}
