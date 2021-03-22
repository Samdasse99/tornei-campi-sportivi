import { Giocatore } from "./giocatore";

export class Slot {
  dataOraFine: Date;
  dataOraInizio: Date;
  idSlot: number;
  prezzo: number;
  referente: Giocatore;
  scontoPercent: number;
  scontoRiscattato: boolean;
}
