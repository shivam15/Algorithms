/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author shivam
 */
public class GraphColoring {

    static int V;
    static LinkedList<Integer>[] graph;
    static boolean visited[];

    GraphColoring(int n) {
        V = n;
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        graph = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new LinkedList();
        }
    }

    static void addEdge(int v, int u) {
        graph[v].add(u);
        graph[u].add(v);
    }

    static void graphColor() {
        int[] result = new int[V];
        Arrays.fill(result, -1);
        result[0] = 0;
        boolean[] avail = new boolean[V];
        Arrays.fill(avail, true);
        for (int u = 1; u < V; u++) {
            Iterator<Integer> itr = graph[u].iterator();
            while (itr.hasNext()) {
                int i = itr.next();
                //below lines are imp
                if (result[i] != -1) {
                    avail[result[i]] = false;
                }
            }
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (avail[cr]) {
                    break;
                }
            }
            result[u] = cr;
            Arrays.fill(avail, true);
        }
        for (int u = 0; u < V; u++) 
            System.out.println("Vertex " + u + " --->  Color "
                                + result[u]);
    }
    public static void main(String args[]) {
        GraphColoring g2 = new GraphColoring(5); 
        g2.addEdge(0, 1); 
        g2.addEdge(0, 2); 
        g2.addEdge(1, 2); 
        g2.addEdge(1, 4); 
        g2.addEdge(2, 4); 
        g2.addEdge(4, 3); 
        g2.graphColor();
    }
}
