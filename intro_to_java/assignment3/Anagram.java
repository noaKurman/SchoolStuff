/*
 * Assignment number : 3.3
 * File Name : Anagram.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */
// A collection of methods for handling anagrams.
public class Anagram {
	public static void main(String args[]) {
	      // Tests the isAnagram function.
   		  System.out.println(isAnagram("silent","listen"));  // true
   		  System.out.println(isAnagram("silent","lissen"));  // true - test double letter in one work
	      System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
	      System.out.println(isAnagram("Madam Curie","Radium came")); // true
	      // Tests the ramdomAnagram function.
	      System.out.println(randomAnagram("silent"));	     	
	   }  

	   // Returns true if the two given strings are anagrams, false otherwise.
	   public static boolean isAnagram(String str1, String str2) {
		   // Replace the following statement with your code.
           str1 = preProcess(str1);
           str2 = preProcess(str2);
           if (str1.length() != str2.length()) {
               return false;
           }
	       char[] array = new char[str1.length()];
	       char[] array2 = new char[str2.length()];
           int count = 0;
           for (int i = 0; i < str1.length(); i++) {
               array[i] = str1.charAt(i);
               array2[i] = str2.charAt(i);
           }
           for (int s = 0; s < array.length; s++) { 
               for (int t = 0; t < array.length; t++) {
                   if (array[s] == array2[t]) { 
                       count++;
                       array2[t] = 0;
                   }
                
               }
           }
           if (count == array.length) {
               return true;
           }    
           return false;
	   }
	   
	   // Returns a preprocessed version of the given string: all the letter characters
	   // are converted to lower-case, and all the other characters are deleted. For example, 
	   // the string "What? No way!" becomes "whatnoway"
	   public static String preProcess(String str) {
		   // Replace the following statement with your code.
           if (str == null) {
               return "";
           }
	       char[] array = new char[str.length()];
           String str2 = "";
           char char1 = '\0';
           for (int i = 0; i < str.length(); i++) {
               if (isLetter(str.charAt(i))) {
                   if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                       char1 = (char) (str.charAt(i) + 32);
                    }
                   else {
                       char1 = str.charAt(i);
                   }
                    str2 = str2 + char1;
               } 
           }
	       return str2;
	   } 
	   
	   // Returns a random anagram of the given string. The random anagram consists of the same
	   // letter characters as the given string, arranged in a random order. The random anagram
	   // is not required to form a word in the English language.
	   public static String randomAnagram(String str) {
		   // Replace the following statement with your code.
           str = preProcess(str);
	       char[] array = new char[str.length()];
           String strAnagram = "";
           boolean[] count = new boolean[str.length()];
           for (int i = 0; i < str.length(); i++) {
               char char1 = str.charAt(i);
               array[i] = char1;
               }
           while (strAnagram.length() < array.length) {
               int exists = 0; 
               int i = 0;
               int rand =  (int) ( Math.random()*(array.length-0) );
               if (count[rand] == false) {
                   strAnagram = strAnagram + array[rand];
                   count[rand] = true;
                   i++;
               }
               
           }
          return strAnagram;
       }
           

       // Returns true if the given character is an English letter ('a' to 'z' or 'A' to 'Z'), false otherwise.
       private static boolean isLetter(char c) {
           // Replace the following statement with your code.
           if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
               return true;
           }
           return false;
       }
            	   
}

