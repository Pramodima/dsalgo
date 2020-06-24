package LinkedList;

public class MergeTwoSortedList {
    public ListNode<Integer> mergeSortedList(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode<Integer> newList = new ListNode(0, null);
        ListNode<Integer> dummyList = newList;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                newList.next = l1;
                l1 = l1.next;
            } else {
                newList.next = l2;
                l2 = l2.next;
            }
            newList=newList.next;
        }
        newList.next = l1 == null ? l2 : l1;
        return  dummyList;
    }

    public static void main(String[] args) {
        ListNode<Integer> n3 = new ListNode(7, null);
        ListNode<Integer> n2 = new ListNode(5, n3);
        ListNode<Integer> n1 = new ListNode(1, n2);

        ListNode<Integer> l3 = new ListNode(11, null);
        ListNode<Integer> l2 = new ListNode(9, l3);
        ListNode<Integer> l1 = new ListNode(3, l2);
        MergeTwoSortedList mergeToSortedList=new  MergeTwoSortedList();
        final ListNode<Integer> integerListNode = mergeToSortedList.mergeSortedList(l1, n1);
        System.out.println(integerListNode);
    }
}
    class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public ListNode(T i, ListNode o) {
            this.data = i;
            this.next = o;
        }
    }
 /*
    The worst-case, from a runtime perspective, corresponds to the case when the lists
are of comparable length, so the time complexity is 0(n + m). (In the best-case, one
list is much shorter than the other and all its entries appear at the beginning of the
merged list.)

 */