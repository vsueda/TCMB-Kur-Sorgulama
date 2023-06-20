import {Component, OnInit} from '@angular/core';
import {Currency} from "../model/currency.model";
import {CurrencyService} from "../service/currency.service";
import { format } from 'date-fns';
import {CurrencyDateParameter} from "../parameter/currencydateparameter.model";
import {MessageService} from "primeng/api";
import {DatePipe} from "@angular/common";


@Component({
  selector: 'app-kur-sorgulama',
  templateUrl: './kur-sorgulama.component.html',
  styleUrls: ['./kur-sorgulama.component.css']
})
export class KurSorgulamaComponent implements OnInit {
  currencyDate: Date;
  currencyList: Currency[] = [];

  currencyCrossList: Currency[] = [];
  searchValue: string;
  selectedCurrency = new Currency();
  convertedCurrency = new Currency();
  selectedCurrencyValue: number;
  convertedCurrencyValue: number;
  isSuccesed: boolean = false;

  constructor(private currencyService: CurrencyService,
              private messageService: MessageService,
              public datePipe: DatePipe) {
  }

  ngOnInit(): void {

  }


  listCurrency() {
    if (this.currencyDate != null){
      this.clear();
      const dateParameter = new CurrencyDateParameter();
      dateParameter.fullDateFormat = format(this.currencyDate, 'ddMMyyyy');
      dateParameter.yearMonthFormat = format(this.currencyDate, 'yyyyMM');
      dateParameter.fullDate = format(this.currencyDate, 'MM/dd/yyyy');
      this.currencyService.getAllCurrencies(dateParameter).pipe().subscribe(data => {
        this.isSuccesed = false;
        this.currencyList = data;
        this.currencyService.getCrossCurrencies(data[0].currencyData.id).pipe().subscribe(item => {
          this.currencyCrossList = item;
        });
      },
        error => {
          console.log(error)
        this.messageService.add({ severity: 'error', summary: 'Hata', detail: error.error.message});
        this.isSuccesed = true;
        this.currencyList = null;
        this.currencyCrossList = null;
        });
    } else{
      this.isSuccesed = false;
    }
  }

  calculate() {
  if (this.selectedCurrency != null && this.selectedCurrencyValue != null){
    if (this.selectedCurrency.banknoteSelling != null){
      this.convertedCurrencyValue = this.selectedCurrencyValue * +this.selectedCurrency.banknoteSelling;
    }
  } else {
    this.convertedCurrencyValue = 0;
  }
  }

  clear(){
    this.searchValue = '';
    this.selectedCurrency = new Currency();
    this.convertedCurrency = new Currency();
    this.selectedCurrencyValue = 0;
    this.convertedCurrencyValue = 0;
  }

}
