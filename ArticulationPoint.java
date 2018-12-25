/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shivam
 */
public class ArticulationPoint {

    int V;
    Vertex[] graph;
    int time = 0;
    LinkedList[] edges;
    boolean[] visited;
    List<Vertex> articulation = new ArrayList<Vertex>();

    class Vertex {

        Vertex parent;
        int lowTime;
        int time;
        int val;
    }

    ArticulationPoint(int v) {
        this.V = v;
        graph = new Vertex[v];
        edges = new LinkedList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < v; i++) {
            graph[i] = new Vertex();
            graph[i].parent = null;
            graph[i].lowTime = -1;
            graph[i].time = -1;
            graph[i].val = i;
        }
        for (int i = 0; i < v; i++) {
            edges[i] = new LinkedList();
        }
    }

    private void addEdge(int u, int v) {
        edges[u].add(v);
        edges[v].add(u);
    }

    private void ArticulationUtil(int u) {
        graph[u].lowTime = time;
        graph[u].time = time;
        time++;
        visited[u] = true;
        int child = 0;
        Iterator<Integer> itr = edges[u].iterator();
        boolean isArticulationPoint = false;
        while (itr.hasNext()) {
            int v = itr.next();
            if (graph[u].parent!=null && v == graph[u].parent.val) {
                continue;
            }
            if (!visited[v]) {
                graph[v].parent = graph[u];
                child++;
                ArticulationUtil(v);
                if (graph[u].time <= graph[v].lowTime) {
                    isArticulationPoint = true;
                } else {
                    graph[u].lowTime = Math.min(graph[v].lowTime, graph[u].lowTime);
                }
            } else {
                graph[u].lowTime = Math.min(graph[v].lowTime, graph[u].lowTime);
            }
            if ((graph[u].parent == null && child >= 2) || (graph[u].parent != null && isArticulationPoint)) {
                articulation.add(graph[u]);
            }
        }
    }

    public static void main(String args[]) {
        ArticulationPoint acp = new ArticulationPoint(7);
        acp.addEdge(0, 1); 
        acp.addEdge(1, 2); 
        acp.addEdge(2, 0); 
        acp.addEdge(1, 3); 
        acp.addEdge(1, 4); 
        acp.addEdge(1, 6); 
        acp.addEdge(3, 5); 
        acp.addEdge(4, 5); 
        acp.ArticulationUtil(0);
        System.out.println("Articulation points are:: ");
        for(int i=0;i<acp.articulation.size();i++){
            System.out.print(acp.articulation.get(i).val+" ");
        }
    }
}
