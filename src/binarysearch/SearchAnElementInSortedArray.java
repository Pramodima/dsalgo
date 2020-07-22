package binarysearch;

/*Since the array is sorted , we will use binary search here.*/
public class SearchAnElementInSortedArray {
    //By using recurrsion
    public static int getTheElementIndex(int[] a, int low, int high, int element) {
        if (low > high)
            return -1;
        int mid = low + ((high - low) / 2);//This is to save from overflow.//high+low
        if (a[mid] == element)                                     // --------   this formula will not work in some cases.When in array INTEGER.MAX number of elements will be there ,then it will be overflow.
            return mid;                                        //      2
        else if (element < a[mid]) {
            high = mid - 1;
          return   getTheElementIndex(a, low, high, element);
        } else  {
            low = mid + 1;
           return getTheElementIndex(a, low, high, element);
        }

    }

    //By using iteration
    private static int getTheElementIndexI(int[] a, int low, int high, int element) {
        while (low <=high) {
            int mid = low + ((high - low) / 2);//This is to save from overflow.//high+low
            if (a[mid] == element)                                            // --------   this formula will not work in some cases.When in array INTEGER.MAX number of elements will be there ,then it will be overflow.
                return mid;                                                  //      2
            else if ( element < a[mid]) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9};
        int low=0;
        int high=a.length-1;
        int element=9;
        System.out.println(getTheElementIndexI(a,low,high,element));
    }
}