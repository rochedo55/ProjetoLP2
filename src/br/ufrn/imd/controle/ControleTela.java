package br.ufrn.imd.controle;

import java.io.File;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControleTela{

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
    private Label erro;

    @FXML
    private ComboBoxBase<?> comboBox;
	@FXML
	public void ComboBox() {
	    //comboBox.getId().removeAll(comboBox.getId());
	    //comboBox.getId().addAll("Option A", "Option B", "Option C");
	    //comboBox.getSelectionModel().select("Option B");
	}
	
	@FXML
	public void abrirImagem() {
		FileChooser choser = new FileChooser();
	    File file = choser.showOpenDialog(null);
	    verificarExtencao(file);
	}
	
	@FXML
	public void ButtonAction(ActionEvent event) {
		label.setText("Ola mundo");
		// --------------------------------------> KNN AQUI!!!!!!!!!!!!
	}

	public void verificarExtencao(File file) {
		try {
			String caminho = file.toString();
			String extencao[] = caminho.split(Pattern.quote("."));
			String ext = extencao[1];
			System.out.println(ext);	
			if(ext.equals("png")) {
				
			}else {
				erro.setText("Formato invalido, pfv selecione outra img");
			}
		} catch (Exception e) {
			erro.setText("Img não encontrada, pfv selecione uma img");
		}
		
	}
}
