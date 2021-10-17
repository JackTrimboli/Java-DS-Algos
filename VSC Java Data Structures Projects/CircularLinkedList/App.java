package CircularLinkedList;

public class App 
{
    public static void main(String[] args)
    {
        CircularLinkedList myList = new CircularLinkedList();

        myList.insertFirst(100);
        myList.insertFirst(200);
        myList.insertFirst(300);

        myList.insertLast(300);
        myList.insertLast(300);
        myList.insertLast(300);

        myList.deleteFirst();

        myList.displayList();

        
    }
    
}