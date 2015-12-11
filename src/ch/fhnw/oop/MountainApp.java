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

    private Pane splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;
    private Stage mainStage;
    Scene splashScene;
    private static final int SPLASH_WIDTH = 676;

    @Override public void init() {
        ImageView splash = new ImageView(new Image("mountainpictures/0-1.jpg"));
        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(SPLASH_WIDTH - 20);
        progressText = new Label("Loading Swiss-Mountains");
        splashLayout = new VBox();
        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
        progressText.setAlignment(Pos.CENTER);
        splashLayout.setStyle("-fx-padding: 5; -fx-background-color: cornsilk; -fx-border-width:5; -fx-border-color: linear-gradient(to bottom, chocolate, derive(chocolate, 50%));");
        splashLayout.setEffect(new DropShadow());
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        showSplash(primaryStage);
        showMainStage();
    }

    private void showMainStage() {
        mainStage = new Stage(StageStyle.DECORATED);
        ReadMountain model = new ReadMountain();
        Parent rootPanel = new MountainUI(model);

        Scene scene = new Scene(rootPanel, 300, 250);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);

        mainStage.setMinWidth(1500);
        mainStage.setMinHeight(900);

        mainStage.setWidth(1000);
        mainStage.setHeight(700);

        mainStage.setTitle(model.getWindowTitle());
        mainStage.setScene(scene);
        mainStage.show();
    }
    private void showSplash(Stage initStage) throws Exception {
        splashScene = new Scene(splashLayout);
        initStage.initStyle(StageStyle.UNDECORATED);
//        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        initStage.setScene(splashScene);
//        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
//        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
        initStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
