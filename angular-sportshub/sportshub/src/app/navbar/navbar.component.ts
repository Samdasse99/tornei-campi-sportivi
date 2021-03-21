import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';
import { Giocatore } from '../model/giocatore';
import { SharedUtenteService } from '../shared-utente.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  utenteLoggato : Giocatore;

  constructor(private sharedUtente: SharedUtenteService) {
    this.utenteLoggato = this.sharedUtente.utenteLoggato;
  }

  ngOnInit(): void {
  }

}
