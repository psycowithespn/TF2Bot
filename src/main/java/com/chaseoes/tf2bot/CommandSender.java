package com.chaseoes.tf2bot;

import com.chaseoes.tf2bot.BotMain;
import jerklib.Channel;
import jerklib.Session;

public class CommandSender {

    String name;

    public CommandSender(String name) {
        this.name = name;
    }

    public void pubSendMessage(String message) {
        BotMain.getInstance().getChannel().say(name + ": " + message);
    }

    public void privSendMessage(String message) {
        BotMain.getInstance().getSession().sayPrivate(name, message);
    }
}
