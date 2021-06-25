package ru.xrave.analyzer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import ru.xrave.checker.utils.Data;

public class LocalChecker extends Thread
{

	
	public void run() {
		
		InetAddress localhost = null;
		try {
			localhost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    byte[] ip = localhost.getAddress();

	    for (int i = 1; i <= 254; i++)
	    {
	        ip[3] = (byte)i;
	        InetAddress address = null;
			try {
				address = InetAddress.getByAddress(ip);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    try {
			if (address.isReachable(1000))
			{
				if(!address.toString().contains("127")) {
					for(String s : Data.locals) {
						if(!s.contains(address.toString())) {
							Data.locals.add(address.toString());
						}
					}
			    System.out.println(address + " машина включена и ее можно пинговать");
				}
			}
			else if (!address.getHostAddress().equals(address.getHostName()))
			{
			    System.out.println(address + " машина известна в поиске DNS");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    }
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}