package com.github.sroigmas.currency.conversion.service.feign;

import com.github.sroigmas.currency.conversion.service.dto.CurrencyConversionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeClient {

  @GetMapping("/currency-exchange/from/{fromCcy}/to/{toCcy}")
  CurrencyConversionDto getExchange(
      @PathVariable String fromCcy, @PathVariable String toCcy);
}
