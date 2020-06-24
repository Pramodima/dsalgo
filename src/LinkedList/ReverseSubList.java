package LinkedList;

public class ReverseSubList {

    public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start,
                                                   int finish) {
        if (start == finish) { // No need to reverse since start==finish

            return L;
        }
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> sublistHead = dummyHead;
        int k = 1;
        while (k++ < start) {
            sublistHead = sublistHead.next;
        }
// Reverse sublist.
        ListNode<Integer> sublistiter = sublistHead.next;
        while (start++ < finish) {
            ListNode<Integer> temp = sublistiter.next;
            sublistiter.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode<Integer> n6 = new ListNode(14, null);
        ListNode<Integer> n5 = new ListNode(12, n6);
        ListNode<Integer> n4 = new ListNode(11, n5);
        ListNode<Integer> n3 = new ListNode(9, n4);
        ListNode<Integer> n2 = new ListNode(3, n3);
        ListNode<Integer> n1 = new ListNode(2, n2);


        ReverseSubList reverseSubList=new  ReverseSubList();
        final ListNode<Integer> integerListNode = reverseSubList.reverseSublist(n1,2,5);
        System.out.println(integerListNode);
    }
}
/*
The time complexity is dominated by the search for the / th node, i.e., 0(f).
sublistHead=2->3->9->11->-12->14
sublistIter=3->9->11->-12->14
Iterration-1
----------------
temp        =9->11->-12->14
sublistIter =3->11->-12->14
sublistHead=2->3->11->-12->14
temp       =9->3->11->-12->14
sublistHead=2->9->3->11->-12->14
Iterration-2
----------------
temp       =11->-12->14
sublistIter=3->12->14
sublistHead=2->9->3->12->14
temp       =11->9->3->12->14
sublistHead=2->11->9->3->12->14

Iterration-3
----------------
temp         =12->14
sublistIter  =3->14
sublistHead  =2->11->9->3->14
temp         =12->11->9->3->14
sublistHead  =2->12->11->9->3->14
*/