/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import static android.content.ContentValues.*;
import static android.content.Context.*;
import android.net.wifi.*;
import android.net.*;
import android.util.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

/**
 *
 * @author David-Pc
 */
public class Test 
{
    public static String getMobileIPAddress() {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) 
                    {
                        return  addr.getHostAddress();
                    }
                }
            }
        } catch (Exception ex) { } // for now eat exceptions
        return "";
    }
    public static void main(String[] args) 
    {
        System.out.println(getMobileIPAddress());
    }
}
