package HackerEarthChallenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Scanner;


	public class TestClass {
		 
		   
		public static void main(String[] args) throws Exception
		    {
		    	

		         //BufferedReader
		        BufferedReader br= new BufferedReader(new 
				InputStreamReader(System.in));
		       
		        int T = Integer.parseInt(br.readLine());
		        
		       while (T!=0) {
				
			
		        int a[] = new int[2];
		        String line = br.readLine(); // to read multiple integers line
		        String[] strs = line.trim().split("\\s+");
		        for (int i = 0; i < 2; i++) {
		            a[i] = Integer.parseInt(strs[i]);
		        }
		        int N = a[0];
       	        int D = a[1];
		        		        
		      String lines = br.readLine(); // to read multiple integers lines  
		      String[] str = lines.trim().split(" ");
		      int Array[] = new int[N];
		      for (int i = 0; i < N; i++) {
		          Array[i] = Integer.parseInt(str[i]);
		      }
				
		
			   rotateRight(Array, N, D);
			   printArray(Array, N);
		       }
			}

			/*Function to left rotate arr[] of size n by d*/
			static void rotateRight(int[] Array,int N,int D) {
				for(int i=0;i<D;i++) {
					rotateRightByOne(Array, N);
				}
			}

			
			static void rotateRightByOne(int[] Array,int N )
			{
				int temp = Array[N-1];
				for(int i=N-1;i>0;i--) {
				Array[i] = Array[i-1];
				}
				Array[0]=temp;
			}
			
			
			 static void printArray(int arr[], int n)
			    {
			        for (int i = 0; i < n; i++) {
			          System.out.print(arr[i] + " ");
			    }     System.out.println();
			        }
		
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//    
//	String dat = s.nextLine();
//    String tmp[] = dat.split(" ");
//    int Array1[] = new int[tmp.length];
//    int N = Integer.parseInt(tmp[0]);
//    int D = Integer.parseInt(tmp[1]);
    		   
//   Scanner s = new Scanner(System.in);
//	String data = s.nextLine();
//    String tmpDataArray[] = data.split(" ");
//    int Array[] = new int[tmpDataArray.length];
//    for (int i = 0; i <N; ++i) {
//       Array[i] = Integer.parseInt(tmpDataArray[i]);
//    }
