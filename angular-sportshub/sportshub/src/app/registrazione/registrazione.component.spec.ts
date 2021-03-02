import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrazioneComponent } from './registrazione.component';

describe('RegistrazioneComponent', () => {
  let component: RegistrazioneComponent;
  let fixture: ComponentFixture<RegistrazioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrazioneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
