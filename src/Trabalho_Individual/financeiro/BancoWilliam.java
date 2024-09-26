package Trabalho_Individual.financeiro;

public class BancoWilliam {

    public synchronized void realizarTransferencia(Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
            System.out.println("Transferência de R$ " + valor + " de " + origem.getProprietario() + " para " + destino.getProprietario() + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente em " + origem.getProprietario() + " para realizar a transferência.");
        }
    }
}
