/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploChoiceBox extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //creando un menu de seleccion
        ChoiceBox cb = new ChoiceBox();
        cb.setItems(FXCollections.observableArrayList(
                "New Document", "Open ",
                new Separator(), "Save", "Save as"));

        // Declarando ChoiceBox
        final String[] saludos = new String[]{"HELLO", "HOLA", "HALLO", "BONJOUR", "CIAO", "OLA"};
        final ChoiceBox idiomas = new ChoiceBox(FXCollections.observableArrayList("INGLES", "ESPANOL", "ALEMAN", "FRANCES", "ITALIANO", "PORTUGUES"));
        idiomas.setTooltip(new Tooltip("Seleccione un idioma!"));
        Label label = new Label(saludos[0]);

        idiomas.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    label.setText(saludos[new_val.intValue()]);
                });

        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setMinSize(300, 300);
        root.setVgap(5);
        root.setHgap(5);

        // Indica el componente, columna y fila
        root.add(idiomas, 0, 0);
        root.add(label, 1, 0);

        Scene scene = new Scene(root, 300, 100);

        primaryStage.setTitle("Ejemplo Choicebox");
        primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
