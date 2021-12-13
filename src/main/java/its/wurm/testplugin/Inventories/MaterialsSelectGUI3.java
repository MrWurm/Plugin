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

public class MaterialsSelectGUI3 implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public MaterialsSelectGUI3(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Materials - 3");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the materials
        main.setItem(0, Items.ENCHANTED_FLINT.getItem(plugin));
        main.setItem(1, Items.ENCHANTED_PUMPKIN.getItem(plugin));
        main.setItem(2, Items.ENCHANTED_CACTUS.getItem(plugin));
        main.setItem(3, Items.ENCHANTED_SOUL_SAND.getItem(plugin));
        main.setItem(4, Items.ENCHANTED_SOUL_SOIL.getItem(plugin));
        main.setItem(5, Items.ENCHANTED_OAK_WOOD.getItem(plugin));
        main.setItem(6, Items.ENCHANTED_DARK_OAK_WOOD.getItem(plugin));
        main.setItem(7, Items.ENCHANTED_BIRCH_WOOD.getItem(plugin));
        main.setItem(8, Items.ENCHANTED_SPRUCE_WOOD.getItem(plugin));
        main.setItem(9, Items.ENCHANTED_ACACIA_WOOD.getItem(plugin));
        main.setItem(10, Items.ENCHANTED_JUNGLE_WOOD.getItem(plugin));
        main.setItem(11, Items.ENCHANTED_WARPED_STEM.getItem(plugin));
        main.setItem(12, Items.ENCHANTED_CRIMSON_STEM.getItem(plugin));
        main.setItem(13, Items.ENCHANTED_ENDSTONE.getItem(plugin));
        main.setItem(14, Items.ENCHANTED_ROTTEN_FLESH.getItem(plugin));


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