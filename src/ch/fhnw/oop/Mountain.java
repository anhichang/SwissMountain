package ch.fhnw.oop;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ANhi on 11/21/2015.
 */
public class Mountain {

    private static final String FILE_NAME = "mountains.csv";

    private static final String TAB = ";";

    private final StringProperty applicationTitle = new SimpleStringProperty("Bergen");

    private final ObservableList<Bergen> hello = FXCollections.observableArrayList();

    public Mountain() {
        hello.addAll(readFromFile());
    }

    public void save() {
        try (BufferedWriter writer = Files.newBufferedWriter(getPath(FILE_NAME, true))) {
            writer.write("ID\tName\tGebiet\tKantone\tkmBis\tDominanz\tmBis\tScherten\tName\tKantone\tGebiet\tBilbeschreibung");
            writer.newLine();
            hello.stream().forEach(resultat -> {
                try {
                    writer.write(resultat.infoAsLine());
                    writer.newLine();
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            });
        } catch (IOException e) {
            throw new IllegalStateException("save failed");
        }
    }

    private List<Bergen> readFromFile() {
        try (Stream<String> stream = getStreamOfLines(FILE_NAME)) {
            return stream.skip(0)                              // erste Zeile ist die Headerzeile; ueberspringen
                    .map(s -> new Bergen(s.split(TAB))) // aus jeder Zeile ein Objekt machen
                    .collect(Collectors.toList());        // alles aufsammeln
        }
    }

    private Stream<String> getStreamOfLines(String fileName) {
        try {
            return Files.lines(getPath(fileName, true), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Path getPath(String fileName, boolean locatedInSameFolder)  {
        try {
            if(!locatedInSameFolder) {
                fileName = "/" + fileName;
            }
            return Paths.get(getClass().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public ObservableList<Bergen> getResulate() {
        return hello;
    }

}
