/**
 * Created by chiko on 1/17/2017.
 */
public class DeepCopyOfLinkedList {

    public static class ListNode{
        int data;
        ListNode next;
        ListNode arb;

        public ListNode(int data){
            this.data = data;
            this.next = null;
            this.arb = null;
        }
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        ListNode head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.arb = n3;
        n2.arb = n1;
        n3.arb = n5;
        n4.arb = n3;
        n5.arb = n2;

        ListNode newHead = getDeepCopyOfLinkedList(head);
        while(newHead != null){
            if(newHead.next == null){
                System.out.println(newHead.data + " null " + newHead.arb.data);
                return;
            }
            System.out.println(newHead.data + " " + newHead.next.data + " " + newHead.arb.data);
            newHead = newHead.next;
        }
    }

    public static ListNode getDeepCopyOfLinkedList(ListNode head){
        ListNode original = head;
        ListNode newHead = null;

        while (original != null){
            ListNode copy = new ListNode(original.data);
            copy.next = original.next;
            original.next = copy;
            original = original.next.next;
        }

        original = head;
        while (original != null){
            original.next.arb = original.arb.next;
            original = original.next.next;
        }

        original = head;
        while (original != null){
            ListNode copy = original.next;
            if(newHead == null)
                newHead = copy;
            original.next = original.next.next;
            if(original.next == null)
                copy.next = null;
            else
                copy.next = copy.next.next;
            original = original.next;
        }
        return newHead;
    }
}
