import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Giocatore } from '../model/giocatore';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.css']
})
export class RegistrazioneComponent implements OnInit {

  constructor(
    private http: HttpClient,
    ) {
  }

  ngOnInit(): void {
  }

  registra(nome: string, cognome: string, telefono:string,
    indirizzo: string, citta: string, email: string, password:string) {
      let giocatore = new Giocatore();
      giocatore.email = email;
      giocatore.password = password;
      giocatore.nome = nome;
      giocatore.cognome = cognome;
      giocatore.numeroTelefono = telefono;
      giocatore.indirizzo = indirizzo;
      giocatore.citta = citta;

      this.http.post<Giocatore>('http://localhost:8080/api/giocatori', giocatore).subscribe();
  }
}
