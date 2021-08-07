import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  getAllVoucher(): Observable<Voucher[]>{
    return this.http.get<Voucher[]>('https://ecomerceappbr.herokuapp.com/voucher', this.token)
  }

  getByIdVoucher(idVoucher: Voucher, idCliente: Usuario): Observable<Voucher[]>{
    return this.http.get<Voucher[]>(`https://ecomerceappbr.herokuapp.com/voucher/${idVoucher}/${idCliente}`, this.token)
  }

}
