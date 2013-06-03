package com.chaseoes.tf2bot.commands;

import com.chaseoes.tf2bot.Command;
import com.chaseoes.tf2bot.CommandSender;

public class BotSnackCommand extends Command {
    @Override
    public void onCommand(CommandSender sender, String[] args) {
        say("om nom nom nom!");
    }
}
