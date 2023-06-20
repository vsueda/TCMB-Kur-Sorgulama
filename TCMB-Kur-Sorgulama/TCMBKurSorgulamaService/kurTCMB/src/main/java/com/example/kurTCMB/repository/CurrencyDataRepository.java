package com.example.kurTCMB.repository;

import com.example.kurTCMB.Model.Currency;
import com.example.kurTCMB.Model.CurrencyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyDataRepository extends JpaRepository<CurrencyData, Long> {

    @Query(value = "select t from CurrencyData t where t.date = :currencyDate")
    CurrencyData getCurrencyDatabyDate(String currencyDate);

}
