public class wordSearch {
    public static void main(String []args) {
       test(); 
    }
    private static void test() {
    // Test the "hasWord" function
        char[][] array = {{'a', 'c', 'n'},
                          {'d', 'b', 'o'},
                          {'q', 'h', 'a'}};
        String str = "noa";
        String str2 = "bla";
        String str3 = "acn";
        System.out.println(hasWord(array, str)); //should return true
        System.out.println(hasWord(array, str2)); // should reurn true
        System.out.println(hasWord(array, str3)); // should return false
        
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
                if (word.charAt(j) == board[i][j]) {
                    countVertical++;
                }
            if (word.length() == countVertical) {
                break;
            }
        }
        // Search for the work horizontally
        for (int i = 0; i < board[1].length; i++) {
                countHorizontal = 0;
            for (int j = 0; j < board[0].length; j++)
                if (word.charAt(j) == board[j][i]) {
                    countHorizontal++;
                }
            if (word.length() == countHorizontal) {
                break;
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
