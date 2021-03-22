import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CentroSportivo } from '../model/centro-sportivo';
import { Sport } from '../model/sport';

@Component({
  selector: 'app-lista-centri',
  templateUrl: './lista-centri.component.html',
  styleUrls: ['./lista-centri.component.css']
})
export class ListaCentriComponent implements OnInit {

  centri: CentroSportivo[];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<CentroSportivo[]>("http://localhost:8080/api/centri-sportivi").subscribe((centri) => {
      this.centri = centri;
    })
  }

}
