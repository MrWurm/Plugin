package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class MainGUI implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public MainGUI(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Menu");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Bottom Row with options to change pages and a go back button
        for (int i = 0; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        item = createItem("§cClose", Material.BARRIER, false);
        main.setItem(49, item);

        //Adding in all selection menus
        item = createItem("§aSkills", Material.DIAMOND_PICKAXE, false);
        main.setItem(19, item);
        item = createItem("§fPets - Coming Soon (aka Never)", Material.AXOLOTL_BUCKET, false);
        main.setItem(20, item);
        item = createItem("§5Essence Shop - Coming Soon", Material.DRAGON_EGG, false);
        main.setItem(24, item);
        item = createItem("§9Ender Chest", Material.ENDER_CHEST, false);
        main.setItem(25, item);
        item = createItem("§8Anvil", Material.ANVIL, false);
        main.setItem(29, item);
        item = createItem("§aRecipes", Material.CRAFTING_TABLE, false);
        main.setItem(30, item);
        item = createItem("§6Inspect Item", Material.BOOKSHELF, false);
        main.setItem(31, item);
        item = createItem("§4Rituals - Coming Soon", Material.WRITABLE_BOOK, true);
        main.setItem(32, item);
        item = createItem("§eRewards - Coming Soon", Material.SUNFLOWER, false);
        main.setItem(33, item);

    }

    private ItemStack createItem(String name, Material mat, boolean glint) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        if (glint) {
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;

    }

    @Override
    public Inventory getInventory() {
        return main;
    }
}