package CircularLinkedList;

public class CircularLinkedList 
{
    private Node first;
    private Node last;

    public CircularLinkedList()
    {
        first = null;
        last = null;
    }
    public void insertFirst(int data)
    {
        Node newFirst = new Node();
        newFirst.data = data;
        
        if(isEmpty())
        {
            last = newFirst;
        }
        newFirst.next = first;
        first = newFirst;
        
    }
    public void insertLast(int data)
    {
        Node newLast = new Node();
        newLast.data = data;
        if(isEmpty())
        {
            first = newLast;
        }
        else
        {
            last.next = newLast;
            last = newLast;
        }
    }
    public boolean isEmpty()
    {
        return(first == null);
    }
    public int deleteFirst()
    {
        int temp = first.data;
        if(first.next == null)
        {
            last = null;
        }
        first = first.next;
        
        return temp;
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
}