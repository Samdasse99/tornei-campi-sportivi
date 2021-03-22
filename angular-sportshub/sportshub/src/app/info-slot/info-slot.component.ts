import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Campo } from '../model/campo';
import { CentroSportivo } from '../model/centro-sportivo';
import { Slot } from '../model/slot';

@Component({
  selector: 'app-info-slot',
  templateUrl: './info-slot.component.html',
  styleUrls: ['./info-slot.component.css']
})
export class InfoSlotComponent implements OnInit {

  @Input() inputSlot: Slot;
  campo: Campo;
  centro: CentroSportivo;

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get<Campo>("http://localhost:8080/api/slots/" + this.inputSlot.idSlot + "/campo").subscribe((campo) => {
      this.campo = campo;
      this.http.get<CentroSportivo>("http://localhost:8080/api/campi/" + campo.idCampo + "/centro-sportivo").subscribe((centro) => {
        this.centro = centro;
      })
    })
  }

}
