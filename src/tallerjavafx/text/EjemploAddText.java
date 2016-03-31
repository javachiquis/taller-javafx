/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.text;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author PERSONAL
 */
public class EjemploAddText extends Application {

//	private int fx;

	public void start(Stage stage) throws Exception {
		// agregar texto
		Text t = new Text();
		t.setText("Este es un texto de ejemplo");
		// color y fondo
		t.setFont(Font.font("Verdana", 20));
		t.setFill(Color.RED);

		// negriya o cursiva
		t.setFont(Font.font("Verdana", FontWeight.BOLD, 70));

		t.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
		// fuentes de encargo
		Text text = new Text();
		text.setFont(Font.loadFont("file:resources/fonts/isadoracyr.ttf", 120));
		//
		Text text9 = new Text();
		text9.setFontSmoothingType(FontSmoothingType.LCD);

		String family = "Helvetica";
		double size = 50;

		TextFlow textFlow = new TextFlow();
		textFlow.setLayoutX(40);
		textFlow.setLayoutY(40);
		Text text1 = new Text("Hola ");
		text1.setFont(Font.font(family, size));
		text1.setFill(Color.RED);
		Text text2 = new Text("Bold");
		text2.setFill(Color.ORANGE);
		text2.setFont(Font.font(family, FontWeight.BOLD, size));
		Text text3 = new Text(" Mundo");
		text3.setFill(Color.GREEN);
		text3.setFont(Font.font(family, FontPosture.ITALIC, size));
		textFlow.getChildren().addAll(text1, text2, text3);

		TextFlow textFlow2 = new TextFlow();
		Font font = new Font("Tahoma", 48);
		Text text4 = new Text("He said \u0627\u0644\u0633\u0644\u0627\u0645");
		text4.setFill(Color.RED);
		text4.setFont(font);
		Text text5 = new Text(" \u0639\u0644\u064a\u0643\u0645 to me.");
		text5.setFill(Color.BLUE);
		text5.setFont(font);
		textFlow2.getChildren().addAll(text1, text2);

		Group group = new Group();
		group.getChildren().add(textFlow);
		group.getChildren().add(textFlow2);
		
		Scene scene = new Scene(group, 650, 150, Color.WHITE);
		stage.setTitle("Hello Bidi Text");
		stage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.show();
		textFlow.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
	}

}
