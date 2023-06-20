import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Currency} from "../model/currency.model";
import {CurrencyDateParameter} from "../parameter/currencydateparameter.model";

@Injectable({
  providedIn: 'root'
})
export class CurrencyService {
  private baseUrl = 'http://localhost:8084/';

  constructor(private http: HttpClient) { }

  getEntityName() {
    return 'Currency';
  }

  // getAllCurrencies() {
  //   return this.http.get(`${this.baseUrl}`);
  // }
  //
  // getCurrencyById(id: string) {
  //   return this.http.get(`${this.baseUrl}/${id}`);
  // }
  //
  // createCurrency(currency: any) {
  //   return this.http.post(`${this.baseUrl}`, currency);
  // }
  //
  // updateCurrency(id: string, currency: any) {
  //   return this.http.put(`${this.baseUrl}/${id}`, currency);
  // }
  //
  // deleteCurrency(id: string) {
  //   return this.http.delete(`${this.baseUrl}/${id}`);
  // }

  getAllCurrencies(dateParameter: CurrencyDateParameter) {
    return this.http.post<Currency[]>(this.baseUrl + this.getEntityName() + '/getCurrencyData' , dateParameter);
  }

  getCrossCurrencies(currencyDataId: number) {
    return this.http.post<Currency[]>(this.baseUrl + this.getEntityName() + '/getCrossCurrencies' , currencyDataId);
  }
}
