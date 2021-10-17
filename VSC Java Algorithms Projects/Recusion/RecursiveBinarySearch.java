package Recusion;

public class RecursiveBinarySearch {
    public static void main(String[] args){
        System.out.println(recursiveBinarySearch(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}, 0, 15, 3));

    }
    public static int recursiveBinarySearch(int[] a, int p, int r, int x){
        System.out.println("[ " + p + "..." + r + " ]");
        if(p > r) 
            return -1;
        else{
            int q = (p + r) / 2;
            if(x < a[q]) return recursiveBinarySearch(a, p, q-1, x);
            else if(x > a[q]) return recursiveBinarySearch(a, q+1, r, x);
            else return q;
        }
    }
}