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

public class WeaponsSelectGUI implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public WeaponsSelectGUI(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Armor - 1");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the armor
        main.setItem(0, Items.STONE_SCIMITAR.getItem(plugin));
        main.setItem(1, Items.IRON_SCIMITAR.getItem(plugin));
        main.setItem(2, Items.GOLD_SCIMITAR.getItem(plugin));
        main.setItem(3, Items.DIAMOND_SCIMITAR.getItem(plugin));
        main.setItem(4, Items.NETHERITE_SCIMITAR.getItem(plugin));
        main.setItem(5, Items.TNT_WAND.getItem(plugin));
        main.setItem(6, Items.PUFFERFISH_CANON.getItem(plugin));
        main.setItem(7, Items.AMETHYST_SPEAR.getItem(plugin));
        main.setItem(8, Items.MEAT_CLEAVER.getItem(plugin));
        main.setItem(9, Items.SLATED_SCIMITAR.getItem(plugin));
        main.setItem(10, Items.ALLOY_SCIMITAR.getItem(plugin));
        main.setItem(11, Items.ORNAMENTAL_SCIMITAR.getItem(plugin));
        main.setItem(12, Items.OBSIDIAN_SCIMITAR.getItem(plugin));
        main.setItem(14, Items.CACTUS_SHIELD.getItem(plugin));
        main.setItem(15, Items.SPARKLING_SHIELD.getItem(plugin));
        main.setItem(16, Items.COPPER_SHIELD.getItem(plugin));
        main.setItem(17, Items.IRON_SHIELD.getItem(plugin));
        main.setItem(20, Items.CEREMONIAL_SCIMITAR.getItem(plugin));
        main.setItem(21, Items.GEMSTONE_SCIMITAR.getItem(plugin));
        main.setItem(23, Items.LAPIS_SHIELD.getItem(plugin));
        main.setItem(24, Items.REDSTONE_SHIELD.getItem(plugin));
        main.setItem(25, Items.DIAMOND_SHIELD.getItem(plugin));
        main.setItem(26, Items.EMERALD_SHIELD.getItem(plugin));
        main.setItem(27, Items.QUARTERSTAFF.getItem(plugin));
        main.setItem(28, Items.BRITTLE_BONE_SPEAR.getItem(plugin));
        main.setItem(29, Items.BONE_SPEAR.getItem(plugin));
        main.setItem(30, Items.GEMSTONE_TRIDENT.getItem(plugin));
        main.setItem(31, Items.STICKY_BOMB_LAUNCHER.getItem(plugin));
        main.setItem(32, Items.NETHERITE_SHIELD.getItem(plugin));
        main.setItem(33, Items.LIGHTNING_WAND.getItem(plugin));
        main.setItem(34, Items.WAND_OF_MAGGOTS.getItem(plugin));
        main.setItem(35, Items.BAMBOO_SHORTBOW.getItem(plugin));
        main.setItem(36, Items.POTION_SHORTBOW.getItem(plugin));
        main.setItem(37, Items.LESSER_HEAL_WAND.getItem(plugin));
        main.setItem(38, Items.HEAL_WAND.getItem(plugin));
        main.setItem(39, Items.FLASH_HEAL_WAND.getItem(plugin));
        main.setItem(40, Items.STAFF_OF_EXPLOSIVES.getItem(plugin));
        main.setItem(41, Items.DUNE_WAND.getItem(plugin));
        main.setItem(42, Items.PRISMATIC_WAND.getItem(plugin));
        main.setItem(43, Items.FLIMSY_BAMBOO_SPEAR.getItem(plugin));
        main.setItem(44, Items.BAMBOO_SPEAR.getItem(plugin));

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