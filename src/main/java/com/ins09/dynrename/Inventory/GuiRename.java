package com.ins09.dynrename.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiRename implements Listener {
    private final Inventory inv;

    public GuiRename() {
        inv = Bukkit.createInventory(null, 9, "Gui Rename");
    }

    public void initializeItems() {
        inv.addItem(createGuiItem(Material.RED_DYE, "§fColor: §cRED"));
        inv.addItem(createGuiItem(Material.LIME_DYE, "§fColor: §aGREEN"));
    }

    private ItemStack createGuiItem(final Material material, final String name) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);

        return item;
    }

    public void openInventory(HumanEntity ent) {
        ent.openInventory(inv);
    }
}
