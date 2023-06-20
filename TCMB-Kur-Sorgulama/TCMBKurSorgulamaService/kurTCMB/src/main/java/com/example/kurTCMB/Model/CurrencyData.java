package com.example.kurTCMB.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name ="Tarih_Date")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlAttribute(name = "Tarih")
    private String tarih;

    @XmlAttribute(name = "Date")
    private String date;

    @XmlAttribute(name = "Bulten_No")
    private String bultenNo;

    @XmlElement(name = "Currency")
    @OneToMany(mappedBy = "currencyData")
    @JsonManagedReference
    private List<Currency> currencies;

}
