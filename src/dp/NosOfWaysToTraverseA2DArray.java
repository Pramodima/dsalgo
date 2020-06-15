package dp;
/*
* In this problem you are to count the number of ways of starting at the top-left corner
of a 2D array and getting to the bottom-right comer. All moves must either go right
or down.
*
* Explanation :  If i > 0 and j > 0, you can get to (i, j) from (i-1, j)(just upper cell of (i,j)) or (j-1, i)(just left cell of (i,j)).
* Here Let's assume we have a 2d array of size (m,n)..The last square is (m-1,n-1) as we start from (0,0)
* */
public class NosOfWaysToTraverseA2DArray {
public int getNosOfWayRecurrsiveTopDown(int m,int n){
    if(m==1 || n==1)
        return 1;
    return getNosOfWayRecurrsiveTopDown(m-1,n)+getNosOfWayRecurrsiveTopDown(m,n-1);

}
    public int getNosOfWayDP(int m,int n){
    int[][] memo=new int[5][5];
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0 || j==0){
                memo[i][j]=1;
            }
            if(i>0 && j>0) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
    }

        return memo[m-1][n-1];

    }
    public static void main(String[] args) {
        NosOfWaysToTraverseA2DArray nosOfWaysToTraverseA2DArray=new NosOfWaysToTraverseA2DArray();
        System.out.println(nosOfWaysToTraverseA2DArray.getNosOfWayDP(3,5));
    }
}
/*
     here m=9 and n=8.We can reach (m-1,n-1) in two ways ,either from (m-1,n-2) ie. its left cell  or from (m-2,n-1) is its upeer cell.
     So total number of ways to reach (m-1,n-1)=total nos of ways to reach (m-1,n-2)+total nos of ways to reach (m-2,n-1).Now This gives
     us a recurrsive way to solve.We solve this in top down recursive manner.Here the base case is from (0,0) to reach any cell in first
     row or first column ,there is only 1 way.Reaching from (0,0) to (0,0) , there is {} way.empty way is also 1 way.

           0          1          2         3       4       5        6        7
     ______________________________________________________________________________
    |           |         |         |        |       |        |         |         |
  0 |   1 (0,0) |  1      |   1     |  1     |  1    |  1     |  1      |  1      |
    |___________|_________|_________|________|_______|_______ |_________|_________|
    |           |         |         |        |       |        |         |         |
  1 |   1       |   2     |  3      |  4     |  5    | 5      |  6      |  7      |
    |___________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
  2 |   1       |   3     |  6      |  10    |  15   |  20    | 26      |  33     |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
  3 |    1      |   4     |  10     |  20    |  35   |  55    |  71     | 104     |
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |         |
  4 |    1      |    5    |  15     | 35     |  70   |  125   | 196     | 300     |
    |___________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        |         |  747    |
  5 |    1      |   6     | 21      | 56     | 126   |   251  | 447     |(m-2,n-1)|
    | __________|_________|_________|________|_______|________|_________|_________|
    |           |         |         |        |       |        | 908     | 1655    |
  6 |    1      | 7       | 28      | 84     | 210   |  461   |(m-1,n-2)|(m-1,n-1)|
    | __________|_________|_________|________|_______|________|_________|_________|

The time complexity is 0(nm), and the space complexity is 0(nm), where n is the
number of rows and m is the number of columns.

A more analytical way of solving this problem is to use the fact that each path from
(0, 0) to (n - 1,m -1) is a sequence of m -1 horizontal steps and n -1 vertical steps.
There are  ( n+m-2) =(n+m-2) i.e combination of n+m-2 and m-1 elememts .ie choose m-1 elements from n+m-2, such paths.
          (  n-1)     (m-1 )



Since each path is comprised of m-1 horizontal steps and n-1 vertical steps, there are in total m+n-2 steps in each path.
In order to select a specific path you can define either the vertical or horizontal steps. Let's say you have defined
all the vertical steps (i.e. n-1 of them). Once they're defined, there is no actual choice for the rest of the steps
(the horizontal ones) - there is only one single possibility for each horizontal step (which makes a connection between
the adjacent vertical steps). Therefore, choosing n-1 from m+n-2 defines a single valid path. And the total number of
paths will be the number of possibilities to choose n-1 out of m+n-2 (same result can be achieved by choosing m-1 instead of n-1).

See example below:
https://stackoverflow.com/questions/49544257/number-of-ways-to-traverse-a-2d-array-top-left-to-bottom-right
Let's say you've chosen the vertical steps (the red ones) - once it's done, there is only one option for each horizontal step (the blue ones). Otherwise, the path will be non-continous and invalid as a result

* */