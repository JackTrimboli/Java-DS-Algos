package stackDS;

public class Stack 
{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int size){

        this.maxSize = size;   //Sets the array equal to the size chosen.
        this.stackArray = new char[maxSize]; //initializes the stackArray, makes 'maxSize' the size of the array.
        this.top = -1;  //will increment every time a new item is added. If this number equals -1, the array is NULL.
    }
    public void push(char j) //used to 'push' things onto the stack
    {
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException("The stack is full!");
        }
        top++; //keeps track of top index
        stackArray[top] = j; //will 'push' the value of j to the top of the stack

    }
    public char pop() //'pops' the value at the top index out of the stack 
    {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("The stack is empty!");
        }
        int old_top = top; //saves the old value that's being popped
        top--; //decrements the current top value to represent the new top of the stack
        return stackArray[old_top]; //returns the value that we intend on popping
      
    }
    public char peak()
    {
        return stackArray[top]; //allows user to peak at the top of the stack
    }
    public boolean isEmpty()
    {
        return(top == -1);  //if top hasn't been incremented, nothing has been added.
    }
    public boolean isFull()
    {
        return(maxSize - 1 == top); //top represenst the index position. EX: if the maxSize of the array is 5, the top index will really only be 4.
    }

}
