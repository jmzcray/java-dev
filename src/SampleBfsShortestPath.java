/**
 * Created by d329312 on 2/03/2016.
 *
 * https://www.hackerrank.com/challenges/bfsshortreach
 *
 *
 Sample input:
 2
 4 2
 1 2
 1 3
 1
 3 1
 2 3
 2

 ---Explanation----
 2      // no. of test cases
 4 2    // no. of vertices (nodes) & no. of edges (links)
 1 2    // edge (link)
 1 3    // edge (link)
 1      // starting vertice (node)
 -----------------

 Sample output:
 6 6 -1
 -1 6

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class SampleBfsShortestPath {

    public static void main(String[] asd){

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t=0; t<testCases; t++){
            UndirectedGraph graph = new UndirectedGraph<Integer>();

            int N = scanner.nextInt();
            for(int n=1; n<=N; n++)
                graph.addVertex(n);

            long M = scanner.nextInt();
            for(int m=0; m<M; m++) {
                int ala = scanner.nextInt();
                int bala = scanner.nextInt();
                graph.addEdge(new Edge<Integer>(ala, bala, 6));
            }

            int S = scanner.nextInt();

            List<Integer> result = graph.djikstraWeightPathToAllVertices(S);
            printArray(result);
        }
    }

    private static void printArray(List<Integer> ar) {

        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static class DirectedGraph<T> {

        private HashMap<T, List<Edge<T>>> vertecies;

        public DirectedGraph() {

            vertecies = new HashMap<T, List<Edge<T>>>();
        }

        public void addVertex(T vertex) {

            if (!vertecies.keySet().contains(vertex)) {
                vertecies.put(vertex, new ArrayList<Edge<T>>());
            }
        }

        public void addEdge(Edge<T> edge) {

            vertecies.get(edge.startVertex).add(edge);
        }

        public void removeEdge(Edge<T> edge) {

            vertecies.get(edge.startVertex).remove(edge);
        }

        public List<Edge<T>> getAdj(T vertex) {

            return vertecies.get(vertex);
        }

        public Set<T> getAllVertecies() {

            return vertecies.keySet();
        }

        /**************
         * Algorithms *
         **************/

        public List<T> dfs(T startVertex) {

            List<T> visited = new ArrayList<T>();
            visited.add(startVertex);

            dfsHelp(startVertex, visited);

            return visited;
        }

        private void dfsHelp(T startVertex, List<T> visited) {

            for (Edge<T> edge : getAdj(startVertex)) {
                if (!visited.contains(edge.endVertex)) {
                    visited.add(edge.endVertex);
                    dfsHelp(edge.endVertex, visited);
                }
            }
        }

        public List<T> dfsStack(T startVertex) {

            List<T> dfsResult = new ArrayList<T>();

            Stack<T> stack = new Stack<T>();
            List<T> visited = new ArrayList<T>();
            stack.add(startVertex);
            visited.add(startVertex);

            while (!stack.isEmpty()) {
                T popedVertex = stack.pop();
                dfsResult.add(popedVertex);
                for (Edge<T> edge : getAdj(popedVertex)) {
                    if (!visited.contains(edge.endVertex)) {
                        stack.add(edge.endVertex);
                        visited.add(edge.endVertex);
                    }
                }
            }

            return dfsResult;
        }

        public List<T> bfs(T startVertex) {

            List<T> bfsResult = new ArrayList<T>();

            Queue<T> queue = new LinkedList<T>();
            List<T> visited = new LinkedList<T>();
            queue.add(startVertex);
            visited.add(startVertex);

            while (!queue.isEmpty()) {
                T popedVertex = queue.poll();
                bfsResult.add(popedVertex);
                for (Edge<T> edge : getAdj(popedVertex)) {
                    if (!visited.contains(edge.endVertex)) {
                        queue.add(edge.endVertex);
                        visited.add(edge.endVertex);
                    }
                }
            }

            return bfsResult;
        }

        public List<T> djikstra(T startVertex, T toVertex) {

            List<T> visited = new ArrayList<T>();
            // key - tekushtiq vrux, value - vurxut ot koito idva
            Map<T, T> djikstraResult = new HashMap<T, T>();
            Queue<Edge<T>> queue = new PriorityQueue<Edge<T>>();
            queue.add(new Edge<T>(null, startVertex, 0));
            while (!queue.isEmpty()) {
                Edge<T> edge = queue.poll();
                if (!visited.contains(edge.endVertex)) {
                    visited.add(edge.endVertex);
                    // dobavqne na pred6estvenika na poseteniq vrux
                    djikstraResult.put(edge.endVertex, edge.startVertex);
                    for (Edge<T> e : getAdj(edge.endVertex)) {
                        queue.add(new Edge<T>(e.startVertex, e.endVertex, e.weight + edge.weight));
                    }
                }
            }

            List<T> finalResult = new ArrayList<T>();
            T vertex = toVertex;
            finalResult.add(vertex);
            while (vertex != startVertex) {
                vertex = djikstraResult.get(vertex);
                finalResult.add(vertex);
            }

            return finalResult;
        }

        public List<Edge<T>> djikstraEdgePath(T startVertex, T toVertex) {

            List<T> visited = new ArrayList<T>();
            // key - tekushtiq vrux, value - vurxut ot koito idva
            Map<T, Edge<T>> djikstraResult = new HashMap<T, Edge<T>>();
            Queue<Edge<T>> queue = new PriorityQueue<Edge<T>>();
            queue.add(new Edge<T>(null, startVertex, 0));
            while (!queue.isEmpty()) {
                Edge<T> edge = queue.poll();
                if (!visited.contains(edge.endVertex)) {
                    visited.add(edge.endVertex);
                    // dobavqne na pred6estvenika na poseteniq vrux
                    djikstraResult.put(edge.endVertex, edge);
                    for (Edge<T> e : getAdj(edge.endVertex)) {
                        queue.add(new Edge<T>(e.startVertex, e.endVertex, e.weight + edge.weight));
                    }
                }
            }

            // get the path and revert the path
            Stack<Edge<T>> resultStack = new Stack<Edge<T>>();
            T vertex = toVertex;
            Edge<T> edge;
            while (vertex != startVertex) {
                edge = djikstraResult.get(vertex);
                resultStack.push(edge);
                vertex = edge.startVertex;
            }

            List<Edge<T>> result = new ArrayList<Edge<T>>();
            while (!resultStack.isEmpty()) {
                result.add(resultStack.pop());
            }

            return result;
        }

        public List<Integer> djikstraWeightPathToAllVertices(T startVertex){

            List<T> visited = new ArrayList<T>();
            // key - tekushtiq vrux, value - vurxut ot koito idva
            Map<T, Edge<T>> djikstraResult = new HashMap<T, Edge<T>>();
            Queue<Edge<T>> queue = new PriorityQueue<Edge<T>>();
            queue.add(new Edge<T>(null, startVertex, 0));
            while (!queue.isEmpty()) {
                Edge<T> edge = queue.poll();
                if (!visited.contains(edge.endVertex)) {
                    visited.add(edge.endVertex);
                    // dobavqne na pred6estvenika na poseteniq vrux
                    djikstraResult.put(edge.endVertex, edge);
                    for (Edge<T> e : getAdj(edge.endVertex)) {
                        queue.add(new Edge<T>(e.startVertex, e.endVertex, e.weight + edge.weight));
                    }
                }
            }

            List<Integer> result = new ArrayList<Integer>();
            for(T toVertex : getAllVertecies())
                if (!toVertex.equals(startVertex)){
                    if (djikstraResult.containsKey(toVertex)){
                        T vertex = toVertex;
                        Edge<T> edge;
                        int countWeight = 0;
                        while (!vertex.equals(startVertex)) {
                            edge = djikstraResult.get(vertex);
                            countWeight += 6;
                            vertex = edge.startVertex;
                        }
                        result.add(countWeight);
                    }
                    else {
                        result.add(-1);
                    }
                }

            return result;
        }

        public List<T> prim(T startVertex) {

            List<T> visited = new ArrayList<T>();
            // key - tekushtiq vrux, value - vurxut ot koito idva
            Map<T, T> primResult = new HashMap<T, T>();
            Queue<Edge<T>> queue = new PriorityQueue<Edge<T>>();
            queue.add(new Edge<T>(null, startVertex, 0));
            while (!queue.isEmpty()) {
                Edge<T> edge = queue.poll();
                if (!visited.contains(edge.endVertex)) {
                    visited.add(edge.endVertex);
                    // dobavqne na pred6estvenika na poseteniq vrux
                    primResult.put(edge.endVertex, edge.startVertex);
                    for (Edge<T> e : getAdj(edge.endVertex)) {
                        queue.add(new Edge<T>(e.startVertex, e.endVertex, e.weight));
                    }
                }
            }

            return visited;
        }
    }

    public static class UndirectedGraph<T> extends DirectedGraph<T> {

        @Override
        public void addEdge(Edge<T> edge) {
            Edge<T> reversedEdge = new Edge<T>(edge.endVertex, edge.startVertex, edge.weight);
            super.addEdge(edge);
            super.addEdge(reversedEdge);
        }
    }

    public static class Edge<T> implements Comparable {

        public T startVertex;
        public T endVertex;
        public int weight;

        public Edge(T startVertex, T endVertex, int weight) {

            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.weight = weight;
        }

        public boolean equals(Edge<T> edge) {

            return startVertex.equals(edge.startVertex) && endVertex.equals(edge.endVertex) && weight == edge.weight;
        }

        public int compareTo(Object e) {

            Edge<T> e2 = (Edge<T>) e;

            int result = 0;
            if (this.weight < e2.weight) {
                result = -1;
            }
            if (this.weight == e2.weight) {
                result = 0;
            }
            if (this.weight > e2.weight) {
                result = 1;
            }

            return result;
        }

        @Override
        public String toString() {

            return "(" + startVertex + ", " + endVertex + ", " + weight + ")";
        }
    }

}