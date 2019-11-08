package application;
	
import br.ufrn.imd.modelo.ObjetoDataSet;
import br.ufrn.imd.modelo.ObjetoEuclidiano;
import br.ufrn.imd.modelo.Tratamento;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("..\\br\\ufrn\\imd\\visao\\TelaPrincipal.fxml"));
			Scene scene = new Scene(root,300,150);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		// --------------------------------------> isso fica no controler ou em outra classe (provavelmente no controer msm)
		Tratamento tratamento = new Tratamento();
		ObjetoDataSet obj = new ObjetoEuclidiano();
		tratamento.imagem("C:\\Users\\ander\\Downloads\\0.png");
		tratamento.dataset();
		obj.CalcularDistancia(tratamento);
		System.out.print(tratamento.getDataset().get(0).getDistancia()+"\n");
		//System.out.print(tratamento.getDataset().get(80).getDistancia());
		// TESTES
		//System.out.print(tratamento.getDataset().get(10).getRotulo());
		//System.out.print(tratamento.getDataset().get(80).getRotulo());
		//System.out.print(tratamento.getDataset().get(10).getAtributos());
		
		launch(args);
	}
}
