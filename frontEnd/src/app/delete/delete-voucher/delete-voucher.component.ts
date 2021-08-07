import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmpresaService } from 'src/app/service/empresa.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-delete-voucher',
  templateUrl: './delete-voucher.component.html',
  styleUrls: ['./delete-voucher.component.css']
})
export class DeleteVoucherComponent implements OnInit {

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

  btnSim(idVoucher: number) {

    this.empresaService.deleteByIdVoucher(idVoucher).subscribe(() => {

      alert('Voucher deletado com sucesso!')
      
      this.router.navigate(['/empresa'])

    })

  }

  btnNao() {

    this.router.navigate(['/empresa'])

  }

  
}
