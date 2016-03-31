/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploCheckBox extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Creamos un checkbox vacio y le asignamos el texto con el metodo setText
        CheckBox cb1 = new CheckBox();
        cb1.setText("Seguridad");
        
        //Creamos un checkbox con el nombre en el constructor
        CheckBox cb2 = new CheckBox("Proyecto");
        
        //Creamos un checkbox con el nombre en el constructor
        CheckBox cb3 = new CheckBox("Grafica");
        
        // Se crea un array con los nombres de las imagenes que se van a agregar
        final String[] names = new String[]{"seg", "folder", "chart"};
        /* Se crea un array que va a contener las imagenes
         * El tamano sera el mismo que la cantidad de nombres de imagenes */
        final Image[] images = new Image[names.length];
		/*Se crea el array que va a contener las vistas de las imagenes que
		 * seran mostradas en pantalla */
        final ImageView[] icons = new ImageView[names.length];
        
        // Arreglo que contiene los checkbox
        final CheckBox[] cbs = {cb1, cb2, cb3};

        /* Se recorre el array de nombres y por cada uno se agrega la imagen correspondiente
         * y se incluye en los componentes Image e ImageView
         * 
         * Luego se agrega la accion a cada uno de los checkbox con el metodo
         * selectedProperty().addListener
         * 
         */
        for (int i = 0; i < names.length; i++) {
            final Image image = images[i]
                    = new Image(getClass().getResourceAsStream("/recursos/img/" + names[i] + ".png"));
            final ImageView icon = icons[i] = new ImageView();
//            final CheckBox cb = cbs[i] = new CheckBox(names[i]);
            final CheckBox cb = cbs[i];
            cb.selectedProperty().addListener(
                    (ObservableValue<? extends Boolean> ov,
                            Boolean old_val, Boolean new_val) -> {
                        icon.setImage(new_val ? image : null);
                    });
        }
        
        // Panel que contiene las imagenes
        HBox iconsBox = new HBox();
        iconsBox.getChildren().addAll(icons);
        
        // Panel que contiene los compoenentes CheckBox
        GridPane root = new GridPane();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setMinSize(300, 300);
		root.setVgap(5);
		root.setHgap(5);
        
		root.add(cb1, 0, 1);
		root.add(cb2, 0, 2);
		root.add(cb3, 0, 3);
		root.add(iconsBox, 1, 2); // Se agrega el panel de imagenes al panel principal
        
        Scene scene = new Scene(root, 300, 200);
        
        primaryStage.setTitle("Ejemplo Checkbox");
        primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}