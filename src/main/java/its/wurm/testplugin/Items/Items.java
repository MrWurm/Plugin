package its.wurm.testplugin.Items;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Inventories.FormatRecipesGUI;
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

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.STRING, "Back Arrow");
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
            null) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.WRITTEN_BOOK, 1);
            BookMeta meta = (BookMeta) item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Stats Guide");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.setTitle("Stats Guide");
            meta.setAuthor("WispishWurm");
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
            ChatColor.GRAY + "enemies for " + ChatColor.GREEN + "0.4x " + ChatColor.GRAY + "your " + ChatColor.RED + "❁ Strength " + ChatColor.GRAY + "when",
            ChatColor.GRAY + "you reel the rod in."},
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
            ChatColor.GRAY + "Deal " + ChatColor.GRAY + "25 Damage " + ChatColor.GRAY + "," + ChatColor.DARK_GRAY + "slow" + ChatColor.GRAY + ", and",
            ChatColor.DARK_RED + "weaken " + ChatColor.GRAY + " all enemies within",
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
             ChatColor.GRAY + "within " + ChatColor.GREEN + "10" + ChatColor.GRAY + "blocks who are",
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

//----------------------------------------ITEMS SECTION END x:item-----------------------------------------------------
//----------------------------------------WEAPONS SECTION c:weapons-----------------------------------------------------

    MOON_GLOVE(new String[] {
            ChatColor.GRAY + "This glove can manipulate gravity",
            ChatColor.GRAY + "and send enemies you strike flying."},
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
            ChatColor.GOLD + "Item Ability: Instant Transmission" + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT-CLICK",
            ChatColor.GRAY + "Teleport forward 8 blocks.",
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

    GEMSTONE_TRIDENT(new String[] {}, null) {
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
            meta.setDisplayName(ChatColor.BLUE + "Wand of Healing");

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
            
            meta.setDisplayName(ChatColor.BLUE + "Emerald Shield");

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
//------------------------------------------WEAPONS SECTION END x:weapons---------------------------------------------------
//------------------------------------------ARMOR SECTION c:armor-------------------------------------------------------

    THE_DRIP(new String[] {ChatColor.GRAY + "You got the drip"}, FormatRecipesGUI::newDripGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(94,175,184));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "The Drip");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(70,126,133));

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
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
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 85.0);
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
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 70.0);
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
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
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
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 40.0);

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
            leatherArmorMeta.setColor(Color.fromBGR(120,133,138));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 100.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Silverfish Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(120,133,138));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Silverfish Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(120,133,138));

            
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Silverfish Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(56, 109, 138));

            
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 500.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, -500.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Seven League Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "LEGENDARY");

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
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
            leatherArmorMeta.setColor(Color.fromBGR(18,42,74));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Terracotta Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 11.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE, 11.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(18,42,74));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Terracotta Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 9.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE, 9.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(18,42,74));

            
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Terracotta Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE, 5.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    INVOKER_HOOD(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newInvokerHoodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTE0YTZhZmEzNmM5N2M1MzE5ZWFmNTVkZTI0Y2JlN2UwNjc5ZjUwZTJhMTNkY2ZmOWUzZGE0MDg0Mzk3YTBjNiJ9fX0=");
            ItemMeta meta = item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Invoker Hood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
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
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newInvokerRobesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(173,90,17));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Invoker Robes");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 120.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    INVOKER_TROUSERS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newInvokerTrousersGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(173,90,17));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Invoker Trousers");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 24.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 100.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    INVOKER_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newInvokerBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(173,90,17));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Invoker Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 8.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 9.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 65.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    INCANTER_HOOD(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newIncanterHoodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTg0ODVmODUyZDI3M2FiNjIyMzUxN2MwZDg0YzRjMTNmNzA0ZWE1ZTQwYTc0MzFjNTAxMmJiMmU4NjI1MDQ0NSJ9fX0=");
            ItemMeta meta = item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Incanter Hood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
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
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newIncanterRobesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(154, 176, 28));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Incanter Robes");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 24.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 240.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    INCANTER_TROUSERS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newIncanterTrousersGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(154, 176, 28));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Incanter Trousers");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 45.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 180.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    INCANTER_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newIncanterBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(154, 176, 28));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Incanter Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 6.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 7.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 110.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    MYSTIC_HOOD(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newMysticHoodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg1MGM3ODg4N2MyMzAzOGEzMjRmYWRkMGY0YjIyNDgxYTA2OWYwZTgwNGQ3ZWIwOGM1Mjc3ZDg3ZGM3OWEyYyJ9fX0=");
            ItemMeta meta = item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mystic Hood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
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
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newMysticRobesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(184, 28, 155));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mystic Robes");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 70.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 100.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    MYSTIC_TROUSERS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newMysticTrousersGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(184, 28, 155));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mystic Trousers");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 45.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 54.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 80.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    MYSTIC_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newMysticBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(184, 28, 155));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Mystic Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 6.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 18.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 24.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    CHANTER_HOOD(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to",
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newChanterHoodGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmQzNDVhNGUxYmI4N2Q4ODVjMGI4NGUxM2EzYjlkNTE3Yjk0NmY2NTQyODQ0ZTlkMGNlNmFjYjdhZWYyYWQ1NiJ9fX0=");
            ItemMeta meta = item.getItemMeta();

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Whisperer Hood");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
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
            ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newChanterRobesGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(187, 189, 177));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Whisperer Robes");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 42.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 100.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    CHANTER_TROUSERS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to", ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newChanterTrousersGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(187, 189, 177));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Whisperer Trousers");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 45.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 36.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 80.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            item.setItemMeta(meta);

            initItem(plugin, item);

            return item;
        }
    },

    CHANTER_BOOTS(new String[] {
            ChatColor.GOLD + "Full Set Bonus: Vigorous Casting",
            ChatColor.GRAY + "When you cast a spell you",
            ChatColor.GRAY + "gain " + ChatColor.DARK_PURPLE + "ᛝ Thaumaturgy " + ChatColor.GRAY + "equal to", ChatColor.AQUA + "8%" + ChatColor.GRAY + "of the " + ChatColor.AQUA + "✎ Mana " + ChatColor.GRAY + "you spent",
            ChatColor.GRAY + "for " + ChatColor.GREEN + "12s" + ChatColor.GRAY + "."},
            FormatRecipesGUI::newChanterBootsGUI) {
        @Override
        public ItemStack getItem(Plugin plugin) {
            ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(Color.fromBGR(187, 189, 177));
            

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Whisperer Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "EPIC");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 16.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE, 9.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 7.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 24.0);

            
            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(37, 37, 41));


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Onyx Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");


            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(37, 37, 41));


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 110.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 60.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 110.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Onyx Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");


            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(37, 37, 41));


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 90.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Onyx Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");


            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(37, 37, 41));


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE, 12.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Onyx Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");


            meta.addItemFlags(ItemFlag.HIDE_DYE);
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


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 60.0);
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


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 110.0);
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


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 90.0);
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


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 40.0);
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


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 50.0);
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


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 75.0);
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


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 130.0);
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

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 50.0);
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
            leatherArmorMeta.setColor(Color.fromBGR(16, 111, 125));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Beekeeper Vest");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(16, 111, 125));


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 65.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Beekeeper Pants");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");


            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(16, 111, 125));


            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 35.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Beekeeper Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");


            meta.addItemFlags(ItemFlag.HIDE_DYE);
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

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 70.0);
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

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 60.0);
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
            leatherArmorMeta.setColor(Color.fromBGR(77, 116, 247));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 30.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Copper Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(77, 116, 247));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Copper Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(77, 116, 247));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 40.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Copper Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(77, 116, 247));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Copper Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "UNCOMMON");

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 90.0);
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
            leatherArmorMeta.setColor(Color.fromBGR(10, 59, 18));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 80.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Helmet");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(10, 59, 18));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 180.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Chestplate");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(10, 59, 18));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 150.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 20.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 10.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Leggings");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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
            leatherArmorMeta.setColor(Color.fromBGR(10, 59, 18));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 50.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 5.0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"type"), PersistentDataType.STRING, "boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Cactus Boots");
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING, "RARE");

            meta.addItemFlags(ItemFlag.HIDE_DYE);
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


    //------------------------------------------REFORGE STONE SECTION END x:reforges---------------------------------------------------
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
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        
        updateItem(plugin, item);

    }

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

        //Shaped recipe for Pocket Workbench
        sr = new ShapedRecipe(NamespacedKey.minecraft("porcket_workbench_s"), Items.POCKET_WORKBENCH.getItem(plugin));
        sr.shape("AS ",
                 "BO ",
                 "   ");
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

        //Shaped recipe for Hardwood Handle
        sr = new ShapedRecipe(NamespacedKey.minecraft("wood_handle_s"), Items.HARDWOOD_HANDLE.getItem(plugin));
        sr.shape("  O",
                 " O ",
                 "O  ");
        sr.setIngredient('O', new RecipeChoice.ExactChoice(Items.ENCHANTED_OAK_WOOD.getItem(plugin)));

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

        //Shaped recipe for Stats of Guide
        sr = new ShapedRecipe(NamespacedKey.minecraft("stat_book_s"), Items.STATS_GUIDE.getItem(plugin));
        sr.shape("   ",
                 "IR ",
                 "LP ");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LEATHER.getItem(plugin)));
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(Items.ENCHANTED_INK_SAC.getItem(plugin)));
        sr.setIngredient('P', Material.PAPER);
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
        sr.setIngredient('R', new RecipeChoice.ExactChoice(Items.ENCHANTED_REDSTONE.getItem(plugin)));
        sr.setIngredient('L', new RecipeChoice.ExactChoice(Items.ENCHANTED_LAPIS.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for enchanted slimeball
        sr = new ShapedRecipe(NamespacedKey.minecraft("enchanted_slime_s"), Items.ENCHANTED_SLIMEBALL.getItem(plugin));
        sr.shape("SSS",
                 "S S",
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
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_OAK_WOOD.getItem(plugin)));
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
        sr.setIngredient('W', new RecipeChoice.ExactChoice(Items.ENCHANTED_JUNGLE_WOOD.getItem(plugin)));
        Bukkit.getServer().addRecipe(sr);

        //Shaped recipe for Pungent Herbs
        sr = new ShapedRecipe(NamespacedKey.minecraft("pungent_herbs_s"), Items.PUNGENT_HERBS.getItem(plugin));
        sr.shape("EAE",
                 "ACA",
                 "CBC");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(Items.ENCHANTED_BEETROOT_SOUP.getItem(plugin)));
        sr.setIngredient('E', new RecipeChoice.ExactChoice(Items.FOREST_ESSENCE.getItem(plugin)));
        sr.setIngredient('C', new RecipeChoice.ExactChoice(Items.ENCHANTED_CRIMSON_STEM.getItem(plugin)));
        sr.setIngredient('A', new RecipeChoice.ExactChoice(Items.ENCHANTED_ACACIA_WOOD.getItem(plugin)));
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

        /*//Shaped recipe for Lesser Spirit Bone
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
        Bukkit.getServer().addRecipe(sr);*/
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
            meta.setDisplayName(color + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " " + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"), PersistentDataType.STRING));
        }
        else {
            meta.setDisplayName(color + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING));
        }

        boolean stats = false;
        List<String> lore = new ArrayList<>();

        switch (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"), PersistentDataType.STRING)) {
            case "Warp Scroll":
                lore.add(ChatColor.DARK_GRAY + "Travel to " + Math.round(item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"locationX"), PersistentDataType.DOUBLE)) + " " + Math.round(item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"locationY"), PersistentDataType.DOUBLE)) + " " + Math.round(item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"locationZ"), PersistentDataType.DOUBLE)) + " in the " + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"world"), PersistentDataType.STRING));
                lore.add(" ");
                break;
        }

        double damage = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE) != null) {
            damage = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDamage"), PersistentDataType.DOUBLE) != null) {
            damage += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDamage"), PersistentDataType.DOUBLE);
        }

        if (damage != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDamage"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDamage"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", damage

            );
            lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + str + string);
            stats = true;
        }

        double strength = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE) != null) {
            strength = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeStrength"), PersistentDataType.DOUBLE) != null) {
            strength += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeStrength"), PersistentDataType.DOUBLE);
        }

        if (strength != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeStrength"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeStrength"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", strength

            );

            lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + str + string);
            stats = true;
        }

        double CC = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE) != null) {
            CC = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCC"), PersistentDataType.DOUBLE) != null) {
            CC += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCC"), PersistentDataType.DOUBLE);
        }

        if (CC != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCC"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCC"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", CC

            );

            lore.add(ChatColor.GRAY + "Crit Chance:" + ChatColor.RED + str + string);
            stats = true;
        }

        double crit = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE) != null) {
            crit = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCrit"), PersistentDataType.DOUBLE) != null) {
            crit += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCrit"), PersistentDataType.DOUBLE);
        }

        if (crit != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCrit"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeCrit"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", crit

            );

            lore.add(ChatColor.GRAY + "Crit Damage:" + ChatColor.RED + str + string);
            stats = true;
        }

        double attackspeed = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE) != null) {
            attackspeed = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"AttackSpeed"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeAttackSpeed"), PersistentDataType.DOUBLE) != null) {
            attackspeed += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeAttackSpeed"), PersistentDataType.DOUBLE);
        }

        if (attackspeed != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeAttackSpeed"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeAttackSpeed"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", attackspeed

            );

            lore.add(ChatColor.GRAY + "Attack Speed:" + ChatColor.GREEN + str + string);
            stats = true;
        }

        double health = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE) != null) {
            health = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeHealth"), PersistentDataType.DOUBLE) != null) {
            health += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeHealth"), PersistentDataType.DOUBLE);
        }

        if (health != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeHealth"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeHealth"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", health

            );

            lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + str + string);
            stats = true;
        }

        double defense = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE) != null) {
            defense = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDefense"), PersistentDataType.DOUBLE) != null) {
            defense += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDefense"), PersistentDataType.DOUBLE);
        }

        if (defense != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDefense"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeDefense"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", defense

            );

            lore.add(ChatColor.GRAY + "Defense:" + ChatColor.GREEN + str + string);
            stats = true;
        }

        double speed = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE) != null) {
            speed = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Speed"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeSpeed"), PersistentDataType.DOUBLE) != null) {
            speed += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeSpeed"), PersistentDataType.DOUBLE);
        }

        if (speed != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeSpeed"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", speed

            );

            lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + str + string);
            stats = true;
        }

        double inteligence = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE) != null) {
            inteligence = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Intelligence"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeIntelligence"), PersistentDataType.DOUBLE) != null) {
            inteligence += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeIntelligence"), PersistentDataType.DOUBLE);
        }

        if (inteligence != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeIntelligence"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", inteligence

            );

            lore.add(ChatColor.GRAY + "Intelligence:" + ChatColor.AQUA + str + string);
            stats = true;
        }

        double thaumaturgy = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE) != null) {
            thaumaturgy = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Thaumaturgy"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeThaumaturgy"), PersistentDataType.DOUBLE) != null) {
            thaumaturgy += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeThaumaturgy"), PersistentDataType.DOUBLE);
        }

        if (thaumaturgy != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeThaumaturgy"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", thaumaturgy

            );

            lore.add(ChatColor.GRAY + "Thaumaturgy:" + ChatColor.AQUA + str + string);
            stats = true;
        }

        double invocation = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE) != null) {
            invocation = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Invocation"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeInvocation"), PersistentDataType.DOUBLE) != null) {
            invocation += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeInvocation"), PersistentDataType.DOUBLE);
        }

        if (invocation != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeInvocation"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", invocation

            );

            lore.add(ChatColor.GRAY + "Invocation:" + ChatColor.AQUA + str + string);
            stats = true;
        }

        double magic = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Magic"), PersistentDataType.DOUBLE) != null) {
            magic = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Magic"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMagic"), PersistentDataType.DOUBLE) != null) {
            magic += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMagic"), PersistentDataType.DOUBLE);
        }

        if (magic != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMagic"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", magic

            );

            lore.add(ChatColor.GRAY + "Magic Find:" + ChatColor.AQUA + str + string);
            stats = true;
        }

        double farm = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"FarmingFortune"), PersistentDataType.DOUBLE) != null) {
            farm = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"FarmingFortune"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeFarmingFortune"), PersistentDataType.DOUBLE) != null) {
            farm += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeFarmingFortune"), PersistentDataType.DOUBLE);
        }

        if (farm != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeFarmingFortune"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", farm

            );

            lore.add(ChatColor.GRAY + "Farming Fortune:" + ChatColor.GOLD + str + string);
            stats = true;
        }

        double mine = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE) != null) {
            mine = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"MiningFortune"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMiningFortune"), PersistentDataType.DOUBLE) != null) {
            mine += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMiningFortune"), PersistentDataType.DOUBLE);
        }

        if (mine != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeMiningFortune"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"), PersistentDataType.DOUBLE)

                );
            }

            String str = String.format(
                    " %1$+.0f", mine

            );

            lore.add(ChatColor.GRAY + "Mining Fortune:" + ChatColor.GOLD + str + string);
            stats = true;
        }

        double excavate = 0.0;
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE) != null) {
            excavate = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ExcavatingFortune"), PersistentDataType.DOUBLE);
        }
        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeExcavatingFortune"), PersistentDataType.DOUBLE) != null) {
            excavate += item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeExcavatingFortune"), PersistentDataType.DOUBLE);
        }

        if (excavate != 0.0) {
            String string = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null &&
                    item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"ReforgeExcavatingFortune"), PersistentDataType.DOUBLE) != 0.0) {
                string = String.format(
                        ChatColor.BLUE + " (" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING) + " %1$+.0f)", item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"), PersistentDataType.DOUBLE)

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

        switch (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"), PersistentDataType.STRING)) {
            case "Renegade Crossbow":
                lore.add(ChatColor.GRAY + "Combinations " + ChatColor.GREEN + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"Level"), PersistentDataType.INTEGER).toString() + "/10");
                lore.add(" ");
                break;
        }

        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING) != null) {
            switch (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"reforge"), PersistentDataType.STRING)) {
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
                    lore.add(ChatColor.GRAY + "but spells consume" + ChatColor.GREEN + "100% " + ChatColor.AQUA + "✎ Mana");
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
            }
            lore.add(" ");
        }

        if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING) != "") {
            String type = "";
            if (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING) != null) {
                type = " " + ChatColor.BOLD + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING).toUpperCase();
            }
            lore.add(color + "" + ChatColor.BOLD + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING) + type);
        }

        meta.setLore(lore);
        item.setItemMeta(meta);
    }
}

//c:end