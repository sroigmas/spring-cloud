package com.github.sroigmas.currency.exchange.service.controller;

import com.github.sroigmas.currency.exchange.service.dto.CurrencyExchangeDto;
import com.github.sroigmas.currency.exchange.service.mapper.CurrencyExchangeMapper;
import com.github.sroigmas.currency.exchange.service.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

  private final Environment environment;

  private final CurrencyExchangeRepository repository;

  private final CurrencyExchangeMapper mapper;

  @GetMapping("/from/{fromCcy}/to/{toCcy}")
  public CurrencyExchangeDto getExchange(@PathVariable String fromCcy, @PathVariable String toCcy) {
    CurrencyExchangeDto currencyExchange = repository
        .findByFromAndAndTo(fromCcy, toCcy).map(mapper::entityToDto)
        .orElseThrow(() -> new RuntimeException(
            String.format("Exchange data not found for %s to %s", fromCcy, toCcy)));
    currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
    return currencyExchange;
  }
}
