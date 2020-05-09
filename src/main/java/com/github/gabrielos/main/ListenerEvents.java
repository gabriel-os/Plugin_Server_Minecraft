package com.github.gabrielos.main;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ListenerEvents implements Listener{
	@EventHandler
	public void onDamageEvent(EntityDamageByEntityEvent e) {
		System.out.println("1");
		if(e.getEntity() instanceof LivingEntity) {
			System.out.println("2");
			LivingEntity entidade = ((LivingEntity) e.getEntity());
			
			if(e.getDamager()!= null) {
				System.out.println("3");
				if (e.getDamager() instanceof Player) {
					System.out.println("4");
					Player player = (Player)e.getDamager();
					
					player.sendMessage("Pimba: " + (entidade.getHealth()-e.getDamage()));					
				}

			}

		}
	}
}
