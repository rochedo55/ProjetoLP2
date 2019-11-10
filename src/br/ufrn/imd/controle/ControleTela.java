package br.ufrn.imd.controle;

import java.io.File;
import java.util.regex.Pattern;

import br.ufrn.imd.modelo.Knn;
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

/**
 * Classe de contro da interface gráfica vinculada ao TelaPrincipal.fxml
 * @author Anderson e Gabriel Rocha
 *
 */

public class ControleTela{
	/**
	 * {@value #verificar} botao verificar que executa a funcao para gerar o resultado de ter pessoa ou nao pessoa na imagem
	 * {@value #tela} tela de fundo que sustenta os botes e label's da interface grafica
	 * {@value #erro} label que exibe o status da imagem fornecida pelo usuario,caminho ou erro.
	 * {@value #label} label que exibe o resultado (tem pessoa ou nao)
	 * {@value #abrirImg} botao que abre o seletor de arquivo para que o usuario escolha
	 * {@value #comboBox} caixa de escolha de inteiros pra o valor de knn
	 */

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
	
    /**
     * Funcao para abrir a janela para a escolha da imagem
     */
	@FXML
	public void abrirImagem() {
		FileChooser choser = new FileChooser();
	    File file = choser.showOpenDialog(null);
	    verificarExtencao(file);
	}
	/**
	 * acao do botao verificar
	 * @param event acao de apertar o botao verificar
	 */
	@FXML
	public void ButtonAction(ActionEvent event) {
		Tratamento tratamento = new Tratamento();
		ObjetoDataSet obj = new ObjetoEuclidiano();
		if(caminho != null) {
			tratamento.imagem(caminho);
			tratamento.dataset();
			tratamento = obj.CalcularDistancia(tratamento);
		
			Knn k = new Knn();
			String resposta = k.Ordenar(tratamento, Integer.parseInt(comboBox.getSelectionModel().getSelectedItem()));
			label.setText(resposta);
		}else {
			erro.setText("Imagem não encontrada, Por favor, selecione outra imagem");
		}
	}
	/**
	 * funcao que verifica se a imagem que o usuario forneceu pode ser usada ou nao para o programa
	 * @param file arquivo que o usuario escolheu
	 */
	public void verificarExtencao(File file) {
		try {
			caminho = file.toString();
			String extencao[] = caminho.split(Pattern.quote("."));
			String ext = extencao[1];	
			if(ext.equals("png")) {
				erro.setText("Imagem "+caminho+" selecionada");
			}else {
				erro.setText("Formato inválido, Por favor, selecione outra imagem");
				caminho = null;
			}
		} catch (Exception e) {
			erro.setText("Imagem não encontrada, Por favor, selecione outra imagem");
			caminho = null;
		}
		
	}
}
