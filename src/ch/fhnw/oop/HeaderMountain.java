package ch.fhnw.oop;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Created by ANhi on 11/27/2015.
 */
public class HeaderMountain extends GridPane implements ViewMixin<Mountain>{

    private ImageView saveImage;
    private ImageView addImage;
    private ImageView deleteImage;
    private ImageView backImage;
    private ImageView forwardImage;

    private ImageView whiteStyle;
    private ImageView blackStyle;

    private Button saveButton;
    private Button addButton;
    private Button deleteButton;
    private Button undoButton;
    private Button redoButton;

    private TextField searchTextField;
    private Button blackStyleButton;
    private Button whiteStyleButton;

    final Tooltip tooltipSave       = new Tooltip("Save");
    final Tooltip tooltipAdd        = new Tooltip("Add");
    final Tooltip tooltipDelete     = new Tooltip("Delete");
    final Tooltip tooltipUndo       = new Tooltip("Undo");
    final Tooltip tooltipRedo       = new Tooltip("Redo");

    final Tooltip tooltipBlack      = new Tooltip("Change to black style");
    final Tooltip tooltipWhite      = new Tooltip("Change to white style");

    private String styleSheetWhite  = getClass().getResource("styleWhite.css").toExternalForm();
    private String styleSheetBlack  = getClass().getResource("styleBlack.css").toExternalForm();

    private ReadMountain model;

    public HeaderMountain(ReadMountain model) {
        getStyleClass().add("grid");
        this.model = model;
        init();
    }
    public void init(){
        initializeControls();
        layoutControls();
        addEventHandlers();
        addBindings();
    }

    @Override
    public Mountain getPresentationModel() {
        return null;
    }

    public void initializeControls() {
        saveImage       = new ImageView(new Image("ch/fhnw/oop/res/headerPicture/saveIcon.png"));
        addImage        = new ImageView(new Image("ch/fhnw/oop/res/headerPicture/addIcon.png"));
        deleteImage     = new ImageView(new Image("ch/fhnw/oop/res/headerPicture/deleteIcon.png"));
        backImage       = new ImageView(new Image("ch/fhnw/oop/res/headerPicture/backIcon.png"));
        forwardImage    = new ImageView(new Image("ch/fhnw/oop/res/headerPicture/forwardIcon.png"));

        whiteStyle      = new ImageView(new Image("ch/fhnw/oop/res/headerPicture/whiteStyle.png"));
        blackStyle      = new ImageView(new Image("ch/fhnw/oop/res/headerPicture/blackStyle.png"));

        saveImage.setFitWidth(20);
        saveImage.setFitHeight(20);
        addImage.setFitWidth(20);
        addImage.setFitHeight(20);
        deleteImage.setFitWidth(20);
        deleteImage.setFitHeight(20);
        backImage.setFitWidth(20);
        backImage.setFitHeight(20);
        forwardImage.setFitWidth(20);
        forwardImage.setFitHeight(20);
        whiteStyle.setFitWidth(20);
        whiteStyle.setFitHeight(20);
        blackStyle.setFitWidth(20);
        blackStyle.setFitHeight(20);

        saveButton          = new Button("", saveImage);
        addButton           = new Button("", addImage);
        deleteButton        = new Button("", deleteImage);
        undoButton          = new Button("", backImage);
        redoButton          = new Button("", forwardImage);

        searchTextField     = new TextField("Search");
        blackStyleButton    = new Button("",blackStyle);
        whiteStyleButton    = new Button("",whiteStyle);

        saveButton.setTooltip(tooltipSave);
        addButton.setTooltip(tooltipAdd);
        deleteButton.setTooltip(tooltipDelete);
        undoButton.setTooltip(tooltipUndo);
        redoButton.setTooltip(tooltipRedo);

        blackStyleButton.setTooltip(tooltipBlack);
        whiteStyleButton.setTooltip(tooltipWhite);
    }

    public void layoutControls() {
        ColumnConstraints cc                    = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc);

        RowConstraints rc                       = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc);

        HBox hBoRleft                           = new HBox();
        HBox hBoxRight                          = new HBox();

        hBoRleft.getChildren().addAll(saveButton, addButton, deleteButton, undoButton, redoButton);
        hBoRleft.setPadding(new Insets(10, 5, 5, 10));
        hBoRleft.setSpacing(10);

        hBoxRight.getChildren().addAll(blackStyleButton, whiteStyleButton, searchTextField);
        hBoxRight.setAlignment(Pos.BASELINE_RIGHT);
        hBoxRight.setPadding(new Insets(10, 10, 5, 10));

        add(hBoRleft, 0, 0);
        add(hBoxRight, 1, 0);

    }

    public void addBindings() {
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
        undoButton.disableProperty().bind(model.undoDisabledProperty());
        redoButton.disableProperty().bind(model.redoDisabledProperty());
    }

    public void addEventHandlers() {
        undoButton.setOnAction(event -> model.undo());
        redoButton.setOnAction(event -> model.redo());

        blackStyleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getScene().getStylesheets().remove(styleSheetWhite);
                getScene().getStylesheets().add(styleSheetBlack);
            }
        });

        whiteStyleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getScene().getStylesheets().remove(styleSheetBlack);
                getScene().getStylesheets().add(styleSheetWhite);
            }
        });
    }
}