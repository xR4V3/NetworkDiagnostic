package ru.xrave.checker.ethernet;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class EthernetCable {

	public static boolean isPlug() {
		
		Enumeration<NetworkInterface> tempNetInterface = null;
		try {
		    tempNetInterface = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException ex) {
		    ex.printStackTrace();
		}
		ArrayList<NetworkInterface> interfaces = new ArrayList<>(Collections.list(tempNetInterface));
		
		for (NetworkInterface iNet : interfaces) {
		    try {
		        if (iNet.getHardwareAddress() != null) {
		        	if (iNet.getName().contains("eth")) {
		        	    System.out.println("Драйвер ETHERNET найден");
		        	   return iNet.isUp();
		        	}
		        }
		    } catch (SocketException ex) {
		        //TODO handle exception
		    }
		}
		
		return false;
		
	}
	
	
}
