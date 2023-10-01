package com.ins09.dynrename.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ins09.dynrename.DynamicRename;
import com.ins09.dynrename.Inventory.GuiRename;

public class Rename implements CommandExecutor {

    // LÓGICA:
    /*
     * 1. Comprobar que el comando sea ejectuado por el jugador (client side), de lo
     * contrario envíara un mensaje de advertencia.
     * 2. Antes de abrir el inventario comprobará que el jugador tenga un item
     * (cualquiera) en la mano, de lo contrario envíara un mensaje de advertencia.
     * 2.1. Comprobar que al ejecutar el comando con un item en la mano verifique
     * que el comando no tenga parametros, de lo contrario envíara una advertencia.
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Checks if the command executor is console?
        if (!(sender instanceof Player)) {
            sender.sendMessage(DynamicRename.nmPlugin + " This command does not work in console");
            return true;
        }

        // Check if player have an item in hand?
        final Player player = (Player) sender; // <-- parser sender to playert
        final ItemStack ITEM_IN_HAND = player.getInventory().getItemInMainHand();
        if (ITEM_IN_HAND.getAmount() == 0) {
            sender.sendMessage(DynamicRename.nmPlugin + " You must have an item in hand to rename it");
            return true;
        }

        // Check if command executed by a player have arguments
        if (args.length == 0) {
            sender.sendMessage(DynamicRename.nmPlugin + " Use /rename (name)");
            return true;
        }

        // Do things...
        sender.sendMessage("Renaming Item on hand...");

        GuiRename inv = new GuiRename();

        // [______ Apply name to item ______]
        // String newNameItem = String.join(" ", args);
        // ItemMeta item = ITEM_IN_HAND.getItemMeta();
        // item.setDisplayName(newNameItem);
        // ITEM_IN_HAND.setItemMeta(item);

        // Initialize Inventory
        inv.initializeItems();
        inv.openInventory(player);

        return true;
    }
}
