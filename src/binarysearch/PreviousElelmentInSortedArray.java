package binarysearch;
/*
//This is same as floor logic, but with charcter and little modification.In case of floor the same element is it's floor and celling but here we always return the previous element.
//So we return mid-1;
* */
public class PreviousElelmentInSortedArray {
    //By using recurrsion
    public static int getTheFloorOfAnElement(char[] a, int low, int high, int element) {
        if (low > high)
            return high==0?-1:high;//This is to handel the boundary case for high=0
        int mid = low + ((high - low) / 2);//This is to save from overflow.//high+low
        if (a[mid] == element )                                           // --------   this formula will not work in some cases.When in array INTEGER.MAX number of elements will be there ,then it will be overflow.
            return mid-1;                                                  //      2
        else if (element < a[mid]) {
            high = mid - 1;
            return   getTheFloorOfAnElement(a, low, high, element);
        } else  {
            low = mid + 1;
            return getTheFloorOfAnElement(a, low, high, element);
        }

    }

    public static void main(String[] args) {
        char[] arr={'c','d','f','h','j','l'};;
        final int index = getTheFloorOfAnElement(arr, 0, arr.length - 1, 'i');
        if(index!=-1)
            System.out.println(arr[index]);
        else
            System.out.println("not found ");
    }
    }

