package binarysearch;
/*
Let A={10,20,30,40,50
       11,21,31,41,51
       15,24,32,43,54
       18,27,34,48,56
       }
be a sortred row wise and column wise 4 by 4 matix(2d array).
Now we want to search an element ,eg. 16.
lets start from the right upper corner ie. 50.Since the last(4th) column is sorted and
And starting   element is 50, Now we have 2 options, either go down or go left.since means all the elements in this column are greater than 50.
So we discard the 4 the column.And go to left.Ie we reached at 40.

Now we have 2 options, either go down or go left.
And now we discard 3rd column ,as 40 is greater than 16.And 3rd column is sorted.
Now move left and we reached at 30.

Now we have 2 options, either go down or go left.
And now we discard 2nd column ,as 30 is greater than 16.And 2rd column is sorted.
Now move left and we reached at 20.

Now we have 2 options, either go down or go left.
And now we discard 1st column ,as 20 is greater than 16.And 1st column is sorted.
Now move left and we reached at 10.

Now we have only option we can go down, but  not left
Since 10 is less than 16 , so we go down and check each element.When we found an element greater than 16 so stop scanning down
 and we go left as left is small than is.

 And this process continue till we found the item or exhaust all indexes.

 Time Complexity is O(m+n)
* */
public class SearchRowwiseColumnWiseSorted2dArray {
    public static RowColumn getIndex(int[][] a,int key,int row,int col){
        RowColumn rc1=new RowColumn();
        rc1.setRow(-1);
        rc1.setColumn(-1);
        int i=0;
        int j=col-1;
        RowColumn rc=new RowColumn();
        rc.setRow(0);
        rc.setColumn(j);
        while(i<row&&j>=0){
            if(a[rc.getRow()][rc.getColumn()]>key){
                j--;
                rc.setRow(i);
                rc.setColumn(j);
            }
            else if(a[rc.getRow()][rc.getColumn()]<key){
                i++;
                rc.setRow(i);
                rc.setColumn(j);
            }
            else if(a[rc.getRow()][rc.getColumn()]==key){
                return rc;
            }
            else{

                return rc1;
            }
        }
        return rc1;
    }

    public static void main(String[] args) {
      int[][]  a={
                 {10,20,30,40,50},
                 {11,21,31,41,51},
                 {15,24,32,43,54},
                 {18,27,34,48,56}
        };
        System.out.println(getIndex(a,9,4,5));
    }
}
class RowColumn{
    private int row;
    private int column;
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "RowColumn{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}