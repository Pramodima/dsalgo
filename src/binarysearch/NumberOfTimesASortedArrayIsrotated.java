package binarysearch;
//To find the number of times a sorted array is rotated,first find the minimum in a rotated sorted array .If it rotation is  clockwise .Then n=length of the array-index of the min element
//If the array is rotated anticlockwise  n=index of min.
public class NumberOfTimesASortedArrayIsrotated {
    public static void main(String[] args) {
        int arr1[] = { 5, 6, 1, 2, 3, 4 };
        int n1 = arr1.length;
        int index=FindMinimumInASortedRotatedArray.findMin(arr1, 0, n1 - 1);
        System.out.println("The minimum element's position is " +index);
        System.out.println("Number of clockwise rotation is "+(n1-index));
        System.out.println("Number of anti-clockwise rotation is "+(index));
    }

}
