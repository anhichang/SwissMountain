package ch.fhnw.oop;

/**
 * @author Dieter Holz
 */
public interface ViewMixin<T> {

	T getPresentationModel();

	default void init() {
		initializeControls();
		layoutControls();
		addEventHandlers();
		addValueChangedListeners();
		addBindings();
	}

	void initializeControls();

	void layoutControls();

	default void addEventHandlers() {
	}

	default void addValueChangedListeners() {
	}

	default void addBindings() {
	}
}
