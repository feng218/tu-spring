package com.yufeng.netty.base;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by Administrator on 2019/12/19.
 */
public class NettyServer
{
    public static void main(String[] args)
    {
        /* new NioEventLoopGroup() 的子线程(事件循环线程)的个数默认为CPU的两倍 */

        //bossGroup线程组用于处理客户端的accept事件, 与client建立关系, 生成NioSocketChannel
        // 并将NioSocketChannel注册到worker
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1); //一主多从模式

        //轮询注册到自己selector上的所有NioSocketChannel的读写事件,
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        /* 一个 Netty 应用通常由一个 Bootstrap 开始，主要作用是配置整个 Netty 程序，
            串联各个组件，Netty 中 Bootstrap 类是客户端程序的启动引导类，
            ServerBootstrap 是服务端启动引导类 */
        //创建服务器端的启动对象
        ServerBootstrap bootStrap = new ServerBootstrap();
        bootStrap.group(bossGroup, workerGroup)     //设置两个线程组

                //使用NioServerSocketChannel作为服务器的通道
                .channel(NioServerSocketChannel.class)

                /*初始化服务器连接队列大小，服务端处理客户端连接请求是顺序处理的,所以同一时间只能处理一
                个客户端连接。多个客户端同时来的时候,服务端将不能处理的客户端连接请求放在队列中等待处理*/
                //TCP内核 内维护了两个队列，称为A队列和B 队列, 如果A+B的长度大于Backlog时，新的连接就会呗TCP内核拒绝掉
                .option(ChannelOption.SO_BACKLOG, 1024)

                .childHandler(new ChannelInitializer<SocketChannel>() { //创建通道初始化对象，设置初始化参数
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //对workerGroup的SocketChannel设置处理器
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });

        System.out.println("netty server start...");
        //绑定一个端口并且同步, 生成了一个ChannelFuture异步对象，通过isDone()等方法可以判断异步事件的执行情况
        //启动服务器(并绑定端口)，bind是异步操作，sync方法是等待异步操作执行完毕
        try
        {
            ChannelFuture cf = bootStrap.bind(9000).sync();
            //给cf注册监听器，监听我们关心的事件
            /*cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (cf.isSuccess()) {
                        System.out.println("监听端口9000成功");
                    } else {
                        System.out.println("监听端口9000失败");
                    }
                }
            });*/

            //对通道关闭进行监听，closeFuture是异步操作，监听通道关闭
            // 通过sync方法同步等待通道关闭处理完毕，这里会阻塞等待通道关闭完成
            cf.channel().closeFuture().sync();
        }
        catch(InterruptedException e)
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
