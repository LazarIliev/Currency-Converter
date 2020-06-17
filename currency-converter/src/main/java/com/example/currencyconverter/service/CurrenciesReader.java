package com.example.currencyconverter.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.example.currencyconverter.constants.CurrencyConverterAppConstants.XML_FILE_URL_FROM_BNB_CURRENCIES;

@Service
public class CurrenciesReader {

    public Document readExternalStreamAsDocument(){
        Document doc = null;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try(InputStream urlBNBStream = new URL(XML_FILE_URL_FROM_BNB_CURRENCIES).openStream()){
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(urlBNBStream);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
