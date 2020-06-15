package com.example.currencyconverter.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CurrencyDto implements Serializable {

    @NotNull
    @Size(min = 3, max = 3, message="Code should be formed from 3 alphabet symbols!")
    private String code;
    @NotNull
    @Size(min = 5, max = 45, message = "Full name should be between 5 and 45 alphabet symbols")
    private String name;
   // @Min(value = 0L, message = "The value must be positive")
    private Double rate;
    @Min(value = 1L, message = "The value must be positive")
    private int ratio;


    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
