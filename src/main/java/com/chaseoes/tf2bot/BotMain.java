package com.chaseoes.tf2bot;

import com.chaseoes.tf2bot.commands.BotSnackCommand;
import com.chaseoes.tf2bot.commands.LatestCommand;
import jerklib.Channel;
import jerklib.ConnectionManager;
import jerklib.ProfileImpl;
import jerklib.Session;
import jerklib.events.ChannelMsgEvent;

public class BotMain extends Thread {

    private static BotMain instance;

    private ConnectionManager conn;
    private Session session;
    private Channel channel;
    private CommandManager mngr = new CommandManager();

    public static void main(String[] args) {
        instance = new BotMain();
        instance.start();
    }

    public static BotMain getInstance() {
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void run() {
        initCommands();
        conn = new ConnectionManager(new ProfileImpl("TF2", "TF2", null, null));
        session = conn.requestConnection("irc.esper.net");
        session.addIRCEventListener(new EventListener(this));
    }

    public void handleMessage(ChannelMsgEvent event) {
        mngr.handleMessageEvent(event);
    }

    public void initCommands() {
        mngr.register("botsnack", new BotSnackCommand());
        mngr.register("latest", new LatestCommand());
    }
}
