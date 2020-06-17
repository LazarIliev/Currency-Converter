package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.validation.CurrencyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.example.currencyconverter.constants.CurrencyConverterAppConstants.XML_FILE_URL_FROM_BNB_CURRENCIES;

@Service
public class CurrenciesFromBNBService {//todo rename from bnb

    @Autowired
    CurrencyValidator currencyValidator;

    public List<Currency> getCurrencies() {//todo close all streams
        List<Currency> currencyList = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new URL(XML_FILE_URL_FROM_BNB_CURRENCIES).openStream());
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("ROW");
            //skip first and last
            for (int temp = 1; temp < nList.getLength() - 1; temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Currency currency = new Currency();//todo
                    currency.setName(eElement
                            .getElementsByTagName("NAME_").item(0).getTextContent());
                    currency.setCode(eElement
                            .getElementsByTagName("CODE").item(0).getTextContent());
                    try {
                        currency.setRate(Double.valueOf(eElement
                                .getElementsByTagName("RATE").item(0).getTextContent()));
                        currency.setRatio(Integer.parseInt(eElement
                                .getElementsByTagName("RATIO").item(0).getTextContent()));
                    }catch (NumberFormatException exception){
                       //todo
                    }

                    Set<ConstraintViolation<Currency>> violations = currencyValidator.validate(currency);
                    if (violations.size() != 0){
                        //todo log the violations and skip it
                        for (ConstraintViolation violation : violations) {
                            System.out.println(violation);
                        }
                        continue;
                    }
                    currencyList.add(currency);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return currencyList;
    }
}