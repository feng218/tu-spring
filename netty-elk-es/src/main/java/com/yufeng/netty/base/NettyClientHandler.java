package com.yufeng.netty.base;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * Created by Administrator on 2019/12/19.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter
{
    /**
     * 当客户端连接服务器完成就会触发该方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello Server", CharsetUtil.UTF_8);
        ctx.writeAndFlush(byteBuf);

        /* --------错误的代码------, Client启动之后不工作
        byte[] bytes = "Hello Server".getBytes(CharsetUtil.UTF_8);
        ctx.writeAndFlush(bytes);*/
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("收到服务端的消息: " + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("服务端的地址:" + ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        ctx.close();
    }
}
