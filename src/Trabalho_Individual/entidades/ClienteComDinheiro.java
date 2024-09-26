package Trabalho_Individual.entidades;

import Trabalho_Individual.financeiro.BancoWilliam;
import Trabalho_Individual.financeiro.Conta;

public class ClienteComDinheiro extends Thread {
    private String nome;
    private Conta conta;
    private Lojinha[] lojinhas;
    private BancoWilliam banco;

    public ClienteComDinheiro(String nome, Lojinha[] lojinhas, BancoWilliam banco) {
        this.nome = nome;
        this.conta = new Conta(2000.00, nome); // Saldo inicial de R$ 2.000,00
        this.lojinhas = lojinhas;
        this.banco = banco;
    }

    public Conta getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }

    public void run() {
        for (Lojinha lojinha : lojinhas) {
            double valorCompra = 200 + (Math.random() * 300); // Entre R$ 200 e R$ 500
            banco.realizarTransferencia(conta, lojinha.getConta(), valorCompra);
        }
    }
}