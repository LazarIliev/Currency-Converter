package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.dao.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

@Service
public class CurrencyService {
   @Autowired
   CurrencyRepository currencyRepository;

   public Iterable<Currency> getAllCurrencies(){
       return currencyRepository.findAll();
   }

    public Double convertCurrencyFromTo(String codeFrom, String codeTo, Double amount) {
        Currency currencyFrom = currencyRepository.findById(codeFrom).get();
        Currency currencyTo = currencyRepository.findById(codeTo).get();

        return ((amount * currencyFrom.getRate()) * currencyTo.getRatio()) / (currencyTo.getRate() * currencyFrom.getRatio());
    }

   public void addCurrency(Currency currency){
       currencyRepository.save(currency);
   }
}
