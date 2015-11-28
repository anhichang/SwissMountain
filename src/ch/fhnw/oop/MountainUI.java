package ch.fhnw.oop;

import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Callback;

/**
 * Created by ANhi on 11/21/2015.
 */
public class MountainUI extends BorderPane {
    private final EditorBergen editorBergen;
    private final HeaderBergen headerBergen;
    private final TableView<Mountain> tableView;

    public MountainUI( ReadMountain model) {
        this.editorBergen = new EditorBergen(model);
        this.headerBergen = new HeaderBergen();

        tableView = new TabelleBergen(model).initializeResultatTabelle();
        layoutControls();
        eventEvent();
        System.out.println(model.getListBergen().get(1).getIdBerg() + " MountainUI");
    }

    private void initializeControls() {
    }

    private void layoutControls(){
        initializeControls();
        setTop(headerBergen);
        setCenter(createsplitPane());
    }

    private void eventEvent() {

//        editorBergen.getName().textProperty().bind(tableView.getSelectionModel().getSelectedItem().hightProperty().asString());

        tableView.setOnMouseClicked(new EventHandler<MouseEvent>()
        {@Override
        public void handle(MouseEvent event) {
            editorBergen.getNameTextfield().textProperty().bind(tableView.getSelectionModel().getSelectedItem().nameProperty());
//            System.out.println(tableView.getItems().get(2).getHight()+ " EditorBergen");
        }
        });

    }

    private SplitPane createsplitPane(){
        SplitPane splitPanel = new SplitPane();
        splitPanel.setPrefSize(300,1000);
        splitPanel.getItems().addAll(tableView,editorBergen);
        splitPanel.setMinWidth(600);
        splitPanel.setDividerPositions(0.25);
        return splitPanel;
    }
    private void addBindings(){

    }
}
