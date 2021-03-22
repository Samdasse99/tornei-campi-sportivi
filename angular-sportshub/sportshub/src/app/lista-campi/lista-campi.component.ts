import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Campo } from '../model/campo';
import { CentroSportivo } from '../model/centro-sportivo';

@Component({
  selector: 'app-lista-campi',
  templateUrl: './lista-campi.component.html',
  styleUrls: ['./lista-campi.component.css']
})
export class ListaCampiComponent implements OnInit {

  centro: CentroSportivo;
  campi: Campo[];

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const centroEmailFromRoute = String(routeParams.get('emailCentro'));
    this.http.get<CentroSportivo>("http://localhost:8080/api/centri-sportivi/" + centroEmailFromRoute).subscribe((centro) => {
      this.centro = centro;
    })

    this.http.get<Campo[]>("http://localhost:8080/api/centri-sportivi/" + centroEmailFromRoute + "/campi").subscribe((campi) => {
      this.campi = campi;
    })
  }

}
