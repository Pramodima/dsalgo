package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinWeightPathInTraingle {
    public static int minimumPathTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
// As we iterate, prevRow stores the minimum path sum to each entry in
// triangle.get(i - 1).
            List<Integer> prevRow = new ArrayList<>(triangle.get(0));
            for (int i = 1; i < triangle.size(); ++i) {
// Stores the minimum path sum to each entry in triangle .get (i) .
                List<Integer> currRow = new ArrayList<>(triangle.get(i));
// For the first element.
                currRow.set(0, currRow.get(0) + prevRow.get(0));
                for (int j = 1; j < currRow.size() - 1; ++j) {
                    currRow.set(j, currRow.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));

                }
// For the last element
                currRow.set(currRow.size() - 1, currRow.get(currRow.size() - 1)+ prevRow.get(prevRow.size() - 1));

                prevRow = currRow;
            }
            return Collections.min(prevRow);

        }

    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer> A=new ArrayList<>();
        A.add(2);
        List<Integer> B=new ArrayList<>();
        B.add(4); B.add(3);
        List<Integer> C=new ArrayList<>();
        C.add(8); C.add(5);C.add(6);
        List<Integer> D=new ArrayList<>();
        D.add(4); D.add(1);D.add(6);D.add(2);
        List<Integer> E=new ArrayList<>();
        E.add(1); E.add(5);E.add(2);E.add(3);E.add(4);
        triangle.add(A);triangle.add(B);triangle.add(C);triangle.add(D);triangle.add(E);
        System.out.println(minimumPathTotal(triangle));
    }
}
/*                                     _____
*                                     |  2  |
*                                   __|_____|___
*                                  |   4 |   3  |
 *                             ____|_____|______|__
*                             |  8 |   5  |   6   |
 *                         ___|____|______|_______|____
*                         |  4   |   1    |   6  |  2   |
 *                     ___|___ __|______ _|______|______|___
 *                    |   1  |    5   |   2  |   3  |   4   |
 *                    |___ __|______ _|______|______|_______|
 *
*                 DP table description
*               _____________________________
*
*        Let's take    Prev row=  2
*                   Current row=4 , 3
*             if we take minimum weight path from current row to prev row 4 is adjacent to 2 and 3 is also adjacent to 2
*             so prev row =6 , 5
*            Current row=8,5,6
*          if we take minimum weight path from current row to prev row 8 is adjacent to 6 and 6 is also adjacent to 5.But for 5 there is two option 6 and 5. i.e the current index of 5 is 1 ,so
*          it's adjacent will be  0th and 1st index  from prev row.And we take minmum out of these two and add it with 5.
*         so prev row=14,10,11
*        Current row=4,1,6,2
*         if we take minimum weight path from current row to prev row 4 is adjacent to 14 and 2 is  adjacent to 11.But for 1 there is two option 14 and 10. i.e the current index of 1 is 1 ,so
 *          it's adjacent will be  0th and 1st index  from prev row ie. 14,10.And we take minimum out of these two and add it with 1 ie. 10+1.For 6 there sre two options 10 and 11 i.e the current index
 *        of 6 is 2 , so its adjacent will  1st and 2nd index from prev row and we take minimum of these two i.e minimum of 10 ,11 ie 10 and add it with 6 ie 10+6
 *        so prev row =18,11,16,13
 *    Now current row= 1,5,2,3,4
 *   And usig same logic
 *   prev row      =19,16,13,16,17
 *   And minimum of the last prev row is 13 , so min weight path in traingle is 13.
*
* */