package netstudy02;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TCPSeverDemo01 {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        ByteOutputStream byteOutputStream = null;
        try {
            //1.需要一个地址
            serverSocket = new ServerSocket(9999);
            //2.等待客户端连接过来
             socket = serverSocket.accept();
            //3.读取客户端消息
             in = socket.getInputStream();

            //管道流
             byteOutputStream = new ByteOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len=in.read(buffer)) != -1){
                byteOutputStream.write(buffer,0,len);
            }
            System.out.println(byteOutputStream.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if (byteOutputStream!=null){
                byteOutputStream.close();
            }
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
