import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class CooperativaService {


  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getByIdCliente (id: number): Observable<Usuario>{
    return this.http.get<Usuario>(`https://ecomerceappbr.herokuapp.com/usuario/id/${id}`, this.token)

  }

  getByEnderecoCliente (endereco: string): Observable<Usuario>{
    return this.http.get<Usuario>(`https://ecomerceappbr.herokuapp.com/usuario/endereco/${endereco}`, this.token)

  }

  putAddPontuacao(id_cooperativa: number, id_cliente: number, pontos: number){
    return this.http.put(`https://ecomerceappbr.herokuapp.com/usuario/cliente/${id_cliente}/cooperativa/${id_cooperativa}/valor/${pontos}`, this.token)
  }

  putCooperativa(cooperativa: Usuario){
    return this.http.put('https://ecomerceappbr.herokuapp.com/usuario/mudar', cooperativa, this.token)
  }

  deleteByIdCooperativa(id: number){
    return this.http.delete(`https://ecomerceappbr.herokuapp.com/usuario/id_delete/${id}`)
  }

  getByidCooperativa(id: number): Observable<Usuario>{
    return this.http.get<Usuario>(`https://ecomerceappbr.herokuapp.com/usuario/id/$
  {id}`, this.token)
  }

}
