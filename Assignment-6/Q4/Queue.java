public class Queue<Graph> {
	class Node{
	    public Graph value;
	    public Node next;
	    Node(Graph value, Node next){
	        this.value = value;
	        this.next = null;
	    }
	}
	Node front = null;
    Node end = null;

    /**
     * constructor for class Queue.
     */
    public Queue() {
        this.front = null;
        this.end = null;
    }

    // adds the elements to the queue
    public void enQueue(Graph ele) {
        Node t = new Node(ele, null);
        // if queue is full
        if (isEmpty()) {
        	front = t;
        } else {
        	 end.next = t;
        }
        
    }

    // removes the element from the queue.
    public Graph deQueue() {
        if(front == null){
            return null;
        }
        Graph item = front.value;
        if(end == front) {
            end = null;
        }
        front = front.next;
        return item;
    }


//    public boolean isFull() {
//        if (front == 0 && end == size() - 1) {
//            return true;
//        }
//        return false;
//    }
    
    public Graph peek() {
        if (front == null) {
            return null;
        }
        return front.value;
    }
    
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
