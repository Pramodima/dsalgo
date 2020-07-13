package recursion;

import java.util.Stack;
/*
Here assumption/hypothesis is- we take top of the stack and reverse the remaining stack.
and induction step is - put the top element at bottom of the stack.
Base case is if there is only one element stack is already reversed.

Now we get a new problem ie. the induction step  - put the top element at bottom of the stack.
It is itself a recurrsive problem.
Here assumption/hypothesis is-Take out the top element, reduce the stack size and put the element at buttom.
induction is- push the top element at top.
Base case is-If stack is empty push the element at bottom.
* */
public class ReverseAStackWithoutExtraSpace {
    public void reverseStack(Stack<Integer> stack){
        if(stack.size()==1)// Since it is one element stack, it is already reversed.Base case.
            return;
        Integer topElement=0;
        if(!stack.isEmpty()){         //Assumption/hypothesis - remove the top and reverse the remaining
             topElement = stack.pop();
            reverseStack(stack);
        }
        insertInBottom(stack,topElement);// Induction is - put the top element at bottom.
    }

    private void insertInBottom(Stack<Integer> stack, Integer element) {
        if(stack.isEmpty()){    //Base cae -Stack is empty
            stack.push(element);
            return;
        }
        if(!stack.isEmpty()){
            Integer topElement = stack.pop();//Assumption/hypothesis- pop one element ,reduce the stack size, and insert at bottom.
            insertInBottom(stack,element);
            stack.push(topElement);//induction- push the pooped element in the top.
            return;
        }

    }

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(1);s.push(2);s.push(3);
        System.out.println(s);
        ReverseAStackWithoutExtraSpace rs=new ReverseAStackWithoutExtraSpace();
        rs.reverseStack(s);
        System.out.println(s);
    }
}
