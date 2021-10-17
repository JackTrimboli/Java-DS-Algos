package QuickSort;


public class QuickSort {
    public static void sort(int[] inputArray){
        sort(inputArray, 0, inputArray.length-1);
    }
    public static int[] sort(int[] inputArray, int start, int end){
        if(start < end){
            int mid = partition(inputArray, start, end); //picks a partition point. Sorts all greater values of the given range and moves the mto the rigth or left of the parititon point
            sort(inputArray, start, mid - 1); 
            sort(inputArray, mid+1, end);
        }
        return inputArray;
    }
    public static int partition(int[] inputArray, int start, int end){
        int x = inputArray[end]; // pick our pivot value (the value which is compared to the rest of the indicies)
        int i = start - 1; 
        for(int j = start; j < end -1; j++){
            if(inputArray[j] <= x){
                i++;
                swap(inputArray, i, j);
            }
        }
        swap(inputArray, i+1, end);
        return i + 1;
    }
    public static void swap(int[] array, int second, int first){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}