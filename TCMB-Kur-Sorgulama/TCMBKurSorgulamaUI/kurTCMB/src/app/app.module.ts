import {LOCALE_ID, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { KurSorgulamaComponent } from './kur-sorgulama/kur-sorgulama.component';
import {DropdownModule} from "primeng/dropdown";
import {ButtonModule} from "primeng/button";
import {CommonModule, CurrencyPipe, DatePipe} from "@angular/common";
import {TagModule} from "primeng/tag";
import {TableModule} from "primeng/table";
import {RatingModule} from "primeng/rating";
import {PaginatorModule} from "primeng/paginator";
import {CardModule} from "primeng/card";
import {CalendarModule} from "primeng/calendar";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from "@angular/common/http";
import {InputTextModule} from "primeng/inputtext";
import {TooltipModule} from "primeng/tooltip";
import {MessageService, PrimeNGConfig, SharedModule} from "primeng/api";
import {TabViewModule} from "primeng/tabview";
import {AccordionModule} from "primeng/accordion";
import {MessagesModule} from "primeng/messages";
import { registerLocaleData } from '@angular/common';
import localeTr from '@angular/common/locales/tr';

registerLocaleData(localeTr);
@NgModule({
  declarations: [
    AppComponent,
    KurSorgulamaComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    ButtonModule,
    DropdownModule,
    TagModule,
    TableModule,
    RatingModule,
    PaginatorModule,
    CardModule,
    CalendarModule,
    InputTextModule,
    TooltipModule,
    SharedModule,
    TabViewModule,
    AccordionModule,
    MessagesModule,
    CommonModule
  ],
  providers: [CurrencyPipe, MessageService, { provide: LOCALE_ID, useValue: 'tr' }, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(private primeNGConfig: PrimeNGConfig) {
    this.primeNGConfig.setTranslation({
      firstDayOfWeek: 1,
      dayNames: ['Pazar', 'Pazartesi', 'Salı', 'Çarşamba', 'Perşembe', 'Cuma', 'Cumartesi'],
      dayNamesShort: ['Paz', 'Pzt', 'Sal', 'Çar', 'Per', 'Cum', 'Cmt'],
      dayNamesMin: ['Pz', 'Pt', 'Sa', 'Ça', 'Pe', 'Cu', 'Ct'],
      monthNames: [
        'Ocak', 'Şubat', 'Mart', 'Nisan', 'Mayıs', 'Haziran',
        'Temmuz', 'Ağustos', 'Eylül', 'Ekim', 'Kasım', 'Aralık'
      ],
      monthNamesShort: [
        'Oca', 'Şub', 'Mar', 'Nis', 'May', 'Haz',
        'Tem', 'Ağu', 'Eyl', 'Eki', 'Kas', 'Ara'
      ],
      today: 'Bugün',
      clear: 'Temizle',
      weekHeader: 'Hf'
    });
  }

}
