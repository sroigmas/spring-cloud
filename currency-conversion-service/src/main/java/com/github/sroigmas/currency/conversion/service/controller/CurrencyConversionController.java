package com.github.sroigmas.currency.conversion.service.controller;

import com.github.sroigmas.currency.conversion.service.dto.CurrencyConversionDto;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {

  @GetMapping("/from/{fromCcy}/to/{toCcy}/amount/{amount}")
  public CurrencyConversionDto calculateCurrencyConversion(@PathVariable String fromCcy,
      @PathVariable String toCcy, @PathVariable String amount) {
    return new CurrencyConversionDto(1L, fromCcy, toCcy, new BigDecimal("5.5"),
        new BigDecimal(amount), null, "");
  }
}
