package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/*
Find largest spans of a stock.(Maximum consecutive days for which stock price was less or equal of current day price.)
We can see this problem as nearest largest/greatest element in left.And in this process , we will check how many elements we crossed
towards the left.We will take the index of that nearest greatest element and substract it from the index of the current  element.
* */
public class StockSpanProblem {
    public  List<Integer> getNextGreatestElementInLeft(int[] a){
        Stack<Pair> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<=a.length-1;i++){

            while(!stack.isEmpty()){
                Pair element = stack.peek();
                if(a[i]<element.getElement()){
                    result.add(i-element.getIndex());
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result.add(i-(-1));
            }
            stack.push(new Pair(a[i],i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a={1,3,2,4};
        int[] b={ 10, 4, 5, 90, 120, 80};
        StockSpanProblem sp=new StockSpanProblem();
        System.out.println(sp.getNextGreatestElementInLeft(b));
    }
    class Pair{
        public Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }

        int element;
        int index;

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return element == pair.element &&
                    index == pair.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(element, index);
        }


    }
}
