package QueueDS;

public class App 
{
    public static void main(String[] args)
    {
        Queue myQueue = new Queue(5);
        myQueue.insert(101);
        myQueue.insert(122);
        myQueue.insert(3);
        myQueue.insert(23);
        myQueue.insert(11);
        myQueue.insert(11);
        myQueue.insert(11);
        myQueue.view();


    }
    
}