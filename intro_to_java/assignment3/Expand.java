/*
 * Assignment number : 4.4
 * File Name : Expand.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */
public class Expand {
    public static void main(String args[]) {
        String dna = args[0];
        String newDna = "";
        Parser.init(dna);
        while (Parser.hasMoreChars()) {
            char c = Parser.nextChar();
            int number = Parser.nextInt();
            for (int i = 0; i < number; i++) { 
                newDna = newDna + c;
            }
        }
        System.out.println(newDna);
    }
}
                 
