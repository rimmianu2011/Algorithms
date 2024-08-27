class LinkedList {
    State start;
    State next;
    State end;

    public LinkedList() {
    }

    /***
     * add the state at the end of the linked list
     * @param new_data
     */
    public void add(State state) {

        int r = state.a;
        int c = state.b;
        State new_n = new State(r, c);
        new_n.PositionThing1(state.a_1, state.b_1);
        new_n.PositionThing2(state.a_2, state.b_2);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                new_n.configure_state(i, j, state.position[i][j]);
            }
        }
        new_n.next = null;

        /*
         * Check the Linked List,
         * if it is empty,
         * then make a new node as the start.
         */
        if (start == null) {
            start = new_n;
            end = new_n;
            return;
        }
        State last_ele = start;

        while (last_ele.next != null) {
            last_ele = last_ele.next;
        }
        last_ele.next = new_n;
        end = new_n;
        return;
    }

    /**
     * this method returns the total number of nodes in a linked list.
     *
     * @return
     */
    public int size() {
        State t = start;
        int size_a = 0;
        while (t != null) {
            size_a++;
            t = t.next;
        }
        return size_a;
    }

    public State get(int index) {
        State current = start;
        int c = 0;

        while (current != null) {
            if (c == index)
                return current;
            c++;
            current = current.next;
        }
        assert(false);
        return null;
    }

    public String toString() {
        String str = new String();
        State current = start;
        if (current == null) {
            return null;
        }

        while(current != null) {
            current = current.next;
        }

        return null;
    }
}