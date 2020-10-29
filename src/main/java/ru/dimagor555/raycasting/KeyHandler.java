package ru.dimagor555.raycasting;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ru.dimagor555.raycasting.world.gameobjects.Player;
import ru.dimagor555.raycasting.world.World;

import java.util.HashMap;

public class KeyHandler implements EventHandler<KeyEvent> {

    private World world;
    private HashMap<KeyCode, Boolean> pressedKeys = new HashMap<>();

    public KeyHandler(World world) {
        this.world = world;
        startKeysThread();
    }

    private void startKeysThread() {
        new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handleKeys();
            }
        }).start();
    }

    private void handleKeys() {
        pressedKeys.forEach((keyCode, aBoolean) -> {
            if (aBoolean) {
                switch (keyCode) {
                    case W -> world.player.move(Player.Direction.FORWARD);
                    case S -> world.player.move(Player.Direction.BACK);
                    case A -> world.player.move(Player.Direction.LEFT);
                    case D -> world.player.move(Player.Direction.RIGHT);
                }
                switch (keyCode) {
                    case Q -> world.player.rotate(false);
                    case E -> world.player.rotate(true);
                }
            }
        });
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
            pressedKeys.put(keyEvent.getCode(), true);
        } else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
            pressedKeys.put(keyEvent.getCode(), false);
        }
    }
}
