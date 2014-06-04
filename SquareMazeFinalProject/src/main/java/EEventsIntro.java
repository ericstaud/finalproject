import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by brian on 5/16/14.
 */
public class EEventsIntro extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(getClass().getSimpleName());

        final Group root = new Group();
        Scene scene = new Scene(root, 400, 400, Color.WHEAT);

        // -- 1. Add a text node that we will move around
        final Text text = new Text("100, 100");
        text.setLayoutX(100);
        text.setLayoutY(100);
        root.getChildren().add(text);

        // -- 2. Add a handler for when the mouse moves. It set's the location of the node
        // and changes the text to reflect the current position
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //event.getX -> relative to node origin
                //event.getSceneX -> relative to scene origin
                //event.getScreenX -> relative to screen orign
                
                // TODO - set the text nodes layout x and y values to match the events.
                // TODO - set the text to be the events -> x + ", " + y



            }
        });

        // -- 3. Add a handler for mouse clicks. It adds a red circle to the scene where you clicked
        // TODO - implement an eventhandler that adds circles where you clicked
        //scene.setOnMouseClicked();

        







        // -- 4. See http://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html for a zillion more
        // events you can add listeners too.

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
