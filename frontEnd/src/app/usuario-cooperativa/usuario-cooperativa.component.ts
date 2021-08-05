import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/Usuario';

@Component({
  selector: 'app-usuario-cooperativa',
  templateUrl: './usuario-cooperativa.component.html',
  styleUrls: ['./usuario-cooperativa.component.css']
})
export class UsuarioCooperativaComponent implements OnInit {

  cliente: Usuario = new Usuario()
  
  constructor() { }

  ngOnInit(): void {
  }

}
