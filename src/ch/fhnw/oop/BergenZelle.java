package ch.fhnw.oop;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by ANhi on 12/3/2015.
 */
class BergenZelle extends TableCell<Mountain, String> {
    private static final Map<String, Image> bergenMap = new HashMap<>();

    private static final Insets INSETS = new Insets(1, 8, 1, 5);

    @Override
    protected void updateItem(String item, boolean empty) {
        setText("");
        setGraphic(null);
        if (!empty) {
            Image img = bergenMap.get(item);
            if (img == null) {
                try {
                    img = new Image(getClass().getResource("res/wappen_klein/" + item + ".png")
                            .toExternalForm(), 18, 18, true, true, true);
                    bergenMap.put(item, img);
                }catch (NullPointerException e){
                    img = new Image(getClass().getResource("res/wappen_klein/" + "noPicture" + ".jpg")
                            .toExternalForm(), 18, 18, true, true, true);
                    bergenMap.put(item, img);
                }
            }

            ImageView imageView = new ImageView(img);

            setGraphic(imageView);
            setTooltip(new Tooltip(item));
            setAlignment(Pos.CENTER);
            setPadding(INSETS);
        }

    }

}