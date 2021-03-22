import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Slot } from '../model/slot';
import { SharedUtenteService } from '../shared-utente.service';

@Component({
  selector: 'app-prenotazioni',
  templateUrl: './prenotazioni.component.html',
  styleUrls: ['./prenotazioni.component.css']
})
export class PrenotazioniComponent implements OnInit {

  slots: Slot[];

  constructor(
    private sharedUtente: SharedUtenteService,
    private http: HttpClient,
    private router: Router
  ) {
    this.slots = [];
  }

  ngOnInit(): void {
    this.http.get<Slot[]>("http://localhost:8080/api/giocatori/" + this.sharedUtente.utenteLoggato.email + "/slots").subscribe((slots) => {
      this.slots = slots;
    })
  }

  annulla(slot: Slot) {
    slot.referente = null;
      this.http.put<Slot>("http://localhost:8080/api/slots/" + slot.idSlot, slot).subscribe((s) => {
        this.router.navigate(['']);
      });
  }

}
