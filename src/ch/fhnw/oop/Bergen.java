package ch.fhnw.oop;

import javafx.beans.property.*;
import javafx.scene.control.ListCell;

/**
 * Created by ANhi on 11/21/2015.
 */
public class Bergen extends ListCell<Bergen> {

    private final IntegerProperty idBerg             = new SimpleIntegerProperty();
    private final StringProperty name               = new SimpleStringProperty();
    private final DoubleProperty hoehe              = new SimpleDoubleProperty();
    private final StringProperty dominanz           = new SimpleStringProperty();
    private final StringProperty scharten           = new SimpleStringProperty();
    private final StringProperty kmBis              = new SimpleStringProperty();
    private final StringProperty mBis               = new SimpleStringProperty();
    private final StringProperty typ                = new SimpleStringProperty();
    private final StringProperty region             = new SimpleStringProperty();
    private final StringProperty kantone            = new SimpleStringProperty();
    private final StringProperty gebiet             = new SimpleStringProperty();
    private final StringProperty bildunterschrieft  = new SimpleStringProperty();

    public Bergen(String[] line){
        setidBerg(Integer.parseInt(line[0]));
        setName(line[1]);
        setHoehe(Double.parseDouble(line[2]));
        setDominanz(line[3]);
        setScharten(line[4]);
        setKmBis(line[5]);
        setmBis(line[6]);
        setTyp(line[7]);
        setRegion(line[8]);
        setKantone(line[9]);
        setGebiet(line[10]);
        setBildunterschrieft(line[11]);
        System.out.println(getidBerg());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bergen resultat = (Bergen) o;

        return getidBerg()==(resultat.getidBerg());
    }

    @Override
    public int hashCode() {
        return idBerg.hashCode();
    }

    public String infoAsLine() {
        return String.join("\t",
                Integer.toString(getidBerg()),
                getName(),
                Double.toString(getHoehe()),
                getDominanz(),
                getScharten(),
                getKmBis(),
                getTyp(),
                getRegion(),
                getKantone(),
                getGebiet(),
                getBildunterschrieft()
        );
    }
    public int getidBerg() {
        return idBerg.get();
    }

    public IntegerProperty idBergProperty() {
        return idBerg;
    }

    public void setidBerg(int id) {
        this.idBerg.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getHoehe() {
        return hoehe.get();
    }

    public DoubleProperty hoeheProperty() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe.set(hoehe);
    }

    public String getDominanz() {
        return dominanz.get();
    }

    public StringProperty dominanzProperty() {
        return dominanz;
    }

    public void setDominanz(String dominanz) {
        this.dominanz.set(dominanz);
    }

    public String getScharten() {
        return scharten.get();
    }

    public StringProperty schartenProperty() {
        return scharten;
    }

    public void setScharten(String scharten) {
        this.scharten.set(scharten);
    }

    public String getKmBis() {
        return kmBis.get();
    }

    public StringProperty kmBisProperty() {
        return kmBis;
    }

    public void setKmBis(String kmBis) {
        this.kmBis.set(kmBis);
    }

    public String getmBis() {
        return mBis.get();
    }

    public StringProperty mBisProperty() {
        return mBis;
    }

    public void setmBis(String mBis) {
        this.mBis.set(mBis);
    }

    public String getTyp() {
        return typ.get();
    }

    public StringProperty typProperty() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ.set(typ);
    }

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getKantone() {
        return kantone.get();
    }

    public StringProperty kantoneProperty() {
        return kantone;
    }

    public void setKantone(String kantone) {
        this.kantone.set(kantone);
    }

    public String getGebiet() {
        return gebiet.get();
    }

    public StringProperty gebietProperty() {
        return gebiet;
    }

    public void setGebiet(String gebiet) {
        this.gebiet.set(gebiet);
    }

    public String getBildunterschrieft() {
        return bildunterschrieft.get();
    }

    public StringProperty bildunterschrieftProperty() {
        return bildunterschrieft;
    }

    public void setBildunterschrieft(String bildunterschrieft) {
        this.bildunterschrieft.set(bildunterschrieft);
    }

}
