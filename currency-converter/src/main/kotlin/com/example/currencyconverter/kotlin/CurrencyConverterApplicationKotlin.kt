package com.example.currencyconverter.kotlin

import com.example.currencyconverter.service.CurrencyConvertService
import com.example.currencyconverter.service.CurrencyService
import org.modelmapper.ModelMapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.example.currencyconverter.dao")
@EntityScan("com.example.currencyconverter.domain")
class CurrencyConverterApplicationKotlin {

    @Bean
    fun modelMapper() : ModelMapper {
        return ModelMapper()
    }

    @Bean
    fun currencyConvertService() : CurrencyConvertService {
        return CurrencyConvertService()
    }

    @Bean
    fun currencyService() : CurrencyService{
        return CurrencyService()
    }
}

fun main (args: Array<String>){
    //SpringApplication.run(CurrencyConverterApplicationKotlin::class.java, *args)
    runApplication<CurrencyConverterApplicationKotlin>(*args)
}