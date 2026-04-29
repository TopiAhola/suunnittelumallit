package Assignment22_command;

import java.util.Arrays;
import java.util.StringJoiner;

public class Editor {

    int width;
    int height;
    int cursorX;
    int cursorY;
    int cursorXMax;
    int cursorYMax;

    /**
     *  int[row index][col index] or int[y][x]
     *  top left = 0,0
     */
    int[][] pixelArt;


    public Editor(int width, int height){
        this.width = width;
        this.height = height;
        cursorXMax = width - 1;
        cursorYMax = height - 1;
        cursorX = 0;
        cursorY = 0;
        pixelArt = new int[height][width];

    }


    public void moveCursorUpCommand(){
        cursorY--;
        if(cursorY < 0) {
            cursorY = cursorYMax;
        } else if (cursorY > cursorYMax) {
            cursorY = 0;
        }

    }
    public void moveCursorDownCommand(){
        cursorY++;
        if(cursorY < 0) {
            cursorY = cursorYMax;
        } else if (cursorY > cursorYMax) {
            cursorY = 0;
        }

    }
    public void moveCursorLeftCommand(){
        cursorX--;
        if(cursorX < 0) {
            cursorX = cursorXMax;
        }  else if (cursorX > cursorXMax) {
            cursorX = 0;
        }

    }
    public void moveCursorRightCommand(){
        cursorX++;
        if(cursorX < 0) {
            cursorX = cursorXMax;
        }  else if (cursorX > cursorXMax) {
            cursorX = 0;
        }

    }

    public void togglePixelCommand(){
        if (0 <= cursorX && cursorX <= cursorXMax && 0 <= cursorY && cursorY <= cursorYMax) {
            pixelArt[cursorY][cursorX] = pixelArt[cursorY][cursorX] == 1 ? 0 : 1;
        } else {
            System.out.println("Invalid cursor position!");
        }
    }

    public void generateCodeCommand(){
        String codeString =
                String.format(
                        "int[][] pixelArt = %s;",
                        Arrays.deepToString(pixelArt)
                                .replace("[", "{"  )
                                .replace("]","}")
                );
        System.out.println( codeString );

        //better printout
        StringJoiner codeString2 = new StringJoiner(",\n\t", "int[][] pixelArt = {\n\t", "\n};" );
        for ( int[] row : pixelArt){
            codeString2.add(
                    Arrays.toString(row)
                    .replace("[", "{"  )
                    .replace("]","}")
            );
        }
        System.out.println(codeString2);
    }

    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }

    public int getCursorXMax() {
        return cursorXMax;
    }

    public int getCursorYMax() {
        return cursorYMax;
    }

    public int[][] getPixelArt() {
        return pixelArt;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
