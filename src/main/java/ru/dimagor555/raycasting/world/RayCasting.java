package ru.dimagor555.raycasting.world;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import ru.dimagor555.raycasting.Constants;
import ru.dimagor555.raycasting.world.gameobjects.Player;
import ru.dimagor555.raycasting.world.gameobjects.Tile;

import java.util.ArrayList;

public class RayCasting {

    public static void doRayCasting(Player player, ArrayList<Tile> tiles, Canvas canvas) {
        var currAngle = player.getAngle() - Constants.HALF_FOV;

        for (int ray = 0; ray < Constants.NUM_RAYS; ray++) {
            double sinA = Math.sin(Math.toRadians(currAngle));
            double cosA = Math.cos(Math.toRadians(currAngle));
            for (int depth = 0; depth < Constants.MAX_DEPTH; depth++) {
                double x = player.getX() + depth * cosA;
                double y = player.getY() + depth * sinA;

                Tile tileToCompare = new Tile((int) (x / Constants.TILE_SIZE),
                        (int) (y / Constants.TILE_SIZE));

                if (tiles.contains(tileToCompare)) {
                    depth *= Math.cos(Math.toRadians(player.getAngle() - currAngle));
                    double proj_height = Constants.PROJ_COEF / depth;

                    var gc = canvas.getGraphicsContext2D();

                    float colorCoef = Math.max(0.2f,
                            (Constants.MAX_DEPTH - depth) / (float)Constants.MAX_DEPTH);
                    Color color = new Color(0.69803923f * colorCoef,
                            0.13333334f * colorCoef,
                            0.13333334f * colorCoef,
                            1);
                    gc.setFill(color);
                    gc.fillRect(ray * Constants.SCALE,
                            Constants.HEIGHT / 2 - (int) (proj_height / 2),
                            Constants.SCALE, proj_height);
                    break;
                }

//                var gc = canvas.getGraphicsContext2D();
//                gc.strokeLine(player.getRenderX(), player.getRenderY(), x, y);
            }
            currAngle += Constants.DELTA_ANGLE;
        }
    }
}
