package ch.fhnw.oop;

import javafx.beans.property.Property;

/**
 * @author Dieter Holz
 */
public class ValueChangeCommand<T> implements Command {
	private final ReadMountain    mountain;
	private final Property<T> property;
	private final T           oldValue;
	private final T           newValue;

	public ValueChangeCommand(ReadMountain mountain, Property<T> property, T oldValue, T newValue) {
		this.mountain = mountain;
		this.property = property;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public void undo() {
		mountain.setPropertyValueWithoutUndoSupport(property, oldValue);
	}

	public void redo() {
		mountain.setPropertyValueWithoutUndoSupport(property, newValue);
	}
}
