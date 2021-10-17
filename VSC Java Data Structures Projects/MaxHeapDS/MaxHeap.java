 /*
                                    ***INSERTION ALGORITHM***
        find the next available position in the tree. If inserted value is greater than its parent, 
        continue swapping the current value with its parents value until its either less than its parent, 
        or it becomes the root itself

                                    ***REMOVAL ALGORITHM***
        Remove the root, replacing it with the most recently added value in the tree. 
        Once replaced, continously check each left and right value, swapping the new root with the greater of its children.
        Once the Max Heap is in descending order, the removal is complete.

                                        ***FORMULAS*** 
        Find left child: 2n + 1 where n is the index position of the parent
        Find right child: 2n + 2 where n is the index position of the parent
        Find the parent of a specific child: n-1/2 (rounded down) where n is the index position of the child
        */
package MaxHeapDS;



public class MaxHeap { 
    private Node[] heapArray;
    private int maxSize; //size of the array
    private int currentSize; //used to keep track of how many nodes are in the heap

    public MaxHeap(int maxSize){
        this.maxSize = maxSize;
        currentSize = 0; 
        heapArray = new Node[maxSize];
    }
    public int getSize(){
        return currentSize;
    }
    public boolean isEmpty(){
        return (currentSize == 0);
    }
    public boolean insert(int data){
        if(currentSize == maxSize){
            System.out.println("The array is full!");
            return false;
        }
        Node newNode = new Node(data);
        heapArray[currentSize] = newNode;

        //*trickle up the tree* keep checking if the parent is greater. if it is, swap the nodes.
        trickleUp(currentSize);
        currentSize++;
        return true;
    }
    public Node remove(){
        Node root = heapArray[0];
        currentSize--;
        heapArray[0] = heapArray[currentSize];
        trickleDown(0);
        return root;
        
    }
    private void trickleDown(int index){
        int largerChildIndex;
        Node top = heapArray[index]; // save last node into the top var

        //will run as long as index is not on the bottom row(at least 1 child)
        while(index < currentSize/2){
            int leftChild = 2 * index + 1; //left child index pos
            int rightChild = 2 * index + 2; //right child index pos'

            //figure out which child is larger. Swap the larger child with index
            if(rightChild < currentSize
             && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()){
                largerChildIndex = rightChild;
            }
            else{
                largerChildIndex = leftChild;
            }   
            if(top.getKey() >= heapArray[largerChildIndex].getKey()){ 
                //successfully made root the largest key
                break;
            }
            heapArray[index] = heapArray[largerChildIndex];
            index = largerChildIndex; // go down 

        }
        heapArray[index] = top;
    }
    public void swap(int first, int second){
        Node temp = heapArray[first];
        heapArray[first] = heapArray[second];
        heapArray[second] = temp;
    }
    public void trickleUp(int currentPosition){
        int parentPosition = (currentPosition - 1) / 2;
        Node nodeToInsert = heapArray[currentPosition];

        //loop as long as we haven't reached the root and key of currentpositions' parent is less than new node
        while(currentPosition > 0 && heapArray[parentPosition].getKey() < nodeToInsert.getKey()){ 
            heapArray[currentPosition] = heapArray[parentPosition];
            currentPosition = parentPosition;
            parentPosition = (parentPosition - 1) / 2; // move up
        }
        heapArray[currentPosition] = nodeToInsert;
    }
    public void displayHeap(){
        System.out.println("\n.......................................................");
        System.out.println("Heap In Order: ");
        for(int i = 0; i < currentSize; i++){
            System.out.print(" " + heapArray[i].getKey() + ",");
        }
        System.out.println("\n.......................................................");

        int printLimit = 1;
        int depth = findDepth();
        int numBlanks = (int)(Math.pow(depth,2));
        int i = 0;
        int column = 0;
        while(i < currentSize){ //continues until all nodes are printed
            for(int j = 0; j < printLimit; j++){
                if(column == 0){
                    for(int k = 0; k < numBlanks; k++){
                        System.out.print(" ");
                    }
                }
                System.out.print(heapArray[i].getKey());
                i++;

                if(i == currentSize){
                    System.out.println();
                    break;
                }
                column++;

                if(column == printLimit){
                    printLimit*=2;
                    numBlanks /= 2; 
                    column = 0;
                    System.out.println();
                } 
                else{
                    for(int p = 0; p < numBlanks*2; p++){
                        System.out.print(" ");
                    }
                }

            }
            
        }
    }
    public int findDepth(){
        int checker = 1;
        int lineCount = 0;
        int previousLine = 1;
        while(currentSize >= checker){ 
            lineCount++; 
            previousLine *= 2; 
            checker += previousLine;
        }
        return lineCount + 1;
    }
}
