import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SharedUtenteService } from '../shared-utente.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private sharedUtente: SharedUtenteService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  toPrenotazioni() {
    if(this.sharedUtente.utenteLoggato != null) {
      this.router.navigate(['prenotazioni']);
    } else {
      this.router.navigate(['login']);
    }
  }
}
