package com.example.kurTCMB.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Currency")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Currency {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "currencyDataTarih", nullable = false)
    @JsonBackReference
    private CurrencyData currencyData;

    @XmlAttribute(name = "CrossOrder")
    private String crossOrder;

    @XmlAttribute(name = "Kod")
    private String kod;

    @XmlAttribute(name = "CurrencyCode")
    private String currencyCode;

    @XmlElement(name = "Unit")
    private String unit;

    @XmlElement(name = "Isim")
    private String isim;

    @XmlElement(name = "CurrencyName")
    private String currencyName;

    @XmlElement(name = "ForexBuying")
    private String forexBuying;

    @XmlElement(name = "ForexSelling")
    private String forexSelling;

    @XmlElement(name = "BanknoteBuying")
    private String banknoteBuying;

    @XmlElement(name = "BanknoteSelling")
    private String banknoteSelling;

    @XmlElement(name = "CrossRateUSD")
    private String crossRateUSD;

    @XmlElement(name = "CrossRateOther")
    private String crossRateOther;

}
