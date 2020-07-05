package com.example.currencyconverter.api;

import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.dto.CurrencyDto;
import com.example.currencyconverter.service.CurrencyConvertService;
import com.example.currencyconverter.service.CurrencyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@RestController
public class CurrencyResource {
    @Autowired
    CurrencyConvertService currencyConvertService;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("api/convert")
    @CrossOrigin("*")
    ResponseEntity<String> convert(@RequestParam @NotEmpty String codeFrom, @RequestParam @NotEmpty String codeTo, @RequestParam Double amount) {
        if (amount <= 0 || codeFrom.equals(codeTo)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Optional<Currency> currencyFrom = currencyService.getByCode(codeFrom);
        Optional<Currency> currencyTo = currencyService.getByCode(codeTo);
        if (currencyFrom.isEmpty() || currencyTo.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(currencyConvertService.convertCurrency(currencyFrom.get(), currencyTo.get(), amount), HttpStatus.OK);
    }

    @GetMapping("api/currencies")
    @CrossOrigin("*")
    Iterable<Currency> getAllCurrencies(){
        return currencyService.getAllCurrencies();
    }

    //to api/add addCurrency

    @PostMapping("api/add")
    @CrossOrigin("*")
    ResponseEntity<String> addCurrency(@RequestBody CurrencyDto currencyDto){
        // if (errors.hasErrors() || currencyService.isCurrencyExistByCode(currencyDto.getCode())) {
        Currency currency = convertToEntity(currencyDto);
        currencyService.addCurrency(currency);

        return ResponseEntity.ok("Currency added.");
    }

    private Currency convertToEntity(CurrencyDto currencyDto) {
        return modelMapper.map(currencyDto, Currency.class);
    }

}