import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { SobreNosComponent } from './sobreNos/sobreNos.component';
import { ContatoComponent } from './contato/contato.component';
import { LoginCadastroComponent } from './loginCadastro/loginCadastro.component';
import { ParallaxComponent } from './parallax/parallax.component';

import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { CarouselComponent } from './carousel/carousel.component';
import { Parallax2Component } from './parallax2/parallax2.component';
import { CooperativaComponent } from './usuario/cooperativa/cooperativa.component';
import { ClienteComponent } from './usuario/cliente/cliente.component';
import { EmpresaComponent } from './usuario/empresa/empresa.component';
import { VoucherComponent } from './usuario/empresa/voucher/voucher.component';


@NgModule({
  declarations: [				
    AppComponent,
    MenuComponent,
    RodapeComponent,
    SobreNosComponent,
    ContatoComponent,
    LoginCadastroComponent,
    ParallaxComponent,
    CarouselComponent,
    Parallax2Component,
    CooperativaComponent,
    ClienteComponent,
    EmpresaComponent,
    VoucherComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{
    provide: LocationStrategy,
    useClass: HashLocationStrategy
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
