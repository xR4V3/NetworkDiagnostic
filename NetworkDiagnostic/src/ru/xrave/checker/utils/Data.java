package ru.xrave.checker.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

public class Data {

	public static int speed_value = 0;
	
	public static int upload_value = 0;
	
	public static int ping = 0;
	
	public static int bred = 0;
	
	public static boolean connection = false;
	
	public static List<String> locals;
	
	public static HashMap<Integer,String> servers = new HashMap<Integer, String>();

	public static String getIP() throws UnknownHostException {
		return Inet4Address.getLocalHost().getHostAddress();
	}

	public static String getMac() throws UnknownHostException, SocketException {
		InetAddress ipAddress = InetAddress.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ipAddress);
		byte[] macAddressBytes = networkInterface.getHardwareAddress();
		StringBuilder macAddressBuilder = new StringBuilder();

		for (int macAddressByteIndex = 0; macAddressByteIndex < macAddressBytes.length; macAddressByteIndex++) {
			String macAddressHexByte = String.format("%02X", macAddressBytes[macAddressByteIndex]);
			macAddressBuilder.append(macAddressHexByte);

			if (macAddressByteIndex != macAddressBytes.length - 1) {
				macAddressBuilder.append(":");
			}
		}

		return macAddressBuilder.toString();
	}
}
