package netstudy02;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//文件上传客户端
public class TCPClientDemo02 {
    public static void main(String[] args) throws Exception {
        //1.创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //2.创建一个输出流
        OutputStream outputStream = socket.getOutputStream();
        //3.读取文件
        FileInputStream fileInputStream = new FileInputStream(new File("云智维部门考勤异常审批单-李文豪.doc"));
        //4.写出文件
        byte[] bytes = new byte[1024];
        int len;
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }

        //通知服务器，我已经结束了
        socket.shutdownOutput();//停止输出

        //确定服务器接收完毕，才能断开连接
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

        byte[] bytes1 = new byte[1024];
        int len1;
        while ((len1=is.read(bytes1))!=-1){
            byteOutputStream.write(bytes1,0,len1);
        }
        System.out.println(byteOutputStream.toString());

        //5.关闭资源
        byteOutputStream.close();
        is.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();

    }
}
