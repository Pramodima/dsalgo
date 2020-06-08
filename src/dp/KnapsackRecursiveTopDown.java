package dp;
/*
Bottom up: it fills a table with solutions to all smaller subproblems, but each of
them is solved only once.
Draw-Back
---------
An unsatisfying aspect of this approach is that solutions
to some of these smaller subproblems are often not necessary for getting a solution
to the problem given.

Since this drawback is not present in the top-down approach,
it is natural to try to combine the strengths of the top-down and bottom-up
approaches. The goal is to get a method that solves only subproblems that are
necessary and does so only once. Such a method exists; it is based on using memory
functions.
* */
public class KnapsackRecursiveTopDown {
    public int getKnapsackValue(int[] values,int[] weights,int i,int j){
        if(i==-1 || j==0){
            return 0;
        }
        if(i>values.length)
            return 0;
        if(j-weights[i]<0){
            return getKnapsackValue(values,weights,i-1,j) ;
        }

        return Integer.max(getKnapsackValue(values,weights,i-1,j) ,getKnapsackValue(values,weights,i-1,j-weights[i])+values[i]);

    }

    public static void main(String[] args) {
        KnapsackRecursiveTopDown nr=new KnapsackRecursiveTopDown();
        int[] values ={12,10,20,15};
        int[] weights ={2,1,3,2};
        System.out.println(nr.getKnapsackValue(values,weights,3,5));
    }
}





