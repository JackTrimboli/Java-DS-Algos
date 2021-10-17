package SinglyLinkedList;
//Each node only knows the reference to the next node. Can only traverse forward, hence *singly* linked list, because it is only linked one way

public class SinglyLinkedList 
{
    private Node first; //points to the first node in the singly linked list
    private int count; //personal use. keeps count each time a new node is inserted

    public SinglyLinkedList()
    {
        count = 1;
    }
    public boolean isEmpty()    //checks if the first node points to null. If this is the case, the list has to be empty
    {
        return(first == null);
    }
    public void insertFirst(int data) //used to insert at the beginning of the list
    {
        count++;
        Node newFirst = new Node();
        newFirst.data = data; //new node is created an assigned the new data
        newFirst.next = first;  // the new node now points to the old first node
        first = newFirst; //the 'first' reference variable now points to the new node, making it first in the list
    }
    public void insertLast(int data) //*** NOT EFFICIENT ***, because the loop has to iterate as many times as the list has nodes, its is considered linearly dependent, or O(n). 
    // This would suck for a really long list
    {
        Node currentNode = first;
        while(currentNode.next != null)
        {
            currentNode = currentNode.next; //Continues to loop until current.next is null
        }
        Node LastNode = new Node();
        LastNode.data = data;
        currentNode.next = LastNode;

    }
    public Node deleteFirst() //this deletes the reference to the first node, effectively 'detaching' the node from the list.
    {
        Node temp = first; //stores the current data of first
        first = first.next; //sets the first position to the node it was originally pointing to (the next one on the list)
        return temp;    //return the data of the old first node
    }
    public void displayList() //print list
    {
        System.out.println("List first --> last");
        Node currentNode = first;

        while(currentNode != null)
        {
            currentNode.displayNode();
            currentNode = currentNode.next;
        }

    }
    public int getListLength()
    {
        return count;
    }
    
}