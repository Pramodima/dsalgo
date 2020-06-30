package stack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 Nearest greatest element to the right
* */
public class NearestLargestElementInRight {

    public static List<Integer> getNextGreatestElement(int[] a){
        Stack<Integer> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        // we will start from right.
        for(int i=a.length-1;i>=0;i--){

            while(!stack.isEmpty()){
                Integer element = stack.peek();
                if(a[i]<element){
                    result.add(element);
                    break;
                }
                else{
                    stack.pop();//we are removing the element as it is less than the current element,and it will not be help
                    //of any precedding element also
                }
            }
            if(stack.isEmpty()){
                result.add(-1);//If there is no element in stack ,we can not compare the current number with any previous number,
                //so we add -1 in stack
            }
            stack.push(a[i]);// we will put elements in stack , so that previous elemnts can be comapred with stack elements.
        }
        Collections.reverse(result);//since we have started from right , so we need to reverse the result.
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