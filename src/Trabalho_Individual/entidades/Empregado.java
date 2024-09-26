package Trabalho_Individual.entidades;

import Trabalho_Individual.financeiro.Conta;

public class Empregado {
    private String nome;
    private Conta contaSalario;
    private Conta contaInvestimento;

    public Empregado(String nome) {
        this.nome = nome;
        this.contaSalario = new Conta(0, nome + " (Salário)");
        this.contaInvestimento = new Conta(0, nome + " (Investimentos)");
    }

    public String getNome() {
        return nome;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public void investir() {
        double valorInvestimento = contaSalario.getSaldo() * 0.2;
        contaSalario.debitar(valorInvestimento);
        contaInvestimento.creditar(valorInvestimento);
        System.out.println(nome + " investiu R$ " + valorInvestimento);
    }
}
