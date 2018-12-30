/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author shivam
 */
public class SinglePathDAG {

    private LinkedList<Edge>[] graph;
    private int V;
    private boolean[] visited;
    private int INF = Integer.MAX_VALUE;

    class Edge {

        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    SinglePathDAG(int v) {
        graph = new LinkedList[v];
        visited = new boolean[v];
        this.V = v;
        for (int i = 0; i < V; i++) {
            graph[i] = new LinkedList<Edge>();
        }
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
    }

    private void addEdge(int u, int v, int weight) {
        Edge e = new Edge(u, v, weight);
        graph[u].add(e);
    }

    public static void main(String args[]) {
        SinglePathDAG g = new SinglePathDAG(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
        int s = 1;
        System.out.println("Following are shortest distances "
                + "from source " + s);
        g.SinglePathUtil(s);
    }

    private void doTopological(int u, Stack<Integer> st) {
        visited[u] = true;
        Iterator<Edge> itr = graph[u].iterator();
        while (itr.hasNext()) {
            int dest = itr.next().dest;
            if (!visited[dest]) {
                doTopological(dest, st);
            }
        }
        st.add(u);
    }

    private void SinglePathUtil(int start) {
        Stack<Integer> st = new Stack<Integer>();
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                doTopological(i, st);
            }
        }
        while (!st.isEmpty()) {
            int u = st.pop();
            if (dist[u] != INF) {
                Iterator<Edge> itr = graph[u].iterator();
                while (itr.hasNext()) {
                    Edge e = itr.next();
                    if (dist[e.dest] > (dist[u] + e.weight)) {
                        dist[e.dest] = dist[u] + e.weight;
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
    }

}
