package com.example.kurTCMB.dto.mapper;

import com.example.kurTCMB.Model.Currency;
import com.example.kurTCMB.dto.CurrencyDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    Iterable<CurrencyDTO> map(Iterable<Currency> currencies);

}
