package binarysearch;
/*
An array is said to be nearly sorted if i th element may be in  i th  ,i+1 th or i-1 th position

Example- 10,30,20,40,50,60.Here 20 should be in 1st position , but 20 is in 2nd position.So the array is nearly sorted.

Question is serach a nearly sorted array.We will do here Binary search with little modification.
*/
public class SearchAnearlySortedArray {
    //By using recurrsion
    public static int getTheElementIndex(int[] a, int low, int high, int element) {
        if (low > high)
            return -1;
        int mid = low + ((high - low) / 2);
        if (a[mid] == element)
            return mid;
        if (mid+1<high && a[mid+1] == element)
            return mid+1;
        if (mid-1>low && a[mid-1] == element)
            return mid-1;
        else if (element < a[mid]) {
            high = mid - 2;
            return   getTheElementIndex(a, low, high, element);
        } else  {
            low = mid + 2;
            return getTheElementIndex(a, low, high, element);
        }

    }

    public static void main(String[] args) {
      int  arr[] =  {10, 3, 40, 20, 50, 80, 70};
        System.out.println(getTheElementIndex(arr,0,arr.length-1,10));
    }
}
