package Assignment1_factory_method;

public class Game {

    public static void main(String[] args) {

        Map City = new CityMap(3,3);
        Map Wilderness = new WildernessMap(4,4);


        City.mapTiles[1][1] = City.createTile();
        City.display();

        for (int i = 0; i < Wilderness.height; i++) {
            for (int j = 0; j < Wilderness.width; j++) {
                Wilderness.mapTiles[i][j] = Wilderness.createTile();
            }

        }
        Wilderness.display();

    }



}
