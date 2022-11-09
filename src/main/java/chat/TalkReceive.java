package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
    DatagramSocket datagramSocket = null;

    private int Port;
    private String msgFrom;

    public TalkReceive(int Port, String msgFrom) {
        this.Port = Port;
        this.msgFrom = msgFrom;
        try {
            datagramSocket = new DatagramSocket(Port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        //循环接收
        while (true){
            try {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
                datagramSocket.receive(packet);

                //控制台打印传输的内容
                String result = new String(packet.getData(), 0, packet.getData().length);
                System.out.println(msgFrom + ":" + result);
                if ("bye".equals(result)){
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }
}
