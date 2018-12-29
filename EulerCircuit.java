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
public class EulerCircuit {

    private int V;
    private LinkedList<Integer>[] graph;
    private boolean visited[];

    EulerCircuit(int n) {
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

    private void addEdge(int v, int u) {
        graph[v].add(u);
        graph[u].add(v);
    }

    public static void main(String args[]) {
        EulerCircuit g = new EulerCircuit(5);
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(3, 4); 
        g.addEdge(4, 0);
        System.out.println(g.isEuler());
    }

    private void doDFS(int u) {
        Iterator<Integer> it = graph[u].listIterator();
        visited[u] = true;
        while (it.hasNext()) {
            int n = it.next();
            if (visited[n] == false) {
                doDFS(n);
            }
        }
    }

    private boolean isConnected() {
        int i;
        for (i = 0; i < V; i++) {
            if (graph[i].size() != 0) {
                break;
            }
        }
        if (i == V) {
            return true;
        }
        doDFS(i);
        for (i = 0; i < V; i++) {
            if (visited[i] == false && graph[i].size() > 0) {
                return false;
            }
        }

        return true;
    }

    private String isEuler() {
        if (!isConnected()) {
            return "Not Eulerian";
        }
        int odd = 0;
        for (int i = 0; i < V; i++) {
            if (graph[i].size() % 2 != 0) {
                odd++;
            }
        }
        if (odd > 2) {
            return "Not Eulerian";
        }
        return odd == 0 ? "EULERIAN CYCLE" : "EULERIAN PATH";
    }
}
