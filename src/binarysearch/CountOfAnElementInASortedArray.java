package binarysearch;

public class CountOfAnElementInASortedArray {
    public static int getCount(int[] a) {
        int[] b = new int[1];
        FirstOccuranceOfElementInSortedArray.getTheElementIndex(a, 0, a.length - 1, 10, b);
        int firstOccurance = b[0];
        LastOccuranceOfElementInSortedArray.getTheElementIndex(a, 0, a.length - 1, 10, b);
        int lastOccurance = b[0];
        return lastOccurance - firstOccurance + 1;
    }

    public static void main(String[] args) {
        int[] a={2,4,5,10,10,10,10,20};
        System.out.println( getCount(a));
    }
}
