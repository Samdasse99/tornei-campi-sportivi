import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrenotaComponent } from './prenota.component';

describe('PrenotaComponent', () => {
  let component: PrenotaComponent;
  let fixture: ComponentFixture<PrenotaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrenotaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrenotaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
