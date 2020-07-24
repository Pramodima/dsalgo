package binarysearch;
/*Let A={-2, 0, 2, 4, 6, 7, 9}.Int his array some some elements are equal to index.
Find them.Here we take index as element.And the rest will work as Binary Search.
 */
public class SearchASortedArrayForEntryEqualToItsInex {
    private static int getTheElementIndexI(int[] a, int low, int high) {
        while (low <=high) {
            int mid = low + ((high - low) / 2);//This is to save from overflow.//high+low
            if (a[mid] == mid)                                            // --------   this formula will not work in some cases.When in array INTEGER.MAX number of elements will be there ,then it will be overflow.
                return mid;                                                  //      2
            else if ( mid < a[mid]) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={-2, 1, 2, 4, 6, 7, 9};
        final int theElementIndex = getTheElementIndexI(a, 0, a.length - 1);
        System.out.println(theElementIndex);
    }
}
