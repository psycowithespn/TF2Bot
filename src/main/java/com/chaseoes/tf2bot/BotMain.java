package com.chaseoes.tf2bot;

import jerklib.ConnectionManager;
import jerklib.ProfileImpl;
import jerklib.Session;
import jerklib.events.ChannelMsgEvent;

public class BotMain extends Thread {

    ConnectionManager conn;
    Session session;

    public static void main(String[] args) {
        new BotMain().start();
    }

    public void run() {
        conn = new ConnectionManager(new ProfileImpl("TF2", "TF2", null, null));
        session = conn.requestConnection("irc.esper.net");
        session.addIRCEventListener(new EventListener(this));
    }

    public void handleMessage(ChannelMsgEvent event) {
        String message = event.getMessage();
        if (message.startsWith(".")) {
            String command = message.substring(1).split(" ")[0];
            if (command.equalsIgnoreCase("botsnack")) {
                event.getChannel().say("om nom nom nom!");
            }
            if (command.equalsIgnoreCase("latest")) {
                event.getChannel().say("Latest TF2 build: http://ci.chaseoes.com/job/TF2/lastBuild/artifact/target/TF2.jar");
            }
        }
    }
}
