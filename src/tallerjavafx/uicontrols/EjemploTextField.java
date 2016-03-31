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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploTextField extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Creando el campo de texto para mostrar el mensaje
        Label label1 = new Label("Nombre:");
        TextField textField = new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);

        //Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        //Definiendo el nombre en el campo de texto
        final TextField name = new TextField();
        name.setPromptText("Ingrese su primer nombre.");
        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);

        //Definiendo el ultimo nombre en el campo de texto
        final TextField lastName = new TextField();
        lastName.setPromptText("ingrese su apellido.");
        GridPane.setConstraints(lastName, 0, 1);
        grid.getChildren().add(lastName);

        //Definiendo el comentario en el campo de texto
        final TextField comment = new TextField();
        comment.setPromptText("Ingrese su comentario.");
        GridPane.setConstraints(comment, 0, 2);
        grid.getChildren().add(comment);

        //Definiendo el boton de envio
        Button submit = new Button("enviar");
        GridPane.setConstraints(submit, 1, 0);
        grid.getChildren().add(submit);

        //Definiendo el boton de limpiar
        Button clear = new Button("limpiar");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);

        //Adding a Label
        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

        submit.setOnAction((ActionEvent e) -> {
            if ((comment.getText() != null && !comment.getText().isEmpty())) {
                label.setText(name.getText() + " "
                        + lastName.getText() + ", "
                        + "gracias por su comentario!");
            } else {
                label.setText("no has dejado un comentario.");
            }
        });

        clear.setOnAction((ActionEvent e) -> {
            name.clear();
            lastName.clear();
            comment.clear();
            label.setText(null);
        });

        HBox root = new HBox();
        root.getChildren().add(grid);

        Scene scene = new Scene(root, 300, 150);

        primaryStage.setTitle("Ejemplo Text Field");
        primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
