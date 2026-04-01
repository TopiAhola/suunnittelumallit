package Assignment17_flyweight;


import Assignment17_flyweight.tiles.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Map {

    public int width;
    public int height;
    public int size;
    public Tile[][] mapTiles;
    public TileGraphicFactory tileGraphicFactory;


    public abstract Tile createTile ();

    /**
     * Fills a map with tiles from createTile()
     */
    public void fillMapWithTiles(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.mapTiles[i][j] = createTile();
            }
        }
    }


    public void display(){
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                char printOut = '_';
                 if (this.mapTiles[y][x] != null) {
                     printOut = this.mapTiles[y][x].getCharacter();
                 }
                 System.out.print(printOut);
            }
            //newline
            System.out.println();
        }

    }

    /**
     * Draws Tiles on a Canvas. Size of canvas is 100px * map.width, and height
     * @return Drawn map Canvas
     */
    public Canvas draw(){
        Canvas canvas = new Canvas(width*100, height*100);
        GraphicsContext gc =  canvas.getGraphicsContext2D();

        for (int tileX = 0; tileX < width; tileX++ ) {
            for (int tileY = 0; tileY < height; tileY++) {

                //draw image at coordinates (image, x ,y)
                gc.drawImage(mapTiles[tileX][tileY].getImage(), tileX*100, tileY*100);
                gc.stroke();

            }
        }


        return canvas;
    }

}
