/**
 * Created by shreyas.b1 on 12/08/17.
 */
public class Sort {
    int[] arr;
    int[] auxillaryArr;
    public int[] bubbleSort(int arr[]){
        //Compares element with the next element and swaps if the element is greater than the next element
        int temp;
        boolean flag;
        for(int i=1;i<arr.length-1;i++){
            flag=false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(!flag)
                break;
        }
        return arr;
    }
    public int[] selectionSort(int arr[]){
        //Goes through the array to scan the min value and then swaps it with ith location
        int min,temp=0;
        for(int i=0;i<arr.length-1;i++){
            min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        return arr;
    }
    public int[] insertionSort(int arr[]){
        int value,hole;
        for(int i=1;i<arr.length;i++){
            value=arr[i];
            hole=i;
            while(hole>0&&arr[hole-1]>value){
                arr[hole]=arr[hole-1];
                hole--;
            }
            arr[hole]=value;
        }
        return arr;
    }
    public int[] mergeSort(int arr[]){
        this.arr=arr;
        auxillaryArr=new int[arr.length];
        mergesort(0,arr.length-1);
        return this.arr;
    }
    private void mergesort(int low, int high){
        // check if low is smaller than high, if not then the array is sorted
        if(low<high){
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            mergesort(middle+1,high);
            merge(low,middle,high);
        }
    }
    private void merge(int low, int middle, int high) {
        // Copy both parts into the auxillary array
        for (int i = low; i <= high; i++) {
            auxillaryArr[i] = arr[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (auxillaryArr[i] <= auxillaryArr[j]) {
                arr[k] = auxillaryArr[i++];
            } else {
                arr[k] = auxillaryArr[j++];
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            arr[k++] = auxillaryArr[i++];
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.
    }
    public int[] quickSort(int arr[]){
        this.arr=arr;
        quicksort(0,arr.length-1);
        return this.arr;
    }
    private void quicksort(int low,int high){
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = arr[low + (high-low)/2];
        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (arr[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (arr[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }
    private void exchange(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

