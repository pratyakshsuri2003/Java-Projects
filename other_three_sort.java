import java.util.*;
public class other_three_sort {
    public static void main(String[] args) {
        // create an object of the Main class
        first_three_sort obj = new first_three_sort();
        // random number generator
        Random r=new Random();
        int n=10;
        int x=2;
        // making array of size n
        for(int k=0; k<=14; k++)
        {
            // n=(int)Math.pow(10,k);
            if(k<4){
                n=n*10;
            }
            else{
            n=x*100000;
            x++;
            }
            System.out.print("Value of n is: "+n+'\n');
            // first array for heap sort
            int arr1[]=new int[n];
            // second array for quick sort
            int arr2[]=new int[n];
            // third array for merge sort
            int arr3[]=new int[n];
            // filling array with random numbers for heap sort
            for(int j=0;j<n;j++)
            { 
                arr1[j]=r.nextInt(30);
            }
            // filling array with random numbers for quick sort
            for(int j=0;j<n;j++)
            { 
                arr2[j]=r.nextInt(30);
            }
            // filling array with random numbers for merge sort
            for(int j=0;j<n;j++)
            { 
                arr3[j]=r.nextInt(30);
            }
        // for heap sort
        double start1 = System.nanoTime();
        heapsort(arr1, n);
        double end1 = System.nanoTime();  
        // System.out.println(Arrays.toString(arr));
        double execution1 = (end1 - start1)/1000000;
        System.out.println("Heap Sort: "+ execution1 + " ms");
        // for quick sort
        double start2 = System.nanoTime();
        quickSort(arr2, 0, n-1);
        double end2 = System.nanoTime();  
        // System.out.println(Arrays.toString(arr));
        double execution2 = (end2 - start2)/1000000;
        System.out.println("Quick Sort : "+ execution2 + " ms");
        // for merge sort
        double start3 = System.nanoTime();
        mergeSort(arr3, 0, n-1);
        double end3 = System.nanoTime();  
        // System.out.println(Arrays.toString(arr));
        double execution3 = (end3 - start3)/1000000;
        System.out.println("Merge Sort : "+ execution3 + " ms");
        
      }
    }
    static void merge(int array[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;
    
        int L[] = new int[n1];
        int M[] = new int[n2];
    
        // fill the left and right array
        for (int i = 0; i < n1; i++)
          L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
          M[j] = array[q + 1 + j];
    
        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;
    
        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        // for sorting in descending
        // use if(L[i] >= <[j])
        while (i < n1 && j < n2) {
          if (L[i] <= M[j]) {
            array[k] = L[i];
            i++;
          } else {
            array[k] = M[j];
            j++;
          }
          k++;
        }
    
        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
          array[k] = L[i];
          i++;
          k++;
        }
    
        while (j < n2) {
          array[k] = M[j];
          j++;
          k++;
        }
      }
    
      // Divide the array into two sub arrays, sort them and merge them
      static void mergeSort(int array[], int left, int right) {
        if (left < right) {
    
          // m is the point where the array is divided into two sub arrays
          int mid = (left + right) / 2;
    
          // recursive call to each sub arrays
          mergeSort(array, left, mid);
          mergeSort(array, mid + 1, right);
    
          // Merge the sorted sub arrays
          merge(array, left, mid, right);
        }
      }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
 
        // index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
 
        return i + 1;
    }
 
    /* A[] --> Array to be sorted,
   l  --> Starting index,
   h  --> Ending index */

    static void quickSort(int arr[], int l, int h)
    {
        // Create an auxiliary stack
        int[] stack = new int[h - l + 1];
 
        // initialize top of stack
        int top = -1;
 
        // push initial values of l and h to stack
        stack[++top] = l;
        stack[++top] = h;
 
        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];
 
            // Set pivot element at its correct position
            // in sorted array
            int p = partition(arr, l, h);
 
            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }
 
            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }
    public static void heapsort(int arr[], int n) {
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
          heapify(arr, n, i);
        }
    
        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
          int temp = arr[0];
          arr[0] = arr[i];
          arr[i] = temp;
    
          // Heapify root element
          heapify(arr, i, 0);
        }
      }
    
      static void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
    
        if (l < n && arr[l] > arr[largest])
          largest = l;
    
        if (r < n && arr[r] > arr[largest])
          largest = r;
    
        // Swap and continue heapifying if root is not largest
        if (largest != i) {
          int swap = arr[i];
          arr[i] = arr[largest];
          arr[largest] = swap;
    
          heapify(arr, n, largest);
        }
      }
}
