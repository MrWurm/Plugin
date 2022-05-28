package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.io.BukkitObjectInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrewingStandGUI implements InventoryHolder {

    private Inventory main;
    private Block owner;

    Plugin plugin;

    public BrewingStandGUI(Plugin plugin, Block owner) {
        this.plugin = plugin;
        this.owner = owner;
        main = Bukkit.createInventory(this, 54, "Brewing Stand");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Setup GUI
        for (int i = 0; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        lore.add(ChatColor.YELLOW + "Click an appropriate item to insert it!");
        item = createItem(ChatColor.YELLOW + "Amplifier", Material.YELLOW_STAINED_GLASS_PANE, lore);
        main.setItem(2, item);
        item = createItem(ChatColor.DARK_GREEN + "Base", Material.GREEN_STAINED_GLASS_PANE, lore);
        main.setItem(4, item);
        item = createItem(ChatColor.RED + "Inhibitor", Material.RED_STAINED_GLASS_PANE, lore);
        main.setItem(6, item);
        item = createItem(ChatColor.DARK_AQUA + "Additive", Material.CYAN_STAINED_GLASS_PANE, lore);
        main.setItem(19, item);
        item = createItem(ChatColor.DARK_PURPLE + "Configuration", Material.PURPLE_STAINED_GLASS_PANE, lore);
        main.setItem(25, item);
        lore.clear();
        item = createItem(" ", Material.RED_STAINED_GLASS_PANE, lore);
        main.setItem(20, item);
        main.setItem(21, item);
        main.setItem(22, item);
        main.setItem(23, item);
        main.setItem(24, item);
        main.setItem(29, item);
        main.setItem(31, item);
        main.setItem(33, item);
        ItemStack[] items = new ItemStack[] {};
        TileState state = (TileState)owner.getState();
        try {ByteArrayInputStream inputStream = new ByteArrayInputStream(state.getPersistentDataContainer().get(new NamespacedKey(plugin, "StoredItems"),
                    PersistentDataType.BYTE_ARRAY));
            BukkitObjectInputStream objectInputStream = new BukkitObjectInputStream(inputStream);
            items = (ItemStack[])objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(ChatColor.RED + "Failed to load items");
        }
        main.setItem(13, items[0]);
        main.setItem(38, items[1]);
        main.setItem(40, items[2]);
        main.setItem(42, items[3]);
        item = createItem(ChatColor.GREEN + "Brew", Material.BREWING_STAND, lore);
        main.setItem(44, item);
        item = createItem(ChatColor.RED + "Close", Material.BARRIER, lore);
        main.setItem(53, item);
    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return main;
    }
    public Block getOwner() {return owner;}
}