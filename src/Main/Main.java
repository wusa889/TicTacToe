package Main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author Julian Brecht
 * @version 1.0 Build 05.06.2023 This is the main class that also contains the main method.
 *          It is responsible for the game loop and termination of the program.
 *          It also contains several variables that are needed to play the game.
 */
public class Main {
    /**
     * This is the game array which stores the position of the symbols.
     */
    public static char[][] gameArray = new char[3][3];
    /**
     * This variable is needed to generate the field in the DrawField class.
     */
    public static int fieldBuilder = 0;
    /**
     * This variable stores the current state of the game.
     */
    public static int gameState = 0;
    /**
     * Start of the main method that contains the gameloop.
     * @param args not used.
     */
    public static void main(String[] args) {
        // Creation and Initialising of needed variabels for the game.
        Scanner inputScanner = new Scanner(System.in);
        int player = 0;
        int gameMode = 0;
        int validMove = 0;
        int playAgain = 0;
        int validInput = 0;
        int row = 0;
        int col = 0;
        int validGameMode = 0;
        String playerName1 = "";
        String playerName2 = "";
        /**
         * Method to reset the field.
         * @return void.
         */
        ResetField.resetToStart(); // Fills the Array for the first game
        /**
         * Display welcome message and asks the players what gamemode is wanted
         * @throws InputMismatchException			if input is not an integer.
         */
        System.out.println("Welcome to TicTacToe");
        System.out.println("Please make a choice");
        System.out.println("1 to start the game");
        System.out.println("2 to close the game");
        while (validGameMode == 0) {
            try {
                gameMode = inputScanner.nextInt();
                if (gameMode > 2 || gameMode < 1) {
                    System.out.println("Gamemode not found");
                    System.out.println("1 to start the game");
                    System.out.println("2 to close the game");
                    continue; // To continually check if the integer is valid.
                }
                validGameMode = 1; // To exit the loop.

            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter the gamemode number");
                System.out.println("1 to start the game");
                System.out.println("2 to close the game");
                inputScanner.nextLine();
                continue;
            }

        }
        /**
         *  Start of the game and gets the names of the players.
         */
        if (gameMode == 1) {
            inputScanner.nextLine(); // needs to be here because otherwise it skips player1.
            System.out.println("please enter the name of player1");
            playerName1 = inputScanner.nextLine();
            System.out.println("please enter the name of player2");
            playerName2 = inputScanner.nextLine();
            /**
             * Mehtod that prints the field in the current state.
             * @return void.
             */
            DrawField.drawField();
            while (gameState == 0) {
                /**
                 * Prompts player X to make a move by reading the next two inputs as integers.
                 * @throws ArrayIndexOutOfBoundsException	if coordinates are out of bounds.
                 * @throws InputMismatchException			if type is not int.
                 * @throws Exception						if something else goes wrong.
                 */
                if (player == 0) {
                    System.out.println("Place your symbol " + playerName1 + ".");
                    while (validInput == 0) {
                        try {
                            row = inputScanner.nextInt();
                            col = inputScanner.nextInt();
                            if (row > 2 || col > 2) {
                                throw new java.lang.ArrayIndexOutOfBoundsException();
                            }
                            validInput = 1; // validInput is set to 1 to exit the loop.

                        } catch (java.util.InputMismatchException e) {
                            System.out.println("You have to put in coordinates for your symbol.");
                            inputScanner.nextLine();
                            continue;
                        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                            System.out.println("Coordinates out of bounds please try again.");
                            inputScanner.nextLine();
                            continue;
                        } catch (Exception e) {
                            System.out.println("something stupid happend, try again.");
                            inputScanner.nextLine();
                            continue;
                        }

                    }
                    validInput = 0; // validInput is set back to 0 for next move.
                    /**
                     * Check if the field is already taken and if so prompts to take another field.
                     * @throws ArrayIndexOutOfBoundsException	if coordinates are out of bounds.
                     * @throws InputMismatchException			if type is not int.
                     * @throws Exception						if something else goes wrong.
                     */
                    while (validMove == 0) {
                        if (gameArray[row][col] != ' ') {
                            System.out.println("there is already a symbol on this field, please choose another.");
                            validInput = 0;
                            while (validInput == 0) {
                                try {
                                    row = inputScanner.nextInt();
                                    col = inputScanner.nextInt();
                                    if (row > 2 || col > 2) {
                                        throw new java.lang.ArrayIndexOutOfBoundsException();
                                    }
                                    validInput = 1; // validInput is set to 1 to exit the loop.

                                } catch (java.util.InputMismatchException e) {
                                    System.out.println("You have to put in coordinates for your symbol.");
                                    inputScanner.nextLine();
                                    continue;
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                                    System.out.println("Coordinates out of bounds please try again.");
                                    inputScanner.nextLine();
                                    continue;
                                } catch (Exception e) {
                                    System.out.println("something stupid happend, try again.");
                                    inputScanner.nextLine();
                                    continue;
                                }

                            }
                            validInput = 0; // validInput is set back to 0 for next move.
                        }

                        else {
                            gameArray[row][col] = 'x';
                            validMove = 1; // validMove is set to 1 to exit the loop.
                            /**
                             *  Checks if x has won.
                             *  @return void.
                             */
                            XWinCheck.checkXWin();
                        }

                    }

                    /**
                     * Field is output updated.
                     * @return void.
                     */
                    DrawField.drawField();
                    validMove = 0; // validMove is set back to 0 for next move.
                }
                /**
                 * If X has won asks if the players want to play again.
                 * @throws ArrayIndexOutOfBoundsException	if wrong number is choosen.
                 * @throws InputMismatchException			if type is not int.
                 * @throws Exception						if something else goes wrong.
                 */
                if (gameState == 1) {
                    System.out.println(playerName1 + " wins.");
                    System.out.println("Want to play again? \n 1 for yes \n 2 for no");
                    while (validInput == 0) {
                        try {
                            playAgain = inputScanner.nextInt();
                            if (playAgain != 2 && playAgain != 1) {
                                throw new java.lang.ArrayIndexOutOfBoundsException();
                            }
                            validInput = 1; // validInput is set to 1 to exit loop.
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("You have to type 1 or 2.");
                            inputScanner.nextLine();
                            continue;
                        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                            System.out.println("Please choose betweend 1 or 2.");
                            inputScanner.nextLine();
                            continue;
                        } catch (Exception e) {
                            System.out.println("Something stupid happend, try again.");
                            inputScanner.nextLine();
                            continue;
                        }
                    }
                    if (playAgain == 1) {
                        gameState = 0; // sets gameState to 0 to initialize a new game.
                        /**
                         * Method to reset the field.
                         * @return void.
                         */
                        ResetField.resetToStart();
                        validInput = 0; // validInput is set
                        continue; // to jump to next iteration of the gameloop.
                    } else if (playAgain == 2) {
                        gameMode = 2; // gameMode is set to 2 to terminate the programm.
                        break; // Gameloop is broken.
                    }

                }

                validInput = 0; //validInput is set back to 0 for next move.
                /**
                 * Check if its a draw.
                 * @throws ArrayIndexOutOfBoundsException	if wrong number is choosen.
                 * @throws InputMismatchException			if type is not int.
                 * @throws Exception						if something else goes wrong.
                 */
                DrawCheck.drawCheck();

                if (gameState == 3) {
                    System.out.println("Its a draw.");
                    System.out.println("Want to play again? \n 1 for yes \n 2 for no");
                    while (validInput == 0) {
                        try {
                            playAgain = inputScanner.nextInt();
                            if (playAgain != 2 && playAgain != 1) {
                                throw new java.lang.ArrayIndexOutOfBoundsException();

                            }
                            validInput = 1; // To exit the loop.
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("You have to type 1 or 2.");
                            inputScanner.nextLine();
                            continue;
                        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                            System.out.println("Please choose betweend 1 or 2.");
                            inputScanner.nextLine();
                            continue;
                        } catch (Exception e) {
                            System.out.println("Something stupid happend, try again.");
                            inputScanner.nextLine();
                            continue;
                        }
                    }
                    if (playAgain == 1) {
                        gameState = 0; // sets gameState to 0 to initialize a new game.
                        /**
                         * Method to reset the field.
                         * @return void.
                         */
                        ResetField.resetToStart();
                        validInput = 0; // validInput is set back to 0 for next move.
                        continue;
                    } else if (playAgain == 2) {
                        gameMode = 2;
                        break;
                    }

                }
                validInput = 0; // validInput is set back to 0 for next move.
                player++; // Sets the player variable to O player.
                /**
                 * Prompts player O to make a move by reading the next two inputs as integers.
                 * @throws ArrayIndexOutOfBoundsException	if coordinates are out of bounds.
                 * @throws InputMismatchException			if type is not int.
                 * @throws Exception						if something else goes wrong.
                 */
                if (player == 1) {
                    System.out.println("Place your symbol " + playerName2 + ".");
                    while (validInput == 0) {
                        try {
                            row = inputScanner.nextInt();
                            col = inputScanner.nextInt();
                            if (row > 2 || col > 2) {
                                throw new java.lang.ArrayIndexOutOfBoundsException();
                            }
                            validInput = 1; // validInput is set to 1 to exit loop.
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("You have to put in coordinates for your symbol.");
                            inputScanner.nextLine();
                            continue;
                        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                            System.out.println("Coordinates out of bounds please try again.");
                            inputScanner.nextLine();
                            continue;
                        } catch (Exception e) {
                            System.out.println("Something stupid happend, try again.");
                            inputScanner.nextLine();
                            continue;
                        }

                    }
                    validInput = 0; // validInput is set back to 0 for next move.
                    /**
                     * Check if the field is already taken and if so prompts to take another field.
                     * @throws ArrayIndexOutOfBoundsException	if coordinates are out of bounds.
                     * @throws InputMismatchException			if type is not int.
                     * @throws Exception						if something else goes wrong.					 *
                     */
                    while (validMove == 0) {
                        if (gameArray[row][col] != ' ') {
                            System.out.println("there is already a symbol on this field, please choose another.");
                            validInput = 0;
                            while (validInput == 0) {
                                try {
                                    row = inputScanner.nextInt();
                                    col = inputScanner.nextInt();
                                    if (row > 2 || col > 2) {
                                        throw new java.lang.ArrayIndexOutOfBoundsException();
                                    }
                                    validInput = 1; // validInput is set to 1 to exit loop.
                                } catch (java.util.InputMismatchException e) {
                                    System.out.println("You have to put in coordinates for your symbol.");
                                    inputScanner.nextLine();
                                    continue;
                                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                                    System.out.println("Coordinates out of bounds please try again.");
                                    inputScanner.nextLine();
                                    continue;
                                } catch (Exception e) {
                                    System.out.println("Something stupid happend, try again.");
                                    inputScanner.nextLine();
                                    continue;
                                }

                            }
                            validInput = 0; // validInput is set back to 0 for next move.
                        }

                        else {
                            gameArray[row][col] = 'o';
                            validMove = 1; // validMove is set to 1 to exit the loop.
                            /**
                             * Checks if O has won.
                             * @return void.
                             */
                            OWinCheck.checkOWin();
                        }
                    }

                }
                /**
                 * Field is output updated.
                 * @return void.
                 */
                DrawField.drawField();
                validMove = 0; // validMove is set back to 0 for next move.
                /**
                 * If O has won asks if the players want to play again.
                 * @throws ArrayIndexOutOfBoundsException	if wrong number is choosen.
                 * @throws InputMismatchException			if type is not int.
                 * @throws Exception						if something else goes wrong.
                 */
                if (gameState == 2) {
                    System.out.println(playerName2 +" wins.");
                    System.out.println("Want to play again? \n 1 for yes \n 2 for no");
                    while (validInput == 0) {
                        try {
                            playAgain = inputScanner.nextInt();
                            if (playAgain != 2 && playAgain != 1) {
                                throw new java.lang.ArrayIndexOutOfBoundsException();
                            }
                            validInput = 1; //validInput is set to 1 to exit loop.
                        }

                        catch (java.util.InputMismatchException e) {
                            System.out.println("You have to type 1 or 2.");
                            inputScanner.nextLine();
                            continue;
                        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                            System.out.println("Please choose betweend 1 or 2.");
                            inputScanner.nextLine();
                            continue;
                        } catch (Exception e) {
                            System.out.println("Something stupid happend, try again.");
                            inputScanner.nextLine();
                            continue;
                        }

                    }
                    if (playAgain == 1) {
                        gameState = 0; // sets gameState to 0 to initialize a new game.
                        /**
                         * Method to reset the field.
                         * @return void.
                         */
                        ResetField.resetToStart();
                        player--; // Sets the player back to X player.
                        validInput = 0; // validInput is set back to 0 for next move.
                        continue;
                    } else if (playAgain == 2) {
                        gameMode = 2;
                        break; // Breaks the gameloop.
                    }

                }
                player--; // sets the player variable back to X player.
            }

        } // End of gameloop.
        /**
         *  Start of gameMode 2.
         *  Closes the programm.
         */
        if (gameMode == 2)

        {
            System.out.println("Thanks for playing!");
            System.out.println("Program is being closed...");
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {

            }
            System.out.println("bye bye");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.exit(0);
        } // End of GameMode 2.
        inputScanner.close(); // Closes the Scanner.
    } // End of main method.

} // End of the class.