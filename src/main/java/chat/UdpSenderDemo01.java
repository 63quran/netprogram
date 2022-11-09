package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

//UDP实现聊天
public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        //控制台读取System.in
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            //读取控制台一行的数据
            String data = bufferedReader.readLine();
            DatagramPacket packet = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, new InetSocketAddress("localhost", 6666));
            //发送包
            datagramSocket.send(packet);
            if (data.equals("bye")){
                break;
            }
        }
        datagramSocket.close();
    }
}
