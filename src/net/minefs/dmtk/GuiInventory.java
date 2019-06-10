package net.minefs.dmtk;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class GuiInventory implements InventoryHolder {
	private Inventory inv;
	GuiItemStack[] actions;

	public GuiInventory(int size, String title) {
		inv = Bukkit.createInventory(this, size, title);
		actions = new GuiItemStack[size];
	}

	@Override
	public Inventory getInventory() {
		return inv;
	}

	public void setItem(int slot, GuiItemStack item) {
		if (slot >= inv.getSize())
			return;
		inv.setItem(slot, item.getItem());
		actions[slot] = item;
	}

	public void onClick(InventoryClickEvent e) {
//		e.getWhoClicked().sendMessage("a");
		GuiItemStack i = actions[e.getSlot()];
		if (i != null)
			i.onClick(e);
		else
			e.getWhoClicked().sendMessage("null " + e.getSlot());
	}
}
