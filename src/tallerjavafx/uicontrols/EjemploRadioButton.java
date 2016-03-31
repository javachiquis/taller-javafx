/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploRadioButton extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Creacion de un grupo de botones de opcion
        final ToggleGroup group = new ToggleGroup();
        
        //Un boton de radio con una cadena vacia para su etiqueta
        RadioButton rb1 = new RadioButton();
        //Configuracion de una etiqueta de texto
        rb1.setText("Casa");
        rb1.setUserData("casa");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        
        //Un boton de radio con la etiqueta especificada
        RadioButton rb2 = new RadioButton("Calendario");
        rb2.setUserData("calendario");
        rb2.setToggleGroup(group);

        RadioButton rb3 = new RadioButton("Contactos");
        rb3.setUserData("agenda");
        rb3.setToggleGroup(group);
        
        ImageView imageView = new ImageView();
        
        group.selectedToggleProperty().addListener(
            (ObservableValue<? extends Toggle> ov, Toggle old_toggle,
                    Toggle new_toggle) -> {
                if (group.getSelectedToggle() != null) {
                    final Image image = new Image(
                            getClass().getResourceAsStream("/recursos/img/"+
                                    group.getSelectedToggle().getUserData().toString()
                                    + ".png"));
                    imageView.setImage(image);
                }
            });
        
        VBox root = new VBox();
        root.getChildren().add(rb1);
        root.getChildren().add(rb2);
        root.getChildren().add(rb3);
        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 200, 150);

        primaryStage.setTitle("Ejemplo RadioButton");
        primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
