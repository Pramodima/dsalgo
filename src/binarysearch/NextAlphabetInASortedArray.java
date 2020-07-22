package binarysearch;
//This is same as ceilling logic, but with charcter and little modification.In case of ceilling the same element is it's floor and celling but here we always return the next element.
//So we return mid+1;
public class NextAlphabetInASortedArray {
    //By using recurrsion
    public static int getTheCellingOfAnElement(char[] a, int low, int high, int element) {
        if (low > high)
            return low==a.length?-1:low;//To handle out of bound exception.For last element.it's next does not exist

        int mid = low + ((high - low) / 2);//This is to save from overflow.//high+low
        if (a[mid] == element && mid<high)                                           // --------   this formula will not work in some cases.When in array INTEGER.MAX number of elements will be there ,then it will be overflow.
            return mid+1;                                                  //      2
        else if (element < a[mid]) {
            high = mid - 1;
            return   getTheCellingOfAnElement(a, low, high, element);
        } else  {
            low = mid + 1;
            return getTheCellingOfAnElement(a, low, high, element);
        }
    }

    public static void main(String[] args) {
        char[] arr={'c','d','f','h','j','l'};
        final int index = getTheCellingOfAnElement(arr, 0, arr.length - 1, 'd');
        if(index!=-1)
        System.out.println(arr[index]);
        else
            System.out.println("not found ");
    }
}
