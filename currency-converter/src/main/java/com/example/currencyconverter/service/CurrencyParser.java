package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@Service
public class CurrencyParser {

    public Currency parseFromNode(Node node){
        Element eElement = (Element) node;
        Currency currency = new Currency();//todo all magic strings
        currency.setName(eElement
                .getElementsByTagName("NAME_").item(0).getTextContent());
        currency.setCode(eElement
                .getElementsByTagName("CODE").item(0).getTextContent());
        try {
            currency.setRate(Double.valueOf(eElement
                    .getElementsByTagName("RATE").item(0).getTextContent()));
            currency.setRatio(Integer.parseInt(eElement
                    .getElementsByTagName("RATIO").item(0).getTextContent()));
        } catch (NumberFormatException exception) {
           // log.info(exception.getMessage(), exception);todo
        }//other service
        return currency;
    }
}
