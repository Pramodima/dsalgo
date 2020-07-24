package binarysearch;

/*
* First refer to MaxElementInBitonicArray .First we find max in bitonic array.then we
* use binary search in left and reight half as both half are already sorted.
* */
public class SearchAnElementInABitonicArray {
    public static  int find(int[] a,int key){
        final int peakIndex = MaxElementInBitonicArray.getPeak(a);
        if(a[peakIndex]==key)
            return peakIndex;
        else{
            int indexLeft=SearchAnElementInSortedArray.getTheElementIndex(a,0,peakIndex-1,key);
            int indexRight=SearchAnElementInReverseSortedArray.getTheElementIndex(a,peakIndex+1,a.length-1,key);
            if(indexLeft==-1 && indexRight==-1){
                return  -1;
            }
            else
                return indexLeft==-1?indexRight:indexLeft;
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,6,8,9,7,5,4,3};
        System.out.println(find(a,3));
    }
}
