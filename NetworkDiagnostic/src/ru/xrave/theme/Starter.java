package ru.xrave.theme;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.xrave.checker.Main;
import ru.xrave.checker.ethernet.EthernetCable;

public class Starter extends Application {

	@Override
	public void init() {

	}

	private double x, y;

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }

	@Override
	public void stop() {
		System.exit(0);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println(EthernetCable.isPlug());
		new Main();
		launch(args);
	}

}