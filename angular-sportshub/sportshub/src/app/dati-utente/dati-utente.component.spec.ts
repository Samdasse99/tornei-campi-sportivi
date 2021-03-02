import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatiUtenteComponent } from './dati-utente.component';

describe('DatiUtenteComponent', () => {
  let component: DatiUtenteComponent;
  let fixture: ComponentFixture<DatiUtenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatiUtenteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DatiUtenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
