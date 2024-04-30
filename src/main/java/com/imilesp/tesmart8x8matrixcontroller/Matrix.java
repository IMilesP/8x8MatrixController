package com.imilesp.tesmart8x8matrixcontroller;

import org.apache.commons.net.util.SubnetUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Matrix {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * attempts to connect to the matrix at the given address and port
     * @param address e.g. "192.168.5.5"
     * @param port e.g. 5000
     * @return true if successful
     */
    public boolean connect(String address, String port) {
        try {
            socket = new Socket(address, Integer.parseInt(port));
            System.out.println("Connected");

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            return true;
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    /**
     * closes the reader, writer, and socket
     */
    public void disconnect() {
        try {
            out.close();
            in.close();
            socket.close();
            System.out.println("Disconnected");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * calculates all ips within subnet,
     * pings each one to check for a response,
     * attempts to connect on port 5000 (default for matrix),
     * sends a command the matrix would recognize,
     * and checks for the appropriate response
     * @param subnetPlusMask (ex: "192.168.5.0/27")
     */
    public void findMatrix(String subnetPlusMask) {
        SubnetUtils utils = new SubnetUtils(subnetPlusMask);
        String[] allIps = utils.getInfo().getAllAddresses();
        final String[] validIp = new String[1];
        for(String ip: allIps) {
            final String address = ip;
            new Thread(() -> {
                try {
                    InetAddress inetAddress = InetAddress.getByName(address);
                    String output = inetAddress.toString().substring(1);
                    if (inetAddress.isReachable(500)) {
                        System.out.println(output + " is on the network");
                        validIp[0] = output;
                    } else {
                        System.out.println("Not Reachable: " + output);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }).start();
            if(connect(validIp[0], "5000")) {
                break;
            }
        }
    }

    /**
     * sends command to mirror matrix input num to output num (A-1, B-2, etc.)
     * @return true if successful
     */
    public boolean mirrorMatrixIO() {
        try {
            out.println("MT00SW0000NT");
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * sends command to map a single input to all outputs (A-1, B-1, etc.)
     * @param input number of input (e.g. 1, 2, ... 8)
     * @return true if successful
     */
    public boolean mapInputToAllOutputs(String input) {
        try {
            out.println("MT00SW0" + input + "00NT");
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * sends command to map single input to single output (A-2, B-7, etc.)
     * @param input number of input (e.g. 1, 2, ... 8)
     * @param output number of output (e.g. 1, 2, ... 8)
     * @return true if successful
     */
    public boolean mapInputToOutput(String input, String output) {
        try {
            out.println("MT00SW0" + input + "0" + output + "NT");
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * @return string value of the entire matrix config map
     */
    public String reqConfig() {
        char[] cbuff = new char[1];
        char[] cbuf = new char[47];
        try {
            out.println("MT00RD0000NT");
            in.read(cbuff, 0, 1);
            in.read(cbuf, 0, 47);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(cbuff) + String.valueOf(cbuf);
    }

    /**
     * loads a saved config by sending a command to the matrix
     * @param slot num of save slot to load (1-8)
     * @return true if successful
     */
    public boolean loadPreset(String slot) {
        try {
            out.println("MT00RD010" + slot + "NT");
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * saves current matrix config map to a save slot
     * @param slot num of save slot to save to (1-8)
     * @return true if successful
     */
    public boolean savePreset(String slot) {
        try {
            out.println("MT00SV000" + slot + "NT");
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * mutes the device buzzer
     * @return true if successful
     */
    public boolean muteBuzzer() {
        try {
            out.println("MT00BZEN01NT");
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * unmutes the device buzzer
     * @return true if successful
     */
    public boolean unmuteBuzzer() {
        try {
            out.println("MT00BZEN00NT");
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * sends command to device to request the ip address of the device
     * @return string value of the device ip (e.g. "192.168.005.005")
     */
    public String reqAddress() {
        char[] cbuf = new char[15];
        try {
            out.println("IP?");
            in.skip(3);
            in.read(cbuf, 0, 15);
            in.skip(1);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(cbuf);
    }

    /**
     * sends command to device to request the port of the device
     * @return string value of the device port (e.g. "5000")
     */
    public String reqPort() {
        char[] cbuf = new char[5];
        try {
            out.println("PT?");
            in.skip(3);
            in.read(cbuf, 0, 5);
            in.skip(1);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(cbuf);
    }

    /**
     * sends command to device to request the gateway ip address of the device
     * @return string value of the device gateway ip (e.g. "192.168.005.001")
     */
    public String reqGateway() {
        char[] cbuf = new char[15];
        try {
            out.println("GW?");
            in.skip(3);
            in.read(cbuf, 0, 15);
            in.skip(1);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(cbuf);
    }

    /**
     * sends command to device to request the subnet mask of the device
     * @return string value of the device subnet mask (e.g. "255.255.255.000")
     */
    public String reqMask() {
        char[] cbuf = new char[15];
        try {
            out.println("MA?");
            in.skip(3);
            in.read(cbuf, 0, 15);
            in.skip(1);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(cbuf);
    }

    /**
     * sends command to change the ip address of the matrix
     * @param address (e.g. "192.168.5.6")
     * @return "OK" if successful
     */
    public String setAddress(String address) {
        char[] cbuf = new char[2];
        try {
            out.println("IP:" + address + ";");
            in.read(cbuf, 0, 2);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(cbuf);
    }

    /**
     * sends command to change the port of the matrix
     * @param portNum (e.g. "5001")
     * @return "OK" if successful
     */
    public String setPort(String portNum) {
        char[] cbuf = new char[2];
        try {
            out.println("PT:" + portNum + ";");
            in.read(cbuf, 0, 2);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(cbuf);
    }

    /**
     * sends command to change the gateway ip address of the matrix
     * @param gateway (e.g. "192.168.6.1")
     * @return "OK" if successful
     */
    public String setGateway(String gateway) {
        char[] cbuf = new char[2];
        try {
            out.println("GW:" + gateway + ";");
            in.read(cbuf, 0, 2);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(cbuf);
    }

    /**
     * sends command to change the subnet mask of the matrix
     * @param mask (e.g. "255.255.255.128")
     * @return "OK" if successful
     */
    public String setMask(String mask) {
        char[] cbuf = new char[2];
        try {
            out.println("MA:" + mask + ";");
            in.read(cbuf, 0, 2);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(cbuf);
    }
}
