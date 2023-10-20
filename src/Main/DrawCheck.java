package Main;

public class DrawCheck {
    /**
     *  Method that checks if the game is a draw.
     */
    public static void drawCheck() {
        if ((Main.gameArray[0][0] == 'o' || Main.gameArray[0][0] == 'x')
                && (Main.gameArray[0][1] == 'o' || Main.gameArray[0][1] == 'x')
                && (Main.gameArray[0][2] == 'o' || Main.gameArray[0][2] == 'x')
                && (Main.gameArray[1][0] == 'o' || Main.gameArray[1][0] == 'x')
                && (Main.gameArray[1][1] == 'o' || Main.gameArray[1][1] == 'x')
                && (Main.gameArray[1][2] == 'o' || Main.gameArray[1][2] == 'x')
                && (Main.gameArray[2][0] == 'o' || Main.gameArray[2][0] == 'x')
                && (Main.gameArray[2][1] == 'o' || Main.gameArray[2][1] == 'x')
                && (Main.gameArray[2][2] == 'o' || Main.gameArray[2][2] == 'x')) {
            Main.gameState = 3;
        }
    }

}
