package com.velocitypowered.proxy.protocol.netty;

import com.velocitypowered.proxy.protocol.packet.LegacyDisconnect;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.nio.charset.StandardCharsets;

@ChannelHandler.Sharable
public class LegacyPingEncoder extends MessageToByteEncoder<LegacyDisconnect> {

  public static final LegacyPingEncoder INSTANCE = new LegacyPingEncoder();

  private LegacyPingEncoder() {
  }

  @Override
  protected void encode(ChannelHandlerContext ctx, LegacyDisconnect msg, ByteBuf out)
      throws Exception {
    out.writeByte(0xff);
    writeLegacyString(out, msg.getReason());
  }

  private static void writeLegacyString(ByteBuf out, String string) {
    out.writeShort(string.length());
    out.writeCharSequence(string, StandardCharsets.UTF_16BE);
  }
}
