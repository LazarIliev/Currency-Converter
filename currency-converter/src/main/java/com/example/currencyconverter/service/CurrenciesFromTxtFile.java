package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.currencyconverter.constants.CurrencyConverterAppConstants.CURRENCIES_DATA_PATH_FILE;

@Service
public class CurrenciesFromTxtFile {

    public List<Currency> getCurrencies() {
        List<Currency> currencyList = new ArrayList<>();
        File file = new File(CURRENCIES_DATA_PATH_FILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("ROW");
            //skip first and last
            for (int temp = 1; temp < nList.getLength() - 1; temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Currency currency = new Currency();
                    currency.setName(eElement
                            .getElementsByTagName("NAME_").item(0).getTextContent());
                    currency.setCode(eElement
                            .getElementsByTagName("CODE").item(0).getTextContent());
                    currency.setRate(Double.valueOf(eElement
                            .getElementsByTagName("RATE").item(0).getTextContent()));
                    currency.setRatio(Integer.parseInt(eElement
                            .getElementsByTagName("RATIO").item(0).getTextContent()));
                    currencyList.add(currency);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return currencyList;
    }
}
