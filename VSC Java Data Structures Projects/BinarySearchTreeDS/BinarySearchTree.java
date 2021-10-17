package BinarySearchTreeDS;
import java.util.*;


public class BinarySearchTree{
    Node root;

    public void insert(int key, String value){
       
        Node newNode = new Node(key, value);

        if(root == null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                
                if(key < current.key){
                    current = current.left;
                    if(current == null){ //If true,current's parent is a leaf node if untrue, the traversing continues and the loop iterates again
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return;
                    }
                } 
            }
        }
    }
    public boolean delete(int key){ //key is the node being deleted
        //For a leaf node: simply erase the pointer to the node by setting the reference to null
        //For a node with one child: move the subtree to the node we're trying to delete
        //For a node with TWO children: replace the deleted node with the smallest of the nodes larger than that node
        Node current = root;
        Node last = current;
        boolean isLeftNode = false;

        while(current.key != key){ //traverses the binary search tree and finds the node to be deleted. keeps track of the previous node
            last = current;
            if(key < current.key){
                current = current.left;
                isLeftNode = true;
            }
            else{
                current = current.right;
                isLeftNode = false;
            }
            if(current == null){
                return false;
            }
        }
        //found the node we're trying to delete
        //***CURRENT WILL BE THE NODE TO BE DELETED***
        //***LAST WILL BE THE PART OF THE NODE BEING DELETED***
        if(isLeafNode(current)){ //deletes the node we're trying to delete if it is a LEAF NODE
            if(current == root){
                root = null;
            }
            else if(isLeftNode){
                last.left = null;
            }
            else{
                last.right = null;
            }
            
        }
        else if(current.right == null){ //deletes the node if it has a LEFT child
            if(current == root){ 
                root = current.left;
            }
            else if(isLeftNode){
                last.left = current.left;
            }
            else{
                last.right = current.left;
            }
        }
        else if(current.left == null){ //deletes the node if it has a RIGHT child
            if(current == root){
                root = current.right;
            }
            else if(isLeftNode){
                last.left = current.right;
            }
            else{
                last.right = current.right;
            }
        }
        else{ //in this situation, the node being deleted has two children and must be swapped with the smallest node that is still larger than it
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }
            else if(isLeftNode){
                last.left = successor;
            }
            else{
                last.right = successor;
            }
            successor.left = current.left;
        
        } 
        return true;
    }
    private Node getSuccessor(Node nodeToDelete){
        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete;

        Node current = nodeToDelete.right; //go to the right child to enter the group of nodes larger than the node being deleted

        while(current != null){ //now, traverse left until we reach the smallest number of that group of larger nums
            successorParent = successor;
            successor = current;
            current = current.left;
        } 
        if(successor != nodeToDelete.right){ 
            successorParent.left = successor.right;
            successor.right = nodeToDelete.right;
        }
        return successor;
    }
    public boolean isLeafNode(Node current){
        if(current.left == null && current.right == null)
            return true;
        return false;
    }
    public Node findMin(){
        Node current = root;
        Node last = null;
        while(current != null){
            last = current; 
            current = current.left;
        }
        return last;
    }
    public Node findMax(){
        Node current = root;
        Node last = null;
        while(current != null){
            last = current;
            current = current.right;
        }
        return last;
    }
    public void displayTree(){ 
        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
            
        while(isRowEmpty==false) {
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }      
            while(globalStack.isEmpty()==false) {
                Node temp = (Node)globalStack.pop(); 
                if(temp != null) {
                    System.out.print(temp.key); 
                    localStack.push(temp.left); 
                    localStack.push(temp.right);
                    if(temp.left != null || temp.right != null) {
                        isRowEmpty = false; 
                    }
                } else {
                    System.out.print("--"); 
                    localStack.push(null); 
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks = nBlanks/2;
                
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() ); 
            }
        System.out.println( "......................................................");
     
    }
    public int findDepth(Node root){
        if(root == null)
            return 0;
        
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
            
        if(leftDepth > rightDepth)
            return leftDepth + 1;
        else
            return rightDepth + 1;   
    }
    
  

}