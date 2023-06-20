import {CurrencyData} from "./currencydata.model";

export class Currency {

  id: number;
  currencyData: CurrencyData;
  crossOrder: string;
  kod: string;
  currencyCode: string;
  unit: string;
  isim: string;
  currencyName: string;
  forexBuying: string;
  forexSelling: string;
  banknoteBuying: string;
  banknoteSelling: string;
  crossRateUSD: string;
  crossRateOther: string;

}
