package ru.dimagor555.raycasting;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ru.dimagor555.raycasting.world.RayCasting;
import ru.dimagor555.raycasting.world.World;
import ru.dimagor555.raycasting.world.gameobjects.Tile;

public class WorldRender {

    private World world;

    public WorldRender(World world) {
        this.world = world;
    }

    public void render(Canvas canvas) {
        var gc = canvas.getGraphicsContext2D();
        renderBG(gc);
        RayCasting.doRayCasting(world.player, world.getTiles(), canvas);
        renderMiniMap(gc);
    }

    private void renderMiniMap(GraphicsContext gc) {
        renderTiles(gc);
        renderPlayer(gc);
    }

    private void renderBG(GraphicsContext gc) {
        gc.setFill(Color.SKYBLUE);
        gc.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT / 2d);
        gc.setFill(Color.GREEN);
        gc.fillRect(0, Constants.HEIGHT / 2d, Constants.WIDTH, Constants.HEIGHT / 2d);
    }

    private void renderTiles(GraphicsContext gc) {
        var tiles = world.getTiles();
        final int tileSize = Constants.TILE_SIZE;

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.setLineWidth(1);
        for (Tile tile : tiles) {
            gc.strokeRect(500 + tile.getX() * tileSize / 5, tile.getY() * tileSize / 5,
                    tileSize / 5f, tileSize / 5f);
        }
    }

    private void renderPlayer(GraphicsContext gc) {
        var player = world.player;

        double startXOffset = 500 - 20 / 5f;

        gc.setFill(Color.BLUE);
        gc.fillOval(startXOffset + (player.getRenderX() / 5f) - 2, (player.getRenderY() / 5f) - 2, 20 / 5f, 20 / 5f);

        gc.strokeLine(startXOffset + player.getRenderX() / 5f, player.getRenderY() / 5f,
                startXOffset + player.getX() / 5f + Constants.WIDTH / 100f * player.cos(),
                player.getY() / 5f + Constants.WIDTH / 100f * player.sin());
    }
}
