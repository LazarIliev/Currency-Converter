package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


@Slf4j
@Service
public class CurrencyParser {
    private static final String NAME_ = "NAME_";
    private static final String CODE = "CODE";
    private static final String RATE = "RATE";
    private static final String RATIO = "RATIO";

    public Currency parseFromNode(Node node){
        Element eElement = (Element) node;
        Currency currency = new Currency();
        currency.setName(eElement
                .getElementsByTagName(NAME_).item(0).getTextContent());
        currency.setCode(eElement
                .getElementsByTagName(CODE).item(0).getTextContent());
        try {
            currency.setRate(Double.valueOf(eElement
                    .getElementsByTagName(RATE).item(0).getTextContent()));
            currency.setRatio(Integer.parseInt(eElement
                    .getElementsByTagName(RATIO).item(0).getTextContent()));
        } catch (NumberFormatException exception) {
            log.info(exception.getMessage(), exception);
        }
        return currency;
    }
}
