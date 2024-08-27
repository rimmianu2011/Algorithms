import java.util.Scanner;

public class Daycare {
	static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = "";
        boolean result;
        
        int n = sc.nextInt(); // students
        int a = sc.nextInt(); // hats
        int b = sc.nextInt(); // mittens
        int c = sc.nextInt(); // jackets
        
        
        int vertices = a + b + c + 2; // total vertices of the graph
        String[] resultingEdges = new String[4 * n]; 
        Graph[][] graph = new Graph[vertices][vertices]; // adj matrix 
        int[][] inputs = new int[3 * n][]; //holds the inputs in the form of an array - for convenience of mapping
        int[] options = new int[n]; // for storing number of options of each child
        
        int indexofEdges = 0;
        String checkEdge;
        boolean edgeFound = false;
        int index = 0;

        if (a < n || c < n || b < n) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < resultingEdges.length; i++) {
            	resultingEdges[i] = " ";
            }

            //create the graph
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    graph[i][j] = new Graph();
                    graph[i][j].setEdgeTaken(false);
                    graph[i][j].setVertexNumber(i);
                    graph[i][j].setSelected(false);
                }
            }
            
            sc.nextLine();

            // read lines of input and puts them index wise in input array
            for (int i = 0; i < inputs.length; i++) {
                String[] line = sc.nextLine().split(" ");
                inputs[i] = new int[line.length - 1];
                for (int j = 0; j < line.length - 1; j++) {
                	inputs[i][j] = Integer.parseInt(line[j]);
                }
            }

            // storing total options for each child in an array - for convenience 
            int s = 0;
            for (int i = 0; i < inputs.length; i = i + 3) {
            	options[s] = inputs[i].length + inputs[i + 1].length + inputs[i + 2].length;
                s++;
            }

            int totalStudents = n;
            do {
                int forCheck = Integer.MAX_VALUE; //infinity
                int i;
                int minIndex = 0;
                
                //finding min number of options available 
                for (i = 0; i < options.length; i++) {
                    if (options[i] < forCheck) {
                        forCheck = options[i];
                    }
                }
                
                // recording index of students having min options
                for (minIndex = 0; minIndex < options.length; minIndex++) {
                    if (options[minIndex] == forCheck) {
                        break;
                    }
                }
                // fill graph
                if (createGraph(graph, n, a, b, c, inputs, minIndex)) {
                    result = true;
                } else {
                    // if returns false
                    result = false;
                    System.out.println("NO");
                    break;
                }
                options[minIndex] = Integer.MAX_VALUE;
                totalStudents--;
                int resultIndex;

                // checking for matches
                for (int k = 0; k < graph.length; k++) {
                    for (int j = 0; j < graph.length; j++) {
                        if (graph[k][j].isEdgeTaken() == true && graph[k][j].getWeight() > 0 && graph[k][j].isSelected() == true) {
                        	checkEdge = k + " " + j;
                            for (int h = 0; h < resultingEdges.length; h++) {
                                if (!resultingEdges[h].equals(checkEdge)) { //if the resulting edge is not equal to the current edge - means outfit is not repeated
                                	edgeFound = false;
                                    continue;
                                } else {
                                	edgeFound = true; // if it matches, that means the outfit is seen before - so we break
                                    break;
                                }
                            }
                            if (edgeFound == false) {
                            	resultingEdges[indexofEdges] = checkEdge; //update the resulting edges if not seen before - means mark the outfit as seen
                            	indexofEdges++;
                            }
                        }
                    }
                }
                
                //for creating the output string from the edge
                for (int h = index; h < index + 4; h++) {
                    int des = Integer.parseInt(resultingEdges[h].split(" ")[1]);
                    if (des < graph.length - 1) {
                        if (des <= a) {
                            str = str.concat(des + " ");
                        } else if (des >= a + 1 && des <= a + b) {
                            resultIndex = des - a;
                            str = str.concat(resultIndex + " ");
                        } else if (des >= a + b + 1) {
                            resultIndex = des - (a + b);
                            str = str.concat(resultIndex + "");
                        }
                    }
                }
                index = index + 4;
                str = str.concat("\n");
            } while (totalStudents > 0);
            if (result == true) {
                System.out.println("YES");
                System.out.print(str);
            }
        }
    }

    public static boolean createGraph(Graph[][] graph, int n, int a, int b, int c, int[][] inputs, int index) {
        index =index*3;
        for( int j =0 ; j < inputs[index].length ;j++) {
            graph[0][inputs[index][j]].weight = 1;
        }

        for( int i =0 ; i < inputs[index].length ;i++){
            for( int j =0 ; j < inputs[index+1].length ;j++) {
                graph[inputs[index][i]][inputs[index+1][j]+a].weight = 1;
            }
        }

        for( int i =0 ; i < inputs[index+1].length ;i++){
            for( int j =0 ; j < inputs[index+2].length ;j++) {
                graph[inputs[index+1][i]+a][inputs[index+2][j]+ a+ b].weight = 1;
            }
        }

        for( int i =0; i < inputs[index+2].length ;i++){
            graph[inputs[index+2][i]+ a+ b][graph.length-1].weight=1;
        }
        // check for repeats
        if(findMatches(graph, graph[0][0], graph[graph.length-1][graph.length-1], inputs, index)){
            return true;
        }
        return false;
    }

    public static boolean findMatches(Graph[][] graph, Graph source, Graph destination, int[][] inputs, int index) {
        // doing Breadth first search
        if(BFS(graph, source, destination, inputs, index)){
            return true;
        }
        return false;
    }

    private static boolean BFS(Graph[][] graph, Graph source, Graph destination, int[][] inputs, int index) {
        boolean reached = false;
        index = index*3;
        
        Queue<Graph> queue = new Queue<Graph>();
        queue.enQueue(source);
        source.setEdgeTaken(true);
        
        while (!queue.isEmpty()){
        	Graph edgeChosen = queue.deQueue();
            for( int vertex = 1;  vertex < graph.length ; vertex++){
                // if the edge is present but not taken - take it 
                if( graph[edgeChosen.getVertexNumber()][vertex].weight > 0 && graph[edgeChosen.getVertexNumber()][vertex].isEdgeTaken() == false ){
                    graph[edgeChosen.getVertexNumber()][vertex].setSelected(true);
                    queue.enQueue(graph[vertex][vertex]);
                    
                    if( vertex == destination.getVertexNumber()){
                    	reached = true;
                        graph[edgeChosen.getVertexNumber()][vertex].setEdgeTaken(true);
                    }else {
                        for (int i = 0; i < vertex; i++) {
                            if ( vertex != destination.getVertexNumber()) {
                                graph[i][vertex].setEdgeTaken(true);
                            }
                        }
                    }
                    
                    for(int i = 0; i < graph.length; i++) {
                        if (graph[edgeChosen.getVertexNumber()][i].isSelected() == false) {
                            graph[edgeChosen.getVertexNumber()][i].weight = 0;
                        }
                    }
                    break;
                }

            }
        }
        // if the destination is reached
        for( int v =0 ; v < graph.length ;v++){
            if( graph[v][destination.getVertexNumber()].isEdgeTaken()==true && reached==true){
                return true;
            }

        }
        return false;
    }

}
