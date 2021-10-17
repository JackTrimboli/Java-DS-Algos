package LinearSearch;

public class LinearSearch {
    
    public static void main(String[] args){

    }
    public int linearSearch(int[] a, int x){
        for(int i = 0; i < a.length; i++){
            if(a[i] == x)
            {
                return i;
            }

        }
        return -1;

    }
    
}
