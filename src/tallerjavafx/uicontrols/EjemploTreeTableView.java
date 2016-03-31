/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeSortMode;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tallerjavafx.model.Employee;

/**
 *
 * @author ener2
 */
public class EjemploTreeTableView extends Application {

	List<Employee> employees = Arrays.<Employee> asList(
			new Employee("Ethan Williams", null, "ethan.williams@example.com"),
			new Employee("Emma Jones", null, "emma.jones@example.com"),
			new Employee("Michael Brown", null, "michael.brown@example.com"),
			new Employee("Anna Black", null, "anna.black@example.com"),
			new Employee("Rodger York", null, "roger.york@example.com"),
			new Employee("Susan Collins", null, "susan.collins@example.com"));

	private final ImageView depIcon = new ImageView(
			new Image(getClass().getResourceAsStream("/recursos/img/folder-user.png")));

	final TreeItem<Employee> root = new TreeItem<Employee>(new Employee("Sales Department", null, ""), depIcon);

	@Override
	public void start(Stage stage) throws Exception {
		
		root.setExpanded(true);
        employees.stream().forEach((employee) -> {
            root.getChildren().add(new TreeItem<>(employee));
        });
		
		stage.setTitle("Ejemplo Tree Table View");
		stage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		stage.initModality(Modality.APPLICATION_MODAL);
		
		final Scene scene = new Scene(new Group(), 400, 400);
		scene.setFill(Color.LIGHTGRAY);
		Group sceneRoot = (Group) scene.getRoot();

		TreeTableColumn<Employee, String> empColumn = new TreeTableColumn<>("Employee");
		empColumn.setPrefWidth(150);
		empColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Employee, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getName()));

		TreeTableColumn<Employee, String> emailColumn = new TreeTableColumn<>("Email");
		emailColumn.setPrefWidth(190);
		emailColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Employee, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getEmail()));

		TreeTableView<Employee> treeTableView = new TreeTableView<>(root);
		treeTableView.getColumns().setAll(empColumn, emailColumn);
		treeTableView.setTableMenuButtonVisible(true);
		
		sceneRoot.getChildren().add(treeTableView);
		stage.setScene(scene);
		stage.show();

	}

	// public class Employee {
	//
	// private SimpleStringProperty name;
	// private SimpleStringProperty email;
	// public SimpleStringProperty nameProperty() {
	// if (name == null) {
	// name = new SimpleStringProperty(this, "name");
	// }
	// return name;
	// }
	// public SimpleStringProperty emailProperty() {
	// if (email == null) {
	// email = new SimpleStringProperty(this, "email");
	// }
	// return email;
	// }
	// private Employee(String name, String email) {
	// this.name = new SimpleStringProperty(name);
	// this.email = new SimpleStringProperty(email);
	// }
	// public String getName() {
	// return name.get();
	// }
	// public void setName(String fName) {
	// name.set(fName);
	// }
	// public String getEmail() {
	// return email.get();
	// }
	// public void setEmail(String fName) {
	// email.set(fName);
	// }
	// }
}
