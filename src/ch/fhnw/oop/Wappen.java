package ch.fhnw.oop;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by ANhi on 11/25/2015.
 */
public class Wappen extends ListCell<Wappen> {

//    private static final Insets INSETS =   ;
    ImageView imageview = new ImageView();

    public Wappen(){
        
    }

//    @Override
//    protected void updateItem(String item, boolean empty) {
//        setText("");
//        setGraphic(null);
//        if (!empty) {
//            Image img = WAPPEN.get(item);
//            if (img == null) {
//                img = new Image(getClass().getResource("wappen_klein/" + item + ".png")
//                        .toExternalForm(), 18, 18, true, true, true);
//                WAPPEN.put(item, img);
//            }
//
//            ImageView imageView = new ImageView(img);
//
//            setGraphic(imageView);
//            setTooltip(new Tooltip(item));
//            setAlignment(Pos.CENTER);
//            setPadding(INSETS);
//        }

    public ImageView getImageview() {
        return imageview;
    }
    public Wappen(ImageView imageView){
        this.imageview = imageView;
    }



}
