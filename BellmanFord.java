/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.LinkedList;

/**
 *
 * @author shivam
 */
public class BellmanFord {

    int V;
    int E;
    Edge[] graph;
    int infinity = Integer.MAX_VALUE;

    class Edge {

        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    };

    class Vertex {

        int vertex, distance, parent;

        Vertex() {
            vertex = distance = parent = -1;
        }
    }

    BellmanFord(int n, int e) {
        V = n;
        E = e;
        graph = new Edge[E];
        for (int i = 0; i < E; i++) {
            graph[i] = new Edge();
        }
    }

    void addEdge(int edge, int u, int v, int weight) {
        graph[edge].src = u;
        graph[edge].dest = v;
        graph[edge].weight = weight;
    }

    public static void main(String args[]) {
        BellmanFord g = new BellmanFord(5, 8);

        g.addEdge(0, 0, 1, -1);
        g.addEdge(1, 0, 2, 4);
        g.addEdge(2, 1, 2, 3);
        g.addEdge(3, 1, 3, 2);
        g.addEdge(4, 1, 4, 2);
        g.addEdge(5, 3, 2, 5);
        g.addEdge(6, 3, 1, 1);
        g.addEdge(7, 4, 3, -3);
        g.doBellmanFord(0);
    }

    void doBellmanFord(int start) {
        Vertex[] vert = new Vertex[V];
        for (int i = 0; i < V; i++) {
            vert[i] = new Vertex();
            vert[i].vertex = i;
            vert[i].distance = infinity;
            vert[i].parent = -1;
        }
        vert[start].distance = 0;
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = graph[j].src;
                int v = graph[j].dest;
                int w = graph[j].weight;
                if (vert[u].distance != infinity && vert[v].distance > (vert[u].distance + w)) {
                    vert[v].distance = vert[u].distance + w;
                    vert[v].parent = u;
                }
            }
        }
        for (int j = 0; j < E; j++) {
            int u = graph[j].src;
            int v = graph[j].dest;
            int w = graph[j].weight;
            if (vert[u].distance != infinity && vert[v].distance > (vert[u].distance + w)) {
                System.out.println("Negative weight Cycle");
                return;
            }
        }
        printGraph(vert);
    }

    void printGraph(Vertex[] v) {
        for (int i = 0; i < V; i++) {
            System.out.println(v[i].vertex + "\t\t" + v[i].distance);
        }
    }
}
