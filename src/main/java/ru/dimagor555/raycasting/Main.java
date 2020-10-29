package ru.dimagor555.raycasting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game();

        stage.setScene(game.createScene());
        stage.setOnCloseRequest(windowEvent -> System.exit(0));
        stage.show();

        startRenderThread(game);
    }

    public void startRenderThread(Game game) {
        new Thread(() -> {
            while (true) {
                try {
                    int sleepTime = (int) Math.ceil(Game.deltaTime);
                    sleepTime = Math.max(sleepTime, 5);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(game::render);
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
