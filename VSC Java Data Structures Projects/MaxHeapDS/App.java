package MaxHeapDS;

public class App {
    public static void main(String[] args){
        MaxHeap myHeap = new MaxHeap(100);

        myHeap.insert(17);
        myHeap.insert(15);
        myHeap.insert(9);
        myHeap.insert(1);
        myHeap.insert(12);
        myHeap.insert(3);
        myHeap.insert(8);

        myHeap.displayHeap();
        

    
    }
    
}