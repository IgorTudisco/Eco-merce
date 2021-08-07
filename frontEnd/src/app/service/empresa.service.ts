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

  
  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  constructor(
    private http:HttpClient
    ) { }

  postVoucher(id: number, voucher:Voucher): Observable<Voucher>{
    
    return this.http.post<Voucher>(`https://ecomerceappbr.herokuapp.com/usuario/empresa/${id}/criar`,voucher, this.token)
  }

  deleteByIdEmpresa(idEmpresa: number): Observable<Usuario>{
    return this.http.delete<Usuario>(`https://ecomerceappbr.herokuapp.com/usuario/id_delete/${idEmpresa}`, this.token)
  }

  deleteByIdVoucher(idVoucher: number): Observable<Voucher>{
    return this.http.delete<Voucher>(`https://ecomerceappbr.herokuapp.com/voucher/id_delete/${idVoucher}`, this.token)
  }

  putVoucher(voucher: Voucher): Observable<Voucher>{
    return this.http.put<Voucher>(`https://ecomerceappbr.herokuapp.com/voucher/`,voucher, this.token)
  }

  putMudarEmpresa(usuario: Usuario): Observable<Usuario>{
    return this.http.put<Usuario>(`https://ecomerceappbr.herokuapp.com/usuario/mudar`,usuario, this.token)
  }

  getAllVoucher(): Observable<Voucher[]>{
    return this.http.get<Voucher[]>('https://ecomerceappbr.herokuapp.com/voucher', this.token)
  }

  getByIdVoucher(idVoucher: number, idCliente: number): Observable<Voucher>{
    return this.http.get<Voucher>(`https://ecomerceappbr.herokuapp.com/voucher/${idVoucher}/${idCliente}`, this.token)
  }

  getByDescricao(descricao: string): Observable<Voucher[]>{
    return this.http.get<Voucher[]>(`https://ecomerceappbr.herokuapp.com/voucher/descricao/${descricao}`, this.token)
  }

  getAllEmpresa():Observable<Usuario[]>{
    return this.http.get<Usuario[]>(`https://ecomerceappbr.herokuapp.com/usuario`, this.token)
  }

  getByIdEmpresa(idEmpresa: number): Observable<Usuario>{
    return this.http.get<Usuario>(`https://ecomerceappbr.herokuapp.com/usuario/id/${idEmpresa}`, this.token)
  }

  getByEmail(email: string): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(`https://ecomerceappbr.herokuapp.com/usuario/email/${email}`, this.token)
  }

}
