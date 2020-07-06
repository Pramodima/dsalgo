package stack;

import static stack.LargestAreaUnderHistogram.getMaxAreaUnderHistogram;
/*
   A binary matrix of length n by m is given.We have to find max rectangular area in binary matrix.
   0 1 1 0
   1 0 0 1
   1 1 0 1
   1 1 0 0
   This problem is same as Max rectangular area in histogram.But here we have to take 4 histogram, as each line in the matrix is a histogram.
   We will add the heights of the buildings in each layer till we come to bottom layer.,If we find a building of zero height in any row , then that complete
   building hegiht accumulated from the prevous layer will be zero, as no build can hang in air , at least it should have foundation in that layer but not in air :).
   Let's see how these histograms  look like
   for first row
          -------------
     _____|_____|_____|_____      Here first and 4th   building has  heights  0 unit and 2nd and 3rd building has height 1 unit.
     1       2     3      4

    for second row
      -----             -----
     |_____|_____|_____|_____|      Here first and 4th   building has  heights  1 unit and 2nd and 3rd building have height 0 unit.Because , since 2nd and 3rd building has height 0 , we
        1     2     3      4                            can not add up first row values.As building in second row can not hang in air :).


    for third row
     -------           -------
     |     |------     |     |
     |_____|_____|_____|_____|      Here first and 4th   building has  heights  2 unit and 2nd  has height 1 unit and 3rd building has height 0 unit,due to the same reason :).
       1     2     3      4

 for third row
     -------
     |     |------
     |     |     |
     |_____|_____|__________      Here first    building has  heights  3 unit and 2nd  has height 2 unit and 3rd and 4th  building has height 0 unit,due to the same reason :).
       1     2     3      4
    Find the Max area in each histogram and take the max.
* */
public class MaxectangularAreaInBinaryMatrix {

    private static int getMaxArea(int[][] d,int n,int m){
        int[] histogram=d[0];
         int maxAreaUnderHistogram = getMaxAreaUnderHistogram(histogram);
        for (int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(d[i][j]!=0){
                 histogram[j]=histogram[j]+d[i][j];
                }
                else{
                    histogram[j]=0;
                }
            }
            maxAreaUnderHistogram=  Integer.max(maxAreaUnderHistogram,getMaxAreaUnderHistogram(histogram));

        }
        return maxAreaUnderHistogram;
    }

    public static void main(String[] args) {
        int[][] d={{0,1,1,0},{1,0,0,1},{1,1,0,1},{1,1,0,0}};
        final int maxArea = getMaxArea(d, 4, 4);
        System.out.println(maxArea);
    }
}
/*


* */