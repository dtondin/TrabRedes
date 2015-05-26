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

    String destino;
    int metrica;
    String saida;

    // Construtor da classe que recebe por parametro todos os atributos
    public CamposTabela(String destino, int metrica, String saida) {
        this.destino = destino;
        this.metrica = metrica;
        atualizaSaida();
    }

    // Construtor da classe que não recebe nenhum atributo por parametro
    public CamposTabela() {
        this.destino = "";
        this.metrica = 0;
        this.saida = "";
    }

    // Edita o valor do campo 'Destino'
    public void setDestino(String destino) {
        this.destino = destino;
    }

    // Edita o valor do campo 'Metrica'
    public void setMetrica(int metrica) {
        this.metrica = metrica;
    }

    // Edita o valor do campo 'Saida'
    public void setSaida(String saida) {
        this.saida = saida;
    }

    //Retorna o valor do campo 'Destino'
    public String getDestino() {
        return destino;
    }

    //Retorna o valor do campo 'Metrica'
    public int getMetrica() {
        return metrica;
    }

    //Retorna o valor do campo 'Saida'
    public String getSaida() {
        return saida;
    }

    @Override
    public String toString() {
        String tab =  "Destino: " + destino +
                " | Metrica: " + metrica +
                " | Saida: " + saida + " |";
        return tab;
    }

    private void atualizaSaida() {
        if (metrica == 1 || metrica == 0) {
            saida = "direto";
        } else {
            saida = destino;
        }
    }

}
