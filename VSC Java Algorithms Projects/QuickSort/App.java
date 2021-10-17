package QuickSort;

public class App {
    public static void main(String[] args){
        int [] arr = new int[]{8, 1, 6, 7, 3, 2};
        QuickSort.sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(" " + arr[i]);
        }
    }
    
}   