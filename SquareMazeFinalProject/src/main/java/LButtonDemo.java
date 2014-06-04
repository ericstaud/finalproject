import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by brian on 5/17/14.
 */
public class LButtonDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);

        // --- 1. Create a button
        final Button btn = new Button("Hello World");
        btn.setLayoutX(100);
        btn.setLayoutY(80);

        // --- 2. Add an EventHandler to do something when the button is clicked
        // TODO - Add an eventhandler that prints "Hello World" to the console.
        // TODO - In the eventhandler add a RotateTransition to spin the button when clicked.        




        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
