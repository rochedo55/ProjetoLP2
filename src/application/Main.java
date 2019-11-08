package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrn.imd.modelo.ObjetoDataSet;
import br.ufrn.imd.modelo.ObjetoEuclidiano;
import br.ufrn.imd.modelo.Tratamento;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Main extends Application  {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("../br/ufrn/imd/visao/TelaPrincipal.fxml"));
			//"..\\br\\ufrn\\imd\\visao\\TelaPrincipal.fxml"
			// "../br/ufrn/imd/visao/TelaPrincipal.fxml"
			Scene scene = new Scene(root,300,150);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Titulo");
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	//@FXML
	//private Stage primaryStage;
	
    @FXML
    private AnchorPane tela;

    @FXML
    private Button abrirImg;

    @FXML
    private Button verificar;

    @FXML
    private Label label;

    @FXML
    private ComboBoxBase<?> comboBox;
	@FXML
	public void ComboBox() {
	    //comboBox.getId().removeAll(comboBox.getId());
	    //comboBox.getId().addAll("Option A", "Option B", "Option C");
	    //comboBox.getSelectionModel().select("Option B");
	}
	
	@FXML
	public void ButtonAction(ActionEvent event) {
		System.out.print(label.getText() +"\n");
		System.out.print("Sua mãe \n");
		label.setText("Ola mundo");
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
