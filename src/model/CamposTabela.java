package model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Esta classe implementa o objeto da Tabela de Roteamento. Os campos são:
 * Destino, Métrica e Saída.
 *
 * @author Bruno, Douglas e Tamires
 */
public class CamposTabela {

    private String ip;
    private int metrica;
    private String destino;

    // Construtor da classe que recebe por parametro todos os atributos
    public CamposTabela(String ip, int metrica, String destino) {
        this.ip = ip;
        this.metrica = metrica;
        this.destino = destino;
    }

    //Retorna o valor do campo 'Destino'
    public String getIp() {
        return ip;
    }

    //Retorna o valor do campo 'Metrica'
    public int getMetrica() {
        return metrica;
    }

    //Retorna o valor do campo 'Saida'
    public String getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return "Campos Tabela: "
                + "|" + "Ip: " + ip + " | Metrica: " + metrica + " | Destino: " + destino + "|";
    }

}
