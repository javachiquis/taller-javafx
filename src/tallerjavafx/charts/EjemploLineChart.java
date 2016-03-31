package tallerjavafx.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EjemploLineChart extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Ejemplo Line Chart");
		primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
		
		// Se definen los ejes
		final CategoryAxis ejeX = new CategoryAxis();
		ejeX.setLabel("Mes");
		final NumberAxis ejeY = new NumberAxis();
		ejeY.setLabel("Ventas");
		
		// Se crea el grafico especificando el tipo de dato de los ejes
		final LineChart<String, Number> lineChart = new LineChart<String, Number>(ejeX, ejeY);
		lineChart.setTitle("Supervision de Capital, 2016");
		
		// Se definen las series de datos y sus valores para los ejes
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		series1.setName("Cartera 1");
		series1.getData().add(new XYChart.Data<String, Number>("Ene", 23));
		series1.getData().add(new XYChart.Data<String, Number>("Feb", 14));
		series1.getData().add(new XYChart.Data<String, Number>("Mar", 15));
		series1.getData().add(new XYChart.Data<String, Number>("Abr", 24));
		series1.getData().add(new XYChart.Data<String, Number>("May", 34));
		series1.getData().add(new XYChart.Data<String, Number>("Jun", 36));
		series1.getData().add(new XYChart.Data<String, Number>("Jul", 22));
		series1.getData().add(new XYChart.Data<String, Number>("Ago", 45));
		series1.getData().add(new XYChart.Data<String, Number>("Sep", 43));
		series1.getData().add(new XYChart.Data<String, Number>("Oct", 17));
		series1.getData().add(new XYChart.Data<String, Number>("Nov", 29));
		series1.getData().add(new XYChart.Data<String, Number>("Dic", 25));

		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.setName("Cartera 2");
		series2.getData().add(new XYChart.Data<String, Number>("Ene", 33));
        series2.getData().add(new XYChart.Data<String, Number>("Feb", 34));
        series2.getData().add(new XYChart.Data<String, Number>("Mar", 25));
        series2.getData().add(new XYChart.Data<String, Number>("Abr", 44));
        series2.getData().add(new XYChart.Data<String, Number>("May", 39));
        series2.getData().add(new XYChart.Data<String, Number>("Jun", 16));
        series2.getData().add(new XYChart.Data<String, Number>("Jul", 55));
        series2.getData().add(new XYChart.Data<String, Number>("Ago", 54));
        series2.getData().add(new XYChart.Data<String, Number>("Sep", 48));
        series2.getData().add(new XYChart.Data<String, Number>("Oct", 27));
        series2.getData().add(new XYChart.Data<String, Number>("Nov", 37));
        series2.getData().add(new XYChart.Data<String, Number>("Dic", 29));
		
        XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
		series3.setName("Cartera 3");
		series3.getData().add(new XYChart.Data<String, Number>("Ene", 44));
        series3.getData().add(new XYChart.Data<String, Number>("Feb", 35));
        series3.getData().add(new XYChart.Data<String, Number>("Mar", 36));
        series3.getData().add(new XYChart.Data<String, Number>("Abr", 33));
        series3.getData().add(new XYChart.Data<String, Number>("May", 31));
        series3.getData().add(new XYChart.Data<String, Number>("Jun", 26));
        series3.getData().add(new XYChart.Data<String, Number>("Jul", 22));
        series3.getData().add(new XYChart.Data<String, Number>("Ago", 25));
        series3.getData().add(new XYChart.Data<String, Number>("Sep", 43));
        series3.getData().add(new XYChart.Data<String, Number>("Oct", 44));
        series3.getData().add(new XYChart.Data<String, Number>("Nov", 45));
        series3.getData().add(new XYChart.Data<String, Number>("Dic", 44));
		
//		lineChart.setCreateSymbols(false);
//		xAxis.setSide(Side.TOP);
		
		Scene scene = new Scene(lineChart, 850, 450);
		lineChart.getData().add(series1);
		lineChart.getData().add(series2);
		lineChart.getData().add(series3);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
