package Assignment17_flyweight.tiles;

import javafx.scene.image.Image;

public abstract class Tile implements ImageFlyweight {

    public String type;
    public char character;
    private Image graphic;


    /**
     * returns the character that represents the tile type
     */
    public char getCharacter() {
        return this.character;
    }

    /**
     * returns the tile type as a string (e.g. "swamp", "water", "road", "forest", "building")
     */
    public String getType(){
        return this.type;
    }

    @Override
    public Image getImage() {
        return this.graphic;
    }

    public void setImage(Image im){
        this.graphic = im;
    }
}
