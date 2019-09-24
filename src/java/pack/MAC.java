/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author David-Pc
 */
public class MAC 
{
    Pattern macpt = null;

private String getMac(String ip) {

    // Find OS and set command according to OS
    String OS = System.getProperty("os.name").toLowerCase();

    String[] cmd;
    if (OS.contains("win")) {
        // Windows
        macpt = Pattern
                .compile("[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+");
        String[] a = { "arp", "-a", ip };
        cmd = a;
    } else {
        // Mac OS X, Linux
        macpt = Pattern
                .compile("[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+");
        String[] a = { "arp", ip };
        cmd = a;
    }

    try {
        // Run command
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
        // read output with BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        String line = reader.readLine();

        // Loop trough lines
        while (line != null) {
            Matcher m = macpt.matcher(line);

            // when Matcher finds a Line then return it as result
            if (m.find()) {
                System.out.println("Found");
                System.out.println("MAC: " + m.group(0));
                return m.group(0);
            }

            line = reader.readLine();
        }

    } catch (IOException e1) {
        e1.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Return empty string if no MAC is found
    return "";
}
public static void main(String args[]) throws Exception
{
    MAC ss=new MAC();
    ss.getMac("192.168.1.15");
    System.out.println(ss.getMac("192.168.1.15"));
    System.out.println(ss.getMacAddress());
}

public String getMacAddress() throws Exception 
{
    String macAddress = null;
    String command = "ifconfig";

    String osName = System.getProperty("os.name");
    System.out.println("Operating System is " + osName);

    if (osName.startsWith("Windows")) {
        command = "ipconfig /all";
    } else if (osName.startsWith("Linux") || osName.startsWith("Mac") || osName.startsWith("HP-UX")
            || osName.startsWith("NeXTStep") || osName.startsWith("Solaris") || osName.startsWith("SunOS")
            || osName.startsWith("FreeBSD") || osName.startsWith("NetBSD")) {
        command = "ifconfig -a";
    } else if (osName.startsWith("OpenBSD")) {
        command = "netstat -in";
    } else if (osName.startsWith("IRIX") || osName.startsWith("AIX") || osName.startsWith("Tru64")) {
        command = "netstat -ia";
    } else if (osName.startsWith("Caldera") || osName.startsWith("UnixWare") || osName.startsWith("OpenUNIX")) {
        command = "ndstat";
    } else {// Note: Unsupported system.
        throw new Exception("The current operating system '" + osName + "' is not supported.");
    }

    Process pid = Runtime.getRuntime().exec(command);
    BufferedReader in = new BufferedReader(new InputStreamReader(pid.getInputStream()));
    Pattern p = Pattern.compile("([\\w]{1,2}(-|:)){5}[\\w]{1,2}");
    while (true) {
        String line = in.readLine();
        System.out.println("line " + line);
        if (line == null)
            break;

        Matcher m = p.matcher(line);
        if (m.find()) {
            macAddress = m.group();
            break;
        }
    }
    in.close();
    return macAddress;
}

}
