/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploLabel extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // una etiqueta vacia
        Label label1 = new Label();
        
        //una etiqueta con un elemento de texto 
        Label label2 = new Label("Etiqueta con fuente personalizada");
        label2.setFont(new Font("Arial",18));
        label2.setTranslateY(-200);
        
        // Se importa una imagen para agregarla en el label
        Image image = new Image(getClass().getResourceAsStream("/recursos/img/Cup.png"));
        Label label3 = new Label("Etiqueta con imagen y color", new ImageView(image));
        label3.setTextFill(Color.web("#0076a3"));
        label3.setTranslateY(-100);
        
        // una etiqueta con texto girado
        Label label4 = new Label("etiqueta con rotacion");
        label4.setScaleX(2);
        label4.setScaleY(2);
        label4.setRotate(270);
        label4.setTranslateX(-200);
        
        // Una etiqueta con una accion definida al pasar el mouse
        Label label5 = new Label("coloque el mouse para hacer zoom");
        label5.setOnMouseEntered((MouseEvent e) -> {
            label5.setScaleX(2.1);
            label5.setScaleY(2.1);
        });
        label5.setOnMouseExited((MouseEvent e) -> {
            label5.setScaleX(1);
            label5.setScaleY(1);
        });
                
        
        StackPane root = new StackPane();
        root.getChildren().add(0, label1);
        root.getChildren().add(1, label2);
        root.getChildren().add(2, label3);
        root.getChildren().add(3, label4);
        root.getChildren().add(4, label5);
        
        
        Scene scene = new Scene(root, 500, 350);
        
        primaryStage.setTitle("Ejemplo Label");
        primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
