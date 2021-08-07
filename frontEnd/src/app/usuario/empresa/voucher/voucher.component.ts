import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Voucher } from 'src/app/model/Voucher';
import { EmpresaService } from 'src/app/service/empresa.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-voucher',
  templateUrl: './voucher.component.html',
  styleUrls: ['./voucher.component.css']
})
export class VoucherComponent implements OnInit {

  voucher: Voucher = new Voucher()

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

  atualizarVoucher(voucher: Voucher){

    this.empresaService.putVoucher(voucher).subscribe((resp) => {

      this.voucher = resp

      alert('Voucher atualizado com sucesso!')

    })

  }


}
