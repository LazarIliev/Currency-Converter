package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConvertServiceTest {
    CurrencyConvertService currencyConvertService = new CurrencyConvertService();

    @Test
    void convertCurrencyFromTo_withEuroAndUSD_shouldWork() {
        Currency currencyEUR = new Currency("EUR","Euro", 1.95, 1);
        Currency currencyUSD = new Currency("USD","USA", 1.74, 1);

        String actualAmount = currencyConvertService.convertCurrencyFromTo(currencyEUR, currencyUSD, 20d);
        String expectedAmount = "22.4137";

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void convertCurrencyFromTo_withBGNAndBGN_shouldWork() {
        Currency currencyEUR = new Currency("BGN","bg", 1d, 1);
        Currency currencyUSD = new Currency("BGN","bg", 1d, 1);

        String actualAmount = currencyConvertService.convertCurrencyFromTo(currencyEUR, currencyUSD, 20d);
        String expectedAmount = "20";

        assertEquals(expectedAmount, actualAmount);
    }
}