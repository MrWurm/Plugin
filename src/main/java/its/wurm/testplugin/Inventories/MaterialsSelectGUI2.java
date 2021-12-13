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

public class MaterialsSelectGUI2 implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public MaterialsSelectGUI2(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Materials - 2");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the materials
        main.setItem(0, Items.ENCHANTED_REDSTONE.getItem(plugin));
        main.setItem(1, Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin));
        main.setItem(2, Items.ENCHANTED_NETHERITE.getItem(plugin));
        main.setItem(3, Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin));
        main.setItem(4, Items.ENCHANTED_NETHERITE_BLOCK.getItem(plugin));
        main.setItem(5, Items.ENCHANTED_BONE.getItem(plugin));
        main.setItem(6, Items.ENCHANTED_BONE_BLOCK.getItem(plugin));
        main.setItem(7, Items.ENCHANTED_STRING.getItem(plugin));
        main.setItem(8, Items.ENCHANTED_WEB.getItem(plugin));
        main.setItem(9, Items.ENCHANTED_SPIDER_EYE.getItem(plugin));
        main.setItem(10, Items.ENCHANTED_AMETHYST.getItem(plugin));
        main.setItem(11, Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin));
        main.setItem(12, Items.ENCHANTED_INK_SAC.getItem(plugin));
        main.setItem(13, Items.ENCHANTED_GLOW_SAC.getItem(plugin));
        main.setItem(14, Items.ENCHANTED_COCOA.getItem(plugin));
        main.setItem(15, Items.ENCHANTED_SNOWBALL.getItem(plugin));
        main.setItem(16, Items.ENCHANTED_SNOW.getItem(plugin));
        main.setItem(17, Items.SNOW_MOUND.getItem(plugin));
        main.setItem(18, Items.ENCHANTED_GUNPOWDER.getItem(plugin));
        main.setItem(19, Items.ENCHANTED_POWDER_BALL.getItem(plugin));
        main.setItem(20, Items.ENCHANTED_TNT.getItem(plugin));
        main.setItem(21, Items.ENCHANTED_CLAY.getItem(plugin));
        main.setItem(22, Items.ENCHANTED_CLAY_BLOCK.getItem(plugin));
        main.setItem(23, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin));
        main.setItem(24, Items.ENCHANTED_GLOWSTONE.getItem(plugin));
        main.setItem(25, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin));
        main.setItem(26, Items.ENCHANTED_BLAZE_ROD.getItem(plugin));
        main.setItem(27, Items.ENCHANTED_ENDER_PEARL.getItem(plugin));
        main.setItem(28, Items.ENCHANTED_ENDER_EYE.getItem(plugin));
        main.setItem(29, Items.ENCHANTED_WART.getItem(plugin));
        main.setItem(30, Items.ENCHANTED_SWEET_BERRIES.getItem(plugin));
        main.setItem(31, Items.ENCHANTED_SUGAR_CANE.getItem(plugin));
        main.setItem(32, Items.ENCHANTED_SUGAR.getItem(plugin));
        main.setItem(33, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin));
        main.setItem(34, Items.ENCHANTED_POPPED_CHORUS_FRUIT.getItem(plugin));
        main.setItem(35, Items.ENCHANTED_CARROT.getItem(plugin));
        main.setItem(36, Items.ENCHANTED_GOLDEN_CARROT.getItem(plugin));
        main.setItem(37, Items.ENCHANTED_POTATO.getItem(plugin));
        main.setItem(38, Items.ENCHANTED_BAKED_POTATO.getItem(plugin));
        main.setItem(39, Items.ENCHANTED_BEETROOT.getItem(plugin));
        main.setItem(40, Items.ENCHANTED_BEETROOT_SOUP.getItem(plugin));
        main.setItem(41, Items.ENCHANTED_MELON_SLICE.getItem(plugin));
        main.setItem(42, Items.ENCHANTED_MELON.getItem(plugin));
        main.setItem(43, Items.ENCHANTED_RED_MUSHROOM.getItem(plugin));
        main.setItem(44, Items.ENCHANTED_BROWN_MUSHROOM.getItem(plugin));



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