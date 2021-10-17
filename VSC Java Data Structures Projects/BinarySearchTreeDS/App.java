package BinarySearchTreeDS;

public class App {
    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(20, "Twenty");
        tree.insert(10, "Ten");
        tree.insert(5, "Five");
        tree.insert(15, "Fifteen");
        tree.insert(30, "Thirty");
       
        tree.insert(35, "ThirtyFive");
        tree.insert(25, "TwentyFive");
        tree.insert(24, "TwentyFour");
        
        
        tree.displayTree();
    }
       
}