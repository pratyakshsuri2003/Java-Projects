import java.util.*;
public class first_three_sort {
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
            int arr[]=new int[n];
            // filling array with random numbers
            for(int j=0;j<n;j++)
            { 
                arr[j]=r.nextInt(30);
            }
        // for bubble sort
        double start1 = System.nanoTime();
        bubble(n, arr);
        double end1 = System.nanoTime();  
        // System.out.println(Arrays.toString(arr));
        double execution1 = (end1 - start1)/1000000;
        System.out.println("Bubble Sort : "+ execution1 + " ms");
        // for insertion sort
        for(int j=0;j<n;j++)
            { 
                arr[j]=r.nextInt(30);
            }
        double start2 = System.nanoTime();
        insertion(n, arr);
        double end2 = System.nanoTime();  
        // System.out.println(Arrays.toString(arr));
        double execution2 = (end2 - start2)/1000000;
        System.out.println("Insertion sort : "+ execution2 + " ms");
        // for selection sort
        for(int j=0;j<n;j++)
            { 
                arr[j]=r.nextInt(30);
            }
        double start3 = System.nanoTime();
        selection(n, arr);
        double end3 = System.nanoTime();  
        // System.out.println(Arrays.toString(arr));
        double execution3 = (end3 - start3)/1000000;
        System.out.println("Selection Sort : "+ execution3 + " ms");
    
        }
    }
    static void selection(int n, int[] arr){
        // get the start time
        
        for (int i = 0; i < n - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < n; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }
        // get the end time
        
    } 
    static void insertion(int n, int array[]) {  
        // int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    }   
    static void bubble(int n, int[] arr){
        // int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
    }
}
