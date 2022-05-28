package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class EnchantmentsGUI2 implements InventoryHolder {

    private Inventory main;

    Plugin plugin;

    public EnchantmentsGUI2(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Enchantments - 2");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Setup GUI
        for (int i = 0; i < 9; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        main.setItem(9, Items.MENU_GLASS.getItem(plugin));
        main.setItem(17, Items.MENU_GLASS.getItem(plugin));
        main.setItem(18, Items.MENU_GLASS.getItem(plugin));
        main.setItem(26, Items.MENU_GLASS.getItem(plugin));
        main.setItem(27, Items.MENU_GLASS.getItem(plugin));
        main.setItem(35, Items.MENU_GLASS.getItem(plugin));
        main.setItem(36, Items.MENU_GLASS.getItem(plugin));
        main.setItem(44, Items.MENU_GLASS.getItem(plugin));
        for (int i = 45; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        item = createItem(ChatColor.BLUE + "Leaping", Material.ENCHANTED_BOOK);
        main.setItem(10, item);
        item = createItem(ChatColor.BLUE + "Light", Material.ENCHANTED_BOOK);
        main.setItem(11, item);
        item = createItem(ChatColor.BLUE + "Looting", Material.ENCHANTED_BOOK);
        main.setItem(12, item);
        item = createItem(ChatColor.BLUE + "Mana Shield", Material.ENCHANTED_BOOK);
        main.setItem(13, item);
        item = createItem(ChatColor.BLUE + "Masochism", Material.ENCHANTED_BOOK);
        main.setItem(14, item);
        item = createItem(ChatColor.BLUE + "Mysticism", Material.ENCHANTED_BOOK);
        main.setItem(15, item);
        item = createItem(ChatColor.BLUE + "Pierce", Material.ENCHANTED_BOOK);
        main.setItem(16, item);
        item = createItem(ChatColor.BLUE + "Poisonous", Material.ENCHANTED_BOOK);
        main.setItem(19, item);
        item = createItem(ChatColor.BLUE + "Power", Material.ENCHANTED_BOOK);
        main.setItem(20, item);
        item = createItem(ChatColor.BLUE + "Proliferation", Material.ENCHANTED_BOOK);
        main.setItem(21, item);
        item = createItem(ChatColor.BLUE + "Prospector", Material.ENCHANTED_BOOK);
        main.setItem(22, item);
        item = createItem(ChatColor.BLUE + "Protection", Material.ENCHANTED_BOOK);
        main.setItem(23, item);
        item = createItem(ChatColor.BLUE + "Pummel", Material.ENCHANTED_BOOK);
        main.setItem(24, item);
        item = createItem(ChatColor.BLUE + "Repair", Material.ENCHANTED_BOOK);
        main.setItem(25, item);
        item = createItem(ChatColor.BLUE + "Resolute", Material.ENCHANTED_BOOK);
        main.setItem(28, item);
        item = createItem(ChatColor.BLUE + "Sharpness", Material.ENCHANTED_BOOK);
        main.setItem(29, item);
        item = createItem(ChatColor.BLUE + "Shred", Material.ENCHANTED_BOOK);
        main.setItem(30, item);
        item = createItem(ChatColor.BLUE + "Silk Touch", Material.ENCHANTED_BOOK);
        main.setItem(31, item);
        item = createItem(ChatColor.BLUE + "Smelt", Material.ENCHANTED_BOOK);
        main.setItem(32, item);
        item = createItem(ChatColor.BLUE + "Smite", Material.ENCHANTED_BOOK);
        main.setItem(33, item);
        item = createItem(ChatColor.BLUE + "Spiked", Material.ENCHANTED_BOOK);
        main.setItem(34, item);
        item = createItem(ChatColor.BLUE + "Splash", Material.ENCHANTED_BOOK);
        main.setItem(37, item);
        item = createItem(ChatColor.BLUE + "Stalwart", Material.ENCHANTED_BOOK);
        main.setItem(38, item);
        item = createItem(ChatColor.BLUE + "Velocity", Material.ENCHANTED_BOOK);
        main.setItem(39, item);
        item = createItem(ChatColor.BLUE + "Venomous", Material.ENCHANTED_BOOK);
        main.setItem(40, item);
        item = createItem(ChatColor.BLUE + "Wisdom", Material.ENCHANTED_BOOK);
        main.setItem(41, item);

        main.setItem(45, Items.PREVIOUS_ARROW.getItem(plugin));
        main.setItem(49, Items.BACK_ARROW.getItem(plugin));

    }

    private ItemStack createItem(String name, Material mat) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;

    }

    @Override
    public Inventory getInventory() {
        return main;
    }
}