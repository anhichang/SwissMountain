package ch.fhnw.oop;
import javafx.scene.control.TextField;
import java.awt.*;

/**
 * Created by ANhi on 11/26/2015.
 */
public class NumberTextField extends TextField {

    @Override public void replaceText(int start, int end, String text) {
        if (text.matches("[0-9]") || text == "") {
            super.replaceText(start, end, text);
        }
    }

    @Override public void replaceSelection(String text) {
        if (text.matches("[0-9]") || text == "") {
            super.replaceSelection(text);
        }
    }

}
