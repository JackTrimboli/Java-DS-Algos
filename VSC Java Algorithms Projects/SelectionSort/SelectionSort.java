/*Selection sort 'selects' a new element (starting at the 0th index and incrememnts by 1 until the last index) each 
iteration of a loop, and compares it to the rest of the values in the array. If it find a smaller value, 
its swaps them. Selection sort will continue to do this until all items in the array are in a ascending order.*/
package SelectionSort;

public class SelectionSort {

    public static void main(String[] args){
        int[] myArray = selectionSort(new int[] {9,8,3,13,87,12,99});
        printArray(myArray);
    
    }
    public static int[] selectionSort(int[] a){

        for(int i = 0; i < a.length; i++)
        {
            int min = i;
            for(int j = i+1; j< a.length; j++) //checks every index that comes after i, and compares the values 
            {
                if(a[j] < a[min]) min = j; //if at any point the index of j is less than the current min, its overwrites as the new min
            }
            swap(a, i, min); //swaps i and min. if the values end up being the same it doesn't effect anything
        }
        return a;
    }
    public static void swap(int[] a, int i,int min){
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++)
        {
            System.out.print("["+ array[i] +"] ");
        }
    }
}
                                          