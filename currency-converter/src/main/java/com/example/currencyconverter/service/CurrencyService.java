package com.example.currencyconverter.service;

import com.example.currencyconverter.models.Currency;
import com.example.currencyconverter.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

   public void addCurrency(Currency currency){
       currencyRepository.save(currency);
   }

    public List<Currency> getParsedCurrencies(){
        getCurrenciesFromBNB();

        List<Currency> currencyList = new ArrayList<>();
        File file = new File("src/main/resources/currenciesData.txt");
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
                    Currency currency = new Currency();//CODE, NAME_, REVERSERATE, RATE to add RATIO
                    currency.setName(eElement
                            .getElementsByTagName("NAME_").item(0).getTextContent());
                    currency.setCode(eElement
                            .getElementsByTagName("CODE").item(0).getTextContent());
                    currency.setReverse_rate(Double.valueOf(eElement
                            .getElementsByTagName("REVERSERATE").item(0).getTextContent()));
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


    private List<Currency> getCurrenciesFromBNB(){
        String FILE_URL = "http://bnb.bg/Statistics/StExternalSector/StExchangeRates/StERForeignCurrencies/index.htm?download=xml&search=&lang=EN";

        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/currenciesData.txt")){
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1){
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
