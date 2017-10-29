package ru.ndra.deadfall.combat;

import android.view.MotionEvent;

import ru.ndra.deadfall.Game;
import ru.ndra.engine.Scene;
import ru.ndra.engine.Sprite;
import ru.ndra.engine.TouchEvent;

public class CombatControlsScene extends Scene {

    private final Bar bar;

    public CombatControlsScene(Game game) {

        super(game);

        // Верхняя полоска со скиллами
        bar = new Bar(game);
        game.world.add(bar);

        // Кнопки

        Sprite moveBackButton = new Sprite(game) {
            public void onTouch(TouchEvent event) {
                if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_POINTER_DOWN) {
                    this.game.eventManager.trigger("control/move-backward");
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    this.game.eventManager.trigger("control/move-stop");
                }
            }
        };
        moveBackButton.width = 200;
        moveBackButton.height = 200;
        moveBackButton.position.y = -200;
        moveBackButton.position.x = -700;
        moveBackButton.zIndex = 1000;
        moveBackButton.game.world.add(moveBackButton);
        moveBackButton.isButton = true;

        Sprite moveForthButton = new Sprite(game) {
            public void onTouch(TouchEvent event) {
                if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_POINTER_DOWN) {
                    this.game.eventManager.trigger("control/move-forward");
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    this.game.eventManager.trigger("control/move-stop");
                }
            }
        };
        moveForthButton.width = 200;
        moveForthButton.height = 200;
        moveForthButton.position.y = -200;
        moveForthButton.position.x = -300;
        moveForthButton.zIndex = 1000;
        moveForthButton.game.world.add(moveForthButton);
        moveForthButton.isButton = true;


    }

}