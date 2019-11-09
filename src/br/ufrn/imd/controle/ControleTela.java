package br.ufrn.imd.controle;

import java.io.File;
import java.util.regex.Pattern;

import br.ufrn.imd.modelo.ObjetoDataSet;
import br.ufrn.imd.modelo.ObjetoEuclidiano;
import br.ufrn.imd.modelo.Tratamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> comboBox;
    
    public String caminho;

	
	@FXML
	public void initialize() {
	    comboBox.getItems().removeAll(comboBox.getItems());
	    comboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
	    comboBox.getSelectionModel().select("1");  
	}
	
    
	@FXML
	public void abrirImagem() {
		FileChooser choser = new FileChooser();
	    File file = choser.showOpenDialog(null);
	    verificarExtencao(file);
	}
	
	@FXML
	public void ButtonAction(ActionEvent event) {
		Tratamento tratamento = new Tratamento();
		ObjetoDataSet obj = new ObjetoEuclidiano();
		if(caminho != null) {
			tratamento.imagem(caminho);
			tratamento.dataset();
			tratamento = obj.CalcularDistancia(tratamento);
		
			KnnTeste k = new KnnTeste();
			String resposta = k.Ordenar(tratamento, Integer.parseInt(comboBox.getSelectionModel().getSelectedItem()));
			label.setText(resposta);
		}else {
			erro.setText("Img não encontrada, pfv selecione uma img");
		}
	}

	public void verificarExtencao(File file) {
		try {
			caminho = file.toString();
			String extencao[] = caminho.split(Pattern.quote("."));
			String ext = extencao[1];	
			if(ext.equals("png")) {
				erro.setText("Img "+caminho+" selecionada");
			}else {
				erro.setText("Formato invalido, pfv selecione outra img");
				caminho = null;
			}
		} catch (Exception e) {
			erro.setText("Img não encontrada, pfv selecione uma img");
			caminho = null;
		}
		
	}
}
