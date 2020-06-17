package com.example.currencyconverter.dao;

import com.example.currencyconverter.domain.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Currency} repository extending the spring {@link CrudRepository} to get data from db
 */
@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {
}
