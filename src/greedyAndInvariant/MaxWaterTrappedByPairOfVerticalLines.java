package greedyAndInvariant;

//page 358,Element of programming interview,18.7
/*
An array of integers naturally defines a set of lines parallel to the Y-axis, starting from
x = 0 as illustrated in Figure 18.4(a). The goal of this problem is to find the pair of
lines that together with the X-axis "trap" the most water. See Figure 18.4(b) for an
example.

Solution : Let A be the array, and n its length. There is a straightforward 0(n3)
brute-force solution for each pair of indices ( i , j), i < j, the water trapped by the
corresponding lines is (j - i ) X min(A[i], A[j]), which can easily be computed in 0{n)
time. The maximum of all these is the desired quantity. This algorithm can easily be
improved to 0(n2) time by keeping the running minimum as we iterate over j.Same as Lardest rectangle
in histogram.

A good starting point is to consider the widest pair, i.e., 0 and n 1. We record the
corresponding amount of trapped water, i.e., ((« - 1) - 0) X min(A[0], A [n -1]). Suppose
A[0] < A[n - 1], Then for any k, the water trapped between 0 and k is less than the
water trapped between 0 and n— 1, so we focus our attention on the maximum water
that can be trapped between 1 and n - 1. The converse is true if A[0] > A[n - 1] we
need never consider n- 1 again. If A[0] = A[n - 1], we can eliminate both 0 and n - 1
from further consideration. We use this approach iteratively to continuously reduce
the subarray that must be explored, while recording the most water trapped so far.
In essence, we are exploring the best way in which to trade-off width for height.
For the given example, we begin with (0,17), which has a capacity of 1 X 17 = 17.
Since the left and right lines have the same height, namely 1, we can advance both, so
now we consider (1,16). The capacity is 2 X 15 = 30. Since 2 < 4, we move to (2,16).
The capacity is 1 X 14 = 14. Since 1 < 4, we move to (3,16). The capacity is 3 X 13 = 39.
Since 3 < 4, we move to (4,16). The capacity is 4 X 12 = 48. Future iterations, which
we do not show, do not surpass 48, which is the result.

* */
public class MaxWaterTrappedByPairOfVerticalLines {
    private static  int getMaxArea(int[] a){
        int i=0;
        int j=a.length-1;
        int max=0;
        while(j>i){
            int width=j-i;
            max=Integer.max(max,width*Integer.min(a[i],a[j]));
            if(a[i]<a[j])
                ++i;
            else if(a[i]>a[j])
                --j;
            else  {//a[i]==a[j]
                ++i;
                --j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int height[]={1, 2, 1, 3, 4, 4, 5, 6, 2,1, 3, 1, 3, 2,1, 2, 4, 1};
        final int maxArea = getMaxArea(height);
        System.out.println(maxArea);
    }
}


/*


                            |
                        |   |
                |   |   |   |                                   |
            |   |   |   |   |           \       |               |
    |       |   |   |   |   |   |       |       |   |       |   |
|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|
0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17

A graphical depiction of the array (1, 2, 1, 3, 4, 4, 5, 6, 2,1, 3, 1, 3, 2,1, 2, 4, 1).

* */