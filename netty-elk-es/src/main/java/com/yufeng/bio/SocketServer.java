package com.yufeng.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2019/12/16.
 */
public class SocketServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接。。");
            Socket socket = serverSocket.accept(); //阻塞方法, 等待客户端去连接
            System.out.println("有客户端连接了。。");
            System.out.println();
            /*
            //多线程
            new Thread(() -> {
                try {
                    handler(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();*/

            //单线程
            try {
                handler(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handler(Socket socket) throws IOException {
        System.out.println("thread id = " + Thread.currentThread().getId());
        byte[] bytes = new byte[1024];
        System.out.println("准备read。。");

        //接收客户端的数据，阻塞方法，没有数据可读时就阻塞
        int len = socket.getInputStream().read(bytes);
        System.out.println("read完毕。。");
        if (len != -1) {
            System.out.println("接收到客户端的数据：" + new String(bytes, 0, len));
            System.out.println("thread id = " + Thread.currentThread().getId());

        }
        socket.getOutputStream().write("HelloClient".getBytes());
        socket.getOutputStream().flush();
    }
}
