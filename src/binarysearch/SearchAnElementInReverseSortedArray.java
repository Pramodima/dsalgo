package binarysearch;

public class SearchAnElementInReverseSortedArray {
    //By using recurrsion{9 8 7 6 5 4 3 2 1}
    public static int getTheElementIndex(int[] a, int low, int high, int element) {
        if (low > high)
            return -1;
        int mid = low + ((high - low) / 2);//This is to save from overflow.//high+low
        if (a[mid] == element)                                             // --------   this formula will not work in some cases.When in array INTEGER.MAX number of elements will be there ,then it will be overflow.
            return mid;                                                   //      2
        else if (element > a[mid]) {
            high = mid - 1;
           return getTheElementIndex(a, low, high, element);
        } else if (element < a[mid]) {
            low = mid + 1;
            return getTheElementIndex(a, low, high, element);
        }
        return -1;
    }

    //By using iteration
    private static int getTheElementIndexI(int[] a, int low, int high, int element) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);//This is to save from overflow.//high+low
            if (a[mid] == element)                                            // --------   this formula will not work in some cases.When in array INTEGER.MAX number of elements will be there ,then it will  overflow.
                return mid;                                                  //      2
            else if ( element > a[mid]) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={9,8,7,6,5,4,3,2,1};
        int low=0;
        int high=a.length-1;
        int element=6;
        System.out.println(getTheElementIndex(a,low,high,element));
    }
}
