package ru.xrave.checker.utils;

import java.io.IOException;
import org.icmp4j.IcmpPingRequest;
import org.icmp4j.IcmpPingResponse;
import org.icmp4j.IcmpPingUtil;

public class PingPong {

	public static long ping() throws IOException, InterruptedException {
		final IcmpPingRequest request = IcmpPingUtil.createIcmpPingRequest();

		request.setHost("speedtest.tele2.net");

		final IcmpPingResponse response = IcmpPingUtil.executePingRequest(request);
		System.out.println("ping: " + response.getDuration());

		return response.getDuration();
	}

}
