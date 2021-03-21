import { Injectable } from '@angular/core';
import { Giocatore } from './model/giocatore';

@Injectable({
  providedIn: 'root'
})

@Injectable()
export class SharedUtenteService {

  utenteLoggato : Giocatore = null;

  constructor() { }
}
