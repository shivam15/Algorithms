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
public class TopologicalSort {
    public static void main(String args[]){
        TopologicalSort g = new TopologicalSort(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g.topological();
    }
    private int V;
    LinkedList<Integer>[] graph;
    Stack<Integer> st;
    
    TopologicalSort(int v){
        this.V = v;
        graph = new LinkedList[v];
        for(int i=0;i<v;i++)
            graph[i] = new LinkedList();
        st = new Stack<Integer>();
    }
    
    void addEdge(int u,int v){
        graph[u].add(v);
    }
    void topological(){
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                topologicalUtil(visited, i); 
  
        while (st.empty()==false) 
            System.out.print(st.pop() + " "); 
    }
    
    void topologicalUtil(boolean[] visited,int v){
        visited[v] = true;
        Iterator<Integer> it = graph[v].iterator();
        while(it.hasNext()){
            int x = it.next();
            if(!visited[x]){
                topologicalUtil(visited,x);
            }
        }
        st.add(v);
    }
}
