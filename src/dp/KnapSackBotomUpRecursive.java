package dp;
//cdhhc comment
/* Naive brute force solution. Recursively
 include or exclude each item to try every
 possible combination, starting from 0.so it's
 name is bottom up

Bottom up: it fills a table with solutions to all smaller subproblems, but each of
them is solved only once.
 */
public class KnapSackBotomUpRecursive {
    public int getKnapsackValue(int[] values,int[] weights,int i,int target){

        if(i>=values.length)
            return 0;
        if(target-weights[i]<0){
            return getKnapsackValue(values,weights,i+1,target) ;
        }

        return Integer.max(getKnapsackValue(values,weights,i+1,target) ,getKnapsackValue(values,weights,i+1,target-weights[i])+values[i]);


    }

    public static void main(String[] args) {
        KnapSackBotomUpRecursive nr=new KnapSackBotomUpRecursive();
        int[] values ={12,10,20,15};
        int[] weights ={2,1,3,2};
        System.out.println("KnapSackBotomUpRecursive value is "+nr.getKnapsackValue(values,weights,0,5));
    }
}
/*
Our code looks at every possible combination, which is not very
efficient. The question that must be asked is: how bad is it?
Each item can be included it or not included. This causes the
recursion to branch in two different ways. Like several other
problems that have been discussed, we get 2^0+2^1+2^2+2^3
 or 2^4(2^n), where n is the depth of our recursion. In this case,
our recursion iterates over the items array. Therefore, n is the
number of items, which gives us a time complexity of O(2^n).
The code performs reasonably well in terms of space complexity.
The only extra space that we are using is the recursive stack,
which is at most, height O(n).
* */