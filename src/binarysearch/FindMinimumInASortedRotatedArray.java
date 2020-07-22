package binarysearch;
/*
A={1,2,3,4,5,6,7,8,9}
Case-1
-------
After rotating anti-clockwise 3 times A={7,8,9,1,2,3,4,5,6}

Observe that, the previous element of min element is gretaer,but for all other the
previous elements are smaller.

Here mid=2, and right part is {2,3,4,5,6} is already sorted.

And left part is {7,8,9,1} is unsorted.And we ll always find the min in unsorted part.
ie mid<high ie. right part is sorted, so we go to the left part.ie. high =mid;

Case-2
------
After rotating anti-clockwise 5 times A={5,6,7,8,9,1,2,3,4} or we can say rotating clockwise 4 times

Observe that, the previous element of min element is gretaer,but for all other the
previous elements are smaller.

Here mid=9, and right part is {9,1,2,3,4} is already unsorted.

And left part is {5,6,7,8} is sorted.And we ll always find the min in unsorted part.
ie mid>high ie. left part is sorted, so we go to the right part.ie. low =mid+1;

Case-3 Array  containing duplicate
------
A={1,2,3,4,4,4,4,4,4,4,4,4,4,5,6}
After rotating anti clock wise 2 times.Or clockwise 13 times.A={5,6,1,2,3,4,4,4(mid),4,4,4,4,4,4,4}.Here mid=4.So we have to do high=high-1,to reduce the duplicates
Clockwise rotation +anti-clockwise rotation=total nos of element.ie 2+13=15
*/
public class FindMinimumInASortedRotatedArray {

        // Function to find minimum element
        public static int findMin(int arr[],int low, int high){


            while(low < high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == arr[high])      // Case-3
                high--;

            else if(arr[mid] > arr[high])   //Case-2
                low = mid + 1;
            else
                high = mid;//{7,8,9,1,2,3,4,5,6} Case-1
        }                         //  |
            return high;    //  mid
        }

        public static void main(String args[])
        {
          /*  int arr1[] = { 5, 6, 1, 2, 3, 4 };
            int n1 = arr1.length;
            System.out.println("The minimum element is " +
                    findMin(arr1, 0, n1 - 1));

            int arr2[] = { 1, 2, 3, 4 };
            int n2 = arr2.length;
            System.out.println("The minimum element is " +
                    findMin(arr2, 0, n2 - 1));

            int arr3[] = {1};
            int n3 = arr3.length;
            System.out.println("The minimum element is " +
                    findMin(arr3, 0, n3 - 1));

            int arr4[] = { 1, 2 };
            int n4 = arr4.length;
            System.out.println("The minimum element is " +
                    findMin(arr4, 0, n4 - 1));

            int arr5[] = { 2, 1 };
            int n5 = arr5.length;
            System.out.println("The minimum element is " +
                    findMin(arr5, 0, n5 - 1));

            int arr6[] = { 5, 6, 7, 1, 2, 3, 4 };
            int n6 = arr6.length;
            System.out.println("The minimum element is " +
                    findMin(arr6, 0, n6 - 1));
*/
            int arr7[] = { 1, 2, 3, 4, 5, 6, 7 };
            int n7 = arr7.length;
            System.out.println("The minimum element is " +
                    arr7[findMin(arr7, 0, n7 - 1)]);

            int arr8[] = { 2, 3, 4, 5, 6, 7, 8, 1 };
            int n8 = arr8.length;
            System.out.println("The minimum element is " +
                    arr8[findMin(arr8, 0, n8 - 1)]);

            int arr9[] = { 4,4,1,2,3,4,4,4,4,4,4,4,4};//original array A={1,2,3,4,4,4,4,4,4,4,4,4,4}
            int n9 = arr9.length;
            System.out.println("The minimum element is " +
                    arr9[findMin(arr9, 0, n9 - 1)]);
        }
    }



