package BinarySearch;


public class BinarySearch {
    public static void main(String[] args){
        System.out.println("Index: " + binarySearch(new int[]{1,2,3,4,7,9,12,19}, 2));
    }
    public static int binarySearch(int[] a, int x){
        int p = 0;              // beginning of the range
        int r = a.length - 1;   //end of the range
      
        while(p <= r) {
            int q = (p+r)/2;    //midpoint
            if(x < a[q]) r = q - 1;
            else if(x > a[q]) p = q + 1;
            else return q;
        }
        return -1;
    }
    
}