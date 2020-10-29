package ru.dimagor555.raycasting;

public class Constants {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    public static final int TILE_SIZE = 100;

    public static final int WORLD_SIZE = 8;

    public static final int MOVE_SPEED = 2;
    public static final double ROTATE_SPEED = 2;

    //Raycasting
    public static final double FOV = Math.toDegrees(Math.PI) / 2;
    public static final double HALF_FOV = FOV / 2;
    public static final int NUM_RAYS = 1200;
    public static final int MAX_DEPTH = 800;
    public static final double DELTA_ANGLE = FOV / NUM_RAYS;

    public static final double DIST = NUM_RAYS / (2 * Math.tan(Math.toRadians(HALF_FOV)));
    public static final double PROJ_COEF = DIST * TILE_SIZE * 0.75;
    public static final int SCALE = WIDTH / NUM_RAYS;
}