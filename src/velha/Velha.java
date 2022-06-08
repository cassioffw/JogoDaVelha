package velha;
import graph.Grafo;
import java.util.ArrayList;


public class Velha {
    public static Grafo g = new Grafo();
    public Velha(){
    
    }
    
    public Grafo getGrafo(){
        return g;
    }
    public static void print(int mat[][]) {
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                switch(mat[i][j]) {
                    case 1:
                        System.out.print("X");
                        break;
                    case 0:
                        System.out.print((i == mat.length-1 ? " " : "_"));
                        break;
                    case -1:
                        System.out.print("O");
                        break;
                }
                System.out.print((j == mat[0].length-1 ? "" : "|"));
            }
            System.out.println();
        }
    }

    public static int[][] copy(int m[][]) {
        int aux[][] = new int[m.length][m[0].length];
        for(int i=0; i<aux.length; i++) {
            System.arraycopy(m[i], 0, aux[i], 0, aux[0].length);
        }
        return aux;
    }

    // x = true | o = false
    public static ArrayList<int[][]> exp(int m[][], boolean jogador) {
        ArrayList<int[][]> espaco = new ArrayList<>();
        for(int i = 0; i<m.length; i++) {
            for(int j=0; j<m[0].length; j++) {
                if(m[i][j] == 0) {
                    int aux[][] = Velha.copy(m);
                    aux[i][j] = (jogador ? 1 : -1);
                    espaco.add(aux);
                }
            }
        }
        return espaco;
    }

    public static boolean is_fineshed(int m[][]) {
        // tabuleiro cheio
        int count = 0;
        for (int[] m1 : m) {
            for (int j = 0; j<m[0].length; j++) {
                if (m1[j] != 0) {
                    count ++;
                }
            }
        }
        if(count == 9) {
            return true;   
        } else {
            if(m[0][0] != 0 && m[0][0] == m[0][1] && m[0][1] == m[0][2]) {
                return true;
            } else if(m[1][0] != 0 && m[1][0] == m[1][1] && m[1][1] == m[1][2]) {
                return true;
            } else if(m[2][0] != 0 && m[2][0] == m[2][1] && m[2][1] == m[2][2]) {
                return true;
            } else if(m[0][0] != 0 && m[0][0] == m[1][0] && m[1][0] == m[2][0]) {
                return true;
            } else if(m[0][1] != 0 && m[0][1] == m[1][1] && m[1][1] == m[2][1]) {
                return true;
            } else if(m[0][2] != 0 && m[0][2] == m[1][2] && m[1][2] == m[2][2]) {
                return true;
            } else if(m[0][0] != 0 && m[0][0] == m[1][1] && m[1][1] == m[2][2]) {
                return true;
            } else if(m[0][2] != 0 && m[0][2] == m[1][1] && m[1][1] == m[2][0]) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void espaco_busca(int estado[][], boolean jogador) {
        g.adicionarVertice(estado);
        if(!Velha.is_fineshed(estado)) {
            ArrayList<int[][]> espaco = Velha.exp(estado, jogador);
            espaco.forEach(m -> {
                /*System.out.println("----------");
                System.out.print("Estado atual -->\n");
                Velha.print(estado);
                System.out.print("Estado para aresta -->\n");
                Velha.print(m);*/
                g.adicionarVertice(m);
                g.adicionarAresta(1.0, estado, m);
                espaco_busca(m, !jogador);
            });
        }
    }
}