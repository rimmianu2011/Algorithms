/*
 * Filename: SpanTree.java
 */

import java.util.Scanner;
/*
 * This program finds the minimum spanning tree if there exists one. If found then it will output the total weight
 * else it will output -1 which indicates that no spanning tree could be found.
 * @author : Anushka Yadav (ay4034)
 */
public class SpanTree{
    public static int vertice_node;
    public static int edge_node;
    public static LinkedList[] adjacencyList;
    public static WeightedEdge[] edges;

    static int cost = 0;

    static int[] indexes;

    static int[] total_nodes;
    public static LinkedList[] kruskal_set;

    public SpanTree(){

    }

    /***
     * This is the constructor for the class SpanTree.
     * @param Vertices : number of vertices
     * @param Edges : number of edges
     */
    public SpanTree(int Vertices, int Edges) {

        this.vertice_node = Vertices;
        this.edge_node = Edges;

        edges = new WeightedEdge[Edges];
        indexes = new int[Vertices];
        adjacencyList = new LinkedList[Vertices];
        total_nodes = new int[Vertices];
        kruskal_set = new LinkedList[Vertices];

        for (int i = 0; i < Vertices; i++) {
            adjacencyList[i] = new LinkedList();
            kruskal_set[i] = new LinkedList();
            kruskal_set[i].add(i);
        }
        for (int k = 0; k < Vertices; k++){
            indexes[k] = k;
            total_nodes[k] = 1;
        }
        for (int j = 0; j < Edges; j++) {
            edges[j] = new WeightedEdge();
        }

    }

    /***
     * This is the main function that takes the input from the command line and calls the respective function
     * for making a spanning tree.
     * @param args
     */
    public static void main(String args[]){
        Scanner input_num = new Scanner(System.in);

        int vertices = input_num.nextInt();
        int total_edges = input_num.nextInt();

        SpanTree tree = new SpanTree(vertices, total_edges);
//        WeightedEdge weight_edge = new WeightedEdge();
        for (int i = 0; i < total_edges; i++){
            int edge_u = input_num.nextInt()-1;
            int edge_v = input_num.nextInt()-1;
            int weight = input_num.nextInt();
            int span = input_num.nextInt();
            tree.addWeighted(edge_u, edge_v, weight, i, span);
            tree.normalEdges(edge_u, edge_v);
            input_num.nextLine();
        }

        tree.createSpanningTree(vertices,total_edges);
    }

    /***
     * This function calls the methods for the creation of spanning tree.
     * @param vertices
     * @param total_edges
     */
    public static void createSpanningTree(int vertices, int total_edges){
        SpanTree tree = new SpanTree();
        boolean val = tree.SpanTreeContruct(0);
//        System.out.println(val);

        if (val == true){
//            System.out.println("createSpanningTree");
            tree.MergeSort(edges, 0, edge_node - 1);
            System.out.println(tree.Kruskal_algorithm());
        }
        else{
            System.out.println(-1);
        }
    }

    /***
     * Used to sort the edges for further computation.
     * @param edges
     * @param left
     * @param right
     */
    public static void MergeSort(WeightedEdge edges[], int left, int right) {
        if (left < right)
        {
            int m = (left+right)/2;
//            System.out.println(m);
            MergeSort(edges, left, m);
            MergeSort(edges , m+1, right);
            Merge(edges, left, m, right);
        }
    }

    public static void Merge(WeightedEdge edge_list[], int left, int m, int right) {
        int m1 = m - left + 1;
        int m2 = right - m;

        WeightedEdge Left_side[] = new WeightedEdge [m1];
        WeightedEdge Right_side[] = new WeightedEdge [m2];

        for (int i = 0; i < m1; ++i){
            Left_side[i] = edges[left + i];
        }

        for (int j = 0; j < m2; ++j) {
            Right_side[j] = edges[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < m1 && j < m2) {
            if (Left_side[i].weight <= Right_side[j].weight) {
                edge_list[k] = Left_side[i];
                i++;
            }
            else {
                edge_list[k] = Right_side[j];
                j++;
            }
            k++;
        }

        while (i < m1) {
            edges[k] = Left_side[i];
            i++;
            k++;
        }

        while (j < m2) {
            edges[k] = Right_side[j];
            j++;
            k++;
        }
    }

    /***
     * This is the main method where the kruskal's algorithm has been implemented for the spanning tree.
     * @return weight_edge : total weight of the minimum spanning tree.
     */
    public static int Kruskal_algorithm() {
        int weight_edge = 0;

        for (int j = 0; j < edge_node; j++) {
            int get_V = edges[j].get_V();
            int get_U = edges[j].get_U(get_V);
            int a = find_node(get_V);
            int b = find_node(get_U);
            int c = edges[j].type;

            if (c == 1 && a != b) {
//                System.out.println("hi");
                combine(get_V, get_U);
                weight_edge = weight_edge + edges[j].weight;

            }
            else if (c == 1) {
//                System.out.println("hey");
                if(a == b) {
                    return -1;
                }
            }
        }

        for (int i = 0; i < edge_node; i++) {
            int get_V = edges[i].get_V();
            int get_U = edges[i].get_U(get_V);
            int a = find_node(get_V);
            int b = find_node(get_U);
            int c = edges[i].type;

            if (c == 0 && a != b){
                combine(get_V, get_U);
                weight_edge = weight_edge + edges[i].weight;
            }
        }

        return weight_edge;
    }

    public static void combine(int edge_u, int edge_v) {
        int a = total_nodes[indexes[edge_u]];
        int b = total_nodes[indexes[edge_v]];

        if (a > b) {

            kruskal_set[indexes[edge_u]] = kruskal_set[indexes[edge_u]].join(kruskal_set[indexes[edge_u]],
                    kruskal_set[indexes[edge_v]]);
            total_nodes[indexes[edge_u]] = total_nodes[indexes[edge_u]] + total_nodes[indexes[edge_v]];
            LinkedList set_temp = kruskal_set[indexes[edge_v]];

            int total_count = total_nodes[indexes[edge_v]];
            for (int i = 0; i < total_count; i++) {
                int node = set_temp.get(i);

                indexes[node] = indexes[edge_u];
            }
        }

        else {
            kruskal_set[indexes[edge_v]] = kruskal_set[indexes[edge_v]].join(kruskal_set[indexes[edge_v]],
                    kruskal_set[indexes[edge_u]]);
            total_nodes[indexes[edge_v]] += total_nodes[indexes[edge_u]];

            LinkedList set_temp = kruskal_set[indexes[edge_u]];

            int total_count = total_nodes[indexes[edge_u]];
            for (int i = 0; i < total_count; i++) {
                int node = set_temp.get(i);
                indexes[node] = indexes[edge_v];
            }
        }
    }

    public static int find_node(int v) {
        return indexes[v];
    }

    public static boolean SpanTreeContruct(int start_edge){
        boolean visited_nodes[] = new boolean[vertice_node];
        int counter = 1;

        Queue Q = new Queue();

        Q.enQueue(start_edge);
        visited_nodes[start_edge] = true;

        while (!Q.isEmpty()) {
            int popped_edge = Q.deQueue().value;
//            System.out.println(popped_edge);

            LinkedList neighbors = adjacencyList[popped_edge];

            for (int v = 0; v < neighbors.size(); v++) {
                int node_neighbors = neighbors.get(v);
//                System.out.println(node_neighbors);

                if (!visited_nodes[node_neighbors]) {
                    visited_nodes[node_neighbors] = true;
                    counter++;
                    Q.enQueue(node_neighbors);
                }
            }
        }
//        System.out.println(vertice_node);
        if (counter == vertice_node) {
            return true;
        }
        else {
            return false;
        }
    }

    /***
     * This method creates a list of edges along with the weight.
     * @param u
     * @param v
     * @param weight
     * @param index
     * @param span_type
     */
    public static void addWeighted(int u, int v, int weight, int index, int type) {
        edges[index].edge_u = u;
        edges[index].edge_v = v;
        edges[index].weight = weight;
        edges[index].type = type;
    }

    /***
     * this method creates an adjacency list without the weights for a bi-directional graph.
     * @param v
     * @param w
     */
    public void normalEdges(int u, int v) {
        adjacencyList[u].add(v);
        adjacencyList[v].add(u);
    }
}
