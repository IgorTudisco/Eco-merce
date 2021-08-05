import { ContatoComponent } from './contato/contato.component';
import { SobreNosComponent } from './sobreNos/sobreNos.component';
import { RodapeComponent } from './rodape/rodape.component';
import { MenuComponent } from './menu/menu.component';
import { LoginCadastroComponent } from './loginCadastro/loginCadastro.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioEmpresaComponent } from './usuario-empresa/usuario-empresa.component';

const routes: Routes = [
{
  path:'',
  redirectTo:'entrar',
  pathMatch:'full'
},
{
  path:'entrar',
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
  path: 'usuario-empresa/:idVoucher',
  component: UsuarioEmpresaComponent
},
{
  path: 'usuario-cliente/:idCliente',
  component: UsuarioEmpresaComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
