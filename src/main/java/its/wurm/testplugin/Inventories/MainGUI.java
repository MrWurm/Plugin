package its.wurm.testplugin.Inventories;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.persistentDataContainers.stringList;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class MainGUI implements InventoryHolder {

    private Inventory main;

    static Plugin plugin;

    public MainGUI(Plugin plugin, Player player) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Menu");
        init(player);
    }

    private void init(Player player)
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
        item = createStats("§eYour Stats", player);
        main.setItem(13, item);
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
        item = createItem(ChatColor.LIGHT_PURPLE + "Enchantments", Material.ENCHANTING_TABLE, false);
        main.setItem(31, item);
        item = createItem("§4Rituals - Coming Soon", Material.WRITABLE_BOOK, true);
        main.setItem(32, item);
        item = createItem("§eRewards - Coming Soon", Material.SUNFLOWER, false);
        main.setItem(33, item);
        item = createItem(ChatColor.GREEN + "Settings", Material.COMMAND_BLOCK, false);
        main.setItem(46, item);
        item = createItem(ChatColor.YELLOW + "Potion Effects", Material.POTION, false);
        main.setItem(47, item);
        new BukkitRunnable() {
            ItemStack potion = main.getItem(47);
            public void run()
            {
                if (main.getViewers().isEmpty()) {
                    this.cancel();
                    return;
                }

                ItemMeta potionsMeta = potion.getItemMeta();
                List<String> potionsLore = new ArrayList<>();
                if (player.getPersistentDataContainer().get(new NamespacedKey(plugin,"potionEffects"), new stringList()).length > 0) {
                    String potions = "";
                    String testName = "";
                    String[] potionName = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "potionEffects"), new stringList());
                    int[] potionLevel = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "potionLevels"), PersistentDataType.INTEGER_ARRAY);
                    long[] potionDuration = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "potionDurations"), PersistentDataType.LONG_ARRAY);
                    for (int i = 0; i < potionName.length; i++) {
                        boolean previous = false;
                        String formattedTime = "";
                        long cutTime = potionDuration[i] - System.currentTimeMillis();
                        if (cutTime / 3600000 >= 1) {
                            formattedTime = " " + formattedTime + (int) (cutTime/3600000) + ":";
                            cutTime -= 3600000 * (int)(cutTime / 3600000);
                            previous = true;
                        }
                        if (cutTime / 60000 >= 1) {
                            formattedTime = formattedTime + (int) (cutTime/60000) + ":";
                            cutTime -= 60000 * (int)(cutTime / 60000);
                            previous = true;
                        } else {
                            if (previous) {
                                formattedTime = formattedTime + "00:";
                            }
                        }
                        if (cutTime / 1000 >= 1) {
                            if ((int) (cutTime/1000) >= 10) {
                                formattedTime = formattedTime + (int) (cutTime / 1000);
                            } else {
                                formattedTime = formattedTime + "0" + (int) (cutTime / 1000);
                            }
                            cutTime -= 1000 * (int)(cutTime / 1000);
                        } else {
                        if (previous) {
                            formattedTime = formattedTime  + "00";
                        }
                    }

                        testName = potionName[i] + " " + potionLevel[i] + " " + formattedTime + ", ";
                        if (potions.length() + testName.length() < 22) {
                            potions += testName;
                        } else {
                            potionsLore.add(ChatColor.BLUE + potions);
                            potions = testName;
                        }
                        if (i + 1 == potionName.length) {
                            potionsLore.add(ChatColor.BLUE + potions.substring(0, potions.length() - 2));
                            break;
                        }
                    }
                }
                potionsMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                potionsMeta.setLore(potionsLore);
                potion.setItemMeta(potionsMeta);
            }
        }.runTaskTimer(plugin, 0, 20);
        item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTJlZjM5NDM3ZDdkNDNhMDM0YzVhNDBiOTc0ZThkMmM2NzM0YTIxOGM3NjQ4NWQwNDkxMGY1MDdiZGMyZTgwOSJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "Sacks");
        item.setItemMeta(meta);
        main.setItem(51, item);
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

    private ItemStack createStats(String name, Player player) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(player);
        meta.setDisplayName(name);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + "  " + "❤ Health" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.GREEN + "  " + "❈ Defense" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.RED + "  " + "❁ Strength" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.DARK_BLUE + "  " + "☣ Crit Chance" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritChance"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.BLUE + "  " + "☠ Crit Damage" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.YELLOW + "  " + "⚔ Attack Speed" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.WHITE + "  " + "✦ Speed" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.AQUA + "  " + "✎ Intelligence" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.LIGHT_PURPLE + "  " + "҉ Invocation" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.DARK_PURPLE + "  " + "ᛝ Thaumaturgy" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.DARK_AQUA + "  " + "✯ Magic Find" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicFind"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.GOLD + "  " + "☘ Farming Fortune" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.GOLD + "  " + "⛏ Mining Fortune" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE));
        lore.add(ChatColor.GOLD + "  " + "♠ Excavating Fortune" + ChatColor.WHITE + " " + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return main;
    }
}