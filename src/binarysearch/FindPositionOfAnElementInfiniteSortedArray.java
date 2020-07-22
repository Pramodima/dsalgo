package binarysearch;

public class FindPositionOfAnElementInfiniteSortedArray {
    public static int getPositionOfAnElemnet(int[] a,int key){
        int low=0;
        int high=1;
       while(key>a[high]) {
           low=high;
           high=high*2;
       }
      return SearchAnElementInSortedArray.getTheElementIndex(a,low,high,5);
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(getPositionOfAnElemnet(a,12));
    }
}
