package graph;
import java.util.Scanner;
import main.main;
import java.util.ArrayList;
import velha.Velha;
import graph.Vertice;

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;
    Scanner sc = new Scanner(System.in);
    public Grafo(){
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }
    public void removeVertices(){
        this.vertices.forEach((Vertice<TIPO> e) -> {
            e.setDado(null);
        });
    }
    public void removeArestas(){
        this.arestas.forEach(e -> {e.setFim(null); e.setInicio(null); e.setPeso(null);});
        
    }
    public int size(){
        return this.vertices.size();
    }
    public void adicionarVertice(TIPO dado){
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim){
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    
    public Vertice<TIPO> getVertice(TIPO dado){
        Vertice<TIPO> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    public void buscaEmLargura(){
        ArrayList<Vertice<TIPO>> fila = new ArrayList<>();
        Vertice<TIPO> atual = this.vertices.get(0);
        fila.add(atual);
        while(fila.size() > 0){
                    System.out.println("Linha");
                    int a = sc.nextInt();
                    System.out.println("Col");
                    int b = sc.nextInt();
                    main.tabuleiro[a][b] = 1; 
                    Velha.print(main.tabuleiro);
                    System.out.println("Atual");
                    Vertice<TIPO> proximo = atual.getArestasSaida().get(0).getInicio();
                    fila.add(proximo);
                    atual.setDado((TIPO) (int[][]) proximo.getDado());
                    System.out.println(proximo.getDado());
                    System.out.println(atual.getDado());
                    /*System.out.println("Proximo");
                    Velha.print((int[][]) proximo.getDado());*/
            fila.remove(0);
        }
    }
}