package com.example.currencyconverter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class CurrenciesReader {
    @Value("${DOWNLOAD_XML_FILE_CURRENCIES_FROM_BNB_URL}")
    private String DOWNLOAD_XML_FILE_CURRENCIES_FROM_BNB_URL;

    public Document readExternalStreamAsDocument(){
        Document doc = null;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try(InputStream urlBNBStream = new URL(DOWNLOAD_XML_FILE_CURRENCIES_FROM_BNB_URL).openStream()){
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(urlBNBStream);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
