package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FormatRecipesGUI implements InventoryHolder {

    private Inventory main;
    private Inventory backArrow;

    public FormatRecipesGUI(

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
            main.setItem(i, ItemManager.menu_glass);
        }
        for (int i = 13; i < 19; i++) {
            main.setItem(i, ItemManager.menu_glass);
        }
        for (int i = 22; i < 28; i++) {
            main.setItem(i, ItemManager.menu_glass);
        }
        int[] trans = {10, 11, 12, 19, 20, 21, 28, 29, 30};
        main.setItem(trans[item1_index-1], item1);
        for (int itemIndex = 0; itemIndex < items.length; itemIndex += 2) {
            int item_index = (int) items[itemIndex];
            ItemStack item = (ItemStack) items[itemIndex + 1];
            main.setItem(trans[item_index - 1], item);
        }
        for (int i = 31; i < 54; i++) {
            main.setItem(i, ItemManager.menu_glass);
        }
        main.setItem(23, output);
        main.setItem(49, ItemManager.back_arrow);

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
    public static FormatRecipesGUI newDripRecipeGUI() {
        return new FormatRecipesGUI(new ArmorSelectGUI(), ItemManager.the_drip,
                4, ItemManager.edripstone, 6, ItemManager.edripstone,
                7, ItemManager.edripstone, 9, ItemManager.edripstone);
    }

    // Supreme Drip GUI
    public static FormatRecipesGUI newSupremeDripRecipeGUI() {
        return new FormatRecipesGUI(new ArmorSelectGUI(), ItemManager.the_driptm,
                1, ItemManager.edripstone, 2, ItemManager.edripstone, 3, ItemManager.edripstone,
                4, ItemManager.sedripstone, 5, ItemManager.the_drip, 6, ItemManager.sedripstone,
                7, ItemManager.sedripstone, 8, ItemManager.sedripstone, 9, ItemManager.sedripstone);
    }
    // Enchanted Dripstone GUI
    public static FormatRecipesGUI newEnchantedDripstoneGUI() {
        ItemStack dripstone = new ItemStack(Material.POINTED_DRIPSTONE, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.edripstone,
                2, dripstone, 4, dripstone,
                5, dripstone, 6, dripstone, 8, dripstone);
    }

    // Enchanted Dripstone Block GUI
    public static FormatRecipesGUI newsEnchantedDripstoneRecipeGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.sedripstone,
                1, ItemManager.edeepslate, 2, ItemManager.edripstone, 3, ItemManager.edeepslate,
                4, ItemManager.edripstone, 5, ItemManager.edripstone, 6, ItemManager.edripstone,
                7, ItemManager.edeepslate, 8, ItemManager.edripstone, 9, ItemManager.edeepslate);
    }

    // Enchanted Coal GUI
    public static FormatRecipesGUI newEnchantedCoalGUI() {
        ItemStack coal = new ItemStack(Material.COAL, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.ecoal,
                1,coal, 2, coal, 3, coal,
                4, coal, 6, coal,
                7, coal, 8, coal, 9, coal);
    }

    // Enchanted Coal Block GUI
    public static FormatRecipesGUI newsEnchantedCoalGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.secoal,
                1, ItemManager.ecoal, 2, ItemManager.ecoal, 3, ItemManager.ecoal,
                4, ItemManager.ecoal, 5, ItemManager.ecoal, 6, ItemManager.ecoal,
                7, ItemManager.ecoal, 8, ItemManager.ecoal, 9, ItemManager.ecoal);
    }

    // Enchanted Deepslate GUI
    public static FormatRecipesGUI newEnchantedDeepslateGUI() {
        ItemStack deepslate = new ItemStack(Material.DEEPSLATE, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.edeepslate,
                1,deepslate, 2, deepslate, 3, deepslate,
                4, deepslate, 5, deepslate, 6, deepslate,
                7, deepslate, 8, deepslate, 9, deepslate);
    }

    // Enchanted Polished Deepslate GUI
    public static FormatRecipesGUI newsEnchantedDeepslateGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.sedeepslate,
                1, ItemManager.edeepslate, 2, ItemManager.edeepslate, 3, ItemManager.edeepslate,
                4, ItemManager.edeepslate, 5, ItemManager.edeepslate, 6, ItemManager.edeepslate,
                7, ItemManager.edeepslate, 8, ItemManager.edeepslate, 9, ItemManager.edeepslate);
    }

    // Enchanted Deepslate Tiles GUI
    public static FormatRecipesGUI newvsEnchantedDeepslateGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.vsedeepslate,
                1, ItemManager.sedeepslate, 2, ItemManager.sedeepslate, 3, ItemManager.sedeepslate,
                4, ItemManager.sedeepslate, 5, ItemManager.sedeepslate, 6, ItemManager.sedeepslate,
                7, ItemManager.sedeepslate, 8, ItemManager.sedeepslate, 9, ItemManager.sedeepslate);
    }

    // Enchanted Bamboo GUI
    public static FormatRecipesGUI newEnchantedBambooGUI() {
        ItemStack bamboo = new ItemStack(Material.BAMBOO, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.ebamboo,
                1,bamboo, 2, bamboo, 3, bamboo,
                4, bamboo, 5, bamboo, 6, bamboo,
                7, bamboo, 8, bamboo, 9, bamboo);
    }

    // Enchanted Iron GUI
    public static FormatRecipesGUI newEnchantedIronGUI() {
        ItemStack iron = new ItemStack(Material.IRON_INGOT, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.eiron,
                1,iron, 2, iron, 3, iron,
                4, iron, 5, iron, 6, iron,
                7, iron, 8, iron, 9, iron);
    }

    // Enchanted Iron Block GUI
    public static FormatRecipesGUI newsEnchantedIronGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.seiron,
                1, ItemManager.eiron, 2, ItemManager.eiron, 3, ItemManager.eiron,
                4, ItemManager.eiron, 5, ItemManager.eiron, 6, ItemManager.eiron,
                7, ItemManager.eiron, 8, ItemManager.eiron, 9, ItemManager.eiron);
    }

    // Bamboo Bundle GUI
    public static FormatRecipesGUI newsEnchantedBambooGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.sebamboo,
                1, ItemManager.ebamboo, 2, ItemManager.ebamboo, 3, ItemManager.ebamboo,
                4, ItemManager.ebamboo, 5, ItemManager.ebamboo, 6, ItemManager.ebamboo,
                7, ItemManager.ebamboo, 8, ItemManager.ebamboo, 9, ItemManager.ebamboo);
    }

    // Enchanted Feather GUI
    public static FormatRecipesGUI newEnchantedFeatherGUI() {
        ItemStack feather = new ItemStack(Material.FEATHER, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.efeather,
                1,feather, 2, feather, 3, feather,
                4, feather, 5, feather, 6, feather,
                7, feather, 8, feather, 9, feather);
    }

    // Feather Charm GUI
    public static FormatRecipesGUI newfCharmGUI() {
        return new FormatRecipesGUI(new MiscSelectGUI(), ItemManager.fcharm,
                1, ItemManager.efeather, 2, ItemManager.efeather, 3, ItemManager.efeather,
                4, ItemManager.efeather, 6, ItemManager.efeather,
                7, ItemManager.efeather, 8, ItemManager.efeather, 9, ItemManager.efeather);
    }

    // Enchanted Phantom Membrane GUI
    public static FormatRecipesGUI newEnchantedMembraneGUI() {
        ItemStack membrane = new ItemStack(Material.PHANTOM_MEMBRANE, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.emembrane,
                1,membrane, 2, membrane, 3, membrane,
                4, membrane, 5, membrane, 6, membrane,
                7, membrane, 8, membrane, 9, membrane);
    }

    // Spectral Wings GUI
    public static FormatRecipesGUI newSpectralWingsGUI() {
        ItemStack elytra = new ItemStack(Material.ELYTRA, 1);
        return new FormatRecipesGUI(new ArmorSelectGUI(), ItemManager.sWings,
                2, ItemManager.emembrane,
                4, ItemManager.emembrane, 5, elytra, 6, ItemManager.emembrane,
                7, ItemManager.emembrane, 9, ItemManager.emembrane);
    }

    // Enchanted Gold GUI
    public static FormatRecipesGUI newEnchantedGoldGUI() {
        ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.egold,
                1,gold, 2, gold, 3, gold,
                4, gold, 5, gold, 6, gold,
                7, gold, 8, gold, 9, gold);
    }

    // Enchanted Gold Block GUI
    public static FormatRecipesGUI newsEnchantedGoldGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.segold,
                1, ItemManager.egold, 2, ItemManager.egold, 3, ItemManager.egold,
                4, ItemManager.egold, 5, ItemManager.egold, 6, ItemManager.egold,
                7, ItemManager.egold, 8, ItemManager.egold, 9, ItemManager.egold);
    }

    // Enchanted Sand GUI
    public static FormatRecipesGUI newEnchantedSandGUI() {
        ItemStack sand = new ItemStack(Material.SAND, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.esand,
                1,sand, 2, sand, 3, sand,
                4, sand, 5, sand, 6, sand,
                7, sand, 8, sand, 9, sand);
    }

    // Enchanted Compacted Sand GUI
    public static FormatRecipesGUI newsEnchantedSandGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.sesand,
                1, ItemManager.esand, 2, ItemManager.esand, 3, ItemManager.esand,
                4, ItemManager.esand, 5, ItemManager.esand, 6, ItemManager.esand,
                7, ItemManager.esand, 8, ItemManager.esand, 9, ItemManager.esand);
    }

    // Enchanted Sandstone GUI
    public static FormatRecipesGUI newvsEnchantedSandGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.vsesand,
                1, ItemManager.sesand, 2, ItemManager.sesand, 3, ItemManager.sesand,
                4, ItemManager.sesand, 5, ItemManager.sesand, 6, ItemManager.sesand,
                7, ItemManager.sesand, 8, ItemManager.sesand, 9, ItemManager.sesand);
    }

    // Enchanted Copper GUI
    public static FormatRecipesGUI newEnchantedCopperGUI() {
        ItemStack copper = new ItemStack(Material.COPPER_INGOT, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.ecopper,
                1,copper, 2, copper, 3, copper,
                4, copper, 6, copper,
                7, copper, 8, copper, 9, copper);
    }

    // Enchanted Copper Block GUI
    public static FormatRecipesGUI newsEnchantedCopperGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.secopper,
                1, ItemManager.ecopper, 2, ItemManager.ecopper, 3, ItemManager.ecopper,
                4, ItemManager.ecopper, 5, ItemManager.ecopper, 6, ItemManager.ecopper,
                7, ItemManager.ecopper, 8, ItemManager.ecopper, 9, ItemManager.ecopper);
    }

    // Enchanted Cut Copper Block GUI
    public static FormatRecipesGUI newvsEnchantedCopperGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.vsecopper,
                1, ItemManager.secopper, 2, ItemManager.secopper, 3, ItemManager.secopper,
                4, ItemManager.secopper, 5, ItemManager.secopper, 6, ItemManager.secopper,
                7, ItemManager.secopper, 8, ItemManager.secopper, 9, ItemManager.secopper);
    }

    // Enchanted Quartz GUI
    public static FormatRecipesGUI newEnchantedQuartzGUI() {
        ItemStack quartz = new ItemStack(Material.QUARTZ, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.equartz,
                1,quartz, 2, quartz, 3, quartz,
                4, quartz, 6, quartz,
                7, quartz, 8, quartz, 9, quartz);
    }

    // Enchanted Quartz Block GUI
    public static FormatRecipesGUI newsEnchantedQuartzGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.sequartz,
                1, ItemManager.equartz, 2, ItemManager.equartz, 3, ItemManager.equartz,
                4, ItemManager.equartz, 5, ItemManager.equartz, 6, ItemManager.equartz,
                7, ItemManager.equartz, 8, ItemManager.equartz, 9, ItemManager.equartz);
    }

    // Enchanted Quartz Sculpture GUI
    public static FormatRecipesGUI newvsEnchantedQuartzGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.vsequartz,
                1, ItemManager.sequartz, 2, ItemManager.sequartz, 3, ItemManager.sequartz,
                4, ItemManager.sequartz, 5, ItemManager.sequartz, 6, ItemManager.sequartz,
                7, ItemManager.sequartz, 8, ItemManager.sequartz, 9, ItemManager.sequartz);
    }

    // Enchanted Cobblestone GUI
    public static FormatRecipesGUI newEnchantedCobbleGUI() {
        ItemStack cobble = new ItemStack(Material.COBBLESTONE, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.ecobble,
                1,cobble, 2, cobble, 3, cobble,
                4, cobble, 5, cobble, 6, cobble,
                7, cobble, 8, cobble, 9, cobble);
    }

    // Enchanted Diamond GUI
    public static FormatRecipesGUI newEnchantedDiamondGUI() {
        ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.ediamond,
                1,diamond, 2, diamond, 3, diamond,
                4, diamond, 6, diamond,
                7, diamond, 8, diamond, 9, diamond);
    }

    // Enchanted Emerald GUI
    public static FormatRecipesGUI newEnchantedEmeraldGUI() {
        ItemStack emerald = new ItemStack(Material.EMERALD, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.eemerald,
                1,emerald, 2, emerald, 3, emerald,
                4, emerald, 6, emerald,
                7, emerald, 8, emerald, 9, emerald);
    }

    // Stone Saber GUI
    public static FormatRecipesGUI newStoneSaberGUI() {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        return new FormatRecipesGUI(new WeaponsSelectGUI(), ItemManager.stone_saber,
                3, ItemManager.ecobble,
                5, ItemManager.ecobble,
                7, stick);
    }

    // Iron Saber GUI
    public static FormatRecipesGUI newIronSaberGUI() {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        return new FormatRecipesGUI(new WeaponsSelectGUI(), ItemManager.iron_saber,
                3, ItemManager.eiron,
                5, ItemManager.eiron,
                7, stick);
    }

    // Golden Saber GUI
    public static FormatRecipesGUI newGoldSaberGUI() {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        return new FormatRecipesGUI(new WeaponsSelectGUI(), ItemManager.golden_saber,
                3, ItemManager.egold,
                5, ItemManager.egold,
                7, stick);
    }

    // Diamond Saber GUI
    public static FormatRecipesGUI newDiamondSaberGUI() {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        return new FormatRecipesGUI(new WeaponsSelectGUI(), ItemManager.diamond_saber,
                3, ItemManager.ediamond,
                5, ItemManager.ediamond,
                7, stick);
    }

    // Alloy GUI
    public static FormatRecipesGUI newAlloyGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.alloy,
                1,ItemManager.eiron, 2, ItemManager.ecopper, 3, ItemManager.eiron,
                4, ItemManager.ecopper, 5, ItemManager.eiron,  6, ItemManager.ecopper,
                7, ItemManager.eiron, 8, ItemManager.ecopper, 9, ItemManager.eiron);
    }

    // Enchanted Chicken GUI
    public static FormatRecipesGUI newEnchantedChickenGUI() {
        ItemStack chicken = new ItemStack(Material.CHICKEN, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.echicken,
                1,chicken, 2, chicken, 3, chicken,
                4, chicken, 5, chicken, 6, chicken,
                7, chicken, 8, chicken, 9, chicken);
    }

    // Enchanted Wool GUI
    public static FormatRecipesGUI newEnchantedWoolGUI() {
        ItemStack wool = new ItemStack(Material.WHITE_WOOL, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.ewool,
                1,wool, 2, wool, 3, wool,
                4, wool, 5, wool, 6, wool,
                7, wool, 8, wool, 9, wool);
    }

    // Enchanted Mutton GUI
    public static FormatRecipesGUI newEnchantedMuttonGUI() {
        ItemStack mutton = new ItemStack(Material.MUTTON, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.emutton,
                1,mutton, 2, mutton, 3, mutton,
                4, mutton, 5, mutton, 6, mutton,
                7, mutton, 8, mutton, 9, mutton);
    }

    // Enchanted Pork GUI
    public static FormatRecipesGUI newEnchantedPorkGUI() {
        ItemStack pork = new ItemStack(Material.PORKCHOP, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.epork,
                1,pork, 2, pork, 3, pork,
                4, pork, 5, pork, 6, pork,
                7, pork, 8, pork, 9, pork);
    }

    // Enchanted Beef GUI
    public static FormatRecipesGUI newEnchantedBeefGUI() {
        ItemStack beef = new ItemStack(Material.BEEF, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.ebeef,
                1,beef, 2, beef, 3, beef,
                4, beef, 5, beef, 6, beef,
                7, beef, 8, beef, 9, beef);
    }

    // Enchanted Rabbit GUI
    public static FormatRecipesGUI newEnchantedRabbitGUI() {
        ItemStack rabbit = new ItemStack(Material.BEEF, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.erabbit,
                1,rabbit, 2, rabbit, 3, rabbit,
                4, rabbit, 5, rabbit, 6, rabbit,
                7, rabbit, 8, rabbit, 9, rabbit);
    }

    // Enchanted Tropical Fish GUI
    public static FormatRecipesGUI newEnchantedClownGUI() {
        ItemStack clownfish = new ItemStack(Material.TROPICAL_FISH, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.eclown,
                1,clownfish, 2, clownfish, 3, clownfish,
                4, clownfish, 5, clownfish, 6, clownfish,
                7, clownfish, 8, clownfish, 9, clownfish);
    }

    // Enchanted Pufferfish GUI
    public static FormatRecipesGUI newEnchantedPufferGUI() {
        ItemStack pufferfish = new ItemStack(Material.PUFFERFISH, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.epuffer,
                1,pufferfish, 2, pufferfish, 3, pufferfish,
                4, pufferfish, 5, pufferfish, 6, pufferfish,
                7, pufferfish, 8, pufferfish, 9, pufferfish);
    }

    // Enchanted Cod GUI
    public static FormatRecipesGUI newEnchantedCodGUI() {
        ItemStack cod = new ItemStack(Material.COD, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.ecod,
                1,cod, 2, cod, 3, cod,
                4, cod, 5, cod, 6, cod,
                7, cod, 8, cod, 9, cod);
    }

    // Enchanted Cooked Cod GUI
    public static FormatRecipesGUI newsEnchantedCodGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.secod,
                1, ItemManager.ecod, 2, ItemManager.ecod, 3, ItemManager.ecod,
                4, ItemManager.ecod, 5, ItemManager.ecod, 6, ItemManager.ecod,
                7, ItemManager.ecod, 8, ItemManager.ecod, 9, ItemManager.ecod);
    }

    // Enchanted Salmon GUI
    public static FormatRecipesGUI newEnchantedSalmonGUI() {
        ItemStack salmon = new ItemStack(Material.SALMON, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.esalmon,
                1,salmon, 2, salmon, 3, salmon,
                4, salmon, 5, salmon, 6, salmon,
                7, salmon, 8, salmon, 9, salmon);
    }

    // Enchanted Cooked Salmon GUI
    public static FormatRecipesGUI newsEnchantedSalmonGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.sesalmon,
                1, ItemManager.esalmon, 2, ItemManager.esalmon, 3, ItemManager.esalmon,
                4, ItemManager.esalmon, 5, ItemManager.esalmon, 6, ItemManager.esalmon,
                7, ItemManager.esalmon, 8, ItemManager.esalmon, 9, ItemManager.esalmon);
    }

    // Enchanted Lapis GUI
    public static FormatRecipesGUI newEnchantedLapisGUI() {
        ItemStack lapis = new ItemStack(Material.LAPIS_LAZULI, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.elapis,
                1,lapis, 2, lapis, 3, lapis,
                4, lapis, 5, lapis, 6, lapis,
                7, lapis, 8, lapis, 9, lapis);
    }

    // Enchanted Lapis Block GUI
    public static FormatRecipesGUI newsEnchantedLapisGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.selapis,
                1, ItemManager.elapis, 2, ItemManager.elapis, 3, ItemManager.elapis,
                4, ItemManager.elapis, 5, ItemManager.elapis, 6, ItemManager.elapis,
                7, ItemManager.elapis, 8, ItemManager.elapis, 9, ItemManager.elapis);
    }

    // Enchanted Redstone GUI
    public static FormatRecipesGUI newEnchantedRedstoneGUI() {
        ItemStack redstone = new ItemStack(Material.REDSTONE, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI2(), ItemManager.eredstone,
                1,redstone, 2, redstone, 3, redstone,
                4, redstone, 5, redstone, 6, redstone,
                7, redstone, 8, redstone, 9, redstone);
    }

    // Enchanted Redstone Block GUI
    public static FormatRecipesGUI newsEnchantedRedstoneGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI2(), ItemManager.seredstone,
                1, ItemManager.eredstone, 2, ItemManager.eredstone, 3, ItemManager.eredstone,
                4, ItemManager.eredstone, 5, ItemManager.eredstone, 6, ItemManager.eredstone,
                7, ItemManager.eredstone, 8, ItemManager.eredstone, 9, ItemManager.eredstone);
    }

    // Enchanted Kelp GUI
    public static FormatRecipesGUI newEnchantedKelpGUI() {
        ItemStack kelp = new ItemStack(Material.KELP, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.ekelp,
                1,kelp, 2, kelp, 3, kelp,
                4, kelp, 5, kelp, 6, kelp,
                7, kelp, 8, kelp, 9, kelp);
    }

    // Enchanted Dried Kelp GUI
    public static FormatRecipesGUI newsEnchantedKelpGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.sekelp,
                1, ItemManager.ekelp, 2, ItemManager.ekelp, 3, ItemManager.ekelp,
                4, ItemManager.ekelp, 5, ItemManager.ekelp, 6, ItemManager.ekelp,
                7, ItemManager.ekelp, 8, ItemManager.ekelp, 9, ItemManager.ekelp);
    }

    // Enchanted Kelp Block GUI
    public static FormatRecipesGUI newvsEnchantedKelpGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI(), ItemManager.vsekelp,
                1, ItemManager.sekelp, 2, ItemManager.sekelp, 3, ItemManager.sekelp,
                4, ItemManager.sekelp, 5, ItemManager.sekelp, 6, ItemManager.sekelp,
                7, ItemManager.sekelp, 8, ItemManager.sekelp, 9, ItemManager.sekelp);
    }

    // Enchanted Netherite Scrap GUI
    public static FormatRecipesGUI newEnchantedNetheriteGUI() {
        ItemStack scrap = new ItemStack(Material.NETHERITE_SCRAP, 1);
        return new FormatRecipesGUI(new MaterialsSelectGUI2(), ItemManager.enetherite,
                2, scrap,
                4, scrap, 5, scrap, 6, scrap,
                8, scrap);
    }

    // Enchanted Netherite Ingot GUI
    public static FormatRecipesGUI newsEnchantedNetheriteGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI2(), ItemManager.senetherite,
                1, ItemManager.enetherite, 2, ItemManager.enetherite, 3, ItemManager.enetherite,
                4, ItemManager.enetherite, 6, ItemManager.egold,
                7, ItemManager.egold, 8, ItemManager.egold, 9, ItemManager.egold);
    }

    // Enchanted Netherite Block GUI
    public static FormatRecipesGUI newvsEnchantedNetheriteGUI() {
        return new FormatRecipesGUI(new MaterialsSelectGUI2(), ItemManager.vsenetherite,
                2, ItemManager.senetherite ,
                4, ItemManager.senetherite, 5, ItemManager.senetherite, 6, ItemManager.senetherite,
                8, ItemManager.senetherite);
    }
}