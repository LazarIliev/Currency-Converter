package com.example.currencyconverter.kotlin.api

import com.example.currencyconverter.domain.Currency
import com.example.currencyconverter.dto.CurrencyDto
import com.example.currencyconverter.service.CurrencyConvertService
import com.example.currencyconverter.service.CurrencyService
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.constraints.NotEmpty

@RestController
@CrossOrigin("*")
class CurrencyResource(private val currencyConvertService : CurrencyConvertService,
private val currencyService : CurrencyService, private  val modelMapper: ModelMapper) {

    @GetMapping("api/convert")
    fun convert (@RequestParam @NotEmpty codeFrom: String, @RequestParam @NotEmpty codeTo: String,
                 @RequestParam amount: Double): ResponseEntity<String> {
        if (amount <= 0 || codeFrom == codeTo){
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val currencyFrom: Optional<Currency> = currencyService.getByCode(codeFrom)
        val currencyTo: Optional<Currency> = currencyService.getByCode(codeTo)
        if (currencyFrom.isEmpty || currencyTo.isEmpty){
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        return ResponseEntity(currencyConvertService.convertCurrency(currencyFrom.get(), currencyTo.get(), amount), HttpStatus.OK)
    }

    @GetMapping("api/currencies")
    fun getAllCurrencies() : Iterable<Currency> {
        return currencyService.allCurrencies
    }

    @PostMapping("api/add")
    fun addCurrency(@RequestBody currencyDto: CurrencyDto): ResponseEntity<String> {
        val currency: Currency = convertToEntity(currencyDto)
        currencyService.addCurrency(currency)
        return ResponseEntity.ok("Currency added.")
    }

    @DeleteMapping("api/currency/{code}")
    fun deleteCurrency (@PathVariable code: String) : ResponseEntity<String>{
        currencyService.delete(code)
        return ResponseEntity.ok("Currency deleted.")
    }

    private fun convertToEntity(currencyDto: CurrencyDto) : Currency{
        return modelMapper.map(currencyDto, Currency::class.java)
    }
}