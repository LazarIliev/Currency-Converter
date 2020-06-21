package com.example.currencyconverter.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class CurrencyDto implements Serializable {
    @NotNull
    @Size(min = 3, max = 3, message="Code should be formed from 3 alphabet symbols!")
    private String code;
    @NotNull
    @Size(min = 5, max = 45, message = "Full name should be between 5 and 45 alphabet symbols")
    private String name;
    @Min(value = 0L, message = "The value must be positive")
    private Double rate;
    @Min(value = 1L, message = "The value must be positive")
    private int ratio;

    @AssertFalse
    public boolean isCodeForbidden (){
        return this.code.equals("XAU");//todo to think about an abstract class
    }
}
