package com.example.currencyconverter.service;

import com.example.currencyconverter.dao.CurrencyRepository;
import com.example.currencyconverter.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConvertService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Double convertCurrencyFromTo(Currency codeFrom, Currency codeTo, Double amount) {//todo rename
        //Currency currencyFrom = currencyRepository.findById(codeFrom).get();//todo check levs and add
        //Currency currencyTo = currencyRepository.findById(codeTo).get();//TODO IF NULL STATUS CODE

        return ((amount * codeFrom.getRate()) * codeTo.getRatio()) / (codeTo.getRate() * codeFrom.getRatio());
    }
}
