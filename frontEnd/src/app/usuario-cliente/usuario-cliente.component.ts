import { Component, OnInit } from '@angular/core';
import { Voucher } from '../model/Voucher';
import { Router } from '@angular/router';
import { Usuario } from '../model/Usuario';
import { ClienteService } from '../service/cliente.service';

@Component({
  selector: 'app-usuario-cliente',
  templateUrl: './usuario-cliente.component.html',
  styleUrls: ['./usuario-cliente.component.css']
})
export class UsuarioClienteComponent implements OnInit {

  cliente: Usuario = new Usuario()
  listaVoucher: Voucher[]

  constructor(
    private router: Router,
    private clienteService: ClienteService
  ) { }

  ngOnInit(){
  }

  findAllVoucher(){
    this.clienteService.getAllVoucher().subscribe((resp: Voucher[]) => {
      this.listaVoucher = resp
    })
  }

}
