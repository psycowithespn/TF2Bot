package com.chaseoes.tf2bot.commands;

import com.chaseoes.tf2bot.Command;
import com.chaseoes.tf2bot.CommandSender;

public class LatestCommand extends Command {
    @Override
    public void onCommand(CommandSender sender, String[] args) {
        say("Latest TF2 build: http://ci.chaseoes.com/job/TF2/lastBuild/artifact/target/TF2.jar");
    }
}
