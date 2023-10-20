package Main;

public class DrawField {
    /**
     *  Method to print the field.
     */
    public static void drawField() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + Main.gameArray[Main.fieldBuilder][0] + " | " + Main.gameArray[Main.fieldBuilder][1] + " | "
                    + Main.gameArray[Main.fieldBuilder][2] + " ");
            Main.fieldBuilder++;
            if (i == 2) {
                continue;
            }
            for (int j = 0; j < 1; j++) {
                System.out.println("---+---+---");
            }
        }
        Main.fieldBuilder = 0;
    }
}