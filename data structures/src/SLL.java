/**
 * Created by chiko on 12/21/2016.
 */
public class SLL {
    class Node {
        int data;
        Node next = null;
        Node(int data){
            this.data  = data;
        }
    }
    private Node head;

    public int length(){
        if(head == null)
            return 0;
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insert(int data){
        if(head == null){
            head = new Node(data);
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = new Node(data);
    }



    public void insertAtFirst(int data){
        if(head == null){
            head = new Node(data);
            return;
        }

        Node temp = head;
        head = new Node(data);
        head.next = temp;
    }

    public void insertAtIndex(int data, int index){
        if(index < 0)
            return;

        if(index == 0){
            insertAtFirst(data);
            return;
        }

        int length = length();
        if(length < index + 1){
            System.out.println("Index out of bound");
            return;
        }

        int count = 1;
        Node temp = head;
        while(temp.next != null && count <= index - 1){
            count++;
            temp = temp.next;
        }

        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
    }


    public void insertInSortedList(int key){
        if(head == null){
            head = new Node(key);
            return;
        }

        Node temp = head;
        while (temp.next != null && key > temp.next.data){
            temp = temp.next;
        }
        Node next = temp.next;
        Node node = new Node(key);
        node.next = next;
        temp.next = node;
    }


    public void traverse(Node head){
        if(head == null){
            System.out.println("No element in the list");
            return;
        }

        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }


    public void deleteFirst(){
        if(head == null){
            System.out.println("Empty LL");
            return;
        }

        Node temp = head.next;
        head = temp;
    }


    public void deleteAtLast(){
        if(head == null){
            System.out.println("Empty LL");
            return;
        }

        Node temp = head;
        Node prev = null;

        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
    }


    public void delete(int key){
        if(head == null){
            System.out.println("Empty LL");
            return;
        }
        if(head.data == key){
            deleteFirst();
            return;
        }

        Node temp = head;
        Node prev = null;

        while(temp.next != null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
    }


    public int nthFromLast(int n){
        if(head == null){
            return -1;
        }
        Node pNode = head;
        for(int i=0; i<n-1 && pNode != null; i++){
            pNode = pNode.next;
        }

        Node temp = head;
        while (pNode.next != null){
            temp = temp.next;
            pNode = pNode.next;
        }
        return temp.data;
    }


    public boolean cycleExistsFloyds(){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }


    public Node reverseLL(Node current){
        Node prev=null;
        Node next = null;
        while (current != null){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }


    public Node findMiddleElement(){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Node : "+slow.data);
        return slow;
    }


    public void printListFromEnd(Node temp){
        if(temp.next != null){
            printListFromEnd(temp.next);
        }

        System.out.print(temp.data+" ");
    }


    public void lengthOddorEven(){
        Node temp = head;
        while (temp!=null && temp.next!=null){
            temp = temp.next.next;
        }

        if(temp==null)
            System.out.println("Even list");
        else
            System.out.println("Odd list");
    }


    public void pairWiseSwap()
    {
        Node temp = head;

        while (temp != null && temp.next != null) {
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
    }


    public boolean isPalindrome(){
        if(head==null)
            return true;

        Node slow = head, fast = head;
        Node prev=null;
        Node middle = null;
        Node next;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null){
            next = prev.next;
            prev.next = null;
        }else{
            next = slow.next;
            middle = slow;
            prev.next = null;
        }

        Node head1 = head;
        Node head2 = reverseLL(next);

        boolean isPal = compareLL(head1,head2);

        Node head3 = reverseLL(head2);
        if(middle != null){
            prev.next = middle;
            middle.next = head3;
        }else{
            slow.next = head3;
        }

        return isPal;
    }


    public boolean compareLL(Node head1, Node head2){
        while (head1 != null && head2 != null){
            if(head1.data == head2.data){
                head1 = head1.next;
                head2 = head2.next;
            }else{
                return false;
            }
        }

        if(head1 == null && head2 == null){
            return true;
        }

        return false;
    }


    public void modularNode(int k){
        if(head == null){
            System.out.println("Empty LL");
            return;
        }
        if(k <= 0){
            return;
        }
        Node modularNode = null;
        int i=0;
        for(Node temp = head; temp != null; temp = temp.next){
            if(i%k == 0){
                modularNode = temp;
            }
            i++;
        }
        System.out.println("Last Modular Node : "+modularNode.data);
    }


    public Node pivotLL(int k){
        Node root = new Node(0);
        Node pivot = new Node(k);
        Node rootHead = root;
        Node pivotHead = pivot;
        Node temp = head;
        while (temp != null){
            if(temp.data <= k){
                root.next = temp;
                root = root.next;
            }else{
                pivot.next = temp;
                pivot = pivot.next;
            }
            temp = temp.next;
        }
        root.next = pivotHead;
        return rootHead.next;
    }



    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.insert(1);
        sll.insert(4);
        sll.insert(3);
        sll.insert(4);
        sll.insert(5);
        sll.insert(6);
        //System.out.println(sll.length());
        sll.traverse(sll.head);

        //sll.findMiddleElement();
        //sll.printListFromEnd(sll.head);
        //sll.pairWiseSwap();
        System.out.println();
        Node head1 = sll.reverseLL(sll.head);
        System.out.println(head1.data);
        //sll.traverse();
        //System.out.println(sll.isPalindrome());
        //sll.modularNode(2);
    }
}
