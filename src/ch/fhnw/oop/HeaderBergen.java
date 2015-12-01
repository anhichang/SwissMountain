package ch.fhnw.oop;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

/**
 * Created by ANhi on 11/27/2015.
 */
public class HeaderBergen extends GridPane {
    private Button saveButton;
    private Button addButton;
    private Button deleteButton;
    private Button backButton;
    private Button forwardButton;
    private TextField searchTextField;

    private ReadMountain model;

    public HeaderBergen(ReadMountain model){
        this.model = model;
        initializeControls();
        layoutControls();
        addBindings();

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

    private void initializeControls() {
        saveButton = new Button("Save");
        addButton = new Button("Add");
        deleteButton = new Button("Delete");
        backButton = new Button("Back");
        forwardButton = new Button("Forward");
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
        hBoRleft.setSpacing(5);

        hBoxRight.getChildren().add(searchTextField);
        hBoxRight.setAlignment(Pos.BASELINE_RIGHT);
        hBoxRight.setPadding(new Insets(10, 10, 5, 10));

        add(hBoRleft,0,0);
        add(hBoxRight,1,0);
    }


}
