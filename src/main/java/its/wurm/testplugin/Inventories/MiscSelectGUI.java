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

public class MiscSelectGUI implements InventoryHolder {

    private Inventory main;

    Plugin plugin;

    public MiscSelectGUI(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Misc - 1");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the armor
        main.setItem(0, Items.FEATHER_CHARM.getItem(plugin));
        main.setItem(1, Items.MEATY_STEW.getItem(plugin));
        main.setItem(2, Items.MAGIC_STEW.getItem(plugin));
        main.setItem(3, Items.FIBROUS_STEW.getItem(plugin));
        main.setItem(4, Items.SPICY_STEW.getItem(plugin));
        main.setItem(5, Items.HEARTY_STEW.getItem(plugin));
        main.setItem(6, Items.GRAPPLING_HOOK.getItem(plugin));
        main.setItem(7, Items.KINETIC_ROD.getItem(plugin));
        main.setItem(8, Items.METAL_DETECTOR.getItem(plugin));
        main.setItem(9, Items.METALLOID_DETECTOR.getItem(plugin));
        main.setItem(10, Items.TREASURE_DETECTOR.getItem(plugin));
        main.setItem(11, Items.POCKET_WORKBENCH.getItem(plugin));
        main.setItem(12, Items.MINI_ENDERCHEST.getItem(plugin));
        main.setItem(13, Items.PROSPEROUS_GROVE.getItem(plugin));
        main.setItem(14, Items.LEACHING_BRAMBLES.getItem(plugin));
        main.setItem(15, Items.PROLIFERATING_SAPLING.getItem(plugin));
        main.setItem(16, Items.LASHING_VINES.getItem(plugin));
        main.setItem(17, Items.PUNGENT_HERBS.getItem(plugin));
        main.setItem(18, Items.LESSER_SPIRIT_BONE.getItem(plugin));
        main.setItem(19, Items.GREATER_SPIRIT_BONE.getItem(plugin));
        main.setItem(20, Items.CACTUS_DYE.getItem(plugin));
        main.setItem(21, Items.TORRENT.getItem(plugin));
        main.setItem(22, Items.STONK.getItem(plugin));
        main.setItem(23, Items.SCRUFFY_LASSO.getItem(plugin));
        main.setItem(24, Items.SNAGGLETOOTH_LASSO.getItem(plugin));
        main.setItem(25, Items.WOODCUTTERS_AXE.getItem(plugin));
        main.setItem(26, Items.FORESTERS_AXE.getItem(plugin));
        main.setItem(27, Items.DULL_PICKAXE.getItem(plugin));
        main.setItem(28, Items.NOTCHED_PICK.getItem(plugin));
        main.setItem(29, Items.IMBALANCED_PICKAXE.getItem(plugin));
        main.setItem(30, Items.STATS_GUIDE.getItem(plugin));
        main.setItem(31, Items.SUGAR_CUBE.getItem(plugin));
        main.setItem(32, Items.SHORTBOW_CORD.getItem(plugin));
        main.setItem(33, Items.DRAWSTRING_BAG.getItem(plugin));
        main.setItem(34, Items.TINY_ROCK_SACK.getItem(plugin));
        main.setItem(35, Items.SMALL_ROCK_SACK.getItem(plugin));
        main.setItem(36, Items.MEDIUM_ROCK_SACK.getItem(plugin));
        main.setItem(37, Items.LARGE_ROCK_SACK.getItem(plugin));
        main.setItem(38, Items.GIGANTIC_ROCK_SACK.getItem(plugin));
        main.setItem(39, Items.HUMONGOUS_ROCK_SACK.getItem(plugin));
        main.setItem(40, Items.ROCK_SACK_EXTENSION.getItem(plugin));

        //Bottom Row with options to change pages and a go back button
        for (int i = 45; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        main.setItem(49,Items.BACK_ARROW.getItem(plugin));

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