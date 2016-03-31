/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerjavafx.principal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tallerjavafx.charts.EjemploAreaChart;
import tallerjavafx.charts.EjemploBarChart;
import tallerjavafx.charts.EjemploBubbleChart;
import tallerjavafx.charts.EjemploLineChart;
import tallerjavafx.charts.EjemploPieChart;
import tallerjavafx.charts.EjemploScatterChart;
import tallerjavafx.text.EjemploAddText;
import tallerjavafx.text.EjemploEffectText;
import tallerjavafx.uicontrols.EjemploButton;
import tallerjavafx.uicontrols.EjemploCheckBox;
import tallerjavafx.uicontrols.EjemploChoiceBox;
import tallerjavafx.uicontrols.EjemploColorPicker;
import tallerjavafx.uicontrols.EjemploComboBox;
import tallerjavafx.uicontrols.EjemploCustomization;
import tallerjavafx.uicontrols.EjemploDatePicker;
import tallerjavafx.uicontrols.EjemploFileChooser;
import tallerjavafx.uicontrols.EjemploHtml;
import tallerjavafx.uicontrols.EjemploHyperLink;
import tallerjavafx.uicontrols.EjemploLabel;
import tallerjavafx.uicontrols.EjemploListView;
import tallerjavafx.uicontrols.EjemploMenu;
import tallerjavafx.uicontrols.EjemploPaginationControl;
import tallerjavafx.uicontrols.EjemploPasswordField;
import tallerjavafx.uicontrols.EjemploProgressBarAndProgressIndicator;
import tallerjavafx.uicontrols.EjemploRadioButton;
import tallerjavafx.uicontrols.EjemploScrollBar;
import tallerjavafx.uicontrols.EjemploScrollPane;
import tallerjavafx.uicontrols.EjemploSeparator;
import tallerjavafx.uicontrols.EjemploSlider;
import tallerjavafx.uicontrols.EjemploTableView;
import tallerjavafx.uicontrols.EjemploTextField;
import tallerjavafx.uicontrols.EjemploTitledPane;
import tallerjavafx.uicontrols.EjemploToggleButton;
import tallerjavafx.uicontrols.EjemploToolip;
import tallerjavafx.uicontrols.EjemploTreeTableView;
import tallerjavafx.uicontrols.EjemploTreeView;

/**
 *
 * @author ener2
 */
public class Principal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // PARTE 1 - UICONTROLS
        // BUTTON
        Button btnButton = new Button("Botones (Button)");
        btnButton.setOnAction((ActionEvent event) -> {
            try {
                new EjemploButton().start(new Stage());
            } catch (Exception e) {
            }
        });

        // CHECKBOX
        Button btnCheckBox = new Button("Casilla de Seleccion (CheckBox)");
        btnCheckBox.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploCheckBox().start(new Stage());
            } catch (Exception e) {
            }
        });

        // CHOICEBOX
        Button btnChoiceBox = new Button("Menu de Seleccion (ChoiceBox)");
        btnChoiceBox.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploChoiceBox().start(new Stage());
            } catch (Exception e) {
            }
        });

        // COLORPICKER
        Button btnColorPicker = new Button("Selector de Color (ColorPicker)");
        btnColorPicker.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploColorPicker().start(new Stage());
            } catch (Exception e) {
            }
        });

        // COMBOBOX
        Button btnComboBox = new Button("Caja de Seleccion (ComboBox)");
        btnComboBox.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploComboBox().start(new Stage());
            } catch (Exception e) {
            }
        });

        // CUSTOMATIZATION
        Button btnCustomatization = new Button("Componente Modificado (Customatization)");
        btnCustomatization.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploCustomization().start(new Stage());
            } catch (Exception e) {
            }
        });

        // DATEPICKER
        Button btnDatePicker = new Button("Selector de Fecha (DatePicker)");
        btnDatePicker.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploDatePicker().start(new Stage());
            } catch (Exception e) {
            }
        });

        // FILECHOOSER
        Button btnFileChooser = new Button("Selector de Archivos (FileChooser)");
        btnFileChooser.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploFileChooser().start(new Stage());
            } catch (Exception e) {
            }
        });

        // HTML
        Button btnHtml = new Button("Editor HTML");
        btnHtml.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploHtml().start(new Stage());
            } catch (Exception e) {
            }
        });

        // HYPERLINK
        Button btnHyperLink = new Button("Enlaces (HyperLink)");
        btnHyperLink.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploHyperLink().start(new Stage());
            } catch (Exception e) {
            }
        });

        // LABEL
        Button btnLabel = new Button("Etiqueta (Label)");
        btnLabel.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploLabel().start(new Stage());
            } catch (Exception e) {
            }
        });

        // LISTVIEW
        Button btnListView = new Button("Lista (ListView)");
        btnListView.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploListView().start(new Stage());
            } catch (Exception e) {
            }
        });

        // MENU
        Button btnMenu = new Button("Menus");
        btnMenu.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploMenu().start(new Stage());
            } catch (Exception e) {
            }
        });

        // PAGINATIONCONTROL
        Button btnPaginationControl = new Button("Control de Paginacion");
        btnPaginationControl.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploPaginationControl().start(new Stage());
            } catch (Exception e) {
            }
        });

        // PASWORDFIELD
        Button btnPasswordField = new Button("Campo de Contrasena (PaswordField)");
        btnPasswordField.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploPasswordField().start(new Stage());
            } catch (Exception e) {
            }
        });

        // PROGRESSBAR AND PROGRESSINDICATOR
        Button btnProgressBarAndProgressIndicator = new Button("Barras e Indicadores");
        btnProgressBarAndProgressIndicator.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploProgressBarAndProgressIndicator().start(new Stage());
            } catch (Exception e) {
            }
        });

        // RADIOBUTTON
        Button btnRadioButton = new Button("Boton de Opcion (RadioButton)");
        btnRadioButton.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploRadioButton().start(new Stage());
            } catch (Exception e) {
            }
        });

        // SCROLLBAR
        Button btnScrollBar = new Button("Barra de Desplazamiento (ScrollBar)");
        btnScrollBar.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploScrollBar().start(new Stage());
            } catch (Exception e) {
            }
        });

        // SCROLLPANE
        Button btnScrollPane = new Button("Panel de Desplazamiento (ScrollPane)");
        btnScrollPane.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploScrollPane().start(new Stage());
            } catch (Exception e) {
            }
        });

        // SEPARATOR
        Button btnSeparator = new Button("Separadores (Separator)");
        btnSeparator.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploSeparator().start(new Stage());
            } catch (Exception e) {
            }
        });

        // SLIDER
        Button btnSlider = new Button("Deslizador (Slider)");
        btnSlider.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploSlider().start(new Stage());
            } catch (Exception e) {
            }
        });

        // TABLEVIEW
        Button btnTableView = new Button("Tablas (TableView)");
        btnTableView.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploTableView().start(new Stage());
            } catch (Exception e) {
            }
        });

        // TEXTFIELD
        Button btnTextField = new Button("Campo de Texto (TextField)");
        btnTextField.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploTextField().start(new Stage());
            } catch (Exception e) {
            }
        });

        // TITLEDPANE
        Button btnTitledPane = new Button("Menu Acordeon(TitledPane Accordion)");
        btnTitledPane.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploTitledPane().start(new Stage());
            } catch (Exception e) {
            }
        });

        // TOGGLEBUTTON
        Button btnToggleButton = new Button("Boton de Activacion (ToggleButton)");
        btnToggleButton.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploToggleButton().start(new Stage());
            } catch (Exception e) {
            }
        });

        // TOOLIP
        Button btnToolip = new Button("Globo de Informacion (Toolip)");
        btnToolip.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploToolip().start(new Stage());
            } catch (Exception e) {
            }
        });

        // TREETABLEVIEW
        Button btnTreeTableView = new Button("Arboles y Tablas(TreeTableView)");
        btnTreeTableView.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploTreeTableView().start(new Stage());
            } catch (Exception e) {
            }
        });

        // TREEVIEW
        Button btnTreeView = new Button("Arboles (TreeView)");
        btnTreeView.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploTreeView().start(new Stage());
            } catch (Exception e) {
            }
        });

        // PARTE 2 - CHARTS
        // Grafica Circular
        Button btnPieChart = new Button("Grafica Circular (Pie Charts)");
        btnPieChart.setOnAction((ActionEvent event) -> {
            try {
                new EjemploPieChart().start(new Stage());
            } catch (Exception e) {
            }
        });

        // Grafico de Lineas
        Button btnLineChart = new Button("Grafico de Lineas (Line Chart)");
        btnLineChart.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploLineChart().start(new Stage());
            } catch (Exception e) {
            }
        });

        // Grafico de Area
        Button btnAreaChart = new Button("Grafico de Area (Area Chart)");
        btnAreaChart.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploAreaChart().start(new Stage());
            } catch (Exception e) {
            }
        });

        // Grafico Burbuja
        Button btnBubbleChart = new Button("Grafico Burbuja (Bubble Chart)");
        btnBubbleChart.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploBubbleChart().start(new Stage());
            } catch (Exception e) {
            }
        });

        // Grafico de Dispersion
        Button btnScatterChart = new Button("Grafico de Dispersion (Scatter Chart)");
        btnScatterChart.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploScatterChart().start(new Stage());
            } catch (Exception e) {
            }
        });

        // Grafico de Barras
        Button btnBarChart = new Button("Grafico de Barras (Bar Chart)");
        btnBarChart.setOnAction((ActionEvent arg0) -> {
            try {
                new EjemploBarChart().start(new Stage());
            } catch (Exception e) {
            }
        });

        // PARTE 3 - TEXT
        // Usando Text en JavaFX
        Button btnAddText = new Button("Agregar Texto (Add Text)");
        btnAddText.setOnAction((ActionEvent event) -> {
            try {
                new EjemploAddText().start(new Stage());
            } catch (Exception e) {
            }
        });

        // Aplicando Efectos al Texto
        Button btnEffectText = new Button("Aplicar Efectos (Effect Text)");
        btnEffectText.setOnAction((ActionEvent event) -> {
            try {
                new EjemploEffectText().start(new Stage());
            } catch (Exception e) {
            }
        });

        //Se agregan los componentes al panel de vistas
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setMinSize(800, 300);
        root.setVgap(5);
        root.setHgap(5);

        root.add(btnLabel, 0, 0);
        root.add(btnButton, 0, 1);
        root.add(btnCheckBox, 0, 2);
        root.add(btnRadioButton, 0, 3);
        root.add(btnChoiceBox, 0, 4);
        root.add(btnComboBox, 0, 5);
        root.add(btnTextField, 0, 6);
        root.add(btnPasswordField, 0, 7);
        root.add(btnToggleButton, 0, 8);

        root.add(btnToolip, 1, 0);
        root.add(btnMenu, 1, 1);
        root.add(btnScrollPane, 1, 2);
        root.add(btnScrollBar, 1, 3);
        root.add(btnSlider, 1, 4);
        root.add(btnProgressBarAndProgressIndicator, 1, 5);
        root.add(btnColorPicker, 1, 6);
        root.add(btnDatePicker, 1, 7);
        root.add(btnFileChooser, 1, 8);

        root.add(btnCustomatization, 2, 0);
        root.add(btnHtml, 2, 1);
        root.add(btnHyperLink, 2, 2);
        root.add(btnListView, 2, 3);
        root.add(btnPaginationControl, 2, 4);
        root.add(btnSeparator, 2, 5);
        root.add(btnTitledPane, 2, 6);
        root.add(btnAddText, 2, 7);
        root.add(btnEffectText, 2, 8);

        root.add(btnTableView, 3, 0);
        root.add(btnTreeView, 3, 1);
        root.add(btnTreeTableView, 3, 2);
        root.add(btnPieChart, 3, 3);
        root.add(btnLineChart, 3, 4);
        root.add(btnAreaChart, 3, 5);
        root.add(btnBubbleChart, 3, 6);
        root.add(btnScatterChart, 3, 7);
        root.add(btnBarChart, 3, 8);

        Scene scene = new Scene(root, 920, 300);

        primaryStage.setTitle("Taller - Ejemplos JavaFX");
        primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
