package ch.fhnw.oop;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ListCell;
import javafx.util.Callback;

/**
 * Created by ANhi on 11/27/2015.
 */
public class TabelleBergen extends TableView {
    TableView<Mountain> tableView;
    ReadMountain model;

    public TabelleBergen(ReadMountain readMountain) {
        this.model = readMountain;
        initializeControls();
        System.out.println(readMountain.getListBergen().get(20).getHight() + " TabelleBergen");
    }

    private void initializeControls() {
        tableView = initializeResultatTabelle();
    }

    public TableView<Mountain> initializeResultatTabelle() {

        tableView = new TableView<>(model.getListBergen());

        TableColumn<Mountain, Number> iDCol = new TableColumn<>("ID");
        iDCol.setCellValueFactory(param1 -> param1.getValue().idBergProperty());

        TableColumn<Mountain, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(param -> param.getValue().nameProperty());

        TableColumn<Mountain, Number> hoeheCol = new TableColumn<>("Höhe");
        hoeheCol.setCellValueFactory(param -> param.getValue().hightProperty());

        tableView.getColumns().addAll(iDCol, nameCol,hoeheCol);
        System.out.println(model.getListBergen().get(20).getHight() + " TabelleBergen");

        return tableView;
    }

    }
