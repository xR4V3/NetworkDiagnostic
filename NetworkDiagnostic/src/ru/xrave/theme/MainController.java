package ru.xrave.theme;

import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ru.xrave.checker.utils.Data;
import ru.xrave.checker.utils.XThreads;

public class MainController implements Initializable {

	@FXML
	private Label ip_address;
	@FXML
	private VBox pnItems = null;
	@FXML
	private Button btnDashboard;

	@FXML
	private Button btnOptions;

	@FXML
	private Button btnExit;

	@FXML
	private Pane pnlCustomer;

	@FXML
	private Pane pnlOrders;

	@FXML
	private Pane pnlOverview;

	@FXML
	private Pane pnlMenus;

	@FXML
	private Label ll1;
	@FXML
	private Label ll2;
	@FXML
	private Label ll3;
	@FXML
	private Label ll4;
	@FXML
	private Label mac_address;
	@FXML
	private Label network_text;
	@FXML
	private ImageView network_img;
	@FXML
	private ImageView no_network_img;
	@FXML
	private Button btnServers;
	@FXML
	private Button server_add;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ll1.setText("...");
		ll2.setText("...");
		ll3.setText("...");
		ll4.setText("...");
		server_add.setVisible(false);
		if (Data.connection) {
			network_text.setText("Подключен");
			network_img.setVisible(true);
			no_network_img.setVisible(false);
		} else {
			network_text.setText("Не подключен");
			network_img.setVisible(false);
			no_network_img.setVisible(true);
		}
		try {
			ip_address.setText(Data.getIP());
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			mac_address.setText(Data.getMac());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Node[] nodes = new Node[10];
		for (int i = 0; i < nodes.length; i++) {
			try {

				final int j = i;
				nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

				nodes[i].setOnMouseEntered(event -> {
					nodes[j].setStyle("-fx-background-color : #0A0E3F");
				});
				nodes[i].setOnMouseExited(event -> {
					nodes[j].setStyle("-fx-background-color : #02030A");
				});
				pnItems.getChildren().add(nodes[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		new XThreads(() -> {
			ll1.setText(Data.speed_value + "");
			ll2.setText(Data.upload_value + "");
			ll3.setText(Data.ping + "");
			//ll4.setText(Data.locals + "");
			ll4.setText("0");
			if (Data.connection) {
				network_text.setText("Подключен");
				network_img.setVisible(true);
				no_network_img.setVisible(false);
			} else {
				network_text.setText("Не подключен");
				network_img.setVisible(false);
				no_network_img.setVisible(true);
			}
		});
	}

	public void handleClicks(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnOptions) {
			Data.bred = 0;
			pnlCustomer.setStyle("-fx-background-color : #1620A1");
			pnlCustomer.toFront();
		}
		if (actionEvent.getSource() == btnDashboard) {
			Data.bred = 0;
			server_add.setVisible(false);
			pnItems.getChildren().removeAll(pnItems.getChildren());
			Node[] nodes = new Node[10];
			for (int i = 0; i < nodes.length; i++) {
				try {

					final int j = i;
					nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

					nodes[i].setOnMouseEntered(event -> {
						nodes[j].setStyle("-fx-background-color : #0A0E3F");
					});
					nodes[i].setOnMouseExited(event -> {
						nodes[j].setStyle("-fx-background-color : #02030A");
					});
					pnItems.getChildren().add(nodes[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			pnlOverview.setStyle("-fx-background-color : #02030A");
			pnlOverview.toFront();
		}
		if (actionEvent.getSource() == btnServers) {
			server_add.setVisible(true);
			Data.servers.put(0, "Google:10.10.10.10");
			Data.servers.put(1, "Yandex:10.10.10.10");
			Node[] nodes = new Node[Data.servers.size()];
			pnItems.getChildren().removeAll(pnItems.getChildren());

			for (int i = 0; i < nodes.length; i++) {
				try {

					final int j = i;
					nodes[i] = FXMLLoader.load(getClass().getResource("servers.fxml"));
					
					nodes[i].setOnMouseEntered(event -> {
						nodes[j].setStyle("-fx-background-color : #0A0E3F");
					});
					nodes[i].setOnMouseExited(event -> {
						nodes[j].setStyle("-fx-background-color : #02030A");
					});
					pnItems.getChildren().add(nodes[i]);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			pnlOverview.setStyle("-fx-background-color : #02030A");
			pnlOverview.toFront();
		}
		
		if(actionEvent.getSource() == server_add) {
			Data.bred = 0;
			pnItems.getChildren().removeAll(pnItems.getChildren());
			Node[] nodes = new Node[1];
			for (int i = 0; i < nodes.length; i++) {
				try {

					final int j = i;
					nodes[i] = FXMLLoader.load(getClass().getResource("add_servers.fxml"));

					nodes[i].setOnMouseEntered(event -> {
						nodes[j].setStyle("-fx-background-color : #0A0E3F");
					});
					nodes[i].setOnMouseExited(event -> {
						nodes[j].setStyle("-fx-background-color : #02030A");
					});
					pnItems.getChildren().add(nodes[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			pnlOverview.setStyle("-fx-background-color : #02030A");
			pnlOverview.toFront();
			System.out.println("add");
		}
		
		if (actionEvent.getSource() == btnExit) {
			System.exit(1);
			System.out.println("exit");
		}
	}
}