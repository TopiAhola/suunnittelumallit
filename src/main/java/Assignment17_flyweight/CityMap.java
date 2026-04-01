package Assignment17_flyweight;


import Assignment17_flyweight.tiles.Tile;

public class CityMap extends Map {
    //road, forest, and building.

    public CityMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.size = width * height;
        this.mapTiles = new Tile[width][height];
        this.tileGraphicFactory = new TileGraphicFactory();

        this.fillMapWithTiles();

    }


    public Tile createTile() {
        int randomNumber = (int) (Math.random() * 3);

        Tile tile = null;
        switch (randomNumber) {
            case 0: {
                tile = tileGraphicFactory.getBuildingTile();
                break;
            }
            case 1: {
                tile = tileGraphicFactory.getForestTile();
                break;
            }

            case 2: {
                tile = tileGraphicFactory.getRoadTile();
                break;
            }
        }

        return tile;
    }


}
