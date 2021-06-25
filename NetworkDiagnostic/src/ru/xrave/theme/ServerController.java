package ru.xrave.theme;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import ru.xrave.checker.servers.AvailabilityCheck;
import ru.xrave.checker.utils.Data;

public class ServerController implements Initializable{

	@FXML
	private Button server_status;
	@FXML
	private Label server_ip;
	@FXML
	private Label server_name;
	@FXML
	private Label server_drop;
	@FXML
	private ImageView server_signal;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String[] server_data = Data.servers.get(Data.bred).split(":");
		server_ip.setText(server_data[0]);
		server_name.setText(server_data[1]);
		server_drop.setText("error");
		boolean reachable = false;
		try {
			reachable = InetAddress.getByName(server_data[1]).isReachable(80);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(reachable) {
		//if(AvailabilityCheck.isAvailability(server_data[1])) {
			server_status.setText("В сети");
			server_signal.setVisible(true);
			try {
				server_drop.setText(AvailabilityCheck.ping(server_data[1]) + "ms");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			server_signal.setVisible(false);
			server_status.setText("Не сети");
		}
		Data.bred = Data.bred + 1;
	}



}