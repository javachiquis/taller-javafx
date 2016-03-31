/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploPasswordField extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Digite contraseña");
        
        final Label message = new Label("");

        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 0, 0, 10));
        vb.setSpacing(10);
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label("Password");

        passwordField.setOnAction((ActionEvent e) -> {
            if (!passwordField.getText().equals("soymuyguapo")) {
                message.setText("Contrasena incorrecta!");
                message.setTextFill(Color.rgb(210, 39, 30));
            } else {
                message.setText("Contrasena confirmada");
                message.setTextFill(Color.rgb(21, 117, 84));
            }
            passwordField.clear();
        });

        hb.getChildren().addAll(label, passwordField);
        vb.getChildren().addAll(hb, message);
        
        Scene scene = new Scene(vb, 300, 150);

        primaryStage.setTitle("Ejemplo Password Field");
        primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
