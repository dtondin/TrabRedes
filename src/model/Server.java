/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bruno, Douglas e Tamires
 */
import java.io.*;
import java.net.*;
import java.util.ArrayList;
public class Server extends Thread {
    ArrayList<CamposTabela> lista;
    String ip = "";
    public void run() {
        // cria socket do servidor com a porta 9876
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);

            byte[] receiveData = new byte[1024];
            while (true) {
                // declara o pacote a ser recebido
                DatagramPacket receivePacket =
                        new DatagramPacket(receiveData,
                        receiveData.length);

                // recebe o pacote do cliente
                serverSocket.receive(receivePacket);


                // pega os dados, o endere�o IP e a porta do cliente
                // para poder mandar a msg de volta 
                String sentence = new String(
                        receivePacket.getData());
                
                InetAddress IPAddress =
                        receivePacket.getAddress();
                int port = receivePacket.getPort();

                //System.out.println("Mensagem recebida: " + sentence);
                arrumaList(sentence);
                Thread.sleep(10 * 1000);
                serverSocket.disconnect();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    /**
     * recebe aqui referencia da lista la do menu
     */
    public void ApontaLista(ArrayList<CamposTabela> list){
        lista = list;
    }
    /**
     * recebe aqui referencia do IP la do menu
     */
    public void myIp(String ipValue){
        ip = ipValue;
    }
    
    /**
     * Organiza strings recebidos em texto.
     */
    public void arrumaList(String texto){
        if(!"".equals(texto)){        
            String[] ar = texto.split("/");
            ArrayList<CamposTabela> ct = new ArrayList<>();
            CamposTabela aux = null;
            for(int i = 1;i <= ar.length-2; i=i+2){

                aux = new CamposTabela(ar[0], Integer.parseInt(ar[i+1])+1, ar[i]);
                ct.add(aux);
                if(!lista.contains(aux) && !aux.getIp().equals(ip)){
                    lista.add(aux);
                }else{
                    CamposTabela camp = null;
                    for(CamposTabela ca:lista){
                        if(ca.getIp().equals(ar[i])){
                            camp = ca;
                        }
                    }
                    if(camp !=null){
                        if(camp.getMetrica()> Integer.parseInt(ar[i+1])+1){
                            lista.remove(camp);
                            lista.add(aux);
                        }
                    }                
                }                 
            }
            ArrayList<CamposTabela> toRemove = new ArrayList<>();
            for(CamposTabela ca:lista){
                if(ca.getDestino().equals(ar[0]) && !ct.contains(ca)){
                    toRemove.add(ca);
                }            
            } 
            for(CamposTabela camp: toRemove){
                lista.remove(camp);
            }
        }
    }   
}