package Contas;

import Cliente.Cliente;
public abstract class Conta {
    private String numeroAgencia;
    protected int numeroConta;
    protected Cliente cliente;
    protected double saldo;
    private int quantidadeSaqueDiario;

    public Conta (String numeroAgencia, int numeroConta, Cliente cliente){
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.quantidadeSaqueDiario = 0;
        this.cliente = cliente;
    }

    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract void extrato();
    public abstract void transferir(Conta contaDestino, double valor);

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getQuantidadeSaqueDiario(){
        return quantidadeSaqueDiario;
    }

    public void incrementarQuantidadeSaqueDiario(){
        this.quantidadeSaqueDiario++;
    }

    public void disponibilizarQuantidadeSaqueDiario(){
        this.quantidadeSaqueDiario = 0;
    }

    @Override
    public String toString() {
        return String.format("Conta{numeroConta='%d', cliente=%s, saldo= R$ %.2f}", numeroConta, cliente, saldo);
    }
}
