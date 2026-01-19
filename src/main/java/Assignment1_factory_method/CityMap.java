package Assignment1_factory_method;
import Assignment1_factory_method.tiles.BuildingTile;
import Assignment1_factory_method.tiles.ForestTile;
import Assignment1_factory_method.tiles.RoadTile;
import Assignment1_factory_method.tiles.Tile;



public class CityMap extends Map {
    //road, forest, and building.

    public CityMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.size = width * height;
        this.mapTiles = new Tile[width][height];

    }

    public Tile createTile() {
        int randomNumber = (int) (Math.random() * 3);

        Tile tile = null;
        switch (randomNumber) {
            case 0: {
                tile = new RoadTile();
                break;
            }
            case 1: {
                tile = new ForestTile();
                break;
            }

            case 2: {
                tile = new BuildingTile();
                break;
            }
        }

        return tile;
    }


}
