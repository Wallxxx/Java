package com.bootcamp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class DtoDeposit {
    private String number;
    private BigDecimal value;
}
