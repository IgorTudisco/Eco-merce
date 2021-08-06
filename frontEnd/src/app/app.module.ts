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
    UsuarioEmpresaComponent,
    UsuarioClienteComponent,
    VoucherComponent,
    UsuarioCooperativaComponent
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
