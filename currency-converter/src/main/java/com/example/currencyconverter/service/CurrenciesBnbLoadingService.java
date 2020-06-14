package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrenciesBnbLoadingService {

    @Autowired
    CurrenciesFromBnbToTxtFile currenciesFromBnbToTxtFile;

    @Autowired
    CurrenciesFromTxtFile currenciesFromTxtFile;

    public List<Currency> getCurrencies() {
       // getCurrenciesFromBNB();
        currenciesFromBnbToTxtFile.write();

        List<Currency> currencyList = currenciesFromTxtFile.getCurrencies();
//                = new ArrayList<>();
//        File file = new File("src/main/resources/currenciesData.txt");
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(file);
//            doc.getDocumentElement().normalize();
//            NodeList nList = doc.getElementsByTagName("ROW");
//            //skip first and last
//            for (int temp = 1; temp < nList.getLength() - 1; temp++) {
//                Node nNode = nList.item(temp);
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) nNode;
//                    Currency currency = new Currency();
//                    currency.setName(eElement
//                            .getElementsByTagName("NAME_").item(0).getTextContent());
//                    currency.setCode(eElement
//                            .getElementsByTagName("CODE").item(0).getTextContent());
//                    currency.setRate(Double.valueOf(eElement
//                            .getElementsByTagName("RATE").item(0).getTextContent()));
//                    currency.setRatio(Integer.parseInt(eElement
//                            .getElementsByTagName("RATIO").item(0).getTextContent()));
//                    currencyList.add(currency);
//                }
//            }
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            e.printStackTrace();
//        }
        return currencyList;
    }

//    private void getCurrenciesFromBNB(){
//        String FILE_URL = "http://bnb.bg/Statistics/StExternalSector/StExchangeRates/StERForeignCurrencies/index.htm?download=xml&search=&lang=EN";
//
//        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
//             FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/currenciesData.txt")){
//            byte[] dataBuffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1){
//                fileOutputStream.write(dataBuffer, 0, bytesRead);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
