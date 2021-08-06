import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { CooperativaService } from '../service/cooperativa.service';

@Component({
  selector: 'app-usuario-cooperativa',
  templateUrl: './usuario-cooperativa.component.html',
  styleUrls: ['./usuario-cooperativa.component.css']
})
export class UsuarioCooperativaComponent implements OnInit {
  cliente: Usuario;

  listaUsuario: Usuario[]

  constructor(private cooperativaService: CooperativaService) {}

  ngOnInit() {}

  
 
}
