/*
 * Filename: NegativeCycle.java
 */

import java.util.Scanner;
/*
 * This program checks the given graph for a negative cycle. If it contains a negative cycle then it will
 * output "YES" else it will output "NO".
 * @author : Anushka Yadav (ay4034)
 */

public class NegativeCycle{

    static boolean track;
    static boolean hasNegativeCycle;

    /***
     * This function takes the input from the command line and stores it in their respective int array.
     * It then calls the FindNegativeCycle() method for further computation.
     * @param args
     */
    public static void main(String args[]){
//        System.out.println("hi");
        Scanner input_num = new Scanner(System.in);
        int vertices = input_num.nextInt();
        int edges = input_num.nextInt();
        input_num.nextLine();
//        System.out.println(vertices);
//        System.out.println(edges);

        int[] Cost = new int[edges];
        int[] Edge_U = new int[edges];
        int[] Edge_V = new int[edges];

        for(int k = 0; k<edges; k++){
            int edge_u = input_num.nextInt()-1;
            Edge_U[k] = edge_u;

            int edge_v = input_num.nextInt()-1;
            Edge_V[k] = edge_v;

            int weight_edge = input_num.nextInt();
            Cost[k] = weight_edge;
            input_num.nextLine();
        }

        int[] Vertice = new int[vertices];

        for (int i = 0; i<vertices; i++){
            Vertice[i] = 0;
//            input_num.nextLine();
        }
        String output = "";
        output = FindNegativeCycle(Edge_U, Edge_V, Cost, Vertice);
        System.out.println(output);
    }

    /***
     * This method finds the negative cycle in a graph by taking the sum of the weights and if the total comes down
     * to less than 0 then it has a negative cycle else it does not.
     * @param Edge_U
     * @param Edge_V
     * @param Cost
     * @param Vertice_dist
     * @return
     */
    public static String FindNegativeCycle(int[] Edge_U, int[] Edge_V, int[] Cost, int[] Vertice_dist){
//        System.out.println("hi");
        for(int l = 0; l<Vertice_dist.length; l++){
            Vertice_dist[l] = 10000;
        }
        Vertice_dist[0] = 0;

//        for(int p = 0; p<Vertice_dist.length; p++){
//            System.out.println(Vertice_dist[p]);
//        }

//        track = false;

        for (int n = 0; n < Vertice_dist.length -1; n++){

            track = false;

            for (int m = 0; m < Edge_U.length; m++){
//                System.out.println(edges);

                int cost_U = Vertice_dist[Edge_V[m]];
                int cost_V = Vertice_dist[Edge_U[m]] + Cost[m];

                if (cost_U > cost_V){
//                System.out.println("hello");
                    Vertice_dist[Edge_V[m]] = cost_V;
                    track = true;
                }
            }

            if (track == false){
//                System.out.println("hi");
                break;
            }
        }

        for (int j = 0; j < Edge_U.length; j++){

            int cost_U = Vertice_dist[Edge_V[j]];
            int cost_V = Vertice_dist[Edge_U[j]] + Cost[j];

            if (cost_U > cost_V){
//                System.out.println("hello");
                hasNegativeCycle = true;
            }
        }
        
        String return_result = "";
        
        if (hasNegativeCycle == true){
            return_result = "YES";
        }
        
        else if (hasNegativeCycle == false){
            return_result = "NO";
        }

        return return_result;

    }
}
