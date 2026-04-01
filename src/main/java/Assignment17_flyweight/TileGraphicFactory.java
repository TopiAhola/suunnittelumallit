package Assignment17_flyweight;

import Assignment17_flyweight.tiles.*;

import java.io.FileInputStream;
import java.util.EnumMap;

import javafx.scene.image.Image;

public class TileGraphicFactory {

    public EnumMap<GraphicType, javafx.scene.image.Image> graphics;

    public TileGraphicFactory() {
        try {
            graphics = new EnumMap<>(GraphicType.class);

            //load images only once
            for (GraphicType gt : GraphicType.values()) {
                System.out.println(gt.filePath);
                graphics.put(gt, new javafx.scene.image.Image(new FileInputStream(gt.filePath)));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Tile getBuildingTile(){
        Tile tile = new BuildingTile();
        tile.graphic = graphics.get(GraphicType.building);

        return tile;
    }

    public Tile getForestTile(){
        Tile tile = new ForestTile();
        tile.graphic = graphics.get(GraphicType.forest);

        return tile;
    }

    public Tile getRoadTile(){
        Tile tile = new RoadTile();
        tile.graphic = graphics.get(GraphicType.road);

        return tile;
    }

    public Tile getSwampTile(){
        Tile tile = new SwampTile();
        tile.graphic = graphics.get(GraphicType.swamp);

        return tile;
    }

    public Tile getWaterTile(){
        Tile tile = new WaterTile();
        tile.graphic = graphics.get(GraphicType.water);

        return tile;
    }




}
