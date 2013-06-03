package com.chaseoes.tf2bot;

import jerklib.events.ChannelMsgEvent;

import java.util.HashMap;

public class CommandManager {

    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public void handleMessageEvent(ChannelMsgEvent event) {
        String message = event.getMessage();
        if (message.startsWith(".")) {
            String[] messSplit = message.split(" ");
            String command = messSplit[0].substring(1);
            String[] args = new String[messSplit.length - 1];
            System.arraycopy(messSplit, 1, args, 0, args.length);
            CommandSender sender = new CommandSender(event.getNick());
            Command cmd = commands.get(command);
            if (cmd != null) {
                cmd.onCommand(sender, args);
            }
        }
    }

    public void register(String command, Command cmd) {
        if (!commands.containsKey(command)) {
            commands.put(command, cmd);
        }
    }
}
