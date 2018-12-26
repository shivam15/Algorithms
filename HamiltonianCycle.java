/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author shivam
 */
public class HamiltonianCycle {

    private int V;
    private LinkedList<Integer>[] graph;
    private boolean visited[];

    HamiltonianCycle(int n) {
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
        HamiltonianCycle g = new HamiltonianCycle(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 4);
        g.findHamilTonianCycle(0);
    }

    private void findHamilTonianCycle(int u) {
        ArrayList<Integer> hamil = new ArrayList<Integer>();
        if (findHamilTonianCycleUtil(u, u, hamil)) {
            printCycle(hamil);
        } else {
            System.out.println("No Possible Hamiltonian Cycle");
        }
    }

    private void printCycle(ArrayList<Integer> hamil) {
        System.out.println("Hamiltonian Cycle is:: ");
        for (int i = 0; i < hamil.size(); i++) {
            System.out.print(hamil.get(i) + " ");
        }
    }

    private boolean findHamilTonianCycleUtil(int start, int u, ArrayList<Integer> hamil) {
        hamil.add(u);
        visited[u] = true;
        Iterator<Integer> itr = graph[u].iterator();
        while (itr.hasNext()) {
            int v = itr.next();
            if (start == v && hamil.size() == V) {
                hamil.add(v);
                return true;
            }
            if (!visited[v]) {
                boolean b = findHamilTonianCycleUtil(start, v, hamil);
                if (b) {
                    return true;
                }
            }
        }
        hamil.remove(hamil.size() - 1);
        visited[u] = false;
        return false;
    }
}
