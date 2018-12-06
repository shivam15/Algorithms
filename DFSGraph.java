/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author shivam
 */
public class DFSGraph {

    static int V;
    static LinkedList<Integer>[] graph;
    static boolean visited[];

    DFSGraph(int n) {
        V = n;
        visited = new boolean[V];
        for (int i = 0; i < V; i++) 
            visited[i] = false;
      
        graph = new LinkedList[V];
        for (int i = 0; i < V; i++) 
            graph[i] = new LinkedList();
    }

    static void addEdge(int v, int u) {
        graph[v].add(u);
    }

    public static void main(String args[]) {
        DFSGraph g = new DFSGraph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.doDFS(2); 
    }

    static void doDFS(int u) {
        Iterator<Integer> it = graph[u].listIterator();
        visited[u] = true;
        System.out.println(u+" ");
        while (it.hasNext()) {
            int n = it.next();
            if (visited[n]==false) {
                doDFS(n);
            }
        }
    }
}
