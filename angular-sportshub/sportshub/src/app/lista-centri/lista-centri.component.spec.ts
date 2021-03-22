import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCentriComponent } from './lista-centri.component';

describe('ListaCentriComponent', () => {
  let component: ListaCentriComponent;
  let fixture: ComponentFixture<ListaCentriComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaCentriComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaCentriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
