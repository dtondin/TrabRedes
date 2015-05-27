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
            if (ct.getIp().equals(ipDestino)) {
                lista.remove(ct);
            }
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
        
        s.ApontaLista(lista);
        c.apontaLista(lista);
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
