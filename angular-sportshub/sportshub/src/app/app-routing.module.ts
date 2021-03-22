import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrazioneComponent } from './registrazione/registrazione.component';
import { DatiUtenteComponent } from './dati-utente/dati-utente.component';
import { HomeComponent } from './home/home.component';
import { CambioDatiComponent } from './cambio-dati/cambio-dati.component';
import { CambioPwdComponent } from './cambio-pwd/cambio-pwd.component';
import { ListaCentriComponent } from './lista-centri/lista-centri.component';
import { ListaCampiComponent } from './lista-campi/lista-campi.component';
import { PrenotaComponent } from './prenota/prenota.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registrazione', component: RegistrazioneComponent},
  {path: 'dati-utente', component: DatiUtenteComponent},
  {path: 'modifica-dati', component: CambioDatiComponent},
  {path: 'modifica-pwd', component: CambioPwdComponent},
  {path: 'lista-centri', component: ListaCentriComponent},
  {path: 'lista-campi/:emailCentro', component: ListaCampiComponent},
  {path: 'prenota/:idCampo', component: PrenotaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
