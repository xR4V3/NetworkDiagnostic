package ru.xrave.checker.utils;

import fr.bmartel.speedtest.SpeedTestReport;
import fr.bmartel.speedtest.inter.ISpeedTestListener;
import fr.bmartel.speedtest.model.SpeedTestError;

public class Utils implements ISpeedTest {

	private static int a;

	public static void registerSpeedListener() {
		// Регистрируем слушателя либы SpeedTest
		speedTestSocket.addSpeedTestListener(new ISpeedTestListener() {

			@Override
			public void onCompletion(SpeedTestReport report) {
				// Вывод результата теста

				// GaugeController.setDonwloadValue((int) convert(report.getTransferRateBit() +
				// ""));
				if (a == 0) {
					Data.speed_value = convert(report.getTransferRateBit() + "");
					a = 1;
				} else if (a == 1) {
					Data.upload_value = convert(report.getTransferRateBit() + "");
					a = 0;
				}

				System.out.println("[ТЕСТ] скорость в Mbit/s   : " + convert(report.getTransferRateBit() + ""));
			}

			@Override
			public void onError(SpeedTestError speedTestError, String errorMessage) {
				// Вывод ошибок во время теста
				System.out.println(errorMessage);
			}

			@Override
			public void onProgress(float percent, SpeedTestReport report) {

			}
		});
	}

	public static int convert(String string) {
		int s = (int) (Float.parseFloat(string) / 1000000);
		return s;
	}
}
