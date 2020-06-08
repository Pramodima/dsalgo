package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void solveNQueens(int n, int row, List<Integer> colPlacement,
                                       List<List<Integer>> result) {
        if (row == n) {
// All queens are legally placed.
            result.add(new ArrayList<>(colPlacement));
        } else {
            for (int col = 0; col < n; ++col) {
                colPlacement.add(col);
                if (isValid(colPlacement)) {
                    solveNQueens(n, row + 1, colPlacement, result);
                }
                colPlacement.remove(colPlacement.size() - 1);
            }
        }
    }
    private static void solveNQueensIterative(int n, int row, List<Integer> colPlacement,
                                     List<List<Integer>> result) {
        while (row != n) {
// All queens are legally placed.
           // result.add(new ArrayList<>(colPlacement));

            for (int col = 0; col < n; ++col) {
                colPlacement.add(col);
                if (isValid(colPlacement)) {
                   row=row+1;
                }
               // colPlacement.remove(colPlacement.size() - 1);
            }
        }
        result.add(new ArrayList<>(colPlacement));

    }
    // Test if a newly placed queen will conflict any earlier queens
// placed before.
    private static boolean isValid(List<Integer> colPlacement) {
        int rowID = colPlacement.size() - 1;
        for (int i = 0; i < rowID; ++i) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowID));
            //column check
            if (diff == 0)   {
                return false;
            }
            //digonal check
            if( diff == rowID - i){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = nQueens(4);
        System.out.println(lists);
    }
}