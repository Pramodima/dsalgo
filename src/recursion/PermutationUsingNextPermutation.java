package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationUsingNextPermutation {
    private static void directedPermutations(List<Integer> list) {
        List<List<Integer>> resultList = new ArrayList<>();
        NextPermutation nextPermutation = new NextPermutation();
        resultList.add(list);
        do {
            list = nextPermutation.nextPermutation(list);
            resultList.add(list);
        }
        while (list.size() != 0);
        resultList.remove(resultList.size()-1);
        System.out.println(resultList);
    }



    public static void main(String[] args) {
        NextPermutation nextPermutation=new NextPermutation();
        List<Integer> list=new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(0);
        Collections.sort(list);
        directedPermutations(list);
    }
}
