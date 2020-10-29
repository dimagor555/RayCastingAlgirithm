package ru.dimagor555.raycasting.world.gameobjects;

import ru.dimagor555.raycasting.Constants;

public class Player extends GameObject {

    private double angle = 0;

    public Player(double x, double y) {
        super(x, y);
    }

    public void move(Direction direction) {
        double sinA = sin();
        double cosA = cos();

        switch (direction) {
            case FORWARD -> {
                x += Constants.MOVE_SPEED * cosA;
                y += Constants.MOVE_SPEED * sinA;
            }
            case BACK -> {
                x += -Constants.MOVE_SPEED * cosA;
                y += -Constants.MOVE_SPEED * sinA;
            }
            case RIGHT -> {
                x += -Constants.MOVE_SPEED * sinA;
                y += Constants.MOVE_SPEED * cosA;
            }
            case LEFT -> {
                x += Constants.MOVE_SPEED * sinA;
                y += -Constants.MOVE_SPEED * cosA;
            }
        }
    }

    public void rotate(boolean right) {
        if (right) {
            angle += Constants.ROTATE_SPEED;
        } else {
            angle -= Constants.ROTATE_SPEED;
        }
    }

    public int getRenderX() {
        return (int) Math.round(x);
    }

    public int getRenderY() {
        return (int) Math.round(y);
    }

    public double sin() {
        return Math.sin(Math.toRadians(angle));
    }

    public double cos() {
        return Math.cos(Math.toRadians(angle));
    }

    public double getAngle() {
        return angle;
    }

    public enum Direction {
        FORWARD, BACK, RIGHT, LEFT
    }
}
