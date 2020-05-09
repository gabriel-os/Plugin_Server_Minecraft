package com.github.gabrielos.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Comandos implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			
		String cmd = command.getName();		
		
		if(cmd.equalsIgnoreCase("dead")) {

			if(sender instanceof Player == false) {
				sender.sendMessage("Apenas players podem usar meo");
				return true;
			}
			
			Player player = (Player) sender;
			
			for(Entity e :player.getWorld().getEntities()) {
				if (e instanceof LivingEntity) {
					  ((org.bukkit.entity.LivingEntity)e).setHealth(0);
					}
			}
			
		}
		
		if (cmd.equalsIgnoreCase("create")) {
			
			if(sender instanceof Player == false) {
				sender.sendMessage("Apenas players podem usar meo");
				return true;
			}
			
			Player player = (Player) sender;
			
			if (args.length == 2) {
				
				
				if(!isNumber(args[1])) {
					player.sendMessage(ChatColor.AQUA+"Ixi, tem que ser número a quantidade mané");
					
					return true;
				}
				int qntd = Integer.parseInt(args[1]);
				int i;
				
				if(args[0].equalsIgnoreCase("galinha")) {
					if(qntd>100) {
						
						return false;
					}
					for(i=0;i<qntd;i++) {
						player.getWorld().spawnEntity(player.getLocation(), EntityType.CHICKEN);
					}
					Bukkit.broadcastMessage(ChatColor.RED+player.getName()+": Spawnou Galinha");
				}else {
					player.sendMessage(ChatColor.DARK_BLUE+"Ixi, não entendi o animal.Tente novamente");
				}
			}else {
				player.sendMessage(ChatColor.BLUE+"Ixi, não entendi.Tente novamente");
				player.sendMessage(ChatColor.BLUE+"Usa assim carai: /create <entity>");
				
			}
		return true;
		}
		
		return false;
	}

	public boolean isNumber (String num) {
		try {
			Integer.parseInt(num);
			
			return true;
		}catch(Exception e) {return false;}
	} 
}

