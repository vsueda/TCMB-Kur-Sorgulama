package com.example.kurTCMB.dto;

import com.example.kurTCMB.Model.CurrencyData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDTO {


    private CurrencyData currencyData;

    private String crossOrder;

    private String kod;

    private String currencyCode;

    private String unit;

    private String isim;

    private String currencyName;

    private String forexBuying;

    private String forexSelling;

    private String banknoteBuying;

    private String banknoteSelling;

    private String crossRateUSD;

    private String crossRateOther;
}
