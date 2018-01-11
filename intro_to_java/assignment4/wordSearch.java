/*
 * Assignment number : 4.3
 * File Name : WordSearch.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */
public class WordSearch {
    public static void main(String []args) {
       test(); 
    }
    private static void test() {
    // Test the "hasWord" function
        char[][] array = {{'a', 'c', 'n'},
                          {'d', 'b', 'o'},
                          {'q', 'h', 'a'}};
        // Test all the possible scenarios for the function
        String str = "noa";
        String str2 = "bhn";
        String str3 = "acn";
        String str4 = "do";
        String str5 = "not";
        String str6 = "nca";
        String str7 = "ac";
        String str8 = "cn";

        System.out.println(hasWord(array, str)); //should return true
        System.out.println(hasWord(array, str7)); // should return true
        System.out.println(hasWord(array, str8)); // should return true
        System.out.println(hasWord(array, str3)); // should return true
        System.out.println(hasWord(array, str4)); // should return false
        System.out.println(hasWord(array, str2)); // should return false
        System.out.println(hasWord(array, str5)); // should return false
        System.out.println(hasWord(array, str6)); // should return false
        
    }
    
	/** If the given array contains the given string, either vericaly or horizontaly, returns true.
	 *  Otherwise, returns false. 
     *  The function will recieve a two-dimentional array and a string */
    public static boolean hasWord(char[][] board, String word) {
        int countHorizontal = 0;
        int countVertical = 0;
        if (word.length() > board[0].length || word.length() > board[1].length) {
            return false; 
        }
        // Search for the work vertically 
        for (int i = 0; i < board[0].length; i++) {
                countVertical = 0;
            for (int j = 0; j < board[1].length; j++)
                if (word.charAt(countVertical) == board[i][j]) {
                    countVertical++;
                    if (word.length() == countVertical) {
                        return true;
                    }
                }
                else {
                    countVertical = 0;
                }
        }
        // Search for the work horizontally
        for (int i = 0; i < board[1].length; i++) {
                countHorizontal = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(countHorizontal) == board[j][i]) {
                    countHorizontal++;
                    if (word.length() == countHorizontal) {
                        return true;
                    }
                }
                else {
                    countHorizontal = 0;
                }
            }
        }
        if (word.length() == countVertical || word.length() == countHorizontal) {
            return true;
        }
        else {
            return false;
        }
    }

}
