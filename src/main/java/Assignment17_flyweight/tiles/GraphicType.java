package Assignment17_flyweight.tiles;

public enum GraphicType {
    building("src/main/java/Assignment17_flyweight/images/building.bmp"),
    forest("src/main/java/Assignment17_flyweight/images/forest.bmp"),
    road("src/main/java/Assignment17_flyweight/images/road.bmp"),
    swamp("src/main/java/Assignment17_flyweight/images/swamp.bmp"),
    tile("src/main/java/Assignment17_flyweight/images/tile.bmp"),
    water("src/main/java/Assignment17_flyweight/images/water.bmp");

    public final String filePath;

    GraphicType(String path){
        this.filePath = path;
    };
}
