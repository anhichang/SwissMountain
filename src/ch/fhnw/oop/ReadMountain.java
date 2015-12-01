package ch.fhnw.oop;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
 * Created by ANhi on 11/27/2015.
 */
public class ReadMountain {

    private final StringProperty windowTitle        = new SimpleStringProperty("MountainApp");
    private static final String FILE_NAME           = "mountains.csv";
    private static final String TAB = ";";
//    private static final String FILE_NAME_OUT       = "mountainsout.csv"; wird im selben File gespeichert
    private static int laufNummer;

    private final ObservableList<Mountain> listBergen = FXCollections.observableArrayList();
    private final ObjectProperty<Mountain> selectedMountain = new SimpleObjectProperty<>();

    public ReadMountain(){
        listBergen.addAll(readFromFile());
        laufNummer = listBergen.size();
    }

    public void remove(){
        listBergen.remove(getSelectedMountain());
    }
    public void add(){
        String[] newMountain = new String[]{Integer.toString(laufNummer),"",Integer.toString(0),"","","","",Integer.toString(0),"",Integer.toString(0),"",""};
        Mountain mountainObject = new Mountain(newMountain);
        listBergen.add(laufNummer++,mountainObject);
        setSelectedMountain(mountainObject);
    }

    public void save() {
        try (BufferedWriter writer = Files.newBufferedWriter(getPath(FILE_NAME, true))) {
            writer.write("ID\tName\theight\tKantone\tkmBis\tDominanz\tkanton\tmBis\tScherten\tName\tKantone\tGebiet\tBilbeschreibung");
            writer.newLine();
            listBergen.stream().forEach(resultat -> {
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

    private List<Mountain> readFromFile() {
        try (Stream<String> stream = getStreamOfLines(FILE_NAME)) {
            return stream.skip(1)                              // erste Zeile ist die Headerzeile; ueberspringen
                    .map(s -> new Mountain(s.split(TAB))) // aus jeder Zeile ein Objekt machen
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

    public Mountain getSelectedMountain() {
        return selectedMountain.get();
    }

    public ObjectProperty<Mountain> selectedMountainProperty() {
        return selectedMountain;
    }

    public void setSelectedMountain(Mountain selectedMountain) {
        this.selectedMountain.set(selectedMountain);
    }



    public ObservableList<Mountain> getListBergen() {
        return listBergen;
    }

    public String getWindowTitle() {
        return windowTitle.get();
    }

    public StringProperty windowTitleProperty() {
        return windowTitle;
    }
}
