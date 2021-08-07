import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/model/Usuario';
import { CooperativaService } from 'src/app/service/cooperativa.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-delete-cooperativa',
  templateUrl: './delete-cooperativa.component.html',
  styleUrls: ['./delete-cooperativa.component.css']
})
export class DeleteCooperativaComponent implements OnInit {

  cooperativa: Usuario = new Usuario()
  delOk: boolean = false

  constructor(
    private router: Router,
    private cooperativaService: CooperativaService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(){
    let id: number = this.route.snapshot.params["id"]
    this.findByIdCooperativa(id)
  }

  findByIdCooperativa(id: number) {
    this.cooperativaService.getByidCooperativa(environment.id).subscribe((resp: Usuario) => {
      this.cooperativa = resp
    }, err => {
      console.log(`Erro cod: ${err.status}`)
    })
  }

  btnSim() {
    this.cooperativaService.deleteByIdCooperativa(this.cooperativa.id).subscribe(() => {
      this.delOk = true
      this.router.navigate(['/home'])
    }, err => {
      console.log(err)
    })
  }
  btnNao() {
    this.router.navigate(['/cooperativa'])
  }


}
