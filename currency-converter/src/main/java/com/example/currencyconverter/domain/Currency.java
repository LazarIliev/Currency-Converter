package com.example.currencyconverter.domain;

import javax.persistence.*;

@Entity(name = "currencies")
public class Currency {

    @Id
    @Column
    private String code;
    private String name;
    private Double rate;
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
