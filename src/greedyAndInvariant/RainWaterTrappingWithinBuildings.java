package greedyAndInvariant;

public class RainWaterTrappingWithinBuildings {
    private static int getAreaOfTrappedWater(int[] a) {
        int[] b=new int[a.length];
        int tempSum=0;
    for(int i=1;i<a.length;i++){
        int rightLarge=a[i];
        int leftLarge=a[i];
        for(int j=i+1;j<a.length;j++){
            rightLarge=rightLarge>a[j]?rightLarge:a[j];
        }
        for(int j=i-1;j>=0;j--){
            leftLarge=leftLarge>a[j]?leftLarge:a[j];
        }
        int max=rightLarge>leftLarge?leftLarge:rightLarge;
        tempSum+= (max-a[i]);
    }
    return tempSum;
    }

    public static void main(String[] args) {
        int[] a={4,2,3,5,1,2,4};
        final int areaOfTrappedWater = getAreaOfTrappedWater(a);
        System.out.println(areaOfTrappedWater+"  areaOfTrappedWater");
    }
}
/*
We will take the farthest right largest element and farthest left largest element for each elemnt and take smallest element in each of them.
Let it be max.And substarct the orginal building height ie. a[i] from max and take the sum of each of these entity .That sum will be the maximum
trapped water on the building view or histogram.
* */