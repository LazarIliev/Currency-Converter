package com.example.currencyconverter.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
@NoArgsConstructor annotation for generating a constructor with no parameters
*/
@NoArgsConstructor
/*
@AllArgsConstructor annotation for generating a constructor
with 1 parameter for each field
*/
@AllArgsConstructor
@Getter
@Setter
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
}
