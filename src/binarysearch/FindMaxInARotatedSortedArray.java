package binarysearch;
//First find min and then take it just previous index.If it is 0, then take array.length-1;
public class FindMaxInARotatedSortedArray {
    public static void main(String[] args) {
        int arr1[] = { 5, 6, 1, 2, 3, 4 };
        int n1 = arr1.length;
        int index=FindMinimumInASortedRotatedArray.findMin(arr1, 0, n1 - 1);
        System.out.println("The minimum element's position is " +index);
        int max_index=0;
       if(index>0){
           max_index=index-1;
       }
       else if(index==0){
           max_index=n1;
       }
        System.out.println("max elelment is "+arr1[max_index]);
    }
}
