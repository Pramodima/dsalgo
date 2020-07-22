package binarysearch;
//Here array is sorted but order not known.If it has only one element .it is sorted in both way acssesending and descrnding .
//But if it has more than 1 element,then we compare 1st element with 2nd element and identif the order.
//The we apply previous one of the methods.
public class SearchInSortedButOrderNotKnownArray {

    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;

    private static int findOrder(int[] a ) {
        int type=ASCENDING;
        if(a.length==1){
          type=ASCENDING;
        }
        else if(a.length>1){
            if(a[0]>a[1]){
                type= DESCENDING;
            }

        }
        return type;
    }

    public static void main(String[] args) {
        int a[]={9,5,4,3,2,1};
        if(findOrder(a)==1){
            System.out.println(SearchAnElementInSortedArray.getTheElementIndex(a,0,a.length-1,3));
        }
        else{
            System.out.println(SearchAnElementInReverseSortedArray.getTheElementIndex(a,0,a.length-1,3));
        }
    }
}
