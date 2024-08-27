public class Queue {

    State front_node, rear_node;

    public Queue() {
        this.front_node =  null;
        this.rear_node = null;
    }

    /**
     * adds the state or node to the queue.
     * @param state
     */
    public void Enqueue(State state) {

        int r = state.a;
        int c = state.b;
        State temp = new State(r, c);
        temp.PositionThing1(state.a_1, state.b_1);
        temp.PositionThing2(state.a_2, state.b_2);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp.configure_state(i, j, state.position[i][j]);
            }
        }

        if (rear_node == null) {
            rear_node = temp;
            front_node = temp;
            return;
        }
        rear_node.next = temp;
        rear_node = temp;
    }


    /**
     * removes the element from the queue
     * @return
     */
    public State Dequeue() {
        if (front_node == null) return null;
        State temp = front_node;
        front_node = front_node.next;
        if (front_node == null) rear_node = null;
        return temp;
    }

    /**
     * Returns count of states in the linked list.
     * @return
     */
    public int count() {
        State temp = front_node;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}