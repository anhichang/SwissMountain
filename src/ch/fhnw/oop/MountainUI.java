package ch.fhnw.oop;

import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Created by ANhi on 11/21/2015.
 */
public class MountainUI extends BorderPane {
    ReadMountain model;
    private EditorBergen editorBergen;
    private HeaderBergen headerBergen;
    private TabelleBergen tabelleBergen;

//    private final TableView<Mountain> tableView VERBOTEN;

    public MountainUI( ReadMountain model) {
        this.model = model;
        initializeControls();
        layoutControls();
        eventEvent();
    }

    private void initializeControls() {
        this.editorBergen = new EditorBergen(model);
        this.headerBergen = new HeaderBergen(model);
        this.tabelleBergen = new TabelleBergen(model);
    }

    private void layoutControls(){
        initializeControls();
        setTop(headerBergen);
        setCenter(createsplitPane());
    }

    private void eventEvent() {

    }


    private SplitPane createsplitPane(){
        SplitPane splitPanel = new SplitPane();
        splitPanel.setPrefSize(300,1000);
        splitPanel.getItems().addAll(tabelleBergen,editorBergen);
        splitPanel.setMinWidth(600);
        splitPanel.setDividerPositions(0.25);
        return splitPanel;
    }
    private void addBindings(){

    }
}
