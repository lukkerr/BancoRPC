package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas = new ArrayList<>();

    public BancoServiceServer() throws RemoteException {
        HashMap<String, Double> saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);
        Conta conta;

        for(String contaNumber: saldoContas.keySet()) {
            conta = new Conta(contaNumber, saldoContas.get(contaNumber));
            contas.add(conta);
        }
    }

    public Conta getConta(String contaNumber) {
        for(Conta conta: this.contas)
            if(conta.getNumero().equals(contaNumber)) return conta;

        return null;
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        Conta contaObject = this.getConta(conta);
        if(contaObject == null)  throw new RemoteException("Conta não encontrada");
        return contaObject.getSaldo();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return this.contas.size();
    }

    @Override
    public void adicionarConta(String numero, double saldo) throws RemoteException {
        Conta contaObject = this.getConta(numero);
        if(contaObject != null) throw new RemoteException("Conta já existente");
        this.contas.add(new Conta(numero,saldo));
    }

    @Override
    public String pesquisaConta(String numero) throws RemoteException {
        Conta conta = getConta(numero);
        if(conta != null)
            return conta.toString();

        return null;
    }

    @Override
    public boolean removerConta(String conta) throws RemoteException {
        for(Conta contaItem: this.contas)
            if(contaItem.getNumero().equals(conta)) return this.contas.remove(contaItem);

        return false;
    }

}
