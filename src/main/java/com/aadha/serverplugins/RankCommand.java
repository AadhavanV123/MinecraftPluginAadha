package com.aadha.serverplugins;

import org.apache.commons.lang3.EnumUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;




public class RankCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        Player player = (Player) sender;
        if (player.isOp() || ServerPlugins.getFileManager().getRank(player).equals(Rank.OWNER) || ServerPlugins.getFileManager().getRank(player).equals(Rank.ADMIN)){

            if (args.length == 2){

                if (Bukkit.getOfflinePlayer(args[0]).hasPlayedBefore()) {

                    if (EnumUtils.isValidEnum(Rank.class, args[1].toUpperCase())){

                        ServerPlugins.getFileManager().setRank(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.valueOf(args[1].toUpperCase()));

                        player.getPlayer().sendMessage(ChatColor.GREEN + "You have changed " + player.getName() + "'s rank!");

                        if (Bukkit.getOfflinePlayer(args[0]).isOnline()) {
                            Bukkit.getOfflinePlayer(args[0]).getPlayer().sendMessage(ChatColor.GREEN + player.getName() + "Just Changed your rank to " + args[1] + "!");



                            //if (ServerPlugins.getFileManager().getRank(player).equals(Rank.OWNER) && player.isOp()){
                            //    player.setOp(true);

                            //    }
                            if (!player.isOp()){

                                player.sendMessage("ok so yea");

                            }
                        }

                    } else {

                        player.sendMessage(ChatColor.DARK_RED + "This Rank Doesn't Exist!");

                    }

                } else {

                    player.sendMessage(ChatColor.DARK_RED + "They have never played before!");

                }

            } else {
                player.sendMessage(ChatColor.DARK_RED + "Invalid Usage!, Try Again!");
            }

        } else {
            player.sendMessage(ChatColor.DARK_RED + "You Do Not Have Permission To Use This Command! ");
        }

        return false;
    }

}
