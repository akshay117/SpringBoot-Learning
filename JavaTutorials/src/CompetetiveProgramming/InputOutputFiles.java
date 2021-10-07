package CompetetiveProgramming;


	// Java program For handling Input/Output
	import java.io.*;
	class InputOutputFiles 
	{
		public static void main(String[] args) throws IOException
		{
			// BufferedReader Class for Fast buffer Input
			BufferedReader br = new BufferedReader(
								new FileReader("input.txt"));

			// PrintWriter class prints formatted representations
			// of objects to a text-output stream.
			PrintWriter pw=new PrintWriter(new
					BufferedWriter(new FileWriter("output.txt")));

			// Your code goes Here

			pw.flush();
		}
	}
	


