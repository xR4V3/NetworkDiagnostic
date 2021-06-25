package ru.xrave.checker.utils;

import javafx.application.Platform;
import ru.xrave.checker.connections.Connection;

public class XThreads extends Thread {

	final Runnable onStopTask;

	public XThreads(Runnable onStopTask) {
		this.onStopTask = onStopTask;
		start();
	}

	@Override
	public void run() {
		while (true) {
			Data.connection = Connection.netIsAvailable();

			try {
				System.out.println("Получаем значения");
				sleep(10000);
			} catch (Exception e) {

			}

			Platform.runLater(onStopTask);
			System.out.println(Data.speed_value + "");
			System.out.println(Data.upload_value + "");
			System.out.println(Data.ping + "");
			System.out.println(Data.connection + "");
			// System.out.println(Data.locals.size() + "");
			try {
				sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}