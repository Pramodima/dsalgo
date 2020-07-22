package binarysearch;
/*

Problem Statement find peak element
-----------------
Let A={10,30,20,25,5,7,2,8,6}, be an unsorted array.An element is said to be peak element
if it is greater than its left and right element.eg. 30 as 30>10 and 30>20.
similarly 25 as 25>20 and 25>5
Similary 7 and 8.

If it is boundary element , then it should be larger than its nearest element.
For A[0] =10, it is not greater than 30.So it is not peak.
For A[n]=6, it is not greater than 8.So it is not peak.

Solution:
-----------

Apply  Binary search on the unsorted array.Take the mid  and comapre it with negbouring element.
If condition satisfes  , then return it.

Otherwise move to its left if left is greater than element.
it means the element can not be peak due to its left as left is greater than the element.So we go to the left.
For example for element 5 , we ll go to the left ,because 25 is greater than 5.And 25,5 is the duo of the peak triplet.
Means , if we go to the left, there is more chance that we can find the triplet.

Similarly if right element is greater the mid element , then move to the right.
 */
public class PeakElementInAnUnsortedArray {
    public static int getPeak(int[] a){
        int low=0;
        int high=a.length-1;
        while(low<=high){
           int mid=low+(high-low)/2;
           if(mid>0 && mid<a.length-1){//will handel the boundary case latter.
               if(a[mid]>a[mid-1] && a[mid]>a[mid+1]){//check mid is greater than its neighbours(left and right)
                   return mid;
               }
               else if (a[mid]<a[mid-1]){//check the mid with  its left, if left is greater , go towards left.
                       high=mid-1;
               }
               else if (a[mid]<a[mid+1]){//check the mid with  its right, if right is greater , go towards right.
                   low=mid+1;
               }
               else{
                   return -1;
               }
           }
           else{//boundary condition will be handled here.
               if(mid==0 && a[mid]>a[mid+1]){
                   return mid;
               }
              else if(mid==a.length-1 && a[mid]>a[mid-1]){
                   return mid;
               }
              return -1;
           }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={1,3,20,21,5,1,2,8,6};
        final int peak = getPeak(a);
        System.out.println(a[peak]);

    }
}
