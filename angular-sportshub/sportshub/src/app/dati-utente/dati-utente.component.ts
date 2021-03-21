import { Component, OnInit } from '@angular/core';
import { Giocatore } from '../model/giocatore';
import { SharedUtenteService } from '../shared-utente.service';

@Component({
  selector: 'app-dati-utente',
  templateUrl: './dati-utente.component.html',
  styleUrls: ['./dati-utente.component.css']
})
export class DatiUtenteComponent implements OnInit {

  utenteLoggato: Giocatore;

  constructor(private sharedUtente: SharedUtenteService) {
    this.utenteLoggato = this.sharedUtente.utenteLoggato;
  }

  ngOnInit(): void {
  }

}
