
# Final Project Ideas



## Shooter game
A game where there is a main character with a gun who shoots enemies. It will move from left to right.
The character can move forward, jump, and shoot.

## Basketball game
User will aim at a basket and choose how hard (s)he wants to throw it with a power meter.

## Fly game
A character will fly in the sky and try to avoid objects by moving up or down

## Final Idea - Gem Catcher
User will try to avoid items on a path, as of right now circles, and try to retrieve gems.

Currently having issues making the rectanlge relocate when it intersects with the circle.

/**
 * Created by Eric on 5/23/2014.
 */
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PathGameProject extends Application {

    public static Circle circle;
    public static Pane canvas;

    @Override
    public void start(final Stage primaryStage) {
        Group root = new Group();
        canvas = new Pane();
        final Scene scene = new Scene(root, 800, 800, Color.WHITE);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        final Rectangle rectangle = new Rectangle(150, 150, 20, 20);
        root.getChildren().add(rectangle);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.LEFT)) {
                    rectangle.setLayoutX(rectangle.getLayoutX() - 10);
                }
                else if (event.getCode().equals(KeyCode.RIGHT)) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + 10);
                }
                else if (event.getCode().equals(KeyCode.UP)) {
                    rectangle.setLayoutY(rectangle.getLayoutY() - 10);
                }
                else if (event.getCode().equals(KeyCode.DOWN)) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + 10);
                }
            }
        });

        // -- 1. Build a Path using helper elements
        Path path = new Path();
        root.getChildren().add(path); // comment this line to hide path from stage

        Path path2 = new Path();
        root.getChildren().add(path2);

        path2.getElements().add (new MoveTo (350f, 800f));
        path2.getElements().add (new LineTo (350f, 0f));

        MoveTo moveTo = new MoveTo();
        moveTo.setX(300.0f);
        moveTo.setY(0.0f);

        MoveTo moveTo1 = new MoveTo();
        moveTo1.setX(300.0f);
        moveTo1.setY(0.0f);


        LineTo lineTo = new LineTo();
        lineTo.setX(300.0f);
        lineTo.setY(800.0f);


        path.getElements().add(moveTo);
//        path.getElements().add(hLineTo);
//        path.getElements().add(quadCurveTo);
        path.getElements().add(lineTo);
//        path.getElements().add(arcTo);


        // -- 2. Create a circle
        Circle circle = new Circle(100, 100, 20, Color.DARKORCHID);
        root.getChildren().add(circle);

        Circle circle2 = new Circle(100, 100, 20, Color.DARKORCHID);
        root.getChildren().add(circle2);


        final boolean atRectangle = circle.getBoundsInParent().intersects(rectangle.getBoundsInParent());

        if (atRectangle) {

            rectangle.relocate(10,10);
        }



        // -- 3. Animate cirlce along path
        PathTransition pathTransition = new PathTransition(Duration.seconds(5), path, circle);
        pathTransition.setCycleCount(1000);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        PathTransition pathTransition2 = new PathTransition(Duration.seconds(5), path2, circle2);
        pathTransition2.setCycleCount(1000);
        pathTransition2.setAutoReverse(true);
        pathTransition2.play();

 

    }

    public static void main(final String[] args) {
        launch(args);
    }
}
