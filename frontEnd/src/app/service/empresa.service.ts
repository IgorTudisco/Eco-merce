import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ThrowStmt } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { Voucher } from '../model/Voucher';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  tok = environment.token
  
  token = {
    headers: new HttpHeaders().set('Authorization', this.tok)
  }

  constructor(private http:HttpClient) { }

  postVoucher(id: number, voucher:Voucher): Observable<Voucher>{ // ok
    
    return this.http.post<Voucher>(`localhost:8080/usuario/empresa/${id}/criar`,voucher, this.token)
  }

  deleteByIdEmpresa(idEmpresa: number): Observable<Usuario>{ // ok 
    return this.http.delete<Usuario>(`localhost:8080/usuario/id_delete/${idEmpresa}`, this.token)
  }

  deleteByIdVoucher(idVoucher: number): Observable<Voucher>{ // ok
    return this.http.delete<Voucher>(`localhost:8080/voucher/id_delete/${idVoucher}`, this.token)
  }

  putVoucher(voucher: Voucher): Observable<Voucher>{ // ok
    return this.http.put<Voucher>(`localhost:8080/voucher/`,voucher, this.token)
  }

  putMudarEmpresa(usuario: Usuario): Observable<Usuario>{ // ok 
    return this.http.put<Usuario>(`localhost:8080/usuario/mudar`,usuario, this.token)
  }

  getAllVoucher(): Observable<Voucher[]>{ // ok
    console.log(this.tok)
    return this.http.get<Voucher[]>(`localhost:8080/voucher`, this.token)
  }

  getByIdVoucher(idVoucher: number): Observable<Voucher>{ // ok
    return this.http.get<Voucher>(`localhost:8080/voucher/id/${idVoucher}`, this.token)
  }

  getByDescricao(descricao: string): Observable<Voucher[]>{ // ok
    return this.http.get<Voucher[]>(`localhost:8080/voucher/descricao/${descricao}`, this.token)
  }

  getAllCliente():Observable<Usuario[]>{ // ok
    return this.http.get<Usuario[]>(`localhost:8080/usuario`, this.token)
  }

  getByIdCliente(idCliente: number): Observable<Usuario>{ // ok
    return this.http.get<Usuario>(`localhost:8080/usuario/id/${idCliente}`, this.token)
  }

  getByEmail(email: string): Observable<Usuario>{ // ok
    return this.http.get<Usuario>(`localhost:8080/usuario/email/${email}`, this.token)
  }

}
