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

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage = new Stage(StageStyle.DECORATED);
        ReadMountain model = new ReadMountain();
        Parent rootPanel = new MountainUI(model);

        Scene scene = new Scene(rootPanel, 300, 250);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);

        primaryStage.setMinWidth(1500);
        primaryStage.setMinHeight(900);

        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);

        primaryStage.setTitle(model.getWindowTitle());
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
