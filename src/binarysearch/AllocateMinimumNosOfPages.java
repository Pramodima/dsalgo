package binarysearch;
/*
Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages.
Every student is assigned to read some consecutive books.
The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.

Let there are 4 books with int[] pages=(12,34,67,90) and number of students(m)=2
Let S1 and S2 be two students
We can give S1 ={12} pages and S2={34,67,90}=191 pages.Max number of pages allocated to S2.
We can give S1 ={12,34}=46 pages and S2={67,90}=157 pages Max number of pages allocated to S2.
We can give S1 ={12,34,67}=113 pages and S2={90} pages    Max number of pages allocated to S1.
Total max allocations={191,157,113}. out of this 113 is minimum. so 113 is answer.

Any student can get books consucatively like a student can not get books like 12,34,90.Because
these are not consecutive
Here our aim is not to overburden the students.That's why we are taking minimum.


Here isValid method is important.AS it takes the mid of the binary search as max and checks, if the max nos of pages
we got is a valid nos of pages we can assign a student. We compare the conscutive sum of the pages of books with max.
If the sum exceeds than max, then we increase the student count.ie increase the tha max nos of student required with
this max as threshold.Ie. a student can get maximum these nos of pages.And we reintialize sum as a[i], as next students
share of pages is started.

Similarly we start for the next student and if sum exceeds than max ,then we increase the student count.And assign sum to fresh a[i].

And we continue.If we find the max nos of student required is greater than actual nos of student given,then our isVald method freturns false.
It means we go in right direction of mid, as we need more number of pages than max to minimze the max nos of student.

And if we find the max nos of student required is less than equal actual nos of student given,then our isValid method returns true.
it means the max given by mid of binary search is a larger nos of pages to read for one student, so we try to minimize it,so we go left.

* */
public class AllocateMinimumNosOfPages {
    public static int getMInAllocation(int[] a,int nosOfStudent){
        if(a.length<nosOfStudent)//student more book less, so each student can not get a book.
            return -1;
        int result=-1;
        int start=a[a.length-1];//max of the array
        int end=0;
        for(int element:a){
            end+=element;
        }
        while(start<=end){
        int mid=start+(end-start)/2;
        if(isValid(a,a.length,nosOfStudent,mid)){
            result=mid;
            end=mid-1;
        }
        else{
            start=mid+1;
        }
        }
        return result;
    }

    private static boolean isValid(int[] a, int length, int nosOfStudent, int max) {
        int maxStudentReuired=1;
        int sum=0;
        for (int i=0;i<length;i++){
            sum+=a[i];
            if(sum>max){
                maxStudentReuired++;
                sum=a[i];
            }
            if(maxStudentReuired>nosOfStudent){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a[]={12,34,67,90};
        int b[]={10,20,30,40};
        final int mInAllocation = getMInAllocation(b, 5);
        System.out.println(mInAllocation);
    }
}
