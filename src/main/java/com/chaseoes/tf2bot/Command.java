package com.chaseoes.tf2bot;

public abstract class Command {

    public abstract void onCommand(CommandSender sender, String[] args);

    public void say(String message) {
        BotMain.getInstance().getChannel().say(message);
    }
}
