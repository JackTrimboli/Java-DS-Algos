package test;

public class test {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        ListNode prev = null;
        ListNode current = head;
        while(current != null){ //This loop rebuilds the list by taking the root and slowly moving items in front of it each iteration
            ListNode next = current.next; //Next variable stands for the next node to be moved over
            current.next = prev; 
            prev = current;
            current = next;
        }
        while(prev != null){
            System.out.print("->" + prev.val);
            prev = prev.next;
        }
           
    }

}
        
       
