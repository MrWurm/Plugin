package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class MaterialsSelectGUI implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public MaterialsSelectGUI(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Materials - 1");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the materials
        main.setItem(0, Items.ENCHANTED_DRIPSTONE.getItem(plugin));
        main.setItem(1, Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin));
        main.setItem(2, Items.ENCHANTED_COAL.getItem(plugin));
        main.setItem(3, Items.ENCHANTED_COAL_BLOCK.getItem(plugin));
        main.setItem(4, Items.ENCHANTED_DEEPSLATE.getItem(plugin));
        main.setItem(5, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin));
        main.setItem(6, Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin));
        main.setItem(7, Items.ENCHANTED_BAMBOO.getItem(plugin));
        main.setItem(8, Items.BAMBOO_BUNDLE.getItem(plugin));
        main.setItem(9, Items.ENCHANTED_IRON.getItem(plugin));
        main.setItem(10, Items.ENCHANTED_IRON_BLOCK.getItem(plugin));
        main.setItem(11, Items.ENCHANTED_FEATHER.getItem(plugin));
        main.setItem(12, Items.ENCHANTED_MEMBRANE.getItem(plugin));
        main.setItem(13, Items.ENCHANTED_GOLD.getItem(plugin));
        main.setItem(14, Items.ENCHANTED_GOLD_BLOCK.getItem(plugin));
        main.setItem(15, Items.ENCHANTED_SAND.getItem(plugin));
        main.setItem(16, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin));
        main.setItem(17, Items.ENCHANTED_SANDSTONE.getItem(plugin));
        main.setItem(18, Items.ENCHANTED_COPPER.getItem(plugin));
        main.setItem(19, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin));
        main.setItem(20, Items.ENCHANTED_CUT_COPPER.getItem(plugin));
        main.setItem(21, Items.ENCHANTED_QUARTZ.getItem(plugin));
        main.setItem(22, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin));
        main.setItem(23, Items.ENCHANTED_QUARTZ_SCULPTURE.getItem(plugin));
        main.setItem(24, Items.ENCHANTED_COBBLESTONE.getItem(plugin));
        main.setItem(25, Items.ENCHANTED_DIAMOND.getItem(plugin));
        main.setItem(26, Items.ENCHANTED_EMERALD.getItem(plugin));
        main.setItem(27, Items.ALLOY.getItem(plugin));
        main.setItem(28, Items.ENCHANTED_CHICKEN.getItem(plugin));
        main.setItem(29, Items.ENCHANTED_BEEF.getItem(plugin));
        main.setItem(30, Items.ENCHANTED_PORK.getItem(plugin));
        main.setItem(31, Items.ENCHANTED_RABBIT.getItem(plugin));
        main.setItem(32, Items.ENCHANTED_MUTTON.getItem(plugin));
        main.setItem(33, Items.ENCHANTED_WOOL.getItem(plugin));
        main.setItem(34, Items.ENCHANTED_COD.getItem(plugin));
        main.setItem(35, Items.ENCHANTED_COOKED_COD.getItem(plugin));
        main.setItem(36, Items.ENCHANTED_SALMON.getItem(plugin));
        main.setItem(37, Items.ENCHANTED_COOKED_SALMON.getItem(plugin));
        main.setItem(38, Items.ENCHANTED_KELP.getItem(plugin));
        main.setItem(39, Items.ENCHANTED_DRIED_KELP.getItem(plugin));
        main.setItem(40, Items.ENCHANTED_KELP_BLOCK.getItem(plugin));
        main.setItem(41, Items.ENCHANTED_CLOWNFISH.getItem(plugin));
        main.setItem(42, Items.ENCHANTED_PUFFERFISH.getItem(plugin));
        main.setItem(43, Items.ENCHANTED_LAPIS.getItem(plugin));
        main.setItem(44, Items.ENCHANTED_LAPIS_BLOCK.getItem(plugin));

        //Bottom Row with options to change pages and a go back and next page button
        for (int i = 45; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
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