package com.yufeng.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Administrator on 2019/12/16.
 */
public class SocketClient
{
    public static void main(String[] args) throws IOException
    {
        //连接到服务端
        Socket socket = new Socket("localhost", 9000);

        //向服务端发送数据
        System.out.println("client, 开始向服务端发送数据");
        socket.getOutputStream().write("HelloServer".getBytes());
        socket.getOutputStream().flush();
        System.out.println("向服务端发送数据结束");

        byte[] bytes = new byte[1024];
        //接收服务端回传的数据(阻塞方法)
        socket.getInputStream().read(bytes);
        System.out.println("接收到服务端的数据：" + new String(bytes));
        socket.close();
    }
}
