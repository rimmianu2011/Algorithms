/*
 * Filename: Prerequisites.java
 */
import java.util.Scanner;

/*
 * This program finds the longest sequence of prerequisites possible from the given graph and it does so by using
 * the depth first approach.
 * @author : Anushka Yadav (ay4034)
 */

public class Prerequisites{

    static LinkedList[] adj;
    static boolean[] visited;
    static int nodes;
    static int[] dp;

    /**
     * Creates the adjacency list using Linked List, boolean visited[], and dp[] of size nodes+1.
     * @param vertices
     */
    Prerequisites(int vertices){
        nodes = vertices;
        adj = new LinkedList[nodes + 1];
        visited = new boolean[nodes + 1];
        dp = new int[nodes + 1];
        for (int k = 0; k<nodes+1; k++){
            adj[k] = new LinkedList();
            visited[k] = false;
        }
    }

    /**
     * this method adds the directed edges to the adj[].
     * @param a
     * @param b
     */
    public void addEdges(int a, int b){
        adj[a].add(b);
//        adj[b].add(a);
    }

    /**
     * this method runs recursively to find the ongest possible path in the given graph and computes the length
     * using dynamic approach.
     * @param n : node
     * @param visited : boolean[]
     * @return : dp[]
     */
    public static int[] dfs(int n, boolean[] visited){
        visited[n] = true;
        LinkedList all_neigh = adj[n];

        for(int j = 0; j<all_neigh.size(); j++){
            int ele = all_neigh.get(j);
            if (!visited[ele]) {
                dfs(ele, visited);
            }

            dp[n] = Math.max(dp[n], 1 + dp[ele]);
        }
//        System.out.println("a");
        return dp;

    }

    /**
     * this method calls the dfs() method only if a node hasn't been visited yet to compute the longest path
     * in a directed graph and outputs the longest path.
     * @param q
     */
    public static void longestPath(int q){
//        System.out.println("hi");
        for(int w = 1; w<=nodes; w++){
            if(!visited[w]){
                dfs(w, visited);
            }
        }
        int longest_prereq = 0;

        for(int t = 0; t <= nodes; t++){
            longest_prereq = Math.max(longest_prereq, dp[t]);
        }
        System.out.println(longest_prereq+1);
//        return 0;
    }

    /**
     * this is the main function that takes the input from the command line and creates an adjacency list and calls
     * the addEdge() method to add the edges to the Linked List adj[].
     * Then it calls the longestPath() method which finds the longest path.
     * @param args
     */
    public static void main(String[] args){
        Scanner input_num = new Scanner(System.in);
        int vertices = input_num.nextInt();

        Prerequisites p = new Prerequisites(vertices);

        input_num.nextLine();
        int count = 1;

        for(int i = 0; i<vertices; i++){
            while(true){
                int a = input_num.nextInt();
                if(a == 0){
                    count += 1;
                    break;
                }
                else{
                    p.addEdges(count, a);
//                    System.out.println(a);
                }
            }
        }
        longestPath(vertices);
    }
}
