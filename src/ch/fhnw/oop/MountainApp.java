package ch.fhnw.oop;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by ANhi on 11/21/2015.
 */
public class MountainApp extends Application {
    String styleSheet = new String();
    static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage = new Stage(StageStyle.DECORATED);
        ReadMountain model = new ReadMountain();
        Parent rootPanel = new MountainUI(model);

        scene = new Scene(rootPanel, 300, 250);

        styleSheet = getClass().getResource("styleBlack.css").toExternalForm();
        scene.getStylesheets().add(styleSheet);

        primaryStage.setMinWidth(1100);
        primaryStage.setMinHeight(800);

        primaryStage.setWidth(1100);
        primaryStage.setHeight(800);

        primaryStage.setTitle(model.getWindowTitle());
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.show();
    }

    public String getStyleSheet() {
        return styleSheet;
    }

    public void setStyleSheet(String styleSheet) {
        this.styleSheet = styleSheet;
    }

    public static Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
