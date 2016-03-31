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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploHtml extends Application {
    
    private final String INITIAL_TEXT = "Lorem ipsum dolor sit "
            + "amet, consectetur adipiscing elit. Nam tortor felis, pulvinar "
            + "in scelerisque cursus, pulvinar at ante. Nulla consequat"
            + "congue lectus in sodales. Nullam eu est a felis ornare "
            + "bibendum et nec tellus. Vivamus non metus tempus augue auctor "
            + "ornare. Duis pulvinar justo ac purus adipiscing pulvinar. "
            + "Integer congue faucibus dapibus. Integer id nisl ut elit "
            + "aliquam sagittis gravida eu dolor. Etiam sit amet ipsum "
            + "sem.";

    @Override public void start(Stage stage) {
        
        stage.setTitle("Editor HTML");
        stage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		stage.initModality(Modality.APPLICATION_MODAL);
        stage.setWidth(650);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
    
        VBox root = new VBox();      
        root.setPadding(new Insets(8, 8, 8, 8));
        root.setSpacing(5);
        root.setAlignment(Pos.BOTTOM_LEFT);
              
        final HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);
        htmlEditor.setHtmlText(INITIAL_TEXT);       
 
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        final TextArea htmlCode = new TextArea();
        htmlCode.setWrapText(true);
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setStyle("-fx-background-color: white");
        scrollPane.setContent(htmlCode);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(180);
 
        Button showHTMLButton = new Button("Mostrar codigo HTML");
        root.setAlignment(Pos.CENTER);
        showHTMLButton.setOnAction((ActionEvent arg0) -> {
            htmlCode.setText(htmlEditor.getHtmlText());
            scrollPane.setContent(htmlCode);
        });
        
        Button showContentButton = new Button("Vista de Navegador");
        root.setAlignment(Pos.CENTER);
        showContentButton.setOnAction((ActionEvent arg0) -> {
            webEngine.loadContent(htmlEditor.getHtmlText());
            scrollPane.setContent(browser);
        });
        
        root.getChildren().addAll(htmlEditor, showHTMLButton, showContentButton, scrollPane);
        scene.setRoot(root);
 
        stage.setScene(scene);
        stage.show();
    }
 
}
        
        
    
    

