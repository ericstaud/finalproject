
# Final Project Ideas



## Shooter game
A game where there is a main character with a gun who shoots enemies. It will move from left to right.
The character can move forward, jump, and shoot.

## Basketball game
User will aim at a basket and choose how hard (s)he wants to throw it with a power meter.

## Fly game
A character will fly in the sky and try to avoid objects by moving up or down

## Final Idea - Square Maze
The user will move a square that tries to get to the door at the bottom of the maze. (S)He is forced to stay inide of the lines of the maze and tries to avoid being hit by a big red circle.

There are pockets in the maze walls for the user to "hide" from being hit by the circle.

If the user hits the circle they are relocated to the start.

Every time the user reaches the door they are relocated and the circle is sped up.

In case I can't get github to commit my changes here is the code

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class SquareMaze extends Application {

    public static Circle circle;
    public static Circle doorHandle;
    public static Pane canvas;

    @Override
    public void start(final Stage primaryStage) {

        canvas = new Pane();
        final Scene scene = new Scene(canvas, 800, 600);

        primaryStage.setTitle("Square Maze");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setFill(Color.ORANGE);

        final Rectangle rectangle = new Rectangle(1, 1, 15, 15);
        final Rectangle door = new Rectangle(360, 560, 30, 35);
        door.setFill(Color.BURLYWOOD);
        doorHandle = new Circle(3, Color.WHITE);
        doorHandle.relocate(379, 578);



        final Rectangle rectangleMazeLeft = new Rectangle(385, 35, 5, 260);
        final Rectangle rectangleMazeRight = new Rectangle(455, 0, 5, 135);

        final Rectangle rectangleMazeFirstPocketRightTop = new Rectangle(455, 135, 40, 5);
        final Rectangle rectangleMazeFirstPocketRightSideRight = new Rectangle(495, 135, 5, 40);
        final Rectangle rectangleMazeFirstPocketRightSideBottom = new Rectangle(455, 175, 45, 5);

        final Rectangle rectangleMazeSecondPocketLeftSideTop = new Rectangle(345, 295, 45, 5);
        final Rectangle rectangleMazeSecondPocketLeftSideLeft = new Rectangle(345, 295, 5, 45);
        final Rectangle rectangleMazeSecondPocketLeftSideBottom = new Rectangle(345, 335, 45, 5);

        final Rectangle rectangleMazeTopLeft = new Rectangle(0, 35, 385, 5);
        final Rectangle rectangleMazeRight2 = new Rectangle(455, 175, 5, 250);

        final Rectangle rectangleMazeThirdPocketRightSideTop = new Rectangle(455, 425, 40, 5);
        final Rectangle rectangleMazeThirdPocketRightSideRight = new Rectangle(495, 425, 5, 40);
        final Rectangle rectangleMazeThirdPocketRightSideBottom = new Rectangle(455, 465, 45, 5);

        final Rectangle rectangleMazeRight3 = new Rectangle(455, 465, 5, 135);

        final Rectangle rectangleMazeLeft2 = new Rectangle(385, 340, 5, 225);
        final Rectangle rectangleMazeBottom = new Rectangle(0, 595, 460, 5);

        canvas.getChildren().add(rectangle);
        canvas.getChildren().add(rectangleMazeLeft);
        canvas.getChildren().add(rectangleMazeTopLeft);
        canvas.getChildren().add(rectangleMazeRight);
        canvas.getChildren().add(rectangleMazeFirstPocketRightTop);
        canvas.getChildren().add(rectangleMazeFirstPocketRightSideRight);
        canvas.getChildren().add(rectangleMazeFirstPocketRightSideBottom);
        canvas.getChildren().add(rectangleMazeSecondPocketLeftSideTop);
        canvas.getChildren().add(rectangleMazeSecondPocketLeftSideLeft);
        canvas.getChildren().add(rectangleMazeSecondPocketLeftSideBottom);
        canvas.getChildren().add(rectangleMazeRight2);
        canvas.getChildren().add(rectangleMazeThirdPocketRightSideTop);
        canvas.getChildren().add(rectangleMazeThirdPocketRightSideRight);
        canvas.getChildren().add(rectangleMazeThirdPocketRightSideBottom);
        canvas.getChildren().add(rectangleMazeRight3);
        canvas.getChildren().add(rectangleMazeLeft2);
        canvas.getChildren().add(rectangleMazeBottom);
        canvas.getChildren().add(door);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.LEFT)) {
                    rectangle.setLayoutX(rectangle.getLayoutX() - 10);
                }
                else if (event.getCode().equals(KeyCode.RIGHT)) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + 10);
                }
                else if (event.getCode().equals(KeyCode.DOWN)) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + 10);
                }
                else if (event.getCode().equals(KeyCode.UP)) {
                    rectangle.setLayoutY(rectangle.getLayoutY() - 10);
                }

            }
        });


        circle = new Circle(24, Color.RED);
        circle.relocate(400, 10);



        canvas.getChildren().addAll(circle);

        canvas.getChildren().add(doorHandle);



        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaX = 0;
            double deltaY = 1.8;

            @Override
            public void handle(final ActionEvent t) {
                circle.setLayoutX(circle.getLayoutX() + deltaX);
                circle.setLayoutY(circle.getLayoutY() + deltaY);



                final Bounds bounds = canvas.getBoundsInLocal();
                final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
                final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
                final boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
                final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());
                final boolean atRectangle = circle.getBoundsInParent().intersects(rectangle.getBoundsInParent());
                final boolean atRectangleMazeTopLeft = rectangle.getBoundsInParent().intersects(rectangleMazeTopLeft.getBoundsInParent());


                final boolean atRectangleMazeRight = rectangle.getBoundsInParent().intersects(rectangleMazeRight.getBoundsInParent());
                final boolean atRectangleMazeFirstPocketRightTop = rectangle.getBoundsInParent().intersects(rectangleMazeFirstPocketRightTop.getBoundsInParent());
                final boolean atRectangleMazeFirstPocketRightSideRight = rectangle.getBoundsInParent().intersects(rectangleMazeFirstPocketRightSideRight.getBoundsInParent());
                final boolean atRectangleMazeFirstPocketRightSideBottom = rectangle.getBoundsInParent().intersects(rectangleMazeFirstPocketRightSideBottom.getBoundsInParent());
                final boolean atRectangleMazeSecondPocketLeftSideTop = rectangle.getBoundsInParent().intersects(rectangleMazeSecondPocketLeftSideTop.getBoundsInParent());
                final boolean atRectangleMazeSecondPocketLeftSideLeft = rectangle.getBoundsInParent().intersects(rectangleMazeSecondPocketLeftSideLeft.getBoundsInParent());
                final boolean atRectangleMazeSecondLeftSideBottom = rectangle.getBoundsInParent().intersects(rectangleMazeSecondPocketLeftSideBottom.getBoundsInParent());
                final boolean atRectangleMazeRight2 = rectangle.getBoundsInParent().intersects(rectangleMazeRight2.getBoundsInParent());
                final boolean atRectangleMazeThirdPocketRightSideTop = rectangle.getBoundsInParent().intersects(rectangleMazeThirdPocketRightSideTop.getBoundsInParent());
                final boolean atRectangleMazeThirdPocketRightSideRight = rectangle.getBoundsInParent().intersects(rectangleMazeThirdPocketRightSideRight.getBoundsInParent());
                final boolean atRectangleMazeThirdPocketRightSideBottom = rectangle.getBoundsInParent().intersects(rectangleMazeThirdPocketRightSideBottom.getBoundsInParent());
                final boolean atRectangleMazeRight3 = rectangle.getBoundsInParent().intersects(rectangleMazeRight3.getBoundsInParent());
                final boolean atRectangleMazeLeft2 = rectangle.getBoundsInParent().intersects(rectangleMazeLeft2.getBoundsInParent());
                final boolean atRectangleMazeBottom = rectangle.getBoundsInParent().intersects(rectangleMazeBottom.getBoundsInParent());


                final boolean atRectangleMazeLeft = rectangle.getBoundsInParent().intersects(rectangleMazeLeft.getBoundsInParent());

                final boolean atDoor = rectangle.getBoundsInParent().intersects(door.getBoundsInParent());

                if (atRightBorder || atLeftBorder) {
                    deltaX *= -1;
                }
                if (atBottomBorder || atTopBorder) {
                    deltaY *= -1;
                }
                if (atRectangle) {
//                    deltaY *= -1;
                    rectangle.relocate(10, 10);
                }
                if (atRectangleMazeTopLeft) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + -.5);

                }

                if (atDoor) {
                    rectangle.relocate(10,10);
                    deltaY += .3;
                }

                if (atRectangleMazeLeft) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + .2);

                }


                if (atRectangleMazeRight) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + -.2);

                }

                if (atRectangleMazeFirstPocketRightTop) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + .2);

                }

                if (atRectangleMazeFirstPocketRightSideRight) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + -.2);

                }

                if (atRectangleMazeFirstPocketRightSideBottom) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + -.2);

                }

                if (atRectangleMazeSecondPocketLeftSideTop) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + .2);

                }

                if (atRectangleMazeSecondPocketLeftSideLeft) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + .2);

                }

                if (atRectangleMazeSecondLeftSideBottom) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + -.2);

                }

                if (atRectangleMazeRight2) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + -.2);

                }

                if (atRectangleMazeThirdPocketRightSideTop) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + .2);

                }

                if (atRectangleMazeThirdPocketRightSideRight) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + -.2);

                }

                if (atRectangleMazeThirdPocketRightSideBottom) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + -.2);

                }

                if (atRectangleMazeSecondPocketLeftSideTop) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + .2);

                }

                if (atRectangleMazeRight3) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + -.2);

                }

                if (atRectangleMazeLeft2) {
                    rectangle.setLayoutX(rectangle.getLayoutX() + .2);

                }
                if (atRectangleMazeBottom) {
                    rectangle.setLayoutY(rectangle.getLayoutY() + -.2);

                }

            }
        }));


        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }



    public static void main(final String[] args) {
        launch(args);
    }
}
