package com.yufeng.netty.chat;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/19.
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String>
{
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 当客户端注册到服务端完成就会出发该方法
     * @param ctx
     * @throws Exception
     */
    @Override
    //public void channelRegistered(ChannelHandlerContext ctx) throws Exception
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        Channel channel = ctx.channel();
        String str = channel.remoteAddress() + " 上线了 " + format.format(new Date());
        channelGroup.writeAndFlush("[客户端]" + str);
        channelGroup.add(channel);
        System.out.println(str);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception
    {
        Channel channel = ctx.channel(); //获取当前的
        channelGroup.forEach(ch -> {
            if(channel != ch) {
                //不是当前的channel, 转发消息
                ch.writeAndFlush("[ 客户端 ] " + ch.remoteAddress() + " 发送消息: " + msg
                        + format.format(new Date()));
            }
            else {
                ch.writeAndFlush("[ 自己 ]发送了消息: " + msg + format.format(new Date()));
            }
        });
    }

    @Override
    //public void channelUnregistered(ChannelHandlerContext ctx) throws Exception
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        String str = ctx.channel().remoteAddress() + " 下线了 " + format.format(new Date());
        System.out.println(str);
        System.out.println("channelGroup.size():" + channelGroup.size());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        ctx.close();
    }
}
