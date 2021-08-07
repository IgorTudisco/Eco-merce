import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/model/Usuario';
import { Voucher } from 'src/app/model/Voucher';
import { ClienteService } from 'src/app/service/cliente.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  cliente: Usuario = new Usuario()
  listaVoucher: Voucher[]
  voucher: Voucher = new Voucher()  

  constructor(
    private router: Router,
    private clienteService: ClienteService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(){
    this.findAllVoucher()
    let id_voucher: number = this.route.snapshot.params["id"]
    this.adquirirVoucher(environment.id, id_voucher)
    this.findByIdCliente(id_voucher)
  }

  findAllVoucher(){
    this.clienteService.getAllVoucher().subscribe((resp: Voucher[]) => {
      this.listaVoucher = resp
      console.log(JSON.stringify(this.listaVoucher))
    })
  }

  findByIdCliente(id: number){
    this.clienteService.getByidCliente(environment.id).subscribe((resp: Usuario) => {
      this.cliente = resp
    }, err => {
      console.log(`Erro cod: ${err.status}`)
    })
  }

  adquirirVoucher(id_cliente: number, id_voucher: number){
    this.clienteService.putVoucher(id_cliente, id_voucher).subscribe(() => {
      alert('Voucher adquirido!')
    })
  }

  alterarCliente(){
    this.clienteService.putCliente(this.cliente).subscribe((resp: Usuario) => {
      this.cliente = resp
      this.router.navigate(['/cliente'])
    })
  }
}