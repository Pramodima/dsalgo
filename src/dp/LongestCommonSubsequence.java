package dp;

public class LongestCommonSubsequence {

    public static int getLCSRecurssive(String a,String b ){
        if(a.isEmpty() || b.isEmpty()) return 0;
        final char[] achars = a.toCharArray();
        final char[] bchars = b.toCharArray();
        final char achar = achars[a.length() - 1];
        final char bchar = bchars[b.length() - 1];
        if(achar==bchar)
            return 1+getLCSRecurssive(a.substring(0,a.length()-1),b.substring(0,b.length()-1));
        else
            return Math.max(getLCSRecurssive(a.substring(0,a.length()-1),b.substring(0,b.length())),getLCSRecurssive(a.substring(0,a.length()),b.substring(0,b.length()-1)));
    }

    public static void main(String[] args) {
        System.out.println(getLCSDP("aggtab","gxtxayb"));
    }
    public static int getLCSDP(String a,String b ){
        final char[] achars = a.toCharArray();
        final char[] bchars = b.toCharArray();
        int[][] memo=new int[a.length()+1][b.length()+1];
        for(int i=0;i<=achars.length;i++){
            for(int j=0;j<=bchars.length;j++) {
                if (i == 0)
                    memo[i][j] = 0;
                if (j == 0)
                    memo[i][j] = 0;
                if (i > 0 && j > 0) {
                    if (achars[i-1] == bchars[j-1]) {
                        memo[i][j] = 1 + memo[i-1][j - 1];
                    } else {
                        memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                    }
                }
            }
        }return memo[a.length()][b.length()];
    }
}
/*
*                                       lcs("aab","azb")
*                                                |
*                                                |
*               1+lcs("aa","az")(this is because the last two charcters are same call as "b")
 *                                               |
*                                                |
*              max(lcs("a","az"),lcs("aa","a") (as end chars are not matching,we will take 1 char less from each string and take max)
*                     |                 |
*                     |                 |
*              max(lcs("","az"),    1+lcs("a","")
*                 lcs("a","a"))          |
*                      |                  |
*                    max(0,1)       1+0(lcs of an empty string with any string zero)
*
*     DP Table for LCS
*    ______________________________________________________________________________
*   |           |         |         |        |       |        |         |         |
*   |           |   ""    |    A    |   G    |   G   |   T    |  A      |   B     |
*   |___________|_________|_________|________|_______|_______ |_________|_________|
*   |           |         |         |        |       |        |         |         |
*   |      ""   |    0    |    0    |   0    |   0   |   0    |  0      |   0     |
*   |___________|_________|_________|________|_______|________|_________|_________|
*   |           |         |         |        |       |        |         |         |
*   |       G   |   0     |    0    |    1   |   1   |   1    |   1     |  1      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |       X   |   0     |    0    |   1    |  1    |   1    |  1      |  1      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |       T   |    0    |    0    |   1    |   1   |   2    |  2      |   2     |
*   |___________|_________|_________|________|_______|________|_________|_________|
*   |           |         |         |        |       |        |         |         |
*   |       X   |   0     |    1    |   1    |  1    |  2     |  2      |  2      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |       A   |   0     |    1    |  1     |   1   |  2     |   3     |   3     |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
*   |      Y    |   0     |    1    |  1     |  1    |  2     |   3     |  3      |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
    |      B    |   0     |    1    |   1    |  1    |   2    |   3     |    4    |
    |___________|_________|_________|________|_______|________|_________|_________|
    *
* */

