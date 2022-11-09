package netstudy03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//不需要连接服务器
//UDP没有服务端的概念，两头都可以使服务端和客户端
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.建立要给socket
        DatagramSocket datagramSocket = new DatagramSocket();

        //2,建个包
        String msg = "我来发一个包";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        //用DatagramPacket包装：需要参数：数据，数据的长度，要发送给谁（地址和端口号）
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);

        //3.发送包
        datagramSocket.send(datagramPacket);

        //4.关闭流
        datagramSocket.close();

    }
}
