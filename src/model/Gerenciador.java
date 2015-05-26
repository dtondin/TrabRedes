package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Bruno, Douglas e Tamires
 */
public class Gerenciador extends Thread { 

    private Client c = new Client();
    private Server s = new Server();
    private String myIp = "";
    private ArrayList<CamposTabela> lista;
    //private Set<String> conjuntoIps;

    public Gerenciador() {
        lista = new ArrayList<CamposTabela>();
        //conjuntoIps = new HashSet<String>();
    }

    public String getMyIp() {
        return myIp;
    }

    public void adicionaIp(String ip) {
        if (myIp.equals("")) {
            //if (!conjuntoIps.contains(ip)) {
                CamposTabela camp = new CamposTabela(ip, 0, "");
                lista.add(camp);
                //conjuntoIps.add(ip);
                myIp = ip;
                c.myIp(ip);
                s.myIp(ip);
           // }
        }
    }

    public void adicionaVizinho(String ip, int metrica, String destino) {
        //if (!conjuntoIps.contains(destino)) {
            CamposTabela camp = new CamposTabela(destino, metrica, "");
            lista.add(camp);
            //conjuntoIps.add(destino);
        //}

    }

    public void removeVizinho(String ipDestino) {
        for (CamposTabela ct : lista) {
            if (ct.getDestino().equals(ipDestino)) {
                lista.remove(ct);
                //conjuntoIps.remove(ipDestino);
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
