package dp;

import java.util.Arrays;
import java.util.Collections;

public class LongestNonDecreasingSubSequence {
    private static int getsubsequenceLength(int[] a){

        Integer[] l=new Integer[a.length];
        l[0]=1;
        for (int i=1;i<a.length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                if(a[j]<a[i])
              max=Math.max(max,l[j]) ;
            }
            l[i]=1+max;
        }
        return Collections.max(Arrays. asList(l) ) ;
    }

    public static void main(String[] args) {
        int a[]={0,8,4,12,2,10,6,14,1,9};
        System.out.println(getsubsequenceLength(a));
    }
}
