package CompetetiveProgramming;


//Initial Template for Java

import java.io.*;
import java.util.*;

 public class ArraySwap{
	  
	  // Driver code
		public static void main (String[] args) {
		    // Input using Scanner class
			Scanner sc = new Scanner(System.in);
			
			int testcase = sc.nextInt();
			
			while(testcase-- > 0){
			    int sizeof_array = sc.nextInt();
			    int a[] = new int[sizeof_array];
			    
			    for(int i = 0;i<sizeof_array;i++){
			        a[i] = sc.nextInt();
			    }
			    
			    Geekss obj = new Geekss();
			    obj.swapElements(a, sizeof_array);
			}
			
		}
	} 


 class Geekss{
  static void swapElements(int a[], int n){
      int temp =0;
      
      for(int i=0;i<a.length-2;i++){
          temp = a[i];
          a[i] =a[(i+2)];
          a[(i+2)]= temp;
      }
      
      for (int i=0;i<a.length;i++) {
    	  System.out.print(a[i]+ " ");
      }
      System.out.println();
      
      
  }
}

