package AulaEncapsulamentoBCC;

public class Conta {
  private Pessoa titular;
  private String nro;
  private String agencia;
  private int banco;
  private double saldo;// Não foi criado SET para saldo

  public Conta(Pessoa titular, String nro, String agencia, int banco) {
    this.titular = titular;
    this.nro = nro;
    this.agencia = agencia;
    this.banco = banco;
    this.saldo = 0.0; // inicializar variável
  }

  public Pessoa getTitular() {
    return this.titular;
  }

  public void setTitular(Pessoa titular) {
    this.titular = titular;
  }

  public String getNro() {
    return this.nro;
  }

  public void setNro(String nro) {
    this.nro = nro;
  }

  public String getAgencia() {
    return this.agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public int getBanco() {
    return this.banco;
  }

  public void setBanco(int banco) {
    this.banco = banco;
  }

  public double getSaldo() {
    return this.saldo;
  }

  boolean sacar(double valor) {
    if (valor > 0 && saldo >= valor) {
      saldo = saldo - valor;
      System.out.println("Saque realizado com sucesso!");
      return true;
    }
    System.out.println("Erro ao realizar saque!");
    return false;
  }

  boolean depositar(double valor) {
    if (valor > 0) {
      saldo = saldo + valor;
      System.out.println("Deposito realizado com sucesso!");
      return true;
    }
    System.out.println("Erro ao realizar depositar!");
    return false;
  }

  boolean transferir(double valor, Conta contaDestino) {
    if (this.sacar(valor)) {
      contaDestino.depositar(valor);
      System.out.println("Transferencia realizado com sucesso!");
      return true;
    }
    System.out.println("Erro ao realizar transferencia!");
    return false;
  }

  void extrato() {
    System.out.println("Conta " + nro + " - Saldo atual: " + saldo);
  }

}