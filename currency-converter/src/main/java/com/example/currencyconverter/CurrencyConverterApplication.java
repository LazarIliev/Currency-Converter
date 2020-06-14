package com.example.currencyconverter;

import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.currencyconverter.dao")
@EntityScan("com.example.currencyconverter.domain")
public class CurrencyConverterApplication implements CommandLineRunner {
	@Autowired
	CurrencyService currencyService;
//packages to add??: constants - constant defined class,
//					 config
//					 validation,model?
//					 exceptions
	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

	@Override
	public void run(String... args) {
		currencyService.loadCurrencyDataFromBNB();
	}
}
