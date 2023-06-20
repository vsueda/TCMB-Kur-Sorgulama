package com.example.kurTCMB.dto.mapper;

import com.example.kurTCMB.Model.CurrencyData;
import com.example.kurTCMB.dto.CurrencyDataDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyDataMapper {

    CurrencyDataDTO currencytoCurrencyDataDTO(CurrencyData currencyData);
}
