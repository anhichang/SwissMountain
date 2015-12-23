package ch.fhnw.oop;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by ANhi on 11/21/2015.
 */
public class MountainApp extends Application {
    String styleSheet;
    static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage        = new Stage(StageStyle.DECORATED);
        ReadMountain model  = new ReadMountain();
        Parent rootPanel    = new MountainUI(model);

        scene               = new Scene(rootPanel, 300, 250);

        styleSheet          = getClass().getResource("styleBlack.css").toExternalForm();
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

    public static void main(String[] args) {
        launch(args);
    }
}
