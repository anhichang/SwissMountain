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
    private TableView<Mountain> tableView;


    private ImageView image;
    private Label nameOben;
    private Label hoeheOben;
    private Label gebietOben;

    private Label nameLabel;
    private Label dominanzLabel;
    private Label kmLabel;
    private Label typLabel;
    private Label kantoneLabel;
    private Label bildunterschriftLabel;
    private Label hoeheLabel;
    private Label schartenLabel;
    private Label mBisLabel;
    private Label regionLabel;
    private Label gebietLabel;

    private TextField nameTextfield;
    private TextField dominanzTextfield;
    private TextField kmTextfield;
    private TextField typTextfield;
    private TextField kantoneTextfield;
    private TextField bildunterschriftTextfield;
    private TextField hoeheTextfield;
    private TextField schartenTextfield;
    private TextField mBisTextfield;
    private TextField regionTextfield;
    private TextField gebietTextfield;

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

        nameTextfield = new TextField();
        dominanzTextfield = new TextField();
        kmTextfield = new TextField();
        typTextfield = new TextField();
        kantoneTextfield = new TextField();
        bildunterschriftTextfield = new TextField();
        hoeheTextfield = new TextField();
        schartenTextfield = new TextField();
        mBisTextfield = new TextField();
        regionTextfield = new TextField();
        gebietTextfield = new TextField();
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

        add(nameTextfield,1,7);
        add(dominanzTextfield,1,8);
        add(kmTextfield,1,9);
        add(typTextfield,1,10);
        add(kantoneTextfield,1,11);
        add(bildunterschriftTextfield,1,12,4,1);

        add(hoeheLabel,2,7);
        add(schartenLabel,2,8);
        add(mBisLabel,2,9);
        add(regionLabel,2,10);
        add(gebietLabel,2,11);

        add(hoeheTextfield,3,7);
        add(schartenTextfield,3,8);
        add(mBisTextfield,3,9);
        add(regionTextfield,3,10);
        add(gebietTextfield,3,11);
    }
    private void addBindings() {
    }

    public void addEventHandlers() {
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>()
        {@Override
        public void handle(MouseEvent event) {
            nameTextfield.textProperty().bind(tableView.getSelectionModel().getSelectedItem().nameProperty());
            System.out.println(tableView.getItems().get(2).getHight()+ " EditorBergen");
        }
        });
    }

    public void addValueChangedListeners(){

    }

}
