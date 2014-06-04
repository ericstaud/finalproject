import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

/**
 * Created by brian on 5/16/14.
 */
public class CDrawingText extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(getClass().getSimpleName());
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.WHITE);

        // -- 1. In this loop we create Text nodes and then generate a random
        // rotation angle and color and add the them to the root node
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            int x = rand.nextInt((int) scene.getWidth());
            int y = rand.nextInt((int) scene.getHeight());
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);

            // TODO - add a text node at x, y

            // TODO rotate the text node and set its color. add it to the root node
            int rot = rand.nextInt(360);
            Color color = Color.rgb(red, green, blue, 0.99);

        }

        // -- 2. Remember, transforms applied to a node also apply to it's children
        // TODO - when all is added uncomment the lines below
//        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), root);
//        rotateTransition.setByAngle(360);
//        rotateTransition.setCycleCount(30);
//        rotateTransition.play();
//
//        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3), root);
//        scaleTransition.setByX(8.5);
//        scaleTransition.setByY(8.5f);
//        scaleTransition.setCycleCount(100);
//        scaleTransition.setAutoReverse(true);
//        scaleTransition.play();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
