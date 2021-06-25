package ru.xrave.theme;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.xrave.checker.utils.Data;


public class ServerAddController implements Initializable{

	
	@FXML
	private Button server_add;
	@FXML
	private TextField field_name;
	@FXML
	private TextField field_address;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void handleClicks(ActionEvent actionEvent) {
		if(actionEvent.getSource() == server_add) {
			if(field_name.getText() != null && field_address.getText() != null) {
				Data.servers.put(Data.servers.size(),field_name.getText() + ":" + field_address.getText());
				Data.bred = 0;

			}
		}
		
	}


}