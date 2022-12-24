package com.github.sroigmas.currency.conversion.service.controller;

import com.github.sroigmas.currency.conversion.service.dto.CurrencyConversionDto;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currency-conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {

  @GetMapping("/from/{fromCcy}/to/{toCcy}/amount/{amount}")
  public CurrencyConversionDto calculateCurrencyConversion(@PathVariable String fromCcy,
      @PathVariable String toCcy, @PathVariable BigDecimal amount) {
    CurrencyConversionDto currencyConversion = new RestTemplate()
        .getForEntity("http://localhost:8000/currency-exchange/from/{fromCcy}/to/{toCcy}",
            CurrencyConversionDto.class, fromCcy, toCcy).getBody();
    currencyConversion.setConvertedAmount(
        amount.multiply(currencyConversion.getConversionMultiple()));
    return currencyConversion;
  }
}
