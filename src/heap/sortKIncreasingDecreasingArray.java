package heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class sortKIncreasingDecreasingArray {


    public static List<Integer> sortKIncreasingDecreasingArray(List <Integer > A) {
// Decomposes A into a set of sorted arrays.
        List<List <Integer>> sortedSubarrays=new ArrayList<>() ;
                SubarrayType subarrayType = SubarrayType .INCREASING ;
        int startldx = 0;
        for (int i = 1; i <= A.size(); ++i) {
            if (i == A.size() // A is ended. Adds the last subarray
                    || (A.get(i - 1) < A.get(i)
                    && subarrayType == SubarrayType.DECREASING)
                    || (A.get(i - 1) >= A.get(i)
                    && subarrayType == SubarrayType.INCREASING)) {
                List <Integer >subList = A.subList(startldx, i);
                if (subarrayType == SubarrayType.DECREASING) {
                    Collections.reverse(subList);
                }
                sortedSubarrays.add(subList);
                startldx=i;

                subarrayType  = (subarrayType == SubarrayType.INCREASING? SubarrayType.DECREASING : SubarrayType.INCREASING);
            }
        }
        return sortedSubarrays.stream().flatMap(Collection::stream).collect(Collectors.toList());//MergeSortedArrays.mergeSortedArrays(sortedSubarrays);
    }
    private static enum SubarrayType { INCREASING, DECREASING }

    public static void main(String[] args) {
        List array=new ArrayList();
        array.add(57);array.add(131);  array.add(493);  array.add(294);  array.add(221);  array.add(339);  array.add(418);  array.add(452);array.add(442);array.add(190);

        System.out.println(sortKIncreasingDecreasingArray(array)) ;
    }
}