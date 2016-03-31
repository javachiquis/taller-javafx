/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploColorPicker extends Application {

	ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/recursos/img/Oracle.png"))

	);

	@Override
	public void start(Stage stage) {
		stage.setTitle("ColorPicker");
		stage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
		
		Scene scene = new Scene(new VBox(10), 300, 300);
		scene.getStylesheets().add("/recursos/css/estilos.css");
		VBox box = (VBox) scene.getRoot();

		ToolBar tb = new ToolBar();
		box.getChildren().add(tb);

		final ComboBox logoSamples = new ComboBox();
		logoSamples.getItems().addAll("Oracle", "Java", "JavaFX", "Cup");
		logoSamples.setValue("Oracle");

		logoSamples.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				logo.setImage(new Image(getClass().getResourceAsStream("/recursos/img/" + t1 + ".png")));
			}
		});
		final ColorPicker colorPicker = new ColorPicker();
		tb.getItems().addAll(logoSamples, colorPicker);

		StackPane stack = new StackPane();
		box.getChildren().add(stack);

		final SVGPath svg = new SVGPath();
		svg.setContent("M70,50 L90,50 L120,90 L150,50 L170,50"
				+ "L210,90 L180,120 L170,110 L170,200 L70,200 L70,110 L60,120 L30,90" + "L70,50");
		svg.setStroke(Color.DARKGREY);
		svg.setStrokeWidth(2);
		svg.setEffect(new DropShadow());
		svg.setFill(colorPicker.getValue());
		stack.getChildren().addAll(svg, logo);

		colorPicker.setOnAction((ActionEvent t) -> {
			svg.setFill(colorPicker.getValue());
		});

		stage.setScene(scene);
		stage.show();
	}

}
