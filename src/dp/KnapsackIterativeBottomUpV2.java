package dp;
//bottom up using 1d array
/*
This problem can also be optimized in terms of space in the
same way as with the Fibonacci problem. A close examination
of our solution indicates that cache values are only looked up
where i = i - 1. Therefore, we can reduce our solution to only
using a 1D array .
* */
public class KnapsackIterativeBottomUpV2 {
    public int getKnapsackValue(int[] values,int[] weights,int target){
        int[] cache1=new int[target+1];
        for(int i1=0;i1<=values.length;i1++) {
            int[] cache2=new int[target+1];
            for (int j1 = 0; j1 <= target; j1++) {

                if (i1 != 0 && j1 != 0) {

                    if (j1 - weights[i1-1] < 0) {
                        cache2[j1] = cache1[j1];
                    } else {
                        cache2[j1] = Integer.max(cache1[j1], cache1[j1 - weights[i1-1]] + values[i1-1]);
                    }

                }
            }
            cache1=cache2;
        }
      return cache1[target];
    }

    public static void main(String[] args) {
        KnapsackIterativeBottomUpV2 nr=new KnapsackIterativeBottomUpV2();
        int[] values ={12,10,20,15};
        int[] weights ={2,1,3,2};
        final int knapsackValue = nr.getKnapsackValue(values, weights, 5);
        System.out.println("knapsackValue for bottom up using 1 d array "+knapsackValue);
    }
}
