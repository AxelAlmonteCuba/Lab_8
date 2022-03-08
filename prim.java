
import java.util.Arrays;


public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{{10000, 5, 7, 10000, 10000, 10000, 2}, {5, 10000, 10000, 9, 10000, 10000, 3}, {7, 10000, 10000, 10000, 8, 10000, 10000}, {10000, 9, 10000, 10000, 10000, 4, 10000}, {10000, 10000, 8, 10000, 10000, 5, 4}, {10000, 10000, 10000, 4, 5, 10000, 6}, {2, 3, 10000, 10000, 4, 6, 10000},};
        MGraph graph = new MGraph(verxs); 
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs,  weight);
        minTree.showGraph(graph);
        minTree.prim(graph, 0);
    }
}

class MinTree {

    public void createGraph(MGraph grafo, int veritices, int[][] matriz) {
        int i, j;
        for (i = 0; i < veritices; i++) {
            for (j = 0; j < veritices; j++) {
                grafo.matriz_adj[i][j] = matriz[i][j];
            }
        }
    }
    public void showGraph(MGraph grafo) {
        for (int[] link : grafo.matriz_adj) {
            System.out.println(Arrays.toString(link));
        }
    }
    public void prim(MGraph grafo, int v) {
        int visitado[] = new int[grafo.num_nodos];
          visitado[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minPeso = 10000; 
        for (int k = 1; k < grafo.num_nodos; k++) {
            for (int i = 0; i < grafo.num_nodos; i++) {
                for (int j = 0; j < grafo.num_nodos; j++) {
                    if (visitado[i] == 1 && visitado[j] == 0 && grafo.matriz_adj[i][j] < minPeso) {
                        minPeso = grafo.matriz_adj[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("Lado <" + grafo.data[h1] + "," + grafo.data[h2] + "> Peso:" + minPeso); // Marcar el nodo actual como visitado
            visitado[h2] = 1;
            minPeso = 10000;
        }
    }
}

class MGraph {
    int num_nodos;
    char[] data;
    int[][] matriz_adj; 

    public MGraph(int verxs) {
        this.num_nodos = verxs;
        data = new char[verxs];
        matriz_adj = new int[verxs][verxs];
    }
}
