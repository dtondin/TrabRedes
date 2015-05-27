package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bruno, Douglas e Tamires
 */
public class Gerenciador extends Thread {

    Client c = new Client();
    Server s = new Server();
    String myIp = "";
    ArrayList<CamposTabela> lista;

    public Gerenciador() {
        lista = new ArrayList<>();
    }

    public String getMyIp() {
        return myIp;
    }

    public void adicionaIp(String ip) {
        CamposTabela camp = new CamposTabela(ip, 0, "");
        lista.add(camp);
        myIp = ip;
        c.myIp(ip);
        s.myIp(ip);
    }

    public void adicionaVizinho(String ip, int metrica, String destino) {
        CamposTabela camp = new CamposTabela(ip, metrica, destino);
        lista.add(camp);
    }

    public void removeVizinho(String ipDestino) {
        for (CamposTabela ct : lista) {
            if (ct.getDestino().equals(ipDestino)) {
                lista.remove(ct);
            }
        }
    }

    public void imprimirTabela() {
        for (CamposTabela ct : lista) {
            System.out.println(ct.toString());
        }
    }

    public ArrayList<CamposTabela> getLista() {
        return lista;
    }

    /**
     * Opções do menu e sincronização de ponteiros.
     */
    @Override
    public void run() {
        boolean terminou = false;
        Scanner sc = new Scanner(System.in);
        s.ApontaLista(lista);
        c.apontaLista(lista);
        //System.out.println("Informe seu IP: ");
        //myIp = sc.next();
        //c.myIp(myIp);
        //s.myIp(myIp);

        while (terminou != true) {
//            System.out.println("***** MENU *****");
//            System.out.println("1 - Adicionar máquina ao grupo");
//            System.out.println("2 - Remover máquina do grupo");
//            System.out.println("3 - Exibir tabela de roteamento");
//            System.out.println("4 - Encerrar");
            int op = sc.nextInt();
            String ipAux = "";
            switch (op) {
                case 1:
                    //System.out.println("Informe o Ip vizinho: ");
                    //ipAux = sc.next();
                    //CamposTabela camp = new CamposTabela(ipAux, 1, ipAux);
                    //lista.add(camp);
                    break;
                case 2:
//                    CamposTabela aux = null;
//                    System.out.println("Informe o Ip a ser removido: ");
//                    ipAux = sc.next();
//                    for (CamposTabela ct : lista) {
//                        if (ct.getDestino().equals(ipAux)) {
//                            aux = ct;
//                            break;
//                        }
//                    }
//                    if (aux != null) {
//                        lista.remove(aux);
//                    } else {
//                        System.out.println("Impossível remover o IP.");
//                    }
                    break;
                case 3:
                    System.out.println("Tabela de roteamento : ");
                    for (CamposTabela ct : lista) {
                        System.out.println(ct.toString());
                    }
                    break;
                case 4:
//                    terminou = true;
//                    System.exit(0);
                    break;
            }
        }

    }

    /**
     * retorna ponteiro do cliente
     */
    public Client atualCliente() {
        return c;
    }

    /**
     * retorna ponteiro do servidor
     */
    public Server atualServer() {
        return s;
    }
}
