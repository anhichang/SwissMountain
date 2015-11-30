package ch.fhnw.oop;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * Created by ANhi on 11/27/2015.
 */
public class TabelleBergen extends TableView<Mountain> {

//    private TableView<Mountain> tableView; REDUNDANT!!!!!!!!!!!!!!!

    private ReadMountain model;

    public TabelleBergen(ReadMountain readMountain) {

        this.model = readMountain;
        System.out.println(readMountain.getListBergen().get(20).getHight() + " TabelleBergen");
        initializeControls();
    }

    private void initializeControls() {
        initializeColTabelle();
        eventEvent();
    }

    public void initializeColTabelle() {
//    private TableView<Mountain> tableView; REDUNDANT!!!!!!!!!!!!!!!

        setItems(model.getListBergen());

        TableColumn<Mountain, Number> iDCol = new TableColumn<>("ID");
        iDCol.setCellValueFactory(param1 -> param1.getValue().idBergProperty());

        TableColumn<Mountain, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(param -> param.getValue().nameProperty());

        TableColumn<Mountain, Number> hoeheCol = new TableColumn<>("Höhe");
        hoeheCol.setCellValueFactory(param -> param.getValue().hightProperty());

        getColumns().addAll(iDCol, nameCol, hoeheCol);

    }
    private void eventEvent() {
        getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSelection, newSelection) -> model.setSelectedMountain(newSelection));

//        model.selectedMountainProperty().addListener((observableValue, oldSelection, newSelection) -> {
////update der Tabellenselektion und scrolling zur Selektion
//    };
    }
}