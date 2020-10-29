package ru.dimagor555.raycasting;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import ru.dimagor555.raycasting.world.World;

public class Game {

    private final Canvas canvas;
    private final WorldRender worldRender;
    private final World world;

    public Game() {
        canvas = new Canvas(Constants.WIDTH, Constants.HEIGHT);
        canvas.getGraphicsContext2D().setFont(new Font(24));

        world = new World(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        world.setMap(new String[]{
                "11111111",
                "10000001",
                "10011001",
                "10000001",
                "10000001",
                "10000001",
                "10000001",
                "11111111"});

        worldRender = new WorldRender(world);
    }

    public static double deltaTime = 1000;

    public void render() {
        long startTime = System.nanoTime();

        worldRender.render(canvas);
        renderFPS(canvas);

        deltaTime = (System.nanoTime() - startTime) / 1_000_000d;
        deltaTime = deltaTime <= 0 ? 1 : deltaTime;
    }

    private void renderFPS(Canvas canvas) {
        var gc = canvas.getGraphicsContext2D();
        double fps = 1000 / deltaTime;
        gc.fillText((int)fps + "", 20, 20);
    }

    public Scene createScene() {
        Scene scene = new Scene(new Pane(canvas));
        var keyHandler = new KeyHandler(world);
        scene.setOnKeyPressed(keyHandler);
        scene.setOnKeyReleased(keyHandler);
        return scene;
    }
}
