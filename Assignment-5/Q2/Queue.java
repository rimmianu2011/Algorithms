public class Queue{
//    int size_array = 5;

    Node front;
    Node end;

    /**
     * constructor for class Queue.
     */
    public Queue() {
        this.front = null;
        this.end = null;
    }

    // adds the elements to the queue
    public void enQueue(int ele) {
        Node t = new Node(ele);
        // if queue is full
        if(end == null){
            end = t;
            front = t;
        }
        else {
            end.next = t;
            end = t;
        }
    }

    // removes the element from the queue.
    public Node deQueue() {
        if(front == null){
            return null;
        }
        Node t = front;
        front = front.next;
        if(front == null){
            end = null;
        }
        return t;
    }


//    public boolean isFull() {
//        if (front == 0 && end == size() - 1) {
//            return true;
//        }
//        return false;
//    }

    // checks the queue to see if it is empty.
    public boolean isEmpty() {
        if (front == null)
            return true;
        else
            return false;
    }

    // gets the size of the queue: total elements in the queue so far.
    public int size(){
        Node n = front;
        int size_queue = 0;
        while(n != null){
            size_queue += 1;
            n =n.next;
        }
        return size_queue;
    }
}