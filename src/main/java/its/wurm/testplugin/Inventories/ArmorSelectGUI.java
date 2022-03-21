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

    Plugin plugin;

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
        main.setItem(6, Items.SILVERFISH_HELMET.getItem(plugin));
        main.setItem(7, Items.SILVERFISH_CHESTPLATE.getItem(plugin));
        main.setItem(8, Items.SILVERFISH_LEGGINGS.getItem(plugin));
        main.setItem(9, Items.SILVERFISH_BOOTS.getItem(plugin));
        main.setItem(10, Items.INVOKER_HOOD.getItem(plugin));
        main.setItem(11, Items.INVOKER_ROBES.getItem(plugin));
        main.setItem(12, Items.INVOKER_TROUSERS.getItem(plugin));
        main.setItem(13, Items.INVOKER_BOOTS.getItem(plugin));
        main.setItem(14, Items.INCANTER_HOOD.getItem(plugin));
        main.setItem(15, Items.INCANTER_ROBES.getItem(plugin));
        main.setItem(16, Items.INCANTER_TROUSERS.getItem(plugin));
        main.setItem(17, Items.INCANTER_BOOTS.getItem(plugin));
        main.setItem(18, Items.MYSTIC_HOOD.getItem(plugin));
        main.setItem(19, Items.MYSTIC_ROBES.getItem(plugin));
        main.setItem(20, Items.MYSTIC_TROUSERS.getItem(plugin));
        main.setItem(21, Items.MYSTIC_BOOTS.getItem(plugin));
        main.setItem(22, Items.CHANTER_HOOD.getItem(plugin));
        main.setItem(23, Items.CHANTER_ROBES.getItem(plugin));
        main.setItem(24, Items.CHANTER_TROUSERS.getItem(plugin));
        main.setItem(25, Items.CHANTER_BOOTS.getItem(plugin));
        main.setItem(26, Items.COPPER_HELMET.getItem(plugin));
        main.setItem(27, Items.COPPER_CHESTPLATE.getItem(plugin));
        main.setItem(28, Items.COPPER_LEGGINGS.getItem(plugin));
        main.setItem(29, Items.COPPER_BOOTS.getItem(plugin));
        main.setItem(30, Items.CACTUS_HELMET.getItem(plugin));
        main.setItem(31, Items.CACTUS_CHESTPLATE.getItem(plugin));
        main.setItem(32, Items.CACTUS_LEGGINGS.getItem(plugin));
        main.setItem(33, Items.CACTUS_BOOTS.getItem(plugin));
        main.setItem(34, Items.ONYX_HELMET.getItem(plugin));
        main.setItem(35, Items.ONYX_CHESTPLATE.getItem(plugin));
        main.setItem(36, Items.ONYX_LEGGINGS.getItem(plugin));
        main.setItem(37, Items.ONYX_BOOTS.getItem(plugin));
        main.setItem(38, Items.SATURATED_CREEPER_MASK.getItem(plugin));
        main.setItem(39, Items.INTRICATE_CREEPER_MASK.getItem(plugin));

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