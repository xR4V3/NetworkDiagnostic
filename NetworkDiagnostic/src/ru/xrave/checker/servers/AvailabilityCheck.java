package ru.xrave.checker.servers;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.icmp4j.IcmpPingRequest;
import org.icmp4j.IcmpPingResponse;
import org.icmp4j.IcmpPingUtil;

public class AvailabilityCheck {
	private static final int TCP_SERVER_PORT = 80;
	private static boolean connected = false;
	static Socket s;

	public static boolean isAvailability(String SERVER_ADDRESS) {
		boolean available = true;
		try {
			if (connected == false) {
				(s = new Socket(SERVER_ADDRESS, TCP_SERVER_PORT)).close();
			}
		} catch (UnknownHostException e) {
			available = false;
			s = null;
		} catch (IOException e) {
			available = false;
			s = null;
		} catch (NullPointerException e) {
			available = false;
			s = null;
		}

		return available;
	}
	
	public static long ping(String host) throws IOException, InterruptedException {
		final IcmpPingRequest request = IcmpPingUtil.createIcmpPingRequest();

		request.setHost(host);

		final IcmpPingResponse response = IcmpPingUtil.executePingRequest(request);
		System.out.println("ping: " + response.getDuration());

		return response.getDuration();
	}

}
