package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 Nearest greatest element to the left
* */
public class NearestLargestElementInLeft {
    public static List<Integer> getNextGreatestElement(int[] a){
        Stack<Integer> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<=a.length-1;i++){

            while(!stack.isEmpty()){
                Integer element = stack.peek();
                if(a[i]<element){
                    result.add(element);
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result.add(-1);
            }
            stack.push(a[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a={1,3,2,4};
        System.out.println(getNextGreatestElement(a));
    }
}
/*
Time Complexity: O(n).
The worst case occurs when all elements are sorted in decreasing order. If elements are sorted in decreasing order, then every element is processed at most 4 times.

    Initially pushed to the stack.
    Popped from the stack when next element is being processed.
    Pushed back to the stack because the next element is smaller.
    Popped from the stack in step 3 of algorithm.

 */

