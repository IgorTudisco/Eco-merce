import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { UsuarioCadastroDTO } from '../model/UsuarioCadastroDTO';
import { UsuarioLoginDTO } from '../model/UsuarioLoginDTO';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
    ) { }

  entrar(usuarioLoginDTO: UsuarioLoginDTO): Observable<UsuarioLoginDTO>{
    return this.http.post<UsuarioLoginDTO>('https://ecmomercebr.herokuapp.com/usuarios/logar', usuarioLoginDTO)
  }

  cadastrar(usuarioCadastroDTO: UsuarioCadastroDTO): Observable<UsuarioCadastroDTO>{
    return this.http.post<UsuarioCadastroDTO>('https://ecmomercebr.herokuapp.com/usuarios/cadastrar', usuarioCadastroDTO)
  }

  logado(){
    let ok: boolean = false

    if(environment.token != ''){
      ok = true
    }

    return ok
  }
}
