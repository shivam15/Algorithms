/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author shivam
 */
public class BFSGraph {

    static int V;
    static LinkedList<Integer>[] graph;
    static boolean visited[];

    BFSGraph(int n) {
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
    }

    public static void main(String args[]) {
        BFSGraph g = new BFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "
                + "(starting from vertex 2)");

        g.doBFS(2);
    }

    static void doBFS(int u) {
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add(u);
        while (!qu.isEmpty()) {
            u = qu.poll();
            System.out.print(u + " ");
            Iterator<Integer> it = graph[u].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    qu.add(n);
                }
            }
        }
    }
}
