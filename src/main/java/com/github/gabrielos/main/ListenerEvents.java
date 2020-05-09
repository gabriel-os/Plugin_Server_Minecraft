package com.github.gabrielos.main;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ListenerEvents implements Listener{
	@EventHandler
	public void onDamageEvent(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() instanceof LivingEntity) {
			
			LivingEntity entidade = ((LivingEntity) e.getEntity());
			
			if(e.getDamager()!= null) {
				
				if (e.getDamager() instanceof Player) {
					
					Player player = (Player)e.getDamager();
					
					player.sendMessage("Pimba: " + (entidade.getHealth()-e.getDamage()));					
				}

			}

		}
	}
}
