import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Campo } from '../model/campo';
import { Slot } from '../model/slot';
import { SharedUtenteService } from '../shared-utente.service';

@Component({
  selector: 'app-prenota',
  templateUrl: './prenota.component.html',
  styleUrls: ['./prenota.component.css']
})
export class PrenotaComponent implements OnInit {

  campo: Campo;
  slots: Slot[];

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private sharedUtente: SharedUtenteService,
    private router: Router
  ) {
    this.slots = [];
  }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const campoIdFromRoute = Number(routeParams.get('idCampo'));
    this.http.get<Campo>("http://localhost:8080/api/campi/" + campoIdFromRoute).subscribe((campo) => {
      this.campo = campo;
    })

    this.http.get<Slot[]>("http://localhost:8080/api/campi/" + campoIdFromRoute + "/slots").subscribe((slots) => {
      for(let s of slots) {
        if(s.referente == null) {
          this.slots.push(s);
        }
      }
    })
  }

  prenota(slot: Slot) {
    if (this.sharedUtente.utenteLoggato != null) {
      slot.referente = this.sharedUtente.utenteLoggato;
      this.http.put<Slot>("http://localhost:8080/api/slots/" + slot.idSlot, slot).subscribe((s) => {
        this.router.navigate(['']);
      });
    } else {
      this.router.navigate(['login']);
    }
  }
}
