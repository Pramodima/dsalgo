package binarysearch;
/*
Implement a function which takes as input a floating point value/integer and returns its
square root.
* */
public class RealSquareRoot {
    public static double squareRoot(double x) {
// Decides the search range according to x’s value relative to 1.(9.
        double left, right;
        if (x < 1.0) {
            left = x;
            right = 1.0;
        } else { // x >= 1 . <9.
            left = 1.0;
            right = x;
        }
// Keeps searching as long as left < right , within tolerance.
        while (compare(left, right) == Ordering.SMALLER) {
            double mid = left + 0.5 * (right - left);
            double midSquared = mid * mid;
            if (compare(midSquared, x) == Ordering.EQUAL) {
                return mid;
            } else if (compare(midSquared, x) == Ordering.LARGER) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private static enum Ordering {SMALLER, EQUAL, LARGER}

    private static Ordering compare(double a, double b) {
        final double EPSILON = 0.00001;
// Uses normalization for precision problem.
        double diff = (a - b) / b;
        return diff < -EPSILON
                ? Ordering.SMALLER
                : (diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL);
    }

    public static void main(String[] args) {
        final double sqrt = squareRoot(26.8);
        System.out.println(sqrt);
    }
}
