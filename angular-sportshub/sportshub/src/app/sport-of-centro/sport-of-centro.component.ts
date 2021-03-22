import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { CentroSportivo } from '../model/centro-sportivo';
import { Sport } from '../model/sport';

@Component({
  selector: 'app-sport-of-centro',
  templateUrl: './sport-of-centro.component.html',
  styleUrls: ['./sport-of-centro.component.css']
})
export class SportOfCentroComponent implements OnInit {

  @Input() inputCentro: CentroSportivo;
  sports: Sport[];

  constructor(private http: HttpClient) {
    this.sports = [];
  }

  ngOnInit(): void {
    this.http.get<Sport[]>("http://localhost:8080/api/centri-sportivi/" + this.inputCentro.email + "/sports").subscribe((sports) => {
      for(let s of sports) {
        let isThere: boolean = false;
        for(let i of this.sports) {
          if(i.idSport == s.idSport) {
            isThere = true;
          }
        }
        if (!isThere) {
          this.sports.push(s);
        }
      }
    })
  }

}
