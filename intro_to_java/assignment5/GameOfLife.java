/*
 * Assignment number : 5
 * File Name : GameOfLife.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */
/** A class that plays the Game of Life.
 *  Usage: "GameOfLife fileName"
 *  The file represents the initial board.
 *  The file format is described in the HW05 document.
 */
//import std.*;

public class GameOfLife {

	public static void main(String[] args) {
		String fileName = args[0];
		// Uncomment the test that you want to execute, and re-compile.
		// (Run one test at a time).
		// test1(fileName);
		// test2(fileName);
		// test3(fileName, 3);
		 play(fileName);
	}
	
	// Reads the data file and prints the initial board.
	private static void test1(String fileName) {
		int[][] board = read(fileName);
		print(board);
	}
		
	// Reads the data file, and runs some test code that checks 
	// the count and cell functions.
    // Check if cell is being killed when less than 2 neighbors
    // Check if the sum of number of neighbors (for a certain line) is correct
	private static void test2(String fileName) {
		int[][] board = read(fileName);
        int neighbors = 0; 
        for (int i = 1; i < board.length - 1; i++) {
            int nei = count(board, 3, i); 
            if (nei < 2 && board[3][i] == 1 && cell(board, 3, i) != 0) {
                System.out.println("Test for function cell failed, for cell in location 3," + i);
            }
            neighbors += nei; 
        }
        if (fileName.equals("lifeDataLine") && neighbors == 6) {
            System.out.println("Test for neigbors passed for lifeDataLine");
            }
        else if (fileName.equals("lifeDataSquare") && neighbors == 10) {
            System.out.println("Test for neigbors passed for lifeDataSquare");
        }
        else if (fileName.equals("lifeDataPulser") && neighbors == 15) {
            System.out.println("Test for neigbors passed for lifeDataPulser");
        }
        else {
            System.out.println("Test for the neighbors func failed. Please check your code");
        }
          
	}
		
	// Reads the data file, plays the game for Ngen generations, 
	// and prints the board at the beginning of each generation.
	private static void test3(String fileName, int Ngen) {
		int[][] board = read(fileName);
		for (int gen = 0; gen < Ngen; gen++) {
			StdOut.println("Generation " + gen + ":");
			print(board);
			board = evolve(board);
		}
	}
		
	// Reads the data file and plays the game, for ever.
	private static void play(String fileName) {
		int[][] board = read(fileName);
		while (true) {
			show(board);
			board = evolve(board);
		}
	}
	
	// Reads the data from the given fileName, uses the data to construct the initial board,
	// and returns the initial board. Live and dead cells are represented by 1 and 0, respectively.
	// To avoid dealing with extreme cases, constructs a board that has 2 extra rows and 2
	// extra columns, containing zeros. These will be the top and the bottom row, and the 
	// the leftmost and the rightmost columns. Thus the actual board is surrounded by a "frame" of zeros. 
	// You can think of this frame as representing the infinite number of dead cells that 
	// exist in every direction.
	private static int[][] read(String fileName) {
		StdIn.setInput(fileName);
		int rows = Integer.parseInt(StdIn.readLine());
		int cols = Integer.parseInt(StdIn.readLine());
        int [][] board = new int[rows+2][cols+2];
        int count = 1;
        int countc = 1;
        while (StdIn.hasNextLine()) {
            String live = StdIn.readLine();
            if ( live.equals("") ) {
                for ( int i = 2; i < board[0].length - 2; i++ ) {
                    board[count][i] = 0;
                }
                count++;
            }
            else {
                for (int i = 0; i < live.length(); i++) {
                    if (live.charAt(i) == 'x') {
                        board[count][countc] = 1;
                        countc++;
                    }
                    else {
                        board[count][countc] = 0;
                        countc++;
                    }
                }
                countc = 1;
                count++;
            }
        }

		return board;
	}
	
	// Creates a new board from the given board, using the rules of the game.
	// Uses the cell(board,i,j) function to compute the new contents of each 
	// cell in the new board. Returns the new board.
	private static int[][] evolve(int[][] board){
        int [][] newBoard = new int [board[0].length][board[1].length];
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board.length - 1; j++) {
                int next = cell(board, i, j);
                newBoard[i][j] = next; 
            }
        }
		return newBoard;
	}

	// Returns the contents of cell (i,j) in the next generation.
	// If the cell is alive (equals 1) and has fewer than two live neighbors, it dies (becomes 0).
	// If the cell is alive and has two or three live neighbors, it remains alive.
	// If the cell is alive and has more than three live neighbors, it dies.
	// If the cell is dead and and has three live neighbors, it becomes alive.
	// Other cells don't change. 
	// Assumes that i is at least 1 and at most the number of rows in the board - 1. 
	// Assumes that j is at least 1 and at most the number of columns in the board - 1. 
	// Uses the count(board,i,j) function to count the number of alive neighbors.
	private static int cell(int[][] board, int i, int j) {
        int neighbors = count(board, i, j); 
        int ans = board[i][j];
        if (neighbors < 2 && ans == 1) {
            ans = 0;
        }
        if (neighbors > 3 && ans == 1) {
            ans = 0; 
        }
        if (neighbors == 3 && ans == 0) {
            ans = 1; 
        }
		return ans;
	}
	
	// Counts and returns the number of living neighbors of the given cell.
	// Assumes that i is at least 1 and at most the number of rows in the board - 1. 
	// Assumes that j is at least 1 and at most the number of columns in the board - 1. 
	private static int count (int[][] board, int i, int j) {
        int count = 0;
        for (int s = -1; s < 2; s++) {
            for (int f = -1; f < 2; f++) {
                if (board[i+f][j+s] == 1) {
                    count++;
                    if (f == 0 && s == 0 && board[i][j] == 1) {
                        count = count - 1; 
                    }
                }
            }
        }
		return count;
	}
	
	
	// Prints the board. Living and dead cells are printed as 1 and 0, respectively.
    private static void print(int[][] board) {
        for (int i = 1; i < board.length - 1; i++) {
           for (int j = 1; j < board.length - 1; j++) {
               System.out.printf("%2s", board[i][j]);
           }
           System.out.println();
        }
	}
		
    // Displays the board. Living and dead cells are represented by black and white squares, respectively.
    // Since we use the same canvas size for displaying boards of different sizes, we change the square 
    // sizes to fill the canvas: The smaller the board, the larger the squares.
    // This code should be treated as a black box -- no need to study or understand it.
	private static void show(int[][] board) {
		// StdDraw.setCanvasSize(1024, 1024);
		StdDraw.setCanvasSize(900, 900);
		int rows = board.length;
		int cols = board[0].length;
		// StdDraw.setCanvasSize(height * 10, width *10);
		StdDraw.setXscale(0, cols);
		StdDraw.setYscale(0, rows);
		StdDraw.show(100);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int grey = 255 * (1 - board[i][j]);
				StdDraw.setPenColor(grey, grey, grey);
				StdDraw.filledRectangle(j + 0.5, rows - i - 0.5, 0.5, 0.5);
			}
		}
		StdDraw.show();
	}
}
