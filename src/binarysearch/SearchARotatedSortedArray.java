package binarysearch;

/*
assuming all the keys are unique.

Let A={1,2,3,4,5,6,7,8,9} is a sorted array.We want to search 8.

Case 1- Lets rotate it 5 times in clockwise direction
----------------------------------------------------

After rotation A={6,7,8,9,1,2,3,4,5} mid=1 left={6,7,8,9} right={2,3,4,5}
left array sorted and right array sorted.So we can apply binary search on both side , depending on whre the element lies.

Case 2- Lets rotate it 2 times in clockwise direction
-----------------------------------------------------

After rotation A={3,4,5,6,7,8,9,1,2} mid=7 left={3,4,5,6} right={8,9,1,2}
left array is sorted and right array is not sorted.But if our desired key 8 is in right part, and mid>=end i.e 8>2
then start=mid+1 and apply binary search in right part.

Case 3-  Rotate 3 times in clockwise direction
-----------------------------------------------

After rotation A-{7,8,9,1,2,3,4,5,6} mid=2 left={7,8,9,1} right={3,4,5,6}
left array is not sorted and right array is  sorted.But if our desired key 8 is in left part, and mid<=end i.e 8<2
then end=mid+1 and apply binary search in left part.

Runtime complexity

The runtime complexity of this solution is logarithmic, O(log n)

Memory complexity

The memory complexity of this solution is logarithmic, O(log n).It is for call stack.No external memory is allocated by code.

The solution is essentially a binary search but with some modifications. If we look at the array in the example closely,
we notice that at least one half of the array is always sorted. We can use this property to our advantage.
If the number nnn lies within the sorted half of the array, then our problem is a basic binary search.
Otherwise, discard the sorted half and keep examining the unsorted half. Since we are partitioning the array in half at each step,
this gives us O(log n) runtime complexity.
* */
public class SearchARotatedSortedArray {
    //recurrsive
    public static int getTheElementIndex(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
            return getTheElementIndex(arr, start, mid - 1, key);
        }

        else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
            return getTheElementIndex(arr, mid + 1, end, key);
        }

        else if (arr[end] <= arr[mid]) {
            return getTheElementIndex(arr, mid + 1, end, key);
        }

        else if (arr[start] >= arr[mid]) {
            return getTheElementIndex(arr, start, mid - 1, key);
        }

        return -1;
    }
   /* Runtime complexity  for itreartive

    The runtime complexity of this solution is logarithmic, O(log n)
    Memory complexity

    The memory complexity of this solution is constant, O(1)
    */

    public static int getTheElementIndexI(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
                end = mid-1;
            } else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
                start = mid + 1;
            } else if (arr[end] <= arr[mid]) {
                start = mid + 1;
            } else if (arr[start] >= arr[mid]) {
                end = mid - 1;
            }
            else
                return -1;
            //return -1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a={6,7,8,9,1,2,3,4,5};
        System.out.println(getTheElementIndexI(a,0,a.length-1,8));
        int[] b={3,4,5,6,7,8,9,1,2};
        System.out.println(getTheElementIndexI(b,0,b.length-1,8));
        int[] c={7,8,9,1,2,3,4,5,6};
        System.out.println(getTheElementIndexI(c,0,c.length-1,8));
    }
}
