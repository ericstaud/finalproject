import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by brian on 5/16/14.
 */
public class BSceneGraph extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Basic Scene Graph Demo");

        Group root = new Group();
        Scene scene = new Scene(root, 400, 400, Color.WHITE);

        // -- 1. A group is not directly sizeable. It takes on the bound of it's children
        Group subnode = new Group();


        // -- 2. We can shift the node relative to it's parent's coordinates
        // TODO - shift the node +100 x and y relative to it's parent



        // -- 3. Add some objects to subnode
        // More shapes at http://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/package-summary.html
        // TODO - create a 50x50 Blue rectangle offset 50, 50 from it's parent. Add to the subnode

        // TODO - create a 30px radius Red circle at 100, 90.



        // -- 4. Transforms applied to a node also apply to it's children
        // TODO after everything is displayed. Uncomment the lines below
        //RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), subnode);
        //rotateTransition.setByAngle(360);
        //rotateTransition.setCycleCount(30);
        //rotateTransition.play();


        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
