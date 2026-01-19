package Assignment1_factory_method;

import Assignment1_factory_method.tiles.*;


public class WildernessMap extends Map {

    public WildernessMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.size = width * height;
        this.mapTiles = new Tile[width][height];
    }


    //swamp, water, and forest
   public Tile createTile() {
        int randomNumber = (int) (Math.random() * 3);

        Tile tile = null;
        switch (randomNumber) {
            case 0: {
                tile = new SwampTile();
                break;
            }
            case 1: {
                tile = new WaterTile();
                break;
            }

            case 2: {
                tile = new ForestTile();
                break;
            }
        }

        return tile;
    }


}
