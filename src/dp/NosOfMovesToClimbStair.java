package dp;

public class NosOfMovesToClimbStair {
    public static int getNumMoves(int totalSteps, int stepsCanClimb) {
        int[] num = new int[totalSteps + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= totalSteps; i++) {
            for (int j = 1; j <= stepsCanClimb; j++) {
                if (i >= j) {//Thiss check is to aviod negative index for aray.
                    num[i] += num[i - j];
                }
            }
        }
        return num[totalSteps];
    }

    // what if steps can climb is a discrte set i.e stepsCanClimb={1,3,5}
    public static int getNumMovesV1(int totalSteps, int[] stepsCanClimb) {
        int[] num = new int[totalSteps + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= totalSteps; i++) {
            for (int j = 0;j< stepsCanClimb.length;j++) {
                if (i >= j) {//This check is to aviod negative index for aray.
                    num[i] += num[i - j];
                }
            }
        }
        return num[totalSteps];
    }

    public static void main(String[] args) {
        System.out.println(getNumMoves(4, 2));
    }
}
     /*                           ___
                              ___|__|0
                          ___|______|1
                       __|__________|2
                      |_____________|3
                                     4

              Here our assumption is , we have 4 steps and we can climbs 1 or 2 steps at a time.
              Let's assume we have only one step i.e 0th step and 1 is ground .Total nos of ways to reach 0 from 1 {1,0}

              Let's assume we have only two step i.e 0th step and 1st step and 2  is ground .Total nos of ways to reach 0 from 2 {2,1,0},{2,0}

              Let's assume we have only 3 step i.e 0th step and 1st step and 2nd step  and 3 is ground .Total nos of ways to reach 0 from 3 .
              If we take 1 step and reach 2 and next is same as 2 to 0.so we can writ {3,2,1,0},{3,2,0} and if we take two step from 3 then we reach 1
              and next is same as 1 to 0 .so we can write {3,1,0}

             Let's assume we have only 4 step i.e 0th step and 1st step and 2nd step  and 3rd step and 4  is ground .Total nos of ways to reach 0 from 4 .
              If we take 1 step and reach 3 and next is same as 3 to 0.so we can writ {4,3,2,1,0},{4,3,2,0},{4,3,1,0} and if we take two step from 4 then we reach 2
              and next is same as 2 to 0 .so we can write {4,2,1,0}  {4,2,0}

              if we observe it , we found each step depends on its two previous steps
              that is f(n)=f(n-1)+f(n-2)

              above solution is a dp in bottom up aproach..The base case is 0 steps and 1 steps.
              If we have o step i.e no step .so we can take 0 ways to move to 0 steps.so  number
              of ways is 1

              If we have 1 step .so we can take 1 ways to move to 0 step from 1  i.e {1,0}.so  number
              of ways is 1.


     Time Complexity is O(nk) and space complexity is O(n)

     Space compexity can be improved , as we need only  prevoius k elements.

    For  stepsCanClimb =2 ,it is a fibonacci problem.

      */