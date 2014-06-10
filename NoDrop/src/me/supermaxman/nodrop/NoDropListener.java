package me.supermaxman.nodrop;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

	
public class NoDropListener implements Listener {
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		ItemStack i = e.getItemDrop().getItemStack();
		if (NoDrop.items.containsKey(i.getTypeId())) {
			int b = NoDrop.items.get(i.getTypeId());
			byte d = (byte) b;
			if(d == i.getData().getData()) {
				e.setCancelled(true);
			}
		}
	}
	
	
}
