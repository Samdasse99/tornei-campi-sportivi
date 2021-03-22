import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SportOfCentroComponent } from './sport-of-centro.component';

describe('SportOfCentroComponent', () => {
  let component: SportOfCentroComponent;
  let fixture: ComponentFixture<SportOfCentroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SportOfCentroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SportOfCentroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
