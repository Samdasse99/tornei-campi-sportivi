import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Giocatore } from '../model/giocatore';
import { SharedUtenteService } from '../shared-utente.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private http: HttpClient, private sharedUtente: SharedUtenteService) { }

  ngOnInit(): void {
  }

  logga(email: string, password: string) {
    this.http.get<Giocatore>('http://localhost:8080/api/giocatori/{email}').subscribe((utente) => {
      if (utente.password == password) {
        this.sharedUtente.utenteLoggato = utente;
      }
    });
  }
}
