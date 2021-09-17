package BitWiseAnd;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BitwiseAnd {

	
	
	public static void main(String[] args) throws Exception {
		 BufferedReader br= new BufferedReader(new 
		InputStreamReader(System.in));
			       
	     int t = Integer.parseInt(br.readLine());
		
		for(int itr =0;itr<t;itr++) {
	        int a[] = new int[2];
	        String line = br.readLine(); // to read multiple integers line
	        String[] strs = line.trim().split("\\s+");
	        for (int i = 0; i < 2; i++) {
	            a[i] = Integer.parseInt(strs[i]);
	        }
	        int n = a[0];
   	        int k = a[1];
			
			calcMaxSum( n ,  k);
		}
		
	}

	static void calcMaxSum(int n, int k) {
		int max=0;
		for(int i=1;i<n;i++) {
			for(int j=1;j<i;j++) {
				int bitAnd = i&j;
				if((max<bitAnd)&&(bitAnd<k)) {
					max= bitAnd;
				}
			}
		}
		System.out.println(max+ " ");
	}
}
