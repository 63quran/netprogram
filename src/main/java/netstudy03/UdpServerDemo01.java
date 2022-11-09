package netstudy03;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//等待客户端的连接
public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        //接收包（阻塞接收）
        datagramSocket.receive(datagramPacket);

        System.out.println(datagramPacket.getAddress());
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

        //关闭流
        datagramSocket.close();


    }
}
