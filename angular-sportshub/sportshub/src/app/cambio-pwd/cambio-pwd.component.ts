import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Giocatore } from '../model/giocatore';
import { SharedUtenteService } from '../shared-utente.service';

@Component({
  selector: 'app-cambio-pwd',
  templateUrl: './cambio-pwd.component.html',
  styleUrls: ['./cambio-pwd.component.css']
})
export class CambioPwdComponent implements OnInit {

  utenteLoggato: Giocatore;
  vecchiaStyle: string;
  nuovaStyle: string;

  constructor(
    private sharedUtente: SharedUtenteService,
    private http: HttpClient,
    private router: Router) {
      this.utenteLoggato = this.sharedUtente.utenteLoggato;
      this.vecchiaStyle = 'default';
      this.nuovaStyle = 'default'
    }

  ngOnInit(): void {
  }

  modifica(vecchia: string, nuova: string, nuova2: string) {
    let updatedGiocatore: Giocatore = this.utenteLoggato;

    this.vecchiaStyle = 'default';
    this.nuovaStyle = 'default';

    if (vecchia != this.utenteLoggato.password) {
      this.vecchiaStyle = 'wrong';
    } else if (nuova != nuova2) {
      this.nuovaStyle = 'wrong';
    } else {
      updatedGiocatore.password = nuova;
      this.http.put<Giocatore>('http://localhost:8080/api/giocatori/' + this.utenteLoggato.email, updatedGiocatore)
      .subscribe((giocatore) => {
        this.sharedUtente.utenteLoggato = giocatore;
        this.router.navigate(['dati-utente']);
      })
    }
  }
}
