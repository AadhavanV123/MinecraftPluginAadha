package com.aadha.serverplugins;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class RankListener  implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        if (!e.getPlayer().hasPlayedBefore()){

            ServerPlugins.getFileManager().setRank(e.getPlayer(), Rank.DEFAULT);

        }

    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player player = e.getPlayer();
        Rank rank = ServerPlugins.getFileManager().getRank(player);

        for (Player onlinePlayer : e.getRecipients()) {
            onlinePlayer.sendMessage(rank.getColor() + "[" + rank.getName() + "]" + " " + player.getName() + ": " + e.getMessage());
        }

        e.setCancelled(true);

    }

}
