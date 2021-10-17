/*Insertion sort starts by diving the list/array into 2 sections: a sorted section, and an unsorted section. The 
algorithm then moves one item from the unsorted section to the sorted section, until there are no items left in the
unsorted section*/

//Visualization: 
package InsertionSort;
public class InsertionSort{
    public static void main(String[] args){
        int[] myArray = insertionSort(new int[] {9,8,3,13,87,12,99});
        printArray(myArray);
    }
    public static int[] insertionSort(int[] a){
        for(int i = 1; i < a.length; i++) //loop through the array. doesn't start from the 0th 
        //index because the 0th index is the 'sorted' section
        {
            int element = a[i]; //element variable contains the data we intend on bringing over to the sorted section.
            int j = i - 1; //j variable points to the index position of the last value in the sorted area.

            while(j >= 0 && a[j] > element) /*Loop condition: If we get to the end of the sorted section, j = -1. this 
            means it is the new smallest element and goes at the beginning of our sorted section. We also exit the loop
            if we find an element at the jth position that is smaller than the element we intend on placing in the sorted
            section. This because if the element we're bringing over is less than the previous index, but still greater
            than the index we're currently checking, we've found its new position in the array.*/
            {
                a[j + 1] = a[j]; /*since we're inserting a new value into the sorted section by comparing it with each index of the sorted 
                section, each time this loop runs, the value being checked needs to be moved over if the value being inserted is smaller to make space and maintain the correct order*/
                j--; //decrement j to get to the next index in the sorted section(smaller and smaller values each iteration)
            }
            a[j+1] = element; //since the value at the jth index of the sorted section must be less than element being 
            //inserted(or is the smallest value in which case j+1 gives us the 0th index) j+1 gives us the index where the
            //new element belongs.
        }
        return a; //return the newly sorted array
    }
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++)
        {
            System.out.print("["+ array[i] +"] ");
        }
    }
    
    
}