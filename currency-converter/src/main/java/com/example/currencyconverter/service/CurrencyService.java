package com.example.currencyconverter.service;

import com.example.currencyconverter.dao.CurrencyRepository;
import com.example.currencyconverter.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {
   @Autowired
   CurrencyRepository currencyRepository;

   public Iterable<Currency> getAllCurrencies(){
       return currencyRepository.findAll();
   }

   public Optional<Currency> getByCode(String code){
       return currencyRepository.findById(code);
   }

   public void addCurrency(Currency currency){
       currencyRepository.save(currency);
   }
}
