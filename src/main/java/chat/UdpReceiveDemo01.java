package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//接收端
public class UdpReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(6666);

        //循环接收
        while (true){
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            datagramSocket.receive(packet);

            //控制台打印传输的内容
            String result = new String(packet.getData(), 0, packet.getData().length);
            System.out.println(result);
            if ("bye".equals(result)){
                break;
            }
        }
        datagramSocket.close();
    }
}
