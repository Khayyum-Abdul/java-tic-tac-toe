import java.util.*;                                   // Import utility classes

public class Main {                                   // Main class

    static Scanner s = new Scanner(System.in);        // Scanner object for input
    static char[][] a;                                // 2D array for game board
    static int n;                                     // Board size
    static String x, o;                               // Player names

    static void names() {                             // Function to ask player names
        System.out.print("Please enter the name of Player X: ");
        x = s.next();
        System.out.print("Please enter the name of Player O: ");
        o = s.next();
        System.out.println("Welcome " + x + " and " + o + "! Let the game begin.\n");
    }

    static void init() {                              // Initialize the board
        a = new char[n][n];                           // Create NxN board
        for (int i = 0; i < n; i++)                   // Loop through rows
            for (int j = 0; j < n; j++)               // Loop through columns
                a[i][j] = '-';                        // Fill each cell with '-'
    }

    static void show() {                              // Display the board
        System.out.print("   ");                      // Space for alignment
        for (int i = 0; i < n; i++)                   // Print column numbers
            System.out.print(i + " ");
        System.out.println();                         // New line

        for (int i = 0; i < n; i++) {                 // Loop through rows
            System.out.print(i + "  ");               // Print row number
            for (int j = 0; j < n; j++)               // Loop through columns
                System.out.print(a[i][j] + " ");      // Print cell value
            System.out.println();                     // New line after each row
        }
        System.out.println();                         // Extra space after board
    }

    static boolean ok(int r, int c) {                 // Validate a move
        return r >= 0 && r < n &&                     // Check row range
               c >= 0 && c < n &&                     // Check column range
               a[r][c] == '-';                        // Ensure cell is empty
    }

    static boolean win(char p) {                      // Check if a player wins
        for (int i = 0; i < n; i++) {                 // Loop through indices
            boolean r = true, c = true;               // Flags for row and column
            for (int j = 0; j < n; j++) {             // Inner loop
                if (a[i][j] != p) r = false;          // Row check
                if (a[j][i] != p) c = false;          // Column check
            }
            if (r || c) return true;                  // Win found
        }

        boolean d1 = true, d2 = true;                 // Diagonal flags
        for (int i = 0; i < n; i++) {                 // Loop diagonals
            if (a[i][i] != p) d1 = false;             // Main diagonal check
            if (a[i][n - 1 - i] != p) d2 = false;     // Other diagonal check
        }
        return d1 || d2;                              // Return result
    }

    static boolean full() {                           // Check for draw
        for (int i = 0; i < n; i++)                   // Loop rows
            for (int j = 0; j < n; j++)               // Loop columns
                if (a[i][j] == '-') return false;     // Empty cell found
        return true;                                  // Board is full
    }

    static String who(char p) {                       // Return player name
        return p == 'X' ? x : o;                      // X -> player x, O -> player o
    }

    public static void main(String[] args) {          // Main method

        System.out.println("========================================");
        System.out.println("        WELCOME TO TIC TAC TOE CLI       ");
        System.out.println("========================================");
        System.out.println("Instructions:");
        System.out.println("1. Enter your move as: row column");
        System.out.println("2. Rows and columns start from 0");
        System.out.println("3. Board size can be between 3 and 10\n");

        while (true) {                                // Outer game loop

            while (true) {                            // Board size input loop
                System.out.print("Please enter the board size (between 3 and 10): ");
                n = s.nextInt();                      // Read board size
                if (n >= 3 && n <= 10) break;         // Validate range
                System.out.println("Invalid size. Please enter a number from 3 to 10.\n");
            }

            names();                                  // Ask for player names
            init();                                   // Initialize board
            char p = 'X';                             // Start with X

            while (true) {                            // Game round loop
                show();                               // Display board
                System.out.print(who(p) + " (" + p + "), please enter your move: ");
                int r = s.nextInt();                  // Read row
                int c = s.nextInt();                  // Read column

                if (!ok(r, c)) {                      // Validate move
                    System.out.println("That move is invalid or already occupied. Please try again.\n");
                    continue;                         // Retry move
                }

                a[r][c] = p;                          // Place symbol

                if (win(p)) {                         // Check for win
                    show();                           // Show final board
                    System.out.println("Congratulations " + who(p) + "! You have won the game.\n");
                    break;                            // End round
                }

                if (full()) {                         // Check for draw
                    show();                           // Show final board
                    System.out.println("The game has ended in a draw. Well played both players.\n");
                    break;                            // End round
                }

                p = (p == 'X') ? 'O' : 'X';           // Switch player
            }

            System.out.print("Would you like to play another game? (y/n): ");
            if (!s.next().equalsIgnoreCase("y")) {    // Check replay choice
                System.out.println("Thank you for playing Tic Tac Toe. Goodbye!");
                break;                                // Exit game
            }
        }
    }
}
