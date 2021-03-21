import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrazioneComponent } from './registrazione/registrazione.component';
import { DatiUtenteComponent } from './dati-utente/dati-utente.component';
import { HomeComponent } from './home/home.component';
import { CambioDatiComponent } from './cambio-dati/cambio-dati.component';
import { CambioPwdComponent } from './cambio-pwd/cambio-pwd.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registrazione', component: RegistrazioneComponent},
  {path: 'dati-utente', component: DatiUtenteComponent},
  {path: 'modifica-dati', component: CambioDatiComponent},
  {path: 'modifica-pwd', component: CambioPwdComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
