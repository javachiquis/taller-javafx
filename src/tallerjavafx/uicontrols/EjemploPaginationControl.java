/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ener2
 */
public class EjemploPaginationControl extends Application {

	private Pagination pagination;
	String[] fonts = new String[] {};

	public int itemsPerPage() {
		return 15;
	}

	public VBox createPage(int pageIndex) {
		VBox box = new VBox(5);
		int page = pageIndex * itemsPerPage();
		for (int i = page; i < page + itemsPerPage(); i++) {
			Label font = new Label(fonts[i]);
			box.getChildren().add(font);
		}
		return box;
	}

	@Override
	public void start(final Stage stage) throws Exception {
		fonts = Font.getFamilies().toArray(fonts);

		pagination = new Pagination(fonts.length / itemsPerPage(), 0);
		pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
		pagination.setPageFactory((Integer pageIndex) -> createPage(pageIndex));

		AnchorPane anchor = new AnchorPane();
		AnchorPane.setTopAnchor(pagination, 10.0);
		AnchorPane.setRightAnchor(pagination, 10.0);
		AnchorPane.setBottomAnchor(pagination, 10.0);
		AnchorPane.setLeftAnchor(pagination, 10.0);
		anchor.getChildren().addAll(pagination);
		Scene scene = new Scene(anchor, 400, 450);
		stage.setScene(scene);
		stage.setTitle("Control de Paginacion");
		stage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		stage.initModality(Modality.APPLICATION_MODAL);
		scene.getStylesheets().add("/recursos/css/estilos.css");
		stage.show();
	}
	
}
