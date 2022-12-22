package com.github.sroigmas.currency.exchange.service.mapper;

import com.github.sroigmas.currency.exchange.service.dto.CurrencyExchangeDto;
import com.github.sroigmas.currency.exchange.service.entity.CurrencyExchangeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyExchangeMapper {

  CurrencyExchangeDto entityToDto(CurrencyExchangeEntity entity);

  CurrencyExchangeEntity dtoToEntity(CurrencyExchangeDto dto);
}
