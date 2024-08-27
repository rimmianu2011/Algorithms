/*
 * Filename: DoubleTrouble.java
 */
import java.util.Scanner;

/*
 * This program finds the shortest path the THINGS can take to exit the environment making sure the conditions
 * are fulfilled.
 * @author : Anushka Yadav (ay4034)
 */

public class DoubleTrouble {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension1 = scanner.nextInt();
        int dimension2 = scanner.nextInt();

        State state = new State(dimension1, dimension2);


        for (int i = 0; i < dimension1; i++) {
            String[] input_num = scanner.next().split("");
            for (int j = 0; j < dimension2; j++) {
//                if (input_num[j] == "."){
//                    state.configure_state(i, j, 0);
//                    break;
//                }
//                if (input_num[j] == "x"){
//                    state.configure_state(i, j, 1);
//                    break;
//                }
//                if(input_num[j] == "1"){
//                    state.configure_state(i, j, 1);
//                    state.PositionThing1(i, j);
//                    break;
//                }
//                if(input_num[j] == "2"){
//                    state.configure_state(i, j, 1);
//                    state.PositionThing2(i, j);
//                    break;
//                }
                switch (input_num[j]) {
                    case ".":
                        state.configure_state(i, j, 0);
                        break;
                    case "x":
                        state.configure_state(i, j, 1);
                        break;
                    case "1":
                        state.configure_state(i, j, 1);
                        state.PositionThing1(i, j);
                        break;
                    case "2":
                        state.configure_state(i, j, 1);
                        state.PositionThing2(i, j);
                        break;
                }
            }
        }
        BreadthFirstSearch(state);
    }

    /**
     *  This method implements breadth first search to find the shortest path as in moves possible to move out of
     *  the environment.
     * @param state
     * @return
     */
    public static int BreadthFirstSearch(State state) {

        State current_position = state;


        boolean[][][][] visited = new boolean[current_position.a][current_position.b][current_position.a][current_position.b];

        visited[state.a_1][state.b_1][state.a_2][state.b_2] = true;

        int[][][][] moves = new int[current_position.a][current_position.b][current_position.a][current_position.b];

        for (int v = 0; v < current_position.a; v++) {
            for (int i = 0; i < current_position.b; i++) {
                for (int j = 0; j < current_position.a; j++) {
                    for (int k = 0; k < current_position.b; k++) {
                        moves[v][i][j][k] = 1;
                    }
                }
            }
        }

        Queue Q = new Queue();

        Q.Enqueue(current_position);

        while (Q.count() != 0) {

            state = Q.Dequeue();

            LinkedList neighbors = state.getNeighborStates();

            for (int i = 0; i < neighbors.size(); i++) {
                State s = neighbors.get(i);

                if (!visited[s.a_1][s.b_1][s.a_2][s.b_2]) {
                    visited[s.a_1][s.b_1][s.a_2][s.b_2] = true;
                    Q.Enqueue(s);
                    moves[s.a_1][s.b_1][s.a_2][s.b_2] = moves[state.a_1][state.b_1][state.a_2][state.b_2] + 1;
                }

                if (s.ifEnds() == true) {
                    int output = moves[s.a_1][s.b_1][s.a_2][s.b_2];
                    System.out.println(output);
                    return 0;
                }
            }
        }

        System.out.println("STUCK");
        return 0;
    }

}
