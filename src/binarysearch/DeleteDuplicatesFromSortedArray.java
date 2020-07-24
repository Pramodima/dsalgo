package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplicatesFromSortedArray {
    public static int deleteDuplicates(List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
// .Returns the number
        }
        int writeIndex = 1;
        for (int i = 1; i < A.size(); ++i) {
            if (!A.get(writeIndex -1).equals(A.get(i))) {
                if(writeIndex==i){
                    writeIndex=writeIndex+1;
                } else{
                    A.set(writeIndex, A.get(i));
                    writeIndex=writeIndex+1;
                }
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        a.add(2); a.add(3); a.add(5); a.add(7); a.add(7); a.add(11); a.add(11);a.add(13);
        deleteDuplicates(a);
    }
}
