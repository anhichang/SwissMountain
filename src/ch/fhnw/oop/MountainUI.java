package ch.fhnw.oop;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Created by ANhi on 11/21/2015.
 */
public class MountainUI extends BorderPane {
    private final Mountain model;
    private TableView<Bergen> tabelle;

    Button speichern;
    Button add;
    Button loeschen;
    Button zurueck;
    Button vorwaerts;

    TextField suche;

    Label nameOben;
    Label kmOben;
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

    public MountainUI(Mountain model) {
        this.model = model;
        initializeControls();
        layoutControls();
        eventEvent();
    }

    private void initializeControls() {
        speichern = new Button("sp");
        add = new Button("add");
        loeschen = new Button("loe");
        zurueck = new Button("zur");
        vorwaerts = new Button("vor");

        suche = new TextField("Suche");

        nameOben = new Label("-----");
        kmOben = new Label("-----");
        gebietOben = new Label("----");

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

    private void eventEvent(){

    }

    private SplitPane createsplitPane(){
        SplitPane splitPanel = new SplitPane();
        splitPanel.setOrientation(Orientation.HORIZONTAL);
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

    private TableView<Bergen> createlistView(){
        TableView<Bergen> tableView = new TableView<>(model.getResulate());

        TableColumn<Bergen, Number> IDCol = new TableColumn<>("ID");
        IDCol.setCellValueFactory(param -> param.getValue().IDProperty());
//        IDCol.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().idProperty()).asObject());

        TableColumn<Bergen, String> NameCol = new TableColumn<>("Name");
        NameCol.setCellValueFactory(param -> param.getValue().nameProperty());

        TableColumn<Bergen, String> hoeheCol1 = new TableColumn<>("Höhe");
        hoeheCol1.setCellValueFactory(param -> param.getValue().hoeheProperty());
//        kantonCol1.setCellFactory(param -> param.getValue().kürzelProperty());

        tableView.getColumns().addAll(IDCol, NameCol,hoeheCol1);
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
        gridPane.add(kmOben,0,1);
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
