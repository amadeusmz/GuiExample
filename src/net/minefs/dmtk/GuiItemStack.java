package net.minefs.dmtk;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiItemStack {

	private ItemStack item;

	public GuiItemStack(Material material, int amount, short data) {
		item = new ItemStack(material, amount, data);
	}

	public GuiItemStack(Material material, int amount) {
		item = new ItemStack(material, amount);
	}

	public GuiItemStack(Material material) {
		item = new ItemStack(material);
	}

	public GuiItemStack(Material material, String name) {
		item = new ItemStack(material);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		item.setItemMeta(im);
	}

	public void onClick(InventoryClickEvent e) {
	}

	public ItemStack getItem() {
		return item;
	}
}
