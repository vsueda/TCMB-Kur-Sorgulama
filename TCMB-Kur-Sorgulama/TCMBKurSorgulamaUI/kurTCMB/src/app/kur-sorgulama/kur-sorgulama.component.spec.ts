import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KurSorgulamaComponent } from './kur-sorgulama.component';

describe('KurSorgulamaComponent', () => {
  let component: KurSorgulamaComponent;
  let fixture: ComponentFixture<KurSorgulamaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KurSorgulamaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KurSorgulamaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
