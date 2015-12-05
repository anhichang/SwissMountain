package ch.fhnw.oop;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.converter.NumberStringConverter;

import java.util.Locale;

/**
 * Created by ANhi on 11/27/2015.
 */
public class EditorBergen extends GridPane {
   // private TableView<Mountain> tableView; VERBOTEN
    private ReadMountain model;
    private static Locale country;

    private ImageView image;
    private Image picture;

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

    public EditorBergen(ReadMountain model ) {
        this.model = model;
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();

    }

    private void initializeControls() {
        country     = new Locale("de", "DE");
        nameOben    = new Label();
        hightOben   = new Label();
        regionOben  = new Label();

        picture = new Image("0-1.jpg");
        image = new ImageView(picture);
        image.setFitHeight(350);
        image.setFitWidth(350);

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

    private void layoutControls() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc,cc,cc,cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc);

        setPadding(new Insets(5, 10, 10, 10));

        add(nameOben,0,0); //colIndex, rowIndex, colSpan, rowSpan
        add(hightOben,0,1);
        add(regionOben,0,2);

        add(image, 2,0, 2,4 );

        add(nameLabel,0,7);
        add(isolationLabel,0,8);
        add(isolationPointLabel,0,9);
        add(typLabel,0,10);
        add(cantonLabel,0,11);
        add(captionLabel,0,12);

        add(nameTextfield,1,7);
        add(isolationTextfield,1,8);
        add(isolationPointfield,1,9);
        add(typTextfield,1,10);
        add(cantonTextfield,1,11);
        add(captionTextfield,1,12,4,1);

        add(hightLabel,2,7);
        add(prominanceLabel,2,8);
        add(prominancePointLabel,2,9);
        add(regionLabel,2,10);
        add(rangeLabel,2,11);

        add(hightTextfield,3,7);
        add(prominanceTextfield,3,8);
        add(prominancePointTextfield,3,9);
        add(regionTextfield,3,10);
        add(rangeTextfield,3,11);
    }
    private void addBindings() {
    }

    public void addEventHandlers() {

//        observableList.addListener(new ListChangeListener() {
//            @Override
//            public void onChanged(ListChangeListener.Change change) {
//                System.out.println("change!");
//            }
//        });
    }

    public void addValueChangedListeners(){
        model.selectedMountainProperty().addListener((observableValue, oldSelection, newSelection) -> {
            // unbind von allen Properties auf oldSelection
            //bind von allen Properties auf newSelection
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
            }
        });
    }
    public void showImage(){

    }


}
