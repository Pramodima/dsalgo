package binarysearch;
//Consider a sorted array with duplicate elements.We have to find the first occurance of the element.
public class FirstOccuranceOfElementInSortedArray {
    public static void getTheElementIndex(int[] a, int low, int high, int element,int[] b) {
        if (low > high) {
            return;
        }
        int mid = low + ((high - low) / 2);//This is to save from overflow. //high+low
        if (a[mid] == element) {                                           // --------   this formula will not work in some cases.When in array INTEGER.MAX number of elements will be there ,then it will be overflow.
            b[0]=mid;high=mid-1;                                          //      2
             getTheElementIndex(a, low, high, element,b);
        }
        else if (element < a[mid]) {
            high = mid - 1;
               getTheElementIndex(a, low, high, element,b);
        } else  {
            low = mid + 1;
             getTheElementIndex(a, low, high, element,b);
        }

    }

    public static void main(String[] args) {
        int[] a={2,4,5,10,10,10,20};
        int[] b=new int[1];
        getTheElementIndex(a,0,a.length-1,10,b);
        System.out.println(b[0]);
    }
}
