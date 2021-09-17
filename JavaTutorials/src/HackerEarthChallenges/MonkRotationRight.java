package HackerEarthChallenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MonkRotationRight {
  
	
	public static void main(String[] args) {
		MonkRotationRight monk = new MonkRotationRight();
		int Array[] = { 1, 2, 3, 4, 5, 6 };
		monk.rotateRight(Array, 6, 2);
		monk.printArray(Array, 6);
		
	}
	
	/*Function to left rotate arr[] of size n by d*/
	public void rotateRight(int[] Array,int N,int D) {
		for(int i=0;i<D;i++) {
			rotateRightByOne(Array, N);
		}
	}

	
	public void rotateRightByOne(int[] Array,int N )
	{
		int temp = Array[N-1];
		for(int i=N-1;i>0;i--) {
		Array[i] = Array[i-1];
		}
		Array[0]=temp;
	}
	
	
	   void printArray(int arr[], int n)
	    {
	        for (int i = 0; i < n; i++)
	          System.out.print(arr[i] + " ");
	    }
}
