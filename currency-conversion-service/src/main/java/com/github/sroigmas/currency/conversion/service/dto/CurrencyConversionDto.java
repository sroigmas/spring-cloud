package com.github.sroigmas.currency.conversion.service.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyConversionDto {

  private Long id;

  private String from;

  private String to;

  private BigDecimal conversionMultiple;

  private BigDecimal amount;

  private BigDecimal convertedAmount;

  private String environment;
}
