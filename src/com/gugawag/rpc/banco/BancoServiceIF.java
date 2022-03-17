package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    void adicionarConta(String numero, double saldo) throws RemoteException;
    String pesquisaConta(String numero) throws RemoteException;
    boolean removerConta(String conta) throws RemoteException;
}
