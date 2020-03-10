import java.util.Scanner;
//THIS IS MY GIT EDIT TEST//
public class ConnectFour {

    public static void printBoard(char[][] array){ //Method prints the game board//

     int i; //Variables j and i are defined as integers//
     int j;

        for(i = array.length-1; i >= 0; i--){ //Instead of using a for each loop, I chose to use nested for loops to print the array//
                                                    //Rows//
            for(j = 0; j < array[0].length; j++){ //Columns//
                System.out.print(array[i][j] + " ");
            }
            System.out.println(); //Prints array//
        }

    }

    public static void initializeBoard(char[][] array){ //This method puts '-' in every array value//

        int i; //Variables j and i are defined as integers//
        int j;

        for(i = 0; i < array.length; ++i){

            for (j = 0; j < array[i].length; ++j){
                array[i][j] = '-'; // Replaces null array values with '-'//
            }
        }
    }

    public static int insertChip(char[][] array, int col, char chipType){ // This method inserts a chip in a column of the player's choice//

        int i; //Variable i is defined as an int for the for loop//

        for(i = 0; i < array.length; ++i){
            if(array[i][col] == '-'){
                array[i][col] = chipType; // The - in the selected column is replaced with the players symbol (either x or o)//
                return i;
            }
        }
        return 1; //This value is used to determine which row is called in the checkIfWinner method//
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){ // This method checks to see if there are four chips in a row//

        int i; //Variable i is defined as an int for the for loop//
        int chipCounter = 0; //Counts how many of a certain chip is in a row/column //

        for(i=0; i < array.length; ++i){

            if(array[i][col] == chipType){

                chipCounter++; //Counts how many chips of a certain type are in a column//

                if(chipCounter == 4){
                    return true; //If four chips are in a column the game is over and the method returns the value true//
                }

            } else{
                chipCounter = 0; //The counter is set back to 0 if the game is not over yet//
            }
        }

        for(i = 0; i < array[0].length; i++){

            if(array[row][i] == chipType){

                chipCounter++; //Counts how many chips of a certain type are in a row//

                if(chipCounter == 4){
                    return true; //If four chips are in a row the game is over and the method returns the value true//
                }

            } else{
                chipCounter = 0; //The counter is set back to 0 if the game is not over yet//
            }
        }

        return false; //If 4 chips are not together, the method returns false and the game resumes//

    }

    public static void main(String[] args) {

    int heightInput; //Height of the board//
    int lengthInput; //Length of the board//
    int selection; //User input//
    boolean game = true; //Enters the first whiles loop that contains the entire game//
    boolean finishedGame; //Enters while loop when game is finished//
    int boardPlaces; //How many possible chips can be placed//
    int moveCount = 0; //How many chips are on the board//

        Scanner scnr = new Scanner(System.in);

        System.out.println("What would you like the height of the board to be?");
        heightInput = scnr.nextInt(); //Height of the board//

        System.out.println("What would you like the length of the board to be?");
        lengthInput = scnr.nextInt(); //Length of the board//

        boardPlaces = (heightInput * lengthInput); //Calculates how many chips can be placed on the board (Used when determining a draw//

        char[][] board = new char[heightInput][lengthInput];

        initializeBoard(board); //Calls method to put - in every array value//
        printBoard(board); //Calls method that prints board//

        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        while (game) { //While loop that is always true and contains the entire game//
            System.out.println("Player 1: Which column would you like to choose?");
            selection = scnr.nextInt();
            moveCount++; //Counts how many moves have happened in order to determine is there is a draw//


            int chipRow = insertChip(board, selection, 'x'); //Variable is used to call method and determine which row was called//
            finishedGame = checkIfWinner(board, selection, chipRow, 'x'); /* Calls a method that defines a boolean
            to see if the game ending loop should be entered */
            printBoard(board); //Prints board again//


            if(finishedGame){ //If the game is done, the loop is entered and prints the winner//
                System.out.println("Player 1 won the game!");
                break;
            }
            if (moveCount == boardPlaces){ // If the amount of chips placed equals the amount of places on the board the game ends in a draw//
                System.out.println("Draw. Nobody wins.");
                break;
            }



            System.out.println("Player 2: Which column would you like to choose?");
            selection = scnr.nextInt();
            moveCount++;//Counts how many moves have happened in order to determine is there is a draw//

            chipRow = insertChip(board, selection, 'o'); //Variable is used to call method and determine which row was called//
            finishedGame =checkIfWinner(board, selection, chipRow, 'o');/* Calls a method that defines a boolean
            to see if the game ending loop should be entered */
            printBoard(board);//Prints board again//

            if(finishedGame){ //If the game is done, the loop is entered and prints the winner//
                System.out.println("Player 2 won the game!");
                break;
            }
            if (moveCount == boardPlaces){// If the amount of chips placed equals the amount of places on the board the game ends in a draw//
                System.out.println("Draw. Nobody wins.");
                break;
            }



        }


    }
}
