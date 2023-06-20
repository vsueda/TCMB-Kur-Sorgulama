package com.example.kurTCMB.service;

import com.example.kurTCMB.Model.Currency;
import com.example.kurTCMB.Model.CurrencyData;
import com.example.kurTCMB.dto.CurrencyDTO;
import com.example.kurTCMB.dto.mapper.CurrencyMapper;
import com.example.kurTCMB.exception.BadRequestException;
import com.example.kurTCMB.exception.ResourceNotFoundException;
import com.example.kurTCMB.exception.message.ErrorMessage;
import com.example.kurTCMB.parameter.CurrencyDateParameter;
import com.example.kurTCMB.repository.CurrencyDataRepository;
import com.example.kurTCMB.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class CurrencyService {

    @Autowired
    private RestTemplate restTemplate;

    private CurrencyDataRepository currencyDataRepository;

    private CurrencyRepository currencyRepository;

    private CurrencyMapper currencyMapper;

    public static Object xmlToObject(String xml, Class<?> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new IllegalArgumentException("Error while converting xml to object", e);
        }
    }

    public String createRequestURL(CurrencyDateParameter dateParameter) {
        return "https://www.tcmb.gov.tr/kurlar/" + dateParameter.getYearMonthFormat() + "/" + dateParameter.getFullDateFormat() + ".xml";
    }

    public CurrencyData getTCMBCurrencies(CurrencyDateParameter dateParameter) {
        String requestURL = createRequestURL(dateParameter);
        try{
            ResponseEntity<String> response = restTemplate.getForEntity(requestURL, String.class);
            String xmlData = response.getBody();
            String decodedXmlData = new String(xmlData.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            return (CurrencyData) xmlToObject(decodedXmlData, CurrencyData.class);
        } catch (Exception e){
            tarihKontrol(dateParameter.getFullDate());
            return null;
        }
    }

    private void tarihKontrol(String fullDate) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            if (LocalDate.parse(fullDate, formatter).isAfter(LocalDate.now())){
            throw new BadRequestException(ErrorMessage.FUTURE_DATED_WITH_NO_QURRENCY_DATA_REQUEST);
            } else {
            throw new ResourceNotFoundException(ErrorMessage.OLD_DATED_WITH_NO_QURRENCY_DATA_REQUEST);
            }
    }

    public Iterable<CurrencyDTO> getModel(CurrencyDateParameter dateParameter) {
        CurrencyData currencyData = currencyDataRepository.getCurrencyDatabyDate(dateParameter.getFullDate());
        if (currencyData != null) {
            return getCurrenciesbyCurrencyData(currencyData.getId());
        } else {
            currencyData = getTCMBCurrencies(dateParameter);
            saveAllData(currencyData);
            currencyData = currencyDataRepository.getCurrencyDatabyDate(dateParameter.getFullDate());
            return getCurrenciesbyCurrencyData(currencyData.getId());
        }
    }

    private Iterable<CurrencyDTO> getCurrenciesbyCurrencyData(Long currencyDataId){
        Iterable<Currency> currencies = currencyRepository.getCurrenciesbyCurrencyData(currencyDataId);
        return currencyMapper.map(currencies);
    }


    private void saveAllData(CurrencyData currencyData) {
        currencyDataRepository.save(currencyData);
        for (Currency currency : currencyData.getCurrencies()) {
            currency.setCurrencyData(currencyData);
            currencyRepository.save(currency);
        }
    }

    public Iterable<CurrencyDTO> getCrossCurrencies(Long currencyDataId) {
        Iterable<Currency> currencies = currencyRepository.getCrossCurrencies(currencyDataId, "0");
        return currencyMapper.map(currencies);
    }

}
