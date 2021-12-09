package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeaponsSelectGUI implements InventoryHolder {

    private Inventory main;

    public WeaponsSelectGUI() {
        main = Bukkit.createInventory(this, 54, "Armor - 1");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the armor
        main.setItem(0, ItemManager.stone_saber);
        main.setItem(1, ItemManager.iron_saber);
        main.setItem(2, ItemManager.golden_saber);
        main.setItem(3, ItemManager.diamond_saber);

        //Bottom Row with options to change pages and a go back button
        for (int i = 45; i < 54; i++) {
            main.setItem(i, ItemManager.menu_glass);
        }
        main.setItem(49, ItemManager.back_arrow);

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