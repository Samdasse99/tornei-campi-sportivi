import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCampiComponent } from './lista-campi.component';

describe('ListaCampiComponent', () => {
  let component: ListaCampiComponent;
  let fixture: ComponentFixture<ListaCampiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaCampiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaCampiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
