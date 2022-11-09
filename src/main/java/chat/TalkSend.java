package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
    DatagramSocket datagramSocket = null;
    BufferedReader bufferedReader = null;

    private String toIp;
    private int toPort;
    private int fromPort;

    public TalkSend(String toIp, int toPort, int fromPort) {
        this.toIp = toIp;
        this.toPort = toPort;
        this.fromPort = fromPort;
        try {
            datagramSocket = new DatagramSocket(fromPort);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        //控制台读取System.in
        while (true){
            try {
                //读取控制台一行的数据
                String data = bufferedReader.readLine();
                DatagramPacket packet = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, new InetSocketAddress(this.toIp, this.toPort));
                //发送包
                datagramSocket.send(packet);
                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }
}
