package com.github.sroigmas.currency.exchange.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "currency_exchange")
@Getter
@Setter
public class CurrencyExchangeEntity {

  @Id
  private Long id;

  @Column(name = "from_ccy")
  private String from;

  @Column(name = "to_ccy")
  private String to;

  private BigDecimal conversionMultiple;

  private String environment;
}
