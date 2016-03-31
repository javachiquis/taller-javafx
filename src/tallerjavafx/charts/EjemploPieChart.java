package tallerjavafx.charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EjemploPieChart extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(new Group());
		scene.getStylesheets().add("/recursos/css/estilos-chart.css");
		
		primaryStage.getIcons().add(new Image("/recursos/img/java_icon.png"));
		primaryStage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal para evitar duplicados
		primaryStage.setTitle("Ejemplo Pie Chart");
		primaryStage.setWidth(550);
		primaryStage.setHeight(440);

		// Datos del grafico
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Uvas", 13),
				new PieChart.Data("Naranjas", 25),
				new PieChart.Data("Ciruelas", 10),
				new PieChart.Data("Peras", 22),
				new PieChart.Data("Manzanas", 30));
		
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Frutas Importadas");
		chart.setLabelLineLength(10); // Cambiar el largo de la linea del texto
		chart.setLegendSide(Side.RIGHT); // Cambiar la posicion de la leyenda del grafico
		chart.setStartAngle(180); // Angulo inicial donde se ubican los datos del grafico

		// Agregar eventos al grafico
		final Label subtitulo = new Label("");
		subtitulo.getStyleClass().add("label-text");
		subtitulo.setTextFill(Color.WHITESMOKE);
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		subtitulo.setEffect(ds);

		for (final PieChart.Data data : chart.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					subtitulo.setTranslateX(e.getSceneX());
					subtitulo.setTranslateY(e.getSceneY());
					subtitulo.setText(String.valueOf(data.getName() + "\n" + data.getPieValue()) + "%");
				}
			});
		}
		
		((Group) scene.getRoot()).getChildren().add(chart);
		((Group) scene.getRoot()).getChildren().add(subtitulo);
		primaryStage.setScene(scene);
//		primaryStage.initOwner(primaryStage.getOwner());
		primaryStage.show();
	}

}
