package dp;
//bottom up using 2d array
/*
Bottom up: it fills a table with solutions to all smaller subproblems, but each of
them is solved only once.
Draw-Back
---------
An unsatisfying aspect of this approach is that solutions
to some of these smaller subproblems are often not necessary for getting a solution
to the problem given.

 */
public class KnapsackIterativeBottomUP {
    public void getKnapsackValue(int[] values,int[] weights,int[][] cache,int target){
        for(int i1=0;i1<=values.length;i1++) {
            for (int j1 = 0; j1 <= target; j1++) {

                if (i1 != 0 && j1 != 0) {

                    if (j1 - weights[i1-1] < 0) {
                        cache[i1][j1] = cache[i1 - 1][j1];
                    } else {
                        cache[i1][j1] = Integer.max(cache[i1 - 1][j1], cache[i1 - 1][j1 - weights[i1-1]] + values[i1-1]);
                    }

                }
            }
        }

    }

    public static void main(String[] args) {
        KnapsackIterativeBottomUP nr=new KnapsackIterativeBottomUP();
        int[] values ={12,10,20,15};
        int[] weights ={2,1,3,2};
        int[][] cache=new int[5][6];
        nr.getKnapsackValue(values,weights,cache,5);
        System.out.println(cache[4][5]);
    }
}
