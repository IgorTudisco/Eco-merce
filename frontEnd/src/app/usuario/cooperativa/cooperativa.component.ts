import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/model/Usuario';
import { CooperativaService } from 'src/app/service/cooperativa.service';

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

    })
  }

  addPonto(id_cooperativa: number, id_cliente: number, pontos: number) {

    this.cooperativaService.putAddPontuacao(id_cooperativa, id_cliente, pontos).subscribe(() => {

      alert('Pontos adicionados com sucesso!')

    })

  }

  atualizarEmpresa(empresa: Usuario){
      
    this.cooperativaService.putMudarCooperativa(empresa).subscribe((resp: Usuario) =>{

      this.cliente=resp
      alert('Dados atualizados com sucesso!')

      this.router.navigate(['/cooperativa'])

    })
  }

}
