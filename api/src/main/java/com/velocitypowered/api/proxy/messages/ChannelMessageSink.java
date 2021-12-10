package com.velocitypowered.api.proxy.messages;

/**
 * Represents something that can be sent plugin messages.
 */
public interface ChannelMessageSink {

  /**
   * Sends a plugin message to this target.
   *
   * @param identifier the channel identifier to send the message on
   * @param data the data to send
   * @return whether or not the message could be sent
   */
  boolean sendPluginMessage(ChannelIdentifier identifier, byte[] data);
}
