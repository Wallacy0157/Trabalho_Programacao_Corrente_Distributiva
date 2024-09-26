package Trabalho_Individual.financeiro;

public class Conta {
    private double saldo;
    private String proprietario;

    public Conta(double saldoInicial, String proprietario) {
        this.saldo = saldoInicial;
        this.proprietario = proprietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void creditar(double valor) {
        saldo += valor;
    }

    public void debitar(double valor) {
        saldo -= valor;
    }
}