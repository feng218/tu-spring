package com.yufeng.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

/**
 * Created by Administrator on 2019/12/19.
 */
public class ChatClient
{
    public static void main(String[] args)
    {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ChatClientHandler());
                    }
                });

        try
        {
            //启动客户端去连接服务端
            ChannelFuture cf = bootstrap.connect("localhost", 9000).sync();

            System.out.println("========" + cf.channel().localAddress() + "=========");
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()) {
                String str = scanner.nextLine();
                //System.out.println("[ 自己 ]发送了消息: " + str);
                cf.channel().writeAndFlush(str);
            }
            cf.channel().closeFuture().sync();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            group.shutdownGracefully();
        }
    }
}
