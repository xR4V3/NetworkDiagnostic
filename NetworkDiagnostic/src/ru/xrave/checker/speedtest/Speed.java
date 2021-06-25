package ru.xrave.checker.speedtest;

import fr.bmartel.speedtest.utils.SpeedTestUtils;
import ru.xrave.checker.utils.ISpeedTest;

public class Speed implements ISpeedTest{

	public static void onDownload() {
		
	    speedTestSocket.startFixedDownload("ftp://speedtest.tele2.net/100MB.zip", 10000);
		//speedTestSocket.startFixedDownload("ftp://speedtest.tele2.net/100MB.zip", 10000);
	}

	public static  void onUpload() {
		String fileName = SpeedTestUtils.generateFileName() + ".txt";
		speedTestSocket.startFixedUpload("ftp://speedtest.tele2.net/upload/" + fileName, 10000000, 10000);
	}

}
