package netstudy04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class netStudyUrl {
    public static void main(String[] args) throws IOException {
        //获取一个url资源
        URL url = new URL
                ("https://dl.stream.qqmusic.qq.com/RS020647JhcU1kN0iF.mp3?guid=8856545238&vkey=63B7D45D637B33D393F8DAD52B93FA1A113D9B3FBB4B173CBA7310D7612D2CF201F8A9A034CB44716354E3E7A7A2398321DC640F3C1BCA38&uin=&fromtag=120002");

        /**
         * 下载一个网络文件
         */
        //1.连接到这个http资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        //获取输入流
        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream("rq1.m4a");

        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes))!= -1){
            fileOutputStream.write(bytes,0,len);//写出这个数据
        }

        fileOutputStream.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
