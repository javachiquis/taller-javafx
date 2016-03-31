/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author ener2
 */
public class EjemploComboBox extends Application {

    final Button button = new Button("Enviar");
    final Label notification = new Label();
    final TextField subject = new TextField("");
    final TextArea text = new TextArea("");

    String address = " ";

    @Override
    public void start(Stage stage) {
        stage.setTitle("Ejemplo Combo Box");
        stage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
		
        Scene scene = new Scene(new Group(), 500, 270);

        final ComboBox emailComboBox = new ComboBox();
        emailComboBox.getItems().addAll(
                "jacob.smith@example.com",
                "isabella.johnson@example.com",
                "ethan.williams@example.com",
                "emma.jones@example.com",
                "michael.brown@example.com"
        );

        emailComboBox.setPromptText("Correo Electronico");
        emailComboBox.setEditable(true);
        emailComboBox.setOnAction((Event ev) -> {
            address = emailComboBox.getSelectionModel().getSelectedItem().toString();
        });

        final ComboBox priorityComboBox = new ComboBox();
        priorityComboBox.getItems().addAll(
                "Muy Alta",
                "Alta",
                "Normal",
                "Baja",
                "Muy Baja"
        );

        priorityComboBox.setValue("Normal");
        priorityComboBox.setCellFactory(
                new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                final ListCell<String> cell = new ListCell<String>() {
                    {
                        super.setPrefWidth(100);
                    }

                    @Override
                    public void updateItem(String item,
                            boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            if (item.contains("Alta")) {
                                setTextFill(Color.RED);
                            } else if (item.contains("Baja")) {
                                setTextFill(Color.GREEN);
                            } else {
                                setTextFill(Color.BLACK);
                            }
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });

        button.setOnAction((ActionEvent e) -> {
            if (emailComboBox.getValue() != null
                    && !emailComboBox.getValue().toString().isEmpty()) {
            	
                if (text != null && !text.getText().isEmpty()) {
					notification.setText("Tu mensaje fue enviado correctamente a " + address);
					emailComboBox.setValue("");
					if (priorityComboBox.getValue() != null && !priorityComboBox.getValue().toString().isEmpty()) {
						priorityComboBox.setValue(null);
					}
					subject.clear();
					text.clear();
				} else {
					notification.setText("No hay mensaje para enviar!");
				}
                
            } else {
                notification.setText("No has seleccionado un destinatario!");
            }
        });

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Para: "), 0, 0);
        grid.add(emailComboBox, 1, 0);
        grid.add(new Label("Prioridad: "), 2, 0);
        grid.add(priorityComboBox, 3, 0);
        grid.add(new Label("Asunto: "), 0, 1);
        grid.add(subject, 1, 1, 3, 1);
        grid.add(text, 0, 2, 4, 1);
        grid.add(button, 0, 3);
        grid.add(notification, 1, 3, 3, 1);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();

    }

}
