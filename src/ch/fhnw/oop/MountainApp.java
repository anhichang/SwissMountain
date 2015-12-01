package ch.fhnw.oop;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by ANhi on 11/21/2015.
 */
public class MountainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ReadMountain model = new ReadMountain();
        Parent rootPanel = new MountainUI(model);

        Scene scene = new Scene(rootPanel);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);

        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(700);

        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);

        primaryStage.setTitle(model.getWindowTitle());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
