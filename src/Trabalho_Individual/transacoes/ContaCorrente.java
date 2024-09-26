package Trabalho_Individual.transacoes;

public class ContaCorrente {
    private String proprietario;
    private double saldo;

    public ContaCorrente(String proprietario, double saldoInicial) {
        this.proprietario = proprietario;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debitar(double valor) {
        saldo -= valor;
    }

    public void creditar(double valor) {
        saldo += valor;
    }

    public String getProprietario() {
        return proprietario;
    }
}