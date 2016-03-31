package tallerjavafx.charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EjemploScatterChart extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Ejemplo Scatter Chart");
		primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
		
		final NumberAxis xAxis = new NumberAxis(0, 10, 1);
		final NumberAxis yAxis = new NumberAxis(-100, 500, 100);
		
		final ScatterChart<Number, Number> dispersion = new ScatterChart<>(xAxis, yAxis);
		xAxis.setLabel("Age (years)");
		yAxis.setLabel("Returns to date");
		dispersion.setTitle("Investment Overview");

		XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
		series1.setName("Equities");
		series1.getData().add(new XYChart.Data<Number, Number>(4.2, 193.2));
		series1.getData().add(new XYChart.Data<Number, Number>(2.8, 33.6));
		series1.getData().add(new XYChart.Data<Number, Number>(6.2, 24.8));
		series1.getData().add(new XYChart.Data<Number, Number>(1, 14));
		series1.getData().add(new XYChart.Data<Number, Number>(1.2, 26.4));
		series1.getData().add(new XYChart.Data<Number, Number>(4.4, 114.4));
		series1.getData().add(new XYChart.Data<Number, Number>(8.5, 323));
		series1.getData().add(new XYChart.Data<Number, Number>(6.9, 289.8));
		series1.getData().add(new XYChart.Data<Number, Number>(9.9, 287.1));
		series1.getData().add(new XYChart.Data<Number, Number>(0.9, -9));
		series1.getData().add(new XYChart.Data<Number, Number>(3.2, 150.8));
		series1.getData().add(new XYChart.Data<Number, Number>(4.8, 20.8));
		series1.getData().add(new XYChart.Data<Number, Number>(7.3, -42.3));
		series1.getData().add(new XYChart.Data<Number, Number>(1.8, 81.4));
		series1.getData().add(new XYChart.Data<Number, Number>(7.3, 110.3));
		series1.getData().add(new XYChart.Data<Number, Number>(2.7, 41.2));

//		XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
//		series2.setName("Mutual funds");
//		series2.getData().add(new XYChart.Data<Number, Number>(5.2, 229.2));
//		series2.getData().add(new XYChart.Data<Number, Number>(2.4, 37.6));
//		series2.getData().add(new XYChart.Data<Number, Number>(3.2, 49.8));
//		series2.getData().add(new XYChart.Data<Number, Number>(1.8, 134));
//		series2.getData().add(new XYChart.Data<Number, Number>(3.2, 236.2));
//		series2.getData().add(new XYChart.Data<Number, Number>(7.4, 114.1));
//		series2.getData().add(new XYChart.Data<Number, Number>(3.5, 323));
//		series2.getData().add(new XYChart.Data<Number, Number>(9.3, 29.9));
//		series2.getData().add(new XYChart.Data<Number, Number>(8.1, 287.4));

		dispersion.setPrefSize(500, 400);
		dispersion.getData().add(series1);
//		dispersion.getData().add(series2);
		final DropShadow shadow = new DropShadow();
		shadow.setOffsetX(2);
		shadow.setColor(Color.GREY);
		dispersion.setEffect(shadow);
		
		Scene scene = new Scene(new Group());
		scene.getStylesheets().add("/recursos/css/estilos-chart.css");
		final VBox vbox = new VBox();
        final HBox hbox = new HBox();
        
        final Button add = new Button("Agregar Series");               
		add.setOnAction((ActionEvent e) -> {
			if (dispersion.getData() == null) {
				dispersion.setData(FXCollections.<XYChart.Series<Number, Number>> observableArrayList());
			}
			ScatterChart.Series<Number, Number> series = new ScatterChart.Series<>();
			series.setName("Option " + (dispersion.getData().size() + 1));
			for (int i = 0; i < 100; i++) {
				series.getData().add(new ScatterChart.Data<>(Math.random() * 100, Math.random() * 500));
			}
			dispersion.getData().add(series);
		});
		
		final Button remove = new Button("Remover Series");
		remove.setOnAction((ActionEvent e) -> {
			if (!dispersion.getData().isEmpty())
				dispersion.getData().remove((int) (Math.random() * (dispersion.getData().size() - 1)));
		});
        
        hbox.setSpacing(10);
        hbox.getChildren().addAll(add, remove);
        
        vbox.getChildren().addAll(dispersion, hbox);
        hbox.setPadding(new Insets(10, 10, 10, 50));
        
        ((Group)scene.getRoot()).getChildren().add(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
