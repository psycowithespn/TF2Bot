package com.chaseoes.tf2bot;

import jerklib.Session;
import jerklib.events.ChannelMsgEvent;
import jerklib.events.IRCEvent;
import jerklib.events.JoinCompleteEvent;
import jerklib.events.listeners.IRCEventListener;

public class EventListener implements IRCEventListener {

    private final BotMain main;

    public EventListener(BotMain main) {
        this.main = main;
    }

    @Override
    public void recieveEvent(IRCEvent ircEvent) {
        if (ircEvent.getType() == IRCEvent.Type.CONNECT_COMPLETE) {
            ircEvent.getSession().joinChannel("#tf2plugin");
        } else if (ircEvent.getType() == IRCEvent.Type.JOIN_COMPLETE) {
            JoinCompleteEvent event  = (JoinCompleteEvent) ircEvent;
            BotMain.getInstance().setChannel(event.getChannel());
        } else if (ircEvent.getType() == IRCEvent.Type.CHANNEL_MESSAGE) {
            ChannelMsgEvent event = (ChannelMsgEvent) ircEvent;
            main.handleMessage(event);
        }
    }
}
