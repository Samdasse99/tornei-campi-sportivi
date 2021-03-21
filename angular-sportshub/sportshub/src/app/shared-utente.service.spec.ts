import { TestBed } from '@angular/core/testing';

import { SharedUtenteService } from './shared-utente.service';

describe('SharedUtenteService', () => {
  let service: SharedUtenteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SharedUtenteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
