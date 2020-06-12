package dp;

import java.util.Arrays;

/*
* In 1965, Vladimir Levenshtein defined the distance between two words as the
minimum number of "edits" it would take to transform the misspelled word into a
correct word, where a single edit is the insertion, deletion, or substitution of a single
character. For example, the Levenshtein distance between "Saturday" and "Sundays"
is 4 delete the first 'a' and 't', substitute V by 'n' and insert the trailing 's'.
—
Write a program that takes two strings and computes the minimum number of edits
needed to transform the first string into the second string.
*
* */
public class LevenshteinDistance {
    public static int getLevenshteinDistanceDP(String a,String b ){
        final char[] achars = a.toCharArray();
        final char[] bchars = b.toCharArray();
        int[][] memo=new int[a.length()+1][b.length()+1];
        for(int i=0;i<=achars.length;i++){
            for(int j=0;j<=bchars.length;j++) {
                if (i == 0)
                    memo[i][j] = j;
                if (j == 0)
                    memo[i][j] = i;
                if (i > 0 && j > 0) {
                    if (achars[i-1] == bchars[j-1]) {
                        memo[i][j] =  memo[i-1][j - 1];
                    } else {
                        int min = Math.min(memo[i][j - 1], memo[i - 1][j]);
                        min = Math.min(min, memo[i - i][j - 1]);
                        memo[i][j] = 1+min;
                    }
                }
            }
        }return memo[a.length()][b.length()];
    }
    public static int levenshteinDistance(String A, String B) {
        int[][] distanceBetweenPrefixes = new int[A.length()][B.length()];
        for (int[] row : distanceBetweenPrefixes) {
            Arrays.fill(row, -1);
        }
        return computeDistanceBetweenPrefixes(A, A.length() - 1, B, B.length() - 1,
                distanceBetweenPrefixes);
    }

    private static int computeDistanceBetweenPrefixes(
            String A, int A_idx , String B, int B_idx ,
            int[][] distanceBetweenPrefixes) {
        if (A_idx < 0) {
// A is empty so add all of B's characters.
            return B_idx + 1;
        } else if (B_idx < 0) {
// B is empty so delete all of A’s characters.
            return A_idx + 1;
        }
        if (distanceBetweenPrefixes[A_idx][B_idx] == -1) {
            if (A.charAt(A_idx) == B.charAt(B_idx)){
                distanceBetweenPrefixes[A_idx][B_idx] = computeDistanceBetweenPrefixes(
                        A, A_idx - 1, B, B_idx - 1, distanceBetweenPrefixes);
            } else {
                int substituteLast = computeDistanceBetweenPrefixes(
                        A, A_idx - 1, B, B_idx - 1, distanceBetweenPrefixes);
                int addLast = computeDistanceBetweenPrefixes(A , A_idx , B, B_idx - 1,
                        distanceBetweenPrefixes);
                int deleteLast = computeDistanceBetweenPrefixes(
                        A, A_idx - 1, B, B_idx , distanceBetweenPrefixes);
                distanceBetweenPrefixes[A_idx][B_idx]
                        = 1 + Math.min(substituteLast , Math.min(addLast , deleteLast));
            }
        }
        return distanceBetweenPrefixes[A_idx][B_idx];
    }
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("aggtab","gxtxayb"));
    }
}

/*
*  DP Table for Levenshtein distance
*    ______________________________________________________________________________
*   |           |         |         |        |       |        |         |         |
*   |           |   ""    |    A    |   G    |   G   |   T    |  A      |   B     |
*   |___________|_________|_________|________|_______|_______ |_________|_________|
*   |           |         |         |        |       |        |         |         |
*   |      ""   |    0    |    1    |   2    |   3   |   4    |  5      |   6     |
*   |___________|_________|_________|________|_______|________|_________|_________|
*   |           |         |         |        |       |        |         |         |
*   |       G   |   1     |    1    |    1   |   2   |   3    |   4     |  5      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |       X   |   2     |    2    |   2    |  2    |   3    |  4      |  5      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |       T   |    3    |    3    |   3    |   3   |   2    |  3      |   4     |
*   |___________|_________|_________|________|_______|________|_________|_________|
*   |           |         |         |        |       |        |         |         |
*   |       X   |   4     |    4    |   4    |  4    |  3     |  3      |  4      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |       A   |   5     |    4    |  5     |   5   |  4     |   3     |   4     |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |      Y    |   6     |    5    |  5     |  6    |  5     |   4     |  4      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
    |      B    |   7     |    6    |   6    |  6    |   6    |   5     |    4    |
    |___________|_________|_________|________|_______|________|_________|_________|
    *
* */