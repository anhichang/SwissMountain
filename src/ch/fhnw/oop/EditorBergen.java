package ch.fhnw.oop;

import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * Created by ANhi on 11/27/2015.
 */
public class EditorBergen extends GridPane {
    TableView<Mountain> tableView;

    ImageView image;
    Label nameOben;
    Label hoeheOben;
    Label gebietOben;

    Label nameLabel;
    Label dominanzLabel;
    Label kmLabel;
    Label typLabel;
    Label kantoneLabel;
    Label bildunterschriftLabel;
    Label hoeheLabel;
    Label schartenLabel;
    Label mBisLabel;
    Label regionLabel;
    Label gebietLabel;

    TextField name;
    TextField dominanz;
    TextField km;
    TextField typ;
    TextField kantone;
    TextField bildunterschrift;
    TextField hoehe;
    TextField scharten;
    TextField mBis;
    TextField region;
    TextField gebiet;

    public EditorBergen(ReadMountain model ) {
        this.tableView = new TableView<>(model.getListBergen());
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();
    }

    private void initializeControls() {
        nameOben = new Label();
        hoeheOben = new Label();
        gebietOben = new Label();

        Image picture = new Image("0-1.jpg");
        image = new ImageView(picture);
        image.setFitHeight(200);
        image.setFitWidth(200);

        nameLabel = new Label("Name");
        dominanzLabel = new Label("Dominanz");
        kmLabel = new Label("Km bis");
        typLabel = new Label("Typ");
        kantoneLabel = new Label("Kantone");
        bildunterschriftLabel = new Label("Bildunterschrift");
        hoeheLabel = new Label("Höhe");
        schartenLabel = new Label("Scharten");
        mBisLabel = new Label("m bis");
        regionLabel = new Label("Region");
        gebietLabel = new Label("Gebiet");

        name = new TextField();
        dominanz = new TextField();
        km = new TextField();
        typ  = new TextField();
        kantone = new TextField();
        bildunterschrift = new TextField();
        hoehe = new TextField();
        scharten = new TextField();
        mBis = new TextField();
        region = new TextField();
        gebiet = new TextField();
    }

    private void layoutControls() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc,cc,cc,cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc);

        setPadding(new Insets(5, 10, 10, 10));

        add(nameOben,0,0); //colIndex, rowIndex, colSpan, rowSpan
        add(hoeheOben,0,1);
        add(gebietOben,0,2);

        add(image, 2,0, 2,4 );

        add(nameLabel,0,7);
        add(dominanzLabel,0,8);
        add(kmLabel,0,9);
        add(typLabel,0,10);
        add(kantoneLabel,0,11);
        add(bildunterschriftLabel,0,12);

        add(name,1,7);
        add(dominanz,1,8);
        add(km,1,9);
        add(typ,1,10);
        add(kantone,1,11);
        add(bildunterschrift,1,12,4,1);

        add(hoeheLabel,2,7);
        add(schartenLabel,2,8);
        add(mBisLabel,2,9);
        add(regionLabel,2,10);
        add(gebietLabel,2,11);

        add(hoehe,3,7);
        add(scharten,3,8);
        add(mBis,3,9);
        add(region,3,10);
        add(gebiet,3,11);
    }
    private void addBindings() {
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>()
        {@Override
        public void handle(MouseEvent event) {
            nameOben.textProperty().bind(tableView.getSelectionModel().getSelectedItem().nameProperty());
            hoehe.textProperty().bind(tableView.getSelectionModel().getSelectedItem().hightProperty().asString());
            System.out.println(tableView.getItems().get(2).getHight()+ " EditorBergen");
        }
        });
    }

    private void addEventHandlers() {

    }

    public void addValueChangedListeners(){

    }

}
