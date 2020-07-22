package binarysearch;
/*Ceil-lub(least upper bound)
A={10,11,14,15,18,19,20,26,28,29},find floor of 17.it is 15.If element is found.it is its self floor.
 */
public class CeillingOfAnElementInASortedArray {
    //By using recurrsion
    public static int getTheCellingOfAnElement(int[] a, int low, int high, int element) {
        if (low > high)
            return low;
        int mid = low + ((high - low) / 2);//This is to save from overflow.//high+low
        if (a[mid] == element )                                           // --------   this formula will not work in some cases.When in array INTEGER.MAX number of elements will be there ,then it will be overflow.
            return mid;                                                  //      2
        else if (element < a[mid]) {
            high = mid - 1;
            return   getTheCellingOfAnElement(a, low, high, element);
        } else  {
            low = mid + 1;
            return getTheCellingOfAnElement(a, low, high, element);
        }

    }

    public static void main(String[] args) {
        int[] arr={10,11,14,15,18,19,20,26,28,29};
        System.out.println(arr[getTheCellingOfAnElement(arr,0,arr.length-1,27)]);
    }
}
