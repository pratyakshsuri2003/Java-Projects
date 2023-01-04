import java.util.Random;

public class all_six_sorts {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 0;

        for (int k = 0; k <= 15; k++) {
            if (k < 10) {
                n = n + 10000;
            } else {
                n = n + 100000;
                // x++;
            }
            System.out.print("Value of n is: " + n + '\n');
            int arr[] = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = r.nextInt();
            }

            // for bubble sort
            double start1 = System.nanoTime();
            bubble(n, arr);
            double end1 = System.nanoTime();
            // System.out.println(Arrays.toString(arr));
            double execution1 = (end1 - start1) / 1000000;
            System.out.println("Bubble Sort : " + execution1 + " ms");
            // empty the array
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
            // for insertion sort
            for (int j = 0; j < n; j++) {
                arr[j] = r.nextInt(30);
            }
            double start2 = System.nanoTime();
            insertion(n, arr);
            double end2 = System.nanoTime();
            // System.out.println(Arrays.toString(arr));
            double execution2 = (end2 - start2) / 1000000;
            System.out.println("Insertion sort : " + execution2 + " ms");
            // empty the array
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
            // for selection sort
            for (int j = 0; j < n; j++) {
                arr[j] = r.nextInt(30);
            }
            double start3 = System.nanoTime();
            selection(n, arr);
            double end3 = System.nanoTime();
            // System.out.println(Arrays.toString(arr));
            double execution3 = (end3 - start3) / 1000000;
            System.out.println("Selection Sort : " + execution3 + " ms");
            // empty the array
            // Setting default value to empty array
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
            // for selection sort
            for (int j = 0; j < n; j++) {
                arr[j] = r.nextInt(30);
            }
            // for heap sort
            double start4 = System.nanoTime();
            heapsort(arr, n);
            double end4 = System.nanoTime();
            // System.out.println(Arrays.toString(arr));
            double execution4 = (end4 - start4) / 1000000;
            System.out.println("Heap Sort: " + execution4 + " ms");
            // empty the array
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
            // for selection sort
            for (int j = 0; j < n; j++) {
                arr[j] = r.nextInt(30);
            }
            // for quick sort
            double start5 = System.nanoTime();
            quickSort(arr, 0, n - 1);
            double end5 = System.nanoTime();
            // System.out.println(Arrays.toString(arr));
            double execution5 = (end5 - start5) / 1000000;
            System.out.println("Quick Sort : " + execution5 + " ms");
            // empty the array
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
            // for selection sort
            for (int j = 0; j < n; j++) {
                arr[j] = r.nextInt(30);
            }
            // for merge sort
            double start6 = System.nanoTime();
            mergeSort(arr, 0, n - 1);
            double end6 = System.nanoTime();
            // System.out.println(Arrays.toString(arr));
            double execution6 = (end6 - start6) / 1000000;
            System.out.println("Merge Sort : " + execution6 + " ms");
        }
    }

    static void bubble(int n, int[] arr) {
        // int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void insertion(int n, int array[]) {
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    static void selection(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j; // searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
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

    static int partition(int arr[], int low, int high) {
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

    /*
     * A[] --> Array to be sorted,
     * l --> Starting index,
     * h --> Ending index
     */

    static void quickSort(int arr[], int l, int h) {
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
