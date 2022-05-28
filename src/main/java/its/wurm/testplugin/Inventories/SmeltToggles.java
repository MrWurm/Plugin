package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class SmeltToggles implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public SmeltToggles(Plugin plugin, Player player) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 18, "Toggle Smelt Materials");
        init(player);
    }


    private void init(Player player)
    {
        ItemStack item;
        ItemMeta meta;
        List<String> lore = new ArrayList<>();

        main.setItem(17, Items.BACK_ARROW.getItem(plugin));

        //Adding in all selection menus
        int[] toggles = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                PersistentDataType.INTEGER_ARRAY);
        item = new ItemStack(Material.RAW_COPPER);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Ores");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(ChatColor.GOLD + "copper" + ChatColor.GRAY + ", iron, " + ChatColor.YELLOW + "gold" + ChatColor.GRAY + ", and");
        lore.add(ChatColor.DARK_RED + "ancient debris " + ChatColor.GRAY + "with the " + ChatColor.BLUE + "Smelt");
        lore.add(ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[0] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(0, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.OAK_LOG);
        meta = item.getItemMeta();
        meta.setDisplayName(net.md_5.bungee.api.ChatColor.of("#5e372c") + "Wood");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(net.md_5.bungee.api.ChatColor.of("#5e372c") + "logs" + ChatColor.GRAY + " and " + net.md_5.bungee.api.ChatColor.of("#5e372c") + "wood" + ChatColor.GRAY + "with the ");
        lore.add(ChatColor.BLUE + "Smelt " + ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[1] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(1, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.TERRACOTTA);
        meta = item.getItemMeta();
        meta.setDisplayName(net.md_5.bungee.api.ChatColor.of("#c9abab") + "Clay");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(net.md_5.bungee.api.ChatColor.of("#c2b2b2") + "clay" + ChatColor.GRAY + " and " + net.md_5.bungee.api.ChatColor.of("#9c5656") + "terracotta " + ChatColor.GRAY + "with the " );
        lore.add(ChatColor.BLUE + "Smelt " + ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[2] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(2, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.SAND);
        meta = item.getItemMeta();
        meta.setDisplayName(net.md_5.bungee.api.ChatColor.of("#cdcf7e") + "Sand");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(net.md_5.bungee.api.ChatColor.of("#cdcf7e") + "sand " + ChatColor.GRAY +"with the " + ChatColor.BLUE + "Smelt");
        lore.add(ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[3] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(3, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.POPPED_CHORUS_FRUIT);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Chorus Fruit");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(ChatColor.DARK_PURPLE +  "Chorus Fruit " + ChatColor.GRAY + "with the " + ChatColor.BLUE + "Smelt");
        lore.add(ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[4] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(4, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.SMOOTH_STONE);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Stone");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(ChatColor.GRAY + "Stone, " + ChatColor.DARK_GRAY + "deepslate" + ChatColor.GRAY + ", " + ChatColor.WHITE + "quartz" + ChatColor.GRAY + ", and");
        lore.add(net.md_5.bungee.api.ChatColor.of("#cdcf7e") + "sandstone " + ChatColor.GRAY + "with the");
        lore.add(ChatColor.BLUE + "Smelt " + ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[5] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(5, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.NETHER_BRICK);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "Nether Bricks");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(ChatColor.DARK_RED + "Netherrack " + ChatColor.GRAY + "with the " + ChatColor.BLUE + "Smelt");
        lore.add(ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[6] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(6, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.CACTUS);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "Plants");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(ChatColor.DARK_GREEN + "Cactus" + ChatColor.GRAY + " and " + ChatColor.GREEN + "kelp " + ChatColor.GRAY + "with the ");
        lore.add(ChatColor.BLUE + "Smelt " +ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[7] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(7, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.WET_SPONGE);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Sponge");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(ChatColor.YELLOW + "Wet Sponges " + ChatColor.GRAY + "with the " + ChatColor.BLUE + "Smelt");
        lore.add(ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[8] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(8, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.SEA_PICKLE);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Sea Pickles");
        lore.add(ChatColor.GRAY + "Toggle whether you smelt");
        lore.add(ChatColor.GREEN + "Sea Pickles " + ChatColor.GRAY + "with the " + ChatColor.BLUE + "Smelt");
        lore.add(ChatColor.GRAY + "enchantment");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to toggle");
        if (toggles[9] == 1) {
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
        } else {
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        main.setItem(9, item);
        lore = new ArrayList<>();

        main.setItem(17, Items.BACK_ARROW.getItem(plugin));
    }

    @Override
    public Inventory getInventory() {
        return main;
    }
}