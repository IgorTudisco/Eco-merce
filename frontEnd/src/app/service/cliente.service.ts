import { Voucher } from './../model/Voucher';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  constructor(private http: HttpClient) {}

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token),
  }

  getAllVoucher(): Observable<Voucher[]> {
    return this.http.get<Voucher[]>(`http://localhost:8080/voucher`,this.token
    )
  }

  getByIdVoucher(id: number): Observable<Voucher> {
    return this.http.get<Voucher>(`http://localhost:8080/voucher/id/${id}`,this.token
    )
  }

  getByDescricaoVoucher(descricao: string): Observable<Voucher[]> {
    return this.http.get<Voucher[]>(`http://localhost:8080/voucher/descricao/${descricao}`,this.token
    )
  }

  getEmpresaParceiraVoucher(empresa: string): Observable<Voucher> {
    return this.http.get<Voucher>(`http://localhost:8080/empresaParceira/${empresa}`, this.token)
  }
}
