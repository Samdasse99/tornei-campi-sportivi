import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Giocatore } from '../model/giocatore';
import { SharedUtenteService } from '../shared-utente.service';

@Component({
  selector: 'app-cambio-dati',
  templateUrl: './cambio-dati.component.html',
  styleUrls: ['./cambio-dati.component.css']
})
export class CambioDatiComponent implements OnInit {

  utenteLoggato: Giocatore;

  constructor(
    private sharedUtente: SharedUtenteService,
    private http: HttpClient,
    private router: Router) {
      this.utenteLoggato = this.sharedUtente.utenteLoggato;
    }

  ngOnInit(): void {
  }

  modifica(nome: string, cognome: string, telefono: string, indirizzo: string, citta: string) {
    let updatedGiocatore = new Giocatore;
    updatedGiocatore.nome = nome;
    updatedGiocatore.cognome = cognome;
    updatedGiocatore.numeroTelefono = telefono;
    updatedGiocatore.indirizzo = indirizzo;
    updatedGiocatore.citta = citta;
    updatedGiocatore.password = this.utenteLoggato.password;

    this.http.put<Giocatore>('http://localhost:8080/api/giocatori/' + this.utenteLoggato.email, updatedGiocatore)
      .subscribe((giocatore) => {
        this.sharedUtente.utenteLoggato = giocatore;
        this.router.navigate(['dati-utente']);
      })
  }
}
