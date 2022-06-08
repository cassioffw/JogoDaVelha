package main;
import graph.Grafo;
import velha.Velha;
import java.util.Scanner;

public class main {
    public static int tabuleiro[][] = {{0,0,-1}, {1,0,0}, {0,0,1}};
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        Grafo g = Velha.g;
        Velha.espaco_busca(tabuleiro, false);
        g.buscaEmLargura();
    }
}
