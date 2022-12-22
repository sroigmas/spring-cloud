package com.github.sroigmas.currency.exchange.service.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyExchangeDto {

  private Long id;

  private String from;

  private String to;

  private BigDecimal conversionMultiple;

  private String environment;
}
