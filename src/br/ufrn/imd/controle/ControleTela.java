package br.ufrn.imd.controle;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControleTela extends Application implements Initializable{

	@FXML
	private Stage primeiro;
	
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private void initPrincipal() {
        //essa funcao faz com que as coisas setadas no scene
        //aparecao quando a janela for aberta,logo ela precisa ser chamada ao iniciar
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../br/ufrn/imd/visao/TelaPrincipal.fxml"));
            loader.setController(this);
            tela = (AnchorPane) loader.load();

            Scene scene = new Scene(tela);
            primeiro.setScene(scene);
            primeiro.show();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
