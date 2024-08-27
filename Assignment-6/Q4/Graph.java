public class Graph {
	int weight; // for indicating the weight
    boolean edgeTaken; // for indicating if the edge has been draw
    boolean selected; // if the edge is selected
    int vertexNumber; // the vertex number

    Graph(){
        this.weight =0;
        this.edgeTaken = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setEdgeTaken(boolean edgeTaken) {
        this.edgeTaken = edgeTaken;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isEdgeTaken() {
        return edgeTaken;
    }


}
