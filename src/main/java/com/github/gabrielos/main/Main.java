package com.github.gabrielos.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
    public void onEnable() {
		this.getCommand("create").setExecutor(new Comandos());
		this.getCommand("dead").setExecutor(new Comandos());
		getServer().getPluginManager().registerEvents(new ListenerEvents(), this);;
		System.out.println("Esse é o enable 2.0");
	}
	@Override
	public void onDisable() {
		System.out.println("Console do Minecraft 2.0");
	}
	

}
