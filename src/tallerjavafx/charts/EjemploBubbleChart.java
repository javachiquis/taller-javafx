package tallerjavafx.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EjemploBubbleChart extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Ejemplo Bubble Chart");
		primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados

		// Se definen los ejes del grafico
		final NumberAxis xAxis = new NumberAxis(1, 53, 4);
		xAxis.setLabel("Semana");
		xAxis.setTickLabelFill(Color.CHOCOLATE);
		final NumberAxis yAxis = new NumberAxis(0, 80, 10);
		yAxis.setLabel("Presupuesto de Producto");
		yAxis.setTickLabelFill(Color.CHOCOLATE);
		yAxis.setTickLabelGap(10); // Separacion de las etiquetas
		
		// Se aplica formato al eje, agregando un simbolo para identificar el tipo de dato
		yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$ ",null));
		
		final BubbleChart<Number, Number> burbuja = new BubbleChart<>(xAxis, yAxis);
		burbuja.setTitle("Control de Presupuesto");

		// Se definen los datos para el grafico
		XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
		series1.setName("Producto 1");
		series1.getData().add(new XYChart.Data<Number, Number>(3, 35, 2));
		series1.getData().add(new XYChart.Data<Number, Number>(12, 60, 1.8));
		series1.getData().add(new XYChart.Data<Number, Number>(15, 15, 7));
		series1.getData().add(new XYChart.Data<Number, Number>(22, 30, 2.5));
		series1.getData().add(new XYChart.Data<Number, Number>(28, 20, 1));
		series1.getData().add(new XYChart.Data<Number, Number>(35, 41, 5.5));
		series1.getData().add(new XYChart.Data<Number, Number>(42, 17, 9));
		series1.getData().add(new XYChart.Data<Number, Number>(49, 30, 1.8));

		XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
		series2.setName("Producto 2");
		series2.getData().add(new XYChart.Data<Number, Number>(8, 15, 2));
		series2.getData().add(new XYChart.Data<Number, Number>(13, 23, 1));
		series2.getData().add(new XYChart.Data<Number, Number>(15, 45, 3));
		series2.getData().add(new XYChart.Data<Number, Number>(24, 30, 4.5));
		series2.getData().add(new XYChart.Data<Number, Number>(38, 78, 1));
		series2.getData().add(new XYChart.Data<Number, Number>(40, 41, 7.5));
		series2.getData().add(new XYChart.Data<Number, Number>(45, 57, 2));
		series2.getData().add(new XYChart.Data<Number, Number>(47, 23, 3.8));

		Scene scene = new Scene(burbuja);
		burbuja.getData().add(series1);
		burbuja.getData().add(series2);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
