import { ContatoComponent } from './contato/contato.component';
import { SobreNosComponent } from './sobreNos/sobreNos.component';
import { RodapeComponent } from './rodape/rodape.component';
import { MenuComponent } from './menu/menu.component';
import { LoginCadastroComponent } from './loginCadastro/loginCadastro.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpresaComponent } from './usuario/empresa/empresa.component';
import { CooperativaComponent } from './usuario/cooperativa/cooperativa.component';
import { ClienteComponent } from './usuario/cliente/cliente.component';
const routes: Routes = [
{
  path:'',
  redirectTo:'home',
  pathMatch:'full'
},
{
  path:'home',
 component: LoginCadastroComponent
},
{
  path:'menu',
 component: MenuComponent
},
{
  path:'rodape',
 component: RodapeComponent
},
{
  path:'sobreNos',
 component: SobreNosComponent
},
{
  path:'contato',
 component: ContatoComponent
},
{
  path: 'empresa',
  component: EmpresaComponent
},
{
  path: 'cooperativa',
  component: CooperativaComponent
},
{
  path: 'cliente',
  component: ClienteComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
