package tallerjavafx.charts;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EjemploBarChart extends Application {

	private final static String AUSTRIA = "Austria";
	private final static String BRASIL = "Brasil";
	private final static String FRANCIA = "Francia";
	private final static String ITALIA = "Italia";
	private final static String USA = "USA";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Ejemplo Bar Chart");
		primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		
        final NumberAxis ejeX = new NumberAxis();
        ejeX.setLabel("Value");
        ejeX.setTickLabelRotation(90);
        final CategoryAxis ejeY = new CategoryAxis();
        ejeY.setLabel("Country");       
        
        final BarChart<Number,String> barChart = new BarChart<>(ejeX,ejeY);
        
        barChart.setTitle("Country Summary");
 
        XYChart.Series<Number,String> series1 = new XYChart.Series<>();
        series1.setName("2003");       
        series1.getData().add(new XYChart.Data<Number,String>(25601.34, AUSTRIA));
        series1.getData().add(new XYChart.Data<Number,String>(20148.82, BRASIL));
        series1.getData().add(new XYChart.Data<Number,String>(10000, FRANCIA));
        series1.getData().add(new XYChart.Data<Number,String>(35407.15, ITALIA));
        series1.getData().add(new XYChart.Data<Number,String>(12000, USA));      
        
        XYChart.Series<Number,String> series2 = new XYChart.Series<>();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data<Number,String>(57401.85, AUSTRIA));
        series2.getData().add(new XYChart.Data<Number,String>(41941.19, BRASIL));
        series2.getData().add(new XYChart.Data<Number,String>(45263.37, FRANCIA));
        series2.getData().add(new XYChart.Data<Number,String>(117320.16, ITALIA));
        series2.getData().add(new XYChart.Data<Number,String>(14845.27, USA));  
        
        XYChart.Series<Number,String> series3 = new XYChart.Series<>();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data<Number,String>(45000.65, AUSTRIA));
        series3.getData().add(new XYChart.Data<Number,String>(44835.76, BRASIL));
        series3.getData().add(new XYChart.Data<Number,String>(18722.18, FRANCIA));
        series3.getData().add(new XYChart.Data<Number,String>(17557.31, ITALIA));
        series3.getData().add(new XYChart.Data<Number,String>(92633.68, USA));  
        
        barChart.setBarGap(1); // Separacion entre barras de la categoria
        barChart.setCategoryGap(20); // Separacion entre categorias
        
        // Agregar una animacion al grafico
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(900), 
            (ActionEvent actionEvent) -> {
                barChart.getData().stream().forEach((series) -> {
                    series.getData().stream().forEach((data) -> {
                        data.setXValue(Math.random() * 1000);
                    });
                });
            }
        ));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.setAutoReverse(true);
        tl.play();
        
        ejeY.setAnimated(false);
        
        Scene scene  = new Scene(barChart,800,600);
        barChart.getData().add(series1);
        barChart.getData().add(series2);
        barChart.getData().add(series3);
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}
