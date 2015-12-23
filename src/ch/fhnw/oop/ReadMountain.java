package ch.fhnw.oop;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ANhi on 11/27/2015.
 */
public class ReadMountain {

    private static final String TAB = ";";
    private static int laufNummer;
    private static int laufNummerID;

    private final StringProperty windowTitle                = new SimpleStringProperty("Mountain CH");
    private static final String FILE_NAME                   = "mountains.csv";

    private final ObservableList<Mountain> listBergen       = FXCollections.observableArrayList();
    private final ObjectProperty<Mountain> selectedMountain = new SimpleObjectProperty<>();

    private final FilteredList<Mountain> filteredData       = new FilteredList<>(listBergen);  // kann nur filtern

    private final ObservableList<Command> undoStack         = FXCollections.observableArrayList();
    private final ObservableList<Command> redoStack         = FXCollections.observableArrayList();

    private final BooleanProperty undoDisabled              = new SimpleBooleanProperty();
    private final BooleanProperty redoDisabled              = new SimpleBooleanProperty();

    private final Mountain mountainProxy                    = new Mountain();

//    private final IntegerProperty selectedMountainId        = new SimpleIntegerProperty(-1); Redundant

    public ReadMountain() {
        listBergen.addAll(readFromFile());

        laufNummer = listBergen.size();
        laufNummerID = listBergen.size();

        undoDisabled.bind(Bindings.isEmpty(undoStack));
        redoDisabled.bind(Bindings.isEmpty(redoStack));

        selectedMountainProperty().addListener((observable, oldSelection, newSelection) -> {
//                    Mountain oldSelection = getCountry((int) oldValue);
//                    Mountain newSelection = getCountry((int) newValue);

                    if (oldSelection != null) {
                        unbindFromProxy(oldSelection);
                        disableUndoSupport(oldSelection);
                    }

                    if (newSelection != null) {
                        bindToProxy(newSelection);
                        enableUndoSupport(newSelection);
                    }
                }
        );

        selectedMountainProperty().addListener(propertyChangeListenerForUndoSupport);
    }

    private final ChangeListener propertyChangeListenerForUndoSupport = (observable, oldValue, newValue) -> {
        redoStack.clear();
        undoStack.add(0, new ValueChangeCommand(ReadMountain.this, (Property) observable, oldValue, newValue));
    };

    public <T> void setPropertyValueWithoutUndoSupport(Property<T> property, T newValue) {
        property.removeListener(propertyChangeListenerForUndoSupport);
        property.setValue(newValue);
        property.addListener(propertyChangeListenerForUndoSupport);
    }

    private void bindToProxy(Mountain country) {
        mountainProxy.idBergProperty().bindBidirectional(country.idBergProperty());
        mountainProxy.nameProperty().bindBidirectional(country.nameProperty());
        mountainProxy.hightProperty().bindBidirectional(country.hightProperty());
        mountainProxy.regionProperty().bindBidirectional(country.regionProperty());
        mountainProxy.cantonProperty().bindBidirectional(country.cantonProperty());
        mountainProxy.rangeProperty().bindBidirectional(country.rangeProperty());
        mountainProxy.isolationProperty().bindBidirectional(country.isolationProperty());
        mountainProxy.isolationPointProperty().bindBidirectional(country.isolationPointProperty());
        mountainProxy.prominenceProperty().bindBidirectional(country.prominenceProperty());
        mountainProxy.prominencePointProperty().bindBidirectional(country.prominencePointProperty());
        mountainProxy.captionProperty().bindBidirectional(country.captionProperty());
    }

    private void unbindFromProxy(Mountain country) {

        mountainProxy.idBergProperty().unbindBidirectional(country.idBergProperty());
        mountainProxy.nameProperty().unbindBidirectional(country.nameProperty());
        mountainProxy.hightProperty().unbindBidirectional(country.hightProperty());
        mountainProxy.regionProperty().unbindBidirectional(country.regionProperty());
        mountainProxy.cantonProperty().unbindBidirectional(country.cantonProperty());
        mountainProxy.rangeProperty().unbindBidirectional(country.rangeProperty());
        mountainProxy.isolationProperty().unbindBidirectional(country.isolationProperty());
        mountainProxy.isolationPointProperty().unbindBidirectional(country.isolationPointProperty());
        mountainProxy.prominenceProperty().unbindBidirectional(country.prominenceProperty());
        mountainProxy.prominencePointProperty().unbindBidirectional(country.prominencePointProperty());
        mountainProxy.captionProperty().unbindBidirectional(country.captionProperty());
    }

    private void disableUndoSupport(Mountain country) {
        country.idBergProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.nameProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.hightProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.regionProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.cantonProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.rangeProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.isolationProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.isolationPointProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.prominenceProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.prominencePointProperty().removeListener(propertyChangeListenerForUndoSupport);
        country.captionProperty().removeListener(propertyChangeListenerForUndoSupport);
    }

    private void enableUndoSupport(Mountain country) {
        country.idBergProperty().addListener(propertyChangeListenerForUndoSupport);
        country.nameProperty().addListener(propertyChangeListenerForUndoSupport);
        country.hightProperty().addListener(propertyChangeListenerForUndoSupport);
        country.regionProperty().addListener(propertyChangeListenerForUndoSupport);
        country.cantonProperty().addListener(propertyChangeListenerForUndoSupport);
        country.rangeProperty().addListener(propertyChangeListenerForUndoSupport);
        country.isolationProperty().addListener(propertyChangeListenerForUndoSupport);
        country.isolationPointProperty().addListener(propertyChangeListenerForUndoSupport);
        country.prominenceProperty().addListener(propertyChangeListenerForUndoSupport);
        country.prominencePointProperty().addListener(propertyChangeListenerForUndoSupport);
        country.captionProperty().addListener(propertyChangeListenerForUndoSupport);
    }

    private Mountain getCountry(int id) {
        Optional<Mountain> pmOptional = listBergen.stream()
                .filter(mountain -> mountain.getIdBerg() == id)
                .findAny();
        return pmOptional.isPresent() ? pmOptional.get() : null;
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            return;
        }
        Command cmd = undoStack.get(0);
        undoStack.remove(0);
        redoStack.add(0, cmd);

        cmd.undo();
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            return;
        }
        Command cmd = redoStack.get(0);
        redoStack.remove(0);
        undoStack.add(0, cmd);

        cmd.redo();
    }

    public void remove() {

        laufNummer--;
        listBergen.remove(getSelectedMountain());
    }

    public void add() {
        redoStack.clear();
        Mountain addMountain = new Mountain();
        addMountain.setIdBerg(laufNummerID++);
        addMountain.setName("");
        listBergen.add(laufNummer, addMountain);
        setSelectedMountain(addMountain);

    }

    public void setFilterString(String newValue) {
        filteredData.setPredicate(mountain -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if (mountain.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else {
                return false;
            }
        });
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

    private Path getPath(String fileName, boolean locatedInSameFolder) {
        try {
            if (!locatedInSameFolder) {
                fileName = "/" + fileName;
            }
            return Paths.get(getClass().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public Mountain getMountainProxy() {
        return mountainProxy;
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

    public FilteredList<Mountain> getFilteredData() {

        return filteredData;
    }

    public boolean getRedoDisabled() {
        return redoDisabled.get();
    }

    public BooleanProperty redoDisabledProperty() {
        return redoDisabled;
    }

    public void setRedoDisabled(boolean redoDisabled) {
        this.redoDisabled.set(redoDisabled);
    }

    public boolean getUndoDisabled() {
        return undoDisabled.get();
    }

    public BooleanProperty undoDisabledProperty() {
        return undoDisabled;
    }

    public void setUndoDisabled(boolean undoDisabled) {
        this.undoDisabled.set(undoDisabled);
    }
}
