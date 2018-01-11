package CharProb;

import java.util.LinkedList;

public class Tools {
	
	public static void main(String []args) {
		test1();
        test2();
		test3();
        test4();
		test5();

	}

	// Creates a linked list, adds a few CharProb objects,
	// and tests the indexOf method.
	private static void test1() {
		LinkedList<CharProb> probs = new LinkedList<CharProb>();
		probs.add(new CharProb('i'));
		probs.add(new CharProb('d'));
		probs.add(new CharProb('c'));
		System.out.println(indexOf(probs,'d'));	// Should print 1
		System.out.println(indexOf(probs,'i'));	// Should print 0
		System.out.println(indexOf(probs,'u'));	// Should print -1
	}
			
	// Creates a linked list, adds a few CharProb objects,
	// and tests the toString method.
	private static void test2() {
		LinkedList<CharProb> probs = new LinkedList<CharProb>();
		probs.add(new CharProb('i'));
		probs.add(new CharProb('d'));
		probs.add(new CharProb('c'));
        System.out.println(toString(probs));
        // The output should look like this:
        // ((i 1)(d 1)(c 1))
	}
	
	// Tests the creation of a character probabilities list from a given string.
	// Does not handle the p and cp fields yet.
	private static void test3() {
		System.out.println(toString(buildList("committee ")));
		// The output should look like this:
		// ((c 1)(o 1)(m 2)(i 1)(t 2)(e 2)(  1))
	}
	
	// Tests the probability calculations.
	private static void test4() {
		LinkedList<CharProb> probs = buildList("committee ");
		System.out.println("Before: " + toString(probs));
		calculateProbabilities(probs);
		// The following printout will make sense only after you change the 
		// toString method of the CharProb class to also list the two
		// probability fields.
		//System.out.println(toString(probs));
		System.out.println("After: " + toString(probs));
	}
	
	// Tests the calculation of the probabilities p and cp.
	private static void test5() {
		LinkedList<CharProb> probs = buildList("committee ");
		calculateProbabilities(probs);
		System.out.println(getRandomChar(probs));
		String str = "";
		for (int i = 0; i < 10000; i++) {
		    char c = getRandomChar(probs);
		    str += "" + c;
        }
        LinkedList<CharProb> chance = buildList(str);
		calculateProbabilities(chance);
		System.out.println(chance);
		// Write below code that generates characters at random from a given
		// list. Repeat this experiment many times, and verify that the characters
		// are generated according to the probabilities represented in the given list.
	}

	// Builds a character probabilities list from the given string.
	// For each character, sets the chr and count fields, without
	// dealing with the fields p and cp (they remain zero for now).
	public static LinkedList<CharProb> buildList(String str) {
        LinkedList<CharProb> probs = new LinkedList<CharProb>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (indexOf(probs, c) == -1) {
                probs.add(new CharProb(c));
            }
            else {
                int index = indexOf(probs, c);
                probs.get(index).count++;
            }
        }

		return probs;
	}
	
	// If the given character exists in the given list, returns the index of the 
	// element where the character was found. Otherwise returns -1. 
	public static int indexOf(LinkedList<CharProb> probs, char c) {

	    for (int i =0; i < probs.size(); i++) {
	        if (probs.get(i).chr == c) {
                return i;
            }
        }
		return -1;
	}
		
	// Returns a textual representation of the given probabilities list, using the 
	// format ((c n),(c n),...,(c n)) where c is a character and n is a count value. 
	public static String toString(LinkedList<CharProb> probs) {
		StringBuilder str = new StringBuilder();
		str.append("(");
		int length = probs.size();
		for (int i = 0; i < length; i++) {
		    str.append(probs.get(i));
		}
		str.append(")");
			return str.toString();
	}
	
	// Computes and sets the probabilities (p and cp fields) of all the
	// characters in the given probabilities list.
	public static void calculateProbabilities(LinkedList<CharProb> probs) {

	    int total = 0;
        for (int i = 0; i < probs.size(); i++) {
	        total += probs.get(i).count;
        }
	    for (int i = 0; i < probs.size(); i++) {
	        probs.get(i).CharProb(total);
            if (i == 0) {
	            probs.get(i).cp = probs.get(i).p;
            }
            else {
                probs.get(i).cp = probs.get(i-1).cp + probs.get(i).p;
            }
        }
	}
	
	// Returns a character from the given list, according to its probability. 
	public static char getRandomChar(LinkedList<CharProb> probs) {
		double r = Math.random();
		char c  = '\0';
		for (int i = 0; i < probs.size(); i++) {
            if (probs.get(i).cp > r) {
                return probs.get(i).chr;
            }
        }
		return c;
	}
}
