package ch.fhnw.oop;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Created by ANhi on 11/27/2015.
 */
public class HeaderBergen extends GridPane {
    private ImageView saveImage;
    private ImageView addImage;
    private ImageView deleteImage;
    private ImageView backImage;
    private ImageView forwardImage;

    private Button saveButton;
    private Button addButton;
    private Button deleteButton;
    private Button backButton;
    private Button forwardButton;

    private TextField searchTextField;

    private ReadMountain model;

    public HeaderBergen(ReadMountain model){
        getStyleClass().add("grid");
        this.model = model;
        initializeControls();
        layoutControls();
        addBindings();

    }

    private void initializeControls() {
        saveImage       = new ImageView(new Image("headerPicture/saveIcon.png"));
        addImage        = new ImageView(new Image("headerPicture/addIcon.png"));
        deleteImage     = new ImageView(new Image("headerPicture/deleteIcon.png"));
        backImage       = new ImageView(new Image("headerPicture/backIcon.png"));
        forwardImage    = new ImageView(new Image("headerPicture/forwardIcon.png"));

        saveButton      = new Button("323",saveImage);
        addButton       = new Button();
        deleteButton    = new Button();
        backButton      = new Button();
        forwardButton   = new Button();
        searchTextField = new TextField("Search");

    }

    private void layoutControls(){
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc,cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc);

        HBox hBoRleft = new HBox();
        HBox hBoxRight = new HBox();

        hBoRleft.getChildren().addAll(saveButton, addButton, deleteButton, backButton, forwardButton);
        hBoRleft.setPadding(new Insets(10, 5, 5, 10));
        hBoRleft.setSpacing(10);

        hBoxRight.getChildren().add(searchTextField);
        hBoxRight.setAlignment(Pos.BASELINE_RIGHT);
        hBoxRight.setPadding(new Insets(10, 10, 5, 10));

        add(hBoRleft,0,0);
        add(hBoxRight,1,0);
    }

    private void addBindings() {
        saveButton.setOnAction(
                event -> model.save()
        );
        deleteButton.setOnAction(
                event -> model.remove()
        );
        addButton.setOnAction(
                event -> model.add()
        );
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            model.setFilterString(newValue);
        });
    }
    }

