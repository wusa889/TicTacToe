package Main;

public class OWinCheck {
    /**
     *  Method to check if O has won.
     */
    public static void checkOWin() {
        // Check if won horizontal.
        if (Main.gameArray[0][0] == 'o' && Main.gameArray[0][1] == 'o' && Main.gameArray[0][2] == 'o') {
            Main.gameState = 2;
        } else if (Main.gameArray[1][0] == 'o' && Main.gameArray[1][1] == 'o' && Main.gameArray[1][2] == 'o') {
            Main.gameState = 2;
        } else if (Main.gameArray[2][0] == 'o' && Main.gameArray[2][1] == 'o' && Main.gameArray[2][2] == 'o') {
            Main.gameState = 2;
            // Check if won vertikal.
        } else if (Main.gameArray[0][0] == 'o' && Main.gameArray[1][0] == 'o' && Main.gameArray[2][0] == 'o') {
            Main.gameState = 2;
        } else if (Main.gameArray[0][1] == 'o' && Main.gameArray[1][1] == 'o' && Main.gameArray[2][1] == 'o') {
            Main.gameState = 2;
        } else if (Main.gameArray[0][2] == 'o' && Main.gameArray[1][2] == 'o' && Main.gameArray[2][2] == 'o') {
            Main.gameState = 2;
            // Check if won diagonal.
        } else if (Main.gameArray[0][0] == 'o' && Main.gameArray[1][1] == 'o' && Main.gameArray[2][2] == 'o') {
            Main.gameState = 2;
        } else if (Main.gameArray[0][2] == 'o' && Main.gameArray[1][1] == 'o' && Main.gameArray[2][0] == 'o') {
            Main.gameState = 2;
        }
    }
}
