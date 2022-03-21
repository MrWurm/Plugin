package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventoryGUI implements InventoryHolder {

    private Inventory main;
    Player target;
    Plugin plugin;

    public PlayerInventoryGUI(Plugin plugin, Player target) {
        this.plugin = plugin;
        this.target = target;
        main = Bukkit.createInventory(this, 54, target.getName() + "'s Inventory'");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        for (int i = 0; i < 36; i++) {
            if (target.getInventory().getItem(i) != null) {
                main.setItem(i, target.getInventory().getItem(i));
            }
        }

        for (int i = 36; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }

        main.setItem(45, new ItemStack(Material.AIR));
        if (target.getInventory().getHelmet() != null) {
            main.setItem(45, target.getInventory().getHelmet());
        }
        main.setItem(46, new ItemStack(Material.AIR));
        if (target.getInventory().getChestplate() != null) {
            main.setItem(46, target.getInventory().getChestplate());
        }
        main.setItem(47, new ItemStack(Material.AIR));
        if (target.getInventory().getLeggings() != null) {
            main.setItem(47, target.getInventory().getLeggings());
        }
        main.setItem(48, new ItemStack(Material.AIR));
        if (target.getInventory().getBoots() != null) {
            main.setItem(48, target.getInventory().getBoots());
        }

        main.setItem(52, new ItemStack(Material.AIR));
        if (target.getInventory().getItemInOffHand() != null) {
            main.setItem(52, target.getInventory().getItemInOffHand());
        }

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