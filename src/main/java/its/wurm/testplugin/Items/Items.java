package its.wurm.testplugin.Items;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Inventories.FormatRecipesGUI;
import its.wurm.testplugin.persistentDataContainers.stringList;
import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

//c:beginning, c:start

public enum Items implements ItemLike {

    //c:test items

    TEST_FIREBALL(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FIRE_CHARGE);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Test Fireball");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "SPECIAL");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DEV_HAMMER(new String[] {
            ChatColor.GRAY + "Down any mob in one hit",
            ChatColor.GRAY + "with this mighty weapon"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_AXE);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Dev Hammer");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "SPECIAL");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MENU_GLASS(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, " ");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BACK_ARROW(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Back");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    PREVIOUS_ARROW(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Previous Page");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    NEXT_ARROW(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Next Page");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SHORTBOW(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BOW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"), PersistentDataType.DOUBLE, 666.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "type"), PersistentDataType.STRING, "bow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Test Shortbow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "SPECIAL");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ALMIGHTY(new String[] {
            ChatColor.GRAY + "The most powerful piece of armor",
            ChatColor.GRAY + "used by higher beings when",
            ChatColor.GRAY + "testing the limits of their",
            ChatColor.GRAY + "creations"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmQyOWZlYWNiNmVmNGE0NTI5ZjVlYTg0MDE3NTUyY2EzNzg2YjE5N2NiZDhmMmQ1MzMwYTRlZGNjZWQ1MSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Almighty Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "SPECIAL");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 10000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Magic"), PersistentDataType.DOUBLE, 1000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 10000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 10000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 10000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"uuid"), PersistentDataType.STRING, UUID.randomUUID().toString());
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CORE_OF_MAGIC(new String[] {
            ChatColor.GRAY + "An unstable node of",
            ChatColor.GRAY + "powerful magic contained",
            ChatColor.GRAY + "in a mana dampening",
            ChatColor.GRAY + "cage of metal"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTYzYmNhZjZkMjY3OWQ4ZDdkOWJmNmE0NzRhNDhhNzdhOGU5MTc0N2ExMDg0YzA5MjU2ZWJjODZjYjc0ODExIn19fQ==");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Core of Magic");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "SPECIAL");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 1000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 1000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 1000.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"uuid"), PersistentDataType.STRING, UUID.randomUUID().toString());
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GOLDEN_HARVEST(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_HOE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "MiningFortune"), PersistentDataType.DOUBLE, 250.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmingFortune"), PersistentDataType.DOUBLE, 250.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcavatingFortune"), PersistentDataType.DOUBLE, 250.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "type"), PersistentDataType.STRING, "hoe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Golden Harvest");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "SPECIAL");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

//------------------------------------------TEST ITEMS SECTION END x:test---------------------------------------------------
//---------------------------------MATERIALS SECTION c:mat--------------------------------------------------------------


    ENCHANTED_DRIPSTONE(new String[] {}, FormatRecipesGUI::newEnchantedDripstoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POINTED_DRIPSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Dripstone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_DEEPSLATE(new String[] {}, FormatRecipesGUI::newEnchantedDeepslateGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DEEPSLATE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Deepslate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_POLISHED_DEEPSLATE(new String[] {}, FormatRecipesGUI::newsEnchantedDeepslateGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POLISHED_DEEPSLATE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Polished Deepslate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_DEEPSLATE_TILES(new String[] {}, FormatRecipesGUI::newvsEnchantedDeepslateGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POLISHED_DEEPSLATE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Deepslate Tiles");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_DRIPSTONE_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedDripstoneRecipeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DRIPSTONE_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Dripstone Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_IRON(new String[] {}, FormatRecipesGUI::newEnchantedIronGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Iron");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_IRON_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedIronGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Iron Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COAL(new String[] {}, FormatRecipesGUI::newEnchantedCoalGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COAL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Coal");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COAL_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedCoalGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COAL_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Coal Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    COMPACTED_COAL_LUMP(new String[] {}, FormatRecipesGUI::newvsEnchantedCoal) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmRhN2RmMGM2NzYxNjMwNWNlZTI5ZTRlYTJlMzQwNjE1NDYzNjY5NWVmZWY5ZmY3MzVlZmQwMDc0YjAwMjg0YSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Compacted Coal Lump");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BAMBOO(new String[] {}, FormatRecipesGUI::newEnchantedBambooGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BAMBOO, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Bamboo");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BAMBOO_BUNDLE(new String[] {}, FormatRecipesGUI::newsEnchantedBambooGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGVlODRkNmYyZGJkZjdhM2M5MTlmNzdlYzIyZTZlZTI2NjFlMDE3M2E4YTk3MWUxMWM5ODAwMjIzNGU2NDE3ZiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bamboo Bundle");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_FEATHER(new String[] {}, FormatRecipesGUI::newEnchantedFeatherGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FEATHER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Feather");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_MEMBRANE(new String[] {}, FormatRecipesGUI::newEnchantedMembraneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PHANTOM_MEMBRANE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Phantom Membrane");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_GOLD(new String[] {}, FormatRecipesGUI::newEnchantedGoldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Gold");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_GOLD_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedGoldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLD_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Gold Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SAND(new String[] {}, FormatRecipesGUI::newEnchantedSandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SAND, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Sand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COMPACTED_SAND(new String[] {}, FormatRecipesGUI::newsEnchantedSandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SMOOTH_SANDSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Compacted Sand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SANDSTONE(new String[] {}, FormatRecipesGUI::newvsEnchantedSandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SANDSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Sandstone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COPPER(new String[] {}, FormatRecipesGUI::newEnchantedCopperGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COPPER_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Copper");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COPPER_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedCopperGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COPPER_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Copper Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_CUT_COPPER(new String[] {}, FormatRecipesGUI::newvsEnchantedCopperGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CUT_COPPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Cut Copper");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_QUARTZ(new String[] {}, FormatRecipesGUI::newEnchantedQuartzGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.QUARTZ, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Quartz");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_QUARTZ_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedQuartzGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.QUARTZ_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Quartz Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_QUARTZ_SCULPTURE(new String[] {}, FormatRecipesGUI::newvsEnchantedQuartzGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHISELED_QUARTZ_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Quartz Sculpture");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ALLOY(new String[] {}, FormatRecipesGUI::newAlloyGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Alloy");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COBBLESTONE(new String[] {}, FormatRecipesGUI::newEnchantedCobbleGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Cobblestone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_DIAMOND(new String[] {}, FormatRecipesGUI::newEnchantedDiamondGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DIAMOND, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Diamond");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_EMERALD(new String[] {}, FormatRecipesGUI::newEnchantedEmeraldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.EMERALD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Emerald");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_WOOL(new String[] {}, FormatRecipesGUI::newEnchantedWoolGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.WHITE_WOOL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Wool");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_MUTTON(new String[] {}, FormatRecipesGUI::newEnchantedMuttonGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MUTTON, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Mutton");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_CHICKEN(new String[] {}, FormatRecipesGUI::newEnchantedChickenGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHICKEN, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Chicken");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BEEF(new String[] {}, FormatRecipesGUI::newEnchantedBeefGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEEF, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Beef");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_LEATHER(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Leather");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_PORK(new String[] {}, FormatRecipesGUI::newEnchantedPorkGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PORKCHOP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Pork");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_RABBIT(new String[] {}, FormatRecipesGUI::newEnchantedRabbitGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.RABBIT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Rabbit");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_CLOWNFISH(new String[] {}, FormatRecipesGUI::newEnchantedClownGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TROPICAL_FISH, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Clownfish");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_PUFFERFISH(new String[] {}, FormatRecipesGUI::newEnchantedPufferGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PUFFERFISH, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Pufferfish");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COD(new String[] {}, FormatRecipesGUI::newEnchantedCodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Cod");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COOKED_COD(new String[] {}, FormatRecipesGUI::newsEnchantedCodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COOKED_COD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Cooked Cod");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SALMON(new String[] {}, FormatRecipesGUI::newEnchantedSalmonGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SALMON, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Salmon");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COOKED_SALMON(new String[] {}, FormatRecipesGUI::newsEnchantedSalmonGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COOKED_SALMON, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Cooked Salmon");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_KELP(new String[] {}, FormatRecipesGUI::newEnchantedKelpGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.KELP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Kelp");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_DRIED_KELP(new String[] {}, FormatRecipesGUI::newsEnchantedKelpGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DRIED_KELP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Dried Kelp");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_KELP_BLOCK(new String[] {}, FormatRecipesGUI::newvsEnchantedKelpGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DRIED_KELP_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Kelp Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_LAPIS(new String[] {}, FormatRecipesGUI::newEnchantedLapisGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LAPIS_LAZULI, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Lapis");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_LAPIS_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedLapisGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LAPIS_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Lapis Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_REDSTONE(new String[] {}, FormatRecipesGUI::newEnchantedRedstoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.REDSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Redstone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_REDSTONE_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedRedstoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.REDSTONE_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Redstone Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_NETHERITE(new String[] {}, FormatRecipesGUI::newEnchantedNetheriteGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_SCRAP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Netherite");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_NETHERITE_INGOT(new String[] {}, FormatRecipesGUI::newsEnchantedNetheriteGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Netherite Ingot");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_NETHERITE_BLOCK(new String[] {}, FormatRecipesGUI::newvsEnchantedNetheriteGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Netherite Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_ROTTEN_FLESH(new String[] {}, FormatRecipesGUI::newEnchantedFleshGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ROTTEN_FLESH, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Rotten Flesh");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BONE(new String[] {}, FormatRecipesGUI::newEnchantedBoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Bone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BONE_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedBoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Bone Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_STRING(new String[] {}, FormatRecipesGUI::newEnchantedStringGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STRING, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted String");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_WEB(new String[] {}, FormatRecipesGUI::newsEnchantedStringGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COBWEB, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Web");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SPIDER_EYE(new String[] {}, FormatRecipesGUI::newEnchantedSpiderEyeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SPIDER_EYE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Spider Eye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_FERMENTED_SPIDER_EYE(new String[] {}, FormatRecipesGUI::newsEnchantedSpiderEyeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FERMENTED_SPIDER_EYE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Fermented Spider Eye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_AMETHYST(new String[] {}, FormatRecipesGUI::newEnchantedAmethystGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.AMETHYST_SHARD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Amethyst   ");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_AMETHYST_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedAmethystGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.AMETHYST_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Amethyst Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_INK_SAC(new String[] {}, FormatRecipesGUI::newEnchantedInkGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.INK_SAC, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Ink Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_GLOW_SAC(new String[] {}, FormatRecipesGUI::newsEnchantedInkGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GLOW_INK_SAC, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Glow Ink Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_COCOA(new String[] {}, FormatRecipesGUI::newEnchantedCocoaGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COCOA_BEANS, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Coco Beans");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SNOWBALL(new String[] {}, FormatRecipesGUI::newEnchantedSnowGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SNOWBALL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Snowball");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SNOW(new String[] {}, FormatRecipesGUI::newsEnchantedSnowGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SNOW_BLOCK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Snow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SNOW_MOUND(new String[] {}, FormatRecipesGUI::newvsEnchantedSnowGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWRmZDc3MjRjNjlhMDI0ZGNmYzYwYjE2ZTAwMzM0YWI1NzM4ZjRhOTJiYWZiOGZiYzc2Y2YxNTMyMmVhMDI5MyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Snow Mound");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_GUNPOWDER(new String[] {}, FormatRecipesGUI::newEnchantedGunpowderGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GUNPOWDER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Gunpowder");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_POWDER_BALL(new String[] {}, FormatRecipesGUI::newsEnchantedGunpowderGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FIREWORK_STAR, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Powder Ball");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_TNT(new String[] {}, FormatRecipesGUI::newEnchantedTntGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TNT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Tnt");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_CLAY(new String[] {}, FormatRecipesGUI::newEnchantedClayGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CLAY_BALL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Clay");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_CLAY_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedClayGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CLAY, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Clay Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_GLOWSTONE_DUST(new String[] {}, FormatRecipesGUI::newEnchantedGlowstoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GLOWSTONE_DUST, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Glowstone Dust");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_GLOWSTONE(new String[] {}, FormatRecipesGUI::newsEnchantedGlowstoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GLOWSTONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Glowstone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BLAZE_POWDER(new String[] {}, FormatRecipesGUI::newEnchantedBlazeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BLAZE_POWDER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Blaze Powder");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BLAZE_ROD(new String[] {}, FormatRecipesGUI::newsEnchantedBlazeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Blaze Rod");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_ENDER_PEARL(new String[] {}, FormatRecipesGUI::newEnchantedPearlGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Ender Pearl");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_ENDER_EYE(new String[] {}, FormatRecipesGUI::newsEnchantedPearlGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ENDER_EYE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Eye of Ender");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_WART(new String[] {}, FormatRecipesGUI::newEnchantedWartGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHER_WART, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Nether Wart");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SWEET_BERRIES(new String[] {}, FormatRecipesGUI::newEnchantedBerriesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SWEET_BERRIES, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Sweet Berries");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SUGAR_CANE(new String[] {}, FormatRecipesGUI::newEnchantedCaneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SUGAR_CANE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Sugar Cane");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SUGAR(new String[] {}, FormatRecipesGUI::newsEnchantedSugarGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SUGAR, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Sugar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_CHORUS_FRUIT(new String[] {}, FormatRecipesGUI::newEnchantedFruitGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHORUS_FRUIT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Chorus Fruit");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_POPPED_CHORUS_FRUIT(new String[] {}, FormatRecipesGUI::newsEnchantedFruitGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POPPED_CHORUS_FRUIT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Popped Chorus Fruit");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_CARROT(new String[] {}, FormatRecipesGUI::newEnchantedCarrotGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CARROT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Carrot");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_GOLDEN_CARROT(new String[] {}, FormatRecipesGUI::newsEnchantedCarrotGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_CARROT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Golden Carrot");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);

            return item;
        }
    },

    ENCHANTED_POTATO(new String[] {}, FormatRecipesGUI::newEnchantedPotatoGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POTATO, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Potato");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BAKED_POTATO(new String[] {}, FormatRecipesGUI::newsEnchantedPotatoGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BAKED_POTATO, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Baked Potato");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BEETROOT(new String[] {}, FormatRecipesGUI::newEnchantedBeetGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEETROOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Beetroot");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BEETROOT_SOUP(new String[] {}, FormatRecipesGUI::newsEnchantedBeetGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEETROOT_SOUP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Beetroot Sou[");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_MELON_SLICE(new String[] {}, FormatRecipesGUI::newEnchantedMelonGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MELON_SLICE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Melon Slice");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_MELON(new String[] {}, FormatRecipesGUI::newsEnchantedMelonGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MELON, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Melon");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BROWN_MUSHROOM(new String[] {}, FormatRecipesGUI::newEnchantedBrownMushroomGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BROWN_MUSHROOM, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Brown Mushroom");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_RED_MUSHROOM(new String[] {}, FormatRecipesGUI::newEnchantedRedMushroomGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.RED_MUSHROOM, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Red Mushroom");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_FLINT(new String[] {}, FormatRecipesGUI::newEnchantedFlintGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FLINT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Flint");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_PUMPKIN(new String[] {}, FormatRecipesGUI::newEnchantedPumpkinGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PUMPKIN, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Pumpkin");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_CACTUS(new String[] {}, FormatRecipesGUI::newEnchantedCactusGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CACTUS, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Cactus");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SOUL_SAND(new String[] {}, FormatRecipesGUI::newEnchantedSoulSandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SOUL_SAND, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Soul Sand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SOUL_SOIL(new String[] {}, FormatRecipesGUI::newEnchantedSoulSoilGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SOUL_SOIL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Soul Soil");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_OAK_WOOD(new String[] {}, FormatRecipesGUI::newEnchantedOakGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.OAK_LOG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Oak Wood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SPRUCE_WOOD(new String[] {}, FormatRecipesGUI::newEnchantedSpruceGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SPRUCE_WOOD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Spruce Wood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_ACACIA_WOOD(new String[] {}, FormatRecipesGUI::newEnchantedAcaciaGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ACACIA_LOG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Acacia Wood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_BIRCH_WOOD(new String[] {}, FormatRecipesGUI::newEnchantedBirchGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BIRCH_LOG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Birch Wood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_JUNGLE_WOOD(new String[] {}, FormatRecipesGUI::newEnchantedJungleGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.JUNGLE_LOG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Jungle Wood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_DARK_OAK_WOOD(new String[] {}, FormatRecipesGUI::newEnchantedDarkOakGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DARK_OAK_WOOD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Dark Oak Wood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_WARPED_STEM(new String[] {}, FormatRecipesGUI::newEnchantedWarpedGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.WARPED_STEM, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Warped Stem");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_CRIMSON_STEM(new String[] {}, FormatRecipesGUI::newEnchantedCrimsonGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CRIMSON_STEM, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Crimson Stem");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_ENDSTONE(new String[] {}, FormatRecipesGUI::newEnchantedEndStoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.END_STONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted End Stone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_GHAST_TEAR(new String[] {}, FormatRecipesGUI::newEnchantedGhastTearGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GHAST_TEAR, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Ghast Tear");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    PULSING_TUMOR(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmFmZmNkYjA3MjkyYjY2ODY3MzYyM2NlNjNhNjEzZjQ1NzFlZjg1YzFlZmM5MjVmYTJmOGYyZmY4OTUzMzg1OSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Pulsing Tumor");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SIMPLE_SHIELD_BASE(new String[] {}, FormatRecipesGUI::newSimpleShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.LIGHT_GRAY);
            banner.addPattern(new Pattern(DyeColor.GRAY, PatternType.BORDER));
            banner.addPattern(new Pattern(DyeColor.LIGHT_GRAY, PatternType.GRADIENT));
            banner.addPattern(new Pattern(DyeColor.LIGHT_GRAY, PatternType.GRADIENT_UP));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 2.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Simple Shield Base");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ADVANCED_SHIELD_BASE(new String[] {}, FormatRecipesGUI::newAdvancedShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.BLACK);
            banner.addPattern(new Pattern(DyeColor.GRAY, PatternType.BORDER));
            banner.addPattern(new Pattern(DyeColor.GRAY, PatternType.FLOWER));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 4.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Advanced Shield Base");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HARDWOOD_HANDLE(new String[] {}, FormatRecipesGUI::newHardwoodHandleGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Hardwood Handle");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GYROSCOPE(new String[] {}, FormatRecipesGUI::newGyroscopeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FIREWORK_STAR, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Gyroscope");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    RIVER_CLAY(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CLAY_BALL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "River Clay");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HIDE(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Hide");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_OBSIDIAN(new String[] {}, FormatRecipesGUI::newEnchantedObsidianGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.OBSIDIAN, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Obsidian");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    RAZOR_CLAW(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FLINT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Razor Claw");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    WOLF_FANG(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GHAST_TEAR, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Wolf Fang");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MONSTER_MEAT(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEEF, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Monster Meat");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "COMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    COOKED_MONSTER_MEAT(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COOKED_BEEF, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Cooked Monster Meat");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "COMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GEMSTONE(new String[] {}, FormatRecipesGUI::newGemstoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzBjNWNjNzI4Yzg2OWVjZjNjNmUwOTc5ZThhYTA5YzEwMTQ3ZWQ3NzA0MTdlNGJhNTQxYWFjMzgyZjAifX19");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Gemstone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    METAL_SCRAP(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_BARS);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Metal Scrap");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ICY_CORE(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRiYTY0MmVmZmZhMTNlYzM3MzBlYWZjNTkxNGFiNjgxMTVjMWY5OTg4MDNmNzQ0NTJlMmUwY2QyNmFmMGI4In19fQ==");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Icy Core");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MUD_BALL(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTM0ZDhiZGU5ODU3ZDg3MmU1MjEyNGQ5OTgyMTU0Y2YzZDI4Yjc3MDJmYmFjZDE5ODMzYzUxMWZlNmMxY2RmNSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Mud Ball");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DISTILLED_SOUL_ESSENCE(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7ImlkIjoiOTM4NDM1M2E0YWUwNGZlNDkzOTcxYjU4N2RmNzdmMTIiLCJ0eXBlIjoiU0tJTiIsInVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU4MGU1Y2Q5NzBjMWRlZDk3M2QwYzEzOWJlNDE4YjA3NTVlMDcxMzM0NWQ3MTZlZDU5NDI0NGE1M2U2ZTEzZCIsInByb2ZpbGVJZCI6IjgwMThhYjAwYjJhZTQ0Y2FhYzliZjYwZWY5MGY0NWU1IiwidGV4dHVyZUlkIjoiOTU4MGU1Y2Q5NzBjMWRlZDk3M2QwYzEzOWJlNDE4YjA3NTVlMDcxMzM0NWQ3MTZlZDU5NDI0NGE1M2U2ZTEzZCJ9fSwiY2FwZSI6bnVsbCwic2tpbiI6eyJpZCI6IjkzODQzNTNhNGFlMDRmZTQ5Mzk3MWI1ODdkZjc3ZjEyIiwidHlwZSI6IlNLSU4iLCJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzk1ODBlNWNkOTcwYzFkZWQ5NzNkMGMxMzliZTQxOGIwNzU1ZTA3MTMzNDVkNzE2ZWQ1OTQyNDRhNTNlNmUxM2QiLCJwcm9maWxlSWQiOiI4MDE4YWIwMGIyYWU0NGNhYWM5YmY2MGVmOTBmNDVlNSIsInRleHR1cmVJZCI6Ijk1ODBlNWNkOTcwYzFkZWQ5NzNkMGMxMzliZTQxOGIwNzU1ZTA3MTMzNDVkNzE2ZWQ1OTQyNDRhNTNlNmUxM2QifX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Distilled Soul Essence");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SCRUB(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DEAD_BUSH);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Scrub");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CLUMPED_SAND(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTMxOTkzZTRjZmRhMTUzZWFmN2RjMTM4ZDUyYmJhNWMyODNkMDE2MzI2MDIyNjIxNjE3NzZmMGY0Yjg2YSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Clumped Sand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MINERAL_CLUSTER(new String[] {}, FormatRecipesGUI::newMineralClusterGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.RAW_COPPER);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Mineral Cluster");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.addEnchant(Enchantment.LUCK, 1, true);
            item.setItemMeta(meta);
            initItem(plugin, item);

            return item;
        }
    },

    LUMINOUS_QUARTZ(new String[] {}, FormatRecipesGUI::newLuminousQuartzGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.WHITE_DYE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Luminous Quartz");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            meta.addEnchant(Enchantment.LUCK, 1, true);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ONYX(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDhjNTNiY2U4YWU1OGRjNjkyNDkzNDgxOTA5YjcwZTExYWI3ZTk0MjJkOWQ4NzYzNTEyM2QwNzZjNzEzM2UifX19");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Onyx");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SLIMEBALL(new String[] {}, FormatRecipesGUI::newEnchantedSlimeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SLIME_BALL);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Slimeball");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.addEnchant(Enchantment.LUCK, 1, true);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SLIME_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedSlimeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SLIME_BLOCK);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Slime Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            meta.addEnchant(Enchantment.LUCK, 1, true);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    FOREST_ESSENCE(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LILY_OF_THE_VALLEY);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Forest's Essence");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

     GOLDEN_SKULL(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWI1MjIxYjI3NjRjZWY2Nzg2YWMxNWVhMDc1NzY4N2UyM2I5NTM2ODY0NTIwMzI0ZGQ0MzkzYjdhYmVhZDFkMSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Golden Skull");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DEEPSLATE_MONOLITH(new String[] {}, FormatRecipesGUI::newDeepslateMonolithGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjlhODczZjI0OGMzOTExMjIxODg3OWNjOWMwMzM0N2VkMTZlN2Y2MDIzOTBhYzdhNjgwNmY4ZTg0OTI3OTRkNSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Deepslate Monolith");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.addEnchant(Enchantment.LUCK, 1, true);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CACTUS_LEATHER(new String[] {}, FormatRecipesGUI::newCactusLeatherGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GREEN_DYE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Cactus Leather");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    FRAGMENTED_SOUL_REMNANTS(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PRISMARINE_CRYSTALS);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Fragmented Soul Remnants");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            meta.addEnchant(Enchantment.LUCK, 1, true);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SPEARHEAD(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FLINT);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Spearhead");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_MAGMA_CREAM(new String[] {}, FormatRecipesGUI::newEnchantedMagmaCream) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MAGMA_CREAM);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Magma Cream");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.addEnchant(Enchantment.LUCK, 1, true);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_MAGMA_BLOCK(new String[] {}, FormatRecipesGUI::newsEnchantedMagma) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MAGMA_BLOCK);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Magma Block");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            meta.addEnchant(Enchantment.LUCK, 1, true);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TITANIUM_PLATE(new String[] {}, FormatRecipesGUI::newsEnchantedMagma) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Titanium Plate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    PURE_IRON_NUGGET(new String[] {}, FormatRecipesGUI::newvsEnchantedIron) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_NUGGET);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Pure Iron Nugget");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    POLISHED_SLATED_HANDLE(new String[] {}, FormatRecipesGUI::newPolishedHandleGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Polished Slated Handle");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SEASTONE_SHARD(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Seastone Shard");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SEASTONE(new String[] {}, FormatRecipesGUI::newSeastoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTdlNTYxNDA2ODZlNDc2YWVmNTUyMGFjYmFiYzIzOTUzNWZmOTdlMjRiMTRkODdmNDk4MmYxMzY3NWMifX19");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Seastone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    POLISHED_SEASTONE(new String[] {}, FormatRecipesGUI::newPolishedSeastoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM4NDJlZWI4NjhlZTg1YzVhYjk3NGZlYzUyZGIwN2UzYWQ0ZTRmMTU4NjFhYmJmOGY2NDUzNGRiM2Y0NTBmMyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Polished Seastone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    WOOD_PILE(new String[] {}, FormatRecipesGUI::newWoodPileGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2FkNTdkMWY2MDQ3OGFmNmFlMWI2YjFjMjhjZWU1MzRkNWRiYjhjOGNhYjg3OTYzZTljMmVmMGM2YWM1OCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Wood Pile");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BUNDLED_OAK_LOGS(new String[] {}, FormatRecipesGUI::newsEnchantedOakGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjBjZDEzMjIzYThkOWMxNzNjZWRjZTZjNGJlYmViYTA2YTI0YTFiYTI3NWRkM2ViNWM3OTMzZjlhNzRiYTAxMSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bundled Oak Logs");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BUNDLED_DARK_OAK_LOGS(new String[] {}, FormatRecipesGUI::newsEnchantedDarkOakGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTc4YmM5ZTMxNzhiNTY4ZmU2ZjlmNGViOTQ5YTM2NzEzNjM5ZTIwZDBjMmRmYWI3NmFhNjNlMjVmYWYzOWVmIn19fQ==");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bundled Dark Oak Logs");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BUNDLED_BIRCH_LOGS(new String[] {}, FormatRecipesGUI::newsEnchantedBirchGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODJkMWE3ZWZlNWQ5ZmFmY2U0N2UxZDg5ODZiYjZlZjVjZTY0Njk1ZjA2N2Y4YWM5ZGZiYzIzYjVmYjU3MiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bundled Birch Logs");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BUNDLED_SPRUCE_LOGS(new String[] {}, FormatRecipesGUI::newsEnchantedSpruceGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzcxZGFkZWM1ZTc2NTY3YjQ4OTkzOWRmNmIyMjAyMjJmMzlkZGE2NmQ1MzRkYmExYWIyZDAzNmNkODRmOSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bundled Spruce Logs");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BUNDLED_ACACIA_LOGS(new String[] {}, FormatRecipesGUI::newsEnchantedAcaciaGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg4NzI1MzdiNmNlNTc0NjU5ZGMxNzZhMWQ4ZGZlOWMxZTU5OWY2ZjE0MWMxODIyNjI4MzQ3ZGQ1MzhiOWUyIn19fQ==");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bundled Acacia Logs");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BUNDLED_JUNGLE_LOGS(new String[] {}, FormatRecipesGUI::newsEnchantedJungleGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmRmMTQzN2ExMTNhOGI2NjM2NmNhMjI1NGI0NWM0ZmY1OGU4Nzg4NzNjNmUyZmFmODgzNjI3NzRlMmYxNDYifX19");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bundled Jungle Logs");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BUNDLED_CRIMSON_STEMS(new String[] {}, FormatRecipesGUI::newsEnchantedCrimsonGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDExNzBhMzAyMWMyN2Y5ZWRmNWZhZWRlZmJiOWJlMjgwOTZmOWJiYzUxYTE1NDAxOGIyY2M2MjZiMDVjYjVjMCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bundled Crimson Stems");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BUNDLED_WARPED_STEMS(new String[] {}, FormatRecipesGUI::newsEnchantedWarpedGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWMxNGFhNDYyOWMzNjFkNGUxMzJiMzFkNGMyYzhjMmE4YjhmMzVkODNmNTU3ODdlNDAzNjNjZGJmYTJmYmQ2YyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bundled Warped Stems");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DARK_IRON_CORE(new String[] {}, FormatRecipesGUI::newsEnchantedWarpedGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGY0NjJjMDU2ZjFjN2QzMWE5MzFjYTg2ZTlkNDgxNGU4NzcyYjE4YzJlOWM5NTA2ZGJiOWUyNzJiMmNiMTI1ZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Dark Iron Core");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TOUGH_CORD(new String[] {}, FormatRecipesGUI::newToughCordGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STRING);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Tough Cord");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);

            return item;
        }
    },

    SEASTONE_HANDLE(new String[] {}, FormatRecipesGUI::newSeastoneHandleGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Seastone Handle");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MAGMITE_HANDLE(new String[] {}, FormatRecipesGUI::newMagmiteHandleGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Magmite Handle");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_PAPER(new String[] {}, FormatRecipesGUI::newEnchantedPaperGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Paper");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    NECRONOMICON_PAGE(new String[] {
            ChatColor.GRAY.toString() + ChatColor.ITALIC + "A page of the mighty",
            ChatColor.DARK_RED.toString() + ChatColor.ITALIC + "Necronomicon" + ChatColor.GRAY + ", this page contains",
            ChatColor.GRAY.toString() + ChatColor.ITALIC + "the means to perform the most",
            ChatColor.GRAY.toString() + ChatColor.ITALIC + "powerful of occult rituals"},
            (FormatRecipesGUI::newNecronomiconPageGUI)) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MAP);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Necronomicon Page");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BOUND_BOOK(new String[] {
            ChatColor.GRAY.toString() + ChatColor.ITALIC + "This tome is the manuscript",
            ChatColor.DARK_RED.toString() + ChatColor.ITALIC + "of a powerful " + ChatColor.LIGHT_PURPLE + "sorcerer" + ChatColor.GRAY + ",",
            ChatColor.GRAY.toString() + ChatColor.ITALIC + "the power within this book",
            ChatColor.GRAY.toString() + ChatColor.ITALIC + "can act as a catalyst for",
            ChatColor.GRAY.toString() + ChatColor.ITALIC + "the most powerful of incantations"},
            FormatRecipesGUI::newNecronomiconPageGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.WRITABLE_BOOK);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Bound Book");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    AMALGAMATED_TISSUE(new String[] {}, FormatRecipesGUI::newAmalgamatedTissueGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.COOKED_BEEF);
            ItemMeta meta = item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Amalgamated Tissue");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SUPERSTONE_POWDER(new String[] {}, FormatRecipesGUI::newSuperstonePowderGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GUNPOWDER);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Superstone Powder");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ENCHANTED_SHULKER_SHELL(new String[] {}, FormatRecipesGUI::neweShulkerShellGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHULKER_SHELL);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, false);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Enchanted Shulker Shell");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    STICKY_BALL(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SLIME_BALL);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Sticky-Ball");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },
//-------------------------------------------MATERIAL SECTION END x:mat, c:misc------------------------------------------------
//-------------------------------------------MISC SECTION c:item, c:misc------------------------------------------------

    TOMATO(new String[] {
            ChatColor.GRAY.toString() + ChatColor.ITALIC + "Oh cool, a tomato!"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQyNDlmNDhjNWMwMjUzZGI2N2U5MWM3ZDJhNzc0NTVmOTMwOTM4OGJlNTBmOGQ4NWQ0NzE4ZTYyYzkifX19");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "trophy");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tomato");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GOLD_POT(new String[] {
            ChatColor.GRAY + "Apply to an item in an anvil",
            ChatColor.GRAY + "to " + ChatColor.GOLD + "gild " + ChatColor.GRAY + "it"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdlMGFhOTQzM2RiYTliNzU5MzJhMTFkYzk0ZDQwNmJkZTE5ZTg2MzUxNDIxNDkyYjNlZDM3OGM4ZTFhN2NjIn19fQ");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Pot of Gold");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    FEATHER_CHARM(new String[] {
            ChatColor.GRAY + "Float down like a feather when",
            ChatColor.GRAY + "you crouch"},
            FormatRecipesGUI::newfCharmGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZmMzNiMjk3YTk4MWI1MjdiZWMzOTMxNjg0MDFkOGEyZWNhZGViOWYxNjAzYmE1ZTI3NmY0MmQ2NDQ3NTExNiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "artifact");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Feather Charm");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ECHO_STONE(new String[] {
            ChatColor.GOLD + "Item Ability: Echo " + ChatColor.YELLOW.toString() + ChatColor.BOLD +"RIGHT-CLICK",
            ChatColor.GRAY + "Teleport to your last " + ChatColor.AQUA + "echo ward",
            ChatColor.GRAY + "if you have one available",
            " ",
            ChatColor.GOLD + "Item Ability: Echo Ward " + ChatColor.YELLOW + ChatColor.BOLD + "SHIFT",
            ChatColor.GRAY + "Place an " + ChatColor.AQUA + "echo ward" + ChatColor.GRAY + " at",
            ChatColor.GRAY + "your location. " + ChatColor.AQUA + "Echo wards",
            ChatColor.GRAY + "are removed when you change",
            ChatColor.GRAY + "dimension, die, or log out"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LAPIS_LAZULI, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Echo Stone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SOWERS_WILL(new String[] {
            ChatColor.GRAY + "Once one of the minions of a",
            ChatColor.GRAY + "mighty necromancer, this farmhand's work",
            ChatColor.GRAY + " work still continues after death"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FILLED_MAP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sower's Will");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LASER_PICK(new String[] {
            ChatColor.GRAY + "Can mine blocks up to 11 blocks awawy"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.AMETHYST_SHARD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Laser Drill X2085");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SUPER_PICK(new String[] {
            ChatColor.GRAY + "Mine up to 5 blocks at a time"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_PICKAXE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Chain Pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    POCKET_WORKBENCH(new String[] {
            ChatColor.GOLD + "Item Ability: Access Workbench " + ChatColor.YELLOW + ChatColor.BOLD +"RIGHT-CLICK",
            ChatColor.GRAY + "Open a crafting table GUI"},
            FormatRecipesGUI::newPocketWorkbenchGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmNkYzBmZWI3MDAxZTJjMTBmZDUwNjZlNTAxYjg3ZTNkNjQ3OTMwOTJiODVhNTBjODU2ZDk2MmY4YmU5MmM3OCJ9fX0");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Pocket Crafting Table");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

     MINI_ENDERCHEST(new String[] {
             ChatColor.GOLD + "Item Ability: Access Storage " + ChatColor.YELLOW + ChatColor.BOLD +"RIGHT-CLICK",
             ChatColor.GRAY + "Open your " + ChatColor.DARK_PURPLE + "ender chest"},
             FormatRecipesGUI::newMiniEnderChestGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRjYzE4OTYzM2M3ODljYjZkNWU3OGQxM2E1MDQzYjI2ZTdiNDBjZGI3Y2ZjNGUyM2FhMjI3OTU3NDk2N2I0In19fQ==");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mini Ender Chest");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DEATH_CHARM(new String[] {
            ChatColor.GRAY + "This ancient charm can let the",
            ChatColor.GRAY + "wearer escape death, although",
            ChatColor.GRAY + "it is not very reliable"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Death Charm");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "artifact");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SILVERFISH_SCALE(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LIGHT_GRAY_DYE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Silverfish Scale");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEATY_STEW(new String[] {
            ChatColor.GRAY + "Can be eaten to gain",
            ChatColor.RED + "+5 ❁ Strength " + ChatColor.GRAY + "permanently",
            " ",
            ChatColor.RED + "You can only consume three of",
            ChatColor.RED + "this type of soup!"},
            FormatRecipesGUI::newMeatyStewGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.RABBIT_STEW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Meaty Stew");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MAGIC_STEW(new String[] {
            ChatColor.GRAY + "Can be eaten to gain",
            ChatColor.AQUA + "+15 ✎ Intelligence " + ChatColor.GRAY + "permanently",
            " ",
            ChatColor.RED + "You can only consume three of",
            ChatColor.RED + "this type of soup!"},
            FormatRecipesGUI::newMagicStewGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MUSHROOM_STEW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Magic Stew");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    FIBROUS_STEW(new String[] {
            ChatColor.GRAY + "Can be eaten to gain",
            ChatColor.GREEN + "+5 ❈ Defense " + ChatColor.GRAY + "permanently",
            " ",
            ChatColor.RED + "You can only consume three of",
            ChatColor.RED + "this type of soup!"},
            FormatRecipesGUI::newFibrousStewGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.RABBIT_STEW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Fibrous Stew");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SPICY_STEW(new String[] {
            ChatColor.GRAY + "Can be eaten to gain",
            ChatColor.BLUE + "+7 ☠ Crit Damage " + ChatColor.GRAY + "permanently",
            " ",
            ChatColor.RED + "You can only consume three of",
            ChatColor.RED + "this type of soup!"},
            FormatRecipesGUI::newSpicyStewGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEETROOT_SOUP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Spicy Stew");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HEARTY_STEW(new String[] {
            ChatColor.GRAY + "Can be eaten to gain",
            ChatColor.RED + "+10 ❤ Health " + ChatColor.GRAY + "permanently",
            " ",
            ChatColor.RED + "You can only consume three of",
            ChatColor.RED + "this type of soup!"},
            FormatRecipesGUI::newHeartyStewGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MUSHROOM_STEW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Hearty Stew");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BOAR_TOTEM(new String[] {
            ChatColor.GRAY + "Gives you " + ChatColor.RED + "+8% ❁ Strength",
            ChatColor.GRAY + "when held in either hand"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Totem of Boar's Strength");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"StrengthModifier"), PersistentDataType.DOUBLE, 0.08);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BADGER_TOTEM(new String[] {
            ChatColor.GRAY + "Gives you " + ChatColor.RED + "+15% ❁ Strength",
            ChatColor.GRAY + "when held in either hand"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Totem of Badger's Strength");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"StrengthModifier"), PersistentDataType.DOUBLE, 0.15);
            item.setItemMeta(meta);
            initItem(plugin, item);

            return item;
        }
    },

    BONE_NEEDLE(new String[] {
            ChatColor.GOLD + "Item Ability: Blood Sacrifice " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Take " + ChatColor.RED + "20 damage " + ChatColor.GRAY +"and",
            ChatColor.GRAY + "gain " + ChatColor.AQUA + "+12 ✎ mana"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Bone Needle");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);

            return item;
        }
    },

    KINETIC_ROD(new String[] {
            ChatColor.GRAY + "Send enemies you reel flying!"},
            FormatRecipesGUI::newKineticRodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Kinetic Rod");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DIMENSIONAL_ROD(new String[] {
            ChatColor.GRAY + "Swap places with enemies you reel"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dimensional Rod");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GRAPPLING_HOOK(new String[] {
            ChatColor.GOLD + "Item Ability: Grapple " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Launch yourself with high forward", ChatColor.GRAY + "momentum.",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "2.5s"},
            FormatRecipesGUI::newGrapplerGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Grappling Hook");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    OVERWORLD_SCROLL(new String[] {
            ChatColor.GOLD + "Item Ability: Warp " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Teleport to the overworld (you must be at",
            ChatColor.GRAY + "full " + ChatColor.RED + "❤ Health " + ChatColor.GRAY + "to",
            ChatColor.GRAY + "do it)"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FILLED_MAP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Travel Scroll to The Overworld");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    NETHER_SCROLL(new String[] {
            ChatColor.GOLD + "Item Ability: Warp " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Teleport to the nether (you must be at",
            ChatColor.GRAY + "full " + ChatColor.RED + "❤ Health " + ChatColor.GRAY + "to",
            ChatColor.GRAY + "do it)"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FILLED_MAP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Travel Scroll to The Nether");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    END_SCROLL(new String[] {
            ChatColor.GOLD + "Item Ability: Warp " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Teleport to the end (you must be at", ChatColor.GRAY + "full " + ChatColor.RED + "❤ Health " + ChatColor.GRAY + "to",
            ChatColor.GRAY + "do it)"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FILLED_MAP, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Travel Scroll to The End");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LESSER_SPIRIT_BONE(new String[] {
            ChatColor.GOLD + "Item Ability: Spectral Companion " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Summon a " + ChatColor.AQUA + "lesser spirit wolf",
            ChatColor.GRAY + "that has " + ChatColor.RED + "❤ 300 Health" + ChatColor.GRAY + " and ",
            ChatColor.RED + "⚔ 40 Damage"},
            FormatRecipesGUI::newLesserSpiritBoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Gnawed Bone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LESSER_SPIRIT_BONE_SHARD(new String[] {
            ChatColor.GRAY + "Can be repaired in a crafting",
            ChatColor.GRAY + "table to return it to its",
            ChatColor.GRAY + "fixed state"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE_MEAL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Gnawed Bone Shard");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GREATER_SPIRIT_BONE(new String[] {
            ChatColor.GOLD + "Item Ability: Spectral Companion " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Summon a " + ChatColor.AQUA + "greater spirit wolf",
            ChatColor.GRAY + "that has " + ChatColor.RED + "❤ 2500 Health" + ChatColor.GRAY + " and ",
            ChatColor.RED + "⚔ 150 Damage"},
            FormatRecipesGUI::newGreaterSpiritBoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Marred Bone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GREATER_SPIRIT_BONE_SHARD(new String[] {
            ChatColor.GRAY + "Can be repaired in a crafting",
            ChatColor.GRAY + "table to return it to its",
            ChatColor.GRAY + "fixed state"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE_MEAL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Marred Bone Shard");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    STATS_GUIDE(new String[] {
            ChatColor.GRAY + "Read all about " + ChatColor.GREEN + "stats " + ChatColor.GRAY + "in this",
            ChatColor.GRAY + "book"},
            FormatRecipesGUI::newStatsGuideGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.WRITTEN_BOOK, 1);
            BookMeta meta = (BookMeta) item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Stats Guide");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setTitle("Stats Guide");
            meta.setAuthor("WispishWurm");
            meta.setGeneration(BookMeta.Generation.COPY_OF_COPY);
            meta.addPage(ChatColor.DARK_RED.toString() + ChatColor.MAGIC + "0" + ChatColor.RESET + ChatColor.DARK_RED + ChatColor.BOLD + " What are stats " + ChatColor.RESET + ChatColor.DARK_RED + ChatColor.MAGIC + "0                         " + ChatColor.RESET + ChatColor.BLACK + "Stats are attributes that you have that affect specific characteristics about you such as " + ChatColor.RED + "❤ Health " + ChatColor.BLACK + "affects your max health and " + net.md_5.bungee.api.ChatColor.of("#d2d4b6") + "✦ Speed " + ChatColor.BLACK + "affects how fast you move. In the following pages you will see how they work and some more information about them.");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.RED  + "    ❤ Health ❤          " + ChatColor.RESET + ChatColor.RED + "❤ Health " + ChatColor.BLACK + "is a stat that determines how much life you have. WHen it reaches 0 you will die. You regenerate 2% of your max health a second (affected by healing modifier).");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.GREEN  + "    ❈ Defense ❈       " + ChatColor.RESET + ChatColor.GREEN + "❈ Defense " + ChatColor.BLACK + "will reduce the damage of hits you take, nothing much more about it really.");
            meta.addPage( ChatColor.BOLD.toString() + net.md_5.bungee.api.ChatColor.of("#babaa9") + "     ✦ Speed ✦         " + ChatColor.RESET + net.md_5.bungee.api.ChatColor.of("#babaa9") + "✦ Speed " + ChatColor.BLACK + "increases how fast you walk, at negative speed you will be reduced to no speed at all.");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.RED  + "     ❁ Strength ❁     " + ChatColor.RESET + ChatColor.RED + "❁ Strength " + ChatColor.BLACK + "increase the damage you deal by a considerable amount.");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.BLUE  + "         ☠ Crit ☠        " + ChatColor.RESET + ChatColor.BLUE + "☠ Crit " + ChatColor.BLACK + "increase the damage you deal on " + ChatColor.BLUE + "critical hits" + ChatColor.BLACK + ".");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.DARK_BLUE  + "    ☣ Crit Chance ☣     " + ChatColor.RESET + ChatColor.DARK_BLUE + "☣ Crit Chance " + ChatColor.BLACK + "makes your attacks have a % chance to be a critical hit and deal extra damage based on your " + ChatColor.BLUE + "☠ Crit " + ChatColor.BLACK + ". If your " + ChatColor.DARK_BLUE + "☣ Crit Chance " + ChatColor.BLACK+ "is more than 100 it will have no difference to being at 100.");
            meta.addPage( ChatColor.BOLD.toString() + net.md_5.bungee.api.ChatColor.of("#baab23")  + " ⚔ Attack Speed ⚔    " + ChatColor.RESET + net.md_5.bungee.api.ChatColor.of("#baab23") + "⚔ Attack Speed " + ChatColor.BLACK + "attack cooldown recharges 0.5% faster for every " + net.md_5.bungee.api.ChatColor.of("#baab23") + "⚔ Attack Speed " + ChatColor.BLACK + "that you have. This also applies to shortbows and other weapons with delayed attacks.");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.AQUA  + "   ✎ Intelligence ✎      " + ChatColor.RESET + ChatColor.AQUA + "✎ Intelligence " + ChatColor.BLACK + "increases your " + ChatColor.AQUA + "✎ Mana " + ChatColor.BLACK + "which is used as a cost for most spells.");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.LIGHT_PURPLE  + "   ҉ Invocation ҉       " + ChatColor.RESET + ChatColor.LIGHT_PURPLE + "҉ Invocation " + ChatColor.BLACK + "make your summons stronger, the effects of this will range from only basic stats like " + ChatColor.RED + "❤ Health" + ChatColor.BLACK + ", " + ChatColor.GREEN + "❈ Defense" + ChatColor.BLACK + ", and " + ChatColor.RED + "⚔ Damage " + ChatColor.BLACK + "to more even things like " + ChatColor.WHITE + "✦ Speed " + ChatColor.BLACK + "the speed of projectiles.");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.DARK_PURPLE  + "   ᛝ Thaumaturgy ᛝ     " + ChatColor.RESET + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.BLACK + "increase the offensive power of your spells, this can also affect spells in other ways than just damage like blast radius or duration of effects.");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.DARK_AQUA  + "   ✯ Magic Find ✯       " + ChatColor.RESET + ChatColor.DARK_AQUA + "✯ Magic Find " + ChatColor.BLACK + "make mobs have a higher chance to produce " + ChatColor.BLUE + "rare drops " + ChatColor.BLACK + ".");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.GOLD  + "  ☘ Farming Fortune ☘ " + ChatColor.RESET + ChatColor.GOLD + "☘ Farming Fortune " + ChatColor.BLACK + "makes crops have a chance to drop more items and makes" + ChatColor.GOLD + " great crops " + ChatColor.BLACK + "have a higher chance to drop.");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.GOLD  + "   ⛏ Mining Fortune ⛏  " + ChatColor.RESET + ChatColor.GOLD + "⛏ Mining Fortune " + ChatColor.BLACK + "makes ores and higher quality minerals have a chance to drop more items and makes" + ChatColor.DARK_GRAY + " deep ones " + ChatColor.BLACK + "appear more often.");
            meta.addPage( ChatColor.BOLD.toString() + ChatColor.GOLD  + "♠ Excavating Fortune " + ChatColor.RESET + ChatColor.GOLD + "♠ Excavating Fortune " + ChatColor.BLACK + "increases the chance to dig up" + ChatColor.GOLD + " treasures" + ChatColor.BLACK + ".");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BARREL_OF_ROCKS(new String[] {
            ChatColor.GOLD + "Item Ability: Dump " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Rummage through the barrel and",
            ChatColor.GRAY + "find the treasures within",
            "",
            "",
            "",
            "",
            "",
            ChatColor.DARK_GRAY + "(Totally not a scam)"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjZiNjdlZDkyMjBlZjhhZWRlOTc4OTYyMzE1NWI4MWVhNzM1ODRiODZjN2IxYzE1MjM4ZDM4NzJiNDAxMCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Barrel of Rocks");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LUCKY_POTTERY_SHARD(new String[] {
            ChatColor.GRAY + "Gain copious amount of",
            ChatColor.GOLD + "fortune " + ChatColor.GRAY + "but with an",
            ChatColor.GRAY + "unfortunate twist"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzM0MDgzMmZhODRiNGMwNGE0OGM2YWU5MWVkZTI5ZDdiNWM3M2E4YmMzZmZlNmVlYmI3ZmNmMzg1Yjk0OWQ4ZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lucky Pottery Shard");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"FarmingFortune"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    METAL_DETECTOR(new String[] {
            ChatColor.GOLD + "Item Ability: Find Metals " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Pick up the location of",
            ChatColor.GRAY + "nearby metals and highlight",
            ChatColor.GRAY + "them", ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "15s"},
            FormatRecipesGUI::newMetalDetectorGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_HOE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Metal Detector");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    METALLOID_DETECTOR(new String[] {
            ChatColor.GOLD + "Item Ability: Find Metalloids " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Pick up the location of",
            ChatColor.GRAY + "nearby metalloids and highlight",
            ChatColor.GRAY + "them",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "12s"},
            FormatRecipesGUI::newMetalloidDetectorGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_HOE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Metalloid Detector");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TREASURE_DETECTOR(new String[] {
            ChatColor.GOLD + "Item Ability: Find Treasure " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Pick up the location of", ChatColor.GRAY + "nearby treasures and highlight",
            ChatColor.GRAY + "them", ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "10s"},
            FormatRecipesGUI::newTreasureDetectorGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DIAMOND_HOE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Treasure Detector");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    JERKY(new String[] {ChatColor.DARK_GRAY + "0.5 Food units", ChatColor.DARK_GRAY + "Duration: " + ChatColor.GREEN + "240s"}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Jerky");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "food");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 1.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"duration"), PersistentDataType.INTEGER, 240);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"amount"), PersistentDataType.DOUBLE, 0.5);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    STEEL_HOE(new String[] {
            ChatColor.GRAY + "Gain " + ChatColor.GOLD + "+40 ☭ Farming Fortune" + ChatColor.GRAY + "from",
            ChatColor.YELLOW + "wheat" + ChatColor.GRAY + " and " + ChatColor.getByChar("#946754") + "potatoes"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_HOE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Steel Hoe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "hoe");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BLANK_WARP_SCROLL(new String[] {
            ChatColor.GOLD + "Item Ability: Create Warp " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Transform this scroll into", ChatColor.GRAY + "a warp scroll, allowing you",
            ChatColor.GRAY + "to teleport to that location"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MAP);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Blank Warp Scroll");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    WARP_SCROLL(new String[] {
            ChatColor.GOLD + "Item Ability: Warp " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Teleport to the location in the", ChatColor.GRAY + "scroll (you must be at full " + ChatColor.RED + "❤ Health " + ChatColor.GRAY + "to",
            ChatColor.GRAY + "do it)"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MAP);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Warp Scroll");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"locationX"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"locationY"), PersistentDataType.DOUBLE, 64.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"locationZ"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"world"), PersistentDataType.STRING, "world");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SCOURGE(new String[] {
            ChatColor.GRAY + "Inflict " + ChatColor.GREEN + "poison " + ChatColor.GRAY + "and damage",
            ChatColor.GRAY + "enemies for " + ChatColor.GREEN + "0.4x " + ChatColor.GRAY + "your",
            ChatColor.RED + "❁ Strength " + ChatColor.GRAY + "when you reel the rod in"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FISHING_ROD);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "Strength"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Scourge");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    WOOD_CUTTER(new String[] {ChatColor.GRAY + "Cut through wood in one strike"}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHEARS);
            ItemMeta meta = item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Wood Cutters");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    PROSPEROUS_GROVE(new String[] {
            ChatColor.GOLD + "Item Ability: Spirits of the Orchard " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GREEN + "Heal " + ChatColor.GRAY + "yourself and allies within",
            ChatColor.GREEN + "7 " + ChatColor.GRAY + "blocks for " + ChatColor.GREEN + "8% " + ChatColor.GRAY + "of their",
            ChatColor.RED + "❤ Max Health",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "18s",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "120"},
            FormatRecipesGUI::newProsperousGroveGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.OAK_SAPLING);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Prosperous Grove");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LEACHING_BRAMBLES(new String[] {
            ChatColor.GOLD + "Item Ability: Vampire Thorns " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Deal " + ChatColor.RED + "25 Damage" + ChatColor.GRAY + ", " + ChatColor.DARK_GRAY + "slow" + ChatColor.GRAY + ", and",
            ChatColor.DARK_RED + "weaken " + ChatColor.GRAY + "all enemies within",
            ChatColor.GREEN + "7 " + ChatColor.GRAY + "blocks and " + ChatColor.GREEN + "heal " + ChatColor.GRAY + "for " + ChatColor.GREEN + "10% ",
            ChatColor.GRAY + "of the damage you dealt",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "18s",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "120"},
            FormatRecipesGUI::newLeachingBramblesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SPRUCE_SAPLING);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Leaching Brambles");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    PROLIFERATING_SAPLING(new String[] {
            ChatColor.GOLD + "Item Ability: Rapid Growth " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GREEN + "Heal 5% " + ChatColor.GRAY + "of your " + ChatColor.RED + "❤ Max Health ",
            ChatColor.GRAY + "a second for " + ChatColor.GREEN + "6s",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "18s",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "120"},
            FormatRecipesGUI::newProliferatingSaplingGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BIRCH_SAPLING);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Proliferating Sapling");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

     LASHING_VINES(new String[] {
             ChatColor.GOLD + "Item Ability: Binding Vines " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
             ChatColor.GREEN + "Root" + ChatColor.GRAY + " and " + ChatColor.GREEN + "poison " + ChatColor.GRAY + "enemies",
             ChatColor.GRAY + "within " + ChatColor.GREEN + "10 " + ChatColor.GRAY + "blocks who are",
             ChatColor.GRAY + "on the ground for " + ChatColor.GREEN + "6s" , ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "18s",
             ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "120"},
             FormatRecipesGUI::newLashingVinesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.JUNGLE_SAPLING);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Lashing Vines");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

     PUNGENT_HERBS(new String[] {
             ChatColor.GOLD + "Item Ability: Invigorating Fumes " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
             ChatColor.GRAY + "Give you and all allies within",
             ChatColor.GREEN + "5 " + ChatColor.GRAY + "blocks " + ChatColor.RED + "+50 ❁ Strength" + ChatColor.GRAY + ",",
             ChatColor.WHITE + "+50 ✦ Speed " + ChatColor.GRAY + ", " + ChatColor.GRAY + "and ",
             ChatColor.YELLOW + "+50 ⚔ Attack Speed " + ChatColor.GRAY + "for " + ChatColor.GREEN + "10s",
             ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "18s",
             ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "120"},
             FormatRecipesGUI::newPungentHerbsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ACACIA_SAPLING);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Pungent Herbs");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LUCKY_FOOT(new String[] {
            ChatColor.GRAY + "Gain " + ChatColor.DARK_AQUA + "+15 ✯ Magic Find"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.RABBIT_FOOT);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lucky Foot");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "artifact");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MAGENTA_PIGMENT(new String[] {
            net.md_5.bungee.api.ChatColor.of("#9F4576") + "Magenta Haze",
            " ",
            ChatColor.GRAY + "Apply to leather armor in",
            ChatColor.GRAY + "an anvil to change the color"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MAGENTA_DYE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Armor Dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"color"), PersistentDataType.INTEGER_ARRAY, new int[]{159, 69, 118});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HONEY_DYE(new String[] {
            net.md_5.bungee.api.ChatColor.of("#d1a745") + "Honey",
            " ",
            ChatColor.GRAY + "Apply to leather armor in",
            ChatColor.GRAY + "an anvil to change the color"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.HONEYCOMB);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Armor Dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"color"), PersistentDataType.INTEGER_ARRAY, new int[]{209, 167, 69});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CACTUS_DYE(new String[] {
            net.md_5.bungee.api.ChatColor.of("#2E6021") + "Cactus",
            " ",
            ChatColor.GRAY + "Apply to leather armor in",
            ChatColor.GRAY + "an anvil to change the color"},
            FormatRecipesGUI::newCactusDyeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GREEN_DYE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Armor Dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"color"), PersistentDataType.INTEGER_ARRAY, new int[]{46, 96, 33});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DIAMOND_POWDER(new String[] {
            net.md_5.bungee.api.ChatColor.of("#b9f2ff") + "Diamond Powder",
            " ",
            ChatColor.GRAY + "Apply to leather armor in",
            ChatColor.GRAY + "an anvil to change the color"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Armor Dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"color"), PersistentDataType.INTEGER_ARRAY, new int[]{185, 242, 255});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DRIED_BLOOD(new String[] {
            net.md_5.bungee.api.ChatColor.of("#880808") + "Blood",
            " ",
            ChatColor.GRAY + "Apply to leather armor in",
            ChatColor.GRAY + "an anvil to change the color"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.REDSTONE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Armor Dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"color"), PersistentDataType.INTEGER_ARRAY, new int[]{136, 8, 8});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    POWDERED_FUZZ(new String[] {
            net.md_5.bungee.api.ChatColor.of("#87421f") + "Fuzzy Wuzzy",
            " ",
            ChatColor.GRAY + "Apply to leather armor in",
            ChatColor.GRAY + "an anvil to change the color"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BROWN_DYE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Armor Dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"color"), PersistentDataType.INTEGER_ARRAY, new int[]{135, 66, 31});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    VINE_PASTE(new String[] {
            net.md_5.bungee.api.ChatColor.of("#006400") + "Vine Green",
            " ",
            ChatColor.GRAY + "Apply to leather armor in",
            ChatColor.GRAY + "an anvil to change the color"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GREEN_DYE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Armor Dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"color"), PersistentDataType.INTEGER_ARRAY, new int[]{0, 100, 0});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CHARCOAL_POWDER(new String[] {
            net.md_5.bungee.api.ChatColor.of("#2b373f") + "Charcoal",
            " ",
            ChatColor.GRAY + "Apply to leather armor in",
            ChatColor.GRAY + "an anvil to change the color"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHARCOAL);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Armor Dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "dye");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"color"), PersistentDataType.INTEGER_ARRAY, new int[]{43, 55, 63});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DART(new String[] {
            ChatColor.GOLD + "Item Ability: Throw " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Seriously? Do I need to",
            ChatColor.GRAY + "explain how this works?"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ARROW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dart");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

     CORROSIVE_PICKAXE(new String[] {
            ChatColor.GRAY + "When you hit a block it",
            ChatColor.GRAY + "will break in " + ChatColor.GREEN + "150% " + ChatColor.GRAY + "the",
            ChatColor.GRAY + "time it would take you to",
            ChatColor.GRAY + "break it"},
             null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STONE_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Corrosive Pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SOLAR_PICKAXE(new String[] {
            ChatColor.GRAY + "Gain "+ ChatColor.YELLOW + "Haste II " + ChatColor.GRAY + "and " + ChatColor.GOLD + "+65",
            ChatColor.GOLD + "⛏ Mining Fortune " + ChatColor.GOLD + "when you are",
            ChatColor.GRAY + "exposed to the " + ChatColor.YELLOW + "sun"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Solar Pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MAGMATON_FURNACE_F2713(new String[] {
            ChatColor.GRAY + "Gain "+ ChatColor.YELLOW + "Haste IV " + ChatColor.GRAY + "and " + ChatColor.GOLD + "+40",
            ChatColor.GOLD + "⛏ Mining Fortune " + ChatColor.GRAY + "while",
            ChatColor.GRAY + "fueled",
            " ",
            ChatColor.GRAY + "Can be fueled with " + ChatColor.DARK_GRAY + "coal" + ChatColor.GRAY + ",",
            ChatColor.GOLD + "magma" + ChatColor.GRAY + ", and " + ChatColor.YELLOW + "blaze " + ChatColor.GRAY + "based",
            ChatColor.GRAY + "materials"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Magmaton Furnace F2713");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"fuel"), PersistentDataType.INTEGER, 0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 20.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    AETHER_DRIVE_F117(new String[] {
            ChatColor.GRAY + "Instantly break blocks",
            ChatColor.GRAY + "while " + ChatColor.LIGHT_PURPLE + "fueled",
            " ",
            ChatColor.GRAY + "Can be fueled with " + ChatColor.BLUE + "ender" + ChatColor.GRAY + ",",
            ChatColor.DARK_PURPLE + "chorus" + ChatColor.GRAY + ", and " + net.md_5.bungee.api.ChatColor.of("#dbd772") + "endstone ",
            ChatColor.GRAY + "based materials"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Aether Drive F117");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"fuel"), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

     TORRENT(new String[] {
            ChatColor.GRAY + "Gain "+ ChatColor.DARK_AQUA + "Conduit Power " + ChatColor.GRAY + "while",
            ChatColor.GRAY + "wielding this",
            ChatColor.GRAY + "pickaxe"},
             FormatRecipesGUI::newTorrentGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Torrent");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 40.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    STONK(new String[] {}, FormatRecipesGUI::newStonkGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Stonk");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"enchantmentName"), new stringList(), new String[]{"Efficiency"});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"enchantmentPower"), PersistentDataType.INTEGER_ARRAY, new int[]{6});
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DEVOURER(new String[] {
            ChatColor.DARK_RED + "Consume "+ ChatColor.GRAY + "ores you mine",
            ChatColor.GRAY + "and convert them to",
            ChatColor.GREEN + "mining xp"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Devourer");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 10.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SCRUFFY_LASSO(new String[] {
            ChatColor.GOLD + "Item Ability: Lasso " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Swing your lasso forward",
            ChatColor.GRAY + "grabbing the first mob it",
            ChatColor.GRAY + "hits and pull it in",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "4s"},
            FormatRecipesGUI::newScruffyLassoGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEAD);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Scruffy Lasso");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SNAGGLETOOTH_LASSO(new String[] {
            ChatColor.GOLD + "Item Ability: Hooked Lasso " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Swing your lasso forward",
            ChatColor.GRAY + "grabbing all mobs it",
            ChatColor.GRAY + "hits and pull them in",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "6s"},
            FormatRecipesGUI::newSnaggletoothLassoGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEAD);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Snaggletooth Lasso");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LUMBERJACKS_AXE(new String[] {
            ChatColor.GRAY + "Gain " + ChatColor.GREEN + "+25% " + ChatColor.GRAY + "more " + ChatColor.GREEN + "foraging xp",
            ChatColor.GRAY + "and instantly break leaves"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_AXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lumberjack's Axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LOGGERS_AXE(new String[] {
            ChatColor.GRAY + "Gain " + ChatColor.GOLD + "double drops " + ChatColor.GRAY + "from",
            ChatColor.GRAY + "logs"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_AXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Logger's Axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    WOODCUTTERS_AXE(new String[] {
            ChatColor.GRAY + "When mining wood you",
            ChatColor.GRAY + "have a " + ChatColor.GREEN + "60% " + ChatColor.GRAY + "chance to",
            ChatColor.GRAY + "break adjacent logs"},
            FormatRecipesGUI::newWoodCuttersAxeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_AXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Woodcutter's Axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    FORESTERS_AXE(new String[] {
            ChatColor.GRAY + "Gain " + ChatColor.GREEN + "+35% " + ChatColor.GRAY + "more " + ChatColor.GREEN + "foraging xp,",
            ChatColor.GRAY + "instantly break leaves, " + ChatColor.GOLD + "triple " + ChatColor.GOLD + "log",
            ChatColor.GRAY + "drops, and break adjacent logs",
            ChatColor.GRAY + "when mining wood"},
            FormatRecipesGUI::newForestersAxeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_AXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Forester's Axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GROVE_AXE(new String[] {
            ChatColor.GOLD + "Item Ability: Fabricate Sapling " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Plant a " + ChatColor.DARK_GREEN + "sapling",
            ChatColor.GRAY + "based on the last wood",
            ChatColor.GRAY + "type you chopped",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "40"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_AXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"material"), PersistentDataType.STRING, "");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Grove Axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DULL_PICKAXE(new String[] {
            ChatColor.GRAY + "Gain efficiency as you",
            ChatColor.GRAY + "break blocks until it",
            ChatColor.GRAY + "is sharpened"},
            FormatRecipesGUI::newDullPickaxeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STONE_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"broken"), PersistentDataType.INTEGER, 0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"next"), PersistentDataType.INTEGER, 100);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dull Pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    NOTCHED_PICK(new String[] {
            ChatColor.GRAY + "Gain " + ChatColor.GOLD + "+3 ⛏ Mining Fortune " + ChatColor.GRAY + "for",
            ChatColor.GREEN + "16s " + ChatColor.GRAY + "after breaking an ore"},
            FormatRecipesGUI::newNotchedPickGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Notched Pick");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    IMBALANCED_PICKAXE(new String[] {
            ChatColor.GRAY + "Break every fifth block",
            ChatColor.GRAY + "you mine instantly"},
            FormatRecipesGUI::newImbalancedPickaxeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_PICKAXE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"broken"), PersistentDataType.INTEGER, 0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Imbalanced Pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pickaxe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    NFT_MINT(new String[] {
            ChatColor.GRAY + "When you kill an entity you",
            ChatColor.GRAY + "have a small chance to",
            ChatColor.GRAY + "mint it into an nft"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.JUKEBOX);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "NFT Mint");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "artifact");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    NFT(new String[] {},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MUSIC_DISC_CHIRP);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "NFT");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"name"), PersistentDataType.STRING, "");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"uuid"), PersistentDataType.STRING, "");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    KIBBLE(new String[] {
            ChatColor.GRAY + "Will be useful if/when",
            ChatColor.GRAY + "I decide to add pets"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BROWN_DYE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Kibble");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   SHORTBOW_CORD(new String[] {
            ChatColor.GRAY + "Apply to a bow in an",
            ChatColor.GRAY + "anvil to give it ",
            ChatColor.YELLOW + "+15 ⚔ Attack Speed"},
            FormatRecipesGUI::newShortbowCordGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STRING);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Shortbow Cord");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   COMPACTED_PEAT_MOSS(new String[] {
           ChatColor.GOLD + "Item Ability: Enrich Soil " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
           ChatColor.GRAY + "Use one charge to" + ChatColor.WHITE + " bonemeal",
           ChatColor.GRAY + "what you right clicked. Any",
           ChatColor.GRAY + "plants with multiple growth",
           ChatColor.GRAY + "stages are instantly grown",
           " ",
           ChatColor.GRAY + "Can be fueled with " + ChatColor.WHITE + "bone" + ChatColor.GRAY + " and",
           ChatColor.DARK_GREEN + "moss " + ChatColor.GRAY + "based materials"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWE0Yjc4YThiYWYzOGFhOTdjMWI1ODcwNjgzMGVkOGRkYTRmNzc5MWQ4NmZiNTNhOGY2MWRhNTRhMjQzMWExIn19fQ==");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Compacted Peat Moss");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"fuel"), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   NAME_TAG(new String[] {
           ChatColor.GOLD + "Item Ability: Choose Name " + ChatColor.YELLOW + ChatColor.BOLD + "LEFT-CLICK",
           ChatColor.GRAY + "Change the name of the tag",
           " ",
           ChatColor.GOLD + "Item Ability: Change Name " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
           ChatColor.GRAY + "Change the name of a",
           ChatColor.GRAY + "mob to the tag's name",
           " ",
            },
            FormatRecipesGUI::newShortbowCordGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NAME_TAG);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Name Tag");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"name"), PersistentDataType.STRING, " ");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   DRAWSTRING_BAG(new String[] {
           ChatColor.GOLD + "Item Ability: Access Sacks " + ChatColor.YELLOW + ChatColor.BOLD + "LEFT/RIGHT-CLICK",
           ChatColor.GRAY + "Open your sacks gui"},
           FormatRecipesGUI::newDrawstringBagGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjk3NzVkNzYxMmQwNjVlMWRkZDA3YzY0NThiMDYxN2FhY2Y0ZTgzMDhmMmM4ZTNjZmE2ZDk5OWMxYTVhNWFiNCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Drawstring Bag");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   TINY_ROCK_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.DARK_GRAY + "Tiny Rock Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyRockSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjA3ZGZmNjU3ZDYxZjMwMmM3ZDJlNzI1MjY1ZDE3YjY0YWE3MzY0MjM5MTk2NGZiNDhmYzE1YmU5NTA4MzFkOCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Rock Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   SMALL_ROCK_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GRAY + "Tiny Rock Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GRAY + "Small Rock Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallRockSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjA3ZGZmNjU3ZDYxZjMwMmM3ZDJlNzI1MjY1ZDE3YjY0YWE3MzY0MjM5MTk2NGZiNDhmYzE1YmU5NTA4MzFkOCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Rock Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

    MEDIUM_ROCK_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GRAY + "Small Rock Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GRAY + "Medium Rock Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumRockSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTAwYjFiZjg1NTQ5ODVmM2RlY2Y1NDg4NjkyMmFkMjBkMTQ0NDM4NTY0ZWY3YTViNTJjZWQ3MWJjOWRkMDRiYiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Rock Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_ROCK_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GRAY + "Medium Rock Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GRAY + "Large Rock Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeRockSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTAwYjFiZjg1NTQ5ODVmM2RlY2Y1NDg4NjkyMmFkMjBkMTQ0NDM4NTY0ZWY3YTViNTJjZWQ3MWJjOWRkMDRiYiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Rock Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_ROCK_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GRAY + "Large Rock Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GRAY + "Gigantic Rock Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticRockSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTE1ZmNlYmJiZTAyZmRiNzJhY2QyMDk1ZDllZGZjZWEwOTVlNjA0YjM2ODJkYjg4OTYzYjViODNiMjkzOWI2NyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Rock Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_ROCK_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GRAY + "Gigantic Rock Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GRAY + "Humongous Rock Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousRockSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTE1ZmNlYmJiZTAyZmRiNzJhY2QyMDk1ZDllZGZjZWEwOTVlNjA0YjM2ODJkYjg4OTYzYjViODNiMjkzOWI2NyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Rock Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ROCK_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.DARK_GRAY + "Humongous",
            ChatColor.DARK_GRAY + "Rock Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newRockSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GRAY_DYE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Rock Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_MINERAL_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.AQUA + "Tiny Mineral Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjY2MjRhN2JkZWU2MjQwZGRkYmVkODI2ODA5MGUyMzRkMGJhNDcwZWE4OTZlODkyOWY0ZWZiMjEzZjIyNjk0NCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Mineral Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_MINERAL_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.AQUA + "Tiny Mineral Sack " + ChatColor.GRAY + "to a",
            ChatColor.AQUA + "Small Mineral Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjY2MjRhN2JkZWU2MjQwZGRkYmVkODI2ODA5MGUyMzRkMGJhNDcwZWE4OTZlODkyOWY0ZWZiMjEzZjIyNjk0NCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Mineral Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_MINERAL_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.AQUA + "Small Mineral Sack " + ChatColor.GRAY + "to a",
            ChatColor.AQUA + "Medium Mineral Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDM1MDAyOGZkOTZhOThkNWIzM2QwODRkMjUyNGI3NmVkMGZjNmIyMWNjYzQwMDY0YTZkMmU3YmY5OTcxODYwZSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Mineral Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_MINERAL_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.AQUA + "Medium Mineral Sack " + ChatColor.GRAY + "to a",
            ChatColor.AQUA + "Large Mineral Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDM1MDAyOGZkOTZhOThkNWIzM2QwODRkMjUyNGI3NmVkMGZjNmIyMWNjYzQwMDY0YTZkMmU3YmY5OTcxODYwZSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Mineral Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_MINERAL_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.AQUA + "Large Mineral Sack " + ChatColor.GRAY + "to a",
            ChatColor.AQUA + "Gigantic Mineral Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTViYTgwNGI3YWU5MmM2NWIyZjQxZDE4YmU4OTlhM2JkMTM5NzcyZTNlM2M4MWMyZmM4YWRkYmIyNzUzNjk1MiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Mineral Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_MINERAL_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.AQUA + "Gigantic Rock Sack " + ChatColor.GRAY + "to a",
            ChatColor.AQUA + "Humongous Rock Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTViYTgwNGI3YWU5MmM2NWIyZjQxZDE4YmU4OTlhM2JkMTM5NzcyZTNlM2M4MWMyZmM4YWRkYmIyNzUzNjk1MiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Mineral Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MINERAL_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.AQUA + "Humongous",
            ChatColor.AQUA + "Mineral Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LARGE_AMETHYST_BUD);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mineral Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_LUMBER_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.GOLD + "Tiny Lumber Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGY5NjBjNjM5ZDQwMDRkMTg4MjU3NWFlYmE2OWY0NTZmYjNjNzQ0MDc3OTM1NzE0OTQ3ZTE5YzEzMDZkMjczMyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Lumber Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_LUMBER_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GOLD + "Tiny Lumber Sack " + ChatColor.GRAY + "to a",
            ChatColor.GOLD + "Small Lumber Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGY5NjBjNjM5ZDQwMDRkMTg4MjU3NWFlYmE2OWY0NTZmYjNjNzQ0MDc3OTM1NzE0OTQ3ZTE5YzEzMDZkMjczMyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Lumber Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_LUMBER_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GOLD + "Small Lumber Sack " + ChatColor.GRAY + "to a",
            ChatColor.GOLD + "Medium Lumber Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmMxNDEwNWM3YjYyOWNmZGViODY2YTU2MGJhYjU5NzM0YWE1Y2JiZTg4MGVkOWY1MGY5MDQ0YzQyYWZkNTk5ZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Lumber Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_LUMBER_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GOLD + "Medium Lumber Sack " + ChatColor.GRAY + "to a",
            ChatColor.GOLD + "Large Lumber Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmMxNDEwNWM3YjYyOWNmZGViODY2YTU2MGJhYjU5NzM0YWE1Y2JiZTg4MGVkOWY1MGY5MDQ0YzQyYWZkNTk5ZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Lumber Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_LUMBER_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GOLD + "Large Lumber Sack " + ChatColor.GRAY + "to a",
            ChatColor.GOLD + "Gigantic Lumber Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmM2ZTI0ZGY0OThiYTRhNTg5YzI1OWQ5ZmMwZDNkYjM0OGY5M2NkZjI2YTVmZTQ2MTU3MWMxZGE3MDZlZmFmMyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Lumber Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_LUMBER_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GOLD + "Gigantic Lumber Sack " + ChatColor.GRAY + "to a",
            ChatColor.GOLD + "Humongous Lumber Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmM2ZTI0ZGY0OThiYTRhNTg5YzI1OWQ5ZmMwZDNkYjM0OGY5M2NkZjI2YTVmZTQ2MTU3MWMxZGE3MDZlZmFmMyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Lumber Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LUMBER_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.GOLD + "Humongous",
            ChatColor.GOLD + "Lumber Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.OAK_SAPLING);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lumber Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_FORAGING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.DARK_GREEN + "Tiny Foraging Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE5ZjFiNzg3M2I5MmY0NDk3Mjg4NmI4YzM2NGNlZTgwMzdmNDVjZDFkMDVmNjRkNjk4ZGJiMTFmNWUxMmY2MCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Foraging Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_FORAGING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GREEN + "Tiny Foraging Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GREEN + "Small Foraging Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE5ZjFiNzg3M2I5MmY0NDk3Mjg4NmI4YzM2NGNlZTgwMzdmNDVjZDFkMDVmNjRkNjk4ZGJiMTFmNWUxMmY2MCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Foraging Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_FORAGING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GREEN + "Small Foraging Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GREEN + "Medium Foraging Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDYzYzU0MTNhODlmMjljNWE0ZTFkNGIxZjJmYWQzYzBjZWJmMzA4MWVjYjllMzI3ZGUxNjI5NWY5ZmI2YTYxNSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Foraging Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_FORAGING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GREEN + "Medium Foraging Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GREEN + "Large Foraging Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDYzYzU0MTNhODlmMjljNWE0ZTFkNGIxZjJmYWQzYzBjZWJmMzA4MWVjYjllMzI3ZGUxNjI5NWY5ZmI2YTYxNSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Foraging Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_FORAGING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GREEN + "Large Foraging Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GREEN + "Gigantic Foraging Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWZjOTdjYTY0MzE1MjA5MDBiNjc3OGUxYWI3ZDE5YzgzMTJkNzRlYWQ3NDUwNTEzM2JhNzIyYmUxNjJjYjg0MiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Foraging Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_FORAGING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_GREEN + "Gigantic Foraging Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_GREEN + "Humongous Foraging Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWZjOTdjYTY0MzE1MjA5MDBiNjc3OGUxYWI3ZDE5YzgzMTJkNzRlYWQ3NDUwNTEzM2JhNzIyYmUxNjJjYjg0MiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Foraging Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    FORAGING_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.DARK_GREEN + "Humongous",
            ChatColor.DARK_GREEN + "Foraging Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ORANGE_TULIP);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Foraging Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_AGRICULTURE_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.GREEN + "Tiny Agriculture Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmFiODc5ZTFlNTkwMDQxMTQ2YmM3OGMwMThhZjU4NzdkMzllNTQ3NWViN2RiMzY4ZmNhZjJhY2RhMzczODMzZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Agriculture Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_AGRICULTURE_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GREEN + "Tiny Agriculture Sack " + ChatColor.GRAY + "to a",
            ChatColor.GREEN + "Small Agriculture Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmFiODc5ZTFlNTkwMDQxMTQ2YmM3OGMwMThhZjU4NzdkMzllNTQ3NWViN2RiMzY4ZmNhZjJhY2RhMzczODMzZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Agriculture Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_AGRICULTURE_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GREEN + "Small Agriculture Sack " + ChatColor.GRAY + "to a",
            ChatColor.GREEN + "Medium Agriculture Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjk0YzgzNDFhNTM1ZjgwYjNmNDNjNWMyNDNkMDMwMDZiZDMyNWM5ZTk2ZmYzYWI5NTdjY2MzNzA2MjgzMGFjNiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Agriculture Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_AGRICULTURE_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GREEN + "Medium Agriculture Sack " + ChatColor.GRAY + "to a",
            ChatColor.GREEN + "Large Agriculture Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjk0YzgzNDFhNTM1ZjgwYjNmNDNjNWMyNDNkMDMwMDZiZDMyNWM5ZTk2ZmYzYWI5NTdjY2MzNzA2MjgzMGFjNiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Agriculture Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_AGRICULTURE_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GREEN + "Large Agriculture Sack " + ChatColor.GRAY + "to a",
            ChatColor.GREEN + "Gigantic Agriculture Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY4MzViODk0MWZlMzE5OTMxNzQ5Yjg3ZmU4ZTg0YzVkMWY0YTI3MWI1ZmJjZTVlNzAwYTYwMDA0ZDg4MWY3OSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Agriculture Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_AGRICULTURE_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.GREEN + "Gigantic Agriculture Sack " + ChatColor.GRAY + "to a",
            ChatColor.GREEN + "Humongous Agriculture Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY4MzViODk0MWZlMzE5OTMxNzQ5Yjg3ZmU4ZTg0YzVkMWY0YTI3MWI1ZmJjZTVlNzAwYTYwMDA0ZDg4MWY3OSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Agriculture Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    AGRICULTURE_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.GREEN + "Agriculture",
            ChatColor.GREEN + "Agriculture Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEETROOT);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Agriculture Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_HUSBANDRY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.YELLOW + "Tiny Husbandry Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODhlNDY0YzE5ODRjMDBlMTBjMmFiZmVmZmJjOWE2NTkzNWM0YWZkYTY2MjYxYjUzZDZmMzY2ZWYyMDQyZTgyMCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Husbandry Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_HUSBANDRY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.YELLOW + "Tiny Husbandry Sack " + ChatColor.GRAY + "to a",
            ChatColor.YELLOW + "Small Husbandry Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODhlNDY0YzE5ODRjMDBlMTBjMmFiZmVmZmJjOWE2NTkzNWM0YWZkYTY2MjYxYjUzZDZmMzY2ZWYyMDQyZTgyMCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Husbandry Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_HUSBANDRY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.YELLOW + "Small Husbandry Sack " + ChatColor.GRAY + "to a",
            ChatColor.YELLOW + "Medium Husbandry Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2IyM2VlNzk4M2E1ZTFjYTI2MDc3YTBhNTAzYjI1MWRkZTA4YjcyOTMyZmFkNGNmZTJmMjBlZmIxODFhM2IyZSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Husbandry Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_HUSBANDRY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.YELLOW + "Medium Husbandry Sack " + ChatColor.GRAY + "to a",
            ChatColor.YELLOW + "Large Husbandry Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2IyM2VlNzk4M2E1ZTFjYTI2MDc3YTBhNTAzYjI1MWRkZTA4YjcyOTMyZmFkNGNmZTJmMjBlZmIxODFhM2IyZSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Husbandry Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_HUSBANDRY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.YELLOW + "Large Husbandry Sack " + ChatColor.GRAY + "to a",
            ChatColor.YELLOW + "Gigantic Husbandry Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzczMDg3ZjFlNjU0YjE2ODI3MzM1ODRhNDQwOTc1ODdmYjk0MmUxZjM0M2FhZTgzMDdiZDdkYWM4NGU4NDNhYiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Husbandry Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_HUSBANDRY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.YELLOW + "Gigantic Husbandry Sack " + ChatColor.GRAY + "to a",
            ChatColor.YELLOW + "Humongous Husbandry Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzczMDg3ZjFlNjU0YjE2ODI3MzM1ODRhNDQwOTc1ODdmYjk0MmUxZjM0M2FhZTgzMDdiZDdkYWM4NGU4NDNhYiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Husbandry Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUSBANDRY_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.YELLOW + "Humongous",
            ChatColor.YELLOW + "Husbandry Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BEEF);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Husbandry Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_CRYPTOZOOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.DARK_BLUE + "Tiny Cryptozoology Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWI4ZjQ1MmM5ZDZiNjI1NGI1NDc4NTY5YTYwYjBiNmZiMDMxYzdhZDJmMDZlYTNkYWNmMmNlODc0Y2E3MDgzIn19fQ=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Cryptozoology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_CRYPTOZOOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_BLUE + "Tiny Cryptozoology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_BLUE + "Small Cryptozoology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWI4ZjQ1MmM5ZDZiNjI1NGI1NDc4NTY5YTYwYjBiNmZiMDMxYzdhZDJmMDZlYTNkYWNmMmNlODc0Y2E3MDgzIn19fQ=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Cryptozoology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_CRYPTOZOOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_BLUE + "Small Cryptozoology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_BLUE + "Medium Cryptozoology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTRiMmI3OWE0ZTA2MGFiYjAwYWE4OGU3YzRjZDVjMDAzOWY1ZTVjYWQyZDQ1YzFjZmY1Njc2Y2I4M2ExODE1ZSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Cryptozoology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_CRYPTOZOOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_BLUE + "Medium Cryptozoology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_BLUE + "Large Cryptozoology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTRiMmI3OWE0ZTA2MGFiYjAwYWE4OGU3YzRjZDVjMDAzOWY1ZTVjYWQyZDQ1YzFjZmY1Njc2Y2I4M2ExODE1ZSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Cryptozoology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_CRYPTOZOOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_BLUE + "Large Cryptozoology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_BLUE + "Gigantic Cryptozoology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWMxM2M0Nzc0YzgyYzA3MDcxZTZkMTQwODcxN2IxZTNlYWM1NjE4NjA0MmE1ODAzZmMxNzQ0NTJlMzJhMjU0YSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Cryptozoology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_CRYPTOZOOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_BLUE + "Gigantic Cryptozoology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_BLUE + "Humongous Cryptozoology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWMxM2M0Nzc0YzgyYzA3MDcxZTZkMTQwODcxN2IxZTNlYWM1NjE4NjA0MmE1ODAzZmMxNzQ0NTJlMzJhMjU0YSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Cryptozoology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CRYPTOZOOLOGY_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.DARK_BLUE + "Humongous",
            ChatColor.DARK_BLUE + "Cryptozoology Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.ROTTEN_FLESH);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cryptozoology Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_DEMONOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.DARK_RED + "Tiny Demonology Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzA1YTdlNzMxNzFiMTYzMmMxNmQ4NzlmNGU0OTgzMjYxYzVmNmI2NGY0NDI3MmY3M2IzYTM0OWY2OGIzYTI5NiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Demonology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_DEMONOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_RED + "Tiny Demonology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_RED + "Small Demonology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzA1YTdlNzMxNzFiMTYzMmMxNmQ4NzlmNGU0OTgzMjYxYzVmNmI2NGY0NDI3MmY3M2IzYTM0OWY2OGIzYTI5NiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Demonology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_DEMONOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_RED + "Small Demonology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_RED + "Medium Demonology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzAzMmI2Nzg5MjhiOWQ2MGVjODFlNGMwYjA4MDlkMmM5ZDA4YTNkNWMwYzE5ZGZiYmE0ZjQ3MzkyMDczYjA2In19fQ=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Demonology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_DEMONOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_RED + "Medium Demonology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_RED + "Large Demonology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzAzMmI2Nzg5MjhiOWQ2MGVjODFlNGMwYjA4MDlkMmM5ZDA4YTNkNWMwYzE5ZGZiYmE0ZjQ3MzkyMDczYjA2In19fQ=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Demonology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_DEMONOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_RED + "Large Demonology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_RED + "Gigantic Demonology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzAzMmI2Nzg5MjhiOWQ2MGVjODFlNGMwYjA4MDlkMmM5ZDA4YTNkNWMwYzE5ZGZiYmE0ZjQ3MzkyMDczYjA2In19fQ=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Demonology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_DEMONOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_RED + "Gigantic Demonology Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_RED + "Humongous Demonology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzAzMmI2Nzg5MjhiOWQ2MGVjODFlNGMwYjA4MDlkMmM5ZDA4YTNkNWMwYzE5ZGZiYmE0ZjQ3MzkyMDczYjA2In19fQ=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Demonology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DEMONOLOGY_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.DARK_RED + "Humongous",
            ChatColor.DARK_RED + "Demonology Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BLAZE_POWDER);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Demonology Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_XENOARCHAEOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.LIGHT_PURPLE + "Tiny Xenoarchaeology Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTkxZWI0ZWUzZWNjZTM0NDc0ODNhMWYxNTFjMTFmYWNjOWRlMjU1NzdhYjdiNTFmYmYzZDljMmIyYTRiNjlmYyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Xenoarchaeology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_XENOARCHAEOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.LIGHT_PURPLE + "Tiny Xenoarchaeology Sack " + ChatColor.GRAY + "to a",
            ChatColor.LIGHT_PURPLE + "Small Xenoarchaeology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTkxZWI0ZWUzZWNjZTM0NDc0ODNhMWYxNTFjMTFmYWNjOWRlMjU1NzdhYjdiNTFmYmYzZDljMmIyYTRiNjlmYyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Xenoarchaeology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_XENOARCHAEOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.LIGHT_PURPLE + "Small Xenoarchaeology Sack " + ChatColor.GRAY + "to a",
            ChatColor.LIGHT_PURPLE + "Medium Xenoarchaeology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWNmYjc4MGY1ZmU0OGYzYzFiZjUzNTY0MzBiYTgxNDI4NjQwM2VhN2YwZjU5ZGEwOTU0YTZlZmE3MTc0MWNlMSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Xenoarchaeology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_XENOARCHAEOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.LIGHT_PURPLE + "Medium Xenoarchaeology Sack " + ChatColor.GRAY + "to a",
            ChatColor.LIGHT_PURPLE + "Large Xenoarchaeology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWNmYjc4MGY1ZmU0OGYzYzFiZjUzNTY0MzBiYTgxNDI4NjQwM2VhN2YwZjU5ZGEwOTU0YTZlZmE3MTc0MWNlMSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Xenoarchaeology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_XENOARCHAEOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.LIGHT_PURPLE + "Large Xenoarchaeology Sack " + ChatColor.GRAY + "to a",
            ChatColor.LIGHT_PURPLE + "Gigantic Xenoarchaeology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTUwOTAwMmNmMWNiYTM2MTE5YjI2Y2ZhMjUyM2QxNDY5M2E4ZTU2YWY3NTYzM2Y0YzIxY2JmN2Y1YWQ4NzE2OSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Xenoarchaeology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_XENOARCHAEOLOGY_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.LIGHT_PURPLE + "Gigantic Xenoarchaeology Sack " + ChatColor.GRAY + "to a",
            ChatColor.LIGHT_PURPLE + "Humongous Xenoarchaeology Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTUwOTAwMmNmMWNiYTM2MTE5YjI2Y2ZhMjUyM2QxNDY5M2E4ZTU2YWY3NTYzM2Y0YzIxY2JmN2Y1YWQ4NzE2OSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Xenoarchaeology Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    XENOARCHAEOLOGY_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.LIGHT_PURPLE + "Humongous",
            ChatColor.LIGHT_PURPLE + "Xenoarchaeology Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHORUS_FRUIT);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Xenoarchaeology Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_FISHING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.DARK_AQUA + "Tiny Fishing Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzRmYmM3N2QyN2RhYjEwZGU1YWJmOWQwYmNjNDcxOThmOTIzYjBlNmMxNzlhM2MzOTgzZTc3ZjEyZjdjMDMzZSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Fishing Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_FISHING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_AQUA + "Tiny Fishing Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_AQUA + "Small Fishing Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzRmYmM3N2QyN2RhYjEwZGU1YWJmOWQwYmNjNDcxOThmOTIzYjBlNmMxNzlhM2MzOTgzZTc3ZjEyZjdjMDMzZSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Fishing Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_FISHING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_AQUA + "Small Fishing Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_AQUA + "Medium Fishing Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmY3NTg3MWM5MGI5NGY0ZmJjMTY3ZTM1MWQzNmU4YWVhZTFjYzJmZWMwM2IxNjYyOTAwN2Y3NGM5ODlkZTY0OCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Fishing Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_FISHING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_AQUA + "Medium Fishing Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_AQUA + "Large Fishing Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmY3NTg3MWM5MGI5NGY0ZmJjMTY3ZTM1MWQzNmU4YWVhZTFjYzJmZWMwM2IxNjYyOTAwN2Y3NGM5ODlkZTY0OCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Fishing Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_FISHING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_AQUA + "Large Fishing Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_AQUA + "Gigantic Fishing Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjhmNjg2NjkzNTFhNmZjNzE1NmVjZmUzMzAwYmE5NGVmZTA3NjZlMjRiZWQ4Nzg1Y2Y2NGE5Zjk1NDM1MTM0YiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Fishing Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_FISHING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.DARK_AQUA + "Gigantic Fishing Sack " + ChatColor.GRAY + "to a",
            ChatColor.DARK_AQUA + "Humongous Fishing Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjhmNjg2NjkzNTFhNmZjNzE1NmVjZmUzMzAwYmE5NGVmZTA3NjZlMjRiZWQ4Nzg1Y2Y2NGE5Zjk1NDM1MTM0YiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Fishing Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    FISHING_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.DARK_AQUA + "Humongous",
            ChatColor.DARK_AQUA + "Fishing Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TROPICAL_FISH);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Fishing Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TINY_EXCAVATING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add the",
            ChatColor.WHITE + "Tiny Excavating Sack " + ChatColor.GRAY + "to your",
            ChatColor.GRAY + "sacks menu",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newTinyMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmM2Y2Y1OTFhYTIzNjNiZDg0MzQyNDA0ZGM1OTQxNjhiOTA0ZjY1YTFlMjVmOGJlNjU4YjkxYjU2NzYyOWRhZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tiny Excavating Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SMALL_EXCAVATING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.WHITE + "Tiny Excavating Sack " + ChatColor.GRAY + "to a",
            ChatColor.WHITE + "Small Excavating Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newSmallMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmM2Y2Y1OTFhYTIzNjNiZDg0MzQyNDA0ZGM1OTQxNjhiOTA0ZjY1YTFlMjVmOGJlNjU4YjkxYjU2NzYyOWRhZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Small Excavating Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MEDIUM_EXCAVATING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.WHITE + "Small Excavating Sack " + ChatColor.GRAY + "to a",
            ChatColor.WHITE + "Medium Excavating Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMediumMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmE3ZGEzZmRkMDBhMmNkZDY0M2EzZGEzZTJhYzVjZjgxZjcyMzFhYjMxYjBiZjYxNzY3YmEzZmIyMWMyYzFiMiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Medium Excavating Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LARGE_EXCAVATING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.WHITE + "Medium Excavating Sack " + ChatColor.GRAY + "to a",
            ChatColor.WHITE + "Large Excavating Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newLargeMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmE3ZGEzZmRkMDBhMmNkZDY0M2EzZGEzZTJhYzVjZjgxZjcyMzFhYjMxYjBiZjYxNzY3YmEzZmIyMWMyYzFiMiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Large Excavating Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GIGANTIC_EXCAVATING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.WHITE + "Large Excavating Sack " + ChatColor.GRAY + "to a",
            ChatColor.WHITE + "Gigantic Excavating Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newGiganticMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTk5NzEyZDM5N2YwYmZiZmUwMTI0YzVlZDgwYzgxMGY0ZmUxZTBhNWM1NWQ3MWY0MjhkZDI4MzRjOGEyYzM5OSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gigantic Excavating Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUMONGOUS_EXCAVATING_SACK(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to upgrade a",
            ChatColor.WHITE + "Gigantic Excavating Sack " + ChatColor.GRAY + "to a",
            ChatColor.WHITE + "Humongous Excavating Sack ",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newHumongousMineralSackGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTk5NzEyZDM5N2YwYmZiZmUwMTI0YzVlZDgwYzgxMGY0ZmUxZTBhNWM1NWQ3MWY0MjhkZDI4MzRjOGEyYzM5OSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Humongous Excavating Sack");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    EXCAVATING_SACK_EXTENSION(new String[] {
            ChatColor.GOLD + "Right-Click " + ChatColor.GRAY + "to add " + ChatColor.BLUE + "1280",
            ChatColor.GRAY + "capacity to a " + ChatColor.WHITE + "Humongous",
            ChatColor.WHITE + "Excavating Sack",
            " ",
            ChatColor.GRAY + "Sacks can store raw",
            ChatColor.GRAY + "materials to help you",
            ChatColor.GRAY + "keep your inventory clear"},
            FormatRecipesGUI::newMineralSackExtensionGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.FLINT);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Excavating Sack Extension");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },
//----------------------------------------ITEMS SECTION END x:item-----------------------------------------------------
//----------------------------------------WEAPONS SECTION c:weapons-----------------------------------------------------

    MOON_GLOVE(new String[] {
            ChatColor.GRAY + "This glove can manipulate gravity",
            ChatColor.GRAY + "and send enemies you strike flying"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHORUS_FLOWER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 300.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Moon Glove");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ASPECT_OF_THE_END(new String[] {
            ChatColor.GOLD + "Item Ability: Instant Transmission " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Teleport forward 8 blocks",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "40"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Aspect of The End");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GEMSTONE_TRIDENT(new String[] {}, FormatRecipesGUI::newGemstoneTridentGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.TRIDENT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 75.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gemstone Trident");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.addEnchant(Enchantment.LOYALTY, 5, true);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    PUFFERFISH_CANON(new String[] {
            ChatColor.GOLD + "Item Ability: Puffy Projectile" + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Launch a pufferfish to attack",
            ChatColor.GRAY + "your enemies",
            ChatColor.DARK_GRAY + "Mana Cost:" + ChatColor.AQUA + " 30"},
            FormatRecipesGUI::newPufferFishCanonGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_HORSE_ARMOR, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Pufferfish Canon");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    WAND_OF_MAGGOTS(new String[] {
            ChatColor.GOLD + "Item Ability: Swarm Summon " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Summon 3 " + ChatColor.DARK_RED + "maggots " + ChatColor.GRAY + "that copy",
            ChatColor.GREEN + "10% " + ChatColor.GRAY + "of your stats and last for", ChatColor.GREEN + "20s",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "30s",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "80"},
            FormatRecipesGUI::newMaggotWandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BAMBOO, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Wand of Maggots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LESSER_HEAL_WAND(new String[] {
            ChatColor.GOLD + "Item Ability: Minor Heal " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Heal for" + ChatColor.RED + " ❤ 40",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "8s",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "20"},
            FormatRecipesGUI::newLesserHealWandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lesser Wand of Healing");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HEAL_WAND(new String[] {
            ChatColor.GOLD + "Item Ability: Heal " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Heal for" + ChatColor.RED + " ❤ 75",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "7s",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "35"},
            FormatRecipesGUI::newHealWandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Wand of Healing");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    FLASH_HEAL_WAND(new String[] {
            ChatColor.GOLD + "Item Ability: Hasty Heal " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Heal for" + ChatColor.RED + " ❤ 40",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "2s",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "25"},
            FormatRecipesGUI::newChainHealWandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 55.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Chain Heal Wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GREATER_HEAL_WAND(new String[] {
            ChatColor.GOLD + "Item Ability: Major Heal " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Heal for" + ChatColor.RED + " ❤ 100", ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "7s",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "40"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Greater Wand of Healing");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    STONE_SCIMITAR(new String[] {}, FormatRecipesGUI::newStoneSaberGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Stone Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SLATED_SCIMITAR(new String[] {
            ChatColor.GRAY + "Your attacks have a chance to",
            ChatColor.GRAY + "halt enemies for a short time"},
            FormatRecipesGUI::newSlatedScimitarGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Slated Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BEDROCK_SCIMITAR(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Bedrock Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    IRON_SCIMITAR(new String[] {}, FormatRecipesGUI::newIronSaberGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Iron Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ALLOY_SCIMITAR(new String[] {}, FormatRecipesGUI::newAlloyScimitarGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 55.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LITHIUM_SCIMITAR(new String[] {
            ChatColor.GRAY + "Gain invincibility ticks when",
            ChatColor.GRAY + "attack"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lithium Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GOLD_SCIMITAR(new String[] {}, FormatRecipesGUI::newGoldSaberGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gold Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ORNAMENTAL_SCIMITAR(new String[] {}, FormatRecipesGUI::newOrnamentalScimitarGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, 45.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Magic"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Ornamental Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CEREMONIAL_SCIMITAR(new String[] {
            ChatColor.GREEN + "Heal " + ChatColor.GRAY + "for " + ChatColor.RED + "5% Max",
            ChatColor.RED + "Health " + ChatColor.GRAY + " when you kill an enemy"},
            FormatRecipesGUI::newCeremonialScimitarGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Magic"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Ceremonial Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DIAMOND_SCIMITAR(new String[] {}, FormatRecipesGUI::newDiamondSaberGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Diamond Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    OBSIDIAN_SCIMITAR(new String[] {}, FormatRecipesGUI::newObsidianScimitarGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Obsidian Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    GEMSTONE_SCIMITAR(new String[] {}, FormatRecipesGUI::newGemstoneScimitarGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 85.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 75.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gemstone Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    NETHERITE_SCIMITAR(new String[] {}, FormatRecipesGUI::newNetheriteSaberGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Netherite Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    WITHER_SCIMITAR(new String[] {
            ChatColor.DARK_GRAY + "Wither " + ChatColor.GRAY + "enemies on hit"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Wither Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LITCH_SCIMITAR(new String[] {
            ChatColor.DARK_GRAY + "Wither " + ChatColor.GRAY + "enemies on hit",
            " ",
            ChatColor.GOLD + "Item Ability: Oppressing Skull" + ChatColor.BOLD + ChatColor.YELLOW + "RIGHT-CLICK",
            ChatColor.GRAY + "Shoot a homing wither skull",
            ChatColor.GRAY + "that deals " + ChatColor.RED + "40 damage",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "75"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 45.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 115.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Litch Scimitar");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   TNT_WAND(new String[] {
            ChatColor.GOLD + "Item Ability: Hurl Tnt " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Launch a tnt forward dealing",
            ChatColor.RED + "100 " + ChatColor.GRAY + "damage",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "35"},
            FormatRecipesGUI::newTntWandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Tnt Wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   STAFF_OF_EXPLOSIVES(new String[] {
           ChatColor.GOLD + "Item Ability: Cluster Bomb " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
           ChatColor.GRAY + "Launch a bomb that deals",
           ChatColor.RED + "250 " + ChatColor.GRAY + "damage",
           ChatColor.GRAY + "and splits into submunitions",
           ChatColor.GRAY + "that deal " + ChatColor.RED + "100 " + ChatColor.GRAY + "damage",
           ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "90"},
           FormatRecipesGUI::newExplosionStaffGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.REDSTONE_TORCH);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 45.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 140.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Staff of Explosives");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

    LIGHTNING_WAND(new String[] {
            ChatColor.GOLD + "Item Ability: Lightning Strike " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Strike the ground in front", ChatColor.GRAY + "of you dealing heavy damage",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "45"},
            FormatRecipesGUI::newLightningWandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LIGHTNING_ROD, 1);
            ItemMeta meta = item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lightning Wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.addEnchant(Enchantment.LUCK, 1, false);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   BAMBOO_SHORTBOW(new String[] {
            ChatColor.GRAY + "Gain " + ChatColor.WHITE + "+8 ✦ Speed " + ChatColor.GRAY + "for",
            ChatColor.GREEN + "10s " + ChatColor.GRAY + "when you kill an enemy"},
            FormatRecipesGUI::newBambooShortbowGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BOW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "bow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Bamboo Shortbow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

    POTION_SHORTBOW(new String[] {
            ChatColor.GRAY + "Arrows apply random effects to enemies"},
            FormatRecipesGUI::newPotionShortbowGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BOW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "bow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Potion Shortbow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUNTER_SHORTBOW(new String[] {
            ChatColor.GRAY + "Deal " + ChatColor.RED + "+35% " + ChatColor.GRAY + "damage to beasts",
            " ",
            ChatColor.GOLD + "Item Ability: Find Prey " + ChatColor.YELLOW + ChatColor.BOLD + "LEFT-CLICK",
            ChatColor.GRAY + "Make all mobs within a " + ChatColor.GREEN + "35",
            ChatColor.GRAY + "blocks " + ChatColor.WHITE + "glow " + ChatColor.GRAY + "for " + ChatColor.GREEN + "12s",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "20s"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BOW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "bow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Hunter Shortbow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },


    MEAT_CLEAVER(new String[] {}, FormatRecipesGUI::newMeatCleaverGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Meat Cleaver");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CACTUS_SHIELD(new String[] {
            ChatColor.GRAY + "Deal " + ChatColor.BLUE + "2x your ☠ Crit Damage",
            ChatColor.GRAY + "to your attacker when you block",
            ChatColor.GRAY + "an attack."},
            FormatRecipesGUI::newCactusShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.BLACK);
            banner.addPattern(new Pattern(DyeColor.GREEN, PatternType.BRICKS));
            banner.addPattern(new Pattern(DyeColor.GREEN, PatternType.STRIPE_SMALL));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SPARKLING_SHIELD(new String[] {
            ChatColor.GRAY + "Gain " + ChatColor.AQUA + "+50 ✎ Mana" + ChatColor.GRAY + " and" + ChatColor.DARK_GRAY + " blind",
            ChatColor.GRAY + "the attacker for time based on",
            ChatColor.GRAY + "your current " + ChatColor.AQUA + "mana " + ChatColor.GRAY + "reducing their",
            ChatColor.GRAY + "damage by " + ChatColor.RED + "4% " + ChatColor.GRAY + "for the duration"},
            FormatRecipesGUI::newSparkleShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.MAGENTA);
            banner.addPattern(new Pattern(DyeColor.PURPLE, PatternType.GRADIENT));
            banner.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.FLOWER));
            banner.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CIRCLE_MIDDLE));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 4.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sparkling Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    COPPER_SHIELD(new String[] {}, FormatRecipesGUI::newCopperShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.ORANGE);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 2.5);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Copper Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    IRON_SHIELD(new String[] {}, FormatRecipesGUI::newIronShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.LIGHT_GRAY);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 4.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Iron Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    LAPIS_SHIELD(new String[] {}, FormatRecipesGUI::newLapisShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.BLUE);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 2.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lapis Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    REDSTONE_SHIELD(new String[] {}, FormatRecipesGUI::newRedstoneShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.RED);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 2.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Redstone Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DIAMOND_SHIELD(new String[] {}, FormatRecipesGUI::newDiamondShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.LIGHT_BLUE);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 3.5);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Diamond Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    EMERALD_SHIELD(new String[] {}, FormatRecipesGUI::newEmeraldShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.LIME);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 6.5);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Emerald Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    NETHERITE_SHIELD(new String[] {}, FormatRecipesGUI::newNetheriteShieldGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.BLACK);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 8.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 55.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, -10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Netherite Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HOLY_SHIELD(new String[] {
            ChatColor.WHITE + "Smite " + ChatColor.GRAY + "enemies that hit your shield",
            ChatColor.GRAY + "reducing their " + ChatColor.GREEN + "❈ Defense " + ChatColor.GRAY + "by " + ChatColor.RED + "10%",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHIELD, 1);
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            Banner banner = (Banner) meta.getBlockState();
            banner.setBaseColor(DyeColor.WHITE);
            banner.addPattern(new Pattern(DyeColor.RED, PatternType.STRAIGHT_CROSS));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Integrity"), PersistentDataType.DOUBLE, 7.5);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 45.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Holy Shield");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.setBlockState(banner);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TERRACOTTA_CUDGEL(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.WOODEN_SHOVEL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 160.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -150.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, -100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Terracotta Cudgel");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DIMENSIONAL_CUTTERS(new String[] {
            ChatColor.GOLD + "Item Ability: Abyssal Rift " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Open a " + ChatColor.DARK_GRAY + "rift " + ChatColor.GRAY + "to the abyss",
            ChatColor.GRAY + "which leaks " + ChatColor.DARK_GRAY + "shadow bolts" + ChatColor.GRAY + " and " + ChatColor.DARK_PURPLE + "voidspawn",
            ChatColor.GRAY + "periodically, rifts last for" + ChatColor.GREEN + "4s",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "15",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "120"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.SHEARS, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dimensional Cutters");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    RIFT_LANCE(new String[] {
            ChatColor.GRAY + "When you hit an enemy with a",
            ChatColor.DARK_BLUE + "critical hit " + ChatColor.GRAY + "you have a " + ChatColor.GREEN + "20% " + ChatColor.GRAY + "chance to",
            ChatColor.DARK_AQUA + "teleport " + ChatColor.GRAY + "them."},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 225.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 120.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -125.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 75.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Rift Lance");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SAND_WAND(new String[] {
            ChatColor.GOLD + "Item Ability: Summon Sand " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Summon a falling block of",
            ChatColor.YELLOW + "sand " + ChatColor.GRAY + "that deals " + ChatColor.RED + "50 Damage" + ChatColor.GRAY + ".",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "40"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sand Wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DUNE_WAND(new String[] {
            ChatColor.GOLD + "Item Ability: Invoke Dune " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Summon a large dune",
            ChatColor.GRAY + "that deals " + ChatColor.RED + "150 Damage",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "150"},
            FormatRecipesGUI::newDuneWandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dune Wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    PRISMATIC_WAND(new String[] {
            ChatColor.GOLD + "Item Ability: Chromatic Sands " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Summon a flurry of",
            ChatColor.YELLOW + "sand " + ChatColor.GRAY + "that deals " + ChatColor.RED + "90 Damage",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "210"},
            FormatRecipesGUI::newPrismaticWandGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.AMETHYST_SHARD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Prismatic Wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    RENEGADE_CROSSBOW(new String[] {
            ChatColor.GRAY + "Can be combined with other",
            ChatColor.GREEN + "Renegade Crossbows " + ChatColor.GRAY + "to gain",
            ChatColor.GRAY + "more damage"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CROSSBOW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 110.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Level"), PersistentDataType.INTEGER, 0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Renegade Crossbow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "bow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MARAUDER_AXE(new String[] {
            ChatColor.GRAY + "When you hit an enemy that",
            ChatColor.GRAY + "is at full " + ChatColor.GREEN + "health " + ChatColor.GRAY + "you deal ",
            ChatColor.RED + "50% " + ChatColor.GRAY + "more damage to it"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_AXE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 55.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -120.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Marauder Axe");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   STINGER(new String[] {
             ChatColor.GREEN + "Poison " + ChatColor.GRAY + "enemies on hit",
             " ",
             ChatColor.GOLD + "Item Ability: Frenzy " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
             ChatColor.GRAY + "Gain " + ChatColor.YELLOW + "+100 ⚔ Attack Speed " + ChatColor.GRAY + "and",
             ChatColor.RED + "+120 ❁ Strength " + ChatColor.GRAY + "for " + ChatColor.GREEN + "9s " + ChatColor.GRAY + "and",
             ChatColor.GRAY + "gain " + ChatColor.DARK_GRAY + "wither" ,
             ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "32s",
             ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "80"},
             null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Stinger");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
       }
   },

    HOG_HAMMER(new String[] {
            ChatColor.GRAY + "Deal " + ChatColor.RED + "35% " + ChatColor.GRAY + "more damage to",
            ChatColor.GRAY + "mounted enemies and mounts"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STONE_AXE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 125.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -160.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Hog Hammer");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    FLIMSY_BAMBOO_SPEAR(new String[] {
            ChatColor.DARK_GRAY + "Attacks have a 6 block",
            ChatColor.DARK_GRAY + "reach"},
            FormatRecipesGUI::newFlimsyBambooSpearGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BAMBOO);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Flimsy Bamboo Spear");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   BAMBOO_SPEAR(new String[] {
            ChatColor.DARK_GRAY + "Attacks have a 7 block",
            ChatColor.DARK_GRAY + "reach"},
            FormatRecipesGUI::newBambooSpearGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BAMBOO);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 55.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Bamboo Spear");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   AMETHYST_SPEAR(new String[] {
            ChatColor.DARK_GRAY + "Attacks have a 6 block",
            ChatColor.DARK_GRAY + "reach",
            " ",
            ChatColor.GRAY + "Attacks " + ChatColor.DARK_GRAY + "slow " + ChatColor.GRAY + "enemies for" + ChatColor.GREEN + "3s"},
            FormatRecipesGUI::newAmethystSpearGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Amethyst Spear");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   BRITTLE_BONE_SPEAR(new String[] {
            ChatColor.DARK_GRAY + "Attacks have a 6 block",
            ChatColor.DARK_GRAY + "reach"},
            FormatRecipesGUI::newBrittleBoneSpearGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Brittle Bone Spear");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   BONE_SPEAR(new String[] {
            ChatColor.DARK_GRAY + "Attacks have a 7 block",
            ChatColor.DARK_GRAY + "reach"},
            FormatRecipesGUI::newBoneSpearGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BONE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Bone Spear");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   QUARTERSTAFF(new String[] {
            ChatColor.DARK_GRAY + "Attacks have a 5 block",
            ChatColor.DARK_GRAY + "reach",
            " ",
            ChatColor.GOLD + "Item Ability: Push " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Strike forward, pushing the",
            ChatColor.GRAY + "first enemy you hit",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "1.5s"},
            FormatRecipesGUI::newQuarterstaffGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.STICK);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Quarterstaff");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   ELITES_SHIV(new String[] {
            ChatColor.DARK_GRAY + "Attacks have a 2 block",
            ChatColor.DARK_GRAY + "reach"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_SWORD);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 45.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, 150.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Elite's Shiv");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "sword");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   WEBSLINGER_SHORTBOW(new String[] {
            ChatColor.GRAY + "Every " + ChatColor.GREEN + "8 " + ChatColor.GRAY + "shots shoot an",
            ChatColor.GRAY + "arrow that " + ChatColor.WHITE + "glues " + ChatColor.GRAY + "its target",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "2s"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.BOW, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"shots"), PersistentDataType.INTEGER, 0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "bow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Webslinger Shortbow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   CONCRETE_GAUNTLET(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzdlYWIxMmIzMTAxYzU1M2UzNjNiZTI3N2QxZTYxZDEyNDA3MDcxNWYwMzA3ZWQwNzc3MzNhNzFmMzkxY2UzZSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 115.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, -50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, -120.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 120.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"shots"), PersistentDataType.INTEGER, 0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "bow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Concrete Gauntlet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   STICKY_BOMB_LAUNCHER(new String[] {
            ChatColor.GOLD + "Item Ability: Sticky Bomb " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Launch a " + ChatColor.GREEN + "sticky bomb " + ChatColor.GRAY + "forward",
            ChatColor.GRAY + "sticking to enemies/blocks it",
            ChatColor.GRAY + "hits and exploding for " + ChatColor.RED + "2700 Damage",
            ChatColor.GRAY + "after " + ChatColor.GREEN + "3s",
            ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.AQUA + "200",
            ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "5s"},
            FormatRecipesGUI::newStickyBombLauncherGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_HORSE_ARMOR, 1);
            LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
            meta.setColor(Color.fromRGB(64, 207, 66));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Dual"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sticky Bomb Launcher");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "wand");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },
//------------------------------------------WEAPONS SECTION END x:weapons---------------------------------------------------
//------------------------------------------ARMOR SECTION c:armor-------------------------------------------------------

    THE_DRIP(new String[] {ChatColor.GRAY + "You got the drip"}, FormatRecipesGUI::newDripGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(184,175,94));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "The Drip");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SUPREME_DRIP(new String[] {}, FormatRecipesGUI::newSupremeDripGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(133,126,70));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Supreme Drip™");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ALLOY_HELMET(new String[] {}, FormatRecipesGUI::newAlloyHelmetGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ALLOY_CHESTPLATE(new String[] {}, FormatRecipesGUI::newAlloyChestplateGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
            ItemMeta meta = item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 110.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ALLOY_LEGGINGS(new String[] {}, FormatRecipesGUI::newAlloyLegsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
            ItemMeta meta = item.getItemMeta();
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ALLOY_BOOTS(new String[] {}, FormatRecipesGUI::newAlloyBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
            ItemMeta meta = item.getItemMeta();
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SILVERFISH_HELMET(new String[] {
            ChatColor.GRAY + "Gain a " + ChatColor.GREEN + "5% "+ ChatColor.GRAY + "chance to",
            ChatColor.GRAY + "summon a silverfish that copies", ChatColor.GREEN + "10%" + ChatColor.GRAY + " of your stats and lasts",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "10s"},
            FormatRecipesGUI::newSilverfishHelmetGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGE5MWRhYjgzOTFhZjVmZGE1NGFjZDJjMGIxOGZiZDgxOWI4NjVlMWE4ZjFkNjIzODEzZmE3NjFlOTI0NTQwIn19fQ===");
            ItemMeta meta = item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Silverfish Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 180.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SILVERFISH_CHESTPLATE(new String[] {
            ChatColor.GRAY + "Gain a " + ChatColor.GREEN + "5% "+ ChatColor.GRAY + "chance to",
            ChatColor.GRAY + "summon a silverfish that copies",
            ChatColor.GREEN + "10%" + ChatColor.GRAY + " of your stats and lasts",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "10s"},
            FormatRecipesGUI::newSilverfishChestplateGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(138,133,120));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 420.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Silverfish Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SILVERFISH_LEGGINGS(new String[] {
            ChatColor.GRAY + "Gain a " + ChatColor.GREEN + "5% "+ ChatColor.GRAY + "chance to",
            ChatColor.GRAY + "summon a silverfish that copies", ChatColor.GREEN + "10%" + ChatColor.GRAY + " of your stats and lasts",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "10s"},
            FormatRecipesGUI::newSilverfishLegsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(138,133,120));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 360.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Silverfish Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SILVERFISH_BOOTS(new String[] {
            ChatColor.GRAY + "Gain a " + ChatColor.GREEN + "5% "+ ChatColor.GRAY + "chance to",
            ChatColor.GRAY + "summon a silverfish that copies", ChatColor.GREEN + "10%" + ChatColor.GRAY + " of your stats and lasts",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "10s"},
            FormatRecipesGUI::newSilverfishBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(138,133,120));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 140.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Silverfish Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SEVEN_LEAGUE_BOOTS(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(138, 109, 56));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 500.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, -500.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Seven League Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HEAVENLY_SNAIL(new String[] {
            ChatColor.GRAY + "Heal for " + ChatColor.GREEN + "30% " + ChatColor.GRAY + "more and gain",
            ChatColor.GRAY + "immunity to " + ChatColor.GRAY + "most negative effects."},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzg5ZjQ1MzBhOTQ3MzNjNTQ1ZDhlNTRlMGVkYTRiNThiMGU3YmJlYTY3ZmJhMjNkOTg0NWIxMjBlMjJkYzc1NSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Heavenly Snail");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 160.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"HealMod"), PersistentDataType.DOUBLE, 0.3);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TERRACOTTA_HELMET(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Seeker of Earth",
            ChatColor.GRAY + "When you are mining you",
            ChatColor.GRAY + "have a small chance to dig",
            ChatColor.GRAY + "up clay."},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWY4NGVhMTRlMGI3ZmRmZDIwOTRhN2Y0NzBhOWExODE0NGRhMGFjMTk0M2MwNDAxNjBkMjViNDBlZWRmNWM2OCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Terracotta Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 7.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE, 7.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TERRACOTTA_CHESTPLATE(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Seeker of Earth",
            ChatColor.GRAY + "When you are mining you",
            ChatColor.GRAY + "have a small chance to dig",
            ChatColor.GRAY + "up clay."},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(74,42,18));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Terracotta Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 11.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE, 11.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TERRACOTTA_LEGGINGS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Seeker of Earth",
            ChatColor.GRAY + "When you are mining you",
            ChatColor.GRAY + "have a small chance to dig",
            ChatColor.GRAY + "up clay."},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(74,42,18));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Terracotta Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 9.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE, 9.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    TERRACOTTA_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Seeker of Earth",
            ChatColor.GRAY + "When you are mining you",
            ChatColor.GRAY + "have a small chance to dig",
            ChatColor.GRAY + "up clay."},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(74,42,18));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Terracotta Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE, 5.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    INVOKER_HOOD(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newInvokerHoodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTE0YTZhZmEzNmM5N2M1MzE5ZWFmNTVkZTI0Y2JlN2UwNjc5ZjUwZTJhMTNkY2ZmOWUzZGE0MDg0Mzk3YTBjNiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Invoker Hood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 24.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 80.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    INVOKER_ROBES(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newInvokerRobesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(17,90,173));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Invoker Robes");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 55.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 120.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    INVOKER_TROUSERS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newInvokerTrousersGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(17,90,173));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Invoker Trousers");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 55.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 24.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 100.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    INVOKER_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newInvokerBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(17,90,173));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Invoker Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 9.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 65.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   INCANTER_HOOD(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newIncanterHoodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTg0ODVmODUyZDI3M2FiNjIyMzUxN2MwZDg0YzRjMTNmNzA0ZWE1ZTQwYTc0MzFjNTAxMmJiMmU4NjI1MDQ0NSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Incanter Hood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 9.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 18.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 130.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

    INCANTER_ROBES(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newIncanterRobesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(28, 176, 154));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Incanter Robes");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 24.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 240.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    INCANTER_TROUSERS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newIncanterTrousersGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(28, 176, 154));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Incanter Trousers");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 180.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    INCANTER_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newIncanterBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(28, 176, 154));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Incanter Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 6.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 7.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 110.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MYSTIC_HOOD(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newMysticHoodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg1MGM3ODg4N2MyMzAzOGEzMjRmYWRkMGY0YjIyNDgxYTA2OWYwZTgwNGQ3ZWIwOGM1Mjc3ZDg3ZGM3OWEyYyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mystic Hood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 9.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 60.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MYSTIC_ROBES(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newMysticRobesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(155, 28, 184));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mystic Robes");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 100.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MYSTIC_TROUSERS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newMysticTrousersGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(155, 28, 184));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mystic Trousers");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 54.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 80.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MYSTIC_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newMysticBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(155, 28, 184));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mystic Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 6.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 18.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 24.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CHANTER_HOOD(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newChanterHoodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmQzNDVhNGUxYmI4N2Q4ODVjMGI4NGUxM2EzYjlkNTE3Yjk0NmY2NTQyODQ0ZTlkMGNlNmFjYjdhZWYyYWQ1NiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Chanter Hood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 18.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 60.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CHANTER_ROBES(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you", ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newChanterRobesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(177, 189, 187));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Chanter Robes");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 42.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 100.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CHANTER_TROUSERS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to", ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newChanterTrousersGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(177, 189, 187));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Chanter Trousers");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 36.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 80.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CHANTER_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to", ChatColor.AQUA + "8% " + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newChanterBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(177, 189, 187));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Chanter Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 9.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 7.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 24.0);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ONYX_HELMET(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Monolith Stance",
            ChatColor.GRAY + "Slow and weaken nearby enemies"},
            FormatRecipesGUI::newOnyxHelmetGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_HELMET, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(41, 37, 37));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Onyx Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ONYX_CHESTPLATE(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Monolith Stance",
            ChatColor.GRAY + "Slow and weaken nearby enemies"},
            FormatRecipesGUI::newOnyxChestplateGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(41, 37, 37));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 175.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 110.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Onyx Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ONYX_LEGGINGS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Monolith Stance",
            ChatColor.GRAY + "Slow and weaken nearby enemies"},
            FormatRecipesGUI::newOnyxLegsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(41, 37, 37));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 150.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Onyx Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    ONYX_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Monolith Stance",
            ChatColor.GRAY + "Slow and weaken nearby enemies"},
            FormatRecipesGUI::newOnyxBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(41, 37, 37));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 65.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Onyx Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    STUDDED_ONYX_HELMET(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Dark Seal",
            ChatColor.RED + "Heal" + ChatColor.GRAY + " and gain " + ChatColor.AQUA + "mana " + ChatColor.GRAY + "when you",
            ChatColor.GRAY + "deal a " + ChatColor.DARK_BLUE + "critical hit"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_HELMET, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 120.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Studded Onyx Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    STUDDED_ONYX_CHESTPLATE(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Dark Seal",
            ChatColor.RED + "Heal" + ChatColor.GRAY + " and gain " + ChatColor.AQUA + "mana " + ChatColor.GRAY + "when you",
            ChatColor.GRAY + "deal a " + ChatColor.DARK_BLUE + "critical hit"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 220.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 85.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 110.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 65.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Studded Onyx Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    STUDDED_ONYX_LEGGINGS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Dark Seal",
            ChatColor.RED + "Heal" + ChatColor.GRAY + " and gain " + ChatColor.AQUA + "mana " + ChatColor.GRAY + "when you",
            ChatColor.GRAY + "deal a " + ChatColor.DARK_BLUE + "critical hit"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 180.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Studded Onyx Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    STUDDED_ONYX_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Dark Seal",
            ChatColor.RED + "Heal" + ChatColor.GRAY + " and gain " + ChatColor.AQUA + "mana " + ChatColor.GRAY + "when you",
            ChatColor.GRAY + "deal a " + ChatColor.DARK_BLUE + "critical hit"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.NETHERITE_BOOTS, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 24.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Studded Onyx Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SEVERED_CREEPER_HEAD(new String[] {
            ChatColor.GRAY + "Nearby " + ChatColor.GREEN + "creepers " + ChatColor.GRAY + "take",
            ChatColor.GRAY + "slightly more time",
            ChatColor.GRAY + "to explode"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CREEPER_HEAD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Severed Creeper Head");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SATURATED_CREEPER_MASK(new String[] {
            ChatColor.GRAY + "Nearby " + ChatColor.GREEN + "creepers " + ChatColor.GRAY + "take",
            ChatColor.GRAY + "more time",
            ChatColor.GRAY + "to explode"},
            FormatRecipesGUI::newSaturatedCreeperMaskGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzc5ZjEwYTk1OTU0ZDIwNWY2YjA5M2I4NjY1NTgwYmRiMTdkMDIxZGQ0NmY0MTFmOWRjZTc0OWMzNGU0ZTE4ZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 120.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Saturated Creeper Mask");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    INTRICATE_CREEPER_MASK(new String[] {
            ChatColor.GRAY + "Nearby " + ChatColor.GREEN + "creepers " + ChatColor.GRAY + "take",
            ChatColor.GRAY + "significantly more time", ChatColor.GRAY + "to explode"},
            FormatRecipesGUI::newIntricateCreeperMaskGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjAzMTYwN2YyNGU2M2Y0NTEwMzAyODNiZmQxYjhmOTlkNTJmMThmNDc3OGNkNmM5NWZlMzAzYzZjYTIxZGNiMiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 160.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 75.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Intricate Creeper Mask");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BEEKEEPER_HAT(new String[] {
            ChatColor.GRAY + "Take " + ChatColor.GREEN + "10% " + ChatColor.GRAY + "less damage from",
            ChatColor.YELLOW + "b" + ChatColor.DARK_GRAY + "e" + ChatColor.YELLOW + "e" + ChatColor.DARK_GRAY + "s",
            " ",
            ChatColor.GOLD + "Full Set Bonus: Master of Bees",
            ChatColor.GRAY + "Every " + ChatColor.GREEN + "5s " + ChatColor.GRAY + "summon a " + ChatColor.YELLOW + "b" + ChatColor.DARK_GRAY + "e" + ChatColor.YELLOW + "e",
            ChatColor.GRAY + "that lasts for " + ChatColor.GREEN + "8s"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjE1YmJiOGNjODdlNTU4ZDE1OWZkYWNiYTg4ZjUzNDI5OWZjZWNjODc0ZjYxYmQ3MzMzODk2YTJjYjM0ZmNjMSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 75.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Beekeeper Hat");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BEEKEEPER_VEST(new String[] {
            ChatColor.GRAY + "Take " + ChatColor.GREEN + "10% " + ChatColor.GRAY + "less damage from",
            ChatColor.YELLOW + "b" + ChatColor.DARK_GRAY + "e" + ChatColor.YELLOW + "e" + ChatColor.DARK_GRAY + "s",
            " ",
            ChatColor.GOLD + "Full Set Bonus: Master of Bees",
            ChatColor.GRAY + "Every " + ChatColor.GREEN + "5s " + ChatColor.GRAY + "summon a " + ChatColor.YELLOW + "b" + ChatColor.DARK_GRAY + "e" + ChatColor.YELLOW + "e",
            ChatColor.GRAY + "that lasts for " + ChatColor.GREEN + "8s"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(125, 111, 16));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 120.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Beekeeper Vest");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BEEKEEPER_PANTS(new String[] {
            ChatColor.GRAY + "Take " + ChatColor.GREEN + "10% " + ChatColor.GRAY + "less damage from",
            ChatColor.YELLOW + "b" + ChatColor.DARK_GRAY + "e" + ChatColor.YELLOW + "e" + ChatColor.DARK_GRAY + "s",
            " ",
            ChatColor.GOLD + "Full Set Bonus: Master of Bees",
            ChatColor.GRAY + "Every " + ChatColor.GREEN + "5s " + ChatColor.GRAY + "summon a " + ChatColor.YELLOW + "b" + ChatColor.DARK_GRAY + "e" + ChatColor.YELLOW + "e",
            ChatColor.GRAY + "that lasts for " + ChatColor.GREEN + "8s"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(125, 111, 16));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 85.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Beekeeper Pants");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BEEKEEPER_BOOTS(new String[] {
            ChatColor.GRAY + "Take " + ChatColor.GREEN + "10% " + ChatColor.GRAY + "less damage from",
            ChatColor.YELLOW + "b" + ChatColor.DARK_GRAY + "e" + ChatColor.YELLOW + "e" + ChatColor.DARK_GRAY + "s",
            " ",
            ChatColor.GOLD + "Full Set Bonus: Master of Bees", ChatColor.GRAY + "Every " + ChatColor.GREEN + "5s " + ChatColor.GRAY + "summon a " + ChatColor.YELLOW + "b" + ChatColor.DARK_GRAY + "e" + ChatColor.YELLOW + "e",
            ChatColor.GRAY + "that lasts for " + ChatColor.GREEN + "8s"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(125, 111, 16));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Beekeeper Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SWARMER_HEAD(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc0YTM1MzI0MzhmNzQ2NmE2MDI4NDFiZjUxODcxOWNhYjJlNGNlYjk4ODkyZjIyNjAyOTUxNmExOWQwZGFkZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 120.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Swarmer Head");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    HUNTER_CAP(new String[] {
            ChatColor.GRAY + "Gain " + ChatColor.GREEN + "+5% " + ChatColor.WHITE + "✦ Speed " + ChatColor.GRAY + "and",
            ChatColor.GREEN + "10% " + ChatColor.GRAY + "more damage from bows"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGMzMzVjOWQ5NjNhMTBjYTFmZGNlNGMxZWYzZTIwYWU4YmJkMTc4ZTUyNzIwZjIyMTBjZDBlNjYyYTkwZjAzNSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Magic"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"SpeedModifier"), PersistentDataType.DOUBLE, 0.05);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Hunter's Cap");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    COPPER_HELMET(new String[] {}, FormatRecipesGUI::newCopperHelmetGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_HELMET, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(247, 116, 77));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Copper Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    COPPER_CHESTPLATE(new String[] {}, FormatRecipesGUI::newCopperChestplateGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(247, 116, 77));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Copper Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    COPPER_LEGGINGS(new String[] {}, FormatRecipesGUI::newCopperLegsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(247, 116, 77));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 55.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Copper Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    COPPER_BOOTS(new String[] {}, FormatRecipesGUI::newCopperBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(247, 116, 77));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Copper Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    BUSH_SUIT(new String[] {
            ChatColor.DARK_GRAY + "Right-Click to equip",
            ChatColor.GRAY + "Disguise yourself as a bush",
            ChatColor.GRAY + "when you crouch"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.AZALEA, 1);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 150.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Bush Suit");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CACTUS_HELMET(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Impaling Spikes",
            ChatColor.GRAY + "Reflect " + ChatColor.RED + "10% " + ChatColor.GRAY + "of the " + ChatColor.RED + "damage",
            ChatColor.GRAY + "you take to the attacker"},
            FormatRecipesGUI::newCactusHelmetGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_HELMET, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(18, 59, 10));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 160.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CACTUS_CHESTPLATE(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Impaling Spikes",
            ChatColor.GRAY + "Reflect " + ChatColor.RED + "10% " + ChatColor.GRAY + "of the " + ChatColor.RED + "damage",
            ChatColor.GRAY + "you take to the attacker"},
            FormatRecipesGUI::newCactusChestplateGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(18, 59, 10));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 360.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CACTUS_LEGGINGS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Impaling Spikes",
            ChatColor.GRAY + "Reflect " + ChatColor.RED + "10% " + ChatColor.GRAY + "of the " + ChatColor.RED + "damage",
            ChatColor.GRAY + "you take to the attacker"},
            FormatRecipesGUI::newCactusLegsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(18, 59, 10));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 300.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CACTUS_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Impaling Spikes",
            ChatColor.GRAY + "Reflect " + ChatColor.RED + "10% " + ChatColor.GRAY + "of the " + ChatColor.RED + "damage",
            ChatColor.GRAY + "you take to the attacker"},
            FormatRecipesGUI::newCactusBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(18, 59, 10));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DARK_IRON_HELMET(new String[] {}, FormatRecipesGUI::newDarkIronHelmetGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 65.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dark Iron Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DARK_IRON_CHESTPLATE(new String[] {}, FormatRecipesGUI::newDarkIronChestplatetGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 120.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dark Iron Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DARK_IRON_LEGGINGS(new String[] {}, FormatRecipesGUI::newDarkIronLeggingsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 65.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dark Iron Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    DARK_IRON_BOOTS(new String[] {}, FormatRecipesGUI::newDarkIronBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dark Iron Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SPIDER_HELMET(new String[] {},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjJiNjczMmVhYTk3ODg0NTg0NjhmNTk3Njk0Mzk4NjQ2NDk3NGFmMzVmZWFmYjRmY2FkMDVhN2EzMDhjMmE2NyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 110.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Spider Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MOUNTAIN_GOAT_BOOTS(new String[] {
            ChatColor.GRAY + "Gain" + ChatColor.GREEN + " Jump Boost IV " + ChatColor.GRAY + "and take",
            ChatColor.GREEN + "90% " + ChatColor.GRAY + "less " + ChatColor.RED + "fall damage"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromRGB(46, 43, 43));
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 130.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 65.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mountain Goat Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },
//------------------------------------------ARMOR SECTION END x:armor---------------------------------------------------
//------------------------------------------REFORGE STONES c:reforges---------------------------------------------------

    TEST_STONE(new String[] {
            ChatColor.GRAY + "Apply to any item in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Reforged " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMGUyYzQ4MWEzOTdiN2E4OWI2YjQ1ZmQwZTEzMDE3NjhhZTE0OTdhY2YxYTljNzJjNzI0MjRhZDk0N2YzYSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Test Stone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "SPECIAL");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    PRISMATIC_STONE(new String[] {
            ChatColor.GRAY + "Apply to armor in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Prismatic " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTA2MGQxMjIwYjI2OGQ3NGIxODFiM2Q2YTZkMWE3YTlkNDA0NTI3NTk1MDdiMGY4MmE1NzhhZTJiMGU1NDVlMSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Prismatic Stone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    WHETSTONE(new String[] {
            ChatColor.GRAY + "Apply to a sword in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Sharp " + ChatColor.GRAY + "reforge"},
            FormatRecipesGUI::newWhetstoneGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmNiYzlkZWQ5Y2U5MTYxYjI0OTJiYjBmMzY1YWUzMDE3MThkMGVjODI3YWQ5YTg0Mjk3YWY2YzQxMDI2OTI3YyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Whetstone");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    CHUNK_OF_MEAT(new String[] {
            ChatColor.GRAY + "Apply to armor in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Meaty " + ChatColor.GRAY + "reforge"},
            FormatRecipesGUI::newChunkOfMeatGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzI1MDI1ODczZTNjNWU3NWY5YWNmYmNkZDA4ZDMxNWU0ODM1OWM1ODdiODdlZDNmY2NhMmNlZWYwYzQ3OTMzMSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Chunk of Meat");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    OLD_VASE(new String[] {
            ChatColor.GRAY + "Apply to a wand in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Antique " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU2YWM1YzU3YWI1ODMzNjg4YmYzMjU0ZjhjZTJhYjEzZDJmYjg4YzRhZTNhYWRlMzFhYmMxNTQ3NTM5YTY3NSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Old Vase");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   HAIR_TRIGGER(new String[] {
            ChatColor.GRAY + "Apply to a bow in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Repeating " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTJlNDU4NmEyMGMyZmI2NGNkYjg0MjcyMWViYmE0ZWQyYWExMGE1NWY2MWRmYWE2ZWJiODY2ODZjMTNmYmEifX19");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Hair Trigger");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   LIVING_HONEY(new String[]{
            ChatColor.GRAY + "Apply to armor in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Gooey " + ChatColor.GRAY + "reforge"},
            FormatRecipesGUI::newLivingHoneyGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWViZGI5NmM5NDE1ZGMxYThhNDdkYmVlMTg5YmI2ZTZjNzdlOTQwM2QzYjEzYjE1Y2I1NTVkMzI2MjE2Mjk5YSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Living Honey");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   RUSTY_COG(new String[] {
            ChatColor.GRAY + "Apply to armor in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Rusty " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTNjNmI3ODdhOGIxYTc4MzNiNmVkZGYwYmFmNjk1MjU5MDhlMjc4ZmJiNDcwMzQzMjYxNGI5ZDUzZmQzMWQ3ZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Rusty Cog");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   VENOMOUS_FANG(new String[] {
            ChatColor.GRAY + "Apply to a weapon in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Venomous " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.GHAST_TEAR);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Venomous Fang");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   STIMULATING_GLAND(new String[] {
            ChatColor.GRAY + "Apply to a shield in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Stimulating " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODk4OWRjOTY4MWI2Y2Y5ZDNiNGE4ZTJjNTU0ZWExYmNlNjMyNjc5ZDMxOTZhNDU0MDgzNWFjOGQzYWQzMTIifX19");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Stimulating Gland");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   ATTACHABLE_LANTERN(new String[] {
            ChatColor.GRAY + "Apply to a helmet in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Illuminating " + ChatColor.GRAY + "reforge"},
            FormatRecipesGUI::newAttachableLantern) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmVmN2I3OTU4YTkzNTIxYjBhNmU5M2ZiNjMxMzhmNDhmNGYxMWY0YWQ1ZWRiMDE5MGE4MzRlZGFkMWIxNmRhYyJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Attachable Lantern");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   DISCREET_SLUDGE(new String[] {
            ChatColor.GRAY + "Apply to armor in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Camouflaged " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU1MTRhZjVhOTZkY2VjZDMzY2I4Mzg4YzI0ZDU2ZDUyMDcwMmI0N2E4NWI3ZDZmMjM3ZjcyYWE2ZmE0OTgyOSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Discreet Sludge");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   RELENTLESS_LIFEBLOOD(new String[] {
            ChatColor.GRAY + "Apply to a chestplate in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Tenacious " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWVmMTYyZGVmODQ1YWEzZGM3ZDQ2Y2QwOGE3YmY5NWJiZGZkMzJkMzgxMjE1YWE0MWJmZmFkNTIyNDI5ODcyOCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Relentless Lifeblood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

   SHADY_AUGMENT(new String[] {
            ChatColor.GRAY + "Apply to a bow in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Sawed-Off " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.MUSIC_DISC_STRAD);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Shady Augment");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },

   GIANTS_HEART(new String[] {
            ChatColor.GRAY + "Apply to armor in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Gigantic " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQ1ZjRkMTM5YzllODkyNjJlYzA2YjI3YWFhZDczZmE0ODhhYjQ5MjkwZDJjY2Q2ODVhMjU1NDcyNTM3M2M5YiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Giant's Heart");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
       }
   },

   VILE_BLOOD(new String[] {
            ChatColor.GRAY + "Apply to a bow in an anvil",
            ChatColor.GRAY + "to give it the " + ChatColor.BLUE + "Leaching " + ChatColor.GRAY + "reforge"},
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDMxY2Q3ZWQ0ZTRiZjA3YzNkZmQ5YmE0OTg3MDhlNzMwZTY5ZDgwNzMzNWFmZmFiYzEyZDg3ZmY1NDJmNmE4OCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Vile Blood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "reforge stone");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
   },
    //------------------------------------------REFORGE STONE SECTION END x:reforges---------------------------------------------------
    //------------------------------------------POTION SECTION START c:potion----------------------------------------------------------
    EMPTY_POTION(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POTION);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Potion of ");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "COMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "Potion");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"additive"), PersistentDataType.STRING, "");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"effect"), PersistentDataType.STRING, "Generic-a");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"power"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"duration"), PersistentDataType.LONG, 300000l);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    COMT_FROOT_JUICE(new String[] {
            ChatColor.GRAY + "Additives can be applied",
            ChatColor.GRAY + "to " + ChatColor.BLUE + "potions " + ChatColor.GRAY + "in the brewing",
            ChatColor.GRAY + "process to give them" + ChatColor.RED + " s" + ChatColor.GOLD + "p" + ChatColor.YELLOW + "e" +
                    ChatColor.GREEN + "c" + ChatColor.BLUE + "i" + ChatColor.LIGHT_PURPLE + "a" + ChatColor.DARK_PURPLE + "l",
            ChatColor.GRAY + "benefits",
            " ",
            ChatColor.BLUE + "Gain these effects (multiplied by potion level)",
            ChatColor.RED + "-2 ❤ Health" + ChatColor.GRAY + ", " + ChatColor.WHITE + "+1 ✦ Speed" + ChatColor.GRAY + ", "
            + ChatColor.DARK_AQUA + "+0.5 ✯ Magic Find" + ChatColor.GRAY + ",",
            ChatColor.GRAY + "and" + ChatColor.AQUA + "-2 ✎ Intelligence"}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.POTION);
            PotionMeta meta = (PotionMeta)item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "COMT Froot Juice™");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "additive");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"additive"), PersistentDataType.STRING, "Fruity");
            meta.setColor(Color.fromRGB(255, 33, 33));
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SUGAR_CUBE(new String[] {
            ChatColor.GRAY + "Additives can be applied",
            ChatColor.GRAY + "to " + ChatColor.BLUE + "potions " + ChatColor.GRAY + "in the brewing",
            ChatColor.GRAY + "process to give them" + ChatColor.RED + " s" + ChatColor.GOLD + "p" + ChatColor.YELLOW + "e" +
                    ChatColor.GREEN + "c" + ChatColor.BLUE + "i" + ChatColor.LIGHT_PURPLE + "a" + ChatColor.DARK_PURPLE + "l",
            ChatColor.GRAY + "benefits",
            " ",
            ChatColor.BLUE + "Gain these effects (multiplied by potion level)",
            ChatColor.WHITE + "+1 ✦ Speed"}, FormatRecipesGUI::newSugarCubeGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWYyNWRmYjczNjgxNzkxYTc2NmFlMzE1OTkyMGFkYjQyYWQwYjY2YmNlZjY5OGU5Njk3NzYyYTI0MmZjNTU3OSJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sugar Cube");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "additive");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"additive"), PersistentDataType.STRING, "Sweet");
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },
    //------------------------------------------POTION SECTION END x:potion------------------------------------------------------------
    //------------------------------------------PET SECTION START c:pet c:pets------------------------------------------------------------
    ALIEN(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzMwY2Y4YmNhODI0MmNiZTI2YzYzYTQzNDBjNDE3MzJlM2UxYzg3MDMwMDExNzg5ZjA4NGVlNWViNzZkODI1MiJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alien");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "COMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"petType"), PersistentDataType.STRING, "Combat");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"xp"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"baseIntelligence"), PersistentDataType.DOUBLE, 1.2);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"baseThaumaturgy"), PersistentDataType.DOUBLE, 0.4);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    COW(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmU4NDU2MTU1MTQyY2JlNGU2MTM1M2ZmYmFmZjMwNGQzZDljNGJjOTI0N2ZjMjdiOTJlMzNlNmUyNjA2N2VkZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cow");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "COMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"petType"), PersistentDataType.STRING, "Farming");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"xp"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"baseHealth"), PersistentDataType.DOUBLE, 1.5);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    SAND_WORM(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmU4NDU2MTU1MTQyY2JlNGU2MTM1M2ZmYmFmZjMwNGQzZDljNGJjOTI0N2ZjMjdiOTJlMzNlNmUyNjA2N2VkZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sand Worm");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "COMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"petType"), PersistentDataType.STRING, "Excavating");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"xp"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"baseHealth"), PersistentDataType.DOUBLE, 1.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"baseStrength"), PersistentDataType.DOUBLE, .25);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"baseCrit"), PersistentDataType.DOUBLE, .2);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },

    MOLE(new String[] {}, null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmU4NDU2MTU1MTQyY2JlNGU2MTM1M2ZmYmFmZjMwNGQzZDljNGJjOTI0N2ZjMjdiOTJlMzNlNmUyNjA2N2VkZCJ9fX0=");
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sand Worm");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "COMMON");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "pet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"petType"), PersistentDataType.STRING, "Excavating");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER, 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"xp"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"baseHealth"), PersistentDataType.DOUBLE, 1.2);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"baseDefense"), PersistentDataType.DOUBLE, .3);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"baseExcavatingFortune"), PersistentDataType.DOUBLE, .4);
            item.setItemMeta(meta);
            initItem(plugin, item);
            return item;
        }
    },
    //------------------------------------------PET SECTION END x:pet x:pets------------------------------------------------------------
    ;

    public abstract ItemStack getItem(Plugin plugin);

    public final List<String> baseLore;

    public final BiFunction<Plugin, InventoryHolder, FormatRecipesGUI> recipeGUI;

    Items(String[] lore, BiFunction<Plugin, InventoryHolder, FormatRecipesGUI> GUI) {
        recipeGUI = GUI;
        baseLore = new ArrayList<>(Arrays.asList(lore));
    }

    public void initItem(Plugin plugin, ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ordinal"), PersistentDataType.INTEGER, this.ordinal());
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setUnbreakable(true);
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentName"), new stringList()) == null) {
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"enchantmentName"), new stringList(), new String[]{});
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"enchantmentPower"), PersistentDataType.INTEGER_ARRAY, new int[]{});
        }
        item.setItemMeta(meta);
        updateItem(plugin, item);
    }

    public static void registerRecipes(Plugin plugin) {
        // Shaped Recipe for Fire Ball Name
        ItemStack item;
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

        // Shaped Recipe for Enchanted Deepslate Tiles
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_deepslate"), Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin));
        sr.shape("DDD",
                "DDD",
                "DDD");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin)));
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
        slr.addIngredient(9, Material.IRON_INGOT);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Enchanted Iron Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_iron_s"), Items.ENCHANTED_IRON_BLOCK .getItem(plugin));
        sr.shape("III",
                 "III",
                 "III");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shapeless recipe for Enchanted Coal
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_coal_sl"), Items.ENCHANTED_COAL.getItem(plugin));
        slr.addIngredient(9, Material.COAL);
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
        slr.addIngredient(9, Material.GOLD_INGOT);
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
        slr.addIngredient(9, Material.COPPER_INGOT);
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
        slr.addIngredient(9, Material.QUARTZ);
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
        slr.addIngredient(9, Material.LAPIS_LAZULI);
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
        slr.addIngredient(9, Material.REDSTONE);
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

        //Shaped recipe for Stone Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("stone_scimitar_s"), Items.STONE_SCIMITAR.getItem(plugin));
        sr.shape("  C",
                 " C ",
                 "S  ");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COBBLESTONE.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Slated Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("slated_scimitar_s"), Items.SLATED_SCIMITAR.getItem(plugin));
        sr.shape("SDS",
                 "DWD",
                 "SDS");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.STONE_SCIMITAR.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Iron Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("iron_scimitar_s"), Items.IRON_SCIMITAR.getItem(plugin));
        sr.shape("  I",
                 " I ",
                 "S  ");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Alloy Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_scimitar_s"), Items.ALLOY_SCIMITAR.getItem(plugin));
        sr.shape("IIA",
                 "AAI",
                 "WAI");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.IRON_SCIMITAR.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Gold Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("gold_scimitar_s"), Items.GOLD_SCIMITAR.getItem(plugin));
        sr.shape("  G",
                 " G ",
                 "S  ");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Ornamental Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("ornamental_scimitar_s"), Items.ORNAMENTAL_SCIMITAR.getItem(plugin));
        sr.shape("DGE",
                 "GWG",
                 "AGL");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_EMERALD.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.GOLD_SCIMITAR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Diamond Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("diamond_scimitar_s"), Items.DIAMOND_SCIMITAR.getItem(plugin));
        sr.shape("  D",
                 " D ",
                 "S  ");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Obsidian Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("obsidian_scimitar_s"), Items.OBSIDIAN_SCIMITAR.getItem(plugin));
        sr.shape("OOO",
                 "OWO",
                 "OOO");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ENCHANTED_OBSIDIAN.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.DIAMOND_SCIMITAR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Gemstone Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("gemstone_scimitar_s"), Items.GEMSTONE_SCIMITAR.getItem(plugin));
        sr.shape("GGG",
                 "GWG",
                 "GGG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.DIAMOND_SCIMITAR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Netherite Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("netherite_scimitar_s"), Items.NETHERITE_SCIMITAR.getItem(plugin));
        sr.shape("  N",
                 " N ",
                 "S  ");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.ENCHANTED_NETHERITE.getItem(plugin)));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for The Drip 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("the_drip_s1"), Items.THE_DRIP.getItem(plugin));
        sr.shape("   ",
                 "D D",
                 "D D");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIPSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for The Drip
        sr = new ShapedRecipe(NamespacedKey.minecraft("the_drip_s2"), Items.THE_DRIP.getItem(plugin));
        sr.shape("D D",
                 "D D",
                 "   ");
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

        //Shaped recipe for Alloy Helmet 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_helm_s1"), Items.ALLOY_HELMET.getItem(plugin));
        sr.shape("AAA",
                 "A A",
                 "   ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Alloy Helmet 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_helm_s2"), Items.ALLOY_HELMET.getItem(plugin));
        sr.shape("   ",
                 "AAA",
                 "A A");
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

        //Shaped recipe for Alloy Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_boots_s1"), Items.ALLOY_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "A A",
                 "A A");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Alloy Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_boots_s2"), Items.ALLOY_BOOTS.getItem(plugin));
        sr.shape("A A",
                 "A A",
                 "   ");
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
        slr.addIngredient(9, Material.STRING);
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
        slr.addIngredient(9, Material.NETHER_WART);
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
        slr.addIngredient(9, Material.MELON_SLICE);
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

        // Shapeless Recipe for Obsidian
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_obby_sl"), Items.ENCHANTED_OBSIDIAN.getItem(plugin));
        slr.addIngredient(9, Material.OBSIDIAN);
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

        //Shaped recipe for Fibrous Stew
        sr = new ShapedRecipe(NamespacedKey.minecraft("fiber_stew_s"), Items.FIBROUS_STEW.getItem(plugin));
        sr.shape("WCB",
                 "SAL",
                 " b ");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WARPED_STEM.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CRIMSON_STEM.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.BAMBOO_BUNDLE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_WEB.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_CACTUS.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        sr.setIngredient('b', Material.BOWL);

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Spicy Stew
        sr = new ShapedRecipe(NamespacedKey.minecraft("spicy_stew_s"), Items.SPICY_STEW.getItem(plugin));
        sr.shape("KGW",
                 "BFP",
                 " b ");
        sr.setIngredient('K', new RecipeChoice.ExactChoice(Items.ENCHANTED_KELP_BLOCK.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WART.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BEETROOT_SOUP.getItem(plugin)));
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.PULSING_TUMOR.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PUFFERFISH.getItem(plugin)));
        sr.setIngredient('b', Material.BOWL);

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Hearty Stew
        sr = new ShapedRecipe(NamespacedKey.minecraft("hearty_stew_s"), Items.HEARTY_STEW.getItem(plugin));
        sr.shape("PMC",
                 "RBp",
                 " b ");
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PUMPKIN.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.ENCHANTED_MELON.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLDEN_CARROT.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_RED_MUSHROOM.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BROWN_MUSHROOM.getItem(plugin)));
        sr.setIngredient('p', new RecipeChoice.ExactChoice(Items.ENCHANTED_BAKED_POTATO.getItem(plugin)));
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
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.BUNDLED_DARK_OAK_LOGS.getItem(plugin)));
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.BUNDLED_OAK_LOGS.getItem(plugin)));
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

        //Shaped recipe for Pocket Workbench 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("porcket_workbench_s1"), Items.POCKET_WORKBENCH.getItem(plugin));
        sr.shape("AS ",
                 "BO ",
                 "   ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_ACACIA_WOOD.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SPRUCE_WOOD.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BIRCH_WOOD.getItem(plugin)));
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ENCHANTED_OAK_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Pocket Workbench 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("porcket_workbench_s2"), Items.POCKET_WORKBENCH.getItem(plugin));
        sr.shape("   ",
                 "AS ",
                 "BO ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_ACACIA_WOOD.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SPRUCE_WOOD.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BIRCH_WOOD.getItem(plugin)));
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ENCHANTED_OAK_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Pocket Workbench 3
        sr = new ShapedRecipe(NamespacedKey.minecraft("porcket_workbench_s3"), Items.POCKET_WORKBENCH.getItem(plugin));
        sr.shape(" AS",
                 " BO",
                 "   ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_ACACIA_WOOD.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SPRUCE_WOOD.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BIRCH_WOOD.getItem(plugin)));
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ENCHANTED_OAK_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Pocket Workbench 4
        sr = new ShapedRecipe(NamespacedKey.minecraft("porcket_workbench_s4"), Items.POCKET_WORKBENCH.getItem(plugin));
        sr.shape("   ",
                 " AS",
                 " BO");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_ACACIA_WOOD.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SPRUCE_WOOD.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BIRCH_WOOD.getItem(plugin)));
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ENCHANTED_OAK_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Copper Shield
        sr = new ShapedRecipe(NamespacedKey.minecraft("copper_shield_s"), Items.COPPER_SHIELD.getItem(plugin));
        sr.shape("CCC",
                 "CSC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Iron Shield
        sr = new ShapedRecipe(NamespacedKey.minecraft("iron_shield_s"), Items.IRON_SHIELD.getItem(plugin));
        sr.shape("III",
                 "ISI",
                 "III");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Lapis Shield
        sr = new ShapedRecipe(NamespacedKey.minecraft("lapis_shield_s"), Items.LAPIS_SHIELD.getItem(plugin));
        sr.shape("LLL",
                 "LSL",
                 "LLL");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Redstone Shield
        sr = new ShapedRecipe(NamespacedKey.minecraft("redstone_shield_s"), Items.REDSTONE_SHIELD.getItem(plugin));
        sr.shape("RRR",
                 "RSR",
                 "RRR");
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Diamond Shield
        sr = new ShapedRecipe(NamespacedKey.minecraft("diamond_shield_s"), Items.DIAMOND_SHIELD.getItem(plugin));
        sr.shape("DDD",
                 "DSD",
                 "DDD");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Emerald Shield
        sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_shield_s"), Items.EMERALD_SHIELD.getItem(plugin));
        sr.shape("EEE",
                 "ESE",
                 "EEE");
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_EMERALD.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Netherite Shield
        sr = new ShapedRecipe(NamespacedKey.minecraft("netherite_shield_s"), Items.NETHERITE_SHIELD.getItem(plugin));
        sr.shape("NNN",
                 "NSN",
                 "NNN");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.ENCHANTED_NETHERITE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Lightning Rod
        sr = new ShapedRecipe(NamespacedKey.minecraft("lightning_wand_s"), Items.LIGHTNING_WAND.getItem(plugin));
        sr.shape(" R ",
                 " C ",
                 " C ");
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CUT_COPPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Enchanted Ghast Tear
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_tear_sl"), Items.ENCHANTED_GHAST_TEAR.getItem(plugin));
        slr.addIngredient(5, Material.GHAST_TEAR);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Hardwood Handle 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("wood_handle_s1"), Items.HARDWOOD_HANDLE.getItem(plugin));
        sr.shape("  W",
                 " W ",
                 "W  ");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.BUNDLED_OAK_LOGS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Hardwood Handle 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("wood_handle_s2"), Items.HARDWOOD_HANDLE.getItem(plugin));
        sr.shape("  W",
                 " W ",
                 "W  ");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.BUNDLED_DARK_OAK_LOGS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Hardwood Handle 3
        sr = new ShapedRecipe(NamespacedKey.minecraft("wood_handle_s3"), Items.HARDWOOD_HANDLE.getItem(plugin));
        sr.shape("  W",
                 " W ",
                 "W  ");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.BUNDLED_BIRCH_LOGS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Hardwood Handle 4
        sr = new ShapedRecipe(NamespacedKey.minecraft("wood_handle_s4"), Items.HARDWOOD_HANDLE.getItem(plugin));
        sr.shape("  W",
                 " W ",
                 "W  ");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.BUNDLED_ACACIA_LOGS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Hardwood Handle 5
        sr = new ShapedRecipe(NamespacedKey.minecraft("wood_handle_s5"), Items.HARDWOOD_HANDLE.getItem(plugin));
        sr.shape("  W",
                 " W ",
                 "W  ");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.BUNDLED_JUNGLE_LOGS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Gyroscope
        sr = new ShapedRecipe(NamespacedKey.minecraft("gyro_s"), Items.GYROSCOPE.getItem(plugin));
        sr.shape(" I ",
                 "IRI",
                 " I ");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Kinetic Rod
        sr = new ShapedRecipe(NamespacedKey.minecraft("kinetic_rod_s"), Items.KINETIC_ROD.getItem(plugin));
        sr.shape("  G",
                 " HS",
                 "H S");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HARDWOOD_HANDLE.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GYROSCOPE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_STRING.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Grappling Hook
        sr = new ShapedRecipe(NamespacedKey.minecraft("grappling_hook_s"), Items.GRAPPLING_HOOK.getItem(plugin));
        sr.shape("  S",
                 " Ss",
                 "S s");
        sr.setIngredient('S', Material.STICK);
        sr.setIngredient('s', new RecipeChoice.ExactChoice(Items.ENCHANTED_STRING.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Wand of Maggots
        sr = new ShapedRecipe(NamespacedKey.minecraft("mite_wand_s"), Items.WAND_OF_MAGGOTS.getItem(plugin));
        sr.shape(" SS",
                 " HS",
                 "H  ");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HARDWOOD_HANDLE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SILVERFISH_SCALE.getItem(plugin)));

        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Silverfish Helmet 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("silverfish_helm_s1"), Items.SILVERFISH_HELMET.getItem(plugin));
        sr.shape("SSS",
                 "S S",
                 "   ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SILVERFISH_SCALE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Silverfish Helmet 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("silverfish_helm_s2"), Items.SILVERFISH_HELMET.getItem(plugin));
        sr.shape("   ",
                 "SSS",
                 "S S");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SILVERFISH_SCALE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Silverfish Chestplate
        sr = new ShapedRecipe(NamespacedKey.minecraft("silverfish_chest_s"), Items.SILVERFISH_CHESTPLATE.getItem(plugin));
        sr.shape("S S",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SILVERFISH_SCALE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Silverfish Leggings
        sr = new ShapedRecipe(NamespacedKey.minecraft("silverfish_legs_s"), Items.SILVERFISH_LEGGINGS.getItem(plugin));
        sr.shape("SSS",
                 "S S",
                 "S S");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SILVERFISH_SCALE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Silverfish Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("silverfish_boots_s1"), Items.SILVERFISH_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "S S",
                 "S S");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SILVERFISH_SCALE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Silverfish Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("silverfish_boots_s2"), Items.SILVERFISH_BOOTS.getItem(plugin));
        sr.shape("S S",
                 "S S",
                 "   ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SILVERFISH_SCALE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Lesser Wand of Healing
        sr = new ShapedRecipe(NamespacedKey.minecraft("lesser_heal_wand_s"), Items.LESSER_HEAL_WAND.getItem(plugin));
        sr.shape("  T",
                 " F ",
                 "T  ");
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.PULSING_TUMOR.getItem(plugin)));
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_ROTTEN_FLESH.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Wand of Healing
        sr = new ShapedRecipe(NamespacedKey.minecraft("heal_wand_s"), Items.HEAL_WAND.getItem(plugin));
        sr.shape(" FT",
                 "FWF",
                 "TF ");
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.PULSING_TUMOR.getItem(plugin)));
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_ROTTEN_FLESH.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.LESSER_HEAL_WAND.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Chain Heal Wand
        sr = new ShapedRecipe(NamespacedKey.minecraft("chain_heal_wand_s"), Items.FLASH_HEAL_WAND.getItem(plugin));
        sr.shape(" SW",
                "SWS",
                "WS ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SUGAR.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.HEAL_WAND.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Potion Shortbow
        sr = new ShapedRecipe(NamespacedKey.minecraft("potion_shortbow__s"), Items.POTION_SHORTBOW.getItem(plugin));
        sr.shape(" HS",
                 "C S",
                 " cS");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HARDWOOD_HANDLE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_STRING.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.RIVER_CLAY.getItem(plugin)));
        sr.setIngredient('c', new RecipeChoice.ExactChoice(Items.ENCHANTED_CLAY_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Whetstone
        sr = new ShapedRecipe(NamespacedKey.minecraft("whetstone_s"), Items.WHETSTONE.getItem(plugin));
        sr.shape("FFF",
                 "FCF",
                 "FFF");
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_FLINT.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COBBLESTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Furnace Recipe for Cooked Monster Meat
        fr = new FurnaceRecipe(NamespacedKey.minecraft("monster_meat_f"), Items.COOKED_MONSTER_MEAT.getItem(plugin),
                new RecipeChoice.ExactChoice(Items.MONSTER_MEAT.getItem(plugin)), 8.0f,  200);
        Bukkit.getServer().addRecipe(fr);

        // Smoker Recipe for Cooked Monster Meat
        SmokingRecipe sm = new SmokingRecipe(NamespacedKey.minecraft("monster_meat_f"), Items.COOKED_MONSTER_MEAT.getItem(plugin),
                new RecipeChoice.ExactChoice(Items.MONSTER_MEAT.getItem(plugin)), 8.0f, 100);
        Bukkit.getServer().addRecipe(sm);

        //Shaped recipe for Chunk of Meat
        sr = new ShapedRecipe(NamespacedKey.minecraft("meat_chunk_s"), Items.CHUNK_OF_MEAT.getItem(plugin));
        sr.shape("BMB",
                 "MMM",
                 "BMB");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BEEF.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.MONSTER_MEAT.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Stats of Guide 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("stat_book_s1"), Items.STATS_GUIDE.getItem(plugin));
        sr.shape("   ",
                 "IR ",
                 "LP ");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_INK_SAC.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PAPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Stats of Guide 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("stat_book_s2"), Items.STATS_GUIDE.getItem(plugin));
        sr.shape("   ",
                 " IR",
                 " LP");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_INK_SAC.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PAPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Stats of Guide 3
        sr = new ShapedRecipe(NamespacedKey.minecraft("stat_book_s3"), Items.STATS_GUIDE.getItem(plugin));
        sr.shape( "IR ",
                  "LP ",
                  "   ");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_INK_SAC.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PAPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Stats of Guide 4
        sr = new ShapedRecipe(NamespacedKey.minecraft("stat_book_s4"), Items.STATS_GUIDE.getItem(plugin));
        sr.shape(" IR",
                 " LP",
                 "   ");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_INK_SAC.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PAPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Gemstone
        sr = new ShapedRecipe(NamespacedKey.minecraft("gemstone_s"), Items.GEMSTONE.getItem(plugin));
        sr.shape("EDE",
                 "D D",
                 "EDE");
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_EMERALD.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Metal Detector
        sr = new ShapedRecipe(NamespacedKey.minecraft("metal_detector_s"), Items.METAL_DETECTOR.getItem(plugin));
        sr.shape("IRS",
                 " S ",
                 "S  ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.METAL_SCRAP.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Metalloid Detector
        sr = new ShapedRecipe(NamespacedKey.minecraft("metalloid_detector_s"), Items.METAL_DETECTOR.getItem(plugin));
        sr.shape("RGR",
                 "GMG",
                 "RGR");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD_BLOCK.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.METAL_DETECTOR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Treasure Detector
        sr = new ShapedRecipe(NamespacedKey.minecraft("treasure_detector_s"), Items.TREASURE_DETECTOR.getItem(plugin));
        sr.shape("GNG",
                 "GMG",
                 "GNG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.METAL_DETECTOR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Invoker Hood 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("invoker_hood_s1"), Items.INVOKER_HOOD.getItem(plugin));
        sr.shape("LLL",
                 "W W",
                 "   ");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WOOL.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Invoker Hood 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("invoker_hood_s2"), Items.INVOKER_HOOD.getItem(plugin));
        sr.shape("   ",
                 "LLL",
                 "W W");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WOOL.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Invoker Robes
        sr = new ShapedRecipe(NamespacedKey.minecraft("invoker_robes_s"), Items.INVOKER_ROBES.getItem(plugin));
        sr.shape("W W",
                 "WLW",
                 "CCC");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WOOL.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_WEB.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Invoker Trousers
        sr = new ShapedRecipe(NamespacedKey.minecraft("invoker_trousers_s"), Items.INVOKER_TROUSERS.getItem(plugin));
        sr.shape("CLC",
                 "L L",
                 "L L");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_WEB.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Invoker Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("invoker_boots_s1"), Items.INVOKER_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "L L",
                 "W W");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WOOL.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Invoker Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("invoker_boots_s2"), Items.INVOKER_BOOTS.getItem(plugin));
        sr.shape("L L",
                 "W W",
                 "   ");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WOOL.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Incanter Hood 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("incanter_hood_s1"), Items.INCANTER_HOOD.getItem(plugin));
        sr.shape("EHE",
                 "G G",
                 "   ");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.INVOKER_HOOD.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_ENDER_EYE.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Incanter Hood 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("incanter_hood_s2"), Items.INCANTER_HOOD.getItem(plugin));
        sr.shape("   ",
                 "EHE",
                 "G G");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.INVOKER_HOOD.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_ENDER_EYE.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Incanter Robes
        sr = new ShapedRecipe(NamespacedKey.minecraft("incanter_robes_s"), Items.INCANTER_ROBES.getItem(plugin));
        sr.shape("E E",
                 "GCG",
                 "GGG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.INVOKER_ROBES.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_ENDER_EYE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Incanter Trousers
        sr = new ShapedRecipe(NamespacedKey.minecraft("incanter_trousers_s"), Items.INCANTER_TROUSERS.getItem(plugin));
        sr.shape("ELE",
                 "G G",
                 "G G");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_ENDER_EYE.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.INVOKER_TROUSERS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Incanter Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("incanter_boots_s1"), Items.INCANTER_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "B B",
                 "G G");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.INVOKER_BOOTS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Incanter Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("incanter_boots_s2"), Items.INCANTER_BOOTS.getItem(plugin));
        sr.shape("B B",
                 "G G",
                 "   ");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.INVOKER_BOOTS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Mystic Hood 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("mystic_hood_s1"), Items.MYSTIC_HOOD.getItem(plugin));
        sr.shape("AHA",
                 "G G",
                 "   ");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.INVOKER_HOOD.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Mystic Hood 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("mystic_hood_s2"), Items.MYSTIC_HOOD.getItem(plugin));
        sr.shape("   ",
                 "AHA",
                 "G G");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.INVOKER_HOOD.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);


        //Shaped recipe for Mystic Robes
        sr = new ShapedRecipe(NamespacedKey.minecraft("mystic_robes_s"), Items.MYSTIC_ROBES.getItem(plugin));
        sr.shape("A A",
                 "ACA",
                 "GGG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.INVOKER_ROBES.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Mystic Trousers
        sr = new ShapedRecipe(NamespacedKey.minecraft("mystic_trousers_s"), Items.MYSTIC_TROUSERS.getItem(plugin));
        sr.shape("GLG",
                 "A A",
                 "A A");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.INVOKER_TROUSERS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Mystic Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("mystic_boots_s1"), Items.MYSTIC_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "B B",
                 "A A");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.INVOKER_BOOTS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Mystic Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("mystic_boots_s2"), Items.MYSTIC_BOOTS.getItem(plugin));
        sr.shape("B B",
                 "A A",
                 "   ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.INVOKER_BOOTS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Chanter Hood 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("whisper_hood_s1"), Items.CHANTER_HOOD.getItem(plugin));
        sr.shape("GHG",
                 "D D",
                 "   ");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.INVOKER_HOOD.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GHAST_TEAR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Chanter Hood 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("whisper_hood_s2"), Items.CHANTER_HOOD.getItem(plugin));
        sr.shape("   ",
                 "GHG",
                 "D D");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.INVOKER_HOOD.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GHAST_TEAR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Chanter Robes
        sr = new ShapedRecipe(NamespacedKey.minecraft("whisper_robes_s"), Items.CHANTER_ROBES.getItem(plugin));
        sr.shape("G D",
                 "DCD",
                 "DGG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GHAST_TEAR.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.INVOKER_ROBES.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Chanter Trousers
        sr = new ShapedRecipe(NamespacedKey.minecraft("whisper_trousers_s"), Items.CHANTER_TROUSERS.getItem(plugin));
        sr.shape("GLD",
                 "D G",
                 "G D");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GHAST_TEAR.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.INVOKER_TROUSERS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Chanter Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("whisper_boots_s1"), Items.CHANTER_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "B B",
                 "D D");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.INVOKER_BOOTS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Chanter Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("whisper_boots_s2"), Items.CHANTER_BOOTS.getItem(plugin));
        sr.shape("B B",
                 "D D",
                 "   ");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.INVOKER_BOOTS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Dune Wand
        sr = new ShapedRecipe(NamespacedKey.minecraft("dune_wand_s"), Items.DUNE_WAND.getItem(plugin));
        sr.shape(" SC",
                 "SWS",
                 "CS ");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.CLUMPED_SAND.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SANDSTONE.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.SAND_WAND.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Prismatic Wand
        sr = new ShapedRecipe(NamespacedKey.minecraft("prismatic_wand_s"), Items.PRISMATIC_WAND.getItem(plugin));
        sr.shape("QRC",
                 "AWG",
                 "LDE");
        sr.setIngredient('Q', new RecipeChoice.ExactChoice(Items.ENCHANTED_QUARTZ_SCULPTURE.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CUT_COPPER.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.DUNE_WAND.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD_BLOCK.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS_BLOCK.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_EMERALD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Advanced Shield Base
        sr = new ShapedRecipe(NamespacedKey.minecraft("advanced_shield_s"), Items.ADVANCED_SHIELD_BASE.getItem(plugin));
        sr.shape("INI",
                 "HSH",
                 "NIN");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SIMPLE_SHIELD_BASE.getItem(plugin)));
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HIDE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for luminous quartz
        sr = new ShapedRecipe(NamespacedKey.minecraft("luminous_quartz_s"), Items.LUMINOUS_QUARTZ.getItem(plugin));
        sr.shape("GQQ",
                 "QQG",
                 "QGG");
        sr.setIngredient('Q', new RecipeChoice.ExactChoice(Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for mineral cluster
        sr = new ShapedRecipe(NamespacedKey.minecraft("mineral_cluster_s"), Items.MINERAL_CLUSTER.getItem(plugin));
        sr.shape("RLR",
                 "LLL",
                 "RLR");
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for enchanted slimeball
        sr = new ShapedRecipe(NamespacedKey.minecraft("enchanted_slime_s"), Items.ENCHANTED_SLIMEBALL.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', Material.SLIME_BALL);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for enchanted slimeball
        sr = new ShapedRecipe(NamespacedKey.minecraft("senchanted_slime_s"), Items.ENCHANTED_SLIMEBALL.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SLIMEBALL.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for living honey
        sr = new ShapedRecipe(NamespacedKey.minecraft("living_honey_s"), Items.LIVING_HONEY.getItem(plugin));
        sr.shape("HHH",
                 "HSH",
                 "HHH");
        sr.setIngredient('H', Material.HONEY_BOTTLE);
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SLIME_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shapeless recipe for enchanted fermented spider eye
        slr = new ShapelessRecipe(NamespacedKey.minecraft("se_spider_eye_sl"), Items.ENCHANTED_FERMENTED_SPIDER_EYE.getItem(plugin));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_SPIDER_EYE.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_SPIDER_EYE.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_SPIDER_EYE.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_SPIDER_EYE.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_SPIDER_EYE.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_SPIDER_EYE.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_SPIDER_EYE.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_SUGAR.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_BROWN_MUSHROOM.getItem(plugin)));
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for mini ender chest
        sr = new ShapedRecipe(NamespacedKey.minecraft("mini_chest_s"), Items.MINI_ENDERCHEST.getItem(plugin));
        sr.shape("OOO",
                 "OEO",
                 "OOO");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ENCHANTED_OBSIDIAN.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_ENDER_EYE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Prosperous Grove
        sr = new ShapedRecipe(NamespacedKey.minecraft("prosperous_grove_s"), Items.PROSPEROUS_GROVE.getItem(plugin));
        sr.shape("BWW",
                 "CEW",
                 "CEW");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_SUGAR_CANE.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.FOREST_ESSENCE.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BONE_BLOCK.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.BUNDLED_OAK_LOGS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Leaching Brambles
        sr = new ShapedRecipe(NamespacedKey.minecraft("leaching_brambles_s"), Items.LEACHING_BRAMBLES.getItem(plugin));
        sr.shape("FFF",
                 "FEF",
                 "GEG");
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_FERMENTED_SPIDER_EYE.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.FOREST_ESSENCE.getItem(plugin)));
        sr.setIngredient('G', Material.ENCHANTED_GOLDEN_APPLE);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Lashing Vines
        sr = new ShapedRecipe(NamespacedKey.minecraft("lashing_vines_s"), Items.LASHING_VINES.getItem(plugin));
        sr.shape("WBE",
                 "WBB",
                 "CWW");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.BAMBOO_BUNDLE.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.FOREST_ESSENCE.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COCOA.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.BUNDLED_JUNGLE_LOGS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Pungent Herbs
        sr = new ShapedRecipe(NamespacedKey.minecraft("pungent_herbs_s"), Items.PUNGENT_HERBS.getItem(plugin));
        sr.shape("EAE",
                 "ACA",
                 "CBC");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BEETROOT_SOUP.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.FOREST_ESSENCE.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CRIMSON_STEM.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.BUNDLED_ACACIA_LOGS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Copper Helmet 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("copper_helm_s1"), Items.COPPER_HELMET.getItem(plugin));
        sr.shape("CCC",
                 "C C",
                 "   ");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Copper Helmet 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("copper_helm_s2"), Items.COPPER_HELMET.getItem(plugin));
        sr.shape("   ",
                 "CCC",
                 "C C");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Copper Chestplate
        sr = new ShapedRecipe(NamespacedKey.minecraft("copper_chest_s"), Items.COPPER_CHESTPLATE.getItem(plugin));
        sr.shape("C C",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Copper Leggings
        sr = new ShapedRecipe(NamespacedKey.minecraft("copper_legs_s"), Items.COPPER_LEGGINGS.getItem(plugin));
        sr.shape("CCC",
                 "C C",
                 "C C");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Copper Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("copper_boots_s1"), Items.COPPER_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "C C",
                 "C C");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Copper Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("copper_boots_s2"), Items.COPPER_BOOTS.getItem(plugin));
        sr.shape("C C",
                 "C C",
                 "   ");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COPPER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Deepslate Monolith
        sr = new ShapedRecipe(NamespacedKey.minecraft("deepslate_monlith_s"), Items.DEEPSLATE_MONOLITH.getItem(plugin));
        sr.shape("SSS",
                 "BRB",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BONE_BLOCK.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Ceremonial Scimitar
        sr = new ShapedRecipe(NamespacedKey.minecraft("ceremonial_scimitar_s"), Items.CEREMONIAL_SCIMITAR.getItem(plugin));
        sr.shape("GGS",
                 "SWS",
                 "SGG");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ORNAMENTAL_SCIMITAR.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.DEEPSLATE_MONOLITH.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GOLDEN_SKULL.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Cactus Leather
        sr = new ShapedRecipe(NamespacedKey.minecraft("cactus_leather_s"), Items.CACTUS_LEATHER.getItem(plugin));
        sr.shape("CCC",
                 "FCF",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CACTUS.getItem(plugin)));
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_FLINT.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Cactus Helmet 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("cactus_helm_s1"), Items.CACTUS_HELMET.getItem(plugin));
        sr.shape("CLC",
                 "L L",
                 "   ");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CACTUS.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.CACTUS_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Cactus Helmet 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("cactus_helm_s2"), Items.CACTUS_HELMET.getItem(plugin));
        sr.shape("   ",
                 "CLC",
                 "L L");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CACTUS.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.CACTUS_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Cactus Chestplate
        sr = new ShapedRecipe(NamespacedKey.minecraft("cactus_chest_s"), Items.CACTUS_CHESTPLATE.getItem(plugin));
        sr.shape("L L",
                 "LCL",
                 "CLC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CACTUS.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.CACTUS_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Cactus Leggings
        sr = new ShapedRecipe(NamespacedKey.minecraft("cactus_legs_s"), Items.CACTUS_LEGGINGS.getItem(plugin));
        sr.shape("CCC",
                 "L L",
                 "L L");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CACTUS.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.CACTUS_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Cactus Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("cactus_boots_s1"), Items.CACTUS_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "L L",
                 "C C");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CACTUS.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.CACTUS_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Cactus Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("cactus_boots_s2"), Items.CACTUS_BOOTS.getItem(plugin));
        sr.shape("L L",
                 "C C",
                 "   ");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CACTUS.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.CACTUS_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Onyx Helmet 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("onyx_helm_s1"), Items.ONYX_HELMET.getItem(plugin));
        sr.shape("OOO",
                 "O O",
                 "   ");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ONYX.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Onyx Helmet 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("onyx_helm_s2"), Items.ONYX_HELMET.getItem(plugin));
        sr.shape("   ",
                 "OOO",
                 "O O");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ONYX.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Onyx Chestplate
        sr = new ShapedRecipe(NamespacedKey.minecraft("onyx_chest_s"), Items.ONYX_CHESTPLATE.getItem(plugin));
        sr.shape("O O",
                 "OOO",
                 "OOO");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ONYX.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Onyx Leggings
        sr = new ShapedRecipe(NamespacedKey.minecraft("onyx_legs_s"), Items.ONYX_LEGGINGS.getItem(plugin));
        sr.shape("OOO",
                 "O O",
                 "O O");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ONYX.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Onyx Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("onyx_boots_s1"), Items.ONYX_BOOTS.getItem(plugin));
        sr.shape("   ",
                 "O O",
                 "O O");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ONYX.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Onyx Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("onyx_boots_s2"), Items.ONYX_BOOTS.getItem(plugin));
        sr.shape("O O",
                 "O O",
                 "   ");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ONYX.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Saturated Creeper Mask
        sr = new ShapedRecipe(NamespacedKey.minecraft("saturated_creeper_mask_s"), Items.SATURATED_CREEPER_MASK.getItem(plugin));
        sr.shape("S S",
                 "LML",
                 "SHS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_STRING.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HIDE.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.SEVERED_CREEPER_HEAD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Intricate Creeper Mask
        sr = new ShapedRecipe(NamespacedKey.minecraft("intricate_creeper_mask_s"), Items.INTRICATE_CREEPER_MASK.getItem(plugin));
        sr.shape("W W",
                 "LML",
                 "FLF");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WEB.getItem(plugin)));
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_FEATHER.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.CACTUS_LEATHER.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.SATURATED_CREEPER_MASK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Lesser Spirit Bone
        sr = new ShapedRecipe(NamespacedKey.minecraft("lesser_spirit_bone_s1"), Items.LESSER_SPIRIT_BONE.getItem(plugin));
        sr.shape(" BB",
                 "BSB",
                 "BB ");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BONE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.FRAGMENTED_SOUL_REMNANTS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Lesser Spirit Bone 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("lesser_spirit_bone_s2"), Items.LESSER_SPIRIT_BONE.getItem(plugin));
        sr.shape(" B ",
                 "BSB",
                 " B ");
        sr.setIngredient('B', Material.BONE);
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.LESSER_SPIRIT_BONE_SHARD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Greater Spirit Bone
        sr = new ShapedRecipe(NamespacedKey.minecraft("greater_spirit_bone_s1"), Items.GREATER_SPIRIT_BONE.getItem(plugin));
        sr.shape(" BE",
                 "BSB",
                 "EB ");
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.FRAGMENTED_SOUL_REMNANTS.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BONE_BLOCK.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.LESSER_SPIRIT_BONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Greater Spirit Bone 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("greater_spirit_bone_s2"), Items.GREATER_SPIRIT_BONE.getItem(plugin));
        sr.shape("  B",
                 " S ",
                 "B  ");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BONE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.GREATER_SPIRIT_BONE_SHARD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Flimsy Bamboo Spear
        sr = new ShapedRecipe(NamespacedKey.minecraft("flimsy_bamboo_spear_s"), Items.FLIMSY_BAMBOO_SPEAR.getItem(plugin));
        sr.shape("  H",
                 "SB ",
                 "BS ");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BAMBOO.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_STRING.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.SPEARHEAD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bamboo Spear
        sr = new ShapedRecipe(NamespacedKey.minecraft("bamboo_spear_s"), Items.BAMBOO_SPEAR.getItem(plugin));
        sr.shape("  B",
                "WB ",
                "SW ");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.BAMBOO_BUNDLE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.FLIMSY_BAMBOO_SPEAR.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WEB.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Enchanted Magma Cream
        sr = new ShapedRecipe(NamespacedKey.minecraft("e_cream_s"), Items.ENCHANTED_MAGMA_CREAM.getItem(plugin));
        sr.shape("MMM",
                 "MMM",
                 "MMM");
        sr.setIngredient('M', Material.MAGMA_CREAM);
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Enchanted Magma Block
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_cream_s"), Items.ENCHANTED_MAGMA_BLOCK.getItem(plugin));
        sr.shape("MMM",
                 "MMM",
                 "MMM");
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.ENCHANTED_MAGMA_CREAM.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Attachable Lantern
        sr = new ShapedRecipe(NamespacedKey.minecraft("attachable_lantern_s"), Items.ATTACHABLE_LANTERN.getItem(plugin));
        sr.shape("TTT",
                 "ICI",
                 "III");
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.TITANIUM_PLATE.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COAL_BLOCK.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Compacted Coal Lump
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_coal_s"), Items.COMPACTED_COAL_LUMP.getItem(plugin));
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COAL_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Pure Iron Nugget
        sr = new ShapedRecipe(NamespacedKey.minecraft("vse_iron_s"), Items.PURE_IRON_NUGGET.getItem(plugin));
        sr.shape("III",
                 "I I",
                 "III");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Polished Slated Handle
        sr = new ShapedRecipe(NamespacedKey.minecraft("polished_handle_s"), Items.POLISHED_SLATED_HANDLE.getItem(plugin));
        sr.shape("T  ",
                 " S ",
                 "  T");
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Seastone
        sr = new ShapedRecipe(NamespacedKey.minecraft("seastone_s"), Items.SEASTONE.getItem(plugin));
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SEASTONE_SHARD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Polished Seastone 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("polished_seastone_s1"), Items.POLISHED_SEASTONE.getItem(plugin));
        sr.shape("SS ",
                 "SS ",
                 "   ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SEASTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Polished Seastone 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("polished_seastone_s2"), Items.POLISHED_SEASTONE.getItem(plugin));
        sr.shape("   ",
                 "SS ",
                 "SS ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SEASTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Polished Seastone 3
        sr = new ShapedRecipe(NamespacedKey.minecraft("polished_seastone_s3"), Items.POLISHED_SEASTONE.getItem(plugin));
        sr.shape(" SS",
                 " SS",
                 "   ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SEASTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Polished Seastone 4
        sr = new ShapedRecipe(NamespacedKey.minecraft("polished_seastone_s4"), Items.POLISHED_SEASTONE.getItem(plugin));
        sr.shape("   ",
                 " SS",
                 " SS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SEASTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Torrent
        sr = new ShapedRecipe(NamespacedKey.minecraft("torrent_s"), Items.TORRENT.getItem(plugin));
        sr.shape("SPS",
                 " H ",
                 " H ");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.POLISHED_SLATED_HANDLE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SEASTONE.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.POLISHED_SEASTONE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shaped recipe for Torrent
        sr = new ShapedRecipe(NamespacedKey.minecraft("stonk_s"), Items.STONK.getItem(plugin));
        sr.shape("GGG",
                 " H ",
                 " H ");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.POLISHED_SLATED_HANDLE.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless recipe for Wood Pile
        slr = new ShapelessRecipe(NamespacedKey.minecraft("wood_pile_sl"), Items.WOOD_PILE.getItem(plugin));

        slr.addIngredient(new RecipeChoice.ExactChoice(Items.BUNDLED_OAK_LOGS.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.BUNDLED_DARK_OAK_LOGS.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.BUNDLED_BIRCH_LOGS.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.BUNDLED_ACACIA_LOGS.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.BUNDLED_SPRUCE_LOGS.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.BUNDLED_JUNGLE_LOGS.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.BUNDLED_WARPED_STEMS.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.BUNDLED_CRIMSON_STEMS.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.BAMBOO_BUNDLE.getItem(plugin)));
        Bukkit.getServer().addRecipe(slr);

        // Shaped recipe for Quarterstaff
        sr = new ShapedRecipe(NamespacedKey.minecraft("quaterstaff_s"), Items.QUARTERSTAFF.getItem(plugin));
        sr.shape("H  ",
                 " H ",
                 "  H");
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HARDWOOD_HANDLE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shaped recipe for Scruffy Lasso
        sr = new ShapedRecipe(NamespacedKey.minecraft("scruffy_lasso_s"), Items.SCRUFFY_LASSO.getItem(plugin));
        sr.shape(" BB",
                 " SB",
                 "W  ");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.SCRUB.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SLIMEBALL.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WEB.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Snaggletooth Lasso
        sr = new ShapedRecipe(NamespacedKey.minecraft("snaggletooth_lasso_s"), Items.SNAGGLETOOTH_LASSO.getItem(plugin));
        sr.shape(" TC",
                 " LT",
                 "W  ");
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.WOLF_FANG.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.RAZOR_CLAW.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.SCRUFFY_LASSO.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WEB.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Amethyst Spear
        sr = new ShapedRecipe(NamespacedKey.minecraft("amethyst_spear_s"), Items.AMETHYST_SPEAR.getItem(plugin));
        sr.shape(" AH",
                 "APA",
                 "SA ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.POLISHED_SLATED_HANDLE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SLIME_BLOCK.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.SPEARHEAD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Brittle Bone Spear
        sr = new ShapedRecipe(NamespacedKey.minecraft("brittle_bone_spear_s"), Items.BRITTLE_BONE_SPEAR.getItem(plugin));
        sr.shape(" HS",
                 " BH",
                 "B  ");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BONE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SPEARHEAD.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HIDE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bone Spear
        sr = new ShapedRecipe(NamespacedKey.minecraft("bone_spear_s"), Items.BRITTLE_BONE_SPEAR.getItem(plugin));
        sr.shape(" CB",
                 "BBC",
                 "SB ");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BONE_BLOCK.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.BRITTLE_BONE_SPEAR.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.CACTUS_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Forester's Axe
        sr = new ShapedRecipe(NamespacedKey.minecraft("forester_axe_s"), Items.FORESTERS_AXE.getItem(plugin));
        sr.shape(" W ",
                 "GSM",
                 "Lwl");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.WOODCUTTERS_AXE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_BEETROOT_SOUP.getItem(plugin)));
        sr.setIngredient('w', new RecipeChoice.ExactChoice(Items.WOOD_PILE.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.LUMBERJACKS_AXE.getItem(plugin)));
        sr.setIngredient('l', new RecipeChoice.ExactChoice(Items.LOGGERS_AXE.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.CHUNK_OF_MEAT.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GOLD_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bundled Oak Logs
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_oak_s"), Items.BUNDLED_OAK_LOGS.getItem(plugin));
        sr.shape("WWW",
                 "WWW",
                 "WWW");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_OAK_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bundled Dark Oak Logs
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_dark_oak_s"), Items.BUNDLED_DARK_OAK_LOGS.getItem(plugin));
        sr.shape("WWW",
                 "WWW",
                 "WWW");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_DARK_OAK_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bundled Oak Logs
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_birch_s"), Items.BUNDLED_BIRCH_LOGS.getItem(plugin));
        sr.shape("WWW",
                 "WWW",
                 "WWW");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_BIRCH_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bundled Oak Logs
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_acacia_s"), Items.BUNDLED_ACACIA_LOGS.getItem(plugin));
        sr.shape("WWW",
                 "WWW",
                 "WWW");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_ACACIA_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bundled Oak Logs
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_spruce_s"), Items.BUNDLED_SPRUCE_LOGS.getItem(plugin));
        sr.shape("WWW",
                 "WWW",
                 "WWW");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_SPRUCE_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bundled Oak Logs
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_jungle_s"), Items.BUNDLED_JUNGLE_LOGS.getItem(plugin));
        sr.shape("WWW",
                 "WWW",
                 "WWW");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_JUNGLE_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bundled Oak Logs
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_crimson_s"), Items.BUNDLED_CRIMSON_STEMS.getItem(plugin));
        sr.shape("WWW",
                 "WWW",
                 "WWW");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_CRIMSON_STEM.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bundled Oak Logs
        sr = new ShapedRecipe(NamespacedKey.minecraft("se_warped_s"), Items.BUNDLED_WARPED_STEMS.getItem(plugin));
        sr.shape("WWW",
                 "WWW",
                 "WWW");
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WARPED_STEM.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Bundled Oak Logs
        sr = new ShapedRecipe(NamespacedKey.minecraft("woodcutter_axe_s"), Items.WOODCUTTERS_AXE.getItem(plugin));
        sr.shape("LI ",
                 "IH ",
                 " H ");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.PURE_IRON_NUGGET.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HARDWOOD_HANDLE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Dull Pickaxe
        sr = new ShapedRecipe(NamespacedKey.minecraft("dull_pick_s"), Items.DULL_PICKAXE.getItem(plugin));
        sr.shape("DDD",
                 " S ",
                 " S ");
        sr.setIngredient('S', Material.STICK);
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DEEPSLATE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Notched Pick
        sr = new ShapedRecipe(NamespacedKey.minecraft("notched_pick_s"), Items.NOTCHED_PICK.getItem(plugin));
        sr.shape("AIA",
                 " H ",
                 " H ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ALLOY.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HARDWOOD_HANDLE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Imbalanced Pickaxe
        sr = new ShapedRecipe(NamespacedKey.minecraft("imbalanced_pick_s"), Items.IMBALANCED_PICKAXE.getItem(plugin));
        sr.shape("CII",
                 "IH ",
                 " H ");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CUT_COPPER.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HARDWOOD_HANDLE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Dark Iron Helmet 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("dark_iron_helm_s1"), Items.DARK_IRON_HELMET.getItem(plugin));
        sr.shape("NIN",
                 "BHB",
                 "   ");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.PURE_IRON_NUGGET.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.DARK_IRON_CORE.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.ALLOY_HELMET.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Dark Iron Helmet 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("dark_iron_helm_s2"), Items.DARK_IRON_HELMET.getItem(plugin));
        sr.shape("   ",
                 "NIN",
                 "BHB");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.PURE_IRON_NUGGET.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.DARK_IRON_CORE.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.ALLOY_HELMET.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Dark Iron Chestplate
        sr = new ShapedRecipe(NamespacedKey.minecraft("dark_iron_chest_s"), Items.DARK_IRON_CHESTPLATE.getItem(plugin));
        sr.shape("B B",
                 "NIN",
                 "NCN");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.PURE_IRON_NUGGET.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.DARK_IRON_CORE.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ALLOY_CHESTPLATE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Dark Iron Leggings
        sr = new ShapedRecipe(NamespacedKey.minecraft("dark_iron_legs_s"), Items.DARK_IRON_LEGGINGS.getItem(plugin));
        sr.shape("NNN",
                 "L I",
                 "B B");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.PURE_IRON_NUGGET.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.DARK_IRON_CORE.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ALLOY_LEGGINGS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Dark Iron Boots 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("dark_iron_boots_s1"), Items.DARK_IRON_BOOTS.getItem(plugin));
        sr.shape(" I ",
                 "NbB",
                 "   ");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.PURE_IRON_NUGGET.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.DARK_IRON_CORE.getItem(plugin)));
        sr.setIngredient('b', new RecipeChoice.ExactChoice(Items.ALLOY_BOOTS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Dark Iron Boots 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("dark_iron_boots_s2"), Items.DARK_IRON_BOOTS.getItem(plugin));
        sr.shape("   ",
                 " I ",
                 "NbB");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(Items.PURE_IRON_NUGGET.getItem(plugin)));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.DARK_IRON_CORE.getItem(plugin)));
        sr.setIngredient('b', new RecipeChoice.ExactChoice(Items.ALLOY_BOOTS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Tough Cord
        sr = new ShapedRecipe(NamespacedKey.minecraft("tough_cord_s"), Items.TOUGH_CORD.getItem(plugin));
        sr.shape(" FF",
                 "FWF",
                 "FF ");
        sr.setIngredient('F', new RecipeChoice.ExactChoice(Items.ENCHANTED_FLINT.getItem(plugin)));
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_WEB.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Seastone Handle
        sr = new ShapedRecipe(NamespacedKey.minecraft("seastone_handle_s"), Items.SEASTONE_HANDLE.getItem(plugin));
        sr.shape(" SP",
                 "SHS",
                 "PS ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SEASTONE.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.POLISHED_SEASTONE.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.POLISHED_SLATED_HANDLE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Magmite Handle
        sr = new ShapedRecipe(NamespacedKey.minecraft("magmite_handle_s"), Items.MAGMITE_HANDLE.getItem(plugin));
        sr.shape(" OM",
                 "OHO",
                 "MO ");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ENCHANTED_OBSIDIAN.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.ENCHANTED_MAGMA_BLOCK.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.POLISHED_SLATED_HANDLE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Necronomicon Page 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("necronomicon_page_s1"), Items.NECRONOMICON_PAGE.getItem(plugin));
        sr.shape("   ",
                 " PP",
                 " PE");
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PAPER.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Necronomicon Page 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("necronomicon_page_s2"), Items.NECRONOMICON_PAGE.getItem(plugin));
        sr.shape("   ",
                 "PP ",
                 "PE ");
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PAPER.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Necronomicon Page 3
        sr = new ShapedRecipe(NamespacedKey.minecraft("necronomicon_page_s3"), Items.NECRONOMICON_PAGE.getItem(plugin));
        sr.shape(" PP",
                 " PE",
                 "   ");
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PAPER.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Necronomicon Page 4
        sr = new ShapedRecipe(NamespacedKey.minecraft("necronomicon_page_s4"), Items.NECRONOMICON_PAGE.getItem(plugin));
        sr.shape("PP ",
                 "PE ",
                 "   ");
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_PAPER.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.DISTILLED_SOUL_ESSENCE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Gemstone Trident
        sr = new ShapedRecipe(NamespacedKey.minecraft("gemstone_trident_s"), Items.GEMSTONE_TRIDENT.getItem(plugin));
        sr.shape("G G",
                 "GHG",
                 " H ");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.SEASTONE_HANDLE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Amalgamated Tissue 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("amalgamated_tissue_s1"), Items.AMALGAMATED_TISSUE.getItem(plugin));
        sr.shape("   ",
                 " SM",
                 " TE");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SLIME_BLOCK.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.CHUNK_OF_MEAT.getItem(plugin)));
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.PULSING_TUMOR.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_FERMENTED_SPIDER_EYE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Amalgamated Tissue 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("amalgamated_tissue_s2"), Items.AMALGAMATED_TISSUE.getItem(plugin));
        sr.shape("   ",
                 "SM ",
                 "TE ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SLIME_BLOCK.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.CHUNK_OF_MEAT.getItem(plugin)));
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.PULSING_TUMOR.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_FERMENTED_SPIDER_EYE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Amalgamated Tissue 3
        sr = new ShapedRecipe(NamespacedKey.minecraft("amalgamated_tissue_s3"), Items.AMALGAMATED_TISSUE.getItem(plugin));
        sr.shape(" SM",
                 " TE",
                 "   ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SLIME_BLOCK.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.CHUNK_OF_MEAT.getItem(plugin)));
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.PULSING_TUMOR.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_FERMENTED_SPIDER_EYE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Amalgamated Tissue 4
        sr = new ShapedRecipe(NamespacedKey.minecraft("amalgamated_tissue_s4"), Items.AMALGAMATED_TISSUE.getItem(plugin));
        sr.shape("SM ",
                 "TE ",
                 "   ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SLIME_BLOCK.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.CHUNK_OF_MEAT.getItem(plugin)));
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.PULSING_TUMOR.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_FERMENTED_SPIDER_EYE.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Amalgamated Tissue 1
        sr = new ShapedRecipe(NamespacedKey.minecraft("sugar_cube_s1"), Items.SUGAR_CUBE.getItem(plugin));
        sr.shape("   ",
                 " SS",
                 " SS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SUGAR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Sugar Cube 2
        sr = new ShapedRecipe(NamespacedKey.minecraft("sugar_cube_s2"), Items.SUGAR_CUBE.getItem(plugin));
        sr.shape("   ",
                 "SS ",
                 "SS ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SUGAR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Sugar Cube 3
        sr = new ShapedRecipe(NamespacedKey.minecraft("sugar_cube_s3"), Items.SUGAR_CUBE.getItem(plugin));
        sr.shape(" SS",
                 " SS",
                 "   ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SUGAR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Sugar Cube 4
        sr = new ShapedRecipe(NamespacedKey.minecraft("sugar_cube_s4"), Items.SUGAR_CUBE.getItem(plugin));
        sr.shape("SS ",
                 "SS ",
                 "   ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_SUGAR.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        // Shapeless recipe for Shortbow Cord
        item = Items.SHORTBOW_CORD.getItem(plugin);
        item.setAmount(2);
        slr = new ShapelessRecipe(NamespacedKey.minecraft("shortbow_coord_sl"), item);

        slr.addIngredient(new RecipeChoice.ExactChoice(Items.SHORTBOW_CORD.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.TOUGH_CORD.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.TOUGH_CORD.getItem(plugin)));
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Superstone Powder
        sr = new ShapedRecipe(NamespacedKey.minecraft("superstone_powder_s"), Items.SUPERSTONE_POWDER.getItem(plugin));
        sr.shape("CDC",
                 "DPD",
                 "CDC");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_COBBLESTONE.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.ENCHANTED_POWDER_BALL.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Staff of Explosions
        sr = new ShapedRecipe(NamespacedKey.minecraft("explosion_staff_s"), Items.STAFF_OF_EXPLOSIVES.getItem(plugin));
        sr.shape(" PC",
                 " TP",
                 "T  ");
        sr.setIngredient('T', new RecipeChoice.ExactChoice(Items.TNT_WAND.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.COMPACTED_COAL_LUMP.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.SUPERSTONE_POWDER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Drawstring Bag
        sr = new ShapedRecipe(NamespacedKey.minecraft("sack_shortcut_s"), Items.DRAWSTRING_BAG.getItem(plugin));
        sr.shape("RSR",
                 "RLR",
                 "RRR");
        sr.setIngredient('R', new RecipeChoice.ExactChoice(new ItemStack(Material.RABBIT_HIDE)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_STRING.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Tiny Rock Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("rock_sack_tiny_s"), Items.TINY_ROCK_SACK.getItem(plugin));
        sr.shape("SSd",
                 "SLD",
                 "dDD");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin)));
        sr.setIngredient('d', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIPSTONE.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Small Rock Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("rock_sack_small_s"), Items.SMALL_ROCK_SACK.getItem(plugin));
        sr.shape("DLD",
                 "DSD",
                 "DLD");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.TINY_ROCK_SACK.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Medium Rock Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("rock_sack_medium_s"), Items.MEDIUM_ROCK_SACK.getItem(plugin));
        sr.shape("MHD",
                 "HSD",
                 "DDD");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SMALL_ROCK_SACK.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HIDE.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.DEEPSLATE_MONOLITH.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Large Rock Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("rock_sack_large_s"), Items.LARGE_ROCK_SACK.getItem(plugin));
        sr.shape("MHM",
                 "DSH",
                 "HDM");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.MEDIUM_ROCK_SACK.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HIDE.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.DEEPSLATE_MONOLITH.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Gigantic Rock Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("rock_sack_huge_s"), Items.GIGANTIC_ROCK_SACK.getItem(plugin));
        sr.shape("HHH",
                 "MSM",
                 "MPM");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.LARGE_ROCK_SACK.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.SUPERSTONE_POWDER.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HIDE.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.DEEPSLATE_MONOLITH.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Gigantic Rock Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("rock_sack_humongous_s"), Items.HUMONGOUS_ROCK_SACK.getItem(plugin));
        sr.shape("MPP",
                 "MPP",
                 "SMM");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.GIGANTIC_ROCK_SACK.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.SUPERSTONE_POWDER.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.DEEPSLATE_MONOLITH.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shapeless recipe for Rock Sack Extension
        slr = new ShapelessRecipe(NamespacedKey.minecraft("rock_sack_extension_sl"), Items.ROCK_SACK_EXTENSION.getItem(plugin));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.SUPERSTONE_POWDER.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.SUPERSTONE_POWDER.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.DEEPSLATE_MONOLITH.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_OBSIDIAN.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_OBSIDIAN.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_OBSIDIAN.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_OBSIDIAN.getItem(plugin)));
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Tiny Mineral Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("mineral_sack_tiny_s"), Items.TINY_MINERAL_SACK.getItem(plugin));
        sr.shape("EAR",
                 "ALA",
                 "AAA");
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_EMERALD.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Small Mineral Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("mineral_sack_small_s"), Items.SMALL_MINERAL_SACK.getItem(plugin));
        sr.shape("DEG",
                 "RAR",
                 "LSL");
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_EMERALD.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.TINY_ROCK_SACK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Medium Mineral Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("mineral_sack_medium_s"), Items.MEDIUM_MINERAL_SACK.getItem(plugin));
        sr.shape("CaA",
                 "GSa",
                 "HGC");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.SMALL_MINERAL_SACK.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        sr.setIngredient('a', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HIDE.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.MINERAL_CLUSTER.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Large Mineral Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("mineral_sack_large_s"), Items.LARGE_MINERAL_SACK.getItem(plugin));
        sr.shape("DDH",
                 "ASD",
                 "HAA");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.MEDIUM_MINERAL_SACK.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        sr.setIngredient('H', new RecipeChoice.ExactChoice(Items.HIDE.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Gigantic Mineral Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("mineral_sack_huge_s"), Items.GIGANTIC_MINERAL_SACK.getItem(plugin));
        sr.shape("EAD",
                 "ESD",
                 "EAD");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.LARGE_MINERAL_SACK.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(Items.ENCHANTED_DIAMOND.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.ENCHANTED_EMERALD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Humongous Mineral Sack
        sr = new ShapedRecipe(NamespacedKey.minecraft("mineral_sack_humongous_s"), Items.HUMONGOUS_MINERAL_SACK.getItem(plugin));
        sr.shape("GAC",
                 "ASA",
                 "LAM");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.GIGANTIC_MINERAL_SACK.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.COMPACTED_COAL_LUMP.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.GEMSTONE.getItem(plugin)));
        sr.setIngredient('M', new RecipeChoice.ExactChoice(Items.MINERAL_CLUSTER.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.LUMINOUS_QUARTZ.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shapeless recipe for Mineral Sack Extension
        slr = new ShapelessRecipe(NamespacedKey.minecraft("mineral_sack_extension_sl"), Items.MINERAL_SACK_EXTENSION.getItem(plugin));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_AMETHYST.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.ENCHANTED_GLOWSTONE.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.COMPACTED_COAL_LUMP.getItem(plugin)));
        slr.addIngredient(new RecipeChoice.ExactChoice(Items.COMPACTED_COAL_LUMP.getItem(plugin)));
        Bukkit.getServer().addRecipe(slr);

        //Shapeless recipe for Enchanted Shulker Shell
        slr = new ShapelessRecipe(NamespacedKey.minecraft("e_shulker_shell_sl"), Items.ENCHANTED_SHULKER_SHELL.getItem(plugin));
        slr.addIngredient(9, Material.COAL);
        Bukkit.getServer().addRecipe(slr);

        //Shaped recipe for Sticky Bomb Launcher
        sr = new ShapedRecipe(NamespacedKey.minecraft("sticky_bomb_launcher_s"), Items.STICKY_BOMB_LAUNCHER.getItem(plugin));
        sr.shape(" IS",
                 "PsI",
                 "GP ");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(Items.STICKY_BALL.getItem(plugin)));
        sr.setIngredient('s', new RecipeChoice.ExactChoice(Items.ENCHANTED_SLIME_BLOCK.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_IRON_BLOCK.getItem(plugin)));
        sr.setIngredient('P', new RecipeChoice.ExactChoice(Items.PURE_IRON_NUGGET.getItem(plugin)));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(Items.ENCHANTED_POWDER_BALL.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);
    }

    public void updateItem(Plugin plugin, ItemStack item) {
        ItemMeta meta = item.getItemMeta();

        ChatColor color = ChatColor.GRAY;
        switch (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING)) {
            case "COMMON":
                color = ChatColor.WHITE;
                break;
            case "UNCOMMON":
                color = ChatColor.GREEN;
                break;
            case "RARE":
                color = ChatColor.BLUE;
                break;
            case "EPIC":
                color = ChatColor.DARK_PURPLE;
                break;
            case "LEGENDARY":
                color = ChatColor.GOLD;
                break;
            case "MYTHIC":
                color = ChatColor.LIGHT_PURPLE;
                break;
            case "SPECIAL":
                color = ChatColor.RED;
                break;
            case "UNIQUE":
                color = ChatColor.DARK_AQUA;
                break;
        }

        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null) {
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeFarmingFortune"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeExcavatingFortune"), PersistentDataType.DOUBLE, 0.0);

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDamage"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMagic"), PersistentDataType.DOUBLE, 0.0);

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealMod"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDamageModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrengthModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCCModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCritModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealthModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefenseModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeedModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocationModifier"), PersistentDataType.DOUBLE, 0.0);

            switch (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING)) {
                case "Test Stone":
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDamage"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 1.0);
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMagic"), PersistentDataType.DOUBLE, 1.0);
                    break;
                case "Prismatic":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 25.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 40.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 10.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 75.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 16.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 120.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 25.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 160.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 40.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 210.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 65.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 10.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 3.0);
                            break;
                    }
                    break;
                case "Sharp":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 7.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 1.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 12.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 2.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 16.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 3.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 21.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 33.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 8.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 45.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 14.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 3.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 1.0);
                            break;
                    }
                    break;
                case "Meaty":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 13.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 23.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 35.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 57.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 4.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 87.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 7.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 135.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 13.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 5.0);
                            break;
                    }
                    break;
                case "Antique":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 12.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 18.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 8.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 35.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 13.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 44.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 18.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 60.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 25.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 74.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 4.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 1.0);
                            break;
                    }
                    break;
                case "Repeating":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 4.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 6.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 7.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 11.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 10.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 17.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 16.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 25.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 21.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 34.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 27.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 46.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 2.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 5.0);
                            break;
                    }
                    break;
                case "Gooey":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 14.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 4.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, -3.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 21.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 6.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, -5.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 30.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 10.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, -8.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 48.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 16.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, -13.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 61.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 22.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, -17.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 85.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 31.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, -22.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 7.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 2.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, -1.0);
                            break;
                    }
                    break;
                case "Rusty":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 6.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 3.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 3.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 9.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 5.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 14.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 8.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 8.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 21.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 12.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 12.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 30.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 15.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 15.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 39.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 21.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 21.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 2.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 1.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 1.0);
                            break;
                    }
                    if (item.getType() == Material.IRON_HELMET || item.getType() == Material.IRON_CHESTPLATE ||
                        item.getType() == Material.IRON_LEGGINGS || item.getType() == Material.IRON_BOOTS ||
                        item.getType() == Material.CHAINMAIL_HELMET || item.getType() == Material.CHAINMAIL_CHESTPLATE ||
                        item.getType() == Material.CHAINMAIL_LEGGINGS || item.getType() == Material.CHAINMAIL_BOOTS) {
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDefense"), PersistentDataType.DOUBLE) * 2);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeStrength"), PersistentDataType.DOUBLE) * 2);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCrit"), PersistentDataType.DOUBLE) * 2);
                    }
                    break;
                case "Venomous":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 7.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 1.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 4.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 11.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 3.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 6.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 15.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 5.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 9.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 21.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 8.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 14.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 37.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 8.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 14.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 53.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 16.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 26.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 4.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 2.0);
                            break;
                    }
                    break;
                case "Illuminating":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE, 3.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE, 5.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 8.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE, 8.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 11.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE, 12.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 17.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE, 17.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 25.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE, 21.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 34.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE, 1.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 2.0);
                            break;
                    }
                    break;
                case "Stimulating":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 5.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 2.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 16.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 8.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 3.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 26.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 14.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 5.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 38.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 20.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 8.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 38.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 37.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 11.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 80.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 49.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 17.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 128.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, 3.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 10.0);
                            break;
                    }
                    break;
                case "Camouflaged":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 12.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 2.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 18.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 3.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 26.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 41.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 8.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 58.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 12.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 74.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 15.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 6.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 1.0);
                            break;
                    }
                    break;
                case "Tenacious":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 7.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 2.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 1.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 10.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 3.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 2.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 16.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 5.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 3.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 22.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 8.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 37.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 11.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 8.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 58.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 17.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 11.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 4.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 1.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 1.0);
                            break;
                    }
                    break;
                case "Sawed-Off":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 11.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, -3.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 2.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 16.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, -5.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 3.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 22.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, -8.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 35.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, -11.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 8.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 47.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, -16.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 13.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 71.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, -27.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 18.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 6.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, -1.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 1.0);
                            break;
                        }
                    break;
                case "Gigantic":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 20.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 3.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 31.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 5.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 47.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 9.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 64.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 14.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 107.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 21.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 172.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 33.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 7.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 2.0);
                            break;
                    }
                    break;
                case "Leaching":
                    switch (color) {
                        case WHITE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 12.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 4.0);
                            break;
                        case GREEN:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 18.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 6.0);
                            break;
                        case BLUE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 25.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 10.0);
                            break;
                        case DARK_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 37.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 14.0);
                            break;
                        case GOLD:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 51.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 20.0);
                            break;
                        case LIGHT_PURPLE:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 73.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 27.0);
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 6.0);
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 2.0);
                            break;
                    }
                    break;
                default:
                    break;
                }
            }


        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentName"), new stringList()).length > 0) {
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantMiningFortune"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantFarmingFortune"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantExcavatingFortune"), PersistentDataType.DOUBLE, 0.0);

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantDamage"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantStrength"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantCC"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantAttackSpeed"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantCrit"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantHealth"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantDefense"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantSpeed"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantIntelligence"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantThaumaturgy"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantInvocation"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantMagic"), PersistentDataType.DOUBLE, 0.0);

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantHealMod"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantDamageModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantStrengthModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantCCModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantCritModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantHealthModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantDefenseModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantIntelligenceModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantSpeedModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"), PersistentDataType.DOUBLE, 0.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantInvocationModifier"), PersistentDataType.DOUBLE, 0.0);
            int[] level = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentPower"), PersistentDataType.INTEGER_ARRAY);
            for (int i = 0; i < meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentName"), new stringList()).length; i++) {
                switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentName"), new stringList())[i]) {
                    case "Sharpness":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantDamageModifier"), PersistentDataType.DOUBLE, (level[i] * 0.08)
                                + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantDamageModifier"), PersistentDataType.DOUBLE));
                        break;
                    case "Proliferation":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantHealMod"), PersistentDataType.DOUBLE, (level[i] * 0.02)
                                + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantHealMod"), PersistentDataType.DOUBLE));
                        break;
                    case "Luck":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantMagic"), PersistentDataType.DOUBLE, (level[i] * 9.0)
                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantMagic"), PersistentDataType.DOUBLE));
                        break;
                    case "Lacerate":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantStrength"), PersistentDataType.DOUBLE, (level[i] * 2.0)
                                + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantStrength"), PersistentDataType.DOUBLE));
                        break;
                    case "Light":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantSpeed"), PersistentDataType.DOUBLE, (level[i] * 2.0)
                                + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantSpeed"), PersistentDataType.DOUBLE));
                        break;
                    case "Leaping":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantSpeed"), PersistentDataType.DOUBLE, (level[i] * 1.0)
                                + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantSpeed"), PersistentDataType.DOUBLE));
                        break;
                    case "Protection":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantDefense"), PersistentDataType.DOUBLE, (level[i] * 3.0)
                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantDefense"), PersistentDataType.DOUBLE));
                        break;
                    case "Growth":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantHealth"), PersistentDataType.DOUBLE, (level[i] * 15.0)
                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantHealth"), PersistentDataType.DOUBLE));
                        break;
                    case "Intellect":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantIntelligence"), PersistentDataType.DOUBLE, (level[i] * 12.0)
                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantIntelligence"), PersistentDataType.DOUBLE));
                        break;
                    case "Conjure":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantInvocation"), PersistentDataType.DOUBLE, (level[i] * 3.0)
                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantInvocation"), PersistentDataType.DOUBLE));
                        break;
                    case "Cognition":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantThaumaturgy"), PersistentDataType.DOUBLE, (level[i] * 3.0)
                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantThaumaturgy"), PersistentDataType.DOUBLE));
                        break;
                    case "Mysticism":
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantIntelligence"), PersistentDataType.DOUBLE, (level[i] * 4.0)
                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantIntelligence"), PersistentDataType.DOUBLE));
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantInvocatio"), PersistentDataType.DOUBLE, (level[i] * 1.0)
                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantInvocatio"), PersistentDataType.DOUBLE));
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantThaumaturgy"), PersistentDataType.DOUBLE, (level[i] * 1.0)
                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantThaumaturgy"), PersistentDataType.DOUBLE));
                        break;
                    case "Fortune":
                            switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING)) {
                                case "Pickaxe":
                                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantMiningFortune"), PersistentDataType.DOUBLE, (level[i] * 15.0)
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantMiningFortune"), PersistentDataType.DOUBLE));
                                    break;
                                case "Hoe":
                                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantFarmingFortune"), PersistentDataType.DOUBLE, (level[i] * 15.0)
                                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantFarmingFortune"), PersistentDataType.DOUBLE));
                                    break;
                                case "Shovel":
                                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantExcavatingFortune"), PersistentDataType.DOUBLE, (level[i] * 15.0)
                                            + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantExcavatingFortune"), PersistentDataType.DOUBLE));
                                    break;
                            }
                            break;
                    case "Adaptive":
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamage"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamage"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantDamage"), PersistentDataType.DOUBLE,
                                ((level[i] * 0.06) *
                                  meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamage"), PersistentDataType.DOUBLE))
                                + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantShovelFortune"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantStrength"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantStrength"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantCC"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantCC"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE) != null &&
                                meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantAttackSpeed"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantAttackSpeed"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantCrit"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantCrit"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantHealth"), PersistentDataType.DOUBLE,
                            ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE)) +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantHealth"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantDefense"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantDefense"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantSpeed"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantSpeed"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantIntelligence"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantIntelligence"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantThaumaturgy"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantThaumaturgy"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantInvocation"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeTInvocation"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantInvocation"), PersistentDataType.DOUBLE));
                        }
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"), PersistentDataType.DOUBLE) != null &&
                            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"), PersistentDataType.DOUBLE) != 0) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "EnchantMagic"), PersistentDataType.DOUBLE,
                                    ((level[i] * 0.06) *
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"), PersistentDataType.DOUBLE))
                                    + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantMagic"), PersistentDataType.DOUBLE));
                        }
                        break;
                }
            }
        }

        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING) != null &&
            meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING).equals("pet")) {
            int level = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER);
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseHealth"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE,
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseHealth"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseDefense"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseDefense"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseSpeed"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseSpeed"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseStrength"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseStrength"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseCrit"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseCrit"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseCC"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseCC"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseAttackSpeed"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseAttackSpeed"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseIntelligence"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseIntelligence"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseThaumaturgy"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseThaumaturgy"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseInvocation"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseInvocation"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseMagic"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Magic"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseMagic"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseMiningFortune"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseMiningFortune"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseFarmingFortune"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"FarmingFortune"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseFarmingFortune"), PersistentDataType.DOUBLE) * level);
            }
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseExcavatingFortune"), PersistentDataType.DOUBLE) != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE,
                        meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"baseExcavatingFortune"), PersistentDataType.DOUBLE) * level);
            }
        }

        String name = "";
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null) {
            name = name + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " ";
        }

        name = name + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"effect"), PersistentDataType.STRING) != null) {
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"additive"), PersistentDataType.STRING).equals("")) {
                name = name + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"effect"), PersistentDataType.STRING);
            } else {
                name = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"additive"), PersistentDataType.STRING) + " " +
                        name + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"effect"), PersistentDataType.STRING);
            }
        }

        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING) != null &&
            meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "type"), PersistentDataType.STRING).equals("pet")) {
            name = ChatColor.GRAY + "[Lvl " + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) + "] " + color + name;
        }
        meta.setDisplayName(color + name);

        boolean stats = false;
        List<String> lore = new ArrayList<>();

        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING) != null &&
                meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "type"), PersistentDataType.STRING).equals("pet")) {
            lore.add(ChatColor.DARK_GRAY + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "petType"), PersistentDataType.STRING) + " Pet");
            lore.add(" ");
        }

        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"id"), PersistentDataType.STRING)) {
            case "Potion of ":
                String duration = "";
                boolean cont = false;
                int cutTime = (int) (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"duration"), PersistentDataType.LONG) / 1000);
                if (cutTime / 3600 > 1) {
                    duration = duration + (cutTime/3600) + ":";
                    cutTime -= (cutTime/3600) * 3600;
                    cont = true;
                }
                if (cutTime / 60 > 1) {
                    duration = duration + (cutTime/60) + ":";
                    cutTime -= (cutTime/60) * 60;
                    cont = true;
                } else {
                    if (cont) {
                        duration = duration + "00:";
                    }
                }
                if (cutTime > 1) {
                    duration = duration + cutTime + ":";
                } else {
                    if (cont) {
                        duration = duration + "00";
                    }
                }
                lore.add(ChatColor.BLUE + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"effect"), PersistentDataType.STRING) + " "
                        + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"power"), PersistentDataType.INTEGER) + " "
                        + duration);
                lore.add(" ");
                break;
            case "Warp Scroll":
                lore.add(ChatColor.DARK_GRAY + "Travel to " + Math.round(meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"locationX"), PersistentDataType.DOUBLE)) + " " + Math.round(meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"locationY"), PersistentDataType.DOUBLE)) + " " + Math.round(meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"locationZ"), PersistentDataType.DOUBLE)) + " in the " + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"world"), PersistentDataType.STRING));
                lore.add(" ");
                break;
            case "NFT":
                lore.add(ChatColor.DARK_GRAY + "Name: " + ChatColor.AQUA + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"name"), PersistentDataType.STRING));
                lore.add(ChatColor.DARK_GRAY + "id: " + ChatColor.GREEN + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"uuid"), PersistentDataType.STRING));
                lore.add(" ");
                break;
        }

        double damage = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE) != null) {
            damage = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantDamage"), PersistentDataType.DOUBLE) != null) {
            damage += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantDamage"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDamage"), PersistentDataType.DOUBLE) != null) {
            damage += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDamage"), PersistentDataType.DOUBLE);
        }

        if (damage != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDamage"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDamage"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", damage

            );
            lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + str + string);
            stats = true;
        }

        double strength = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE) != null) {
            strength = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantStrength"), PersistentDataType.DOUBLE) != null) {
            strength += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantStrength"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeStrength"), PersistentDataType.DOUBLE) != null) {
            strength += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeStrength"), PersistentDataType.DOUBLE);
        }

        if (strength != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeStrength"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeStrength"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", strength

            );

            lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + str + string);
            stats = true;
        }

        double CC = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE) != null) {
            CC = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantCC"), PersistentDataType.DOUBLE) != null) {
            CC += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantCC"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCC"), PersistentDataType.DOUBLE) != null) {
            CC += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCC"), PersistentDataType.DOUBLE);
        }

        if (CC != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCC"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCC"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", CC

            );

            lore.add(ChatColor.GRAY + "Crit Chance:" + ChatColor.RED + str + string);
            stats = true;
        }

        double crit = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE) != null) {
            crit = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantCrit"), PersistentDataType.DOUBLE) != null) {
            crit += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantCrit"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCrit"), PersistentDataType.DOUBLE) != null) {
            crit += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCrit"), PersistentDataType.DOUBLE);
        }

        if (crit != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCrit"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCrit"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", crit

            );

            lore.add(ChatColor.GRAY + "Crit Damage:" + ChatColor.RED + str + string);
            stats = true;
        }

        double attackspeed = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE) != null) {
            attackspeed = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantAttackSpeed"), PersistentDataType.DOUBLE) != null) {
            attackspeed += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantAttackSpeed"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeAttackSpeed"), PersistentDataType.DOUBLE) != null) {
            attackspeed += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeAttackSpeed"), PersistentDataType.DOUBLE);
        }

        if (attackspeed != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeAttackSpeed"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeAttackSpeed"), PersistentDataType.DOUBLE)

                );
            }

            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "cord"),
                    PersistentDataType.INTEGER) != null) {
                string += ChatColor.YELLOW + " [+15]";
            }

            String str = String.format(
                    " %1$+.0f", attackspeed

            );

            lore.add(ChatColor.GRAY + "Attack Speed:" + ChatColor.GREEN + str + string);
            stats = true;
        }

        double health = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE) != null) {
            health = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantHealth"), PersistentDataType.DOUBLE) != null) {
            health += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantHealth"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeHealth"), PersistentDataType.DOUBLE) != null) {
            health += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeHealth"), PersistentDataType.DOUBLE);
        }

        if (health != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeHealth"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeHealth"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", health

            );

            lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + str + string);
            stats = true;
        }

        double defense = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE) != null) {
            defense = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantDefense"), PersistentDataType.DOUBLE) != null) {
            defense += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantDefense"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDefense"), PersistentDataType.DOUBLE) != null) {
            defense += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDefense"), PersistentDataType.DOUBLE);
        }

        if (defense != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDefense"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDefense"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", defense

            );

            lore.add(ChatColor.GRAY + "Defense:" + ChatColor.GREEN + str + string);
            stats = true;
        }

        double speed = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE) != null) {
            speed = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantSpeed"), PersistentDataType.DOUBLE) != null) {
            speed += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantSpeed"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeSpeed"), PersistentDataType.DOUBLE) != null) {
            speed += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeSpeed"), PersistentDataType.DOUBLE);
        }

        if (speed != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeSpeed"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", speed

            );

            lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + str + string);
            stats = true;
        }

        double inteligence = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE) != null) {
            inteligence = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantIntelligence"), PersistentDataType.DOUBLE) != null) {
            inteligence += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantIntelligence"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeIntelligence"), PersistentDataType.DOUBLE) != null) {
            inteligence += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeIntelligence"), PersistentDataType.DOUBLE);
        }

        if (inteligence != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeIntelligence"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", inteligence

            );

            lore.add(ChatColor.GRAY + "Intelligence:" + ChatColor.AQUA + str + string);
            stats = true;
        }

        double thaumaturgy = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE) != null) {
            thaumaturgy = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantThaumaturgy"), PersistentDataType.DOUBLE) != null) {
            thaumaturgy += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantThaumaturgy"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeThaumaturgy"), PersistentDataType.DOUBLE) != null) {
            thaumaturgy += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeThaumaturgy"), PersistentDataType.DOUBLE);
        }

        if (thaumaturgy != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeThaumaturgy"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", thaumaturgy

            );

            lore.add(ChatColor.GRAY + "Thaumaturgy:" + ChatColor.AQUA + str + string);
            stats = true;
        }

        double invocation = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE) != null) {
            invocation = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantInvocation"), PersistentDataType.DOUBLE) != null) {
            invocation += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantInvocation"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeInvocation"), PersistentDataType.DOUBLE) != null) {
            invocation += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeInvocation"), PersistentDataType.DOUBLE);
        }

        if (invocation != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeInvocation"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", invocation

            );

            lore.add(ChatColor.GRAY + "Invocation:" + ChatColor.AQUA + str + string);
            stats = true;
        }

        double magic = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Magic"), PersistentDataType.DOUBLE) != null) {
            magic = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Magic"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantMagic"), PersistentDataType.DOUBLE) != null) {
            magic += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantMagic"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMagic"), PersistentDataType.DOUBLE) != null) {
            magic += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMagic"), PersistentDataType.DOUBLE);
        }

        if (magic != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMagic"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", magic

            );

            lore.add(ChatColor.GRAY + "Magic Find:" + ChatColor.AQUA + str + string);
            stats = true;
        }

        double farm = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"FarmingFortune"), PersistentDataType.DOUBLE) != null) {
            farm = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"FarmingFortune"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantFarmingFortune"), PersistentDataType.DOUBLE) != null) {
            farm += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantFarmingFortune"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeFarmingFortune"), PersistentDataType.DOUBLE) != null) {
            farm += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeFarmingFortune"), PersistentDataType.DOUBLE);
        }

        if (farm != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeFarmingFortune"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", farm

            );

            lore.add(ChatColor.GRAY + "Farming Fortune:" + ChatColor.GOLD + str + string);
            stats = true;
        }

        double mine = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE) != null) {
            mine = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantMiningFortune"), PersistentDataType.DOUBLE) != null) {
            mine += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantMiningFortune"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMiningFortune"), PersistentDataType.DOUBLE) != null) {
            mine += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMiningFortune"), PersistentDataType.DOUBLE);
        }

        if (mine != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMiningFortune"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", mine

            );

            lore.add(ChatColor.GRAY + "Mining Fortune:" + ChatColor.GOLD + str + string);
            stats = true;
        }

        double excavate = 0.0;
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE) != null) {
            excavate = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"EnchantExcavatingFortune"), PersistentDataType.DOUBLE) != null) {
            excavate += meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "EnchantExcavatingFortune"), PersistentDataType.DOUBLE);
        }
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeExcavatingFortune"), PersistentDataType.DOUBLE) != null) {
            excavate += meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeExcavatingFortune"), PersistentDataType.DOUBLE);
        }

        if (excavate != 0.0) {
            String string = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeExcavatingFortune"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", excavate

            );

            lore.add(ChatColor.GRAY + "Excavating Fortune:" + ChatColor.GOLD + str + string);
            stats = true;
        }

        if (stats) {
            lore.add(" ");
        }

        if (!baseLore.isEmpty()) {
            lore.addAll(baseLore);
            lore.add(" ");
        }

        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING) != null &&
            meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING).equals("pet")) {
            switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"id"), PersistentDataType.STRING)) {
                case "Alien":
                    switch (color) {
                        case GOLD:
                        case LIGHT_PURPLE:
                            lore.add(ChatColor.GOLD + "Bogos");
                            lore.add(ChatColor.GRAY + "Abilities cost " + ChatColor.AQUA +
                                meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .99 + "% " + ChatColor.GRAY + "less");
                            lore.add(" ");
                            lore.add(ChatColor.GOLD + "Binted");
                            lore.add(ChatColor.YELLOW + "Smite " + ChatColor.GRAY + "the enemies you");
                            lore.add( ChatColor.GRAY + "strike until they die");
                            lore.add(" ");
                            lore.add(ChatColor.GOLD.toString() + ChatColor.MAGIC + "???????");
                            lore.add(ChatColor.GRAY + "When you" + ChatColor.MAGIC + " hit a " +
                                net.md_5.bungee.api.ChatColor.of("#241f11") + ChatColor.MAGIC + "cow " + ChatColor.GRAY + "that has");
                            lore.add(ChatColor.WHITE.toString() + ChatColor.MAGIC + "levitation " + ChatColor.RESET + ChatColor.GRAY + "you " +
                                ChatColor.MAGIC + "get kicked");
                            lore.add(" ");
                            break;
                        case DARK_PURPLE:
                            lore.add(ChatColor.GOLD + "Bogos");
                            lore.add(ChatColor.GRAY + "Abilities cost " + ChatColor.AQUA +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .9 + "% " + ChatColor.GRAY + "less");
                            lore.add(" ");
                            lore.add(ChatColor.GOLD + "Binted");
                            lore.add(ChatColor.YELLOW + "Smite " + ChatColor.GRAY + "the enemies you");
                            lore.add( ChatColor.GRAY + "strike until they die");
                            lore.add(" ");
                            break;
                        case BLUE:
                            lore.add(ChatColor.GOLD + "Bogos");
                            lore.add(ChatColor.GRAY + "Abilities cost " + ChatColor.AQUA +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .83 + "% " + ChatColor.GRAY + "less");
                            lore.add(" ");
                            lore.add(ChatColor.GOLD + "Binted");
                            lore.add(ChatColor.YELLOW + "Smite " + ChatColor.GRAY + "the enemies you");
                            lore.add( ChatColor.GRAY + "strike until they die");
                            lore.add(" ");
                            break;
                        case GREEN:
                            lore.add(ChatColor.GOLD + "Bogos");
                            lore.add(ChatColor.GRAY + "Abilities cost " + ChatColor.AQUA +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .71 + "% " + ChatColor.GRAY + "less");
                            lore.add(" ");
                            break;
                        default:
                            lore.add(ChatColor.GOLD + "Bogos");
                            lore.add(ChatColor.GRAY + "Abilities cost " + ChatColor.AQUA +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .63 + "% " + ChatColor.GRAY + "less");
                            lore.add(" ");
                            break;
                    }
                    break;
                case "Cow":
                    switch (color) {
                        case GOLD:
                        case LIGHT_PURPLE:
                            lore.add(ChatColor.GOLD + "Grazer");
                            lore.add(ChatColor.GRAY + "Gain " + ChatColor.GOLD + "+" +
                                meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .5 + " ☘ Farming Fortune");
                            lore.add(ChatColor.GRAY + "on " + ChatColor.YELLOW + "Wheat " + ChatColor.GRAY + "and " + ChatColor.GOLD +
                                meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .6 + " ☘ Excavating");
                            lore.add(ChatColor.GOLD + "Fortune " + ChatColor.GRAY + "on " + ChatColor.GREEN + "grass");
                            lore.add(" ");
                            lore.add(ChatColor.GOLD + "Extended Metabolism");
                            lore.add(ChatColor.GRAY + "Gain " + ChatColor.YELLOW + "+" +
                                meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * 0.015 +
                                " saturation " + ChatColor.GRAY + "when you");
                            lore.add( ChatColor.GRAY + "consume an item");
                            lore.add(" ");
                            lore.add(ChatColor.GOLD + "Fortified Immunity");
                            lore.add(ChatColor.GRAY + "Gain immunity to all");
                            lore.add(ChatColor.GRAY + "negative potion effects");
                            lore.add(" ");
                            break;
                        case DARK_PURPLE:
                            lore.add(ChatColor.GOLD + "Grazer");
                            lore.add(ChatColor.GRAY + "Gain " + ChatColor.GOLD + "+" +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .35 + " ☘ Farming Fortune");
                            lore.add(ChatColor.GRAY + "on " + ChatColor.YELLOW + "Wheat " + ChatColor.GRAY + "and " + ChatColor.GOLD +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .42 + " ☘ Excavating");
                            lore.add(ChatColor.GOLD + "Fortune " + ChatColor.GRAY + "on " + ChatColor.GREEN + "grass");
                            lore.add(" ");
                            lore.add(ChatColor.GOLD + "Extended Metabolism");
                            lore.add(ChatColor.GRAY + "Gain " + ChatColor.YELLOW + "+" +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * 0.009 +
                                    " saturation " + ChatColor.GRAY + "when you");
                            lore.add( ChatColor.GRAY + "consume an item");
                            lore.add(" ");
                            break;
                        case BLUE:
                            lore.add(ChatColor.GOLD + "Grazer");
                            lore.add(ChatColor.GRAY + "Gain " + ChatColor.GOLD + "+" +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .25 + " ☘ Farming Fortune");
                            lore.add(ChatColor.GRAY + "on " + ChatColor.YELLOW + "Wheat " + ChatColor.GRAY + "and " + ChatColor.GOLD +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .3 + " ☘ Excavating");
                            lore.add(ChatColor.GOLD + "Fortune " + ChatColor.GRAY + "on " + ChatColor.GREEN + "grass");
                            lore.add(" ");
                            lore.add(ChatColor.GOLD + "Extended Metabolism");
                            lore.add(ChatColor.GRAY + "Gain " + ChatColor.YELLOW + "+" +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * 0.006 +
                                    " saturation " + ChatColor.GRAY + "when you");
                            lore.add( ChatColor.GRAY + "consume an item");
                            lore.add(" ");
                            break;
                        case GREEN:
                            lore.add(ChatColor.GOLD + "Grazer");
                            lore.add(ChatColor.GRAY + "Gain " + ChatColor.GOLD + "+" +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .15 + " ☘ Farming Fortune");
                            lore.add(ChatColor.GRAY + "on " + ChatColor.YELLOW + "Wheat " + ChatColor.GRAY + "and " + ChatColor.GOLD +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .18 + " ☘ Excavating");
                            lore.add(ChatColor.GOLD + "Fortune " + ChatColor.GRAY + "on " + ChatColor.GREEN + "grass");
                            lore.add(" ");
                            break;
                        default:
                            lore.add(ChatColor.GOLD + "Grazer");
                            lore.add(ChatColor.GRAY + "Gain " + ChatColor.GOLD + "+" +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .1 + " ☘ Farming Fortune");
                            lore.add(ChatColor.GRAY + "on " + ChatColor.YELLOW + "Wheat " + ChatColor.GRAY + "and " + ChatColor.GOLD +
                                    meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"level"), PersistentDataType.INTEGER) * .12 + " ☘ Excavating");
                            lore.add(ChatColor.GOLD + "Fortune " + ChatColor.GRAY + "on " + ChatColor.GREEN + "grass");
                            lore.add(" ");
                            break;
                    }
                    break;
            }
        }

        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"id"), PersistentDataType.STRING)) {
            case "Renegade Crossbow":
                lore.add(ChatColor.GRAY + "Combinations " + ChatColor.GREEN + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"Level"), PersistentDataType.INTEGER).toString() + "/10");
                lore.add(" ");
                break;
            case "Magmaton Furnace F2713":
                lore.add(ChatColor.DARK_GRAY + "Fuel: " + ChatColor.GOLD + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"fuel"), PersistentDataType.INTEGER).toString());
                lore.add(" ");
                break;
            case "Aether Drive F117":
                lore.add(ChatColor.DARK_GRAY + "Fuel: " + ChatColor.LIGHT_PURPLE + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"fuel"), PersistentDataType.INTEGER).toString());
                lore.add(" ");
                break;
            case "Compacted Peat Moss":
                lore.add(ChatColor.DARK_GRAY + "Fertilizer: " + ChatColor.DARK_GREEN + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"fuel"), PersistentDataType.INTEGER).toString());
                lore.add(" ");
                break;
            case "Dull Pickaxe":
                lore.add(ChatColor.YELLOW + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"broken"), PersistentDataType.INTEGER).toString() + ChatColor.GRAY + "/" + ChatColor.GREEN + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"next"), PersistentDataType.INTEGER).toString());
                lore.add(" ");
                break;
            case "Name Tag":
                lore.add(ChatColor.DARK_GRAY + "Name: " + ChatColor.GREEN + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"name"), PersistentDataType.STRING));
                lore.add(" ");
                break;
        }
        meta.removeEnchant(Enchantment.DIG_SPEED);
        meta.removeEnchant(Enchantment.SILK_TOUCH);
        meta.removeEnchant(Enchantment.WATER_WORKER);
        meta.removeEnchant(Enchantment.DEPTH_STRIDER);
        meta.removeEnchant(Enchantment.OXYGEN);
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentName"), new stringList()).length > 0) {
            String[] numeral = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
            String enchantments = "";
            String testName = "";
            String[] enchantmentName = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentName"), new stringList());
            int[] enchantmentLevel = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentPower"), PersistentDataType.INTEGER_ARRAY);
            for (int i = 0; i < enchantmentName.length; i++) {

                if (enchantmentName[i].equals("Efficiency")) {
                    meta.addEnchant(Enchantment.DIG_SPEED, enchantmentLevel[i], true);
                }
                if (enchantmentName[i].equals("Silk Touch")) {
                    meta.addEnchant(Enchantment.SILK_TOUCH, enchantmentLevel[i], true);
                }
                if (enchantmentName[i].equals("Aqua Affinity")) {
                    meta.addEnchant(Enchantment.WATER_WORKER, enchantmentLevel[i], true);
                }
                if (enchantmentName[i].equals("Depth Strider")) {
                    meta.addEnchant(Enchantment.DEPTH_STRIDER, enchantmentLevel[i], true);
                }
                if (enchantmentName[i].equals("Respiration")) {
                    meta.addEnchant(Enchantment.OXYGEN, enchantmentLevel[i], true);
                }

                testName = enchantmentName[i] + " " +  numeral[enchantmentLevel[i] - 1] + ", ";
                if (enchantments.length() + testName.length() < 22) {
                    enchantments += testName;
                } else {
                    lore.add(ChatColor.BLUE + enchantments);
                    enchantments = testName;
                }

                if (i + 1 == enchantmentName.length) {
                    lore.add(ChatColor.BLUE + enchantments.substring(0, enchantments.length() - 2));
                    break;
                }
            }
            lore.add(" ");
        }

        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null) {
            switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING)) {
                case "Reforged":
                    lore.add(ChatColor.GRAY + "Does nothing just exists");
                    break;
                case "Prismatic":
                    lore.add(ChatColor.GRAY + "Cause your armor to become");
                    lore.add(ChatColor.GRAY + "a collage of colors!");
                    break;
                case "Sharp":
                    lore.add(ChatColor.BLUE + "Critical Hits " + ChatColor.GREEN + "deal");
                    lore.add(ChatColor.RED + "15% " + ChatColor.GRAY + "more damage");
                    break;
                case "Meaty":
                    lore.add(ChatColor.GRAY + "Make meaty slaps when");
                    lore.add(ChatColor.GRAY + "you get hit");
                    break;
                case "Antique":
                    lore.add(ChatColor.GRAY + "Deal " + ChatColor.RED + "40% " + ChatColor.GRAY + "more magic damage");
                    lore.add(ChatColor.GRAY + "but spells consume " + ChatColor.GREEN + "+100% " + ChatColor.AQUA + "✎ Mana");
                    break;
                case "Repeating":
                    lore.add(ChatColor.GRAY + "Shoot arrows" + ChatColor.GREEN + " 20% " + ChatColor.GRAY + "faster");
                    break;
                case "Gooey":
                    lore.add(ChatColor.GRAY + "Reduce the " + ChatColor.WHITE + "speed " + ChatColor.GRAY + "of entities");
                    lore.add(ChatColor.GRAY + "that attack you by " + ChatColor.RED + "2.5%");
                    lore.add(ChatColor.GRAY + "for " + ChatColor.GREEN + "5s");
                    break;
                case "Rusty":
                    lore.add(ChatColor.GRAY + "If the reforged item is");
                    lore.add(ChatColor.GRAY + "iron it will gain " + ChatColor.GREEN + "100%");
                    lore.add(ChatColor.GRAY + "more stats from the reforge");
                    break;
                case "Venomous":
                    lore.add(ChatColor.GRAY + "Poison " + ChatColor.GRAY + "and " + ChatColor.DARK_GRAY + "slow " + ChatColor.GRAY + "enemies");
                    lore.add(ChatColor.GRAY + "you attack");
                    break;
                case "Stimulating":
                    lore.add(ChatColor.GRAY + "Gain " + ChatColor.RED + "❁ Strength " + ChatColor.GRAY + "equal to");
                    lore.add(ChatColor.GREEN + "20% " + ChatColor.GRAY + "of the damage you blocked");
                    lore.add(ChatColor.GRAY + "blocked and " + ChatColor.WHITE + "+20 ✦ Speed");
                    lore.add(ChatColor.GRAY + "while your shield is down");
                    break;
                case "Illuminating":
                    lore.add(ChatColor.GRAY + "Gain " + ChatColor.BLUE + "Night Vision");
                    break;
                case "Camouflaged":
                    lore.add(ChatColor.GRAY + "You have a " + ChatColor.GREEN + "2.5% " + ChatColor.GRAY + "chance to");
                    lore.add(ChatColor.GRAY + "dodge an attack");
                    break;
                case "Tenacious":
                    lore.add(ChatColor.GRAY + "When you die your death is delayed");
                    lore.add(ChatColor.GRAY + "delayed by " + ChatColor.GREEN + "5s");
                    break;
                case "Sawed-Off":
                    lore.add(ChatColor.GRAY + "Arrows deal " + ChatColor.GREEN + "100% " + ChatColor.GRAY + "more");
                    lore.add(ChatColor.GRAY + "damage and fire inaccurately");
                    break;
                case "Leaching":
                    lore.add(ChatColor.GRAY + "Arrows heal you for " + ChatColor.GREEN + "2%");
                    lore.add(ChatColor.GRAY + "of your " + ChatColor.RED + " ❤ Max Health");
                    break;
            }
            lore.add(" ");
        }

        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING) != "") {
            String type = "";
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING) != null) {
                type = " " + ChatColor.BOLD + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING).toUpperCase();
            }
            lore.add(color + "" + ChatColor.BOLD + meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING) + type);
        }

        meta.setLore(lore);
        item.setItemMeta(meta);
    }
}

//c:end