package recursion;

public class CountEvenNosInanArray {


    int countEvenPassed(int[] arr) {
        int result = 0;
        countEvenPassed(arr, 0, result);
        return result;
    }

    void countEvenPassed(int[] arr, int i, int result) {
        if (i >= arr.length) return;
        if (arr[i] % 2 == 0) ++result;
        countEvenPassed(arr, i+1, result);
    }

    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        CountEvenNosInanArray c=new CountEvenNosInanArray();
        System.out.println(  c.countEvenPassed(a));
    }
}
