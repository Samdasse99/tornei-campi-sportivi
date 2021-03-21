import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CambioDatiComponent } from './cambio-dati.component';

describe('CambioDatiComponent', () => {
  let component: CambioDatiComponent;
  let fixture: ComponentFixture<CambioDatiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CambioDatiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CambioDatiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
