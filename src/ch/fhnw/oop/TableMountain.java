package ch.fhnw.oop;

import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by ANhi on 11/27/2015.
 */
public class TableMountain extends TableView<Mountain> {

//    private TableView<Mountain> tableView; REDUNDANT!!!!!!!!!!!!!!!
    private ReadMountain model;

    public TableMountain(ReadMountain readMountain) {
        this.model = readMountain;
        initializeControls();
    }

    private void initializeControls() {
        initializeColTabelle();
        eventEvent();
    }

    public void initializeColTabelle() {
//    private TableView<Mountain> tableView; REDUNDANT!!!!!!!!!!!!!!!
//        setItems(model.getListBergen()); braucht es nicht mehr

        TableColumn<Mountain, Number> iDCol         = new TableColumn<>("ID");
        iDCol.setCellValueFactory(param1 -> param1.getValue().idBergProperty());
        iDCol.setMinWidth(30);

        TableColumn<Mountain, String> nameCol       = new TableColumn<>("Name");
        nameCol.setCellValueFactory(param -> param.getValue().nameProperty());
        nameCol.setMinWidth(115);

        TableColumn<Mountain, Number> hoeheCol      = new TableColumn<>("Höhe");
        hoeheCol.setCellValueFactory(param -> param.getValue().hightProperty());
        hoeheCol.setMinWidth(50);

        TableColumn<Mountain, String> cantonCol     = new TableColumn<>("Kanton");
        cantonCol.setCellValueFactory(cell -> cell.getValue().cantonProperty());
        cantonCol.setMinWidth(55);

        cantonCol.setCellFactory(param -> new TableCellMountain());

        getColumns().addAll(iDCol, nameCol, hoeheCol, cantonCol);

        SortedList<Mountain> sortedList = new SortedList<>(model.getFilteredData());
        sortedList.comparatorProperty().bind(comparatorProperty());

        setItems(sortedList);
    }

    private void eventEvent() {
        getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSelection, newSelection) -> model.setSelectedMountain(newSelection));

//        model.selectedMountainProperty().addListener(
//                (observableValue, oldSelection, newSelection) -> {
//                    model.setSelectedMountain(newSelection);
//                });
//
        getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldSelection, newSelection) -> {
                    try {
                        model.setSelectedMountainId(newSelection.idBergProperty().getValue());
                    }catch(NullPointerException e){
                        model.setSelectedMountainId(0);
                    }
                });
    }
}