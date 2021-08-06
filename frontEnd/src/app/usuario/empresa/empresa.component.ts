import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Voucher } from 'src/app/model/Voucher';
import { EmpresaService } from 'src/app/service/empresa.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent implements OnInit {

 voucher: Voucher = new Voucher()
 listVoucher: Voucher[]

  constructor(
    private empresaService: EmpresaService,
    private router: Router
  ) { }

  ngOnInit() {    

    // Verificando o token
    
    if(environment.token == ''){

      // alert('Sua seção expirou, faça o login novamente.')
 
       this.router.navigate(['/empresa'])
 
     }
  }

  criarVoucher(){

    this.empresaService.postVoucher(environment.id,this.voucher).subscribe((resp: Voucher) =>{
      
      this.voucher = resp
      
      alert('Voucher criado')

      this.voucher = new Voucher()

    })

  }



}
