package Contas;

import Cliente.Cliente;

public class ContaPoupanca extends Conta{
    private double taxaJurosMensal;

    public ContaPoupanca(String numeroAgencia, int numeroConta, Cliente cliente, double taxaJurosMensal) {
        super(numeroAgencia, numeroConta, cliente);
        this.taxaJurosMensal = taxaJurosMensal;
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    @Override
    public void extrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Saldo: R$" + saldo);
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada para conta " + destino.getNumeroConta());
        }
    }

    public void aplicarJuros() {
        double juros = saldo * taxaJurosMensal / 100;
        saldo += juros;
        System.out.println("Juros de R$" + juros + " aplicados.");
    }
}

