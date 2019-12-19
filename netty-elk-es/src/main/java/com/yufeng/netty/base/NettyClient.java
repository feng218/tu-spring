package com.yufeng.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by Administrator on 2019/12/19.
 */
public class NettyClient
{
    public static void main(String[] args)
    {
        //客户端需要一个事件循环组
        NioEventLoopGroup group = new NioEventLoopGroup();

        //创建客户端启动对象
        //注意客户端使用的不是 ServerBootstrap 而是 Bootstrap
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)  //使用NioSocketChannel作为客户端的通道实现
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //加入处理器
                        ch.pipeline().addLast(new NettyClientHandler());
                    }
                });

        System.out.println("client start...");
        try
        {
            //启动客户端, 连接到服务端
            ChannelFuture channelFuture = bootstrap.connect("localhost", 9000).sync();

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            group.shutdownGracefully();
        }
    }
}
