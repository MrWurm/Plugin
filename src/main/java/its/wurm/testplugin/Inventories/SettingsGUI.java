package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import org.bukkit.*;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class SettingsGUI implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public SettingsGUI(Plugin plugin, Player player) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 9, "Settings");
        init(player);
    }


    private void init(Player player)
    {
        ItemStack item;
        ItemMeta meta;
        List<String> lore = new ArrayList<>();

        main.setItem(8, Items.BACK_ARROW.getItem(plugin));

        //Adding in all selection menus
        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "peace"),
                PersistentDataType.INTEGER) == 1) {
            item = new ItemStack(Material.WHITE_BANNER);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + "Pacifist Mode");
            lore.add(ChatColor.GRAY + "You and your followers deal no");
            lore.add(ChatColor.RED + "damage " + ChatColor.GRAY + "to other players however");
            lore.add(ChatColor.GRAY + "they can still hurt you.");
            lore.add(" ");
            lore.add(ChatColor.YELLOW + "Click to toggle");
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = new ItemStack(Material.BLACK_BANNER);
            BannerMeta bannerMeta = (BannerMeta) item.getItemMeta();
            Pattern pattern = new Pattern(DyeColor.RED, PatternType.SKULL);
            bannerMeta.addPattern(pattern);
            bannerMeta.setDisplayName(ChatColor.YELLOW + "Pacifist Mode");
            lore.add(ChatColor.GRAY + "You and your followers deal no");
            lore.add(ChatColor.RED + "damage " + ChatColor.GRAY + "to other players however");
            lore.add(ChatColor.GRAY + "they can still hurt you.");
            lore.add(" ");
            lore.add(ChatColor.YELLOW + "Click to toggle");
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
            bannerMeta.setLore(lore);
            bannerMeta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(bannerMeta);
        }
        main.setItem(0, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.NOTE_BLOCK);

        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "noise"),
                PersistentDataType.INTEGER) == 0) {
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + "Skill Xp Noise");
            lore.add(ChatColor.GRAY + "When you gain" + ChatColor.GREEN + " skill");
            lore.add(ChatColor.GREEN + "xp " + ChatColor.GRAY + "from a block it");
            lore.add(ChatColor.GRAY + "will play a small ding");
            lore.add(" ");
            lore.add(ChatColor.YELLOW + "Click to toggle");
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.GREEN + "ON");
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + "Skill Xp Noise");
            lore.add(ChatColor.GRAY + "When you gain" + ChatColor.GREEN + " skill");
            lore.add(ChatColor.GREEN + "xp " + ChatColor.GRAY + "from a block it");
            lore.add(ChatColor.GRAY + "will play a small ding");
            lore.add(" ");
            lore.add(ChatColor.YELLOW + "Click to toggle");
            lore.add(ChatColor.DARK_GRAY + "Currently " + ChatColor.RED + "OFF");
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        main.setItem(1, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.FURNACE);

        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "Smelt Enchantment Settings");
        lore.add(ChatColor.GRAY + "Choose what items the");
        lore.add(ChatColor.GRAY + "enchantment will smelt");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to change settings");
        meta.setLore(lore);
        item.setItemMeta(meta);

        main.setItem(2, item);
        lore = new ArrayList<>();

        item = new ItemStack(Material.GRAY_DYE);

        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Looking For Something Else?");
        lore.add(ChatColor.GRAY + "If you think some qol");
        lore.add(ChatColor.GRAY + "feature should be added");
        lore.add(ChatColor.GRAY + "feel free to suggest it");
        meta.setLore(lore);
        item.setItemMeta(meta);

        main.setItem(3, item);
        lore = new ArrayList<>();

    }

    @Override
    public Inventory getInventory() {
        return main;
    }
}