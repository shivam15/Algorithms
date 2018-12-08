/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author shivam
 */
public class PrimsAlgo {

    static int V;

    public static void main(String args[]) {
        int graph[][] = new int[][] {{0, 2, 0, 6, 0}, 
                                    {2, 0, 3, 8, 5}, 
                                    {0, 3, 0, 0, 7}, 
                                    {6, 8, 0, 0, 9}, 
                                    {0, 5, 7, 9, 0}};
        V = 5;
        primMST(graph);
    }

    static void primMST(int graph[][]) {
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mst[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V; count++) {
            int u = minKey(key, mst);
            mst[u] = true;
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && mst[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent,graph);
    }
    static void printMST(int[] parent,int[][] graph){
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) 
            System.out.println(parent[i]+" - "+ i+"\t"+ 
                            graph[i][parent[i]]);
    }
    static int minKey(int[] key, boolean[] mst) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int v=0;v<V;v++){
            if (mst[v] == false && key[v] < min) 
            { 
                min = key[v]; 
                min_index = v; 
            }
        }
        return min_index;
    }
}
