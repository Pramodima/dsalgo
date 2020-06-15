package dp;


/*
Coin-collecting problem Several coins are placed in cells of an
n × mboard, no more than one coin per cell.Arobot, located in the upper left cell
of the board, needs to collect as many of the coins as possible and bring them to
the bottom right cell. On each step, the robot can move either one cell to the right
or one cell down from its current location.When the robot visits a cell with a coin,
it always picks up that coin. Design an algorithm to find the maximum number of
coins the robot can collect and a path it needs to follow to do this.

//Logic will be same as NosOfWaysToTraverseA2DArray
It may come from upper or left cell , but we will count the coins in the cell, which have max coins.And  we add  the coins in (i,j) th cell if any.

 */
public class RobotCoinCollection {
    public int getMaxCoinsDP(int[][] board,int m,int n){

        int[][] memo=new int[m][n];
            /*for(int i=1;i<m;i++){
            memo[i][0]=memo[i-1][0]+board[i][0];
        }
        for(int j=1;j<n;j++){
            memo[0][j]=memo[0][j-1]+board[0][j];
        }*/
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
        if(i==0 || j==0){
            //Each cell in first column has no left cell only upper cell.
            memo[i][0]=memo[i-1][0]+board[i][0];
            //Each cell in first row has no upper cell only left cell.
            memo[0][j]=memo[0][j-1]+board[0][j];
        }
                if(i>0 && j>0) {
                    memo[i][j] =Math.max(memo[i - 1][j] , memo[i][j - 1])+board[i][j];
                }
            }
        }

        return memo[m-1][n-1];

    }
    public static void main(String[] args) {
        RobotCoinCollection robotCoinCollection=new RobotCoinCollection();
        int[][] board=new int[5][6];
        board[0][4]=1;
        board[1][1]=1;
        board[1][3]=1;
        board[2][3]=1;
        board[2][5]=1;
        board[3][2]=1;
        board[3][5]=1;
        board[4][0]=1;
        board[4][4]=1;
       System.out.println(robotCoinCollection.getMaxCoinsDP(board,5,6));
    }
}
