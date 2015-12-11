package ch.fhnw.oop;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Created by ANhi on 11/27/2015.
 */
public class HeaderBergen extends GridPane {

    private Image saveImage;
    private Image addImage;
    private Image deleteImage;
    private Image backImage;
    private Image forwardImage;

    private Button saveButton;
    private Button addButton;
    private Button deleteButton;
    private Button backButton;
    private Button forwardButton;


    private TextField searchTextField;

    private TabelleBergen tabelleBergen;
    private ReadMountain model;

    public HeaderBergen(ReadMountain model){
        getStyleClass().add("grid");
        this.model = model;
        tabelleBergen = new TabelleBergen(model);
        initializeControls();
        layoutControls();
        addBindings();
        initFilter();

    }

    private void initializeControls() {
        saveButton      = new Button();
        addButton       = new Button();
        deleteButton    = new Button();
        backButton      = new Button();
        forwardButton   = new Button();
        searchTextField = new TextField("Search");

        saveButton.getStyleClass().add("saveButton");
        addButton.getStyleClass().add("addButton");
        deleteButton.getStyleClass().add("deleteButton");
        backButton.getStyleClass().add("backButton");
        forwardButton.getStyleClass().add("forwardButton");

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
//        saveButton.setOnAction(event ->model.save());		//button.setOnAction(event -> model.addColor());
        saveButton.setOnAction(
                event -> model.save()
        );
        deleteButton.setOnAction(
                event -> model.remove()
        );
        addButton.setOnAction(
                event -> model.add()
        );
    }

    private void initFilter() {
        FilteredList<Mountain> filteredData = new FilteredList<>(model.getListBergen(), p -> true);

        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(mountain -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (mountain.getName().toLowerCase().contains(lowerCaseFilter)) {
                    System.out.println(mountain.getName());
                    return true;
                }else{
                    return false;
                }
            });
        });

        SortedList<Mountain> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tabelleBergen.comparatorProperty());
        tabelleBergen.setItems(sortedData);
    }
    }

