
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class ShaPractice {

	public static void main(String[] args) {
		try {
			String s1 = "Akshay V Anil";
			System.out.println(toHexString(getSha(s1)));
			
		}catch(NoSuchAlgorithmException e) {
			System.out.println(e);
		}
	}
	
	
	public static byte[] getSha(String input) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(input.getBytes(StandardCharsets.UTF_8));
	}
	
	
	public static String toHexString (byte[] hash) 
	{
		BigInteger number = new BigInteger(1,hash);
		StringBuilder hexString = new StringBuilder(number.toString(16));
		while (hexString.length() < 32) {
			hexString.insert(0, '0');
		}
		return hexString.toString();
		}
}
