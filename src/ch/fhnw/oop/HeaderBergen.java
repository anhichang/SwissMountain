package ch.fhnw.oop;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

/**
 * Created by ANhi on 11/27/2015.
 */
public class HeaderBergen extends GridPane {
    Button speichern;
    Button add;
    Button loeschen;
    Button zurueck;
    Button vorwaerts;

    TextField suche;

    public HeaderBergen(){
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        speichern   = new Button("sp");
        add         = new Button("add");
        loeschen    = new Button("loe");
        zurueck     = new Button("zur");
        vorwaerts   = new Button("vor");
        suche       = new TextField("Suche");
    }

    private void layoutControls(){
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc,cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc);

        HBox hBoRleft = new HBox();
        HBox hBoxRight = new HBox();

        hBoRleft.getChildren().addAll(speichern,add,loeschen, zurueck, vorwaerts);
        hBoRleft.setPadding(new Insets(10, 5, 5, 10));
        hBoRleft.setSpacing(5);

        hBoxRight.getChildren().add(suche);
        hBoxRight.setAlignment(Pos.BASELINE_RIGHT);
        hBoxRight.setPadding(new Insets(10, 10, 5, 10));

        add(hBoRleft,0,0);
        add(hBoxRight,1,0);

    }


}
