
package assignment2;
import java.util.Random;
public class Cryptography{

	public static void main(String[] args) {
		
		System.out.println(caesarEncrypt("abbb", 3));
		caesarDecrypt(caesarEncrypt("hello", 3),3);
		System.out.println(crackCipher("richard is a god",3));
		char [] a ={'N','B','C','D'};
		System.out.println(a);
		shuffle(a);
		System.out.println(a);
		System.out.println(generatePermutation());
		String input = "Hello!";
		System.out.println(permuteEncrypt(input));
	}

	//this method takes a String and shifts 
	//each individual letter in the string by an int shift (eg. shift is 3)
	//for example A in APPLE would become D
	public static String caesarEncrypt(String originalMessage, int shift){
		String s = originalMessage;
		String newString = "";
		//for all the letters in the program, + shift to it 
		//reprint the coded string that has been shifted 
		
		for(int i=0;i<s.length();i++){
			char j = (char)(s.charAt(i) + shift);
			//puts j into newString
			newString = newString + j;
		}
		return newString;
		
		
	}
	//takes input String and returns a string by applying a reverse shift 
	//caesarDecrypt(caesarEncrypt(originalMessage)) = originalMessage
	//this method should be the reverse of caesarEncrypt
	public static String caesarDecrypt(String encoded, int shift){
		
		String codedString = encoded;
		String decodedString = "";
		//taking codedString and shifting all the letters by an int shift
		//thus decodedString = original message 
		for (int i=0;i<codedString.length();i++){
			char j =(char)(codedString.charAt(i)-shift);
		decodedString = decodedString +j;
	}
		
		return decodedString;
			
		}
	//this method takes a string and shifts it via different integers from 0- numberLetters
	//this method prints the string 
	//(inclusive of all the strings with the different shifts + originalString)
	//with the largest number of English words
	public static String crackCipher(String encoded, int numberLetters){
		int original=0;
		int largest=SentenceChecker.countEnglishWords(caesarDecrypt(encoded,0));
		 for (int i=0; i<numberLetters;i++){
		//this method takes a String and outputs the num ber of English words 
			 caesarDecrypt(encoded, i);
			 SentenceChecker.countEnglishWords(caesarDecrypt(encoded,i));
			 if ((SentenceChecker.countEnglishWords(caesarDecrypt(encoded,i))>largest)){
				 original = i;
				 largest = SentenceChecker.countEnglishWords(caesarDecrypt(encoded,i));
			 }	
		}
		return (caesarDecrypt(encoded,original));
	}
	//this method shuffles the elements in an array
	//swaps elements in the array by (length of array)^4 times
		public static void shuffle (char[]a){
			Random generator = new Random(12345);
			//number of times it swaps
			
			for(int i=0; (i<Math.pow(a.length,4)); i++){
				int x=generator.nextInt(a.length);
				int y=generator.nextInt(a.length);
			int temp = a[x];
			a[x] =a[y];
			a[y]= (char)temp;
			y++;
			}
		}
		
		//this method outputs a random char[]
		//has exactly 26 characters
		//should contain each Uppercase letter once and only once 
		public static char[] generatePermutation(){
			char[]a = new char[26];
			char y = 65;
			if (a.length ==26){
				for (int i=0;i<a.length;i++){
				a[i]= (char)y; 
				y++;
				}
				 
			}
			shuffle(a);
			return a;
		}
		//takes an input String, for every letter in the String
		//mapping of ith letter can be figured out by 
		//by figuring out the ith element in the array
		//this method returns a string in all Uppercase 
		public static String permuteEncrypt(String input){
			// for each position in the array, it gets assigned to A,B,C etc respectively
		String encoded = "";
		for (int i=0; i<input.length();i++){
			if (input.charAt(i)>64 && input.charAt(i)<91){
				//[input.charAt(i)-65] since we start with position 0
				char newCode = generatePermutation()[input.charAt(i)-65];
				encoded = encoded + newCode;
			}
			
			else if (input.charAt(i)>96 && input.charAt(i)<123){
				char newCode = generatePermutation()[input.charAt(i)-97];
				encoded = encoded + newCode;
			}
			else {
				char newCode = input.charAt(i);
				encoded = encoded + newCode;
				}
			}
			return encoded;
			}
			
		}
	


