package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 * Sample solution for Lab 5 Section 6
 */
public class GuiMain_v1 extends Application {

    GardenPlanner planner;

    public GuiMain_v1() {
        planner = new GardenPlanner();
        planner.createBasicDesign();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));

        Pane root = new Pane();
        root.setStyle("-fx-background-color: #007700;");

        /* Create and add a rectangle shape to the pane
        Rectangle rec = new Rectangle(100, 100);
        pane.getChildren().add(rec);
        rec.setX(10);
        rec.setY(10);
        */

        // Hook with a GardenPlanner instance
        // A default garden layout is created in the constructor
        for (RectBed bed : planner.getBeds()) {
            Rectangle rec = new Rectangle(bed.getWidth()*100, bed.getHeight()*100);
            rec.setX(bed.getLeft()*100);
            rec.setY(bed.getTop()*100);
            root.getChildren().add(rec);
        }


        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
