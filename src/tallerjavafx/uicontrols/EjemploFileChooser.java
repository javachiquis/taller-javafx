/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploFileChooser  extends Application  {
    
    private final Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(Stage stage) {
        
        
        stage.setTitle("Ejemplo File Chooser");
        stage.getIcons().add(new Image("/recursos/img/java_icon.png")); // Se asigna icono a la ventana
        stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
 
        final FileChooser fileChooser = new FileChooser();
        final Button openButton = new Button("Abrir Imagen...");
        final Button openMultipleButton = new Button("Abrir Varias Imagenes...");     
        
        // Se asigna el evento al boton para seleccionar solo una imagen
        openButton.setOnAction(
            (final ActionEvent e) -> {
                configureFileChooser(fileChooser);
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    openFile(file);
                }
        });
        
        // Se asigna el evento al boton para seleccionar varias imagenes
        openMultipleButton.setOnAction(
            (final ActionEvent e) -> {
                configureFileChooser(fileChooser);
                List<File> list = 
                        fileChooser.showOpenMultipleDialog(stage);
                if (list != null) {
                    list.stream().forEach((file) -> {
                        openFile(file);
                    });
                }
        });
 
        final GridPane inputGridPane = new GridPane();
 
        // Se configuran los indices de filas y columnas
        //por componenete para ubicarlos en el panel
        GridPane.setConstraints(openButton, 0, 1);
        GridPane.setConstraints(openMultipleButton, 1, 1);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton, openMultipleButton);
        
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        stage.setScene(new Scene(rootGroup));
        stage.show();
      }
 
    /**
     * Se configuran opciones iniciales del selector de archivos del sistema
     */
    private static void configureFileChooser(
        final FileChooser fileChooser) {      
            fileChooser.setTitle("Seleccionar Imagenes...");
            fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
            );                 
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos los tipos de archivos", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
    }
    
 
    /**
     * Metodo encargado de abrir el archivo seleccionado
     * con la aplicacion asociada por defecto
     */
    private void openFile(File file) {
        EventQueue.invokeLater(() -> {
            try {
                desktop.open(file);
            } catch (IOException ex) {
            	//No hay ninguna aplicacion asociada con el archivo especificado
                Logger.getLogger(EjemploFileChooser.
                        class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        });
    }
}
