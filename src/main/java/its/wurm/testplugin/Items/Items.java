package its.wurm.testplugin.Items;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.*;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;


//c:beginning, c:start

public enum Items implements ItemLike {

    //c:test items

    TEST_FIREBALL {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FIRE_CHARGE);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<>();
            meta.setDisplayName(ChatColor.RED + "Fire Ball Name");
            lore.add(ChatColor.RED + "§lSPECIAL");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Test Fireball Name");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "SPECIAL");
            item.setItemMeta(meta);

            return item;
        }
    },

    DEV_HAMMER {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_AXE);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<>();
            meta.setDisplayName(ChatColor.RED + "Dev Hammer");
            lore.add(ChatColor.GRAY + "Down any mob in one hit");
            lore.add(ChatColor.GRAY + "with this mighty weapon");
            lore.add(" ");
            lore.add(ChatColor.RED + "§lSPECIAL");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Dev Hammer");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "SPECIAL");
            item.setItemMeta(meta);

            return item;
        }
    },

    MENU_GLASS {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Menu Glass");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, " ");
            item.setItemMeta(meta);

            return item;
        }
    },

    BACK_ARROW {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("Go Back");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Back Arrow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, " ");
            item.setItemMeta(meta);

            return item;
        }
    },

    PREVIOUS_ARROW {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("Previous Page");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Previous Page");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, " ");
            item.setItemMeta(meta);

            return item;
        }
    },

    NEXT_ARROW {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("Next Page");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Next Page");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, " ");
            item.setItemMeta(meta);

            return item;
        }
    },

    SHORTBOW {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BOW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName("§cTest Shortbow");
            List<String> lore = new ArrayList<>();
            lore.add(" ");
            lore.add(ChatColor.RED + "§lSPECIAL BOW");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"), PersistentDataType.DOUBLE, 666.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "Type"), PersistentDataType.STRING, "bow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Test Shortbow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "SPECIAL");


            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

//---------------------------------MATERIALS SECTION c:mat--------------------------------------------------------------


    ENCHANTED_DRIPSTONE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POINTED_DRIPSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Dripstone");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Dripstone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_DEEPSLATE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DEEPSLATE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Deepslate");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_POLISHED_DEEPSLATE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POLISHED_DEEPSLATE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Polished Deepslate");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_DEEPSLATE_TILES {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POLISHED_DEEPSLATE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Enchanted Deepslate Tiles");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_DRIPSTONE_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DRIPSTONE_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Dripstone Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_IRON {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Iron");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_IRON_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Iron Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_COAL {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COAL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Coal");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_COAL_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COAL_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Coal Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_BAMBOO {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BAMBOO, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Bamboo");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    BAMBOO_BUNDLE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGVlODRkNmYyZGJkZjdhM2M5MTlmNzdlYzIyZTZlZTI2NjFlMDE3M2E4YTk3MWUxMWM5ODAwMjIzNGU2NDE3ZiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Bamboo Bundle");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_FEATHER {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FEATHER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Feather");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_MEMBRANE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PHANTOM_MEMBRANE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Phantom Membrane");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_GOLD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Gold");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_GOLD_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLD_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Gold Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_SAND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SAND, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Sand");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_COMPACTED_SAND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SMOOTH_SANDSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Compacted Sand");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_SANDSTONE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SANDSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Enchanted Sandstone");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_COPPER {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COPPER_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Copper");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_COPPER_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COPPER_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Copper Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_CUT_COPPER {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CUT_COPPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Enchanted Cut Copper Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_QUARTZ {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.QUARTZ, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Quartz");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_QUARTZ_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.QUARTZ_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Quartz Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_QUARTZ_SCULPTURE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHISELED_QUARTZ_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Enchanted Quartz Sculpture");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ALLOY {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Alloy");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_COBBLESTONE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Cobblestone");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_DIAMOND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DIAMOND, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Diamond");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_EMERALD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.EMERALD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Emerald");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_WOOL {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.WHITE_WOOL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Wool");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_MUTTON {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MUTTON, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Mutton");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_CHICKEN {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHICKEN, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Chicken");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_BEEF {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEEF, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Beef");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_LEATHER {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Leather");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_PORK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PORKCHOP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Pork");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_RABBIT {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.RABBIT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Rabbit");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_CLOWNFISH {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TROPICAL_FISH, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Rabbit");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_PUFFERFISH {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PUFFERFISH, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Pufferfish");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_COD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Cod");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_COOKED_COD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COOKED_COD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Cooked Cod");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE +"§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_SALMON {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SALMON, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Salmon");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_COOKED_SALMON {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COOKED_SALMON, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Cooked Salmon");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_KELP {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.KELP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Kelp");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_DRIED_KELP {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DRIED_KELP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Dried Kelp");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_KELP_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DRIED_KELP_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Enchanted Kelp Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_LAPIS {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LAPIS_LAZULI, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Lapis");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_LAPIS_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LAPIS_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Lapis Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_REDSTONE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.REDSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Redstone");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_REDSTONE_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.REDSTONE_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Redstone Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_NETHERITE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_SCRAP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Netherite Scrap");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_NETHERITE_INGOT {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Netherite Ingot");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_NETHERITE_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Enchanted Netherite Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_ROTTEN_FLESH {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ROTTEN_FLESH, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Rotten Flesh");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_BONE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Bone");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_BONE_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Bone Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_STRING {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STRING, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted String");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_WEB {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COBWEB, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Web");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_SPIDER_EYE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SPIDER_EYE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Spider Eye");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_AMETHYST {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.AMETHYST_SHARD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Amethyst");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_AMETHYST_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.AMETHYST_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Amethyst Block");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_INK_SAC {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.INK_SAC, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Ink Sac");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_GLOW_SAC {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GLOW_INK_SAC, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Glow Ink Sac");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_COCOA {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COCOA_BEANS, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Coco Beans");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_SNOWBALL {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SNOWBALL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Snowball");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    ENCHANTED_SNOW {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SNOW_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Snow");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    SNOW_MOUND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWRmZDc3MjRjNjlhMDI0ZGNmYzYwYjE2ZTAwMzM0YWI1NzM4ZjRhOTJiYWZiOGZiYzc2Y2YxNTMyMmVhMDI5MyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Snow Mound");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_GUNPOWDER {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GUNPOWDER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Gunpowder");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_POWDER_BALL {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FIREWORK_STAR, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Powder Ball");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_TNT {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TNT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Enchanted Tnt");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_CLAY {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CLAY_BALL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Clay");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_CLAY_BLOCK {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CLAY, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Clay");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_GLOWSTONE_DUST {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GLOWSTONE_DUST, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Glowstone Dust");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_GLOWSTONE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GLOWSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Glowstone");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_BLAZE_POWDER {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BLAZE_POWDER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Blaze Powder");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_BLAZE_ROD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Blaze Rod");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_ENDER_PEARL {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Ender Pearl");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_ENDER_EYE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ENDER_EYE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Eye of Ender");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_WART {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHER_WART, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Nether Wart");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_SWEET_BERRIES {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SWEET_BERRIES, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Sweet Berries");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_SUGAR_CANE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SUGAR_CANE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Sugar Cane");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_SUGAR {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SUGAR, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Sugar");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_CHORUS_FRUIT {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHORUS_FRUIT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Chorus Fruit");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_POPPED_CHORUS_FRUIT {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POPPED_CHORUS_FRUIT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Popped Chorus Fruit");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_CARROT {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CARROT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Carrot");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_GOLDEN_CARROT {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_CARROT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Golden Carrot");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_POTATO {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POTATO, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Potato");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_BAKED_POTATO {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BAKED_POTATO, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Baked Potato");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_BEETROOT {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEETROOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Beetroot");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_BEETROOT_SOUP {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEETROOT_SOUP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Beetroot Soup");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_MELON_SLICE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MELON_SLICE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Melon Slice");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_MELON {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MELON, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Enchanted Melon");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_BROWN_MUSHROOM {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BROWN_MUSHROOM, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Mushroom");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_RED_MUSHROOM {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.RED_MUSHROOM, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Mushroom");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_FLINT {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FLINT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Flint");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_PUMPKIN {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PUMPKIN, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Pumpkin");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_CACTUS {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CACTUS, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Cactus");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_SOUL_SAND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SOUL_SAND, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Soul Sand");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_SOUL_SOIL {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SOUL_SOIL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Soul Soil");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_OAK_WOOD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.OAK_LOG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Oak Wood");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_SPRUCE_WOOD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SPRUCE_WOOD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Spruce Wood");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_ACACIA_WOOD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ACACIA_LOG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Acacia Wood");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_BIRCH_WOOD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BIRCH_LOG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Birch Wood");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_JUNGLE_WOOD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.JUNGLE_LOG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Jungle Wood");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_DARK_OAK_WOOD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DARK_OAK_WOOD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Dark Oak Wood");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_WARPED_STEM {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.WARPED_STEM, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Warped Stem");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_CRIMSON_STEM {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CRIMSON_STEM, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted Crimson Stem");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    ENCHANTED_ENDSTONE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.END_STONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Enchanted End Stone");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }
    },

    PULSING_TUMOR {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmFmZmNkYjA3MjkyYjY2ODY3MzYyM2NlNjNhNjEzZjQ1NzFlZjg1YzFlZmM5MjVmYTJmOGYyZmY4OTUzMzg1OSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Pulsing Tumor");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "§lUNCOMMON+");
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },
//-------------------------------------------MISC SECTION c:item, c:misc------------------------------------------------

    TOMATO {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQyNDlmNDhjNWMwMjUzZGI2N2U5MWM3ZDJhNzc0NTVmOTMwOTM4OGJlNTBmOGQ4NWQ0NzE4ZTYyYzkifX19");
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Tomato");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "§oOh cool, a tomato!");
            lore.add(" ");
            lore.add(ChatColor.GREEN + "§lUNCOMMON TROPHY");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "trophy");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    FEATHER_CHARM {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZmMzNiMjk3YTk4MWI1MjdiZWMzOTMxNjg0MDFkOGEyZWNhZGViOWYxNjAzYmE1ZTI3NmY0MmQ2NDQ3NTExNiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Feather Charm");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Float down like a feather when");
            lore.add(ChatColor.GRAY + "you crouch");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Feather Charm");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    ECHO_STONE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LAPIS_LAZULI, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Echo Stone");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Item Ability: Echo " + ChatColor.YELLOW + "§lRIGHT-CLICK");
            lore.add(ChatColor.GRAY + "Teleport to your last " + ChatColor.AQUA + "echo ward");
            lore.add(ChatColor.GRAY + "if you have one available.");
            lore.add(" ");
            lore.add(ChatColor.GOLD + "Item Ability: Echo Ward " + ChatColor.GOLD + "§lSHIFT");
            lore.add(ChatColor.GRAY + "Place an " + ChatColor.AQUA + "echo ward" + ChatColor.GRAY + " at");
            lore.add(ChatColor.GRAY + "your location. " + ChatColor.AQUA + "Echo wards");
            lore.add(ChatColor.GRAY + "are removed when you change");
            lore.add(ChatColor.GRAY + "dimension, die, or log out");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Echo Stone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    SWOERS_WILL {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FILLED_MAP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Sower's Will");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Once one of the minions of a");
            lore.add(ChatColor.GRAY + "mighty necromancer, this farmhand's work");
            lore.add(ChatColor.GRAY + " work still continues after death,");
            lore.add(" ");
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sower's Will");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    NUTRI_BAR {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BRICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Nutri Bar");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Can be eaten to get a good");
            lore.add(ChatColor.GRAY + "saturation boost for a minute");
            lore.add(ChatColor.GRAY + "or two.");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Nutri Bar");
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    MEATY_STEW {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.RABBIT_STEW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Meaty Stew");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Can be eaten to gain");
            lore.add(ChatColor.RED + "+5 ❁ Strength " + ChatColor.GRAY + "permanently");
            lore.add(" ");
            lore.add(ChatColor.RED + "You can only consume three of");
            lore.add(ChatColor.RED + "this type of soup!");
            lore.add(" ");
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Meaty Stew");
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    MAGIC_STEW {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MUSHROOM_STEW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Magic Stew");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Can be eaten to gain");
            lore.add(ChatColor.AQUA + "+15 ✎ Intelligence " + ChatColor.GRAY + "permanently");
            lore.add(" ");
            lore.add(ChatColor.RED + "You can only consume three of");
            lore.add(ChatColor.RED + "this type of soup!");
            lore.add(" ");
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Magic Stew");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    BOAR_TOTEM {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Totem of Boar's Strength");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Gives you " + ChatColor.RED + "+5% ❁ Strength");
            lore.add(ChatColor.GRAY + "when held in either hand.");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Totem of Boar's Strength");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"StrengthModifier"), PersistentDataType.DOUBLE, 0.08);



            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    BADGER_TOTEM {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Totem of Badger's Strength");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Gives you " + ChatColor.RED + "+12% ❁ Strength");
            lore.add(ChatColor.GRAY + "when held in either hand.");
            lore.add(" ");
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Totem of Badger's Strength");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"StrengthModifier"), PersistentDataType.DOUBLE, 0.15);
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    BONE_NEEDLE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Bone Needle");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Item Ability: Blood Sacrifice " + ChatColor.YELLOW + "§lRIGHT-CLICK");
            lore.add(ChatColor.GRAY + "Take " + ChatColor.RED + "20 damage " + ChatColor.GRAY +"and");
            lore.add(ChatColor.GRAY + "gain " + ChatColor.AQUA + "+12 ✎ mana");
            lore.add(" ");
            lore.add(ChatColor.GREEN + "§lUNCOMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Bone Needle");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.setLore(lore);

            item.setItemMeta(meta);

            return item;
        }
    },

//----------------------------------------WEAPONS SECTION c:weapons-----------------------------------------------------

    MOON_GLOVE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHORUS_FLOWER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Moon Glove");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "This glove can manipulate gravity");
            lore.add(ChatColor.GRAY + "and send enemies you strike flying.");
            lore.add(" ");
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC SWORD");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Moon Glove");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    ASPECT_OF_THE_END {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Aspect of The End");
            meta.setUnbreakable(true);
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Item Ability: Instant Transmission" + ChatColor.YELLOW + " §l§lRIGHT-CLICK");
            lore.add(ChatColor.GRAY + "Teleport forward 8 blocks.");
            lore.add(ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "40");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE SWORD");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Aspect of The End");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    PUFFERFISH_CANON {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_HORSE_ARMOR, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Pufferfish Canon");
            meta.setUnbreakable(true);
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Item Ability: Puffy Projectile" + ChatColor.YELLOW +  " §lRIGHT-CLICK");
            lore.add(ChatColor.GRAY + "Launch a pufferfish to attack");
            lore.add(ChatColor.GRAY + "your enemies.");
            lore.add(ChatColor.DARK_GRAY + "Mana Cost:" + ChatColor.AQUA + " 30");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE WAND");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Pufferfish Canon");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "wand");
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },

    LESSER_HEAL_WAND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Lesser Wand of Healing");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.YELLOW + "Item Ability: Minor Heal " + ChatColor.GOLD + "§lRIGHT-CLICK");
            lore.add(ChatColor.GRAY + "Heal for" + ChatColor.RED + " ❤ 40");
            lore.add(ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "8s");
            lore.add(ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "20");
            lore.add(" ");
            lore.add(ChatColor.GREEN + "§lUNCOMMON WAND");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lesser Wand of Healing");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    HEAL_WAND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Wand of Healing");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.YELLOW + "Item Ability: Heal " + ChatColor.GOLD + "§lRIGHT-CLICK");
            lore.add(ChatColor.GRAY + "Heal for" + ChatColor.RED + " ❤ 75");
            lore.add(ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "7s");
            lore.add(ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "35");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE WAND");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Wand of Healing");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    FLASH_HEAL_WAND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Chain Heal Wand");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.YELLOW + "Item Ability: Hasty Heal " + ChatColor.GOLD + "§lRIGHT-CLICK");
            lore.add(ChatColor.GRAY + "Heal for" + ChatColor.RED + " ❤ 40");
            lore.add(ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "2s");
            lore.add(ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "25");
            lore.add(" ");
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC WAND");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Chain Heal Wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    GREATER_HEAL_WAND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Greater Heal Wand");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.YELLOW + "Item Ability: Major Heal " + ChatColor.GOLD + "§lRIGHT-CLICK");
            lore.add(ChatColor.GRAY + "Heal for" + ChatColor.RED + " ❤ 100");
            lore.add(ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "7s");
            lore.add(ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "40");
            lore.add(" ");
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC WAND");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Greater Wand of Healing");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    STONE_SCIMITAR {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.GREEN + "Stone Scimitar");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+25");
            lore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "§c+15");
            lore.add(" ");
            lore.add(ChatColor.GREEN + "§lUNCOMMON SWORD");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Stone Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    IRON_SCIMITAR {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.GREEN + "Iron Scimitar");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Damage: " +  ChatColor.RED +"+20");
            lore.add(ChatColor.GRAY + "Crit Chance: " + ChatColor.RED + "+10");
            lore.add(ChatColor.GRAY + "Crit Damage: " + ChatColor.RED +"+20");
            lore.add(" ");
            lore.add(ChatColor.GREEN + "§lUNCOMMON SWORD");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Iron Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    GOLD_SCIMITAR {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.GREEN + "Golden Scimitar");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED +"+15");
            lore.add(ChatColor.GRAY + "Crit Damage: " + ChatColor.RED + "+15");
            lore.add(" ");
            lore.add(ChatColor.GREEN + "§lUNCOMMON SWORD");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gold Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    DIAMOND_SCIMITAR {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.GREEN + "Diamond Scimitar");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+40");
            lore.add(ChatColor.GRAY + "Crit Damage: " + ChatColor.RED + "+25");
            lore.add(ChatColor.GRAY +"Strength: " + ChatColor.RED + "+25");
            lore.add(" ");
            lore.add(ChatColor.GREEN + "§lUNCOMMON SWORD");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Diamond Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    NETHERITE_SCIMITAR {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.GREEN + "Netherite Scimitar");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+60");
            lore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+25");
            lore.add(" ");
            lore.add(ChatColor.GREEN + "§lUNCOMMON SWORD");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Netherite Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    TNT_WAND {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Tnt Wand");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.YELLOW + "Item Ability: Hurl Tnt " + ChatColor.GOLD + "§lRIGHT-CLICK");
            lore.add(ChatColor.GRAY + "Launch a tnt forward dealing");
            lore.add(ChatColor.RED + "100 " + ChatColor.GRAY + "magic damage");
            lore.add(ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "35");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE WAND");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tnt Wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            return item;
        }
    },

    BAMBOO_SHORTBOW {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BOW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Bamboo Shortbow");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+20");
            lore.add(ChatColor.GRAY + "Crit Damage: " + ChatColor.RED + "+15");
            lore.add(" ");
            lore.add(ChatColor.GRAY + "Gain " + ChatColor.WHITE + "+8 ✦ Speed " + ChatColor.GRAY + "for");
            lore.add(ChatColor.GREEN + "10s " + ChatColor.GRAY + "when you kill an enemy.");
            lore.add(ChatColor.BLUE + "§lRARE BOW");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "bow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Bamboo Shortbow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    MEAT_CLEAVER {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Meat Cleaver");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+30");
            lore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+40");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE SWORD");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Meat Cleaver");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    SIMPLE_SHIELD_BASE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.GREEN + "Simple Shield Base");
            List<String> lore = new ArrayList<>();
            lore.add(" ");
            lore.add(ChatColor.GREEN + "§lUNCOMMON SHIELD");
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.LIGHT_GRAY);
            banner.addPattern(new Pattern(DyeColor.GRAY, PatternType.BORDER));
            banner.addPattern(new Pattern(DyeColor.LIGHT_GRAY, PatternType.GRADIENT));
            banner.addPattern(new Pattern(DyeColor.LIGHT_GRAY, PatternType.GRADIENT_UP));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 2.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Simple Shield Base");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setBlockState(banner);
            item.setItemMeta(meta);

            return item;
        }
    },

    CACTUS_SHIELD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Cactus Shield");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Crit Damage: " + ChatColor.RED + "+12");
            lore.add(ChatColor.GRAY + "Defense: " + ChatColor.GREEN + "+25");
            lore.add(" ");
            lore.add(ChatColor.GRAY + "Deal " + ChatColor.BLUE + "2x your ☠ Crit Damage");
            lore.add(ChatColor.GRAY + "to your attacker when you block");
            lore.add(ChatColor.GRAY + "an attack.");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE SHIELD");
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.BLACK);
            banner.addPattern(new Pattern(DyeColor.GREEN, PatternType.BRICKS));
            banner.addPattern(new Pattern(DyeColor.GREEN, PatternType.STRIPE_SMALL));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setBlockState(banner);
            item.setItemMeta(meta);

            return item;
        }
    },

    SPARKLING_SHIELD {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Sparkling Shield");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Defense: " + ChatColor.GREEN + "+20");
            lore.add(ChatColor.GRAY + "Intelligence: " + ChatColor.GREEN + "+30");
            lore.add(" ");
            lore.add(ChatColor.GRAY + "Gain " + ChatColor.AQUA + "+50 ✎ Mana" + ChatColor.GRAY + " and" + ChatColor.DARK_GRAY + " blind");
            lore.add(ChatColor.GRAY + "the attacker for time based on");
            lore.add(ChatColor.GRAY + "your current " + ChatColor.AQUA + "mana " + ChatColor.GRAY + "reducing their");
            lore.add(ChatColor.GRAY + "damage by " + ChatColor.RED + "4% " + ChatColor.GRAY + "for the duration of");
            lore.add(ChatColor.GRAY + "the blind when you block.");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE SHIELD");
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.MAGENTA);
            banner.addPattern(new Pattern(DyeColor.PURPLE, PatternType.GRADIENT));
            banner.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.FLOWER));
            banner.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CIRCLE_MIDDLE));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 4.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sparkling Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setBlockState(banner);
            item.setItemMeta(meta);

            return item;
        }
    },

//------------------------------------------ARMOR SECTION c:armor-------------------------------------------------------

    THE_DRIP {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(94,175,184));
            meta.setDisplayName(ChatColor.BLUE + "The Drip");
            meta.setUnbreakable(true);
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "You got the drip");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE BOOTS");
            meta.setLore(lore);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "The Drip");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    SUPREME_DRIP {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(70,126,133));
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Supreme Drip™");
            meta.setUnbreakable(true);
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "§lEPIC BOOTS");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Supreme Drip™");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);

            return item;
        }
    },

    ALLOY_HELMET {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Alloy Helmet");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "+15");
            lore.add(ChatColor.GRAY + "Defense: " + ChatColor.GREEN + "+25");
            lore.add(ChatColor.GRAY + "Strength: " + ChatColor.GREEN + "+5");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE HELMET");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    ALLOY_CHESTPLATE {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Alloy Chestplate");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "+30");
            lore.add(ChatColor.GRAY + "Defense: " + ChatColor.GREEN + "+60");
            lore.add(ChatColor.GRAY + "Strength: " + ChatColor.GREEN + "+15");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE CHESTPLATE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    ALLOY_LEGGINGS {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Alloy Leggings");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "+25");
            lore.add(ChatColor.GRAY + "Defense: " + ChatColor.GREEN + "+45");
            lore.add(ChatColor.GRAY + "Strength: " + ChatColor.GREEN + "+10");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE LEGGINGS");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 45.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    ALLOY_BOOTS {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.BLUE + "Alloy Boots");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "+10");
            lore.add(ChatColor.GRAY + "Defense: " + ChatColor.GREEN + "+25");
            lore.add(ChatColor.GRAY + "Strength: " + ChatColor.GREEN + "+5");
            lore.add(" ");
            lore.add(ChatColor.BLUE + "§lRARE LEGGINGS");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);

            return item;
        }
    },

    ALLMIGHTY {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmQyOWZlYWNiNmVmNGE0NTI5ZjVlYTg0MDE3NTUyY2EzNzg2YjE5N2NiZDhmMmQ1MzMwYTRlZGNjZWQ1MSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.RED + "Almighty Helmet");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "The most powerful piece of armor");
            lore.add(ChatColor.GRAY + "used by higher beings when");
            lore.add(ChatColor.GRAY + "testing the limits of their");
            lore.add(ChatColor.GRAY + "Creations");
            lore.add(" ");
            lore.add(ChatColor.RED + "§lSPECIAL HELMET");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Almighty Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "SPECIAL");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 10000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 10000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 10000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 10000.0);

            meta.setLore(lore);
            item.setItemMeta(meta);

            return item;
        }
    },
    ;

    public abstract ItemStack getItem(Plugin plugin);

    public static void registerRecipes(Plugin plugin) {
        // Shaped Recipe for Fire Ball Name
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("testitem_s"), Items.TEST_FIREBALL.getItem(plugin));
        sr.shape("S S",
                " F ",
                "S S");
        sr.setIngredient('S', Material.STICK);
        sr.setIngredient('F', Material.FIRE_CHARGE);
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Fire Ball Name
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("testitem_sl"), Items.TEST_FIREBALL.getItem(plugin));
        slr.addIngredient(1, Material.BLAZE_ROD);
        slr.addIngredient(1, Material.COAL_BLOCK);
        slr.addIngredient(1, Material.FIREWORK_STAR);
        Bukkit.getServer().addRecipe(slr);

        // Furnace Recipe for Fire Ball Name
        FurnaceRecipe fr = new FurnaceRecipe(NamespacedKey.minecraft("testitem_f"), Items.TEST_FIREBALL.getItem(plugin),
                Material.FIRE_CHARGE, 20.0f, 40);
        Bukkit.getServer().addRecipe(fr);

        //Shaped recipe for Test Shortbow
        sr = new ShapedRecipe(NamespacedKey.minecraft("test_bow_s"), Items.SHORTBOW.getItem(plugin));
        sr.shape("  S",
                 " S ",
                 "S  ");
        sr.setIngredient('S', Material.STRING);
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Dripstone
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_dripstone_sl"), Items.ENCHANTED_DRIPSTONE.getItem(plugin));
        slr.addIngredient(5, Material.POINTED_DRIPSTONE);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe 1 for Enchanted Deepslate
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_deepslate1_sl"), Items.ENCHANTED_DEEPSLATE.getItem(plugin));
        slr.addIngredient(9, Material.DEEPSLATE);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe 2 for Enchanted Deepslate
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_deepslate2_sl"), Items.ENCHANTED_DEEPSLATE.getItem(plugin));
        slr.addIngredient(9, Material.COBBLED_DEEPSLATE);
        Bukkit.getServer().addRecipe(slr);

        // Shaped Recipe for Enchanted Polished Deepslate
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_deepslate"), Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin));
        sr.shape("DDD",
                 "DDD",
                 "DDD");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DEEPSLATE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);


        // Shaped Recipe for Enchanted Dripstone Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_dripstone"), Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin));
        sr.shape("DdD",
                 "ddd",
                 "DdD");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DEEPSLATE.getItem(plugin)));
        sr.setIngredient('d', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIPSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);


        // Shapeless Recipe for Enchanted Iron
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_iron_sl"), Items.ENCHANTED_IRON.getItem(plugin));
        slr.addIngredient(8, Material.IRON_INGOT);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Iron Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_iron_s"), Items.ENCHANTED_IRON_BLOCK .getItem(plugin));
        sr.shape("III",
                 "III",
                 "III");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);


        //Less recipe for Enchanted Coal
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_coal_sl"), Items.ENCHANTED_COAL.getItem(plugin));
        slr.addIngredient(8, Material.COAL);
        Bukkit.getServer().addRecipe(slr);


        //Shaped recipe for Enchanted Coal Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_coal_s"), Items.ENCHANTED_COAL_BLOCK.getItem(plugin));
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COAL.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Bamboo
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_bamboo_sl"), Items.ENCHANTED_BAMBOO.getItem(plugin));
        slr.addIngredient(9, Material.BAMBOO);
        Bukkit.getServer().addRecipe(slr);


        //Shaped recipe for Enchanted Bamboo Bundle
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_bamboo_s"), Items.BAMBOO_BUNDLE.getItem(plugin));
        sr.shape("BBB",
                 "BBB",
                 "BBB");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BAMBOO.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);


        // Shapeless Recipe for Enchanted Feather
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_feather_sl"), Items.ENCHANTED_FEATHER.getItem(plugin));
        slr.addIngredient(9, Material.FEATHER);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Phantom Membrane
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_membrane_sl"), Items.ENCHANTED_MEMBRANE.getItem(plugin));
        slr.addIngredient(9, Material.PHANTOM_MEMBRANE);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Gold
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_gold_sl"), Items.ENCHANTED_GOLD.getItem(plugin));
        slr.addIngredient(8, Material.GOLD_INGOT);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Gold Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_gold_s"), Items.ENCHANTED_GOLD_BLOCK.getItem(plugin));
        sr.shape("GGG",
                 "GGG",
                 "GGG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Sand
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_sand_sl"), Items.ENCHANTED_SAND.getItem(plugin));
        slr.addIngredient(9, Material.SAND);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Compacted Sand
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_sand_s"), Items.ENCHANTED_COMPACTED_SAND.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SAND.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Enchanted Sandstone
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_sand_s"), Items.ENCHANTED_SANDSTONE.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_COMPACTED_SAND.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Copper
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_copper_sl"), Items.ENCHANTED_COPPER.getItem(plugin));
        slr.addIngredient(8, Material.COPPER_INGOT);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Copper Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_copper_s"), Items.ENCHANTED_COPPER_BLOCK.getItem(plugin));
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Enchanted Cut Copper Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_copper_s"), Items.ENCHANTED_CUT_COPPER.getItem(plugin));
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Quartz
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_quartz_sl"), Items.ENCHANTED_QUARTZ.getItem(plugin));
        slr.addIngredient(8, Material.QUARTZ);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Quartz Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_quartz_s"), Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin));
        sr.shape("QQQ",
                 "QQQ",
                 "QQQ");
        sr.setIngredient('Q', new RecipeChoice.ExactChoice(Items.ENCHANTED_QUARTZ.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Enchanted Quartz Sculpture
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_quartz_s"), Items.ENCHANTED_QUARTZ_SCULPTURE.getItem(plugin));
        sr.shape("QQQ",
                 "QQQ",
                 "QQQ");
        sr.setIngredient('Q', new RecipeChoice.ExactChoice(Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Alloy
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_s"), Items.ALLOY.getItem(plugin));
        sr.shape("CIC",
                 "ICI",
                 "CIC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Cobblestone
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_cobble_sl"), Items.ENCHANTED_COBBLESTONE.getItem(plugin));
        slr.addIngredient(9, Material.COBBLESTONE);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Diamond
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_diamond_sl"), Items.ENCHANTED_DIAMOND.getItem(plugin));
        slr.addIngredient(8, Material.DIAMOND);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Emerald
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_emerald_sl"), Items.ENCHANTED_EMERALD.getItem(plugin));
        slr.addIngredient(8, Material.EMERALD);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Wool
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_wool_sl"), Items.ENCHANTED_WOOL.getItem(plugin));
        slr.addIngredient(9, Material.WHITE_WOOL);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Mutton
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_mutton_sl"), Items.ENCHANTED_MUTTON.getItem(plugin));
        slr.addIngredient(9, Material.MUTTON);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Chicken
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_chicken_sl"), Items.ENCHANTED_CHICKEN.getItem(plugin));
        slr.addIngredient(9, Material.CHICKEN);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Beef
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_beef_sl"), Items.ENCHANTED_BEEF.getItem(plugin));
        slr.addIngredient(9, Material.BEEF);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Leather
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_leather_sl"), Items.ENCHANTED_LEATHER.getItem(plugin));
        slr.addIngredient(9, Material.LEATHER);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Pork
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_pork_sl"), Items.ENCHANTED_PORK.getItem(plugin));
        slr.addIngredient(9, Material.PORKCHOP);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Rabbit
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_rabbit_sl"), Items.ENCHANTED_RABBIT.getItem(plugin));
        slr.addIngredient(9, Material.RABBIT);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Tropical Fish
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_clown_sl"), Items.ENCHANTED_CLOWNFISH.getItem(plugin));
        slr.addIngredient(9, Material.TROPICAL_FISH);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Pufferfish
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_puffer_sl"), Items.ENCHANTED_PUFFERFISH.getItem(plugin));
        slr.addIngredient(9, Material.PUFFERFISH);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Cod
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_cod_sl"), Items.ENCHANTED_COD.getItem(plugin));
        slr.addIngredient(9, Material.COD);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Cooked Cod
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_cod_s"), Items.ENCHANTED_COOKED_COD.getItem(plugin));
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Salmon
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_salmon_sl"), Items.ENCHANTED_SALMON.getItem(plugin));
        slr.addIngredient(9, Material.SALMON);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Cooked Salmon
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_salmon_s"), Items.ENCHANTED_COOKED_SALMON.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SALMON.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Kelp
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_kelp_sl"), Items.ENCHANTED_KELP.getItem(plugin));
        slr.addIngredient(9, Material.KELP);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Dried Kelp
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_kelp_s"), Items.ENCHANTED_DRIED_KELP.getItem(plugin));
        sr.shape("KKK",
                 "KKK",
                 "KKK");
        sr.setIngredient('K', new RecipeChoice.ExactChoice(Items.ENCHANTED_KELP.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Kelp Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_kelp_s"), Items.ENCHANTED_KELP_BLOCK.getItem(plugin));
        sr.shape("KKK",
                 "KKK",
                 "KKK");
        sr.setIngredient('K', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIED_KELP.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Lapis
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_lapis_sl"), Items.ENCHANTED_LAPIS.getItem(plugin));
        slr.addIngredient(8, Material.LAPIS_LAZULI);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Lapis Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_lapis_s"), Items.ENCHANTED_LAPIS_BLOCK.getItem(plugin));
        sr.shape("LLL",
                 "LLL",
                 "LLL");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Redstone
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_redstone_sl"), Items.ENCHANTED_REDSTONE.getItem(plugin));
        slr.addIngredient(8, Material.REDSTONE);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Redstone Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_redstone_s"), Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin));
        sr.shape("RRR",
                 "RRR",
                 "RRR");
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Netherite Scrap
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_netherite_sl"), Items.ENCHANTED_NETHERITE.getItem(plugin));
        slr.addIngredient(5, Material.NETHERITE_SCRAP);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Netherite Ingot
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_netherite_s"), Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin));
        sr.shape("NNN",
                 "N G",
                 "GGG");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.ENCHANTED_NETHERITE.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Netherite Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_netherite_s"), Items.ENCHANTED_NETHERITE_BLOCK.getItem(plugin));
        sr.shape(" N ",
                 "NNN",
                 " N ");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Feather Charm
        sr = new ShapedRecipe(NamespacedKey.minecraft("fcharm_s"), Items.FEATHER_CHARM.getItem(plugin));
        sr.shape("FFF",
                 "F F",
                 "FFF");
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_FEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Lesser Healing Wand
        slr = new ShapelessRecipe(NamespacedKey.minecraft("lheal_wand_sl"), Items.LESSER_HEAL_WAND.getItem(plugin));
        slr.addIngredient(2, Material.STICK);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Stone Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("stone_scimitar_s"), Items.STONE_SCIMITAR.getItem(plugin));
        sr.shape("  C",
                 " C ",
                 "S  ");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COBBLESTONE.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Iron Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("iron_scimitar_s"), Items.IRON_SCIMITAR.getItem(plugin));
        sr.shape("  I",
                 " I ",
                 "S  ");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Gold Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("gold_scimitar_s"), Items.GOLD_SCIMITAR.getItem(plugin));
        sr.shape("  G",
                 " G ",
                 "S  ");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Diamond Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("diamond_scimitar_s"), Items.DIAMOND_SCIMITAR.getItem(plugin));
        sr.shape("  D",
                 " D ",
                 "S  ");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Netherite Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("netherite_scimitar_s"), Items.NETHERITE_SCIMITAR.getItem(plugin));
        sr.shape("  N",
                 " N ",
                 "S  ");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.ENCHANTED_NETHERITE.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for The Drip
        sr = new ShapedRecipe(NamespacedKey.minecraft("the_drip_s"), Items.THE_DRIP.getItem(plugin));
        sr.shape("   ",
                 "D D",
                 "D D");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIPSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for The Drip™
        sr = new ShapedRecipe(NamespacedKey.minecraft("the_driptm_s"), Items.SUPREME_DRIP.getItem(plugin));
        sr.shape("ddd",
                 "DBD",
                 "DDD");
        sr.setIngredient('d', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIPSTONE.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.THE_DRIP.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Alloy Helmet
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_helm_s"), Items.ALLOY_HELMET.getItem(plugin));
        sr.shape("AAA",
                 "A A",
                 "   ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Alloy Chestplate
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_chest_s"), Items.ALLOY_CHESTPLATE.getItem(plugin));
        sr.shape("A A",
                 "AAA",
                 "AAA");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Alloy Leggings
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_legs_s"), Items.ALLOY_LEGGINGS.getItem(plugin));
        sr.shape("AAA",
                 "A A",
                 "A A");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Alloy Leggings
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_boots_s"), Items.ALLOY_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "A A",
                 "A A");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Rotten Flesh
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_flesh_sl"), Items.ENCHANTED_ROTTEN_FLESH.getItem(plugin));
        slr.addIngredient(9, Material.ROTTEN_FLESH);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Bone 1
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_bone_sl1"), Items.ENCHANTED_BONE.getItem(plugin));
        slr.addIngredient(9, Material.BONE);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Bone 2
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_bone_sl2"), Items.ENCHANTED_BONE.getItem(plugin));
        slr.addIngredient(4, Material.BONE_BLOCK);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Bone Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_bone_s"), Items.ENCHANTED_BONE_BLOCK.getItem(plugin));
        sr.shape("BBB",
                 "BBB",
                 "BBB");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted String
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_string_sl"), Items.ENCHANTED_STRING.getItem(plugin));
        slr.addIngredient(8, Material.STRING);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Web
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_string_s"), Items.ENCHANTED_WEB.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_STRING.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Spider Eye
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_seye_sl"), Items.ENCHANTED_SPIDER_EYE.getItem(plugin));
        slr.addIngredient(9, Material.SPIDER_EYE);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Amethyst 1
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_amethyst_sl1"), Items.ENCHANTED_AMETHYST.getItem(plugin));
        slr.addIngredient(9, Material.AMETHYST_SHARD);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Amethyst 2
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_amethyst_sl2"), Items.ENCHANTED_AMETHYST.getItem(plugin));
        slr.addIngredient(4, Material.AMETHYST_BLOCK);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Amethyst Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_amethyst_s"), Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin));
        sr.shape("AAA",
                 "AAA",
                 "AAA");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Ink Sac
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_ink_sl"), Items.ENCHANTED_INK_SAC.getItem(plugin));
        slr.addIngredient(9, Material.INK_SAC);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Ink Sac
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_ink_s"), Items.ENCHANTED_GLOW_SAC.getItem(plugin));
        sr.shape("GGG",
                 "GIG",
                 "GGG");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_INK_SAC.getItem(plugin)));
        sr.setIngredient('G', Material.GLOW_INK_SAC);
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Cocoa Beans
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_cocoa_sl"), Items.ENCHANTED_COCOA.getItem(plugin));
        slr.addIngredient(9, Material.COCOA_BEANS);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Snowball
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_snow_sl"), Items.ENCHANTED_SNOWBALL.getItem(plugin));
        slr.addIngredient(9, Material.SNOWBALL);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Snow
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_snow_s"), Items.ENCHANTED_SNOW.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SNOWBALL.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Snow Mound
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_snow_s"), Items.SNOW_MOUND.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SNOW.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Gunpowder
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_gunpowder_sl"), Items.ENCHANTED_GUNPOWDER.getItem(plugin));
        slr.addIngredient(9, Material.GUNPOWDER);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Powder Ball
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_gunpowder_s"), Items.ENCHANTED_POWDER_BALL.getItem(plugin));
        sr.shape("GGG",
                 "GGG",
                 "GGG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GUNPOWDER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Enchanted Tnt
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_gunpowder_s"), Items.ENCHANTED_TNT.getItem(plugin));
        sr.shape("GSG",
                 "SGS",
                 "GSG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GUNPOWDER.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_COMPACTED_SAND.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Clay
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_clay_sl"), Items.ENCHANTED_CLAY.getItem(plugin));
        slr.addIngredient(9, Material.CLAY_BALL);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Clay Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_clay_s"), Items.ENCHANTED_CLAY_BLOCK.getItem(plugin));
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CLAY.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Glowstone Dust
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_glowstone_sl"), Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin));
        slr.addIngredient(9, Material.GLOWSTONE_DUST);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Glowstone Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_glowstone_s"), Items.ENCHANTED_GLOWSTONE.getItem(plugin));
        sr.shape("GGG",
                 "GGG",
                 "GGG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Blaze Powder
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_blaze_sl"), Items.ENCHANTED_BLAZE_POWDER.getItem(plugin));
        slr.addIngredient(9, Material.BLAZE_POWDER);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Blaze Rod
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_blaze_s"), Items.ENCHANTED_BLAZE_ROD.getItem(plugin));
        sr.shape("BBB",
                 "BBB",
                 "BBB");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BLAZE_POWDER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Ender Pearl
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_pearl_sl"), Items.ENCHANTED_ENDER_PEARL.getItem(plugin));
        slr.addIngredient(9, Material.ENDER_PEARL);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Eye of Ender
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_eeye_s"), Items.ENCHANTED_ENDER_EYE.getItem(plugin));
        sr.shape(" P ",
                 "PBP",
                 " P ");
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_ENDER_PEARL.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BLAZE_POWDER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Nether Wart
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_wart_sl"), Items.ENCHANTED_WART.getItem(plugin));
        slr.addIngredient(8, Material.NETHER_WART);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Sweet Berries
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_sberries_sl"), Items.ENCHANTED_SWEET_BERRIES.getItem(plugin));
        slr.addIngredient(9, Material.SWEET_BERRIES);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Sugar Cane
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_cane_sl"), Items.ENCHANTED_SUGAR_CANE.getItem(plugin));
        slr.addIngredient(9, Material.SUGAR_CANE);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Sugar 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_sugar_s1"), Items.ENCHANTED_SUGAR.getItem(plugin));
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_SUGAR_CANE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Enchanted Sugar 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_sugar_s2"), Items.ENCHANTED_SUGAR.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SWEET_BERRIES.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Chrous Fruit
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_fruit_sl"), Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin));
        slr.addIngredient(9, Material.CHORUS_FRUIT);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchant Popped Chorus Fruit
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_fruit_s"), Items.ENCHANTED_POPPED_CHORUS_FRUIT.getItem(plugin));
        sr.shape("FFF",
                 "FFF",
                 "FFF");
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Carrot
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_carrot_sl"), Items.ENCHANTED_CARROT.getItem(plugin));
        slr.addIngredient(9, Material.CARROT);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchant Golden Carrot
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_carrot_s"), Items.ENCHANTED_GOLDEN_CARROT.getItem(plugin));
        sr.shape("GCG",
                 "CCC",
                 "GCG");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CARROT.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Potato
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_potato_sl"), Items.ENCHANTED_POTATO.getItem(plugin));
        slr.addIngredient(9, Material.POTATO);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchant Baked Potato
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_potato_s"), Items.ENCHANTED_BAKED_POTATO.getItem(plugin));
        sr.shape("PPP",
                 "PPP",
                 "PPP");
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_POTATO.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Beetroot
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_beet_sl"), Items.ENCHANTED_BEETROOT.getItem(plugin));
        slr.addIngredient(9, Material.BEETROOT);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchant Beetroot Soup
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_beet_s"), Items.ENCHANTED_BEETROOT_SOUP.getItem(plugin));
        sr.shape("BBB",
                 "BBB",
                 " b ");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BEETROOT.getItem(plugin)));
        sr.setIngredient('b', Material.BOWL);
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Melon Slice
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_melon_sl"), Items.ENCHANTED_MELON_SLICE.getItem(plugin));
        slr.addIngredient(8, Material.MELON_SLICE);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchant Melon
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_melon_s"), Items.ENCHANTED_MELON.getItem(plugin));
        sr.shape("MMM",
                 "MMM",
                 "MMM");
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.ENCHANTED_MELON_SLICE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Brown Mushroom
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_mushroom_sl1"), Items.ENCHANTED_BROWN_MUSHROOM.getItem(plugin));
        slr.addIngredient(8, Material.BROWN_MUSHROOM);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Red Mushroom
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_mushroom_sl2"), Items.ENCHANTED_RED_MUSHROOM.getItem(plugin));
        slr.addIngredient(8, Material.RED_MUSHROOM);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Flint
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_flint_sl"), Items.ENCHANTED_FLINT.getItem(plugin));
        slr.addIngredient(9, Material.FLINT);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Pumpkin
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_pumpkin_sl"), Items.ENCHANTED_PUMPKIN.getItem(plugin));
        slr.addIngredient(9, Material.PUMPKIN);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Cactus
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_cactus_sl"), Items.ENCHANTED_CACTUS.getItem(plugin));
        slr.addIngredient(9, Material.CACTUS);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Soul Sand
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_soul_sl1"), Items.ENCHANTED_SOUL_SAND.getItem(plugin));
        slr.addIngredient(9, Material.SOUL_SAND);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Soul Sand
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_soul_sl2"), Items.ENCHANTED_SOUL_SOIL.getItem(plugin));
        slr.addIngredient(9, Material.SOUL_SOIL);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Oak Wood
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_oak_sl"), Items.ENCHANTED_OAK_WOOD.getItem(plugin));
        slr.addIngredient(9, Material.OAK_LOG);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Dark Oak Wood
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_doak_sl"), Items.ENCHANTED_DARK_OAK_WOOD.getItem(plugin));
        slr.addIngredient(9, Material.DARK_OAK_LOG);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Birch Wood
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_birch_sl"), Items.ENCHANTED_BIRCH_WOOD.getItem(plugin));
        slr.addIngredient(9, Material.BIRCH_LOG);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Acacia Wood
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_acacia_sl"), Items.ENCHANTED_ACACIA_WOOD.getItem(plugin));
        slr.addIngredient(9, Material.ACACIA_LOG);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Spruce Wood
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_spruce_sl"), Items.ENCHANTED_SPRUCE_WOOD.getItem(plugin));
        slr.addIngredient(9, Material.SPRUCE_LOG);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Jungle Wood
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_jungle_sl"), Items.ENCHANTED_JUNGLE_WOOD.getItem(plugin));
        slr.addIngredient(9, Material.JUNGLE_LOG);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Warped Stem
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_warped_sl"), Items.ENCHANTED_WARPED_STEM.getItem(plugin));
        slr.addIngredient(9, Material.WARPED_STEM);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted Crimson Stem
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_crimson_sl"), Items.ENCHANTED_CRIMSON_STEM.getItem(plugin));
        slr.addIngredient(9, Material.CRIMSON_STEM);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe for Enchanted End Stone
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_endstone_sl"), Items.ENCHANTED_ENDSTONE.getItem(plugin));
        slr.addIngredient(9, Material.END_STONE);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Aspect of The End
        sr = new ShapedRecipe(NamespacedKey.minecraft("aote_s"), Items.ASPECT_OF_THE_END.getItem(plugin));
        sr.shape(" E ",
                 " E ",
                 " D ");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_ENDER_EYE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Tnt Wand
        sr = new ShapedRecipe(NamespacedKey.minecraft("tnt_wand_s"), Items.TNT_WAND.getItem(plugin));
        sr.shape("  T",
                 " A ",
                 "A  ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.ENCHANTED_TNT.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Pufferfish Canon
        sr = new ShapedRecipe(NamespacedKey.minecraft("puffer_canon_s"), Items.PUFFERFISH_CANON.getItem(plugin));
        sr.shape("   ",
                 "IPP",
                 "AAR");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PUFFERFISH.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bamboo Shortbow
        sr = new ShapedRecipe(NamespacedKey.minecraft("bamboo_shortbow_s"), Items.BAMBOO_SHORTBOW.getItem(plugin));
        sr.shape(" bs",
                 "B s",
                 " bs");
        sr.setIngredient('b', new RecipeChoice.ExactChoice(Items.ENCHANTED_BAMBOO.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.BAMBOO_BUNDLE.getItem(plugin)));
        sr.setIngredient('s', Material.STRING);

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Meat Cleaver
        sr = new ShapedRecipe(NamespacedKey.minecraft("meat_cleaver_s"), Items.MEAT_CLEAVER.getItem(plugin));
        sr.shape(" II",
                 " II",
                 " s ");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        sr.setIngredient('s', Material.STICK);

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Meaty Stew
        sr = new ShapedRecipe(NamespacedKey.minecraft("meat_stew_s"), Items.MEATY_STEW.getItem(plugin));
        sr.shape("FSC",
                 "BRL",
                 " b ");
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_COOKED_COD.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_COOKED_SALMON.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CHICKEN.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BEEF.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_RABBIT.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_MUTTON.getItem(plugin)));
        sr.setIngredient('b', Material.BOWL);

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Magic Stew
        sr = new ShapedRecipe(NamespacedKey.minecraft("magic_stew_s"), Items.MAGIC_STEW.getItem(plugin));
        sr.shape("SCQ",
                 "EGP",
                 " b ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SPIDER_EYE.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_POPPED_CHORUS_FRUIT.getItem(plugin)));
        sr.setIngredient('Q', new RecipeChoice.ExactChoice(Items.ENCHANTED_QUARTZ_SCULPTURE.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_ENDER_EYE.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOW_SAC.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_POWDER_BALL.getItem(plugin)));
        sr.setIngredient('b', Material.BOWL);

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bone Needle
        sr = new ShapedRecipe(NamespacedKey.minecraft("bone_needle_s"), Items.BONE_NEEDLE.getItem(plugin));
        sr.shape("  A",
                 "BF ",
                 " B ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BONE.getItem(plugin)));
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_FLINT.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Simple Shield Base
        sr = new ShapedRecipe(NamespacedKey.minecraft("simple_shield_s"), Items.SIMPLE_SHIELD_BASE.getItem(plugin));
        sr.shape("DOD",
                 "DWD",
                 " I ");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DARK_OAK_WOOD.getItem(plugin)));
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ENCHANTED_OAK_WOOD.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WOOL.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Cactus Shield
        sr = new ShapedRecipe(NamespacedKey.minecraft("cactus_shield_s"), Items.CACTUS_SHIELD.getItem(plugin));
        sr.shape("CCC",
                 "CSC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CACTUS.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Sparking Shield
        sr = new ShapedRecipe(NamespacedKey.minecraft("sparkling_shield_s"), Items.SPARKLING_SHIELD.getItem(plugin));
        sr.shape("III",
                 "ASA",
                 "GIG");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOW_SAC.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);
    }
}

//c:end