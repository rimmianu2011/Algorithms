class LinkedList{
    Node head;
    Node next;
    Node tail;

    //    public class Node{
//        int value;
//        Node next;
//        Node(int value){
//            this.value = value;
//            this.next = null;
//        }
//    }
    public LinkedList(){
    }

    /**
     * adds the node to the linkedlist.
     * @param data
     * @return
     */
    public LinkedList add(int data){
        Node x = new Node(data);
        x.next = null;
        if(this.head == null){
            this.head = x;
            this.tail = x;
//            return;
        }
        else{
            Node end = head;
            while(end.next != null){
                end = end.next;
            }
            end.next = x;
        }
        return this;
    }

    /**
     * gets the size of the linked list.
     * @return
     */
    public int size(){
        Node t = head;
        int total_size = 0;
        while (t != null){
            total_size += 1;
            t = t.next;
        }
        return total_size;
    }

    /**
     * gets the node at the specified index from the linked list.
     * @param index_data
     * @return
     */
    public int get(int index_data){
        Node c = head;
        int num = 0;
        while (c != null){
            if(num == index_data){
                return c.value;
            }
            num += 1;
            c = c.next;
        }
        assert(false);
        return -1;
    }

    public LinkedList join(LinkedList l1, LinkedList l2) {
        l1.tail.next = l2.head;
        l1.tail = l2.tail;
        return l1;
    }
}

class Node{
    int value;
    Node next;

    Node(int value){
        this.value = value;
        this.next = null;
    }
}