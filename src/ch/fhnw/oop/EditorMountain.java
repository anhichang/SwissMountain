package ch.fhnw.oop;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import java.io.File;
import java.util.Locale;
/**
 * Created by ANhi on 11/27/2015.
 */
public class EditorMountain extends GridPane implements ViewMixin<ReadMountain>{
    // private TableView<Mountain> tableView; VERBOTEN
    private ReadMountain model;
    private static Locale country;
//    private static MapOptions mapOptions;
//    private static GoogleMapView mapView;
//    private static GoogleMap map;

    private ImageView imageView;

    private Circle glass;
    private Label nameOben;
    private Label hightOben;
    private Label regionOben;

    private Label nameLabel;
    private Label isolationLabel;
    private Label isolationPointLabel;
    private Label typLabel;
    private Label cantonLabel;
    private Label captionLabel;
    private Label hightLabel;
    private Label prominanceLabel;
    private Label prominancePointLabel;
    private Label regionLabel;
    private Label rangeLabel;

    private TextField nameTextfield;
    private TextField isolationTextfield;
    private TextField isolationPointfield;
    private TextField typTextfield;
    private TextField cantonTextfield;
    private TextField captionTextfield;
    private TextField hightTextfield;
    private TextField prominanceTextfield;
    private TextField prominancePointTextfield;
    private TextField regionTextfield;
    private TextField rangeTextfield;


    public EditorMountain(ReadMountain model) {
        this.model = model;
        init();
//        mapInitialized();
    }

    public void init() {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addBindings();
        addValueChangedListeners();
    }

    @Override
    public ReadMountain getPresentationModel() {
        return model;
    }

    public void initializeControls() {
        getStyleClass().add("editorBergen");

//        mapOptions = new MapOptions();

        nameOben    = new Label();
        hightOben   = new Label();
        regionOben  = new Label();

        regionOben.getStyleClass().add("labelKantoneHight");
        nameOben.getStyleClass().add("labelTitel");
        hightOben.getStyleClass().add("labelKantoneHight");


        imageView   = new ImageView();
        imageView.setFitHeight(350);
        imageView.setFitWidth(350);
//        imageView.setPreserveRatio(true);
        glass        = new Circle(150, 150, 150);
        imageView.isSmooth();
        imageView.setClip(glass);


        nameLabel                   = new Label("Name");
        isolationLabel              = new Label("Dominanz");
        isolationPointLabel         = new Label("Km bis");
        typLabel                    = new Label("Typ");
        cantonLabel                 = new Label("Kantone");
        captionLabel                = new Label("Bildunterschrift");
        hightLabel                  = new Label("Höhe");
        prominanceLabel             = new Label("Scharten");
        prominancePointLabel        = new Label("m bis");
        regionLabel                 = new Label("Region");
        rangeLabel                  = new Label("Gebiet");

        nameTextfield               = new TextField();
        isolationTextfield          = new TextField();
        isolationPointfield         = new TextField();
        typTextfield                = new TextField();
        cantonTextfield             = new TextField();
        captionTextfield            = new TextField();
        hightTextfield              = new TextField();
        prominanceTextfield         = new TextField();
        prominancePointTextfield    = new TextField();
        regionTextfield             = new TextField();
        rangeTextfield              = new TextField();
    }

    public void layoutControls() {
        ColumnConstraints cc        = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc, cc);

        RowConstraints rc           = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc);

        add(nameOben, 0, 0, 3, 1); //colIndex, rowIndex, colSpan, rowSpan
        add(hightOben, 0, 1, 3, 1);
        add(regionOben, 0, 2, 3, 1);

        add(imageView, 2, 3, 3, 3);

        add(nameLabel, 0, 10);
        add(isolationLabel, 0, 11);
        add(isolationPointLabel, 0, 12);
        add(typLabel, 0, 13);
        add(cantonLabel, 0, 14);
        add(captionLabel, 0, 15);

        add(nameTextfield, 1, 10);
        add(isolationTextfield, 1, 11);
        add(isolationPointfield, 1, 12);
        add(typTextfield, 1, 13);
        add(cantonTextfield, 1, 14);
        add(captionTextfield, 1, 15, 4, 1);

        add(hightLabel, 2, 10);
        add(prominanceLabel, 2, 11);
        add(prominancePointLabel, 2, 12);
        add(regionLabel, 2, 13);
        add(rangeLabel, 2, 14);

        add(hightTextfield, 3, 10);
        add(prominanceTextfield, 3, 11);
        add(prominancePointTextfield, 3, 12);
        add(regionTextfield, 3, 13);
        add(rangeTextfield, 3, 14);

        setPadding((new Insets(5, 5, 5, 5)));
    }

    public void addBindings() {

    }

    public void addEventHandlers() {
        imageView.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                }
                event.consume();

            }
        });

        imageView.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
               /* data dropped */
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    for (File file : db.getFiles()) {
                        try {
                            String absolutePath = file.toURI().toURL().toString();
                            if (absolutePath.endsWith("png") || absolutePath.endsWith("jpg")) {
                                Image newImage = new Image(absolutePath);
                                imageView.setImage(newImage);
                                model.getSelectedMountain().setImageObjectProperty(newImage);
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Wrong Format");
                                alert.setHeaderText(null);
                                alert.setContentText("Only JPG or PNG allowed");
                                alert.showAndWait();
                            }
                        } catch (Exception exc) {
                            exc.getMessage();
                        }
                    }
                    event.setDropCompleted(true);
                } else {
                    event.setDropCompleted(false);
                }
                event.consume();
            }
        });

        imageView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BorderPane borderPane = new BorderPane();
                ImageView imageView = new ImageView();
                Image image = model.getSelectedMountain().imageObjectPropertyProperty().get();
                imageView.setImage(image);
                imageView.setStyle("-fx-background-color: BLACK");
                imageView.setPreserveRatio(true);
                imageView.setSmooth(true);
                imageView.setCache(true);
                borderPane.setCenter(imageView);
                borderPane.setStyle("-fx-background-color: BLACK");
                Stage newStage = new Stage();
                Scene scene = new Scene(borderPane, Color.BLACK);
                newStage.setScene(scene);
                newStage.show();
            }
        });


    }

//    public void mapInitialized() {
//        //Set the initial properties of the map.
//        mapOptions.center(new LatLong(47.6097, -122.3331))
//                .mapType(MapTypeIdEnum.TERRAIN)
//                .overviewMapControl(false)
//                .panControl(false)
//                .rotateControl(false)
//                .scaleControl(false)
//                .streetViewControl(false)
//                .zoomControl(false)
//                .zoom(12);
//
//        map = mapView.createMap(mapOptions);
//
//        //Add a marker to the map
//        MarkerOptions markerOptions = new MarkerOptions();
//
//        markerOptions.position( new LatLong(47.6, -122.3) )
//                .visible(Boolean.TRUE)
//                .title("My Marker");
//
//        Marker marker = new Marker( markerOptions );
//
//        map.addMarker(marker);
//
//    }

    public void addValueChangedListeners(){
        model.selectedMountainProperty().addListener((observableValue, oldSelection, newSelection) -> {
            // unbind von allen Properties auf oldSelection
            if(oldSelection != null){
                nameOben.textProperty().unbindBidirectional(oldSelection.nameProperty());
                hightOben.textProperty().unbindBidirectional(oldSelection.hightProperty());
                regionOben.textProperty().unbindBidirectional(oldSelection.regionProperty());

                nameTextfield.textProperty().unbindBidirectional(oldSelection.nameProperty());
                isolationTextfield.textProperty().unbindBidirectional(oldSelection.isolationProperty());
                isolationPointfield.textProperty().unbindBidirectional(oldSelection.isolationPointProperty());
                typTextfield.textProperty().unbindBidirectional(oldSelection.typProperty());
                cantonTextfield.textProperty().unbindBidirectional(oldSelection.cantonProperty());
                captionTextfield.textProperty().unbindBidirectional(oldSelection.captionProperty());
                hightTextfield.textProperty().unbindBidirectional(oldSelection.hightProperty());
                prominanceTextfield.textProperty().unbindBidirectional(oldSelection.prominenceProperty());
                prominancePointTextfield.textProperty().unbindBidirectional(oldSelection.prominencePointProperty());
                regionTextfield.textProperty().unbindBidirectional(oldSelection.regionProperty());
                rangeTextfield.textProperty().unbindBidirectional(oldSelection.rangeProperty());
            }

            //bind von allen Properties auf newSelection
            if(newSelection != null){
                nameOben.textProperty().bindBidirectional(newSelection.nameProperty());
                hightOben.textProperty().bindBidirectional(newSelection.hightProperty(), new NumberStringConverter(country));
                regionOben.textProperty().bindBidirectional(newSelection.regionProperty());

                nameTextfield.textProperty().bindBidirectional(newSelection.nameProperty());
                isolationTextfield.textProperty().bindBidirectional(newSelection.isolationProperty(), new NumberStringConverter(country));
                isolationPointfield.textProperty().bindBidirectional(newSelection.isolationPointProperty());
                typTextfield.textProperty().bindBidirectional(newSelection.typProperty());
                cantonTextfield.textProperty().bindBidirectional(newSelection.cantonProperty());
                captionTextfield.textProperty().bindBidirectional(newSelection.captionProperty());
                hightTextfield.textProperty().bindBidirectional(newSelection.hightProperty(), new NumberStringConverter());
                prominanceTextfield.textProperty().bindBidirectional(newSelection.prominenceProperty(), new NumberStringConverter(country));
                prominancePointTextfield.textProperty().bindBidirectional(newSelection.prominencePointProperty());
                regionTextfield.textProperty().bindBidirectional(newSelection.regionProperty());
                rangeTextfield.textProperty().bindBidirectional(newSelection.rangeProperty());

                imageView.setImage(newSelection.getImageObjectProperty());
            }

        });
    }
}
