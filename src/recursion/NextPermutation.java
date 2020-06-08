package recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
There exist exactly n\ permutations of n elements. These can be totally ordered using
the dictionary ordering define permutation p to appear before permutation q if in the
first place where p and q differ in their array representations, starting from index 0, the
corresponding entry for p is less than that for q. For example, (2,0, 1} < (2,1,0). Note
that the permutation (0, 1, 2) is the smallest permutation under dictionary ordering,
and (2, 1, 0) is the largest permutation under dictionary ordering.
—
Write a program that takes as input a permutation, and returns the next permutation
under dictionary ordering. If the permutation is the last permutation, return the
empty array. For example, if the input is (1,0, 3, 2) your function should return
(1, 2, 0, 3). If the input is (3, 2,1, 0), return ().
* */
/*my version */

public class NextPermutation {
    public static List <Integer> nextPermutation(List <Integer > perm) {
        int k = perm.size() - 2;
        while (k >= 0 && perm.get(k) >= perm.get(k + 1)) {
            --k;
        }
        if (k == -1) {
            return Collections.emptyList(); // perm is the last permutation.
        }
// Swap the smallest entry after
//        index k  that is greater than perm[k] . We
// exploit the fact that perm . subList (k + 1, perm.sizeO) is decreasing so
// if we search in reverse order, the first entry that is greater than
// perm[k ] is the smallest such entry.
        for (int i = perm.size() - 1; i > k; --i) {
            if (perm.get(i) > perm.get(k)) {
                Collections.swap(perm, k, i);
                break;
            }
        }
// Since perm . subList [k + 1, perm.size()) is in decreasing order, we can
// build the smallest dictionary ordering of this subarray by reversing it.
        Collections.reverse(perm.subList(k + 1, perm.size()));
        return perm;
    }
    public static void main(String[] args) {
      NextPermutation nextPermutation=new NextPermutation();
      List<Integer> list=new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(0);
        System.out.println(nextPermutation.nextPermutation(list));
    }
}
