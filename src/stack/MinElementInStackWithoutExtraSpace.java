package stack;

import java.util.Stack;

public class MinElementInStackWithoutExtraSpace {
    private int push(int min, int element, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(element);
            min=element;
        }
        else if(element<min){
            stack.push(2*element-min);//2*x-min
            min=element;
        }
        else if(element>min){
            stack.push(element);
        }
        return min;
    }
    private int pop(int min, Stack<Integer> stack){
        if(!stack.isEmpty()){
            Integer poppedElement = stack.pop();
            if(poppedElement!=min)
            min=2*min-poppedElement;
            else
                min=-1;
        }
        return min;
    }
    private int findMin(int min){
        return min;
    }

    public static void main(String[] args) {
        MinElementInStackWithoutExtraSpace obj=new MinElementInStackWithoutExtraSpace();
        int min=0;
        Stack<Integer> stack=new Stack<>();
         min = obj.push(min,5, stack);
        /* min = obj.push(min,3, stack);*/
        min= obj.pop(min,stack);
       /* min = obj.push(min,4, stack);
        min= obj.pop(min,stack);
        min = obj.push(min,1, stack);
        min = obj.push(min,8, stack);
        min = obj.push(min,-8, stack);
        min= obj.pop(min,stack);*/
        System.out.println(min);
    }
}
/**
 When we get a minimum element than min element,then we update the min element with the current minimum and put 2*currentElemnt -min.We can say this as a flag in the stack.

 Similarly, when we pop an element from stack , we check if it is not equal with the min element , that means the flag is there, so to find current minimun in the stack,

 we use the formula 2*min-flag(popped element/top of the stack), and assign it

 */
