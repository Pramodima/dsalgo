package binarysearch;
/*this is the mixture of 2 problem  1-FindPositionOfAnElementInfiniteSortedArray
2-FirstOccuranceOfElementInSortedArray
Infinite Binary Sorted Array is like '{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1.....}'
* */
public class FindPositionOfAnElementInfiniteSortedBinaryArray {
    public static int getPositionOfAnElemnet(int[] a,int key){
        int[] b={0};
        int low=0;
        int high=1;
        while(key>a[high]) {
            low=high;
            high=high*2;
        }
         FirstOccuranceOfElementInSortedArray.getTheElementIndex(a,low,high,key,b);
        return  b[0];
    }

    public static void main(String[] args) {
        int[] a={0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,};
        System.out.println(getPositionOfAnElemnet(a,1));
    }
}
