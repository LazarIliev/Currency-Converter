package com.example.currencyconverter.validation;


import com.example.currencyconverter.domain.Currency;
import com.example.currencyconverter.dto.CurrencyDto;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;

@Service
public class CurrencyValidator  {

    private Validator validator;

    public CurrencyValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    //		Validator validator = factory.getValidator();
    //		Set<ConstraintViolation<CurrencyDto>> violations = validator.validate(currencyDto);
    public Set<ConstraintViolation<CurrencyDto>> validate(CurrencyDto object) {
        return validator.validate(object);
    }

    public Set<ConstraintViolation<Currency>> validate(Currency object) {
        return validator.validate(object);
    }
}
