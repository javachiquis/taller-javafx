/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploHyperLink extends Application {
    
      final static String[] imageFiles = new String[]{
        "/recursos/img/Producto.png",
        "/recursos/img/educacion.png",
        "/recursos/img/partners.png",
        "/recursos/img/support.png"
    };
    final static String[] captions = new String[]{
        "Products",
        "Education",
        "Partners",
        "Support"
    };
 
    final static String[] urls = new String[]{
        "http://www.oracle.com/us/products/index.html",
        "http://education.oracle.com/",
        "http://www.oracle.com/partners/index.html",
        "http://www.oracle.com/us/support/index.html"
    };
    
    final ImageView selectedImage = new ImageView();
    final Hyperlink[] hpls = new Hyperlink[captions.length];
    final Image[] images = new Image[imageFiles.length];   
 

    @Override
    public void start(Stage stage)  {
        
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);
        stage.setTitle("Ejemplo Hyperlink");
        stage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		stage.initModality(Modality.APPLICATION_MODAL);
        stage.setWidth(570);
        stage.setHeight(550);
 
        selectedImage.setLayoutX(100);
        selectedImage.setLayoutY(10);
        
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
 
        for (int i = 0; i < captions.length; i++) {
            final Hyperlink hpl = hpls[i] = new Hyperlink(captions[i]);
            final Image image = images[i] =
                new Image(getClass().getResourceAsStream(imageFiles[i]));
            hpl.setGraphic(new ImageView (image));
            hpl.setFont(Font.font("Arial", 14));
            final String url = urls[i];
 
            hpl.setOnAction((ActionEvent e) -> {
                webEngine.load(url);
            });
        }
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BASELINE_CENTER);
        hbox.getChildren().addAll(hpls);
        vbox.getChildren().addAll(hbox, browser);
        VBox.setVgrow(browser, Priority.ALWAYS);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
    
    


