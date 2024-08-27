/*
 * Filename: NumPaths.java
 */

import java.util.Scanner;

/*
 * This program finds the total number of shortest paths from start node to the end node in a given graph.
 * This program uses breadth first search to find the paths.
 * @author : Anushka Yadav (ay4034)
 */

public class NumPaths{

    static int V;
    public static LinkedList[] adj;
    static boolean[] visited;
    static int[] distance;
    static int[] total_path;

    /**
     * creates an adjacency list, visited, distance and total_path of size vertices+1.
     * @param vertices
     */
    NumPaths(int vertices){
        this.V = vertices;
        adj = new LinkedList[V+1];
        visited = new boolean[V+1];
        distance = new int[V+1];
        total_path = new int[V+1];

        for(int j = 0; j<=V; j++){
            adj[j] = new LinkedList();
//            System.out.println(" j=" + j);
            total_path[j] = 0;
            distance[j] = 100000;
        }

    }

    /**
     * addEdge() method adds the edges to the adjacency list adj as a,b and b,a since it is an undirected graph.
     * @param a
     * @param b
     */
    public void addEdges(int a, int b){
        adj[a].add(b);
        adj[b].add(a);
//        System.out.println("a:"+a+" b:"+b);
    }

    /**
     * This method finds the total number of shortest path in the given graph.
     * @param start_node
     * @param end_node
     * @return : count of the total number of shortest paths found.
     */
    public static int totalShortestPath(int start_node, int end_node){
        Queue Q = new Queue();

        for(int i = 0; i <= V; i++){
            visited[i] = false;
//            System.out.println(visited[i]);
        }
        distance[start_node] = 0;
        total_path[start_node] = 1;
        visited[start_node] = true;
        Q.enQueue(start_node);

        while(!Q.isEmpty()){
//            System.out.println("present");
            start_node = Q.deQueue().value;
            LinkedList neigh_node = adj[start_node];

            for(int k = 0; k < neigh_node.size(); k++){
                int all_neighbors = neigh_node.get(k);
//                System.out.println(all_neighbors);
                if(visited[all_neighbors] == false){
                    visited[all_neighbors] = true;
                    Q.enQueue(all_neighbors);
                }

                if(distance[all_neighbors] > distance[start_node] + 1){
                    distance[all_neighbors] = distance[start_node] + 1;
                    total_path[all_neighbors] = total_path[start_node];
                }

                else {
                    if(distance[all_neighbors] == distance[start_node] + 1){
                        total_path[all_neighbors] += total_path[start_node];
                    }
                }
            }
        }
        return total_path[end_node];
    }


    /**
     * This is the main method that takes the input from the command line and calls the addEdge method and
     * the totalShortestPath() method for further computation.
     * In the end it outputs the total number of shortest path found.t
     * @param args
     */
    public static void main(String[] args){
        Scanner input_num = new Scanner(System.in);
        int vertices = input_num.nextInt();
        int edges = input_num.nextInt();

        NumPaths g = new NumPaths(vertices);
        input_num.nextLine();
        int start_node = input_num.nextInt();
        int end_node = input_num.nextInt();

        for(int i = 0; i<edges; i++){
            int a = input_num.nextInt();
            int b = input_num.nextInt();
            g.addEdges(a, b);
            input_num.nextLine();
        }
        int num_of_shortest_paths = totalShortestPath(start_node, end_node);
        System.out.println(num_of_shortest_paths);
    }
}
