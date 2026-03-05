package AccountBank;

import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    Banco banco = new Banco();

    for (;;) {
      System.out.println("MENU");
      System.out.println("1 - CRIAR CONTA");
      System.out.println("2 - EXIBIR SALDO");
      System.out.println("3 - SACAR");
      System.out.println("4 - DEPOSITAR");
      System.out.println("5 - TRANSFERIR");
      System.out.println("0 - SAIR");
      System.out.print("Digite a opção: ");

      String entrada = scan.nextLine();
      int opcao = Integer.parseInt(entrada);

      if (opcao == 1) {
        System.out.println("Nome:");
        String name = scan.nextLine();
        System.out.println("CPF:");
        String cpf = scan.nextLine();
        System.out.println("Endereço:");
        String endereco = scan.nextLine();
        System.out.println("Telefone:");
        String telefone = scan.nextLine();

        Pessoa titular = new Pessoa(name, cpf, endereco, telefone);

        System.out.println("Número/Código:");
        String numero = scan.nextLine();
        System.out.println("Agência:");
        String agencia = scan.nextLine();
        System.out.println("Banco:");
        int banc = scan.nextInt();
        scan.nextLine();

        Conta conta1 = new Conta(titular, numero, agencia, banc);

        banco.getContas().add(conta1);

      } else if (opcao == 2) {
        System.out.println("Número/Código:");
        String numero = scan.nextLine();

        for (int i = 0; i < banco.getContas().size(); i++) {
          Conta contaAtual = banco.getContas().get(i);
          String numeroConta = contaAtual.getNro();

          if (numero.equals(numeroConta)) {
            System.out.println("=======================");
            System.out.println("EXTRATO DA CONTA");
            System.out.println("Número:" + contaAtual.getNro());
            System.out.println("- Nome:" + contaAtual.getTitular().getNome());
            System.out.println("- Saldo:" + contaAtual.getSaldo());
            System.out.println("=======================");
          }
        }

      } else if (opcao == 3) {
        System.out.println("Número/Código:");
        String numero = scan.nextLine();

        System.out.println("Valor de saque:");
        double valorSaque = scan.nextDouble();
        scan.nextLine();

        for (int i = 0; i < banco.getContas().size(); i++) {
          Conta contaAtual = banco.getContas().get(i);
          String numeroConta = contaAtual.getNro();

          if (numero.equals(numeroConta)) {
            contaAtual.sacar(valorSaque);
          }
        }

      } else if (opcao == 4) {
        System.out.println("Número/Código:");
        String numero = scan.nextLine();

        System.out.println("Valor de Deposito:");
        double valorDeposito = scan.nextDouble();
        scan.nextLine();

        for (int i = 0; i < banco.getContas().size(); i++) {
          Conta contaAtual = banco.getContas().get(i);
          String numeroConta = contaAtual.getNro();

          if (numero.equals(numeroConta)) {
            contaAtual.depositar(valorDeposito);
          }
        }

      } else if (opcao == 5) {
        System.out.println("Número/Código -> REMETENTE:");
        String remetente = scan.nextLine();

        System.out.println("Valor de Transferencia:");
        double valor = scan.nextDouble();
        scan.nextLine();

        System.out.println("Número/Código -> DESTINATÁRIO:");
        String destinatario = scan.nextLine();

        Conta contaDestinatario = null;
        Conta contaRemetente = null;

        for (int i = 0; i < banco.getContas().size(); i++) {
          Conta contaAtual = banco.getContas().get(i);
          String numeroConta = contaAtual.getNro();

          if (remetente.equals(numeroConta)) {
            contaRemetente = contaAtual;
          }
          if (destinatario.equals(numeroConta)) {
            contaDestinatario = contaAtual;
          }
        }
        if (contaRemetente != null && contaDestinatario != null) {
          contaRemetente.transferir(valor, contaDestinatario);
        }

      } else if (opcao == 0) {
        break;
      }
    }
    scan.close();

  }
}
