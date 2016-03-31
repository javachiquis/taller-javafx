package tallerjavafx.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EjemploAreaChart extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Ejemplo Area Chart");
		primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
		
		// Se definen los ejes
		final NumberAxis ejeX = new NumberAxis(1, 31, 1);
		ejeX.setLabel("Dia");
		ejeX.setMinorTickCount(0);
		final NumberAxis ejeY = new NumberAxis(-5, 27, 5);
		ejeY.setMinorTickLength(ejeY.getTickLength());
		ejeY.setForceZeroInRange(false);
		ejeY.setLabel("Grados C");
		
		// Se crea el grafico especificando el tipo de dato de los ejes
		final AreaChart<Number, Number> areaChart = new AreaChart<>(ejeX, ejeY);
		areaChart.setTitle("Monitoreo de Temperatura (en Grados C)");

		// Se definen las series de datos y sus valores para los ejes
		XYChart.Series<Number, Number> seriesAbril = new XYChart.Series<Number, Number>();
		seriesAbril.setName("Abril");
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(1, 4));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(3, 10));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(6, 15));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(9, 8));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(12, 5));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(15, 18));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(18, 15));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(21, 13));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(24, 19));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(27, 21));
		seriesAbril.getData().add(new XYChart.Data<Number, Number>(30, 21));

		XYChart.Series<Number, Number> seriesMayo = new XYChart.Series<Number, Number>();
		seriesMayo.setName("Mayo");
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(1, 20));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(3, 15));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(6, 13));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(9, 12));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(12, 14));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(15, 18));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(18, 25));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(21, 25));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(24, 23));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(27, 26));
		seriesMayo.getData().add(new XYChart.Data<Number, Number>(31, 26));

		XYChart.Series<Number, Number> seriesMarzo = new XYChart.Series<Number, Number>();
        seriesMarzo.setName("Marzo");
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(0, -2));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(3, -4));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(6, 0));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(9, 5));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(12, -4));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(15, 6));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(18, 8));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(21, 14));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(24, 4));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(27, 6));
        seriesMarzo.getData().add(new XYChart.Data<Number, Number>(31, 6)); 
		
		Scene scene = new Scene(areaChart, 850, 450);
		scene.getStylesheets().add("/recursos/css/estilos-chart.css");
		areaChart.getData().add(seriesMarzo);
		areaChart.getData().add(seriesAbril);
		areaChart.getData().add(seriesMayo);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
