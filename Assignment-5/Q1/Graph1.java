import java.util.*;
import java.util.Scanner;

class ConnectGraph {
    static ArrayList<ArrayList<Integer>> adj;
    static int V;

    ConnectGraph(int v) {
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(V + 1);
//        System.out.println("V :" + V);
        for (int i = 1; i <= V + 1; i++){
            adj.add(new ArrayList<Integer>());
//            System.out.println("i :"+ i);
        }
    }

    void addEdge(int u, int v) {
//        System.out.println("u :"+ u);
//        System.out.println("v :"+ v);
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    public static void dfs(int j, boolean visited[]) {
        visited[j] = true;

        Iterator<Integer> i = adj.get(j).iterator();
        int k = 0;
        while (i.hasNext()) {
            k += 1;
            int n = i.next();
            if (!visited[n])
                dfs(n, visited);
        }
//        System.out.println(k);
    }
    public static int DFS() {
        boolean visited[] = new boolean[V+1];

        int count = 0;
        for (int i = 1; i <= V; ++i) {
            if (visited[i] == false) {
                count += 1;
                dfs(i, visited);
            }
        }
        count = count - 1;
        return count;
//        System.out.println("components:"+ count);
    }


    public static void main(String[] args) {

        Scanner input_num = new Scanner(System.in);
        int length = input_num.nextInt();
        int edges = input_num.nextInt();

        int V = length;

        ConnectGraph g = new ConnectGraph(V);
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


