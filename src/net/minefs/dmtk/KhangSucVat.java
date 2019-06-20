package net.minefs.dmtk;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KhangSucVat extends GuiInventory {

	List<TestObject> list = new ArrayList<TestObject>();
	int page;

	public KhangSucVat(int page) {
		super(54, "Test");
		this.page = page;
		for (int i = 0; i < 160; i++) {
			TestObject obj = new TestObject("Item #" + (i + 1));
			list.add(obj);
		}
		int slot = 0;
		// start: 0, end: 45
		for (int i = 45 * page; i < 45 * (page + 1); i++) {
			if (i >= list.size())
				break;
			TestObject obj = list.get(i);
			GuiItemStack item = new GuiItemStack(Material.PAPER, obj.name);
			setItem(slot++, item);
		}
		if (page > 0) {
			GuiItemStack prev = new GuiItemStack(Material.APPLE, "Trang trước") {
				@Override
				public void onClick(InventoryClickEvent e) {
					e.getWhoClicked().openInventory(new KhangSucVat(page - 1).getInventory());
				}
			};
			setItem(45, prev);
		}
		if (page < list.size() / 45) {
			GuiItemStack next = new GuiItemStack(Material.APPLE, "Trang kế") {
				@Override
				public void onClick(InventoryClickEvent e) {
					e.getWhoClicked().openInventory(new KhangSucVat(page + 1).getInventory());
				}
			};
			setItem(53, next);
		}
	}

	class TestObject {
		public String name;

		public TestObject(String name) {
			this.name = name;
		}
	}
	
	class ItemCuaTui extends GuiItemStack {

		public ItemCuaTui(Material material) {
			super(material);
			// TODO Auto-generated constructor stub
		}
		
		
	}
}
