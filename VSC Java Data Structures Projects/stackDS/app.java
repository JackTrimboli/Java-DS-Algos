package stackDS;

public class app 
{
    public static void main(String [] args)
    {
        System.out.println(reverseString("hello"));
    }
    public static String reverseString(String str)
    {
        Stack theStack = new Stack(str.length());
        String reversed = " ";
        
        for(int i = 0; i < str.length(); i++)
        {
            theStack.push(str.charAt(i));
        }
        for(int i = 0; i < str.length(); i++)
        {
            reversed = reversed + theStack.pop();
        }
        return reversed;
    }
}