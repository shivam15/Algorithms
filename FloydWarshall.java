/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author shivam
 */
public class FloydWarshall {

    final static int INF = 99999;
    final static int v = 4;

    public static void main(String args[]) {
        FloydWarshall fw = new FloydWarshall();
        int graph[][] = {{0, 5, INF, 10},
        {INF, 0, 3, INF},
        {INF, INF, 0, 1},
        {INF, INF, INF, 0}
        };
        fw.doFloyd(graph);
    }

    void doFloyd(int[][] graph) {
        int[][] dist = new int[v][v];
        int i;
        for (i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (graph[i][j] != INF && i != j) {
                    dist[i][j] = i;
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        for (i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                for (int k = 0; k < v; k++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        dist[i][j] = dist[k][j];
                    }
                }
            }
        }
        //Detect negative cycle
        for (i = 0; i < v; i++) {
            if (graph[i][i] < 0) {
                System.out.println("Negative cycle");
                return;
            }
        }
        printGraph(graph);
        printShortestPath(0, 1, dist);
    }

    void printShortestPath(int start, int end, int[][] path) {
        System.out.println("Actual path - between " + start + " " + end);
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(end);
        while (true) {
            end = path[start][end];
            if (end == -1) {
                return;
            }
            stack.addFirst(end);
            if (end == start) {
                break;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pollFirst() + " ");
        }

    }

    void printGraph(int[][] arr) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (arr[i][j] == INF) {
                    System.out.print("INF" + " ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}
