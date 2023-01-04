
import java.util.*; 
import java.util.Collections;
import java.util.Vector;

public class bucket {

    static int getMax(int a[]) // function to get maximum element from the given array  
    {  
        int n = a.length;  
        int max = a[0];  
        for (int i = 1; i < n; i++)  
        if (a[i] > max)  
        max = a[i];  
        return max;  
    }  
    static void bucket(int a[], int n) // function to implement bucket sort  
    {  
        // int n = a.length;  
        int max = getMax(a); //max is the maximum element of array  
        int bucket[] = new int[max+1];   
        for (int i = 0; i <= max; i++)  
        {  
            bucket[i] = 0;  
        }  
        for (int i = 0; i < n; i++)  
        {  
            bucket[a[i]]++;  
            
        }  
        for (int i = 0, j = 0; i <= max; i++)  
        {  
            while (bucket[i] > 0)  
            {  
                a[j++] = i;  
                bucket[i]--;  
            }  
        }  
    }  

    public static void main(String[] args) {
        // all_three_sort obj = new all_three_sort();
        // random number generator
        Random r=new Random();
        int n=0;
        // int x=2;
        // making array of size n
        for(int k=0; k<=15; k++)
        {
            // n=(int)Math.pow(10,k);
            if(k<10){
                n=n+10000;
            }
            else{
            n=n+100000;
            // x++;
            }
            System.out.print("Value of n is: "+n+'\n');
            int arr[]=new int[n];
            
            for(int j=0;j<n;j++)
            { 
                arr[j]=r.nextInt();
            }
            // filling array with random numbers for quick sort
            
        double start1 = System.nanoTime();
        bucket(arr, n);
        double end1 = System.nanoTime();  
        // System.out.println(Arrays.toString(arr));
        double execution1 = (end1 - start1)/1000000;
        System.out.println("Bucket Sort: "+ execution1 + " ms");
        for(int j=0;j<n;j++)
            { 
                arr[j]=r.nextInt();
            }
    }
}
}