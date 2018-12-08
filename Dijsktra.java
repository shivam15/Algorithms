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
public class Dijsktra {
    static int V;

    public static void main(String args[]) {
        int graph[][] = new int[][] {{0, 2, 0, 6, 0}, 
                                    {2, 0, 3, 8, 5}, 
                                    {0, 3, 0, 0, 7}, 
                                    {6, 8, 0, 0, 9}, 
                                    {0, 5, 7, 9, 0}};
        V = 5;
        dijsktraMST(graph);
    }

    static void dijsktraMST(int graph[][]) {
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
                    key[v] = key[u]+graph[u][v];
                }
            }
        }
        printMST(key);
    }
    static void printMST(int[] parent){
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i+" \t \t "+parent[i]);
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
