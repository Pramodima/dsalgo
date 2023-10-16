package stack;

public class RainWaterTrapping {
    //Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.
    public static void main(String[] args) {
        RainWaterTrapping rwt=new RainWaterTrapping();
        System.out.println(rwt.getTrappedWaterWithinBuildingsV1());
    }
    private int getTrappedWaterWithinBuildings(){
        int[] buildingHeights={0,1,0,2,1,0,1,3,2,1,2,1};
        int waterTrapped=0;
        for(int i=0;i<buildingHeights.length;i++){
            int leftMax=0;
            int rightMax=0;
            int j=i;
            while(j>=0){
                leftMax = Math.max(leftMax, buildingHeights[j]);
                j--;
            }
            j=i;
            while(j<buildingHeights.length){
                rightMax=Math.max(rightMax,buildingHeights[j]);
                j++;
            }
            waterTrapped+=Math.min(leftMax,rightMax)-buildingHeights[i];
        }
        return waterTrapped;
        /*Time Complexity: O(N*N) as for each index we are calculating leftMax and rightMax so it is buildingHeights nested loop.

          Space Complexity: O(1).*/
    }
    private int getTrappedWaterWithinBuildingsV1(){
        int[] a={2,1,3,4};
        int[] leftMax=new int[a.length];
        int[] rightMax=new int[a.length];
        int waterTrapped=0;
        leftMax[0]=a[0];
        rightMax[a.length-1]=a[a.length-1];
        for(int i=1;i<a.length;i++){
            leftMax[i]= Math.max(leftMax[i-1],a[i]);
        }
        for(int i=a.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],a[i]);
        }
        for(int i=0;i<a.length;i++){
            waterTrapped+= Math.min(leftMax[i],rightMax[i])-a[i];
        }
        return waterTrapped;
        /*Time Complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array.

Space Complexity: O(N)+O(N) for prefix and suffix arrays.

*/
    }
}
