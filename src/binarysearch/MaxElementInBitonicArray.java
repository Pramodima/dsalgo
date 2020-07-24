package binarysearch;

/*Bitoinc array=Monotonically increasing  and then monotonically decreasing.
Eg. A={1,2,6,8,9,7,5,4,3}-increasing upto 9 then decreasing upto 3.LIke below picture
     /\
    /  \
   /    \
  /      \
 /
/
  We have to find  the max element in the above bitonic array.It is 9.But observe one property
  that 9 is also a peak element.because it is gretaer than its left and right.

  So the problem is same as find a peak element in an unsorted array..
 */
public class MaxElementInBitonicArray {
    public static int getPeak(int[] a){
      return  PeakElementInAnUnsortedArray.getPeak(a);
    }

    public static void main(String[] args) {
    int[] a={1,2,6,8,9,7,5,4,3};
        System.out.println(a[getPeak(a)]);
    }
}
