package com.example.kurTCMB.repository;


import com.example.kurTCMB.Model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Query(value = "select t from Currency t where t.currencyData.id = :id")
    Iterable<Currency> getCurrenciesbyCurrencyData(Long id);

    @Query(value = "select t from Currency t where t.currencyData.id = :id and t.crossOrder != :crossOrder ")
    Iterable<Currency> getCrossCurrencies(Long id, String crossOrder);
}
