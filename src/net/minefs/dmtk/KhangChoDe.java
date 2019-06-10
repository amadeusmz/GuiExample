package net.minefs.dmtk;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KhangChoDe extends GuiInventory {
	public KhangChoDe() {
		super(9, "Hypixel tuoi lon");
		GuiItemStack item = new GuiItemStack(Material.APPLE) {
			@Override
			public void onClick(InventoryClickEvent e) {
				Player p = (Player) e.getWhoClicked();
				p.closeInventory();
				p.sendTitle("§c§lCÚC CU", "", 3, 60, 3);
			}
		};
		setItem(0, item);
	}
}
