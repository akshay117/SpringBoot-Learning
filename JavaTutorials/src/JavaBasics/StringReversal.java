package JavaBasics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringReversal {

	public static void main(String[] args) throws Exception {
		
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
       System.out.println(Reverse(str));
        		
	}

	private static String Reverse(String str) {
		if(str==null)
			throw new IllegalArgumentException("NULL IS NOT VALID");
		char[] arr = str.toCharArray();
		
		StringBuilder build = new StringBuilder();
		for(int i = arr.length-1;i>=0;i--) {
			
			build.append(arr[i]);
			
		}
		return build.toString();
		
	}
	
	
}
