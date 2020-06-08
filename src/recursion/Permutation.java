package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public static List <List <String >> permutations(List<String> A) {
        List<List <String>> result = new ArrayList<>() ;
        directedPermutations (0 , A, result);
        return result;
    }
    private static void directedPermutations (int i, List <String > A,
                                              List <List <String >> result) {
        if (i == A.size()-1)
        {
                result . add(new ArrayList <>(A)) ;
            return ;
        }
// Try every possibility for A[i].
        for (int j = i; j < A.size(); ++j) {
                Collections.swap(A, i, j);
// Generate all permutations for A.subList(i + 1, A.size()).
            directedPermutations (i + 1, A, result);
            Collections.swap(A, i, j);
        }
    }
    static void permute(List<String> a, int i, int n)
    {
        int j;
        if (i == n)
            System.out.println(a);
        else
        {
            for (j = i; j <= n; j++)
            {
                Collections.swap(a, i, j);
                System.out.println("swap called 1st "+i +" "+j);
                permute(a, i+1, n);
                Collections.swap(a, i, j);
                System.out.println("swap called 2nd "+i +" "+j);
            }
        }
    }

    /*int main()
    {
        List<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        permute(a, 0, 2);

        return 0;
    }*/
    public static void main(String[] args) {
        /*List<String> plist= new ArrayList<>();
        plist.add("A");plist.add("B");plist.add("C");
        System.out.println(permutations(plist));*/

        List<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        permute(a, 0, 2);
    }
}
