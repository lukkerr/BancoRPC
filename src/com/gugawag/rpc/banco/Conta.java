package com.gugawag.rpc.banco;

public class Conta {
    private String numero;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
