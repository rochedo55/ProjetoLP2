package application;
	
import br.ufrn.imd.modelo.Tratamento;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		// --------------------------------------> isso fica no controler ou em outra classe (provavelmente no controer msm)
		Tratamento tratamento = new Tratamento();
		tratamento.imagem("C:\\Users\\ander\\Downloads\\peixe.jpg");
		tratamento.dataset();
		
		// TESTES
		//System.out.print(tratamento.getDataset().get(10).getRotulo());
		//System.out.print(tratamento.getDataset().get(80).getRotulo());
		//System.out.print(tratamento.getDataset().get(10).getAtributos());
		
		launch(args);
	}
}
