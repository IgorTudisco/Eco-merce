import { Voucher } from './../model/Voucher';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../model/Usuario';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  constructor(private http: HttpClient) {}

  token = {
    headers: new HttpHeaders().set('Authorization', "Basic ZW1wcmVzYUBnbWFpbC5jb206MTIzNDU2Nzg5"),
  }

  getAllVoucher(): Observable<Voucher[]> {
    return this.http.get<Voucher[]>(`https://ecomerceappbr.herokuapp.com/voucher`,this.token
    )
  }

  getByIdVoucher(id: number): Observable<Voucher> {
    return this.http.get<Voucher>(`https://ecomerceappbr.herokuapp.com/voucher/id/${id}`,this.token
    )
  }

  getByDescricaoVoucher(descricao: string): Observable<Voucher[]> {
    return this.http.get<Voucher[]>(`https://ecomerceappbr.herokuapp.com/voucher/descricao/${descricao}`,this.token
    )
  }

  getEmpresaParceiraVoucher(empresa: string): Observable<Voucher> {
    return this.http.get<Voucher>(`https://ecomerceappbr.herokuapp.com/empresaParceira/${empresa}`, this.token)
  }

  getByidCliente(id: number): Observable<Usuario>{
    return this.http.get<Usuario>(`https://ecomerceappbr.herokuapp.com/usuario/id/${id}`, this.token)
  }

  putVoucher(id_cliente: number, id_voucher: number): Observable<Voucher>{
    return this.http.put<Voucher>(`https://ecomerceappbr.herokuapp.com/voucher/cliente/${id_cliente}/voucher/${id_voucher}`, this.token)
  }

  putCliente(cliente: Usuario): Observable<Usuario>{
    return this.http.put<Usuario>('https://ecomerceappbr.herokuapp.com/usuario/mudar', cliente, this.token)
  }

  deleteById(id: number){
    return this.http.delete(`https://ecomerceappbr.herokuapp.com/usuario/id_delete/${id}`)
  }
}
