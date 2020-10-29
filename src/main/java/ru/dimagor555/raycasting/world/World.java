package ru.dimagor555.raycasting.world;

import ru.dimagor555.raycasting.Constants;
import ru.dimagor555.raycasting.world.gameobjects.Player;
import ru.dimagor555.raycasting.world.gameobjects.Tile;

import java.util.ArrayList;

public class World {

    private int width;
    private int height;
    private ArrayList<Tile> tiles = new ArrayList<>();
    public Player player;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        player = new Player(Constants.WIDTH / 2, Constants.HEIGHT / 2);
    }

    public void setMap(String[] textMap) {
        if (textMap.length != height) {
            System.out.println("Error: Text map height do not matches map height");
            return;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (textMap[i].length() != width) {
                    System.out.println("Error: Text map width do not matches map width");
                    return;
                } else {
                    if (textMap[i].charAt(j) == '1') {
                        tiles.add(new Tile(j, i));
                    }
                }
            }
        }
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
