/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author shivam
 */
public class StronglyConnectedComponents {

    private int V;
    private LinkedList<Integer>[] graph;
    private boolean visited[];

    StronglyConnectedComponents(int n) {
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
    }

    public static void main(String args[]) {
        StronglyConnectedComponents g = new StronglyConnectedComponents(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.stronglyConnected();

    }

    private void printStrongCom(List<LinkedHashSet<Integer>> result) {
        for (int i = 0; i < result.size(); i++) {
            LinkedHashSet<Integer> set = result.get(i);
            Iterator<Integer> itr = set.iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
            System.out.println("");
        }
    }

    private void doDFS(int u, Stack<Integer> st) {
        visited[u] = true;
        Iterator<Integer> itr = graph[u].iterator();
        while (itr.hasNext()) {
            int i = itr.next();
            if (!visited[i]) {
                doDFS(i, st);
            }
        }
        st.push(u);
    }

    private void doDFSReverse(int u, LinkedHashSet<Integer> set) {
        visited[u] = true;
        set.add(u);
        Iterator<Integer> itr = graph[u].iterator();
        while (itr.hasNext()) {
            int i = itr.next();
            if (!visited[i]) {
                doDFSReverse(i, set);
            }
        }
    }

    private LinkedList<Integer>[] reverseGraph() {
        LinkedList<Integer>[] graphRev;
        graphRev = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            graphRev[i] = new LinkedList();
        }
        for (int i = 0; i < V; i++) {
            Iterator<Integer> itr = graph[i].iterator();
            while (itr.hasNext()) {
                int x = itr.next();
                graphRev[x].add(i);
            }
        }
        return graphRev;
    }

    private void stronglyConnected() {
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                doDFS(i, st);
            }
        }
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        graph = reverseGraph();
        List<LinkedHashSet<Integer>> result = new ArrayList<LinkedHashSet<Integer>>();
        while (!st.isEmpty()) {
            int x = st.pop();
            if (!visited[x]) {
                LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
                doDFSReverse(x, set);
                result.add(set);
            }
        }
        printStrongCom(result);

    }
}
