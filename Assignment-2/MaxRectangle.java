/*
 * Filename: MaxRectangle.java
 */

//import package.Stack;
import java.util.Scanner;

/*
 * This program finds the maximum rectangle in a histogram.
 * @author : Anushka Yadav
 */

public class MaxRectangle{

    public int[] x;
    public int[] y;

    /***
     * main() method takes the input co-ordinates from the command line along with the length
     * of the inputs. It stores the x-coordinates in the array names 'x' and y-coordinates in
     * the array named 'y'.
     * It then calls the maxRectangleArea() method and passes 'x' and 'y' arrays along with the
     * input size as parameters.
     * Once the maximum area has been computed it is then returned and printed as output on
     * the command line.
     * @param args : command line arguments.
     */

    public static void main(String[] args){
        Scanner input_num = new Scanner(System.in);
        int length = input_num.nextInt();
        int[] x = new int[length];
        int[] y = new int[length];

        for(int i = 0; i<length; i++){
            int a = input_num.nextInt();
            int b = input_num.nextInt();
            input_num.nextLine();

            x[i] = a;
            y[i] = b;
        }
        int area = maxRectangleArea(x, y, length);
        System.out.println(area);

    }

    /***
     * In this method the y value which is the height is pushed into the stack if the stack is emtpy
     * or the stack.peek() value is less than the y value.
     *
     * If the stack.peek() value is not less than the y value i.e. the height we pop the top most value
     * from the stack. Then, we check if the stack is empty, if it is then we get the width(from the current histogram bar
     * till the left most bar) and compute the area.
     *
     * If the computed area is greater than the maxArea, we will update the area, else we won't.
     *
     * If the stack is not empty we compute the area of the closest left bar of the y value(height) and get the
     * width of it, then compute the value and repeat the above step to update the maxArea.
     *
     * If the next value in the stack is still greater than the y value we will get the area of the bars where
     * the height will be the y value and the width will be till the height we just popped.
     *
     * This will continue until we have iterated over all the heights in the y-coordinates array.
     *
     * Once the for-loop ends we will go to the while loop to check if there are any values still left in the stack.
     * If the stack is still full we will start popping each value one by one and compute the area. We will update
     * the maxArea if we find a value greater than that, else we won't.
     *
     * At last, we will return the maxArea.
     *
     * @param xx : this is the array that has the x-coordinates.
     * @param y : this is the array that has the y-coordinates.
     * @param height : this is the input size.
     * @return : returns the maxArea.
     */

    public static int maxRectangleArea(int[] xx, int[] y, int size_input) {
        int l = size_input;
        int[] x = xx;

        Stack stack = new Stack(l);
        int length_heights = y.length;
        int maxArea = 0;
        for (int i = 1; i < length_heights;) {
            if(stack.isEmpty() || y[stack.peek()] <= y[i]){
                stack.push(i);
                i += 2;
            }
            else{
                int top = stack.pop();
                if(stack.isEmpty()){
                    int width = x[i-1]-x[1];
                    maxArea = Math.max(maxArea, y[top]* width);
                }
                else{
                    int width = x[i] -x[stack.peek()+1];
                    maxArea = Math.max(maxArea, y[top]*width);
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()){
                maxArea = Math.max(maxArea, y[top]*x[top-1]);
            }
            else{
                maxArea = Math.max(maxArea, y[top]*(x[top-1] -x[stack.peek()] - 1));
            }
        }
        return maxArea;
    }
}

