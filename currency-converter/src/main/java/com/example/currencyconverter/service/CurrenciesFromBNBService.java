package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.validation.CurrencyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Slf4j
@Service
public class CurrenciesFromBNBService {
    private static final String ROW = "ROW";
    @Autowired
    CurrencyValidator currencyValidator;//todo to add list for forbidden currencies to not add
    @Autowired
    CurrenciesReader currenciesReader;
    @Autowired
    CurrencyParser currencyParser;

    public List<Currency> getCurrencies() {
        List<Currency> currencyList = new ArrayList<>();
        Document document = currenciesReader.readExternalStreamAsDocument();
        NodeList nList = document.getElementsByTagName(ROW);//todo use iterator
        //skip first and last, todo with validator
        for (int temp = 1; temp < nList.getLength() - 1; temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Currency currency = currencyParser.parseFromNode(nNode);
                if (isValidCurrency(currency)) {
                    currencyList.add(currency);
                }
            }
        }
        return currencyList;
    }

    private boolean isValidCurrency(Currency currency) {
        Set<ConstraintViolation<Currency>> violations = currencyValidator.validate(currency);
        if (violations.size() != 0) {
            for (ConstraintViolation violation : violations) {
                System.out.println(violation);
                log.info(violation.getMessage());
            }
            return false;
        }
        return true;
    }
}
