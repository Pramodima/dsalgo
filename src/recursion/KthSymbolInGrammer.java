package recursion;

/*
Suppose on the first row, we have a 0.That is for N=0 and K=0 result is 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 by 01,
and each occurrence of 1 by 10. Suppose we have N rows and index K, we have to find the K-th indexed symbol in row N.

N=0  0                1 st row
N=1  0 1             (as given in question replace 0 as 0  1) 2nd row
N=2  0 1 1 0         (as given in question replace 1 as 1  0) 3 rd row
N=3  0 1 1 0 1 0 0 1                                          4th row
      __________________________________
N=4  |0 1 1 0 1 0 0 1| 1 0 0 1 0 1 1 0 |                        5th row
     |_______________|_________________|
            |
     1 st part is same  2nd part the complement
     as N=3              of N=3
     Same holds for all N.

AS we observe there are even number of element in each row.For N=4, we have 2^4 nos of element.out of these first 8  elements are same as N-1 ie
3rd row and last 8 elements are complements of  elements of N-1 row.

* */
public class KthSymbolInGrammer {

    public int getKthSymbol(int n,int k) {
        if (n == 1 && k==1) {
            return 0;
        }
        int mid =(int) Math.pow(2 , n-1) / 2;
        if (k <= mid)
          return  getKthSymbol(n - 1, k);
        else {
            int kthSymbol = getKthSymbol(n - 1, k - mid);
            if(kthSymbol==0)
                kthSymbol=1;
            else{
                kthSymbol=0;
            }
            return kthSymbol;
        }
    }

    public static void main(String[] args) {
        KthSymbolInGrammer ksg=new KthSymbolInGrammer();
        System.out.println(ksg.getKthSymbol(3,1 ));
    }

}
