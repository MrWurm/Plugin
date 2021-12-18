package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;


public class FormatRecipesGUI implements InventoryHolder {

    private Inventory main;
    private Inventory backArrow;

    public FormatRecipesGUI(

            //Define the plugin
            Plugin plugin,
            // The GUI clicking the back arrow will return
            InventoryHolder back,
            // The item output by this crafting table.
            ItemStack output,
            // The location (where 1 = top left, 9 = bottom right) of an item in the recipe.
            int item1_index,
            // The item in the recipe at this location.
            ItemStack item1,
            // Pairs of (location, item) for the remainder of the recipe.
            Object... items
    ) {
        // Define a main and create a gui
        main = Bukkit.createInventory(this, 54, "Crafting Table");

        for (int i = 0; i < 10; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        for (int i = 13; i < 19; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        for (int i = 22; i < 28; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        int[] trans = {10, 11, 12, 19, 20, 21, 28, 29, 30};
        main.setItem(trans[item1_index - 1], item1);
        for (int itemIndex = 0; itemIndex < items.length; itemIndex += 2) {
            int item_index = (int) items[itemIndex];
            ItemStack item = (ItemStack) items[itemIndex + 1];
            main.setItem(trans[item_index - 1], item);
        }
        for (int i = 31; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        main.setItem(23, output);
        main.setItem(49, Items.BACK_ARROW.getItem(plugin));

        backArrow = back.getInventory();
    }


    @Override
    public Inventory getInventory() {
        return main;
    }

    public Inventory getBackArrow() {
        return backArrow;
    }

    // Create GUI for each recipe

    // The Drip GUI
    public static FormatRecipesGUI newDripRecipeGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new ArmorSelectGUI(plugin), Items.THE_DRIP.getItem(plugin),
                4, Items.ENCHANTED_DRIPSTONE.getItem(plugin), 6, Items.ENCHANTED_DRIPSTONE.getItem(plugin),
                7, Items.ENCHANTED_DRIPSTONE.getItem(plugin), 9, Items.ENCHANTED_DRIPSTONE.getItem(plugin));
    }

    // Supreme Drip GUI
    public static FormatRecipesGUI newSupremeDripRecipeGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new ArmorSelectGUI(plugin), Items.SUPREME_DRIP.getItem(plugin),
                1, Items.ENCHANTED_DRIPSTONE.getItem(plugin), 2, Items.ENCHANTED_DRIPSTONE.getItem(plugin), 3, Items.ENCHANTED_DRIPSTONE.getItem(plugin),
                4, Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin), 5, Items.THE_DRIP.getItem(plugin), 6, Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin),
                7, Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin), 8, Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin), 9, Items.ENCHANTED_DRIPSTONE_BLOCK.getItem(plugin));
    }

    // Enchanted Dripstone GUI
    public static FormatRecipesGUI newEnchantedDripstoneGUI(Plugin plugin) {
        ItemStack dripstone = new ItemStack(Material.POINTED_DRIPSTONE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_DRIPSTONE.getItem(plugin),
                2, dripstone, 4, dripstone,
                5, dripstone, 6, dripstone, 8, dripstone);
    }

    // Enchanted Dripstone Block GUI
    public static FormatRecipesGUI newsEnchantedDripstoneRecipeGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_DRIPSTONE.getItem(plugin),
                1, Items.ENCHANTED_DEEPSLATE.getItem(plugin), 2, Items.ENCHANTED_DRIPSTONE.getItem(plugin), 3, Items.ENCHANTED_DEEPSLATE.getItem(plugin),
                4, Items.ENCHANTED_DRIPSTONE.getItem(plugin), 5, Items.ENCHANTED_DRIPSTONE.getItem(plugin), 6, Items.ENCHANTED_DRIPSTONE.getItem(plugin),
                7, Items.ENCHANTED_DEEPSLATE.getItem(plugin), 8, Items.ENCHANTED_DRIPSTONE.getItem(plugin), 9, Items.ENCHANTED_DEEPSLATE.getItem(plugin));
    }

    // Enchanted Coal GUI
    public static FormatRecipesGUI newEnchantedCoalGUI(Plugin plugin) {
        ItemStack coal = new ItemStack(Material.COAL, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_COAL.getItem(plugin),
                1, coal, 2, coal, 3, coal,
                4, coal, 6, coal,
                7, coal, 8, coal, 9, coal);
    }

    // Enchanted Coal Block GUI
    public static FormatRecipesGUI newsEnchantedCoalGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_COAL_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_COAL.getItem(plugin), 2, Items.ENCHANTED_COAL.getItem(plugin), 3, Items.ENCHANTED_COAL.getItem(plugin),
                4, Items.ENCHANTED_COAL.getItem(plugin), 5, Items.ENCHANTED_COAL.getItem(plugin), 6, Items.ENCHANTED_COAL.getItem(plugin),
                7, Items.ENCHANTED_COAL.getItem(plugin), 8, Items.ENCHANTED_COAL.getItem(plugin), 9, Items.ENCHANTED_COAL.getItem(plugin));
    }

    // Enchanted Deepslate GUI
    public static FormatRecipesGUI newEnchantedDeepslateGUI(Plugin plugin) {
        ItemStack deepslate = new ItemStack(Material.DEEPSLATE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_DEEPSLATE.getItem(plugin),
                1, deepslate, 2, deepslate, 3, deepslate,
                4, deepslate, 5, deepslate, 6, deepslate,
                7, deepslate, 8, deepslate, 9, deepslate);
    }

    // Enchanted Polished Deepslate GUI
    public static FormatRecipesGUI newsEnchantedDeepslateGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin),
                1, Items.ENCHANTED_DEEPSLATE.getItem(plugin), 2, Items.ENCHANTED_DEEPSLATE.getItem(plugin), 3, Items.ENCHANTED_DEEPSLATE.getItem(plugin),
                4, Items.ENCHANTED_DEEPSLATE.getItem(plugin), 5, Items.ENCHANTED_DEEPSLATE.getItem(plugin), 6, Items.ENCHANTED_DEEPSLATE.getItem(plugin),
                7, Items.ENCHANTED_DEEPSLATE.getItem(plugin), 8, Items.ENCHANTED_DEEPSLATE.getItem(plugin), 9, Items.ENCHANTED_DEEPSLATE.getItem(plugin));
    }

    // Enchanted Deepslate Tiles GUI
    public static FormatRecipesGUI newvsEnchantedDeepslateGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin),
                1, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin), 2, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin), 3, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin),
                4, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin), 5, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin), 6, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin),
                7, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin), 8, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin), 9, Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin));
    }

    // Enchanted Bamboo GUI
    public static FormatRecipesGUI newEnchantedBambooGUI(Plugin plugin) {
        ItemStack bamboo = new ItemStack(Material.BAMBOO, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_BAMBOO.getItem(plugin),
                1, bamboo, 2, bamboo, 3, bamboo,
                4, bamboo, 5, bamboo, 6, bamboo,
                7, bamboo, 8, bamboo, 9, bamboo);
    }

    // Bamboo Bundle GUI
    public static FormatRecipesGUI newsEnchantedBambooGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.BAMBOO_BUNDLE.getItem(plugin),
                1, Items.ENCHANTED_BAMBOO.getItem(plugin), 2, Items.ENCHANTED_BAMBOO.getItem(plugin), 3, Items.ENCHANTED_BAMBOO.getItem(plugin),
                4, Items.ENCHANTED_BAMBOO.getItem(plugin), 5, Items.ENCHANTED_BAMBOO.getItem(plugin), 6, Items.ENCHANTED_BAMBOO.getItem(plugin),
                7, Items.ENCHANTED_BAMBOO.getItem(plugin), 8, Items.ENCHANTED_BAMBOO.getItem(plugin), 9, Items.ENCHANTED_BAMBOO.getItem(plugin));
    }

    // Enchanted Iron GUI
    public static FormatRecipesGUI newEnchantedIronGUI(Plugin plugin) {
        ItemStack iron = new ItemStack(Material.IRON_INGOT, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_IRON.getItem(plugin),
                1, iron, 2, iron, 3, iron,
                4, iron, 6, iron,
                7, iron, 8, iron, 9, iron);
    }

    // Enchanted Iron Block GUI
    public static FormatRecipesGUI newsEnchantedIronGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_IRON_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_IRON.getItem(plugin), 2, Items.ENCHANTED_IRON.getItem(plugin), 3, Items.ENCHANTED_IRON.getItem(plugin),
                4, Items.ENCHANTED_IRON.getItem(plugin), 5, Items.ENCHANTED_IRON.getItem(plugin), 6, Items.ENCHANTED_IRON.getItem(plugin),
                7, Items.ENCHANTED_IRON.getItem(plugin), 8, Items.ENCHANTED_IRON.getItem(plugin), 9, Items.ENCHANTED_IRON.getItem(plugin));
    }

    // Enchanted Feather GUI
    public static FormatRecipesGUI newEnchantedFeatherGUI(Plugin plugin) {
        ItemStack feather = new ItemStack(Material.FEATHER, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_FEATHER.getItem(plugin),
                1, feather, 2, feather, 3, feather,
                4, feather, 5, feather, 6, feather,
                7, feather, 8, feather, 9, feather);
    }

    // Feather Charm GUI
    public static FormatRecipesGUI newfCharmGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MiscSelectGUI(plugin), Items.FEATHER_CHARM.getItem(plugin),
                1, Items.ENCHANTED_FEATHER.getItem(plugin), 2, Items.ENCHANTED_FEATHER.getItem(plugin), 3, Items.ENCHANTED_FEATHER.getItem(plugin),
                4, Items.ENCHANTED_FEATHER.getItem(plugin), 6, Items.ENCHANTED_FEATHER.getItem(plugin),
                7, Items.ENCHANTED_FEATHER.getItem(plugin), 8, Items.ENCHANTED_FEATHER.getItem(plugin), 9, Items.ENCHANTED_FEATHER.getItem(plugin));
    }

    // Enchanted Phantom Membrane GUI
    public static FormatRecipesGUI newEnchantedMembraneGUI(Plugin plugin) {
        ItemStack membrane = new ItemStack(Material.PHANTOM_MEMBRANE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_MEMBRANE.getItem(plugin),
                1, membrane, 2, membrane, 3, membrane,
                4, membrane, 5, membrane, 6, membrane,
                7, membrane, 8, membrane, 9, membrane);
    }

    // Enchanted Gold GUI
    public static FormatRecipesGUI newEnchantedGoldGUI(Plugin plugin) {
        ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_GOLD.getItem(plugin),
                1, gold, 2, gold, 3, gold,
                4, gold, 6, gold,
                7, gold, 8, gold, 9, gold);
    }

    // Enchanted Gold Block GUI
    public static FormatRecipesGUI newsEnchantedGoldGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_GOLD_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_GOLD.getItem(plugin), 2, Items.ENCHANTED_GOLD.getItem(plugin), 3, Items.ENCHANTED_GOLD.getItem(plugin),
                4, Items.ENCHANTED_GOLD.getItem(plugin), 5, Items.ENCHANTED_GOLD.getItem(plugin), 6, Items.ENCHANTED_GOLD.getItem(plugin),
                7, Items.ENCHANTED_GOLD.getItem(plugin), 8, Items.ENCHANTED_GOLD.getItem(plugin), 9, Items.ENCHANTED_GOLD.getItem(plugin));
    }

    // Enchanted Sand GUI
    public static FormatRecipesGUI newEnchantedSandGUI(Plugin plugin) {
        ItemStack sand = new ItemStack(Material.SAND, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_SAND.getItem(plugin),
                1, sand, 2, sand, 3, sand,
                4, sand, 5, sand, 6, sand,
                7, sand, 8, sand, 9, sand);
    }

    // Enchanted Compacted Sand GUI
    public static FormatRecipesGUI newsEnchantedSandGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_COMPACTED_SAND.getItem(plugin),
                1, Items.ENCHANTED_SAND.getItem(plugin), 2, Items.ENCHANTED_SAND.getItem(plugin), 3, Items.ENCHANTED_SAND.getItem(plugin),
                4, Items.ENCHANTED_SAND.getItem(plugin), 5, Items.ENCHANTED_SAND.getItem(plugin), 6, Items.ENCHANTED_SAND.getItem(plugin),
                7, Items.ENCHANTED_SAND.getItem(plugin), 8, Items.ENCHANTED_SAND.getItem(plugin), 9, Items.ENCHANTED_SAND.getItem(plugin));
    }

    // Enchanted Sandstone GUI
    public static FormatRecipesGUI newvsEnchantedSandGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_SANDSTONE.getItem(plugin),
                1, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin), 2, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin), 3, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin),
                4, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin), 5, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin), 6, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin),
                7, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin), 8, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin), 9, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin));
    }

    // Enchanted Copper GUI
    public static FormatRecipesGUI newEnchantedCopperGUI(Plugin plugin) {
        ItemStack copper = new ItemStack(Material.COPPER_INGOT, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_COPPER.getItem(plugin),
                1, copper, 2, copper, 3, copper,
                4, copper, 6, copper,
                7, copper, 8, copper, 9, copper);
    }

    // Enchanted Copper Block GUI
    public static FormatRecipesGUI newsEnchantedCopperGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_COPPER_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_COPPER.getItem(plugin), 2, Items.ENCHANTED_COPPER.getItem(plugin), 3, Items.ENCHANTED_COPPER.getItem(plugin),
                4, Items.ENCHANTED_COPPER.getItem(plugin), 5, Items.ENCHANTED_COPPER.getItem(plugin), 6, Items.ENCHANTED_COPPER.getItem(plugin),
                7, Items.ENCHANTED_COPPER.getItem(plugin), 8, Items.ENCHANTED_COPPER.getItem(plugin), 9, Items.ENCHANTED_COPPER.getItem(plugin));
    }

    // Enchanted Cut Copper Block GUI
    public static FormatRecipesGUI newvsEnchantedCopperGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_CUT_COPPER.getItem(plugin),
                1, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin), 2, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin), 3, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin),
                4, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin), 5, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin), 6, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin),
                7, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin), 8, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin), 9, Items.ENCHANTED_COPPER_BLOCK.getItem(plugin));
    }

    // Enchanted Quartz GUI
    public static FormatRecipesGUI newEnchantedQuartzGUI(Plugin plugin) {
        ItemStack quartz = new ItemStack(Material.QUARTZ, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_QUARTZ.getItem(plugin),
                1, quartz, 2, quartz, 3, quartz,
                4, quartz, 6, quartz,
                7, quartz, 8, quartz, 9, quartz);
    }

    // Enchanted Quartz Block GUI
    public static FormatRecipesGUI newsEnchantedQuartzGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_QUARTZ.getItem(plugin), 2, Items.ENCHANTED_QUARTZ.getItem(plugin), 3, Items.ENCHANTED_QUARTZ.getItem(plugin),
                4, Items.ENCHANTED_QUARTZ.getItem(plugin), 5, Items.ENCHANTED_QUARTZ.getItem(plugin), 6, Items.ENCHANTED_QUARTZ.getItem(plugin),
                7, Items.ENCHANTED_QUARTZ.getItem(plugin), 8, Items.ENCHANTED_QUARTZ.getItem(plugin), 9, Items.ENCHANTED_QUARTZ.getItem(plugin));
    }

    // Enchanted Quartz Sculpture GUI
    public static FormatRecipesGUI newvsEnchantedQuartzGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_QUARTZ_SCULPTURE.getItem(plugin),
                1, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin), 2, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin), 3, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin),
                4, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin), 5, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin), 6, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin),
                7, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin), 8, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin), 9, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin));
    }

    // Enchanted Cobblestone GUI
    public static FormatRecipesGUI newEnchantedCobbleGUI(Plugin plugin) {
        ItemStack cobble = new ItemStack(Material.COBBLESTONE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_COBBLESTONE.getItem(plugin),
                1, cobble, 2, cobble, 3, cobble,
                4, cobble, 5, cobble, 6, cobble,
                7, cobble, 8, cobble, 9, cobble);
    }

    // Enchanted Diamond GUI
    public static FormatRecipesGUI newEnchantedDiamondGUI(Plugin plugin) {
        ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_DIAMOND.getItem(plugin),
                1, diamond, 2, diamond, 3, diamond,
                4, diamond, 6, diamond,
                7, diamond, 8, diamond, 9, diamond);
    }

    // Enchanted Emerald GUI
    public static FormatRecipesGUI newEnchantedEmeraldGUI(Plugin plugin) {
        ItemStack emerald = new ItemStack(Material.EMERALD, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_EMERALD.getItem(plugin),
                1, emerald, 2, emerald, 3, emerald,
                4, emerald, 6, emerald,
                7, emerald, 8, emerald, 9, emerald);
    }

    // Stone Saber GUI
    public static FormatRecipesGUI newStoneSaberGUI(Plugin plugin) {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        return new FormatRecipesGUI(plugin, new WeaponsSelectGUI(plugin), Items.STONE_SCIMITAR.getItem(plugin),
                3, Items.ENCHANTED_COBBLESTONE.getItem(plugin),
                5, Items.ENCHANTED_COBBLESTONE.getItem(plugin),
                7, stick);
    }

    // Iron Saber GUI
    public static FormatRecipesGUI newIronSaberGUI(Plugin plugin) {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        return new FormatRecipesGUI(plugin, new WeaponsSelectGUI(plugin), Items.IRON_SCIMITAR.getItem(plugin),
                3, Items.ENCHANTED_IRON.getItem(plugin),
                5, Items.ENCHANTED_IRON.getItem(plugin),
                7, stick);
    }

    // Golden Saber GUI
    public static FormatRecipesGUI newGoldSaberGUI(Plugin plugin) {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        return new FormatRecipesGUI(plugin, new WeaponsSelectGUI(plugin), Items.GOLD_SCIMITAR.getItem(plugin),
                3, Items.ENCHANTED_GOLD.getItem(plugin),
                5, Items.ENCHANTED_GOLD.getItem(plugin),
                7, stick);
    }

    // Diamond Saber GUI
    public static FormatRecipesGUI newDiamondSaberGUI(Plugin plugin) {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        return new FormatRecipesGUI(plugin, new WeaponsSelectGUI(plugin), Items.DIAMOND_SCIMITAR.getItem(plugin),
                3, Items.ENCHANTED_DIAMOND.getItem(plugin),
                5, Items.ENCHANTED_DIAMOND.getItem(plugin),
                7, stick);
    }

    // Alloy GUI
    public static FormatRecipesGUI newAlloyGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ALLOY.getItem(plugin),
                1, Items.ENCHANTED_IRON.getItem(plugin), 2, Items.ENCHANTED_COPPER.getItem(plugin), 3, Items.ENCHANTED_IRON.getItem(plugin),
                4, Items.ENCHANTED_COPPER.getItem(plugin), 5, Items.ENCHANTED_COPPER.getItem(plugin), 6, Items.ENCHANTED_COPPER.getItem(plugin),
                7, Items.ENCHANTED_IRON.getItem(plugin), 8, Items.ENCHANTED_COPPER.getItem(plugin), 9, Items.ENCHANTED_IRON.getItem(plugin));
    }

    // Enchanted Chicken GUI
    public static FormatRecipesGUI newEnchantedChickenGUI(Plugin plugin) {
        ItemStack chicken = new ItemStack(Material.CHICKEN, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_CHICKEN.getItem(plugin),
                1, chicken, 2, chicken, 3, chicken,
                4, chicken, 5, chicken, 6, chicken,
                7, chicken, 8, chicken, 9, chicken);
    }

    // Enchanted Wool GUI
    public static FormatRecipesGUI newEnchantedWoolGUI(Plugin plugin) {
        ItemStack wool = new ItemStack(Material.WHITE_WOOL, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_WOOL.getItem(plugin),
                1, wool, 2, wool, 3, wool,
                4, wool, 5, wool, 6, wool,
                7, wool, 8, wool, 9, wool);
    }

    // Enchanted Wart GUI
    public static FormatRecipesGUI newEnchantedWartGUI(Plugin plugin) {
        ItemStack wart = new ItemStack(Material.NETHER_WART, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_WART.getItem(plugin),
                1, wart, 2, wart, 3, wart,
                4, wart, 6, wart,
                7, wart, 8, wart, 9, wart);
    }

    // Enchanted Mutton GUI
    public static FormatRecipesGUI newEnchantedMuttonGUI(Plugin plugin) {
        ItemStack mutton = new ItemStack(Material.MUTTON, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_MUTTON.getItem(plugin),
                1, mutton, 2, mutton, 3, mutton,
                4, mutton, 5, mutton, 6, mutton,
                7, mutton, 8, mutton, 9, mutton);
    }

    // Enchanted Pork GUI
    public static FormatRecipesGUI newEnchantedPorkGUI(Plugin plugin) {
        ItemStack pork = new ItemStack(Material.PORKCHOP, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_PORK.getItem(plugin),
                1, pork, 2, pork, 3, pork,
                4, pork, 5, pork, 6, pork,
                7, pork, 8, pork, 9, pork);
    }

    // Enchanted Beef GUI
    public static FormatRecipesGUI newEnchantedBeefGUI(Plugin plugin) {
        ItemStack beef = new ItemStack(Material.BEEF, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_BEEF.getItem(plugin),
                1, beef, 2, beef, 3, beef,
                4, beef, 5, beef, 6, beef,
                7, beef, 8, beef, 9, beef);
    }

    // Enchanted Rabbit GUI
    public static FormatRecipesGUI newEnchantedRabbitGUI(Plugin plugin) {
        ItemStack rabbit = new ItemStack(Material.BEEF, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_RABBIT.getItem(plugin),
                1, rabbit, 2, rabbit, 3, rabbit,
                4, rabbit, 5, rabbit, 6, rabbit,
                7, rabbit, 8, rabbit, 9, rabbit);
    }

    // Enchanted Tropical Fish GUI
    public static FormatRecipesGUI newEnchantedClownGUI(Plugin plugin) {
        ItemStack clownfish = new ItemStack(Material.TROPICAL_FISH, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_CLOWNFISH.getItem(plugin),
                1, clownfish, 2, clownfish, 3, clownfish,
                4, clownfish, 5, clownfish, 6, clownfish,
                7, clownfish, 8, clownfish, 9, clownfish);
    }

    // Enchanted Pufferfish GUI
    public static FormatRecipesGUI newEnchantedPufferGUI(Plugin plugin) {
        ItemStack pufferfish = new ItemStack(Material.PUFFERFISH, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_PUFFERFISH.getItem(plugin),
                1, pufferfish, 2, pufferfish, 3, pufferfish,
                4, pufferfish, 5, pufferfish, 6, pufferfish,
                7, pufferfish, 8, pufferfish, 9, pufferfish);
    }

    // Enchanted Cod GUI
    public static FormatRecipesGUI newEnchantedCodGUI(Plugin plugin) {
        ItemStack cod = new ItemStack(Material.COD, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_COD.getItem(plugin),
                1, cod, 2, cod, 3, cod,
                4, cod, 5, cod, 6, cod,
                7, cod, 8, cod, 9, cod);
    }

    // Enchanted Cooked Cod GUI
    public static FormatRecipesGUI newsEnchantedCodGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_COOKED_COD.getItem(plugin),
                1, Items.ENCHANTED_COD.getItem(plugin), 2, Items.ENCHANTED_COD.getItem(plugin), 3, Items.ENCHANTED_COD.getItem(plugin),
                4, Items.ENCHANTED_COD.getItem(plugin), 5, Items.ENCHANTED_COD.getItem(plugin), 6, Items.ENCHANTED_COD.getItem(plugin),
                7, Items.ENCHANTED_COD.getItem(plugin), 8, Items.ENCHANTED_COD.getItem(plugin), 9, Items.ENCHANTED_COD.getItem(plugin));
    }

    // Enchanted Salmon GUI
    public static FormatRecipesGUI newEnchantedSalmonGUI(Plugin plugin) {
        ItemStack salmon = new ItemStack(Material.SALMON, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_SALMON.getItem(plugin),
                1, salmon, 2, salmon, 3, salmon,
                4, salmon, 5, salmon, 6, salmon,
                7, salmon, 8, salmon, 9, salmon);
    }

    // Enchanted Cooked Salmon GUI
    public static FormatRecipesGUI newsEnchantedSalmonGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_COOKED_SALMON.getItem(plugin),
                1, Items.ENCHANTED_SALMON.getItem(plugin), 2, Items.ENCHANTED_SALMON.getItem(plugin), 3, Items.ENCHANTED_SALMON.getItem(plugin),
                4, Items.ENCHANTED_SALMON.getItem(plugin), 5, Items.ENCHANTED_SALMON.getItem(plugin), 6, Items.ENCHANTED_SALMON.getItem(plugin),
                7, Items.ENCHANTED_SALMON.getItem(plugin), 8, Items.ENCHANTED_SALMON.getItem(plugin), 9, Items.ENCHANTED_SALMON.getItem(plugin));
    }

    // Enchanted Lapis GUI
    public static FormatRecipesGUI newEnchantedLapisGUI(Plugin plugin) {
        ItemStack lapis = new ItemStack(Material.LAPIS_LAZULI, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_LAPIS.getItem(plugin),
                1, lapis, 2, lapis, 3, lapis,
                4, lapis, 6, lapis,
                7, lapis, 8, lapis, 9, lapis);
    }

    // Enchanted Lapis Block GUI
    public static FormatRecipesGUI newsEnchantedLapisGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_LAPIS_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_LAPIS.getItem(plugin), 2, Items.ENCHANTED_LAPIS.getItem(plugin), 3, Items.ENCHANTED_LAPIS.getItem(plugin),
                4, Items.ENCHANTED_LAPIS.getItem(plugin), 5, Items.ENCHANTED_LAPIS.getItem(plugin), 6, Items.ENCHANTED_LAPIS.getItem(plugin),
                7, Items.ENCHANTED_LAPIS.getItem(plugin), 8, Items.ENCHANTED_LAPIS.getItem(plugin), 9, Items.ENCHANTED_LAPIS.getItem(plugin));
    }

    // Enchanted Redstone GUI
    public static FormatRecipesGUI newEnchantedRedstoneGUI(Plugin plugin) {
        ItemStack redstone = new ItemStack(Material.REDSTONE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_REDSTONE.getItem(plugin),
                1, redstone, 2, redstone, 3, redstone,
                4, redstone, 6, redstone,
                7, redstone, 8, redstone, 9, redstone);
    }

    // Enchanted Redstone Block GUI
    public static FormatRecipesGUI newsEnchantedRedstoneGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_REDSTONE.getItem(plugin), 2, Items.ENCHANTED_REDSTONE.getItem(plugin), 3, Items.ENCHANTED_REDSTONE.getItem(plugin),
                4, Items.ENCHANTED_REDSTONE.getItem(plugin), 5, Items.ENCHANTED_REDSTONE.getItem(plugin), 6, Items.ENCHANTED_REDSTONE.getItem(plugin),
                7, Items.ENCHANTED_REDSTONE.getItem(plugin), 8, Items.ENCHANTED_REDSTONE.getItem(plugin), 9, Items.ENCHANTED_REDSTONE.getItem(plugin));
    }

    // Enchanted Kelp GUI
    public static FormatRecipesGUI newEnchantedKelpGUI(Plugin plugin) {
        ItemStack kelp = new ItemStack(Material.KELP, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_KELP.getItem(plugin),
                1, kelp, 2, kelp, 3, kelp,
                4, kelp, 5, kelp, 6, kelp,
                7, kelp, 8, kelp, 9, kelp);
    }

    // Enchanted Dried Kelp GUI
    public static FormatRecipesGUI newsEnchantedKelpGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_DRIED_KELP.getItem(plugin),
                1, Items.ENCHANTED_KELP.getItem(plugin), 2, Items.ENCHANTED_KELP.getItem(plugin), 3, Items.ENCHANTED_KELP.getItem(plugin),
                4, Items.ENCHANTED_KELP.getItem(plugin), 5, Items.ENCHANTED_KELP.getItem(plugin), 6, Items.ENCHANTED_KELP.getItem(plugin),
                7, Items.ENCHANTED_KELP.getItem(plugin), 8, Items.ENCHANTED_KELP.getItem(plugin), 9, Items.ENCHANTED_KELP.getItem(plugin));
    }

    // Enchanted Kelp Block GUI
    public static FormatRecipesGUI newvsEnchantedKelpGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI(plugin), Items.ENCHANTED_KELP_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_DRIED_KELP.getItem(plugin), 2, Items.ENCHANTED_DRIED_KELP.getItem(plugin), 3, Items.ENCHANTED_DRIED_KELP.getItem(plugin),
                4, Items.ENCHANTED_DRIED_KELP.getItem(plugin), 5, Items.ENCHANTED_DRIED_KELP.getItem(plugin), 6, Items.ENCHANTED_DRIED_KELP.getItem(plugin),
                7, Items.ENCHANTED_DRIED_KELP.getItem(plugin), 8, Items.ENCHANTED_DRIED_KELP.getItem(plugin), 9, Items.ENCHANTED_DRIED_KELP.getItem(plugin));
    }

    // Enchanted Netherite Scrap GUI
    public static FormatRecipesGUI newEnchantedNetheriteGUI(Plugin plugin) {
        ItemStack scrap = new ItemStack(Material.NETHERITE_SCRAP, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_NETHERITE.getItem(plugin),
                2, scrap,
                4, scrap, 5, scrap, 6, scrap,
                8, scrap);
    }

    // Enchanted Netherite Ingot GUI
    public static FormatRecipesGUI newsEnchantedNetheriteGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin),
                1, Items.ENCHANTED_NETHERITE.getItem(plugin), 2, Items.ENCHANTED_NETHERITE.getItem(plugin), 3, Items.ENCHANTED_NETHERITE.getItem(plugin),
                4, Items.ENCHANTED_NETHERITE.getItem(plugin), 6, Items.ENCHANTED_GOLD.getItem(plugin),
                7, Items.ENCHANTED_GOLD.getItem(plugin), 8, Items.ENCHANTED_GOLD.getItem(plugin), 9, Items.ENCHANTED_GOLD.getItem(plugin));
    }

    // Enchanted Netherite Block GUI
    public static FormatRecipesGUI newvsEnchantedNetheriteGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_NETHERITE_BLOCK.getItem(plugin),
                2, Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin),
                4, Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin), 5, Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin), 6, Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin),
                8, Items.ENCHANTED_NETHERITE_INGOT.getItem(plugin));
    }

    // Netherite Scimitar GUI
    public static FormatRecipesGUI newNetheriteSaberGUI(Plugin plugin) {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        return new FormatRecipesGUI(plugin, new WeaponsSelectGUI(plugin), Items.NETHERITE_SCIMITAR.getItem(plugin),
                3, Items.ENCHANTED_NETHERITE.getItem(plugin),
                5, Items.ENCHANTED_NETHERITE.getItem(plugin),
                7, stick);
    }

    // Enchanted Rotten Flesh  GUI
    public static FormatRecipesGUI newEnchantedFleshGUI(Plugin plugin) {
        ItemStack flesh = new ItemStack(Material.ROTTEN_FLESH, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_ROTTEN_FLESH.getItem(plugin),
                1, flesh, 2, flesh, 3, flesh,
                4, flesh, 5, flesh, 6, flesh,
                7, flesh, 8, flesh, 9, flesh);
    }

    // Enchanted Bone GUI
    public static FormatRecipesGUI newEnchantedBoneGUI(Plugin plugin) {
        ItemStack bone = new ItemStack(Material.BONE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_BONE.getItem(plugin),
                1, bone, 2, bone, 3, bone,
                4, bone, 5, bone, 6, bone,
                7, bone, 8, bone, 9, bone);
    }

    // Enchanted Bone Block GUI
    public static FormatRecipesGUI newsEnchantedBoneGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_BONE_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_BONE.getItem(plugin), 2, Items.ENCHANTED_BONE.getItem(plugin), 3, Items.ENCHANTED_BONE.getItem(plugin),
                4, Items.ENCHANTED_BONE.getItem(plugin), 5, Items.ENCHANTED_BONE.getItem(plugin), 6, Items.ENCHANTED_BONE.getItem(plugin),
                7, Items.ENCHANTED_BONE.getItem(plugin), 8, Items.ENCHANTED_BONE.getItem(plugin), 9, Items.ENCHANTED_BONE.getItem(plugin));
    }

    // Enchanted Spider Eye  GUI
    public static FormatRecipesGUI newEnchantedSpiderEyeGUI(Plugin plugin) {
        ItemStack eye = new ItemStack(Material.SPIDER_EYE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_SPIDER_EYE.getItem(plugin),
                1, eye, 2, eye, 3, eye,
                4, eye, 5, eye, 6, eye,
                7, eye, 8, eye, 9, eye);
    }

    // Enchanted String GUI
    public static FormatRecipesGUI newEnchantedStringGUI(Plugin plugin) {
        ItemStack string = new ItemStack(Material.STRING, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_STRING.getItem(plugin),
                1, string, 2, string, 3, string,
                4, string, 6, string,
                7, string, 8, string, 9, string);
    }

    // Enchanted Web GUI
    public static FormatRecipesGUI newsEnchantedStringGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_WEB.getItem(plugin),
                1, Items.ENCHANTED_STRING.getItem(plugin), 2, Items.ENCHANTED_STRING.getItem(plugin), 3, Items.ENCHANTED_STRING.getItem(plugin),
                4, Items.ENCHANTED_STRING.getItem(plugin), 5, Items.ENCHANTED_STRING.getItem(plugin), 6, Items.ENCHANTED_STRING.getItem(plugin),
                7, Items.ENCHANTED_STRING.getItem(plugin), 8, Items.ENCHANTED_STRING.getItem(plugin), 9, Items.ENCHANTED_STRING.getItem(plugin));
    }

    // Enchanted Amethyst GUI
    public static FormatRecipesGUI newEnchantedAmethystGUI(Plugin plugin) {
        ItemStack amethyst = new ItemStack(Material.AMETHYST_SHARD, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_AMETHYST.getItem(plugin),
                1, amethyst, 2, amethyst, 3, amethyst,
                4, amethyst, 5, amethyst, 6, amethyst,
                7, amethyst, 8, amethyst, 9, amethyst);
    }

    // Enchanted Amethyst Block GUI
    public static FormatRecipesGUI newsEnchantedAmethystGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_AMETHYST_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_AMETHYST.getItem(plugin), 2, Items.ENCHANTED_AMETHYST.getItem(plugin), 3, Items.ENCHANTED_AMETHYST.getItem(plugin),
                4, Items.ENCHANTED_AMETHYST.getItem(plugin), 5, Items.ENCHANTED_AMETHYST.getItem(plugin), 6, Items.ENCHANTED_AMETHYST.getItem(plugin),
                7, Items.ENCHANTED_AMETHYST.getItem(plugin), 8, Items.ENCHANTED_AMETHYST.getItem(plugin), 9, Items.ENCHANTED_AMETHYST.getItem(plugin));
    }

    // Enchanted Ink Sack GUI
    public static FormatRecipesGUI newEnchantedInkGUI(Plugin plugin) {
        ItemStack ink = new ItemStack(Material.INK_SAC, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_INK_SAC.getItem(plugin),
                1, ink, 2, ink, 3, ink,
                4, ink, 5, ink, 6, ink,
                7, ink, 8, ink, 9, ink);
    }

    // Enchanted Glow Ink Sac GUI
    public static FormatRecipesGUI newsEnchantedInkGUI(Plugin plugin) {
        ItemStack ink = new ItemStack(Material.GLOW_INK_SAC, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_GLOW_SAC.getItem(plugin),
                1, ink, 2, ink, 3, ink,
                4, ink, 5, Items.ENCHANTED_INK_SAC.getItem(plugin), 6, ink,
                7, ink, 8, ink, 9, ink);
    }

    // Enchanted Cocoa Beans GUI
    public static FormatRecipesGUI newEnchantedCocoaGUI(Plugin plugin) {
        ItemStack coco = new ItemStack(Material.COCOA_BEANS, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_COCOA.getItem(plugin),
                1, coco, 2, coco, 3, coco,
                4, coco, 5, coco, 6, coco,
                7, coco, 8, coco, 9, coco);
    }

    // Enchanted Snowball GUI
    public static FormatRecipesGUI newEnchantedSnowGUI(Plugin plugin) {
        ItemStack snow = new ItemStack(Material.SNOWBALL, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_SNOWBALL.getItem(plugin),
                1, snow, 2, snow, 3, snow,
                4, snow, 5, snow, 6, snow,
                7, snow, 8, snow, 9, snow);
    }

    // Enchanted Snow Block GUI
    public static FormatRecipesGUI newsEnchantedSnowGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_SNOW.getItem(plugin),
                1, Items.ENCHANTED_SNOWBALL.getItem(plugin), 2, Items.ENCHANTED_SNOWBALL.getItem(plugin), 3, Items.ENCHANTED_SNOWBALL.getItem(plugin),
                4, Items.ENCHANTED_SNOWBALL.getItem(plugin), 5, Items.ENCHANTED_SNOWBALL.getItem(plugin), 6, Items.ENCHANTED_SNOWBALL.getItem(plugin),
                7, Items.ENCHANTED_SNOWBALL.getItem(plugin), 8, Items.ENCHANTED_SNOWBALL.getItem(plugin), 9, Items.ENCHANTED_SNOWBALL.getItem(plugin));
    }

    // Snow Mound GUI
    public static FormatRecipesGUI newvsEnchantedSnowGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.SNOW_MOUND.getItem(plugin),
                1, Items.ENCHANTED_SNOW.getItem(plugin), 2, Items.ENCHANTED_SNOW.getItem(plugin), 3, Items.ENCHANTED_SNOW.getItem(plugin),
                4, Items.ENCHANTED_SNOW.getItem(plugin), 5, Items.ENCHANTED_SNOW.getItem(plugin), 6, Items.ENCHANTED_SNOW.getItem(plugin),
                7, Items.ENCHANTED_SNOW.getItem(plugin), 8, Items.ENCHANTED_SNOW.getItem(plugin), 9, Items.ENCHANTED_SNOW.getItem(plugin));
    }

    // Enchanted Gunpowder GUI
    public static FormatRecipesGUI newEnchantedGunpowderGUI(Plugin plugin) {
        ItemStack gunpowder = new ItemStack(Material.GUNPOWDER, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_GUNPOWDER.getItem(plugin),
                1, gunpowder, 2, gunpowder, 3, gunpowder,
                4, gunpowder, 5, gunpowder, 6, gunpowder,
                7, gunpowder, 8, gunpowder, 9, gunpowder);
    }

    // Enchanted Powder Ball GUI
    public static FormatRecipesGUI newsEnchantedGunpowderGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_POWDER_BALL.getItem(plugin),
                1, Items.ENCHANTED_GUNPOWDER.getItem(plugin), 2, Items.ENCHANTED_GUNPOWDER.getItem(plugin), 3, Items.ENCHANTED_GUNPOWDER.getItem(plugin),
                4, Items.ENCHANTED_GUNPOWDER.getItem(plugin), 5, Items.ENCHANTED_GUNPOWDER.getItem(plugin), 6, Items.ENCHANTED_GUNPOWDER.getItem(plugin),
                7, Items.ENCHANTED_GUNPOWDER.getItem(plugin), 8, Items.ENCHANTED_GUNPOWDER.getItem(plugin), 9, Items.ENCHANTED_GUNPOWDER.getItem(plugin));
    }

    // Enchanted Tnt GUI
    public static FormatRecipesGUI newEnchantedTntGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_TNT.getItem(plugin),
                1, Items.ENCHANTED_GUNPOWDER.getItem(plugin), 2, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin), 3, Items.ENCHANTED_GUNPOWDER.getItem(plugin),
                4, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin), 5, Items.ENCHANTED_GUNPOWDER.getItem(plugin), 6, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin),
                7, Items.ENCHANTED_GUNPOWDER.getItem(plugin), 8, Items.ENCHANTED_COMPACTED_SAND.getItem(plugin), 9, Items.ENCHANTED_GUNPOWDER.getItem(plugin));
    }

    // Enchanted Clay GUI
    public static FormatRecipesGUI newEnchantedClayGUI(Plugin plugin) {
        ItemStack clay = new ItemStack(Material.CLAY_BALL, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_CLAY.getItem(plugin),
                1, clay, 2, clay, 3, clay,
                4, clay, 5, clay, 6, clay,
                7, clay, 8, clay, 9, clay);
    }

    // Enchanted Clay Block GUI
    public static FormatRecipesGUI newsEnchantedClayGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_CLAY_BLOCK.getItem(plugin),
                1, Items.ENCHANTED_CLAY.getItem(plugin), 2, Items.ENCHANTED_CLAY.getItem(plugin), 3, Items.ENCHANTED_CLAY.getItem(plugin),
                4, Items.ENCHANTED_CLAY.getItem(plugin), 5, Items.ENCHANTED_CLAY.getItem(plugin), 6, Items.ENCHANTED_CLAY.getItem(plugin),
                7, Items.ENCHANTED_CLAY.getItem(plugin), 8, Items.ENCHANTED_CLAY.getItem(plugin), 9, Items.ENCHANTED_CLAY.getItem(plugin));
    }

    // Enchanted Glowstone Dust GUI
    public static FormatRecipesGUI newEnchantedGlowstoneGUI(Plugin plugin) {
        ItemStack glowstone = new ItemStack(Material.GLOWSTONE_DUST, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin),
                1, glowstone, 2, glowstone, 3, glowstone,
                4, glowstone, 5, glowstone, 6, glowstone,
                7, glowstone, 8, glowstone, 9, glowstone);
    }

    // Enchanted Glowstone GUI
    public static FormatRecipesGUI newsEnchantedGlowstoneGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_GLOWSTONE.getItem(plugin),
                1, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin), 2, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin), 3, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin),
                4, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin), 5, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin), 6, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin),
                7, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin), 8, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin), 9, Items.ENCHANTED_GLOWSTONE_DUST.getItem(plugin));
    }

    // Enchanted Blaze Powder GUI
    public static FormatRecipesGUI newEnchantedBlazeGUI(Plugin plugin) {
        ItemStack powder = new ItemStack(Material.BLAZE_POWDER, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_BLAZE_POWDER.getItem(plugin),
                1, powder, 2, powder, 3, powder,
                4, powder, 5, powder, 6, powder,
                7, powder, 8, powder, 9, powder);
    }

    // Enchanted Blaze Rod GUI
    public static FormatRecipesGUI newsEnchantedBlazeGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_BLAZE_ROD.getItem(plugin),
                1, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin), 2, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin), 3, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin),
                4, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin), 5, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin), 6, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin),
                7, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin), 8, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin), 9, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin));
    }

    // Enchanted Ender Pearl GUI
    public static FormatRecipesGUI newEnchantedPearlGUI(Plugin plugin) {
        ItemStack pearl = new ItemStack(Material.ENDER_PEARL, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_ENDER_PEARL.getItem(plugin),
                1, pearl, 2, pearl, 3, pearl,
                4, pearl, 5, pearl, 6, pearl,
                7, pearl, 8, pearl, 9, pearl);
    }

    // Enchanted Blaze Rod GUI
    public static FormatRecipesGUI newsEnchantedPearlGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_ENDER_EYE.getItem(plugin),
                2, Items.ENCHANTED_ENDER_PEARL.getItem(plugin),
                4, Items.ENCHANTED_ENDER_PEARL.getItem(plugin), 5, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin), 6, Items.ENCHANTED_ENDER_PEARL.getItem(plugin),
                8, Items.ENCHANTED_BLAZE_POWDER.getItem(plugin));
    }

    // Enchanted Sweet Berries GUI
    public static FormatRecipesGUI newEnchantedBerriesGUI(Plugin plugin) {
        ItemStack berries = new ItemStack(Material.SWEET_BERRIES, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_SWEET_BERRIES.getItem(plugin),
                1, berries, 2, berries, 3, berries,
                4, berries, 5, berries, 6, berries,
                7, berries, 8, berries, 9, berries);
    }

    // Enchanted Sugar Cane GUI
    public static FormatRecipesGUI newEnchantedCaneGUI(Plugin plugin) {
        ItemStack cane = new ItemStack(Material.SUGAR_CANE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_SUGAR_CANE.getItem(plugin),
                1, cane, 2, cane, 3, cane,
                4, cane, 5, cane, 6, cane,
                7, cane, 8, cane, 9, cane);
    }

    // Enchanted Sugar GUI
    public static FormatRecipesGUI newsEnchantedSugarGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_SUGAR.getItem(plugin),
                1, Items.ENCHANTED_SUGAR_CANE.getItem(plugin), 2, Items.ENCHANTED_SUGAR_CANE.getItem(plugin), 3, Items.ENCHANTED_SUGAR_CANE.getItem(plugin),
                4, Items.ENCHANTED_SUGAR_CANE.getItem(plugin), 5, Items.ENCHANTED_SUGAR_CANE.getItem(plugin), 6, Items.ENCHANTED_SUGAR_CANE.getItem(plugin),
                7, Items.ENCHANTED_SUGAR_CANE.getItem(plugin), 8, Items.ENCHANTED_SUGAR_CANE.getItem(plugin), 9, Items.ENCHANTED_SUGAR_CANE.getItem(plugin));
    }

    // Enchanted Chorus Fruit GUI
    public static FormatRecipesGUI newEnchantedFruitGUI(Plugin plugin) {
        ItemStack fruit = new ItemStack(Material.CHORUS_FRUIT, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin),
                1, fruit, 2, fruit, 3, fruit,
                4, fruit, 5, fruit, 6, fruit,
                7, fruit, 8, fruit, 9, fruit);
    }

    // Enchanted Popped Chorus Fruit GUI
    public static FormatRecipesGUI newsEnchantedFruitGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_POPPED_CHORUS_FRUIT.getItem(plugin),
                1, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin), 2, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin), 3, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin),
                4, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin), 5, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin), 6, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin),
                7, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin), 8, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin), 9, Items.ENCHANTED_CHORUS_FRUIT.getItem(plugin));
    }

    // Enchanted Carrot GUI
    public static FormatRecipesGUI newEnchantedCarrotGUI(Plugin plugin) {
        ItemStack carrot = new ItemStack(Material.CARROT, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_CARROT.getItem(plugin),
                1, carrot, 2, carrot, 3, carrot,
                4, carrot, 5, carrot, 6, carrot,
                7, carrot, 8, carrot, 9, carrot);
    }

    // Enchanted Golden Carrot GUI
    public static FormatRecipesGUI newsEnchantedCarrotGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_GOLDEN_CARROT.getItem(plugin),
                1, Items.ENCHANTED_GOLD.getItem(plugin), 2, Items.ENCHANTED_CARROT.getItem(plugin), 3, Items.ENCHANTED_GOLD.getItem(plugin),
                4, Items.ENCHANTED_CARROT.getItem(plugin), 5, Items.ENCHANTED_CARROT.getItem(plugin), 6, Items.ENCHANTED_CARROT.getItem(plugin),
                7, Items.ENCHANTED_GOLD.getItem(plugin), 8, Items.ENCHANTED_CARROT.getItem(plugin), 9, Items.ENCHANTED_GOLD.getItem(plugin));
    }

    // Enchanted Potato GUI
    public static FormatRecipesGUI newEnchantedPotatoGUI(Plugin plugin) {
        ItemStack potato = new ItemStack(Material.POTATO, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_POTATO.getItem(plugin),
                1, potato, 2, potato, 3, potato,
                4, potato, 5, potato, 6, potato,
                7, potato, 8, potato, 9, potato);
    }

    // Enchanted Baked Potato GUI
    public static FormatRecipesGUI newsEnchantedPotatoGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_GOLDEN_CARROT.getItem(plugin),
                1, Items.ENCHANTED_POTATO.getItem(plugin), 2, Items.ENCHANTED_POTATO.getItem(plugin), 3, Items.ENCHANTED_POTATO.getItem(plugin),
                4, Items.ENCHANTED_POTATO.getItem(plugin), 5, Items.ENCHANTED_POTATO.getItem(plugin), 6, Items.ENCHANTED_POTATO.getItem(plugin),
                7, Items.ENCHANTED_POTATO.getItem(plugin), 8, Items.ENCHANTED_POTATO.getItem(plugin), 9, Items.ENCHANTED_POTATO.getItem(plugin));
    }

    // Enchanted Beetroot GUI
    public static FormatRecipesGUI newEnchantedBeetGUI(Plugin plugin) {
        ItemStack beet = new ItemStack(Material.BEETROOT, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_BEETROOT.getItem(plugin),
                1, beet, 2, beet, 3, beet,
                4, beet, 5, beet, 6, beet,
                7, beet, 8, beet, 9, beet);
    }

    // Enchanted Beetroot Soup GUI
    public static FormatRecipesGUI newsEnchantedBeetGUI(Plugin plugin) {
        ItemStack bowl = new ItemStack(Material.BOWL, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_BEETROOT_SOUP.getItem(plugin),
                1, Items.ENCHANTED_BEETROOT.getItem(plugin), 2, Items.ENCHANTED_BEETROOT.getItem(plugin), 3, Items.ENCHANTED_BEETROOT.getItem(plugin),
                4, Items.ENCHANTED_BEETROOT.getItem(plugin), 5, Items.ENCHANTED_BEETROOT.getItem(plugin), 6, Items.ENCHANTED_BEETROOT.getItem(plugin),
                8, bowl);
    }

    // Enchanted Melon Slice GUI
    public static FormatRecipesGUI newEnchantedMelonGUI(Plugin plugin) {
        ItemStack melon = new ItemStack(Material.MELON_SLICE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_MELON_SLICE.getItem(plugin),
                1, melon, 2, melon, 3, melon,
                4, melon, 6, melon,
                7, melon, 8, melon, 9, melon);
    }

    // Enchanted Baked Potato GUI
    public static FormatRecipesGUI newsEnchantedMelonGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_MELON.getItem(plugin),
                1, Items.ENCHANTED_MELON_SLICE.getItem(plugin), 2, Items.ENCHANTED_MELON_SLICE.getItem(plugin), 3, Items.ENCHANTED_MELON_SLICE.getItem(plugin),
                4, Items.ENCHANTED_MELON_SLICE.getItem(plugin), 5, Items.ENCHANTED_MELON_SLICE.getItem(plugin), 6, Items.ENCHANTED_MELON_SLICE.getItem(plugin),
                7, Items.ENCHANTED_MELON_SLICE.getItem(plugin), 8, Items.ENCHANTED_MELON_SLICE.getItem(plugin), 9, Items.ENCHANTED_MELON_SLICE.getItem(plugin));
    }

    // Enchanted Brown Mushroom GUI
    public static FormatRecipesGUI newEnchantedBrownMushroomGUI(Plugin plugin) {
        ItemStack mushroom = new ItemStack(Material.BROWN_MUSHROOM, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_BROWN_MUSHROOM.getItem(plugin),
                1, mushroom, 2, mushroom, 3, mushroom,
                4, mushroom, 6, mushroom,
                7, mushroom, 8, mushroom, 9, mushroom);
    }

    // Enchanted Red Mushroom GUI
    public static FormatRecipesGUI newEnchantedRedMushroomGUI(Plugin plugin) {
        ItemStack mushroom = new ItemStack(Material.RED_MUSHROOM, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ENCHANTED_RED_MUSHROOM.getItem(plugin),
                1, mushroom, 2, mushroom, 3, mushroom,
                4, mushroom, 6, mushroom,
                7, mushroom, 8, mushroom, 9, mushroom);
    }

    // Enchanted Red Mushroom GUI
    public static FormatRecipesGUI newEnchantedFlintGUI(Plugin plugin) {
        ItemStack flint = new ItemStack(Material.FLINT, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_FLINT.getItem(plugin),
                1, flint, 2, flint, 3, flint,
                4, flint, 5, flint, 6, flint,
                7, flint, 8, flint, 9, flint);
    }

    // Enchanted Pumpkin GUI
    public static FormatRecipesGUI newEnchantedPumpkinGUI(Plugin plugin) {
        ItemStack pumpkin = new ItemStack(Material.PUMPKIN, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_PUMPKIN.getItem(plugin),
                1, pumpkin, 2, pumpkin, 3, pumpkin,
                4, pumpkin, 5, pumpkin, 6, pumpkin,
                7, pumpkin, 8, pumpkin, 9, pumpkin);
    }

    // Enchanted Cactus GUI
    public static FormatRecipesGUI newEnchantedCactusGUI(Plugin plugin) {
        ItemStack cactus = new ItemStack(Material.CACTUS, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_CACTUS.getItem(plugin),
                1, cactus, 2, cactus, 3, cactus,
                4, cactus, 5, cactus, 6, cactus,
                7, cactus, 8, cactus, 9, cactus);
    }

    // Enchanted Soul Sand GUI
    public static FormatRecipesGUI newEnchantedSoulSandGUI(Plugin plugin) {
        ItemStack soul = new ItemStack(Material.SOUL_SAND, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_SOUL_SAND.getItem(plugin),
                1, soul, 2, soul, 3, soul,
                4, soul, 5, soul, 6, soul,
                7, soul, 8, soul, 9, soul);
    }

    // Enchanted Soul Sand GUI
    public static FormatRecipesGUI newEnchantedSoulSoilGUI(Plugin plugin) {
        ItemStack soul = new ItemStack(Material.SOUL_SOIL, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_SOUL_SOIL.getItem(plugin),
                1, soul, 2, soul, 3, soul,
                4, soul, 5, soul, 6, soul,
                7, soul, 8, soul, 9, soul);
    }

    // Enchanted Oak Wood GUI
    public static FormatRecipesGUI newEnchantedOakGUI(Plugin plugin) {
        ItemStack wood = new ItemStack(Material.OAK_LOG, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_OAK_WOOD.getItem(plugin),
                1, wood, 2, wood, 3, wood,
                4, wood, 5, wood, 6, wood,
                7, wood, 8, wood, 9, wood);
    }

    // Enchanted Dark Oak Wood GUI
    public static FormatRecipesGUI newEnchantedDarkOakGUI(Plugin plugin) {
        ItemStack wood = new ItemStack(Material.DARK_OAK_LOG, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_DARK_OAK_WOOD.getItem(plugin),
                1, wood, 2, wood, 3, wood,
                4, wood, 5, wood, 6, wood,
                7, wood, 8, wood, 9, wood);
    }

    // Enchanted Birch Wood GUI
    public static FormatRecipesGUI newEnchantedBirchGUI(Plugin plugin) {
        ItemStack wood = new ItemStack(Material.BIRCH_LOG, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_BIRCH_WOOD.getItem(plugin),
                1, wood, 2, wood, 3, wood,
                4, wood, 5, wood, 6, wood,
                7, wood, 8, wood, 9, wood);
    }

    // Enchanted Spruce Wood GUI
    public static FormatRecipesGUI newEnchantedSpruceGUI(Plugin plugin) {
        ItemStack wood = new ItemStack(Material.SPRUCE_LOG, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_SPRUCE_WOOD.getItem(plugin),
                1, wood, 2, wood, 3, wood,
                4, wood, 5, wood, 6, wood,
                7, wood, 8, wood, 9, wood);
    }

    // Enchanted Acacia Wood GUI
    public static FormatRecipesGUI newEnchantedAcaciaGUI(Plugin plugin) {
        ItemStack wood = new ItemStack(Material.ACACIA_LOG, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_ACACIA_WOOD.getItem(plugin),
                1, wood, 2, wood, 3, wood,
                4, wood, 5, wood, 6, wood,
                7, wood, 8, wood, 9, wood);
    }

    // Enchanted Jungle Wood GUI
    public static FormatRecipesGUI newEnchantedJungleGUI(Plugin plugin) {
        ItemStack wood = new ItemStack(Material.JUNGLE_LOG, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_JUNGLE_WOOD.getItem(plugin),
                1, wood, 2, wood, 3, wood,
                4, wood, 5, wood, 6, wood,
                7, wood, 8, wood, 9, wood);
    }

    // Enchanted Crimson Stem GUI
    public static FormatRecipesGUI newEnchantedCrimsonGUI(Plugin plugin) {
        ItemStack wood = new ItemStack(Material.CRIMSON_STEM, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_CRIMSON_STEM.getItem(plugin),
                1, wood, 2, wood, 3, wood,
                4, wood, 5, wood, 6, wood,
                7, wood, 8, wood, 9, wood);
    }

    // Enchanted Warped Stem GUI
    public static FormatRecipesGUI newEnchantedWarpedGUI(Plugin plugin) {
        ItemStack wood = new ItemStack(Material.WARPED_STEM, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_WARPED_STEM.getItem(plugin),
                1, wood, 2, wood, 3, wood,
                4, wood, 5, wood, 6, wood,
                7, wood, 8, wood, 9, wood);
    }

    // Enchanted End Stone GUI
    public static FormatRecipesGUI newEnchantedEndStoneGUI(Plugin plugin) {
        ItemStack end = new ItemStack(Material.END_STONE, 1);
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI3(plugin), Items.ENCHANTED_ENDSTONE.getItem(plugin),
                1, end, 2, end, 3, end,
                4, end, 5, end, 6, end,
                7, end, 8, end, 9, end);
    }

    // Aspect of The End GUI
    public static FormatRecipesGUI newAspectofTheEndGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new MaterialsSelectGUI2(plugin), Items.ASPECT_OF_THE_END.getItem(plugin),
                2, Items.ENCHANTED_ENDER_EYE.getItem(plugin),
                 5, Items.ENCHANTED_ENDER_EYE.getItem(plugin),
                 8, Items.ENCHANTED_DIAMOND.getItem(plugin));
    }

    // Pufferfish Canon GUI
    public static FormatRecipesGUI newPuferFishCanonGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new WeaponsSelectGUI(plugin), Items.PUFFERFISH_CANON.getItem(plugin),
                4, Items.ENCHANTED_IRON_BLOCK.getItem(plugin), 5, Items.ENCHANTED_PUFFERFISH.getItem(plugin), 6, Items.ENCHANTED_PUFFERFISH.getItem(plugin),
                7, Items.ALLOY.getItem(plugin), 8, Items.ALLOY.getItem(plugin), 9, Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin));
    }

    // Tnt Wand GUI
    public static FormatRecipesGUI newTntWandGUI(Plugin plugin) {
        return new FormatRecipesGUI(plugin, new WeaponsSelectGUI(plugin), Items.TNT_WAND.getItem(plugin),
                3, Items.ENCHANTED_TNT.getItem(plugin),
                5, Items.ALLOY.getItem(plugin),
                7, Items.ALLOY.getItem(plugin));
    }

    // Meat Cleaver GUI
    public static FormatRecipesGUI newMeatCleaverGUI(Plugin plugin) {
        ItemStack stick = new ItemStack(Material.STICK, 1);

        return new FormatRecipesGUI(plugin, new WeaponsSelectGUI(plugin), Items.MEAT_CLEAVER.getItem(plugin),
                2, Items.ENCHANTED_IRON.getItem(plugin), 3, Items.ENCHANTED_IRON.getItem(plugin),
                5, Items.ENCHANTED_IRON.getItem(plugin), 6, Items.ENCHANTED_IRON.getItem(plugin),
                8, stick);
    }

    // Meaty Stew GUI
    public static FormatRecipesGUI newMeatyStewGUI(Plugin plugin) {
        ItemStack bowl = new ItemStack(Material.BOWL, 1);

        return new FormatRecipesGUI(plugin, new MiscSelectGUI(plugin), Items.MEATY_STEW.getItem(plugin),
                1, Items.ENCHANTED_COOKED_COD.getItem(plugin), 2, Items.ENCHANTED_COOKED_SALMON.getItem(plugin), 3, Items.ENCHANTED_CHICKEN.getItem(plugin),
                4, Items.ENCHANTED_BEEF.getItem(plugin), 5, Items.ENCHANTED_RABBIT.getItem(plugin), 6, Items.ENCHANTED_MUTTON.getItem(plugin),
                8, bowl);
    }

    // Magic Stew GUI
    public static FormatRecipesGUI newMagicStewGUI(Plugin plugin) {
        ItemStack bowl = new ItemStack(Material.BOWL, 1);

        return new FormatRecipesGUI(plugin, new MiscSelectGUI(plugin), Items.MAGIC_STEW.getItem(plugin),
                1, Items.ENCHANTED_SPIDER_EYE.getItem(plugin), 2, Items.ENCHANTED_POPPED_CHORUS_FRUIT.getItem(plugin), 3, Items.ENCHANTED_QUARTZ_SCULPTURE.getItem(plugin),
                4, Items.ENCHANTED_ENDER_EYE.getItem(plugin), 5, Items.ENCHANTED_GLOW_SAC.getItem(plugin), 6, Items.ENCHANTED_POWDER_BALL.getItem(plugin),
                8, bowl);
    }
}