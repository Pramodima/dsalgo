package bst;

import sun.applet.Main;

import java.util.*;
/*
* 15.6 FIND THE CLOSEST ENTRIES IN THREE SORTED ARRAYS
Design an algorithm that takes three sorted arrays and returns one entry from each
such that the minimum interval containing these three entries is as small as possible.
For example, if the three arrays are (5,10,15), (3,6,9,12,15), and (8,16,24), then
15,15, 16 he in the smallest possible interval.
 */
public  class ArrayData implements Comparable<ArrayData> {
    public int val;
    public int idx;

    public ArrayData(int idx, int val) {
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(ArrayData o) {
        int result = Integer.compare(val, o.val);
        if (result == 0) {
            result = Integer.compare(idx, o.idx);
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ArrayData)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ArrayData that = (ArrayData) obj;
        return this.val == that.val && this.idx == that.idx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, idx);
    }

    public static int findMinDistanceSortedArrays(
            List<List<Integer>> sortedArrays) {
// Indices into each of the arrays.
        List<Integer> heads = new ArrayList<>(sortedArrays.size());
        for (List<Integer> arr : sortedArrays) {
            heads.add(0);
        }
        int result = Integer.MAX_VALUE;
        NavigableSet<ArrayData> currentHeads = new TreeSet<>();
// Adds the minimum element of each array in to currentHeads.
        for (int i = 0; i < sortedArrays.size(); ++i) {
            currentHeads.add(new ArrayData(i, sortedArrays.get(i).get(heads.get(i))));
        }

        while (true) {
            result = Math.min(result,
                    currentHeads.last().val - currentHeads.first().val);
            int idxNextMin = currentHeads.first().idx;
// Return if some array has no remaining elements.
            heads.set(idxNextMin, heads.get(idxNextMin) + 1);
            if (heads.get(idxNextMin) >= sortedArrays.get(idxNextMin).size()) {
                currentHeads.forEach(i->{
                    System.out.println(i.val);
                });
                return result;
            }
            currentHeads.pollFirst();
            currentHeads.add(new ArrayData(
                    idxNextMin, sortedArrays.get(idxNextMin).get(heads.get(idxNextMin))));
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> list=new  ArrayList<>();
       List<Integer>  a=new ArrayList<>();
       a.add(5);a.add(10);a.add(15);//, (3,6,9,12,15), and (8,16,24),
        List<Integer>  b=new ArrayList<>();
        b.add(3);b.add(6);b.add(9);b.add(12);b.add(15);
        List<Integer>  c=new ArrayList<>();
        c.add(8);c.add(50);c.add(60);
        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(findMinDistanceSortedArrays(list));
    }
}
