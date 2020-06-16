package com.example.currencyconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.currencyconverter.dao")
@EntityScan("com.example.currencyconverter.domain")
public class CurrencyConverterApplication {
//					 config
//					 validation,model?
//					 exceptions

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}
}
