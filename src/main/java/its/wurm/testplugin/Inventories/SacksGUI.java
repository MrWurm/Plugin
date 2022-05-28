package its.wurm.testplugin.Inventories;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.persistentDataContainers.stringList;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SacksGUI implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public SacksGUI(Plugin plugin, Player player) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 18, "Sacks");
        init(player);
    }


    private void init(Player player)
    {
        ItemStack item;
        ItemMeta meta;
        List<String> lore = new ArrayList<>();

        //Adding in all selection menus
        String[] sacks = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sacksUnlocked"),
                new stringList());

        item = new ItemStack(Material.DIRT);
        meta = item.getItemMeta();
        if (!sacks[0].equals("-")) {
            switch (sacks[0]) {
                case "Tiny Rock Sack":
                case "Small Rock Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjA3ZGZmNjU3ZDYxZjMwMmM3ZDJlNzI1MjY1ZDE3YjY0YWE3MzY0MjM5MTk2NGZiNDhmYzE1YmU5NTA4MzFkOCJ9fX0=");
                    break;
                case "Medium Rock Sack":
                case "Large Rock Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTAwYjFiZjg1NTQ5ODVmM2RlY2Y1NDg4NjkyMmFkMjBkMTQ0NDM4NTY0ZWY3YTViNTJjZWQ3MWJjOWRkMDRiYiJ9fX0=");
                    break;
                case "Gigantic Rock Sack":
                case "Humongous Rock Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTE1ZmNlYmJiZTAyZmRiNzJhY2QyMDk1ZDllZGZjZWEwOTVlNjA0YjM2ODJkYjg4OTYzYjViODNiMjkzOWI2NyJ9fX0=");
                    break;
            }
            if (sacks[0].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTE1ZmNlYmJiZTAyZmRiNzJhY2QyMDk1ZDllZGZjZWEwOTVlNjA0YjM2ODJkYjg4OTYzYjViODNiMjkzOWI2NyJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.DARK_GRAY + sacks[0]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.DARK_GRAY + "Rock Sack");
        }
        main.setItem(0, item);

        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);
        if (!sacks[1].equals("-")) {
            switch (sacks[1]) {
                case "Tiny Mineral Sack":
                case "Small Mineral Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjY2MjRhN2JkZWU2MjQwZGRkYmVkODI2ODA5MGUyMzRkMGJhNDcwZWE4OTZlODkyOWY0ZWZiMjEzZjIyNjk0NCJ9fX0=");
                    break;
                case "Medium Mineral Sack":
                case "Large Mineral Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDM1MDAyOGZkOTZhOThkNWIzM2QwODRkMjUyNGI3NmVkMGZjNmIyMWNjYzQwMDY0YTZkMmU3YmY5OTcxODYwZSJ9fX0=");
                    break;
                case "Gigantic Mineral Sack":
                case "Humongous Mineral Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTViYTgwNGI3YWU5MmM2NWIyZjQxZDE4YmU4OTlhM2JkMTM5NzcyZTNlM2M4MWMyZmM4YWRkYmIyNzUzNjk1MiJ9fX0=");
                    break;
            }
            if (sacks[1].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTViYTgwNGI3YWU5MmM2NWIyZjQxZDE4YmU4OTlhM2JkMTM5NzcyZTNlM2M4MWMyZmM4YWRkYmIyNzUzNjk1MiJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.AQUA + sacks[1]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.AQUA + "Mineral Sack");
        }
        main.setItem(1, item);
        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);
        if (!sacks[2].equals("-")) {
            switch (sacks[2]) {
                case "Tiny Lumber Sack":
                case "Small Lumber Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGY5NjBjNjM5ZDQwMDRkMTg4MjU3NWFlYmE2OWY0NTZmYjNjNzQ0MDc3OTM1NzE0OTQ3ZTE5YzEzMDZkMjczMyJ9fX0=");
                    break;
                case "Medium Lumber Sack":
                case "Large Lumber Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmMxNDEwNWM3YjYyOWNmZGViODY2YTU2MGJhYjU5NzM0YWE1Y2JiZTg4MGVkOWY1MGY5MDQ0YzQyYWZkNTk5ZCJ9fX0=");
                    break;
                case "Gigantic Lumber Sack":
                case "Humongous Lumber Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmM2ZTI0ZGY0OThiYTRhNTg5YzI1OWQ5ZmMwZDNkYjM0OGY5M2NkZjI2YTVmZTQ2MTU3MWMxZGE3MDZlZmFmMyJ9fX0=");
                    break;
            }
            if (sacks[2].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmM2ZTI0ZGY0OThiYTRhNTg5YzI1OWQ5ZmMwZDNkYjM0OGY5M2NkZjI2YTVmZTQ2MTU3MWMxZGE3MDZlZmFmMyJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.GOLD + sacks[2]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.GOLD + "Lumber Sack");
        }
        main.setItem(2, item);
        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);

        if (!sacks[3].equals("-")) {
            switch (sacks[3]) {
                case "Tiny Foraging Sack":
                case "Small Foraging Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE5ZjFiNzg3M2I5MmY0NDk3Mjg4NmI4YzM2NGNlZTgwMzdmNDVjZDFkMDVmNjRkNjk4ZGJiMTFmNWUxMmY2MCJ9fX0=");
                    break;
                case "Medium Foraging Sack":
                case "Large Foraging Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDYzYzU0MTNhODlmMjljNWE0ZTFkNGIxZjJmYWQzYzBjZWJmMzA4MWVjYjllMzI3ZGUxNjI5NWY5ZmI2YTYxNSJ9fX0=");
                    break;
                case "Gigantic Foraging Sack":
                case "Humongous Foraging Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWZjOTdjYTY0MzE1MjA5MDBiNjc3OGUxYWI3ZDE5YzgzMTJkNzRlYWQ3NDUwNTEzM2JhNzIyYmUxNjJjYjg0MiJ9fX0=");
                    break;
            }
            if (sacks[3].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWZjOTdjYTY0MzE1MjA5MDBiNjc3OGUxYWI3ZDE5YzgzMTJkNzRlYWQ3NDUwNTEzM2JhNzIyYmUxNjJjYjg0MiJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.DARK_GREEN + sacks[3]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.DARK_GREEN + "Foraging Sack");
        }
        main.setItem(3, item);
        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);

        if (!sacks[4].equals("-")) {
            switch (sacks[4]) {
                case "Tiny Agriculture Sack":
                case "Small Agriculture Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmFiODc5ZTFlNTkwMDQxMTQ2YmM3OGMwMThhZjU4NzdkMzllNTQ3NWViN2RiMzY4ZmNhZjJhY2RhMzczODMzZCJ9fX0=");
                    break;
                case "Medium Agriculture Sack":
                case "Large Agriculture Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjk0YzgzNDFhNTM1ZjgwYjNmNDNjNWMyNDNkMDMwMDZiZDMyNWM5ZTk2ZmYzYWI5NTdjY2MzNzA2MjgzMGFjNiJ9fX0=");
                    break;
                case "Gigantic Agriculture Sack":
                case "Humongous Agriculture Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY4MzViODk0MWZlMzE5OTMxNzQ5Yjg3ZmU4ZTg0YzVkMWY0YTI3MWI1ZmJjZTVlNzAwYTYwMDA0ZDg4MWY3OSJ9fX0=");
                    break;
            }
            if (sacks[4].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY4MzViODk0MWZlMzE5OTMxNzQ5Yjg3ZmU4ZTg0YzVkMWY0YTI3MWI1ZmJjZTVlNzAwYTYwMDA0ZDg4MWY3OSJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.GREEN + sacks[4]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.GREEN + "Agriculture Sack");
        }
        main.setItem(4, item);
        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);

        if (!sacks[5].equals("-")) {
            switch (sacks[5]) {
                case "Tiny Husbandry Sack":
                case "Small Husbandry Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODhlNDY0YzE5ODRjMDBlMTBjMmFiZmVmZmJjOWE2NTkzNWM0YWZkYTY2MjYxYjUzZDZmMzY2ZWYyMDQyZTgyMCJ9fX0=");
                    break;
                case "Medium Husbandry Sack":
                case "Large Husbandry Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2IyM2VlNzk4M2E1ZTFjYTI2MDc3YTBhNTAzYjI1MWRkZTA4YjcyOTMyZmFkNGNmZTJmMjBlZmIxODFhM2IyZSJ9fX0=");
                    break;
                case "Gigantic Husbandry Sack":
                case "Humongous Husbandry Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzczMDg3ZjFlNjU0YjE2ODI3MzM1ODRhNDQwOTc1ODdmYjk0MmUxZjM0M2FhZTgzMDdiZDdkYWM4NGU4NDNhYiJ9fX0=");
                    break;
            }
            if (sacks[5].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzczMDg3ZjFlNjU0YjE2ODI3MzM1ODRhNDQwOTc1ODdmYjk0MmUxZjM0M2FhZTgzMDdiZDdkYWM4NGU4NDNhYiJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.RED + sacks[5]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.RED + "Husbandry Sack");
        }
        main.setItem(5, item);
        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);

        if (!sacks[6].equals("-")) {
            switch (sacks[6]) {
                case "Tiny Cryptology Sack":
                case "Small Cryptology Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWI4ZjQ1MmM5ZDZiNjI1NGI1NDc4NTY5YTYwYjBiNmZiMDMxYzdhZDJmMDZlYTNkYWNmMmNlODc0Y2E3MDgzIn19fQ==");
                    break;
                case "Medium Cryptology Sack":
                case "Large Cryptology Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTRiMmI3OWE0ZTA2MGFiYjAwYWE4OGU3YzRjZDVjMDAzOWY1ZTVjYWQyZDQ1YzFjZmY1Njc2Y2I4M2ExODE1ZSJ9fX0=");
                    break;
                case "Gigantic Cryptology Sack":
                case "Humongous Cryptology Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWMxM2M0Nzc0YzgyYzA3MDcxZTZkMTQwODcxN2IxZTNlYWM1NjE4NjA0MmE1ODAzZmMxNzQ0NTJlMzJhMjU0YSJ9fX0=");
                    break;
            }
            if (sacks[6].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWMxM2M0Nzc0YzgyYzA3MDcxZTZkMTQwODcxN2IxZTNlYWM1NjE4NjA0MmE1ODAzZmMxNzQ0NTJlMzJhMjU0YSJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.BLUE + sacks[6]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.BLUE + "Cryptology Sack");
        }
        main.setItem(6, item);
        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);

        if (!sacks[7].equals("-")) {
            switch (sacks[7]) {
                case "Tiny Demonology Sack":
                case "Small Demonology Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzA1YTdlNzMxNzFiMTYzMmMxNmQ4NzlmNGU0OTgzMjYxYzVmNmI2NGY0NDI3MmY3M2IzYTM0OWY2OGIzYTI5NiJ9fX0=");
                    break;
                case "Medium Demonology Sack":
                case "Large Demonology Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzAzMmI2Nzg5MjhiOWQ2MGVjODFlNGMwYjA4MDlkMmM5ZDA4YTNkNWMwYzE5ZGZiYmE0ZjQ3MzkyMDczYjA2In19fQ==");
                    break;
                case "Gigantic Demonology Sack":
                case "Humongous Demonology Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM0NTg3NWU5MjFhMTQ1ZjkyMDM4ODU4YWVlY2MzYzJmMDgzNDQxZWJjNWM4MjY1ZDMxYTI4MWQyNjhlMzY1YiJ9fX0=");
                    break;
            }
            if (sacks[7].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM0NTg3NWU5MjFhMTQ1ZjkyMDM4ODU4YWVlY2MzYzJmMDgzNDQxZWJjNWM4MjY1ZDMxYTI4MWQyNjhlMzY1YiJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.DARK_RED + sacks[7]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.DARK_RED + "Demonology Sack");
        }
        main.setItem(7, item);
        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);

        if (!sacks[8].equals("-")) {
            switch (sacks[8]) {
                case "Tiny Xenoarchaeology Sack":
                case "Small Xenoarchaeology Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTkxZWI0ZWUzZWNjZTM0NDc0ODNhMWYxNTFjMTFmYWNjOWRlMjU1NzdhYjdiNTFmYmYzZDljMmIyYTRiNjlmYyJ9fX0=");
                    break;
                case "Medium Xenoarchaeology Sack":
                case "Large Xenoarchaeology Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWNmYjc4MGY1ZmU0OGYzYzFiZjUzNTY0MzBiYTgxNDI4NjQwM2VhN2YwZjU5ZGEwOTU0YTZlZmE3MTc0MWNlMSJ9fX0=");
                    break;
                case "Gigantic Xenoarchaeology Sack":
                case "Humongous Xenoarchaeology Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTUwOTAwMmNmMWNiYTM2MTE5YjI2Y2ZhMjUyM2QxNDY5M2E4ZTU2YWY3NTYzM2Y0YzIxY2JmN2Y1YWQ4NzE2OSJ9fX0=");
                    break;
            }
            if (sacks[8].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTUwOTAwMmNmMWNiYTM2MTE5YjI2Y2ZhMjUyM2QxNDY5M2E4ZTU2YWY3NTYzM2Y0YzIxY2JmN2Y1YWQ4NzE2OSJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.LIGHT_PURPLE + sacks[8]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.LIGHT_PURPLE + "Xenoarchaeology Sack");
        }
        main.setItem(8, item);
        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);

        if (!sacks[9].equals("-")) {
            switch (sacks[9]) {
                case "Tiny Fishing Sack":
                case "Small Fishing Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzRmYmM3N2QyN2RhYjEwZGU1YWJmOWQwYmNjNDcxOThmOTIzYjBlNmMxNzlhM2MzOTgzZTc3ZjEyZjdjMDMzZSJ9fX0=");
                    break;
                case "Medium Fishing Sack":
                case "Large Fishing Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmY3NTg3MWM5MGI5NGY0ZmJjMTY3ZTM1MWQzNmU4YWVhZTFjYzJmZWMwM2IxNjYyOTAwN2Y3NGM5ODlkZTY0OCJ9fX0=");
                    break;
                case "Gigantic Fishing Sack":
                case "Humongous Fishing Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjhmNjg2NjkzNTFhNmZjNzE1NmVjZmUzMzAwYmE5NGVmZTA3NjZlMjRiZWQ4Nzg1Y2Y2NGE5Zjk1NDM1MTM0YiJ9fX0=");
                    break;
            }
            if (sacks[9].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjhmNjg2NjkzNTFhNmZjNzE1NmVjZmUzMzAwYmE5NGVmZTA3NjZlMjRiZWQ4Nzg1Y2Y2NGE5Zjk1NDM1MTM0YiJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.DARK_AQUA + sacks[9]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.DARK_AQUA + "Fishing Sack");
        }
        main.setItem(9, item);
        lore = new ArrayList<>();
        item = new ItemStack(Material.DIRT);

        if (!sacks[10].equals("-")) {
            switch (sacks[10]) {
                case "Tiny Excavating Sack":
                case "Small Excavating Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmM2Y2Y1OTFhYTIzNjNiZDg0MzQyNDA0ZGM1OTQxNjhiOTA0ZjY1YTFlMjVmOGJlNjU4YjkxYjU2NzYyOWRhZCJ9fX0=");
                    break;
                case "Medium Excavating Sack":
                case "Large Excavating Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmE3ZGEzZmRkMDBhMmNkZDY0M2EzZGEzZTJhYzVjZjgxZjcyMzFhYjMxYjBiZjYxNzY3YmEzZmIyMWMyYzFiMiJ9fX0=");
                    break;
                case "Gigantic Excavating Sack":
                case "Humongous Excavating Sack":
                    item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTk5NzEyZDM5N2YwYmZiZmUwMTI0YzVlZDgwYzgxMGY0ZmUxZTBhNWM1NWQ3MWY0MjhkZDI4MzRjOGEyYzM5OSJ9fX0=");
                    break;
            }
            if (sacks[10].contains("+")) {
                item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTk5NzEyZDM5N2YwYmZiZmUwMTI0YzVlZDgwYzgxMGY0ZmUxZTBhNWM1NWQ3MWY0MjhkZDI4MzRjOGEyYzM5OSJ9fX0=");
            }
            meta = item.getItemMeta();
            lore.add(ChatColor.YELLOW + "Click to view contents!");
            meta.setDisplayName(ChatColor.WHITE + sacks[10]);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = createEmpty(ChatColor.WHITE + "Excavating Sack");
        }
        main.setItem(10, item);

        main.setItem(17, Items.BACK_ARROW.getItem(plugin));
    }

    private ItemStack createEmpty(String name) {
        ItemStack item = new ItemStack(Material.GRAY_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(new ArrayList<>(Arrays.asList(ChatColor.GRAY + "You have not unlocked this",
                ChatColor.GRAY + "sack")));
        item.setItemMeta(meta);
        return item;
    }
    @Override
    public Inventory getInventory() {
        return main;
    }
}