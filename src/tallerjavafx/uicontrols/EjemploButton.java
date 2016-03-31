/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploButton extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Boton con texto
		Button button1 = new Button("Aceptar");
		Button button2 = new Button("Cancelar");

		// Botones con Imagen
		Image imageOk = new Image(getClass().getResourceAsStream("/recursos/img/ok.png"));
		Button button3 = new Button("Imagen", new ImageView(imageOk));

		Button button5 = new Button();
		button5.setGraphic(new ImageView(imageOk));

		Image imageError = new Image(getClass().getResourceAsStream("/recursos/img/error.png"));
		Button button6 = new Button();
		button6.setGraphic(new ImageView(imageError));

		// definiendo una accion para el boton
		Button button4 = new Button("Click");
		button4.setOnAction((ActionEvent e) -> {
			button4.setText("aceptado ");
		});

		// aplicamos la clase DropShadow effect
		DropShadow shadow = new DropShadow();
		// agregando el sombreado cuando el cursor del mouse este sobre el boton
		button4.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			button4.setEffect(shadow);
		});
		// removiendo el sombreado cuando el cursor del mouse se aleje
		button4.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			button4.setEffect(null);
		});

		// Se crea el panel donde se van a agregar los componentes para la vista
		GridPane root = new GridPane();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setMinSize(300, 300);
		root.setVgap(5);
		root.setHgap(5);

		// Indica el componente a agregar con columna y fila
		root.add(button1, 0, 0);
		root.add(button2, 1, 0);
		root.add(button3, 3, 0);
		root.add(button4, 0, 2);
		root.add(button5, 0, 1);
		root.add(button6, 1, 1);

		// Se crea la ventana con el panel que ya tiene los componentes
		Scene scene = new Scene(root, 300, 200);

		// Se inicia la ventana principal para ser mostrada
		primaryStage.setTitle("Ejemplo Button");
		primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png")); // Se asigna icono a la ventana
		primaryStage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
