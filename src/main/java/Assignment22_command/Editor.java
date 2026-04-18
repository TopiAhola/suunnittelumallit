package Assignment22_command;

import java.util.Arrays;
import java.util.StringJoiner;

public class Editor {

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
        cursorXMax = width;
        cursorYMax = height;
        cursorX = 0;
        cursorY = 0;
        pixelArt = new int[height][width];

    }


    public void moveCursorUpCommand(){

    }
    public void moveCursorDownCommand(){

    }
    public void moveCursorLeftCommand(){

    }
    public void moveCursorRightCommand(){

    }
    public void togglePixelCommand(){

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



}
