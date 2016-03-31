/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploScrollPane extends Application {

    final ScrollPane sp = new ScrollPane();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    final Label fileName = new Label();
    final String [] imageNames = new String [] {"imagen1.jpg", "imagen2.jpg",
        "imagen3.jpg", "imagen4.jpg", "imagen5.jpg"};
    @Override
    public void start(Stage primaryStage) throws Exception {
     
        //El uso de un panel de desplazamiento para ver una imagen
        Image bebe = new Image(getClass().getResourceAsStream("/recursos/img/imagen.jpg"));
        ScrollPane sp = new ScrollPane();
        sp.setContent(new ImageView(bebe));
        
        //Ajuste de las Politicas horizontal y vertical de la barra de desplazamiento
        sp.setHbarPolicy(ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
        
        //El uso de un panel de desplazamiento para visualizar imagenes
        
        VBox box = new VBox();
        Scene scene = new Scene(box, 180, 180);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scroll Pane");
        primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL);
        box.getChildren().addAll(sp, fileName);
        VBox.setVgrow(sp, Priority.ALWAYS);
 
        fileName.setLayoutX(30);
        fileName.setLayoutY(160);
 
        for (int i = 0; i < 5; i++) {
            images[i] = new Image(getClass().getResourceAsStream("/recursos/img/" + imageNames[i]));
            pics[i] = new ImageView(images[i]);
            pics[i].setFitWidth(100);
            pics[i].setPreserveRatio(true);
            vb.getChildren().add(pics[i]);
        }
 
        sp.setVmax(440);
        sp.setPrefSize(115, 150);
        sp.setContent(vb);
        sp.vvalueProperty().addListener((ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) -> {
                fileName.setText(imageNames[(new_val.intValue() - 1)/100]);
        });
        primaryStage.show();
        
        }
}