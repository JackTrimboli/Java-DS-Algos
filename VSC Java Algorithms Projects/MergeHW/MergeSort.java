package MergeHW;

public class MergeSort {
    public static void sort(int[] inputArray){
        sort(inputArray, 0, inputArray.length-1);

    }
    public static void sort(int[]inputArray, int start, int end){
        if(end<=start){
            return;
        }
        else{
        int mid = (start + end) / 2;
        sort(inputArray, start, mid);
        sort(inputArray, mid+1, end);
        merge(inputArray, start, mid, end);
        }
    }
    public static void merge(int[] inputArray, int start, int mid, int end){

        int tempArray[] = new int[end - start + 1];

        int leftSlot = start; //index counter for left side of the array
        int rightSlot = mid+1;//index counter for right side of the array
        int k = 0;

        while(leftSlot <= mid && rightSlot <= end){
            if(inputArray[leftSlot] < inputArray[rightSlot]){
                tempArray[k] = inputArray[leftSlot];
                leftSlot++;
            }
            else{
                tempArray[k] = inputArray[rightSlot];
                rightSlot++;
            }
            k++;
        }
        //***the right and left sub arrays have been sorted once the program reaches this point***
        if(leftSlot <= mid){//consider the right side done being sorted. left must be sorted already.
            while(leftSlot <= mid){
                tempArray[k] = inputArray[leftSlot];
                leftSlot++;
                k++;
            }
        }
        else if(rightSlot <= end){ // in this case, if the left side is done being sorted, the right must be sorted already
            while(rightSlot <= mid){
                tempArray[k] = inputArray[rightSlot];
                rightSlot++;
                k++;
            }
        }
        //copy over the temp array into the appropriate slots of the input array
        for(int i = 0; i < tempArray.length; i++){
            inputArray[start+i] = tempArray[i];
        }
    }
    public static void merge2(int[] inputArray, int start, int mid, int end){
        int leftSlot = mid;
        int rightSlot = end - mid;

        int L[] = new int[leftSlot];
        int R[] = new int[rightSlot];

        for(int i = 0; i < leftSlot; i++)
        {
            L[i] = inputArray[1+i];
        }
        for(int j = 0; j < rightSlot; j++)
        {
            R[j] = inputArray[mid+1+j];
        }

        int i = 0; int j = 0;

        int k = 1;
        while(i < leftSlot && j < rightSlot){
            if(L[i] <= R[j]){
                inputArray[k] = L[i];
                i++;
            }
            else{
                inputArray[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < leftSlot){
            inputArray[k] = L[i];
            i++;
            k++;
        }
        while(j < rightSlot){
            inputArray[k] = R[j];
            j++;
            k++;
        }
    
    }
}