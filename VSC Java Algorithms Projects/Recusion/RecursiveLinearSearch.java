package Recusion;

public class RecursiveLinearSearch{
    public static void main(String[] args){

        System.out.println("Value returned: " + recursiveLinearSearch(new int[] {1 , 2 , 3 , 4 , 5}, 5 , 0));

    }
    public static int recursiveLinearSearch(int[] a, int x, int i)
    { 
       if(i > a.length-1) return -1;
       else if(a[i] == x) return i;
       else{ 
           System.out.println("index at: " + i);
           return recursiveLinearSearch(a, x, i+1);
        }
    }
    
}