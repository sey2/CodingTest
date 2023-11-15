//----------------------------------------------------------------------
// Best viewed with tabs every 4 columns
//----------------------------------------------------------------------

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * MinionWalk
 * This program determines whether it is possible to for a minion to
 * walk from the top left corner of a room to the bottom right corner,
 * avoiding obstacles and making only 90 degree turns.
 *
 * The program inputs a description of the room and obstacles in it, and
 * prints either Yes or No depending on whether the walk is possible. It
 * then prints all room locations possibly reached by the minion.
 *
 */
public class Main {

    /* This function solves the MinionWalk problem. It takes as input
     * a 2-dimensional array of chars, representing the available ('O')
     * and occupied ('X') locations in the room. For example:
     *
     * Input array:
     *   O X O O
     *   O O X O
     *   X X O O
     *   O O O X
     *   O O O O
     *
     * Your code needs to find locations that can be reached by
     * minions walking around the room, starting from the top left
     * corner. Minions can only move up, down, left, and right.
     * I.e., no diagonal moves.
     *
     * Your code should change array values to 'M' if minions
     * can walk to that location. It should return true if
     * minions can walk across to the bottom right corner of
     * the room, and false otherwise.
     */
    private static boolean canReach(char[][] wall) {
        int nRows = wall.length;
        int nCols = wall[0].length;

        Queue<int[]> queue = new LinkedList<>();
        if (wall[0][0] == 'O') {
            queue.offer(new int[]{0, 0});
            wall[0][0] = 'M';
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];
            
            int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
            for (int[] d : directions) {
                int newY = y + d[0];
                int newX = x + d[1];

                if (newY >= 0 && newY < nRows && newX >= 0 && newX < nCols && wall[newY][newX] == 'O') {
                    wall[newY][newX] = 'M'; // Mark as reachable
                    queue.offer(new int[]{newY, newX});
                }
            }
        }
        return (wall[nRows-1][nCols-1] == 'M');
    }


    /* --------------------- END OF INSERTION ---------------------*/

    /**
     *  Pretty print the wall
     */
    private static void prettyPrintWall(char[][] wall)
    {
        int nRows = wall.length;
        int nCols = wall[0].length;

        for (int j = 0; j < nCols; j++) {	// print top boundary
            System.out.print("+---");
        }
        System.out.println("+");

        for (int i = 0; i < nRows; i++) {
            // print row contents
            for (int j = 0; j < nCols; j++) {
                switch (wall[i][j]) {
                    case 'X':
                        System.out.print("| X "); break;
                    case 'O':
                        System.out.print("|   "); break;
                    case 'M':
                        System.out.print("| M "); break;

                }
            }
            System.out.println("|");
            // print row separator
            for (int j = 0; j < nCols; j++) {
                switch (wall[i][j]) {
                    case 'X':
                    case 'O':
                    case 'M':
                        System.out.print("+---"); break;
                }
            }
            System.out.println("+");
        }
    }

    /**
     *  Main Program
     */
    public static void main(String[] args) throws Exception {
        // read input
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for(int t = 1; t <= numCases; t++) {
            int nRows = scanner.nextInt();	// number of rows in wall
            int nCols = scanner.nextInt();	// number of columns in wall
            scanner.nextLine();				// skip to eol
            char[][] wall = new char[nRows][]; // the wall
            for (int i = 0; i < nRows; i++) {
                wall[i] = new char[nCols];
                String line = scanner.nextLine();
                for (int j = 0; j < nCols; j++) {
                    wall[i][j] = line.charAt(j);
                }
            }

            System.out.println("Case: " + t);// echo input

            boolean result = canReach(wall);					// check for solution
            prettyPrintWall(wall);			 // print the reachable parts of the room

            String outputMessage = result ? "can" : "cannot";		// choose output
            System.out.format("Minions %s cross the room %n", outputMessage);
        }
        scanner.close();					// close input stream
    }
}
