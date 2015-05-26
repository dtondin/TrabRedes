package model;

/**
 *
 * @author Bruno, Douglas e Tamires
 */
import java.net.*;
import java.util.ArrayList;

public class Client extends Thread {

    private String listaEmString = "";
    String ip = "";
    ArrayList<CamposTabela> lista;

    /**
     * onde ocorre a thread do cliente. envia dados a todos os servidores
     */
    public void run() {
        while (true) {
            // cria o stream do teclado
            transformaListEmString();
            String inFromUser = (listaEmString);
            try {
                // declara socket cliente
                DatagramSocket clientSocket = new DatagramSocket();

                // obtem endere�o IP do servidor com o DNS            
                if (lista != null && lista.size() > 0) {
                    try {
                        for (CamposTabela ct : lista) {

                            InetAddress IPAddress
                                    = InetAddress.getByName(ct.getSaida());

                            byte[] sendData = new byte[1024];
                            byte[] receiveData = new byte[1024];

                            // le uma linha do teclado
                            //String sentence = ct.destino;
                            String sentence = inFromUser;
                            sendData = sentence.getBytes();

                            // cria pacote com o dado, o endere�o do server e porta do servidor
                            DatagramPacket sendPacket
                                    = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

                            //envia o pacote
                            clientSocket.send(sendPacket);
                        }
                    } catch (Exception e) {

                    }
                }

                // fecha o cliente
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * recebe aqui referencia da lista la do menu
     */
    public void apontaLista(ArrayList<CamposTabela> list) {
        lista = list;
    }

    /**
     * recebe aqui referencia do IP la do menu
     */
    public void myIp(String ipValue) {
        ip = ipValue;
    }
    /*
     * Método transforma ArrayList<CamposTabela> lista - em uma String contendo
     * todos os dados da lista. Armazenado em private String listaEmString,
     * formato: IPDestino, Metrica/IPDestino, Metrica/IPDestino ...
     */

    public void transformaListEmString() {
        if (lista != null && lista.size() > 0) {
            listaEmString = ip + "/";
            for (CamposTabela c : lista) {
                listaEmString += c.getDestino() + "/" + c.getMetrica() + "/";
            }
        }
    }
}
