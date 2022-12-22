package com.github.sroigmas.currency.exchange.service.repository;

import com.github.sroigmas.currency.exchange.service.entity.CurrencyExchangeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Long> {

  Optional<CurrencyExchangeEntity> findByFromAndAndTo(String from, String to);
}
