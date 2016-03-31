/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploToggleButton extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

//        //Un boton de activacion sin ningun titulo o icono
//        ToggleButton tb1 = new ToggleButton();
//        tb1.setTranslateX(-200);
//        tb1.setTranslateY(-200);
//        //Un boton de activacion con una leyenda de texto
//        ToggleButton tb2 = new ToggleButton("Presionarme");
//        tb2.setTranslateX(-100);
//        tb2.setTranslateY(-100);
//        //Un boton de activacion con una leyenda de texto y un icono
//        Image image = new Image(getClass().getResourceAsStream("/recursos/imagen.jpg"));
//        ToggleButton tb3 = new ToggleButton("Presionarme", new ImageView(image));
//        tb3.setTranslateX(200);
//        tb3.setTranslateY(200);

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add("/recursos/css/estilos.css");

        //La combinacion de botones de alternancia en un Grupo
        final ToggleGroup group = new ToggleGroup();

        ToggleButton tb1 = new ToggleButton("Menor");
        tb1.setToggleGroup(group);
        tb1.setSelected(true);
        tb1.getStyleClass().add("toggle-button1");
        tb1.setTranslateX(-50);
        tb1.setTranslateY(-63);

        ToggleButton tb2 = new ToggleButton("Mayor");
        tb2.setToggleGroup(group);
        tb2.getStyleClass().add("toggle-button2");
        tb2.setTranslateX(0);
        tb2.setTranslateY(-63);

        ToggleButton tb3 = new ToggleButton("Critico");
        tb3.setToggleGroup(group);
        tb3.getStyleClass().add("toggle-button3");
        tb3.setTranslateX(50);
        tb3.setTranslateY(-63);

        tb1.setUserData(Color.LIGHTGREEN);
        tb2.setUserData(Color.LIGHTBLUE);
        tb3.setUserData(Color.SALMON);
        
        Rectangle rect = new Rectangle();
        rect.setHeight(100);
        rect.setWidth(155);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.DARKGRAY);
        rect.setStrokeWidth(1);
        rect.setArcHeight(10);
        rect.setArcWidth(20);

        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
            if (new_toggle == null) {
                rect.setFill(Color.WHITE);
            } else {
                rect.setFill((Color) group.getSelectedToggle().getUserData());
            }
        });
        
        root.getChildren().add(tb1);
        root.getChildren().add(tb2);
        root.getChildren().add(tb3);
        root.getChildren().add(rect);

        primaryStage.setTitle("Ejemplo ToggleButton");
        primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
