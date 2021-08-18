package com.aadha.serverplugins;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER("Owner", ChatColor.DARK_RED),
    ADMIN("Admin", ChatColor.RED),
    MODERATOR("Mod", ChatColor.DARK_GREEN),
    HELPER("Helper", ChatColor.YELLOW),
    AMAZING("Amazing", ChatColor.BLUE),
    SUPER("Super", ChatColor.LIGHT_PURPLE),
    DEFAULT("Default", ChatColor.GRAY);

    private String name;
    private ChatColor color;

    private Rank(String name, ChatColor color){

        this.name = name;
        this.color = color;

    }


    public String getName() { return name; }
    public ChatColor getColor() { return color; }

}
