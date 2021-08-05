import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { Voucher } from '../model/Voucher';
import { EmpresaService } from '../service/empresa.service';

@Component({
  selector: 'app-usuario-empresa',
  templateUrl: './usuario-empresa.component.html',
  styleUrls: ['./usuario-empresa.component.css']
})
export class UsuarioEmpresaComponent implements OnInit {

  voucher: Voucher
  cliente: Usuario
  empresa: Usuario
  listaVoucher: Voucher[]
  idVoucher: Voucher
  idCliente: Usuario
  idEmpresa: Usuario

  constructor(
    private empresaService: EmpresaService,
    private router: Router,
    private adctivateRoute: ActivatedRoute
  ) { }

  ngOnInit(){
    if(environment.token == ''){
      alert('Sua sessão expirou, faça o login novamente.')
      this.router.navigate(['/entrar'])
    }

   // this.idVoucher = this.adctivateRoute.snapshot.params['idVoucher']

   // this.idCliente = this.adctivateRoute.snapshot.params['idCliente']

   // this.idEmpresa = this.adctivateRoute.snapshot.params['idEmpresa']

    //this.criarVoucher(this.idVoucher, this.idCliente)

    // this.findAllVoucher()
  }



  findAllVoucher(){
    this.empresaService.getAllVoucher().subscribe((resp: Voucher[]) => {
      this.listaVoucher = resp
    })
  }



  criarVoucher(){

    let idE = environment.id

    this.empresaService.postVoucher(idE , this.voucher).subscribe((resp: Voucher) => {
      this.voucher = resp
      alert('Voucher criado com sucesso!')
    })
  }

}
