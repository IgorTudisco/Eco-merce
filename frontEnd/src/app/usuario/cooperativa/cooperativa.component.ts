import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/model/Usuario';
import { CooperativaService } from 'src/app/service/cooperativa.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-cooperativa',
  templateUrl: './cooperativa.component.html',
  styleUrls: ['./cooperativa.component.css']
})
export class CooperativaComponent implements OnInit {

  cliente: Usuario
  cooperativa: Usuario = new Usuario()
  endereco: string
  listaCliente: Usuario[] 
  idCoop: number = environment.id
  IdCliente: number
  pontosCliente: number

  constructor(
    private router: Router,
    private cooperativaService: CooperativaService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
   


  }

  findByIdCliente(idCliente: number){
    this.cooperativaService.getByIdCliente(idCliente).subscribe((resp: Usuario) => {

      this.cliente = resp

    })
  }

  findByEnderecoCliente(endereco: string){
    this.cooperativaService.getByEnderecoCliente(endereco).subscribe((resp: Usuario[]) => {

      this.listaCliente = resp
      console.log(JSON.stringify(this.listaCliente))
    })
  }

  addPonto() {

    this.cooperativaService.putAddPontuacao().subscribe(() => {

      alert('Pontos adicionados com sucesso!')

    })

  }

  atualizarEmpresa(empresa: Usuario){
      
    this.cooperativaService.putMudarCooperativa(empresa).subscribe((resp: Usuario) =>{

      this.cooperativa=resp
      alert('Dados atualizados com sucesso!')

      this.router.navigate(['/cooperativa'])

    })
  }

}
