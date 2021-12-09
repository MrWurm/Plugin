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

public class MaterialsSelectGUI2 implements InventoryHolder {

    private Inventory main;

    public MaterialsSelectGUI2() {
        main = Bukkit.createInventory(this, 54, "Materials - 2");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the materials
        main.setItem(0, ItemManager.eredstone);
        main.setItem(1, ItemManager.seredstone);
        main.setItem(2, ItemManager.enetherite);
        main.setItem(3, ItemManager.senetherite);
        main.setItem(4, ItemManager.vsenetherite);


        //Bottom Row with options to change pages and a go back and next page button
        for (int i = 45; i < 54; i++) {
            main.setItem(i, ItemManager.menu_glass);
        }

        main.setItem(45, ItemManager.last_arrow);
        main.setItem(49, ItemManager.back_arrow);
        main.setItem(53, ItemManager.next_arrow);

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