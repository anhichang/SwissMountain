package ch.fhnw.oop;

import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Created by ANhi on 11/21/2015.
 */
public class MountainUI extends BorderPane {
    private ReadMountain model;
    private EditorMountain editorMountain;
    private HeaderMountain headerMountain;
    private TableMountain tableMountain;

//    private final TableView<Mountain> tableView VERBOTEN;

    public MountainUI(ReadMountain model) {
        this.model = model;
        initializeControls();
        layoutControls();
        eventEvent();
    }

    private void initializeControls() {
        this.headerMountain = new HeaderMountain(model);
        this.tableMountain = new TableMountain(model);
        this.editorMountain = new EditorMountain(model);
    }

    private void layoutControls() {
        initializeControls();
        setTop(headerMountain);
        setCenter(createsplitPane());
    }

    private void eventEvent() {

    }

    private SplitPane createsplitPane() {
        SplitPane splitPanel = new SplitPane();
        splitPanel.setPrefSize(400, 200);
        splitPanel.getItems().addAll(tableMountain, editorMountain);
        splitPanel.setMinSize(800,500);
        splitPanel.setDividerPositions(0.5);
        return splitPanel;
    }

    private void addBindings() {

    }
}