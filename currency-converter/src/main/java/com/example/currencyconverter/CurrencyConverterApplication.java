package com.example.currencyconverter;

import com.example.currencyconverter.repositories.AdminRepository;
import com.example.currencyconverter.repositories.CurrencyRepository;
import com.example.currencyconverter.models.Currency;
import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

//@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories("com.example.currencyconverter.repositories")
@EntityScan("com.example.currencyconverter.models")
public class CurrencyConverterApplication implements CommandLineRunner {

//	@Autowired
//	DataSource dataSource;//useless?

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	CurrencyRepository currencyRepository;

	@Autowired
	CurrencyService currencyService;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Currency> currencyList = currencyService.getParsedCurrencies();//todo to change the name of the method
		for (Currency currency: currencyList){
			currencyRepository.save(currency);
		}

		//Currency currency = currencyRepository.findById("AUD").get();

		//I will check if admins and currencies are empty
		//System.out.println("Our DataSource is = " + dataSource);
//		Admin admin1 = new Admin();
//		admin1.setName("admin123");
//		admin1.setPassword("12345");
//		adminRepository.save(admin1);
//		Iterable<Admin> systemlist = adminRepository.findAll();
//		for(Admin admin:systemlist){
//			System.out.println("Here is a system: " + admin.getName());
//		}
	}

}
