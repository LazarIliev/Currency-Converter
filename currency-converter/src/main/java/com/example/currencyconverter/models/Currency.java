package com.example.currencyconverter.models;

import javax.persistence.*;

@Entity(name = "currencies")
public class Currency {

    @Id
    @Column(name = "code")
    private String code;
    private String name;
    private Double reverse_rate;
    private Double rate;


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getReverse_rate() {
        return reverse_rate;
    }

    public void setReverse_rate(Double reverse_rate) {
        this.reverse_rate = reverse_rate;
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
