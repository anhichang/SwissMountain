package ch.fhnw.oop;

import javafx.beans.property.*;

/**
 * Created by ANhi on 11/21/2015.
 */
public class Mountain {
    private final IntegerProperty idBerg            = new SimpleIntegerProperty();
    private final StringProperty name               = new SimpleStringProperty();
    private final DoubleProperty hight              = new SimpleDoubleProperty();
    private final StringProperty typ                = new SimpleStringProperty();
    private final StringProperty region             = new SimpleStringProperty();
    private final StringProperty canton             = new SimpleStringProperty();
    private final StringProperty range              = new SimpleStringProperty();
    private final DoubleProperty isolation          = new SimpleDoubleProperty();
    private final StringProperty isolationPoint     = new SimpleStringProperty();
    private final DoubleProperty prominence         = new SimpleDoubleProperty();
    private final StringProperty prominencePoint    = new SimpleStringProperty();
    private final StringProperty caption            = new SimpleStringProperty();
    private final StringProperty bilderBergen       = new SimpleStringProperty();

    public Mountain(String[] line){
        setIdBerg(Integer.parseInt(line[0]));
        setName(line[1]);
        setHight(Double.parseDouble(line[2]));
        setTyp(line[3]);
        setRegion(line[4]);
        setCanton(line[5]);
        setRange(line[6]);
        setIsolation(Double.parseDouble(line[7]));
        setIsolationPoint(line[8]);
        setProminence(Double.parseDouble(line[9]));
        setProminencePoint(line[10]);
        setCaption(line[11]);
        setBilderBergen(line[12]);
    }
    public Mountain(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mountain resultat = (Mountain) o;

        return getIdBerg()==(resultat.getIdBerg());
    }

    @Override
    public int hashCode() {
        return idBerg.hashCode();
    }

    public String infoAsLine() {
        return String.join(";",
                Integer.toString(getIdBerg()),
                getName(),
                Double.toString(getHight()),
                getTyp(),
                getRegion(),
                getCanton(),
                getRange(),
                Double.toString(getIsolation()),
                getIsolationPoint(),
                Double.toString(getProminence()),
                getProminencePoint(),
                getCaption(),
                getBilderBergen()
        );
    }


    public int getIdBerg() {
        return idBerg.get();
    }

    public IntegerProperty idBergProperty() {
        return idBerg;
    }

    public void setIdBerg(int idBerg) {
        this.idBerg.set(idBerg);
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

    public double getHight() {
        return hight.get();
    }

    public DoubleProperty hightProperty() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight.set(hight);
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

    public String getCanton() {
        return canton.get();
    }

    public StringProperty cantonProperty() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton.set(canton);
    }

    public String getRange() {
        return range.get();
    }

    public StringProperty rangeProperty() {
        return range;
    }

    public void setRange(String range) {
        this.range.set(range);
    }

    public double getIsolation() {
        return isolation.get();
    }

    public DoubleProperty isolationProperty() {
        return isolation;
    }

    public void setIsolation(double isolation) {
        this.isolation.set(isolation);
    }

    public String getIsolationPoint() {
        return isolationPoint.get();
    }

    public StringProperty isolationPointProperty() {
        return isolationPoint;
    }

    public void setIsolationPoint(String isolationPoint) {
        this.isolationPoint.set(isolationPoint);
    }

    public double getProminence() {
        return prominence.get();
    }

    public DoubleProperty prominenceProperty() {
        return prominence;
    }

    public void setProminence(double prominence) {
        this.prominence.set(prominence);
    }

    public String getProminencePoint() {
        return prominencePoint.get();
    }

    public StringProperty prominencePointProperty() {
        return prominencePoint;
    }

    public void setProminencePoint(String prominencePoint) {
        this.prominencePoint.set(prominencePoint);
    }

    public String getCaption() {
        return caption.get();
    }

    public StringProperty captionProperty() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption.set(caption);
    }

    public String getBilderBergen() {
        return bilderBergen.get();
    }

    public StringProperty bilderBergenProperty() {
        return bilderBergen;
    }

    public void setBilderBergen(String bilderBergen) {
        this.bilderBergen.set(bilderBergen);
    }
}
