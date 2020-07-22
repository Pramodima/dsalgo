package binarysearch;

/* Let A={5,8,9,11,13,16,18,23,25,28,32,35,38,39}
Case-1
-------
Let's take an element 15 and substract it from each element and take absolute value.
The resulting array is B={10,7,6,4,2,1,3,8,10,13,17,20,23,24}
The minimum in resulting array is 1.And it corresponds to number 16.So 16 is the answer.
Case-2
-------
Let's take an element 16 and substract it from each element and take absolute value.
The resulting array is B={11,8,7,5,3,0,2,7,9,11,16,19,22,23}
The minimum in resulting array is 0.And it corresponds to number 16.So 16 is the answer.

So, if the given elelment is present in the array.It is the answer.
If not present, then  take its floor and ceilling  and take the difernce from the element
whichever gives the lower value ,will be the answer.
 */
public class MinimumDifferenceElementInASortedArray {
    public static int  getMinDifferenceElement(int[] a,int key){
        final int floor = FloorOfAnElementInASortedArray.getTheFloorOfAnElement(a, 0, a.length - 1, key);
        final int ceil = CeillingOfAnElementInASortedArray.getTheCellingOfAnElement(a, 0, a.length - 1, key);
        if(a[floor]==key || a[ceil]==key){
            return key;
        }
        else{
          return  Math.abs(key-a[floor])>Math.abs(key-a[ceil])?a[ceil]:a[floor];
        }
    }

    public static void main(String[] args) {
        int[] a={5,8,9,11,13,16,18,23,25,28,32,35,38,39};
        System.out.println(MinimumDifferenceElementInASortedArray.getMinDifferenceElement(a,19));
    }
}
