package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class MaterialsSelectGUI4 implements InventoryHolder {

    private Inventory main;

    Plugin plugin;

    public MaterialsSelectGUI4(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Materials - 4");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the materials
        main.setItem(0, Items.TOUGH_CORD.getItem(plugin));
        main.setItem(1, Items.MAGMITE_HANDLE.getItem(plugin));
        main.setItem(2, Items.SEASTONE_HANDLE.getItem(plugin));
        main.setItem(3, Items.ENCHANTED_PAPER.getItem(plugin));
        main.setItem(4, Items.NECRONOMICON_PAGE.getItem(plugin));
        main.setItem(5, Items.AMALGAMATED_TISSUE.getItem(plugin));
        main.setItem(6, Items.SUPERSTONE_POWDER.getItem(plugin));

        //Bottom Row with options to change pages and a go back and next page button
        for (int i = 45; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }

        main.setItem(45, Items.PREVIOUS_ARROW.getItem(plugin));
        main.setItem(49, Items.BACK_ARROW.getItem(plugin));
        main.setItem(53, Items.NEXT_ARROW.getItem(plugin));

    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    @Override
    public Inventory getInventory() {
        return main;
    }
}