package Trabalho_Individual;

import Trabalho_Individual.entidades.ClienteComDinheiro;
import Trabalho_Individual.entidades.Empregado;
import Trabalho_Individual.entidades.Lojinha;
import Trabalho_Individual.financeiro.BancoWilliam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BancoWilliam banco = new BancoWilliam();

        Lojinha lojinha1 = new Lojinha("Distribuidora de lícitos e ilícitos", 0);
        Lojinha lojinha2 = new Lojinha("Cafeteria e Drogaria", 0);
        Lojinha[] lojinhas = {lojinha1, lojinha2};

        Empregado emp1 = new Empregado("Juninho Portugal");
        Empregado emp2 = new Empregado("Roberto Carlos");
        Empregado emp3 = new Empregado("Michael Jackson");
        Empregado emp4 = new Empregado("Napoleão Sem Medo e Sem Mácula");

        Empregado[] empregadosLojinha1 = {emp1, emp2};
        Empregado[] empregadosLojinha2 = {emp3, emp4};

        ClienteComDinheiro[] clientes = {
                new ClienteComDinheiro("Wallacy William", lojinhas, banco),
                new ClienteComDinheiro("Vinicius Baltazar", lojinhas, banco),
                new ClienteComDinheiro("Djennifer Loira", lojinhas, banco),
                new ClienteComDinheiro("Scarlet Alguma Coisa", lojinhas, banco),
                new ClienteComDinheiro("Professor de Java", lojinhas, banco),
                new ClienteComDinheiro("Um maluco ai", lojinhas, banco),
                new ClienteComDinheiro("Outro maluco ai", lojinhas, banco),
                new ClienteComDinheiro("Fulano de Tal", lojinhas, banco),
                new ClienteComDinheiro("Ciclano de tal", lojinhas, banco),
                new ClienteComDinheiro("Irmão do Fulano e do Ciclano", lojinhas, banco)
        };

        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Fazer uma compra");
            System.out.println("2. Exibir saldo de um cliente");
            System.out.println("3. Exibir saldo de uma das lojinhas");
            System.out.println("4. Pagar CLTs");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Escolha um cliente (1-10):");
                    for (int i = 0; i < clientes.length; i++) {
                        System.out.println((i + 1) + ". " + clientes[i].getNome());
                    }
                    int clienteIndex = scanner.nextInt() - 1;

                    System.out.println("Escolha uma loja (1-2):");
                    System.out.println("1. " + lojinha1.getNome());
                    System.out.println("2. " + lojinha2.getNome());
                    int lojaIndex = scanner.nextInt() - 1;

                    System.out.println("Quanto você quer gastar (entre R$ 200,00 e R$ 500,00)?");
                    double valorCompra = scanner.nextDouble();

                    if (valorCompra < 200 || valorCompra > 500) {
                        System.out.println("Valor inválido. Tente novamente.");
                    } else {
                        banco.realizarTransferencia(clientes[clienteIndex].getConta(), lojinhas[lojaIndex].getConta(), valorCompra);
                    }
                    break;

                case 2:
                    System.out.println("Escolha um cliente (1-10):");
                    for (int i = 0; i < clientes.length; i++) {
                        System.out.println((i + 1) + ". " + clientes[i].getNome());
                    }
                    clienteIndex = scanner.nextInt() - 1;
                    System.out.println("Saldo do cliente " + clientes[clienteIndex].getNome() + ": R$ " + clientes[clienteIndex].getConta().getSaldo());
                    break;

                case 3:
                    System.out.println("Escolha a loja 1 ou 2:");
                    lojaIndex = scanner.nextInt() - 1;
                    System.out.println("Caixa da lojinha " + lojinhas[lojaIndex].getNome() + ": R$ " + lojinhas[lojaIndex].getConta().getSaldo());
                    break;

                case 4:
                    System.out.println("Pagando os CLTs das lojinhas...");
                    lojinha1.pagarEmpregados(empregadosLojinha1);
                    lojinha2.pagarEmpregados(empregadosLojinha2);
                    System.out.println("Salários pagos.");
                    break;

                case 5:
                    System.out.println("Tchau, Obrigado por Utilizar nosso sistema!!!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opaaaa.... Errou ai, arruma isso!");
            }
        }
    }
}
