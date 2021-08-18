package com.aadha.serverplugins;

import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ServerPlugins extends JavaPlugin {

    private static FileManager fileManager;



    @Override
    public void onEnable() {
        System.out.println("The Server Plugins Have Been Let Out Of Their CAGE!!! MUAHAHA!!");

        fileManager = new FileManager(this);

        Bukkit.getPluginManager().registerEvents(new RankListener(), this);

        getCommand("setrank").setExecutor((new RankCommand()));




    }

    public static FileManager getFileManager() { return fileManager; }

    Map<UUID, PermissionAttachment> perms = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player)sender;

        if (!perms.containsKey(player.getUniqueId())) perms.put(player.getUniqueId(), player.addAttachment(this));
        if (ServerPlugins.getFileManager().getRank(player).equals(Rank.OWNER)){
            perms.get(player.getUniqueId()).setPermission("minecraft.*", true);

        }

        return true;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Well... Looks like you beat me BUT NOT FOR LONG! I WILL COME BACK AGAIN MUAHAHA!!!");
    }
}
