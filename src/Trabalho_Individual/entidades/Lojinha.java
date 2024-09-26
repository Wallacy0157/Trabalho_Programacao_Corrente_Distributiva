package Trabalho_Individual.entidades;

import Trabalho_Individual.financeiro.Conta;

public class Lojinha {
    private String nome;
    private Conta conta;

    public Lojinha(String nome, double saldoInicial) {
        this.nome = nome;
        this.conta = new Conta(saldoInicial, nome);
    }

    public Conta getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }

    public void pagarEmpregados(Empregado[] empregados) {
        for (Empregado empregado : empregados) {
            if (conta.getSaldo() >= 1400) {
                conta.debitar(1400);
                empregado.getContaSalario().creditar(1400);
                System.out.println(empregado.getNome() + " recebeu o salário de R$ 1400.");
            } else {
                System.out.println("Saldo insuficiente para pagar " + empregado.getNome());
            }
        }
    }
}
