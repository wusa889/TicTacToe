package Main;

public class XWinCheck {
    /**
     *  Method to check if X has won.
     */
    public static void checkXWin() {
        // Check if won horizontal.
        if (Main.gameArray[0][0] == 'x' && Main.gameArray[0][1] == 'x' && Main.gameArray[0][2] == 'x') {
            Main.gameState = 1;
        } else if (Main.gameArray[1][0] == 'x' && Main.gameArray[1][1] == 'x' && Main.gameArray[1][2] == 'x') {
            Main.gameState = 1;
        } else if (Main.gameArray[2][0] == 'x' && Main.gameArray[2][1] == 'x' && Main.gameArray[2][2] == 'x') {
            Main.gameState = 1;
            // Check if won vertikal.
        } else if (Main.gameArray[0][0] == 'x' && Main.gameArray[1][1] == 'x' && Main.gameArray[2][2] == 'x') {
            Main.gameState = 1;
        } else if (Main.gameArray[0][2] == 'x' && Main.gameArray[1][1] == 'x' && Main.gameArray[2][0] == 'x') {
            Main.gameState = 1;
        } else if (Main.gameArray[0][0] == 'x' && Main.gameArray[1][0] == 'x' && Main.gameArray[2][0] == 'x') {
            Main.gameState = 1;
            // Check if won diagonal.
        } else if (Main.gameArray[0][1] == 'x' && Main.gameArray[1][1] == 'x' && Main.gameArray[2][1] == 'x') {
            Main.gameState = 1;
        } else if (Main.gameArray[0][2] == 'x' && Main.gameArray[1][2] == 'x' && Main.gameArray[2][2] == 'x') {
            Main.gameState = 1;
        }
    }
}
