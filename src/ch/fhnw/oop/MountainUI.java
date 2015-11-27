package ch.fhnw.oop;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

/**
 * Created by ANhi on 11/21/2015.
 */
public class MountainUI extends BorderPane {
    private final Mountain model;
    TableView<PresentationModelBergen> tableView;

    Button speichern;
    Button add;
    Button loeschen;
    Button zurueck;
    Button vorwaerts;

    TextField suche;

    Label nameOben;
    Label hoeheOben;
    Label gebietOben;

    ImageView image;

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

    NumberTextField hoechi;

    public MountainUI( Mountain model) {
        this.model = model;
        tableView = new TableView<>(model.getResulate());
        initializeControls();
        layoutControls();
        eventEvent();
    }

    private void initializeControls() {

        hoechi = new NumberTextField();

        speichern = new Button("sp");
        add = new Button("add");
        loeschen = new Button("loe");
        zurueck = new Button("zur");
        vorwaerts = new Button("vor");

        suche = new TextField("Suche");

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

    private void layoutControls(){
        setTop(createHBox());
        setCenter(createsplitPane());

    }

    private void eventEvent() {
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nameOben.textProperty().bind(tableView.getSelectionModel().getSelectedItem().nameProperty());
                hoeheOben.textProperty().bind(tableView.getSelectionModel().getSelectedItem().hightProperty().asString());
                gebietOben.textProperty().bind(tableView.getSelectionModel().getSelectedItem().regionProperty());

//                hoechi.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().hightProperty(), new );

//                name.textProperty().bind(tableView.getSelectionModel().getSelectedItem().nameProperty());
                hoehe.textProperty().bind(tableView.getSelectionModel().getSelectedItem().hightProperty().asString());
                dominanz.textProperty().bind(tableView.getSelectionModel().getSelectedItem().prominenceProperty().asString());
                scharten.textProperty().bind(tableView.getSelectionModel().getSelectedItem().isolationProperty().asString());
                km.textProperty().bind(tableView.getSelectionModel().getSelectedItem().prominencePointProperty());
                mBis.textProperty().bind(tableView.getSelectionModel().getSelectedItem().isolationPointProperty());
                typ.textProperty().bind(tableView.getSelectionModel().getSelectedItem().typProperty());
                region.textProperty().bind(tableView.getSelectionModel().getSelectedItem().regionProperty());
                kantone.textProperty().bind(tableView.getSelectionModel().getSelectedItem().cantonProperty());
                gebiet.textProperty().bind(tableView.getSelectionModel().getSelectedItem().rangeProperty());
                bildunterschrift.textProperty().bind(tableView.getSelectionModel().getSelectedItem().captionProperty());
            }
        });
        name.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                name.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().nameProperty());
            }
        });


    }

    private SplitPane createsplitPane(){
        SplitPane splitPanel = new SplitPane();
        splitPanel.setPrefSize(300,1000);
        splitPanel.getItems().addAll(createlistView(),createGridPane());
        splitPanel.setMinWidth(600);
        splitPanel.setDividerPositions(0.25);
        return splitPanel;
    }

    private GridPane createHBox(){
        GridPane gridPane = new GridPane();
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(cc,cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        gridPane.getRowConstraints().addAll(rc);

        HBox hBoRleft = new HBox();
        HBox hBoxRight = new HBox();

        hBoRleft.getChildren().addAll(speichern,add,loeschen, zurueck, vorwaerts);
        hBoRleft.setPadding(new Insets(10, 5, 5, 10));
        hBoRleft.setSpacing(5);

        hBoxRight.getChildren().add(suche);
        hBoxRight.setAlignment(Pos.BASELINE_RIGHT);
        hBoxRight.setPadding(new Insets(10, 10, 5, 10));

        gridPane.add(hBoRleft,0,0);
        gridPane.add(hBoxRight,1,0);

        return gridPane;
    }

    private TableView<PresentationModelBergen> createlistView(){

        TableColumn<PresentationModelBergen, Number> iDCol = new TableColumn<>("ID");
        iDCol.setCellValueFactory(param -> param.getValue().idBergProperty());

//        IDCol.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().idProperty()).asObject());

        TableColumn<PresentationModelBergen, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(param -> param.getValue().nameProperty());

        TableColumn<PresentationModelBergen, Number> hoeheCol = new TableColumn<>("Höhe");
        hoeheCol.setCellValueFactory(param -> param.getValue().hightProperty());
//        kantonCol1.setCellFactory(param -> param.getValue().kürzelProperty());

//        TableColumn<Wappen, ImageView> bildCol = new TableColumn<>("Wappen");
//        bildCol.setCellValueFactory(param -> param.getValue().getImageview1().getImage().);

        tableView.getColumns().addAll(iDCol, nameCol,hoeheCol);
        return tableView;
    }

    private GridPane createGridPane(){
        GridPane gridPane = new GridPane();

        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(cc,cc,cc,cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        gridPane.getRowConstraints().addAll(rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc);

        gridPane.setPadding(new Insets(5, 10, 10, 10));

        gridPane.add(nameOben,0,0); //colIndex, rowIndex, colSpan, rowSpan
        gridPane.add(hoeheOben,0,1);
        gridPane.add(gebietOben,0,2);

        gridPane.add(image, 2,0, 2,4 );

        gridPane.add(nameLabel,0,7);
        gridPane.add(dominanzLabel,0,8);
        gridPane.add(kmLabel,0,9);
        gridPane.add(typLabel,0,10);
        gridPane.add(kantoneLabel,0,11);
        gridPane.add(bildunterschriftLabel,0,12);

        gridPane.add(name,1,7);
        gridPane.add(dominanz,1,8);
        gridPane.add(km,1,9);
        gridPane.add(typ,1,10);
        gridPane.add(kantone,1,11);
        gridPane.add(bildunterschrift,1,12,4,1);

        gridPane.add(hoeheLabel,2,7);
        gridPane.add(schartenLabel,2,8);
        gridPane.add(mBisLabel,2,9);
        gridPane.add(regionLabel,2,10);
        gridPane.add(gebietLabel,2,11);

        gridPane.add(hoehe,3,7);
        gridPane.add(scharten,3,8);
        gridPane.add(mBis,3,9);
        gridPane.add(region,3,10);
        gridPane.add(gebiet,3,11);

        return gridPane;
    }
}
