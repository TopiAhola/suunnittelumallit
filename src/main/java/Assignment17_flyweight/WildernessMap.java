package Assignment17_flyweight;


import Assignment17_flyweight.tiles.Tile;

public class WildernessMap extends Map {

    public WildernessMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.size = width * height;
        this.mapTiles = new Tile[width][height];
        this.tileGraphicFactory = new TileGraphicFactory();

        this.fillMapWithTiles();
    }


    //swamp, water, and forest
   public Tile createTile() {
        int randomNumber = (int) (Math.random() * 3);

        Tile tile = null;
        switch (randomNumber) {
            case 0: {
                tile = tileGraphicFactory.getSwampTile();
                break;
            }
            case 1: {
                tile = tileGraphicFactory.getWaterTile();
                break;
            }

            case 2: {
                tile = tileGraphicFactory.getForestTile();
                break;
            }
        }

        return tile;
    }


}
