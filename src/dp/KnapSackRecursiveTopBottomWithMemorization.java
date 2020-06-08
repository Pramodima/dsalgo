package dp;
/*
This method solves a given problem in the top-down manner but, in addition,
maintains a table of the kind that would have been used by a bottom-up dynamic
programming algorithm. Initially, all the table’s entries are initialized with a spe-
cial “null” symbol to indicate that they have not yet been calculated. Thereafter,
whenever a new value needs to be calculated, the method checks the correspond-
ing entry in the table first: if this entry is not “null,” it is simply retrieved from the
table; otherwise, it is computed by the recursive call whose result is then recorded
in the table.
The following algorithm implements this idea for the knapsack problem. After
initializing the table, the recursive function needs to be called with i = n (the
number of items) and j = W (the knapsack capacity).
* */
public class KnapSackRecursiveTopBottomWithMemorization {
        public int getKnapsackValue(int[] values,int[] weights,int[][] cache,int i,int j){
            if(i==0 || j==0){
                cache[i][j]=0;
                return 0;
            }
            if(i>values.length)
                return 0;
            if(cache[i][j]>-1)
                return cache[i][j];
             int knapsackValue=0;
            if(j-weights[i-1]<0){
                  knapsackValue = getKnapsackValue(values, weights, cache, i - 1, j);
            }
            else {
                knapsackValue = Integer.max(getKnapsackValue(values, weights, cache, i - 1, j), getKnapsackValue(values, weights, cache, i - 1, j - weights[i-1]) + values[i-1]);
            }
            cache[i][j]=knapsackValue;
            return knapsackValue;
        }

        public static void main(String[] args) {
            KnapSackRecursiveTopBottomWithMemorization nr=new KnapSackRecursiveTopBottomWithMemorization();
            int[] values ={12,10,20,15};
            int[] weights ={2,1,3,2};
            int[][] cache={{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1}};
            System.out.println(nr.getKnapsackValue(values,weights,cache,4,5));
        }
}
