/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.uicontrols;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tallerjavafx.model.Employee;

/**
 *
 * @author ener2
 */
 
public class EjemploTreeView extends Application {
 
    private final Node rootIcon = 
        new ImageView(new Image(getClass().getResourceAsStream("/recursos/img/folder-user.png")));
    private final Image depIcon = 
        new Image(getClass().getResourceAsStream("/recursos/img/folder-tree.png"));
    List<Employee> employees = Arrays.<Employee>asList(
            new Employee("Jacob Smith", "Accounts Department", null),
            new Employee("Isabella Johnson", "Accounts Department", null),           
            new Employee("Ethan Williams", "Sales Department", null),
            new Employee("Emma Jones", "Sales Department", null),
            new Employee("Michael Brown", "Sales Department", null),
            new Employee("Anna Black", "Sales Department", null),
            new Employee("Rodger York", "Sales Department", null),
            new Employee("Susan Collins", "Sales Department", null),
            new Employee("Mike Graham", "IT Support", null),
            new Employee("Judy Mayer", "IT Support", null),
            new Employee("Gregory Smith", "IT Support", null));
    TreeItem<String> rootNode;
 
    public EjemploTreeView() {
        this.rootNode = new TreeItem<>("MyCompany Human Resources", rootIcon);
    }
 
    @Override
    public void start(Stage stage) {
        rootNode.setExpanded(true);
        for (Employee employee : employees) {
            TreeItem<String> empLeaf = new TreeItem<>(employee.getName());
            boolean found = false;
            for (TreeItem<String> depNode : rootNode.getChildren()) {
                if (depNode.getValue().contentEquals(employee.getDepartment())){
                    depNode.getChildren().add(empLeaf);
                    found = true;
                    break;
                }
            }
            if (!found) {
                TreeItem<String> depNode = new TreeItem<>(
                    employee.getDepartment(), 
                    new ImageView(depIcon)
                );
                rootNode.getChildren().add(depNode);
                depNode.getChildren().add(empLeaf);
            }
        }
 
        stage.setTitle("Ejemplo Tree View");
        stage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		stage.initModality(Modality.APPLICATION_MODAL);
        VBox box = new VBox();
        final Scene scene = new Scene(box, 400, 300);
        scene.setFill(Color.LIGHTGRAY);
 
        TreeView<String> treeView = new TreeView<>(rootNode);
        
        box.getChildren().add(treeView);
        stage.setScene(scene);
        stage.show();
    }
}    
