import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoSlotComponent } from './info-slot.component';

describe('InfoSlotComponent', () => {
  let component: InfoSlotComponent;
  let fixture: ComponentFixture<InfoSlotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoSlotComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoSlotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
