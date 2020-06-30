
package stack;

import java.util.*;

public class LargestAreaUnderHistogram {
    public  List<Integer> getNextSmallestElementInRight(int[] a){
        Stack<Pair> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        for(int i=a.length-1;i>=0;i--){

            while(!stack.isEmpty()){
                Pair element = stack.peek();
                if(a[i]>element.getElement()){
                    result.add((element.getIndex()-i));
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result.add(a.length-i);
            }
            stack.push(new Pair(a[i],i));
        }
        Collections.reverse(result);
        return result;
    }

    public  List<Integer> getNextSmallestElementInLeft(int[] a){
        Stack<Pair> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<=a.length-1;i++){

            while(!stack.isEmpty()){
                Pair element = stack.peek();
                if(a[i]>element.getElement()){
                    result.add(i-element.getIndex());
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result.add(i-(-1));
            }
            stack.push(new Pair(a[i],i));
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] b={ 10, 4, 5, 9, 12, 8};
        int b[]={1,4,2,5,6,3,2,6,6,5,2,1,3};
        LargestAreaUnderHistogram largestAreaUnderHistogram=new LargestAreaUnderHistogram();
        final List<Integer> nearestSmallestIndexInLeft = largestAreaUnderHistogram.getNextSmallestElementInLeft(b);
        final List<Integer> nearestSmallestIndexInRight = largestAreaUnderHistogram.getNextSmallestElementInRight(b);
        List<Integer> TotalNumberOfBuildingsSupportedByTheCurrentPillar=new ArrayList<>();
        List<Integer> areaOfTheRectangleSupportedByCurrentBuilding=new ArrayList<>();
        for(int i=0;i<nearestSmallestIndexInLeft.size();i++){
            TotalNumberOfBuildingsSupportedByTheCurrentPillar.add(nearestSmallestIndexInLeft.get(i)+nearestSmallestIndexInRight.get(i)-1);//-1 because, we added current building twice .once in left and once in right
        }
        for(int i=0;i<TotalNumberOfBuildingsSupportedByTheCurrentPillar.size();i++){
            final int area = TotalNumberOfBuildingsSupportedByTheCurrentPillar.get(i) * b[i];
            areaOfTheRectangleSupportedByCurrentBuilding.add(area);
        }
        System.out.println(Collections.max(areaOfTheRectangleSupportedByCurrentBuilding));
        System.out.println("nearestSmallestIndexInLeft "+nearestSmallestIndexInLeft);
        System.out.println("nearestSmallestIndexInRight "+nearestSmallestIndexInRight);
    }
}
class Pair{
    public Pair(int element, int index) {
        this.element = element;
        this.index = index;
    }

    int element;
    int index;

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockSpanProblem.Pair pair = (StockSpanProblem.Pair) o;
        return element == pair.element &&
                index == pair.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, index);
    }


}
/*

Here we take each building as pillar .And take number of building, to its right/left,  which are greater that or equal to height of this building.
Now this problem boils down to number of buildings greater than left , ie we have to find out nearest smallest element to its left.
Similarly we have to find out the  nearest smallest elemnt in right.

And we will sum up the corrsponding entries in left and right array.And substarct 1 from it ,as current builging is summed twice.
Now multiply height of the current building with sum.And we get area of the largest rectangle  for that building.




*/


