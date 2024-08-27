/***
 * Creates a graph with the weighted edges.
 */
class WeightedEdge {
    //    WeightedGraph
    public int edge_v;
    public int edge_u;
    public int weight;
    public int type;

    public WeightedEdge() {
    }

    public WeightedEdge(int u, int v, int weight, int x) {
        this.edge_u = u;
        this.edge_v = v;
        this.weight = weight;
        this.type = x;
    }
    /**
     * Get one vertex of the edge
     * @return vertex v
     */
    public int get_V() {
        return edge_v;
    }

    /**
     * Get another vertex of the edge
     * @param i the chosen vertex
     * @return vertex u
     */
    public int get_U(int i) {
        if (i == edge_v) {
            return edge_u;
        }
        if (i == edge_u) {
            return edge_v;
        }
        return -1;
    }
}