public class State{

    int a_1, a_2, b_1, b_2;

    int a, b;

    int position[][];

    State next;
    public State() {}


    /**
     * This contructor for State which takes four inputs and builds the next state.
     * @param a_1
     * @param b_1
     * @param a_2
     * @param b_2
     */
    public State(int a_1, int b_1, int a_2, int b_2) {
        this.a_1 = a_1;
        this.b_1 = b_1;
        this.a_2 = a_2;
        this.b_2 = b_2;
        this.next = null;
    }

    public State(int dimension1, int dimension2) {
        a = dimension1;
        b = dimension2;
        this.position = new int[dimension1][dimension2];
    }

    public State(State state) {
        this.a_1 = state.a_1;
        this.b_1 = state.b_1;
        this.a_2 = state.a_2;
        this.b_2 = state.b_2;

        this.next = null;

        this.a = state.a;
        this.b = state.b;
        this.position = new int[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                this.configure_state(i, j, state.position[i][j]);
            }
        }
    }

    public void configure_state(int i, int j, int val) {
        this.position[i][j] = val;
    }

    /**
     * This method puts thing1 at the specified position.
     * @param a_1
     * @param b_1
     */
    public void PositionThing1(int a_1, int b_1) {
        this.a_1 = a_1;
        this.b_1 = b_1;
    }


    /**
     * This method puts thing2 at the specified position.
     * @param a_2
     * @param b_2
     */
    public void PositionThing2(int a_2, int b_2) {
        this.a_2 = a_2;
        this.b_2 = b_2;
    }

    /***
     * This method finds the possible neighboring states.
     * @return returns an array of all the possible neighbors or states.
     */
    public LinkedList getNeighborStates() {
        LinkedList all_neighbors = new LinkedList();


        /**
         * The following condition is for WEST direction.
         */
        if (a_1 - 1 >= 0 && a_2 - 1 >= 0) {

            /**
             * This condition is for when THING1 is not movable and THING2 is movable.
             */
            if (position[a_1 - 1][b_1] == 1 && position[a_2 - 1][b_2] == 0) {
                State t_node = new State(this);
                t_node.position[a_2][b_2] = 0;
                t_node.position[a_2 - 1][b_2] = 1;
                t_node.a_2--;
                all_neighbors.add(t_node);
            }

            /**
             * This condition is for when THING1 is movable and THING2 is not movable.
             */
            else if (position[a_1 - 1][b_1] == 0 && position[a_2 - 1][b_2] == 1) {
                State t_node = new State(this);
                t_node.position[a_1][b_1] = 0;
                t_node.position[a_1 - 1][b_1] = 1;
                t_node.a_1--;
                all_neighbors.add(t_node);
            }

            /**
             * This condition is for when THING1 is movable and THING2 is movable.
             */
            else if (position[a_1 - 1][b_1] == 0 && position[a_2 - 1][b_2] == 0) {
                State t_node = new State(this);
                t_node.position[a_1 - 1][b_1] = 1;
                t_node.position[a_1][b_1] = 0;
                t_node.position[a_2 - 1][b_2] = 1;
                t_node.position[a_2][b_2] = 0;
                t_node.a_1--;
                t_node.a_2--;
                all_neighbors.add(t_node);
            }
        }


        /**
         * The following condition is for EAST direction.
         */
        if (a_1 + 1 <= (a - 1) && a_2 + 1 <= (a - 1)) {

            /**
             * This condition is for when THING1 is not movable and THING2 is movable.
             */
            if (position[a_1 + 1][b_1] == 1 && position[a_2 + 1][b_2] == 0) {
                State t_node = new State(this);
                t_node.position[a_2][b_2] = 0;
                t_node.position[a_2 + 1][b_2] = 1;
                t_node.a_2++;
                all_neighbors.add(t_node);
            }


            /**
             * This condition is for when THING1 is movable and THING2 is not movable.
             */
            else if (position[a_1 + 1][b_1] == 0 && position[a_2 + 1][b_2] == 1) {
                State t_node = new State(this);
                t_node.position[a_1][b_1] = 0;
                t_node.position[a_1 + 1][b_1] = 1;
                t_node.a_1++;
                all_neighbors.add(t_node);
            }


            /**
             * This condition is for when THING1 is movable and THING2 is movable.
             */
            else if (position[a_1 + 1][b_1] == 0 && position[a_2 + 1][b_2] == 0) {
                State t_node = new State(this);
                t_node.position[a_1 + 1][b_1] = 1;
                t_node.position[a_1][b_1] = 0;
                t_node.position[a_2 + 1][b_2] = 1;
                t_node.position[a_2][b_2] = 0;
                t_node.a_1++;
                t_node.a_2++;
                all_neighbors.add(t_node);
            }
        }


        /**
         * The following conditions are for NORTH direction.
         */
        if (b_1 - 1 >= 0 && b_2 - 1 >= 0) {


            /**
             * This condition is for when THING1 is not movable and THING2 is movable.
             */
            if (position[a_1][b_1 - 1] == 1 && position[a_2][b_2 - 1] == 0) {
                State t_node = new State(this);

                t_node.position[a_2][b_2 - 1] = 1;
                t_node.position[a_2][b_2] = 0;
                t_node.b_2--;
                all_neighbors.add(t_node);
            }


            /**
             * This condition is for when THING1 ismovable and THING2 is not movable.
             */
            else if (position[a_1][b_1 - 1] == 0 && position[a_2][b_2 - 1] == 1) {
                State t_node = new State(this);

                t_node.position[a_1][b_1 - 1] = 1;
                t_node.position[a_1][b_1] = 0;
                t_node.b_1--;

                all_neighbors.add(t_node);
            }


            /**
             * This condition is for when THING1 is movable and THING2 is movable.
             */
            else if (position[a_1][b_1 - 1] == 0 && position[a_2][b_2 - 1] == 0) {
                State t_node = new State(this);

                t_node.position[a_1][b_1 - 1] = 1;
                t_node.position[a_1][b_1] = 0;
                t_node.position[a_2][b_2 - 1] = 1;
                t_node.position[a_2][b_2] = 0;
                t_node.b_1--;
                t_node.b_2--;

                all_neighbors.add(t_node);
            }
        }


        /**
         * The following conditions are for SOUTH direction.
         */
        if (b_1 + 1 <= (b - 1) && b_2 + 1 <= (b - 1)) {


            /**
             * This condition is for when THING1 is not movable and THING2 is movable.
             */
            if (position[a_1][b_1 + 1] == 1 && position[a_2][b_2 + 1] == 0) {
                State t_node = new State(this);
                t_node.position[a_2][b_2 + 1] = 1;
                t_node.position[a_2][b_2] = 0;
                t_node.b_2++;
                all_neighbors.add(t_node);
            }


            /**
             * This condition is for when THING1 is movable and THING2 is not movable.
             */
            else if (position[a_1][b_1 + 1] == 0 && position[a_2][b_2 + 1] == 1) {
                State t_node = new State(this);
                t_node.position[a_1][b_1 + 1] = 1;
                t_node.position[a_1][b_1] = 0;
                t_node.b_1++;
                all_neighbors.add(t_node);
            }


            /**
             * This condition is for when THING1 not movable and THING2 is movable.
             */
            else if (position[a_1][b_1 + 1] == 0 && position[a_2][b_2 + 1] == 0) {
                State t_node = new State(this);
                t_node.position[a_1][b_1 + 1] = 1;
                t_node.position[a_1][b_1] = 0;
                t_node.position[a_2][b_2 + 1] = 1;
                t_node.position[a_2][b_2] = 0;
                t_node.b_1++;
                t_node.b_2++;
                all_neighbors.add(t_node);
            }
        }
        return all_neighbors;
    }


    public boolean ifEnds() {
        if (a_1 == 0 && a_2 == 0) {
            return true;
        }
        if (a_1 == (a - 1) && a_2 == (a - 1)) {
            return true;
        }
        if (b_1 == 0 && b_2 == 0) {
            return true;
        }
        if (b_1 == (b - 1) && b_2 == (b - 1)){
            return true;
        }
        return false;
    }
}