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

public class ArmorSelectGUI implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public ArmorSelectGUI(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Armor - 1");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the armor
        main.setItem(0, Items.THE_DRIP.getItem(plugin));
        main.setItem(1, Items.SUPREME_DRIP.getItem(plugin));
        main.setItem(2, Items.ALLOY_HELMET.getItem(plugin));
        main.setItem(3, Items.ALLOY_CHESTPLATE.getItem(plugin));
        main.setItem(4, Items.ALLOY_LEGGINGS.getItem(plugin));
        main.setItem(5, Items.ALLOY_BOOTS.getItem(plugin));


        //Bottom Row with options to change pages and a go back button
        for (int i = 45; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        main.setItem(49, Items.BACK_ARROW.getItem(plugin));

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