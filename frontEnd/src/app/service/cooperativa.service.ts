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
    return this.http.get<Usuario>(`http://localhost:8080/usuario/id/${id}`, this.token)

  }

  getByEnderecoCliente (endereco: string): Observable<Usuario>{
    return this.http.get<Usuario>(`http://localhost:8080/usuario/endereco/${endereco}`, this.token)

  }

}
