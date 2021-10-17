package SinglyLinkedList;

public class App 
{
    public static void main(String[] args)
    {
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.insertFirst(100);
        myList.insertFirst(200);
        myList.insertFirst(300);
        myList.insertFirst(400);
        myList.insertLast(500);

        myList.displayList();
        System.out.println("The number of elements in this list is: " + myList.getListLength());

    }
    
}