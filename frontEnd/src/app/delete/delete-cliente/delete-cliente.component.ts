import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/model/Usuario';
import { ClienteService } from 'src/app/service/cliente.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-delete-cliente',
  templateUrl: './delete-cliente.component.html',
  styleUrls: ['./delete-cliente.component.css']
})
export class DeleteClienteComponent implements OnInit {

  cliente: Usuario = new Usuario()
  delOk: boolean = false

  constructor(
    private router: Router,
    private clienteService: ClienteService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(){
    let id: number = this.route.snapshot.params["id"]
    // this.findByIdCliente(id)
  }

  // findByIdCliente(id: number) {
  //   this.clienteService.getByidCliente(environment.id).subscribe((resp: Usuario) => {
  //     this.cliente = resp
  //   }, err => {
  //     console.log(`Erro cod: ${err.status}`)
  //   })
  // }

  btnSim() {
    this.clienteService.deleteById(this.cliente.id).subscribe(() => {
      this.delOk = true
      this.router.navigate(['/home'])
    }, err => {
      console.log(err)
    })
  }
  btnNao() {
    this.router.navigate(['/cliente'])
  }

  

}
