package ch.fhnw.oop;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by ANhi on 11/27/2015.
 */
public class TabelleBergen extends TableView<Mountain> {

//    private TableView<Mountain> tableView; REDUNDANT!!!!!!!!!!!!!!!

    private ReadMountain model;

    public TabelleBergen(ReadMountain readMountain) {
        this.model = readMountain;
        initializeControls();
    }


    private void initializeControls() {
        initializeColTabelle();
        eventEvent();
    }

    public void initializeColTabelle() {
//    private TableView<Mountain> tableView; REDUNDANT!!!!!!!!!!!!!!!
        setItems(model.getListBergen());

        TableColumn<Mountain, Number> iDCol         = new TableColumn<>("ID");
        iDCol.setCellValueFactory(param1 -> param1.getValue().idBergProperty());

        TableColumn<Mountain, String> nameCol       = new TableColumn<>("Name");
        nameCol.setCellValueFactory(param -> param.getValue().nameProperty());

        TableColumn<Mountain, Number> hoeheCol      = new TableColumn<>("Höhe");
        hoeheCol.setCellValueFactory(param -> param.getValue().hightProperty());

        TableColumn<Mountain, String> cantonCol     = new TableColumn<>("Kanton");
        cantonCol.setCellValueFactory(cell -> cell.getValue().cantonProperty());

        cantonCol.setCellFactory(param -> new BergenZelle());

        getColumns().addAll(iDCol, nameCol, hoeheCol, cantonCol);

    }
    private void eventEvent() {
        getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSelection, newSelection) -> model.setSelectedMountain(newSelection));

        model.selectedMountainProperty().addListener((observableValue, oldSelection, newSelection) -> {
            model.setSelectedMountain(newSelection);
                });
////update der Tabellenselektion und scrolling zur Selektion
//    };
    }

}