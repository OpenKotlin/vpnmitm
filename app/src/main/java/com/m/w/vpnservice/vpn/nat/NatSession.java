package com.m.w.vpnservice.vpn.nat;

import com.m.w.vpnservice.vpn.tcpip.CommonMethods;

/**
 * Created by zengzheying on 15/12/29.
 */
public class NatSession {

	public int RemoteIP;
	public short RemotePort;
	public String RemoteHost;
	public int BytesSent;
	public int PacketSent;
	public long LastNanoTime;
	public boolean IsHttpsSession;
	public String RequestUrl; //HTTP请求的url， HTTPS请求则为空
	public String Method; //HTTP请求方法

	@Override
	public String toString() {
		return String.format("远程地址:%s/远程IP:%s, 远程端口:%d packet: %d", RemoteHost, CommonMethods.ipIntToString(RemoteIP),
				RemotePort & 0xFFFF, PacketSent);
	}
}
