package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
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

public class PetsGUI implements InventoryHolder {

    private Inventory main;
    private Player owner;

    Plugin plugin;

    public PetsGUI(Plugin plugin, Player owner) {
        this.plugin = plugin;
        this.owner = owner;
        main = Bukkit.createInventory(this, 54, "Pets");
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
        for (int i = 45; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }

        switch(owner.getPersistentDataContainer().get(new NamespacedKey(plugin, "selectionMode"),
                PersistentDataType.INTEGER)) {
            case 0:
                lore.add(ChatColor.GRAY + "Click on a pet to select");
                lore.add(ChatColor.GRAY + "it");
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to change mode!");
                item = createItem(ChatColor.GREEN + "Pet Selection", Material.LIME_DYE, lore);
                break;
            case 1:
                lore.add(ChatColor.GRAY + "Click on a pet to return");
                lore.add(ChatColor.GRAY + "it to your inventory");
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to change mode!");
                item = createItem(ChatColor.RED + "Pet Retrieval", Material.RED_DYE, lore);
                break;
            case 2:
                lore.add(ChatColor.GRAY + "Click on a pet with an");
                lore.add(ChatColor.GRAY + "upgrade to apply it");
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to change mode!");
                item = createItem(ChatColor.GOLD + "Pet Upgrades", Material.ORANGE_DYE, lore);
                break;
            default:
                item = createItem(ChatColor.MAGIC.toString() + ChatColor.RED + "????????", Material.BARRIER, lore);
                break;
        }
        main.setItem(48, item);
        main.setItem(49, Items.BACK_ARROW.getItem(plugin));
        ItemStack[] items = new ItemStack[]{};
        try {ByteArrayInputStream inputStream = new ByteArrayInputStream(owner.getPersistentDataContainer().get(new NamespacedKey(plugin, "availablePets"),
                PersistentDataType.BYTE_ARRAY));
            BukkitObjectInputStream objectInputStream = new BukkitObjectInputStream(inputStream);
            items = (ItemStack[])objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(ChatColor.RED + "Failed to load pets");
        }
        for (int i = 0; i < items.length; i++) {
            main.setItem(i + 9, items[i]);
            if (i >= 35) {
                break;
            }
        }
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
    public Player getOwner() {return owner;}

    public void reloadInventory() {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Setup GUI
        for (int i = 0; i < 9; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        for (int i = 45; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }

        switch(owner.getPersistentDataContainer().get(new NamespacedKey(plugin, "selectionMode"),
                PersistentDataType.INTEGER)) {
            case 0:
                lore.add(ChatColor.GRAY + "Click on a pet to select");
                lore.add(ChatColor.GRAY + "it");
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to change mode!");
                item = createItem(ChatColor.GREEN + "Pet Selection", Material.LIME_DYE, lore);
                break;
            case 1:
                lore.add(ChatColor.GRAY + "Click on a pet to return");
                lore.add(ChatColor.GRAY + "it to your inventory");
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to change mode!");
                item = createItem(ChatColor.RED + "Pet Retrieval", Material.RED_DYE, lore);
                break;
            case 2:
                lore.add(ChatColor.GRAY + "Click on a pet with an");
                lore.add(ChatColor.GRAY + "upgrade to apply it");
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to change mode!");
                item = createItem(ChatColor.GOLD + "Pet Upgrades", Material.ORANGE_DYE, lore);
                break;
            default:
                item = createItem(ChatColor.MAGIC.toString() + ChatColor.RED + "????????", Material.BARRIER, lore);
                break;
        }
        main.setItem(48, item);
        main.setItem(49, Items.BACK_ARROW.getItem(plugin));
        ItemStack[] items = new ItemStack[]{};
        try {ByteArrayInputStream inputStream = new ByteArrayInputStream(owner.getPersistentDataContainer().get(new NamespacedKey(plugin, "availablePets"),
                PersistentDataType.BYTE_ARRAY));
            BukkitObjectInputStream objectInputStream = new BukkitObjectInputStream(inputStream);
            items = (ItemStack[])objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(ChatColor.RED + "Failed to load pets");
        }
        for (int i = 0; i < items.length; i++) {
            main.setItem(i + 10, items[i]);
            if (i >= 45) {
                break;
            }
        }
    }
}