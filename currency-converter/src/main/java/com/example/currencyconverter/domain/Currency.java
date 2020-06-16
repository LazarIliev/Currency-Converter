package com.example.currencyconverter.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "currencies")
public class Currency {

    @Id
    @Column
    @NotNull
    @Size(min = 3, max = 3, message="Code should be formed from 3 alphabet symbols!")
    private String code;
    @NotNull
    @Size(min = 5, max = 45, message = "Full name should be between 5 and 45 alphabet symbols")
    private String name;
    @NotNull
    private Double rate;
    @NotNull
    @Min(value = 1L, message = "The value must be positive")
    private int ratio;

    public Currency(String code, String name, Double rate, int ratio) {
        this.code = code;
        this.name = name;
        this.rate = rate;
        this.ratio = ratio;
    }

    public Currency() {

    }


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
