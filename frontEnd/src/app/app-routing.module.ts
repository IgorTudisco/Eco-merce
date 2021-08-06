import { ContatoComponent } from './contato/contato.component';
import { SobreNosComponent } from './sobreNos/sobreNos.component';
import { RodapeComponent } from './rodape/rodape.component';
import { MenuComponent } from './menu/menu.component';
import { LoginCadastroComponent } from './loginCadastro/loginCadastro.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioEmpresaComponent } from './usuario-empresa/usuario-empresa.component';
import { UsuarioClienteComponent } from './usuario-cliente/usuario-cliente.component';
import { UsuarioCooperativaComponent } from './usuario-cooperativa/usuario-cooperativa.component';
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
  component: UsuarioEmpresaComponent
},
{
  path: 'cooperativa',
  component: UsuarioCooperativaComponent
},
{
  path: 'cliente',
  component: UsuarioClienteComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
