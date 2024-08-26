/*
 * Filename: Stack.java
 */

/*
 * This is the stack implementation that is used in the MaxRectangle.java to push,
 * pop the values for calculation of the maximum area.
 * @author : Anushka Yadav
 */

class Stack
{
    private int arr[];
    private int top;
    private int capacity;

    Stack(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // push() method inserts the value in the array.
    public void push(int x){
        if (isFull()) {
            System.exit(-1);
        }
        arr[++top] = x;
    }

    // pop() mehtod gives the top value of the stack and removes it from the array.
    public int pop(){
        if (isEmpty()) {
            System.exit(-1);
        }
        return arr[top--];
    }

    // peek() method just returns the top value of the stack and does not remove it from the array.
    public int peek(){
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
        return -1;
    }

    // size() method returns the size of the stack(array in our case).
    public int size(){

        return top + 1;
    }

    // isEmpty() method checks if the stack has any element left in it.
    public boolean isEmpty(){

        return top == -1;
    }

    // isFull() method checks to see if the array or stack is full or not.
    public boolean isFull(){

        return top == capacity - 1;
    }
}
