package binarysearch;
/*
Write a program which takes a nonnegative integer and returns the largest integer
whose square is less than or equal to the given integer. For example, if the input is
16, return 4; if the input is 300, return 17, since 172 = 289 < 300 and 182 = 324 > 300.
The time complexity is that of binary search over the interval [0, k], i.e., O(logk).
* */
public class ComputeTheIntegerSquareRoot {
    public static int squareRoot(int k) {
        long left = 0, right = k;
// Candidate interval [left, right] where everything before left has
// square <= k, and everything after right has square > k.
        while (left <= right) {
            long mid = left + ((right - left) / 2);
            long midSquared = mid * mid;
            if (midSquared <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)left - 1;
    }

    public static void main(String[] args) {
        final int sqr = squareRoot(26);
        System.out.println(sqr);
    }
}
