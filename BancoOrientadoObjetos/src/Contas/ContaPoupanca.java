package Contas;

import java.time.LocalDate;

import Cliente.Cliente;

public class ContaPoupanca extends Conta{
    private double taxaJurosAnual;
    private LocalDate contaDataCriacao;
    public ContaPoupanca(String numeroAgencia, int numeroConta, Cliente cliente, double taxaJurosAnual, LocalDate contaDataCriacao) {
        super(numeroAgencia, numeroConta, cliente);
        this.taxaJurosAnual = taxaJurosAnual;
        this.contaDataCriacao = contaDataCriacao;
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ %.2f" + valor + " realizado com sucesso.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ %.2f" + valor + " realizado com sucesso.");
    }

    @Override
    public void extrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Saldo: R$ %.2f" + saldo);
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$ %.2f" + valor + " realizada para conta " + destino.getNumeroConta());
        }
    }

    public LocalDate getContaDataCriacao(){
        return contaDataCriacao;
    }

    public void setContaDataCriacao(LocalDate contaDataCriacao) {
        this.contaDataCriacao = contaDataCriacao;
    }

    public void aplicarJuros() {
        double taxaJurosMensal = Math.pow(1 + taxaJurosAnual, 1.0 / 12) - 1;
        double novoSaldo = getSaldo() * (1 + taxaJurosMensal);
        setSaldo(novoSaldo);
        System.out.println("Juros de R$ %.2f" + taxaJurosMensal + " aplicados.");
    }
}
