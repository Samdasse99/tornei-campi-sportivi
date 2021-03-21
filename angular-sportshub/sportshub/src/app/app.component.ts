import { Component } from '@angular/core';
import { SharedUtenteService } from './shared-utente.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'sportshub';

  constructor(private sharedUtente: SharedUtenteService) {}

}


