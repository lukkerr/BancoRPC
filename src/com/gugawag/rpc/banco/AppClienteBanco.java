package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.saldo(conta));
                    break;
                }
                case 2: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.quantidadeContas());
                    break;
                }
                case 3: {
                    System.out.println("Digite o número da conta a adicionar:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    banco.adicionarConta(conta, 0);
                    break;
                }
                case 4: {
                    System.out.println("Digite o número da conta a pesquisar:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    String contaResult = banco.pesquisaConta(conta);
                    if(contaResult == null)
                        System.out.println("Conta não existente");
                    else
                        System.out.println(contaResult.toString());
                    break;
                }
                case 5: {
                    System.out.println("Digite o número da conta a remover:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente;
                    if(banco.removerConta(conta))
                        System.out.println("Conta '" + conta + "' deletada");
                    else
                        System.out.println("Conta não existente");
                    break;
                }
                default: {
                    System.out.println("Opção '" + opcao + "' Invalida");
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("---------------------------------------");
        System.out.println("Aluno: Luciano de Carvalho Souza Filho");
        System.out.println("---------------------------------------");
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Cadastro de nova conta");
        System.out.println("4 - Pesquisar conta (por número)");
        System.out.println("9 - Sair");
        System.out.println("---------------------------------------");
    }

}
