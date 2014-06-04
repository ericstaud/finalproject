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


public class YGamePractice extends Application {

    public static Circle circle;

    public static Pane canvas;

    @Override
    public void start(final Stage primaryStage) {

        canvas = new Pane();
        final Scene scene = new Scene(canvas, 800, 600);

        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        final Rectangle rectangle = new Rectangle(1, 1, 15, 15);
        final Rectangle rectangleMazeLeft = new Rectangle(375, 35, 5, 600);
        final Rectangle rectangleMazeTopLeft = new Rectangle(0, 35, 375, 5);
        canvas.getChildren().add(rectangle);
        canvas.getChildren().add(rectangleMazeLeft);
        canvas.getChildren().add(rectangleMazeTopLeft);

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


        circle = new Circle(15, Color.BLUE);
        circle.relocate(400, 10);



        canvas.getChildren().addAll(circle);





        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaX = 0;
            double deltaY = 3;

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

            }
        }));


        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }



    public static void main(final String[] args) {
        launch(args);
    }
}