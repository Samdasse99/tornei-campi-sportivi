import { Sport } from "./sport";
import { Superficie } from "./superficie";

export class Campo {
  idCampo: number;
  nomeCampo: string;
  coperto: boolean;
  spogliatoi: boolean;
  superficie: Superficie;
  sports: Sport[];
}
