package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    static void generatePowerSet(List<String> powerSet, String set, List<String> finalPowerSet) {
        if (set.length() > 0) {
            List<String> updatedPowerSet = new ArrayList<>();
            for (String s1 : powerSet) {
                updatedPowerSet.add(s1);
                updatedPowerSet.add(s1.concat(String.valueOf(set.charAt(0))));
            }
            finalPowerSet.clear();
            finalPowerSet.addAll(updatedPowerSet);
            set = set.substring(1, set.length());
            generatePowerSet(updatedPowerSet, set, finalPowerSet);
        }

    }

    public static void main(String[] args) {
        List<String> selectedSoFar = new ArrayList<>();
        selectedSoFar.add("");
        List<String> finalPowerSet = new ArrayList<>();
        generatePowerSet(selectedSoFar, "123", finalPowerSet);
        List<Integer> inputSet=new ArrayList<>();
        inputSet.add(1);
        inputSet.add(2);
        inputSet.add(3);
        generatePowerSetV1(inputSet);
        System.out.println(finalPowerSet);
    }

    private static final double L0G_2 = Math.log(2);

    public static List<List<Integer>> generatePowerSetV1(List<Integer> inputSet) {
        List<List<Integer>> powerSet = new ArrayList<>();
        for (int intForSubset = 0; intForSubset < (1 << inputSet.size()); ++intForSubset) {
            int bitArray = intForSubset;
            List<Integer> subset = new ArrayList<>();
            while (bitArray != 0) {
                subset.add(inputSet.get((int) (Math.log(bitArray & ~(bitArray - 1)) / L0G_2)));
                bitArray &= bitArray - 1;
            }
            powerSet.add(subset);
        }
        return powerSet;
    }
}

/*
y= x & ~(x-1) ,The variable y is 1 at exactly the lowest bit of x that is 1; all other bits in y are 0.
For example, if x = (00101100)2, then x-1 = (00101011)2, ~(x - 1) = (11010100)2, y= x & ~(x-1)=(00000100)2
{}  - 000 - 0
A   - 001 - 1
B   - 010 - 2
C   - 100 - 4
AB  - 011 - 3
AC  - 101 - 5
BC  - 110 - 6
ABC - 111 - 7

Here we can observe if the lease significant bit(lsb) set to 1,then it is 1,if the miidle bit is set to 1, then it is B,and if most significant bit(msb) is set to 1 then it is C
And similarly the combinations. So now we found all the elements in powerset in binary representation of all the numbers from  0 to 2^n(i.e cardinailty of powerset) -1.

The step y= x & ~(x-1) will give the lowest bit of x that is 1.
The step y= x & (x-1), will set the lowest bit of x to 0.ie it will take us one bit left.
For example, if x = (00101100)2, then x-1 = (00101011)2,  y= x & (x-1)=(00101000)2

Let's understand it with a concrete example.Take (111)2 first we do y= x & ~(x-1).it will give us y=001. we found A.Add it in a list.We use log(y)
to get the index of the elemnt in orginal list.
Then take y= x & (x-1),it will give 110.
Then take x=(110)2
y= x & ~(x-1),it will give 010..Now we got B.Add it in same list.
y= x & (x-1),it will give 100.
Now take x=(100)2
Now reapeat the step.
y= x & ~(x-1),it will give 100.Now we got C.Add it in same list.
y= x & (x-1),it will give 000.
Since x=0, now the loop breaks and the list containd ABC.
Now we see , how generate ABC from (111)2 ie . 7.

Similarly we can generate all the members of the power set.

1 << inputSet.size())
here the left shift operator ,will move 1 3 palce left ie 0001, will be 1000 ie 8.The cardinality of power set.
Time complexity
-------------
Since each set takes 0{n) time to compute, the time complexity is 0(n2"). In practice,
this approach is very fast. Furthermore, its space complexity is 0(n) when we want
to just enumerate subsets, e.g., to print them, rather that to return all the subsets.

Recursive prcocess-
-------------------
Take empty set first and take each elemnt from the given list.Now we have 2 choice either we will it in empty set or not.


                                                 |---------------{}
                                                 |
                          |--------------{}------|
                          |                      |
      |-------------{}----|                      |---------------{3}
      |                   |
      |                   |
      |                   |                      |---------------{2}
{}----|                   |--------------{2}-----
      |                                          |--------------{2,3}
      |
      |                                          |--------------{1}
      |                   |--------------{1}-----
      |-------------{1}---|                      |---------------{1,3}
                          |
                          |                      |---------------{1,2}
                          |--------------{1,2}----
                                                 |---------------{1,2,3}

  Now take , all the last level elements , it will be the power set.In each step we are taking input from the previous step  and taking next element   from the list and deceding wheather
  we should add that elemt or not in each elemnt of the input.

The number of recursive calls, C(n) satisfies the recurrence C(n) = 2 C(n - 1), which
solves to C(n) = (9(2”). Since we spend 0(n) time within a call, the time complexity
is 0(n2n). The space complexity is 0(n2n), since there are 2" subsets, and the average
subset size is n/ 2. If we just want to print the subsets, rather than returning all of
them, we simply perform a print instead of adding the subset to the result, which
reduces the space complexity to 0(n) — the time complexity remains the same.

 */
