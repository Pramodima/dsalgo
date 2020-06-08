package greedyAndInvariant;


import java.util.*;

public class LargestRecatngleInHistoGram {
    //O(n^3) solution
    public int getAreaOfLargestRectangle(int a[]) {
        int max = 0;
        for (int i = 0; i < a.length - 1; i++) {

            for (int j = i; j < a.length; j++) {

                int min = Integer.MAX_VALUE;
//find the minimum of subarray A[i : j]
                for (int k = i; k <= j; k++) {

                    min = a[k] < min ? a[k] : min;
                }
//  here (j - i + 1) denotes the numbr of buidings from i to j
                int area = (j - i + 1) * min;

                max = area > max ? area : max;
            }

        }
        return max;
    }







    //O(n^2) solution
    public int getAreaOfLargestRectangleN2(int a[]){

        int max=0;

        for(int i=0;i<a.length-1;i++){

            int min=a[i];

            for(int j=i;j<a.length;j++){

                min=Integer.min(a[j],min);

                //  here (j - i + 1) denotes the numbr of buidings from i to j
                int area=(j-i+1)*min;

                max=area>max?area:max;
            }
        }
        return max;
    }






    public static int calculateLargestRectangle(List<Integer> heights) {
        Stack<Integer> pillarIndices = new Stack<>();
        int maxRectangleArea = 0;
        for (int i = 0; i <= heights.size(); ++i) {

// By iterating to heights.size() instead of heights.size() - 1, we can
// uniformly handle the computation for rectangle area here.
            while (!pillarIndices.isEmpty()
                    && isNewPillarOrReachEnd(heights , i, pillarIndices.peek())){
                int height = heights.get(pillarIndices.pop());
                int width
                        = pillarIndices.isEmpty() ? i : i - pillarIndices.peek() - 1;
                maxRectangleArea = Math.max(maxRectangleArea , height * width);
            }
            if (!pillarIndices.isEmpty() && i < heights.size()
                    && heights.get(i).equals(heights.get(pillarIndices.peek()))) {
// Replace earlier building with same height by current building. This
// ensures the later buildings have the correct left endpoint.
                pillarIndices.pop();
                pillarIndices.push(i);
            }
            pillarIndices.push(i);
        }
        return maxRectangleArea;
    }
    private static boolean isNewPillarOrReachEnd(List<Integer> heights,
                                                 int currldx , int lastPillarldx) {
        return currldx < heights.size()
                ? heights.get(currldx) < heights.get(lastPillarldx)
                : true;
    }
    public static void main(String[] args) {
      //  int a[]={1,4,2,5,6,3,2,6,6,5,2,1,3};
        List<Integer> heights=new ArrayList<>();
        heights.add(1);heights.add(4);heights.add(2);heights.add(5);heights.add(6);heights.add(3);heights.add(2);heights.add(6);heights.add(6);
        heights.add(5);heights.add(2);heights.add(1);heights.add(3);
        LargestRecatngleInHistoGram lrh=new LargestRecatngleInHistoGram();
        // int areaOfLargestRectangle = lrh.getAreaOfLargestRectangle(a);
        //System.out.println("area "+areaOfLargestRectangle);
        System.out.println(LargestRecatngleInHistoGram.calculateLargestRectangle(heights));
    }
}
