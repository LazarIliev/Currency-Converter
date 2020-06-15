package com.example.currencyconverter.service;

import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import static com.example.currencyconverter.constants.CurrencyConverterAppConstants.CURRENCIES_DATA_PATH_FILE;
import static com.example.currencyconverter.constants.CurrencyConverterAppConstants.XML_FILE_URL_FROM_BNB_CURRENCIES;

@Service
public class CurrenciesFromBnbToTxtFile {
    public void write() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(XML_FILE_URL_FROM_BNB_CURRENCIES).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(CURRENCIES_DATA_PATH_FILE)){
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1){
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
