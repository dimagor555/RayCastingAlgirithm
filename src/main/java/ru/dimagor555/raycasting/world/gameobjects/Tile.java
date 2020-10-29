package ru.dimagor555.raycasting.world.gameobjects;

public class Tile extends GameObject {

    public Tile(double x, double y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tile) {
            Tile tile = ((Tile) obj);
            return tile.x == x && tile.y == y;
        } else {
            return false;
        }
    }
}
