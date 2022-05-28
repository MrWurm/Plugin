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

    Plugin plugin;

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
        main.setItem(15, Items.SIMPLE_SHIELD_BASE.getItem(plugin));
        main.setItem(16, Items.ADVANCED_SHIELD_BASE.getItem(plugin));
        main.setItem(17, Items.HARDWOOD_HANDLE.getItem(plugin));
        main.setItem(18, Items.GYROSCOPE.getItem(plugin));
        main.setItem(19, Items.GEMSTONE.getItem(plugin));
        main.setItem(20, Items.LUMINOUS_QUARTZ.getItem(plugin));
        main.setItem(21, Items.MINERAL_CLUSTER.getItem(plugin));
        main.setItem(22, Items.ENCHANTED_SLIMEBALL.getItem(plugin));
        main.setItem(23, Items.ENCHANTED_SLIME_BLOCK.getItem(plugin));
        main.setItem(24, Items.ENCHANTED_SPIDER_EYE.getItem(plugin));
        main.setItem(25, Items.ENCHANTED_FERMENTED_SPIDER_EYE.getItem(plugin));
        main.setItem(26, Items.DEEPSLATE_MONOLITH.getItem(plugin));
        main.setItem(27, Items.CACTUS_LEATHER.getItem(plugin));
        main.setItem(28, Items.ENCHANTED_OBSIDIAN.getItem(plugin));
        main.setItem(29, Items.ENCHANTED_MAGMA_CREAM.getItem(plugin));
        main.setItem(30, Items.ENCHANTED_MAGMA_BLOCK.getItem(plugin));
        main.setItem(31, Items.COMPACTED_COAL_LUMP.getItem(plugin));
        main.setItem(32, Items.PURE_IRON_NUGGET.getItem(plugin));
        main.setItem(33, Items.POLISHED_SLATED_HANDLE.getItem(plugin));
        main.setItem(34, Items.SEASTONE.getItem(plugin));
        main.setItem(35, Items.POLISHED_SEASTONE.getItem(plugin));
        main.setItem(36, Items.WOOD_PILE.getItem(plugin));
        main.setItem(37, Items.BUNDLED_OAK_LOGS.getItem(plugin));
        main.setItem(38, Items.BUNDLED_DARK_OAK_LOGS.getItem(plugin));
        main.setItem(39, Items.BUNDLED_BIRCH_LOGS.getItem(plugin));
        main.setItem(40, Items.BUNDLED_SPRUCE_LOGS.getItem(plugin));
        main.setItem(41, Items.BUNDLED_ACACIA_LOGS.getItem(plugin));
        main.setItem(42, Items.BUNDLED_JUNGLE_LOGS.getItem(plugin));
        main.setItem(43, Items.BUNDLED_WARPED_STEMS.getItem(plugin));
        main.setItem(44, Items.BUNDLED_CRIMSON_STEMS.getItem(plugin));

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