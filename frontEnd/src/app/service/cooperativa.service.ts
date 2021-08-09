import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class CooperativaService {


  tok = environment.token
  
  token = {
    headers: new HttpHeaders().set('Authorization', this.tok)
  }

  constructor(private http: HttpClient) { }

  getByIdCliente(id: number): Observable<Usuario> { // ok
    return this.http.get<Usuario>(`localhost:8080/usuario/id/${id}`, this.token)

  }

  getByEnderecoCliente(endereco: string): Observable<Usuario[]> { // OK
    return this.http.get<Usuario[]>(`localhost:8080/usuario/endereco/${endereco}`, this.token)

  }

  putAddPontuacao() { // ok
    return this.http.put(`localhost:8080/usuario/cliente/9/cooperativa/2/valor/100`, this.token)
  }

  putMudarCooperativa(usuario: Usuario): Observable<Usuario> { // ok
    return this.http.put<Usuario>(`localhost:8080/usuario/mudar`, usuario, this.token)
  }

  deleteByIdCooperativa(id: number) { // ok
    return this.http.delete(`localhost:8080/usuario/id_delete/${id}`, this.token)
  }

}
