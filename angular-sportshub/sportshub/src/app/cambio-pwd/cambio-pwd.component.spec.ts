import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CambioPwdComponent } from './cambio-pwd.component';

describe('CambioPwdComponent', () => {
  let component: CambioPwdComponent;
  let fixture: ComponentFixture<CambioPwdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CambioPwdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CambioPwdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
