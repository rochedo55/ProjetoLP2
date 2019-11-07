package br.ufrn.imd.controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.ComboBoxListCell;

//import br.ufrn.imd.visao.TelaPrincipal.fxml;
import application.Main;

public class ControleTela implements Initializable{

	@FXML
	private Label label;
	@FXML
	private ComboBoxListCell comboBox;
	@SuppressWarnings("unchecked")
	@FXML
	public void ComboBox() {
	    comboBox.getItems().removeAll(comboBox.getItems());
	    comboBox.getItems().addAll("Option A", "Option B", "Option C");
	    //comboBox.getSelectionModel().select("Option B");
	}
	private void ButtonAction(ActionEvent event) {
		label.setText("Ola mundo");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
