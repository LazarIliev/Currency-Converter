package com.example.currencyconverter.validation;


import com.example.currencyconverter.domain.Currency;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class CurrencyValidator  {
    private final Validator validator;

    public CurrencyValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public Set<ConstraintViolation<Currency>> validate(Currency object) {
        return validator.validate(object);
    }
}
