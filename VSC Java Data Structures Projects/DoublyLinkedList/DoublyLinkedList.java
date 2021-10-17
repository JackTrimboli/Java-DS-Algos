package DoublyLinkedList;

public class DoublyLinkedList 
{
    private Node first;
    private Node last;

    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public void insertFirst(int data)
    {
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty())
        {
            last = newNode; //if empty, last will refer to the new node being created. Therefore, 
            //the new node will count as the first AND last node in the list.
        }
        else
        {
            first.previous = newNode;
        }
        newNode.next = first;
        this.first = newNode;
    }
    public void insertLast(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        if(isEmpty())
        {
            first = newNode;
        }
        else
        {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
    }
    //assume non-empty list
    public Node deleteFirst()
    {
        Node temp = first;
        if(first.next == null)
        {
            last = null;
        }
        else
        {
            first.next.previous = null; 
        }

        first = first.next;
        return temp;


    }
    public Node deleteLast()
    {
        Node temp = last;
        if(last.previous == null)
        {
            first = null;
        }
        else
        {
            last.previous.next = null;  
            //^^^ last is of type Node and contains an instance variable 'previous' of type node, which points to the 
            //previous node in the list. so, after executing this line, last will still point to the previous node, 
            //but the previous node will not point to last. This effectively makes the previous node the new last node, 
            //even if we haven't set it to the variable last just yet.
        }
        last = last.previous;
        return temp;
    }
    //assume a non-empty list
    public boolean insertAfter(int key, int data)
    {
        Node current = first;  //start from beginning of the list.
        while(current.data != key)
        {
            current = current.next; //keeps going to the next node in the list until it find the node that contains a data value which matches 'key'
            if(current == null) //if current == null, that means we've went through the entire list without finding a matching value
            {
                return false; //if this is the case, we can't insert data after a value we can't find, so the method returns false.
            }
        }
        Node newNode = new Node(); //if the compiler reaches this point, it means we've found a matching key value. we create a new node which will soon be inserted.
        newNode.data = data; //we set the node's data to the int being passed in
        if(current == last) //check if the node we're inserting after is the last node in list. Since we're inserting AFTER, the new node would be the new LAST NODE in the list.
        {
            current.next = null; //SUBJECT TO CHANGE
            last = newNode; //set the new node to last, making it the new last node in the list

        }
        else
        {
            newNode.next = current.next; //Udemy phrasing of explaination: new node's next field should point to the node ahead of the current one
            //My Explaination: we want the new node to be INBETWEEN the node its being inserted after AND the node that was after the node we're inserting after.
            //BEFORE: before this line our list looked like:   (nodeWeAreInsertingAfter) > (nextNodeInList)
            //AFTER: After this line, our list now looks like this: (newNode) > (nextNodeInList)
            current.next.previous = newNode; //Now, the nextNode in the list points back to newNode
        }
        newNode.previous = current;
        current.next = newNode; //now the list looks like this!: (nodeWeAreInsertingAfter) >< (newNode) >< (nextNodeInList) ('><' simply means they point to each other.)
        return true;
        
       

    }
    //assume non-empty list
    public Node deleteKey(int key)
    {
        Node current = first;
        while(current.data != key)
        {
            current = current.next;
            if(current == null)
            {
                return null;
            }
        }
        if(current == first)
        {
            first = current.next; //make the first field pointto the node following current since current will be deleted
        }
        else
        {
            current.previous.next = current.next;
            
        }
        if(current == last)
        {
            last = current.previous;
        }
        else
        {
            current.next.previous = current.previous;
        }
        return current;

    } 
    public void displayForward()
    {
        System.out.println("First --> Last");
        Node current = first;
        while(current != null)
        {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward()
    {
        System.out.println("Last --> First");
        Node current = last;
        while(current != null)
        {
            current.displayNode();
            current = current.previous;
        }
        System.out.println();

    }
    
}