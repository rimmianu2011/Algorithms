/*
 * Filename: ConnectGraph.java
 */
import java.util.Scanner;
/*
 * This program finds the minimum number of edges required to make the given graph connected.
 * For this, depth first approach is used which finds the dfs components.
 * @author : Anushka Yadav (ay4034)
 */

class ConnectGraph {
    static LinkedList[] adj;
    static boolean[] visited;
    static int V;

    ConnectGraph(int v) {
        this.V = v;
        adj = new LinkedList[V + 1];
//        System.out.println("V :" + V);
        for (int i = 1; i < V + 1; i++){
            adj[i] = new LinkedList();
//            System.out.println("i :"+ i);
        }
    }

    /**
     * This method adds the edges to the linked list in both the directions since it is a
     * bi-directional graph.
     * @param a
     * @param b
     */
    void addEdge(int a, int b) {
//        System.out.println("u :"+ u);
//        System.out.println("v :"+ v);

        adj[a].add(b);
        adj[b].add(a);
    }

    /**
     * This is the depth first recursive function which checks all the nodes and marks them as true
     * after it is visited.
     * @param j
     * @param visited
     */
    public static void dfs(int j, boolean[] visited) {
        visited[j] = true;

//        Iterator<Integer> i = adj.get(j).iterator();
        LinkedList i = adj[j];
        int k = 0;
        for(int l = 0; l < i.size(); l++){
            k += 1;
            int all_neighbors = i.getVal(l);
            if(!visited[all_neighbors]){
                dfs(all_neighbors, visited);
            }
        }
    }

    /**
     * This method checks if the node has been visited, if not then it calls the actual dfs method.
     * After all the nodes have been visited it returns the count to the main function which is the
     * minimum number of edges needed to complete the graph.
     * @return
     */
    public static int DFS() {
        boolean visited[] = new boolean[V+1];

        int count = 0;
        for (int i = 1; i < V+1; ++i) {
            if (visited[i] == false) {
                count += 1;
                dfs(i, visited);
            }
        }
        count = count - 1;
        return count;
//        System.out.println("components:"+ count);
    }

    /**
     * This is the main function which takes the input entered on the command line and calls the respective
     * functions for further computation.
     * @param args
     */
    public static void main(String[] args) {

        Scanner input_num = new Scanner(System.in);
        int length = input_num.nextInt();
        int edges = input_num.nextInt();

//        int V = length;

        ConnectGraph g = new ConnectGraph(length);
//        System.out.println("edges: "+ edges);
        for (int i = 0; i<edges; i++){
//            System.out.println("i: "+ i);
//            input_num.nextLine();
            int a = input_num.nextInt(); //10
            int b = input_num.nextInt();
            g.addEdge(a, b);
            input_num.nextLine();
        }

        int total_edges = DFS();
        System.out.println(total_edges);
    }
}


