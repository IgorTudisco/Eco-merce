import { Voucher } from "./Voucher"

export class Usuario{
  public id: number
  public nome: string
  public email: string
  public senha: string
  public endereco: string
  public cpf: string
  public meusPontos: number
  public tipo: string
  public data: Date
  public vouchersEmpresa: Voucher[]
  public meusVouchersCliente: Voucher[]
}