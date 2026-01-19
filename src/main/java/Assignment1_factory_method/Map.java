package Assignment1_factory_method;

import Assignment1_factory_method.tiles.Tile;


public abstract class Map {

    public int width;
    public int height;
    public int size;
    public Tile[][] mapTiles;

    public abstract Tile createTile ();

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
}
