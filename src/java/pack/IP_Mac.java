/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * @author David-Pc
 */
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class IP_Mac{
	
   public static void main(String[] args) throws UnknownHostException
   {
       System.out.println(InetAddress.getLocalHost().getHostAddress());
   }		
   public String getMac()
   {
        InetAddress ip;
        StringBuilder sb = new StringBuilder();
	try 
        {
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		System.out.print("Current MAC address : ");
		
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));		
		}
		System.out.println(sb.toString());
			
	} catch (UnknownHostException | SocketException e) {
            System.out.println(e);
	}
        return sb.toString();
   }

}
