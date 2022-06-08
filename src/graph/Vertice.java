package graph;

import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO dado;
    private final ArrayList<Aresta<TIPO>> arestasEntrada;
    private final ArrayList<Aresta<TIPO>> arestasSaida;
    
    public Vertice(TIPO valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<>();
        this.arestasSaida = new ArrayList<>();
    }

    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }
    
    public void adicionarArestaEntrada(Aresta<TIPO> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<TIPO> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }
    
    
}
