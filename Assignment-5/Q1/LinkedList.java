public class LinkedList {

    Node head;

    /**
     * contructor for class Linkedlist.
     */
    LinkedList(){
        this.head = null;
    }

    /**
     * adds the node to the linkedlist.
     * @param data
     * @return
     */
    public LinkedList add(int data) {
        Node new_node = new Node(data);

        if (this.head == null) {
            this.head = new_node;
        }

        else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return this;
    }

    /**
     * gets the length of the linked list.
     * @return
     */
    public int size() {
        int size = 0;
        Node curr = this.head;
        while(curr!=null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    /**
     * gets the list.
     * @return
     */
    public int[] get() {
        Node n = this.head;
        int tempArray[] = new int[this.size()];
        int i = 0;
        while(n!=null) {
            tempArray[i] = n.data;
            n = n.next;
            i++;
        }
        return tempArray;
    }

    /**
     * gets the the value at the specified index.
     * @param index_data
     * @return
     */
    public int getVal(int index_data){
        Node c = head;
        int num = 0;
        while (c != null){
            if(num == index_data){
                return c.data;
            }
            num += 1;
            c = c.next;
        }
//        assert(false);
        return -1;
    }
}


class Node {
    int data;
    Node next;

    /**
     * contructor for class Node that creates node objects.
     * @param data
     */
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}