package ru.xrave.checker;

import java.io.IOException;

import ru.xrave.analyzer.LocalChecker;
import ru.xrave.checker.connections.Connection;
import ru.xrave.checker.speedtest.Speed;
import ru.xrave.checker.utils.Data;
import ru.xrave.checker.utils.PingPong;
import ru.xrave.checker.utils.Utils;

public class Main {
	
	static {
		Utils.registerSpeedListener();
		LocalChecker alocal = new LocalChecker();
		Speed.onDownload();
		Speed.onUpload();
		try {
			Data.ping = (int) PingPong.ping();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		alocal.start();
		Data.connection = Connection.netIsAvailable();
	}
	
}
