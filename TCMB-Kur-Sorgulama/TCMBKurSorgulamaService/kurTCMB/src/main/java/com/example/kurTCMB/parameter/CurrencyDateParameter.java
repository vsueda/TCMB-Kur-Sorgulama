package com.example.kurTCMB.parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDateParameter {
    String fullDateFormat; //ddmmYYYY
    String yearMonthFormat; //MMyyyy
    String fullDate; //mm/dd/yyyy
}
