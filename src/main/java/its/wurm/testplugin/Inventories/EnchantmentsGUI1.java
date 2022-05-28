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

public class EnchantmentsGUI1 implements InventoryHolder {

    private Inventory main;

    Plugin plugin;

    public EnchantmentsGUI1(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Enchantments - 1");
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
        item = createItem(ChatColor.BLUE + "Adaptive", Material.ENCHANTED_BOOK);
        main.setItem(10, item);
        item = createItem(ChatColor.BLUE + "Altruist", Material.ENCHANTED_BOOK);
        main.setItem(11, item);
        item = createItem(ChatColor.BLUE + "Aqua Affinity", Material.ENCHANTED_BOOK);
        main.setItem(12, item);
        item = createItem(ChatColor.BLUE + "Astute", Material.ENCHANTED_BOOK);
        main.setItem(13, item);
        item = createItem(ChatColor.BLUE + "Ballistics", Material.ENCHANTED_BOOK);
        main.setItem(14, item);
        item = createItem(ChatColor.BLUE + "Bane of Arthropods", Material.ENCHANTED_BOOK);
        main.setItem(15, item);
        item = createItem(ChatColor.BLUE + "Barrage", Material.ENCHANTED_BOOK);
        main.setItem(16, item);
        item = createItem(ChatColor.BLUE + "Channel", Material.ENCHANTED_BOOK);
        main.setItem(19, item);
        item = createItem(ChatColor.BLUE + "Cleanse", Material.ENCHANTED_BOOK);
        main.setItem(20, item);
        item = createItem(ChatColor.BLUE + "Cognition", Material.ENCHANTED_BOOK);
        main.setItem(21, item);
        item = createItem(ChatColor.BLUE + "Conjure", Material.ENCHANTED_BOOK);
        main.setItem(22, item);
        item = createItem(ChatColor.BLUE + "Cubism", Material.ENCHANTED_BOOK);
        main.setItem(23, item);
        item = createItem(ChatColor.BLUE + "Decay", Material.ENCHANTED_BOOK);
        main.setItem(24, item);
        item = createItem(ChatColor.BLUE + "Depth Strider", Material.ENCHANTED_BOOK);
        main.setItem(25, item);
        item = createItem(ChatColor.BLUE + "Dismantle", Material.ENCHANTED_BOOK);
        main.setItem(28, item);
        item = createItem(ChatColor.BLUE + "Efficiency", Material.ENCHANTED_BOOK);
        main.setItem(29, item);
        item = createItem(ChatColor.BLUE + "Execute", Material.ENCHANTED_BOOK);
        main.setItem(30, item);
        item = createItem(ChatColor.BLUE + "Exorcism", Material.ENCHANTED_BOOK);
        main.setItem(31, item);
        item = createItem(ChatColor.BLUE + "Fire Aspect", Material.ENCHANTED_BOOK);
        main.setItem(32, item);
        item = createItem(ChatColor.BLUE + "Fortify", Material.ENCHANTED_BOOK);
        main.setItem(33, item);
        item = createItem(ChatColor.BLUE + "Fortune", Material.ENCHANTED_BOOK);
        main.setItem(34, item);
        item = createItem(ChatColor.BLUE + "Growth", Material.ENCHANTED_BOOK);
        main.setItem(37, item);
        item = createItem(ChatColor.BLUE + "Hunter", Material.ENCHANTED_BOOK);
        main.setItem(38, item);
        item = createItem(ChatColor.BLUE + "Impair", Material.ENCHANTED_BOOK);
        main.setItem(39, item);
        item = createItem(ChatColor.BLUE + "Impaling", Material.ENCHANTED_BOOK);
        main.setItem(40, item);
        item = createItem(ChatColor.BLUE + "Intellect", Material.ENCHANTED_BOOK);
        main.setItem(41, item);
        item = createItem(ChatColor.BLUE + "Lacerate", Material.ENCHANTED_BOOK);
        main.setItem(42, item);
        item = createItem(ChatColor.BLUE + "Leach", Material.ENCHANTED_BOOK);
        main.setItem(43, item);

        main.setItem(49, Items.BACK_ARROW.getItem(plugin));
        main.setItem(53, Items.NEXT_ARROW.getItem(plugin));
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