/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author ener2
 */
public class EjemploDatePicker extends Application {

	private Stage stage;
	private DatePicker checkInDatePicker;
	private DatePicker checkOutDatePicker;

	@Override
	public void start(Stage stage) {
		// Se configura la region por defecto para la ejecucion de la aplicacion
		Locale.setDefault(Locale.US);

		this.stage = stage;
		this.stage.setTitle("Ejemplo DatePicker");
		// Se asigna icono a la ventana
		this.stage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		this.stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
		initUI();
		this.stage.show();
	}

	private void initUI() {
		VBox vbox = new VBox(20);
		vbox.setStyle("-fx-padding: 10;");
		Scene scene = new Scene(vbox, 400, 400);
		stage.setScene(scene);
		checkInDatePicker = new DatePicker();
		checkOutDatePicker = new DatePicker();
		checkInDatePicker.setValue(LocalDate.now());
		
		// Crea un rango de fechas para el datepicker en el cual se desactivan
		// los dias anteriores a la fecha seleccionada
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(checkInDatePicker.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
						long p = ChronoUnit.DAYS.between(checkInDatePicker.getValue(), item);
						setTooltip(new Tooltip("Se quedara por " + p + " dias"));
					}
				};
			}
		};
		checkOutDatePicker.setDayCellFactory(dayCellFactory);
		checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		Label checkInlabel = new Label("Check-In Date:");
		gridPane.add(checkInlabel, 0, 0);
		GridPane.setHalignment(checkInlabel, HPos.LEFT);
		gridPane.add(checkInDatePicker, 0, 1);
		Label checkOutlabel = new Label("Check-Out Date:");
		gridPane.add(checkOutlabel, 0, 2);
		GridPane.setHalignment(checkOutlabel, HPos.LEFT);
		gridPane.add(checkOutDatePicker, 0, 3);
		vbox.getChildren().add(gridPane);
	}
}
