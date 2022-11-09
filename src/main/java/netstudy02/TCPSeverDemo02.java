package netstudy02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//文件上传服务端
public class TCPSeverDemo02 {
    public static void main(String[] args) throws Exception {
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.监听客户端连接
        Socket accept = serverSocket.accept();//阻塞式监听，会一直等待传输
        //3.获取输入流
        InputStream is = accept.getInputStream();

        //4.文件输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("accive.doc"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len=is.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }

        //通知客户端接收完毕，可以断开
        OutputStream os = accept.getOutputStream();
        os.write("我接收完毕，可以断开了！".getBytes());

        os.close();
        fileOutputStream.close();
        is.close();
        accept.close();
        serverSocket.close();
    }
}
