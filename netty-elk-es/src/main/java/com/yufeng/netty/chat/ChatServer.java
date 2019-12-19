package com.yufeng.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * Created by Administrator on 2019/12/19.
 */
public class ChatServer
{
    public static void main(String[] args)
    {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    /*@Override
                    protected void initChannel(Channel ch) throws Exception
                    {
                     ch.pipeline().addLast(new ChatServerHandler());
                    }*/
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception
                    {
                        ch.pipeline().addLast(new ChatServerHandler());
                    }
                });

        try
        {
            System.out.println("聊天室Server启动成功...");
            //启动服务端
            ChannelFuture channelFuture = serverBootstrap.bind(9000).sync();

            //对通道关闭进行监听，closeFuture是异步操作，监听通道关闭
            channelFuture.channel().closeFuture().sync();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
