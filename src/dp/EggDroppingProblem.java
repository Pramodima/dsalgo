package dp;

/*Given a certain amount of floors of a building (say f number of floors) and also given certain amount of eggs (say e number of eggs) …

        What is the least amount of egg drops one has to perform to find out the threshold floor? (Threshold floor is one from which the egg starts breaking and also egg breaks for all the floors above. Also, if egg dropped from any floor below the threshold floor, it won’t break.)
        Constraints:

        An egg that survives a fall can be used again.
        A broken egg must be discarded.
        The effect of a fall is the same for all eggs.
        If an egg breaks when dropped, then it would break if dropped from a higher floor.
        If an egg survives a fall then it would survive a shorter fall.

        One thing is to be remembered that we are finding The least amount of egg drops needed to find threshold and not the threshold floor itself.

*/
public class EggDroppingProblem {

//Bottom up recurssive
    public static int getAmountOfEggDrops(int eggs,int floors){
    if(eggs==1 || floors==0 || floors==1) return floors;
    int minDrops= Integer.MAX_VALUE;
    for(int i=1;i<=floors;i++){
        // If the egg breaks on floor x, we only need to test floors up to the
        // i-1th floor. We also have one less egg since the egg broke.
        int eggBreaks=getAmountOfEggDrops(eggs-1,i-1);
        // If the egg did not break on floor x, we only need to test floors
        // starting from the floor-ith floor onwards. The number of eggs
        // does not change since the egg did not break.
        int eggDoesNotBreak=getAmountOfEggDrops(eggs,floors-i);
        Math.max(eggBreaks,eggDoesNotBreak);

        // Find the number of drops necessary in the WORST CASE scenario.
        // Don't forget to add one to include the current drop.
        int drops = Math.max(eggBreaks, eggDoesNotBreak) + 1;

        // Update memo[floor][egg] if we found a smaller number of needed
        // egg drops
        if (drops < minDrops)
        {
            minDrops = drops;
        }

    }
    return minDrops;
    }
    //Bottom up itertaive DP
    static int eggDropDP(int eggs, int floors) {
        /* A 2D table where entery eggFloor[i][j]
 will represent minimum number of trials
needed for i eggs and j floors. */
        int eggFloor[][] = new int[eggs + 1][floors + 1];
        int res;

        // We need one trial for one floor and
        // 0 trials for 0 floors
        for (int i = 1; i <= eggs; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        // We always need j trials for one egg
        // and j floors.
        for (int j = 1; j <= floors; j++)
            eggFloor[1][j] = j;

        // Fill rest of the entries in table using
        // optimal substructure property
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {

                    // If the egg breaks on floor x, we only need to test floors up to the
                    // x-1th floor. We also have one less egg since the egg broke.
                    int eggBreak = eggFloor[i - 1][x - 1];
                    // If the egg did not break on floor x, we only need to test floors
                    // starting from the j-xth floor onwards. The number of eggs
                    // does not change since the egg did not break.
                    int eggDoesNotBreak = eggFloor[i][j - x];

                    // Find the number of drops necessary in the WORST CASE scenario.
                    // Don't forget to add one to include the current drop.

                    res = 1 + Math.max(eggBreak, eggDoesNotBreak);

                    // Update eggFloor[i][j] if we found a smaller number of needed
                    // egg drops

                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }

        // eggFloor[n][k] holds the result
        return eggFloor[eggs][floors];
    }
    public static void main(String[] args) {
        final int amountOfEggDropsDP = eggDropDP(2, 36);
        System.out.println("amount of trials needed "+amountOfEggDropsDP);
    }
}
//https://medium.com/human-in-a-machine-world/the-egg-dropping-puzzle-a23f58a59374
//https://medium.com/@parv51199/egg-drop-problem-using-dynamic-programming-e22f67a1a7c3

/*
   Below table contains number of trails for each i th egg and jth floor
   eggDrop(e,f) = 1+min{max( eggDrop(e-1,k-1) , eggDrop(e,f-k) ) , k in 1:f}
     _____________________________________________________________________________________
*   |           |         |         |        |       |        |         |         |       |
*   |eggs/floors|   0     |    1    |   2    |   3   |   4    |  5      |   6     |  7    |
*   |___________|_________|_________|________|_______|_______ |_________|_________|_______|
*   |           |         |         |        |       |        |         |         |       |
*   |      1    |    0    |    1    |   2    |   3   |   4    |  5      |   6     |  7    |
*   |___________|_________|_________|________|_______|________|_________|_________|_______|_
*   |      2    |         |         |                                                     |
*   |           |   0     |    1    |                                                     |
    | __________|_________|_________|_____________________________________________________|
    |      3    |         |         |                                                     |
*   |           |   0     |    1    |                                                     |
    | __________|_________|_________|_____________________________________________________|
* */