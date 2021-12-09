package its.wurm.testplugin.Items;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

//c:beginning, c:start

public class ItemManager implements Listener {

    static Main plugin;

    public ItemManager(Main plugin) { this.plugin = plugin;}


    public static ItemStack edripstone;
    //The Drip
    public static ItemStack the_drip;
    //Dev Hammer
    public static ItemStack edeepslate;
    //Emchanted Polished Deepslate
    public static ItemStack sedeepslate;
    //Emchanted Deepslate Tiles
    public static ItemStack vsedeepslate;
    //Enchanted Block Of Dripstone
    public static ItemStack sedripstone;
    //The Drip™
    public static ItemStack the_driptm;
    //Enchanted Coal
    public static ItemStack ecoal;
    //Enchanted Coal Block
    public static ItemStack secoal;
    //Menu Glass
    public static ItemStack menu_glass;
    //Back Arrow
    public static ItemStack back_arrow;
    //Enchanted Iron
    public static ItemStack eiron;
    //Enchanted Iron Block
    public static ItemStack seiron;
    //Rookie Shovel
    //Enchanted Bamboo
    public static ItemStack ebamboo;
    //Moon Glove
    public static ItemStack moon_glove;
    //Aspect of the end
    public static ItemStack aote;
    //Bamboo Bundle
    public static ItemStack sebamboo;
    //Tomato
    public static ItemStack tomato;
    //Lesser Wand of Healing
    public static ItemStack lheal_wand;
    //Enchanted Feather
    public static ItemStack efeather;
    //Enchanted Feather
    public static ItemStack fcharm;
    //Enchanted Phantom Membrane
    public static ItemStack emembrane;
    //Spectral Wings
    public static ItemStack sWings;
    //Echo Stone
    public static ItemStack echostone;
    //Enchanted Gold
    public static ItemStack egold;
    //Enchanted Gold Block
    public static ItemStack segold;
    //Enchanted Sand
    public static ItemStack esand;
    //Enchanted Compacted Sand
    public static ItemStack sesand;
    //Enchanted Sandstone
    public static ItemStack vsesand;
    //Enchanted Copper
    public static ItemStack ecopper;
    //Enchanted Copper Block
    public static ItemStack secopper;
    //Enchanted Cut Copper Block
    public static ItemStack vsecopper;
    //Enchanted Quartz
    public static ItemStack equartz;
    //Enchanted Quartz Block
    public static ItemStack sequartz;
    //Enchanted Quartz Sculpture
    public static ItemStack vsequartz;
    //Sower's Will
    public static ItemStack sower_contract;
    //Iron Scimitar
    public static ItemStack iron_saber;
    //Alloy
    public static ItemStack alloy;
    //Enchanted Cobblestone
    public static ItemStack ecobble;
    //Enchanted Diamond
    public static ItemStack ediamond;
    //Enchanted Emerald
    public static ItemStack eemerald;
    //Stone Scimitar
    public static ItemStack stone_saber;
    //Gold Scimitar
    public static ItemStack golden_saber;
    //Diamond Scimitar
    public static ItemStack diamond_saber;
    //Enchanted Lapis
    public static ItemStack elapis;
    //Enchanted Lapis Block
    public static ItemStack selapis;
    //Enchanted Redstone
    public static ItemStack eredstone;
    //Enchanted Redstone Block
    public static ItemStack seredstone;
    //Enchanted Wool
    public static ItemStack ewool;
    //Enchanted Mutton
    public static ItemStack emutton;
    //Enchanted Chicken
    public static ItemStack echicken;
    //Enchanted Beef
    public static ItemStack ebeef;
    //Enchanted Pork
    public static ItemStack epork;
    //Enchanted Rabbit
    public static ItemStack erabbit;
    //Enchanted Tropical Fish
    public static ItemStack eclown;
    //Enchanted Pufferfish
    public static ItemStack epuffer;
    //Enchanted Cod
    public static ItemStack ecod;
    //Enchanted Cooked Cod
    public static ItemStack secod;
    //Enchanted Salmon
    public static ItemStack esalmon;
    //Enchanted Cooked Salmon
    public static ItemStack sesalmon;
    //Enchanted Kelp
    public static ItemStack ekelp;
    //Enchanted Dried Kelp
    public static ItemStack sekelp;
    //Enchanted Kelp Block
    public static ItemStack vsekelp;
    //Enchanted Netherite Scrap
    public static ItemStack enetherite;
    //Enchanted Netherite Ingot
    public static ItemStack senetherite;
    //Enchanted Netherite Ingot
    public static ItemStack vsenetherite;
    //Next Page Arrow
    public static ItemStack next_arrow;
    //Previous Page Arrow
    public static ItemStack last_arrow;
    //Pufferfish Canon
    public static ItemStack puffer_gun;
    //Alloy Helmet
    public static ItemStack alloy_helmet;
    //Alloy Chestplate
    public static ItemStack alloy_chestplate;
    //Alloy Leggings
    public static ItemStack alloy_legs;
    //Alloy Boots
    public static ItemStack alloy_boots;
    //Netherite Saber
    public static ItemStack netherite_saber;
    //Test Shortbow
    public static ItemStack test_shortbow;



    public static void init() {
        create_e_dripstone();
        create_the_drip();
        create_e_deepslate();
        create_se_deepslate();
        create_se_dripstone();
        create_vse_deepslate();
        create_the_driptm();
        create_e_coal();
        create_se_coal();
        create_menu();
        create_back_arrow();
        create_e_iron();
        create_e_bamboo();
        create_moon_glove();
        create_se_iron();
        create_se_bamboo();
        create_tomato();
        create_lheal_wand();
        create_e_feather();
        create_fcharm();
        create_e_membrane();
        create_spectral_wings();
        create_echo_stone();
        create_e_gold();
        create_se_gold();
        create_e_sand();
        create_se_sand();
        create_vse_sand();
        create_e_copper();
        create_se_copper();
        create_vse_copper();
        create_e_quartz();
        create_se_quartz();
        create_vse_quartz();
        create_sower_contract();
        create_iron_saber();
        create_alloy();
        create_e_cobble();
        create_e_diamond();
        create_e_emerald();
        create_stone_saber();
        create_gold_saber();
        create_diamond_saber();
        create_e_wool();
        create_e_mutton();
        create_e_chicken();
        create_e_pork();
        create_e_beef();
        create_e_clown();
        create_e_puffer();
        create_e_rabbit();
        create_e_cod();
        create_se_cod();
        create_e_salmon();
        create_se_salmon();
        create_e_kelp();
        create_se_kelp();
        create_vse_kelp();
        create_e_redstone();
        create_se_redstone();
        create_e_lapis();
        create_se_lapis();
        create_e_netherite();
        create_se_netherite();
        create_vse_netherite();
        create_next_arrow();
        create_last_arrow();
        create_puffer_canon();
        create_alloy_helmet();
        create_alloy_chestplate();
        create_alloy_leggings();
        create_alloy_boots();
        create_netherite_saber();
        create_test_shortbow();

    }

    // This is Fire Ball Name
    public static ItemStack createItem1() {
        ItemStack testItem = new ItemStack(Material.FIRE_CHARGE, 1);
        ItemMeta meta = testItem.getItemMeta();
        meta.setDisplayName("§cFire Ball Name");
        List<String> lore = new ArrayList<>();
        lore.add("§c§lSPECIAL");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        testItem.setItemMeta(meta);

        // Shaped Recipe for Fire Ball Name
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("testitem_s"), testItem);
        sr.shape("S S",
                 " F ",
                 "S S");
        sr.setIngredient('S', Material.STICK);
        sr.setIngredient('F', Material.FIRE_CHARGE);
        Bukkit.getServer().addRecipe(sr);

        // Shapeless Recipe for Fire Ball Name
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("testitem_sl"), testItem);
        slr.addIngredient(1, Material.BLAZE_ROD);
        slr.addIngredient(1, Material.COAL_BLOCK);
        slr.addIngredient(1, Material.FIREWORK_STAR);
        Bukkit.getServer().addRecipe(slr);

        // Furnace Recipe for Fire Ball Name
        FurnaceRecipe fr = new FurnaceRecipe(NamespacedKey.minecraft("testitem_f"), testItem,
                Material.FIRE_CHARGE, 20.0f, 40);
        Bukkit.getServer().addRecipe(fr);

        return testItem;
    }

    //This is Dev Hammer
    public static ItemStack createDevHammer() {
        ItemStack devHammer = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta meta = devHammer.getItemMeta();
        meta.setDisplayName("§cDev Hammer");
        List<String> lore = new ArrayList<>();
        lore.add("§7Down any mob in one hit with this mighty weapon");
        lore.add(" ");
        lore.add("§c§lSPECIAL");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Dev Hammer");
        devHammer.setItemMeta(meta);

        return devHammer;
    }

    //This is Menu Glass
    private static void create_menu() {
        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        menu_glass = item;
    }

    //This is Back Arrow
    private static void create_back_arrow() {
        ItemStack item = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Go Back");
        item.setItemMeta(meta);
        back_arrow = item;
    }

    //This is Back Arrow
    private static void create_next_arrow() {
        ItemStack item = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Next Page");
        item.setItemMeta(meta);
        next_arrow = item;
    }

    //This is Previous Arrow
    private static void create_last_arrow() {
        ItemStack item = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Previous Page");
        item.setItemMeta(meta);
        last_arrow = item;
    }



//---------------------------------MATERIALS SECTION c:mat--------------------------------------------------------------

    //This is Enchanted Dripstone
    private static void create_e_dripstone() {
        ItemStack item = new ItemStack(Material.POINTED_DRIPSTONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Dripstone");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        edripstone = item;

        // Shapeless Recipe for Enchanted Dripstone
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_dripstone_sl"), item);
        slr.addIngredient(5, Material.POINTED_DRIPSTONE);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Deepslate
    private static void create_e_deepslate() {
        ItemStack item = new ItemStack(Material.DEEPSLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Deepslate");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        edeepslate = item;

        // Shapeless Recipe 1 for Enchanted Deepslate
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_deepslate1_sl"), item);
        slr.addIngredient(9, Material.DEEPSLATE);
        Bukkit.getServer().addRecipe(slr);

        // Shapeless Recipe 2 for Enchanted Deepslate
        ShapelessRecipe slr1 = new ShapelessRecipe(NamespacedKey.minecraft("e_deepslate2_sl"), item);
        slr1.addIngredient(9, Material.COBBLED_DEEPSLATE);
        Bukkit.getServer().addRecipe(slr1);
    }

    //This is Enchanted Polished Deepslate
    private static void create_se_deepslate() {
        ItemStack item = new ItemStack(Material.POLISHED_DEEPSLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Polished Deepslate");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        sedeepslate = item;

        // Shaped Recipe for Enchanted Polished Deepslate
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_deepslate"), item);
        sr.shape("DDD",
                 "DDD",
                 "DDD");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(edeepslate));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Deepslate Tiles
    private static void create_vse_deepslate() {
        ItemStack item = new ItemStack(Material.DEEPSLATE_TILES, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Enchanted Deepslate Tiles");
        List<String> lore = new ArrayList<>();
        lore.add("§5§lEPIC");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        vsedeepslate = item;

        // Shaped Recipe for Enchanted Deepslate Tiles
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_vsedeepslate"), item);
        sr.shape("DDD",
                 "DDD",
                 "DDD");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(sedeepslate));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Block Of Dripstone
    private static void create_se_dripstone() {
        ItemStack item = new ItemStack(Material.DRIPSTONE_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Dripstone Block");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        sedripstone = item;

        // Shaped Recipe for Enchanted Dripstone Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_dripstone"), item);
        sr.shape("DdD",
                 "ddd",
                 "DdD");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(edeepslate));
        sr.setIngredient('d', new RecipeChoice.ExactChoice(edripstone));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Iron
    private static void create_e_iron() {
        ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Iron");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        eiron = item;

        // Shapeless Recipe for Enchanted Iron
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_iron_sl"), item);
        slr.addIngredient(8, Material.IRON_INGOT);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Iron Block
    private static void create_se_iron() {
        ItemStack item = new ItemStack(Material.IRON_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Iron Block");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        seiron = item;

        //Shaped recipe for Enchanted Iron Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_iron_s"), item);
        sr.shape("III",
                 "III",
                 "III");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(eiron));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Coal
    private static void create_e_coal() {
        ItemStack item = new ItemStack(Material.COAL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Coal");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ecoal = item;

        //Less recipe for Enchanted Coal
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_coal_sl"), item);
        slr.addIngredient(8, Material.COAL);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Coal Block
    private static void create_se_coal() {
        ItemStack item = new ItemStack(Material.COAL_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Coal Block");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        secoal = item;

        //Shaped recipe for Enchanted Coal Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_coal_s"), item);
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(ecoal));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Bamboo
    private static void create_e_bamboo() {
        ItemStack item = new ItemStack(Material.BAMBOO, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Bamboo");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ebamboo = item;

        // Shapeless Recipe for Enchanted Bamboo
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_bamboo_sl"), item);
        slr.addIngredient(9, Material.BAMBOO);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Bamboo Bundle
    private static void create_se_bamboo() {
        ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGVlODRkNmYyZGJkZjdhM2M5MTlmNzdlYzIyZTZlZTI2NjFlMDE3M2E4YTk3MWUxMWM5ODAwMjIzNGU2NDE3ZiJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Bamboo Bundle");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        item.setItemMeta(meta);
        sebamboo = item;

        //Shaped recipe for Enchanted Coal Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_bamboo_s"), item);
        sr.shape("BBB",
                 "BBB",
                 "BBB");
        sr.setIngredient('B', new RecipeChoice.ExactChoice(ebamboo));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Feather
    private static void create_e_feather() {
        ItemStack item = new ItemStack(Material.FEATHER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Feather");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        efeather = item;

        // Shapeless Recipe for Enchanted Feather
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_feather_sl"), item);
        slr.addIngredient(9, Material.FEATHER);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Phantom Membrane
    private static void create_e_membrane() {
        ItemStack item = new ItemStack(Material.PHANTOM_MEMBRANE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Phantom Membrane");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        emembrane = item;

        // Shapeless Recipe for Enchanted Phantom Membrane
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_membrane_sl"), item);
        slr.addIngredient(9, Material.PHANTOM_MEMBRANE);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Gold
    private static void create_e_gold() {
        ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Gold");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        egold = item;

        // Shapeless Recipe for Enchanted Gold
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_gold_sl"), item);
        slr.addIngredient(8, Material.GOLD_INGOT);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Gold Block
    private static void create_se_gold() {
        ItemStack item = new ItemStack(Material.GOLD_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Gold Block");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        segold = item;

        //Shaped recipe for Enchanted Gold Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_gold_s"), item);
        sr.shape("GGG",
                 "GGG",
                 "GGG");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(egold));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Sand
    private static void create_e_sand() {
        ItemStack item = new ItemStack(Material.SAND, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Sand");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        esand = item;

        // Shapeless Recipe for Enchanted Sand
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_sand_sl"), item);
        slr.addIngredient(9, Material.SAND);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Compacted Sand
    private static void create_se_sand() {
        ItemStack item = new ItemStack(Material.SMOOTH_SANDSTONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Compacted Sand");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        sesand = item;

        //Shaped recipe for Enchanted Compacted Sand
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_sand_s"), item);
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(esand));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Sandstone
    private static void create_vse_sand() {
        ItemStack item = new ItemStack(Material.SANDSTONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Enchanted Sandstone");
        List<String> lore = new ArrayList<>();
        lore.add("§5§lEPIC");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        vsesand = item;

        //Shaped recipe for Enchanted Sandstone
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("vse_sand_s"), item);
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(sesand));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Copper
    private static void create_e_copper() {
        ItemStack item = new ItemStack(Material.COPPER_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Copper");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ecopper = item;

        // Shapeless Recipe for Enchanted Copper
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_copper_sl"), item);
        slr.addIngredient(8, Material.COPPER_INGOT);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Copper Block
    private static void create_se_copper() {
        ItemStack item = new ItemStack(Material.COPPER_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Copper Block");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        secopper = item;

        //Shaped recipe for Enchanted Copper Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_copper_s"), item);
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(ecopper));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Cut Copper Block
    private static void create_vse_copper() {
        ItemStack item = new ItemStack(Material.CUT_COPPER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Enchanted Cut Copper Block");
        List<String> lore = new ArrayList<>();
        lore.add("§5§lEPIC");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        vsecopper = item;

        //Shaped recipe for Enchanted Cut Copper Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("vse_copper_s"), item);
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(secopper));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Quartz
    private static void create_e_quartz() {
        ItemStack item = new ItemStack(Material.QUARTZ, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Quartz");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        equartz = item;

        // Shapeless Recipe for Enchanted Quartz
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_quartz_sl"), item);
        slr.addIngredient(8, Material.QUARTZ);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Quartz Block
    private static void create_se_quartz() {
        ItemStack item = new ItemStack(Material.QUARTZ_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Quartz Block");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        sequartz = item;

        //Shaped recipe for Enchanted Quartz Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_quartz_s"), item);
        sr.shape("QQQ",
                 "QQQ",
                 "QQQ");
        sr.setIngredient('Q', new RecipeChoice.ExactChoice(equartz));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Quartz Sculpture
    private static void create_vse_quartz() {
        ItemStack item = new ItemStack(Material.CHISELED_QUARTZ_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Enchanted Quartz Sculpture");
        List<String> lore = new ArrayList<>();
        lore.add("§5§lEPIC");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        vsequartz = item;

        //Shaped recipe for Enchanted Cut Copper Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("vse_quartz_s"), item);
        sr.shape("QQQ",
                 "QQQ",
                 "QQQ");
        sr.setIngredient('Q', new RecipeChoice.ExactChoice(sequartz));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Alloy
    private static void create_alloy() {
        ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aAlloy");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        item.setItemMeta(meta);
        alloy = item;

        //Shaped recipe for Alloy
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_s"), item);
        sr.shape("CIC",
                 "ICI",
                 "CIC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(eiron));
        sr.setIngredient('I', new RecipeChoice.ExactChoice(ecopper));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Cobblestone
    private static void create_e_cobble() {
        ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Cobblestone");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
       ecobble = item;

        // Shapeless Recipe for Enchanted Cobblestone
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_cobble_sl"), item);
        slr.addIngredient(9, Material.COBBLESTONE);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Diamond
    private static void create_e_diamond() {
        ItemStack item = new ItemStack(Material.DIAMOND, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Diamond");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ediamond = item;

        // Shapeless Recipe for Enchanted Diamond
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_diamond_sl"), item);
        slr.addIngredient(8, Material.DIAMOND);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Emerald
    private static void create_e_emerald() {
        ItemStack item = new ItemStack(Material.EMERALD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Emerald");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        eemerald = item;

        // Shapeless Recipe for Enchanted Emerald
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_emerald_sl"), item);
        slr.addIngredient(8, Material.EMERALD);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Wool
    private static void create_e_wool() {
        ItemStack item = new ItemStack(Material.WHITE_WOOL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Wool");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ewool = item;

        // Shapeless Recipe for Enchanted Wool
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_wool_sl"), item);
        slr.addIngredient(9, Material.WHITE_WOOL);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Mutton
    private static void create_e_mutton() {
        ItemStack item = new ItemStack(Material.MUTTON, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Mutton");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        emutton = item;

        // Shapeless Recipe for Enchanted Mutton
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_mutton_sl"), item);
        slr.addIngredient(9, Material.MUTTON);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Chicken
    private static void create_e_chicken() {
        ItemStack item = new ItemStack(Material.CHICKEN, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Chicken");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        echicken = item;

        // Shapeless Recipe for Enchanted Chicken
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_chicken_sl"), item);
        slr.addIngredient(9, Material.CHICKEN);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Beef
    private static void create_e_beef() {
        ItemStack item = new ItemStack(Material.BEEF, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Beef");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ebeef = item;

        // Shapeless Recipe for Enchanted Beef
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_beef_sl"), item);
        slr.addIngredient(9, Material.BEEF);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Pork
    private static void create_e_pork() {
        ItemStack item = new ItemStack(Material.PORKCHOP, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Pork");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        epork = item;

        // Shapeless Recipe for Enchanted Pork
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_pork_sl"), item);
        slr.addIngredient(9, Material.PORKCHOP);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Rabbit
    private static void create_e_rabbit() {
        ItemStack item = new ItemStack(Material.RABBIT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Rabbit");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        erabbit = item;

        // Shapeless Recipe for Enchanted Rabbit
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_rabbit_sl"), item);
        slr.addIngredient(9, Material.RABBIT);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Tropic Fish
    private static void create_e_clown() {
        ItemStack item = new ItemStack(Material.TROPICAL_FISH, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Rabbit");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        eclown = item;

        // Shapeless Recipe for Enchanted Tropical Fish
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_clown_sl"), item);
        slr.addIngredient(9, Material.TROPICAL_FISH);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Pufferfish
    private static void create_e_puffer() {
        ItemStack item = new ItemStack(Material.PUFFERFISH, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Pufferfish");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        epuffer = item;

        // Shapeless Recipe for Enchanted Pufferfish
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_puffer_sl"), item);
        slr.addIngredient(9, Material.PUFFERFISH);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Cod
    private static void create_e_cod() {
        ItemStack item = new ItemStack(Material.COD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Cod");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ecod = item;

        // Shapeless Recipe for Enchanted Cod
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_cod_sl"), item);
        slr.addIngredient(9, Material.COD);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Cooked Cod
    private static void create_se_cod() {
        ItemStack item = new ItemStack(Material.COOKED_COD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Cooked Cod");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        secod = item;

        // Shapeless Recipe for Enchanted Cooked Cod
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_cod_s"), item);
        sr.shape("CCC",
                 "CCC",
                 "CCC");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(ecod));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Salmon
    private static void create_e_salmon() {
        ItemStack item = new ItemStack(Material.SALMON, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Salmon");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        esalmon = item;

        // Shapeless Recipe for Enchanted Salmon
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_salmon_sl"), item);
        slr.addIngredient(9, Material.SALMON);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Cooked Salmon
    private static void create_se_salmon() {
        ItemStack item = new ItemStack(Material.COOKED_SALMON, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Cooked Salmon");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        sesalmon = item;

        // Shapeless Recipe for Enchanted Cooked Salmon
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_salmon_s"), item);
        sr.shape("SSS",
                 "SSS",
                 "SSS");
        sr.setIngredient('S', new RecipeChoice.ExactChoice(esalmon));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Kelp
    private static void create_e_kelp() {
        ItemStack item = new ItemStack(Material.KELP, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Kelp");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ekelp = item;

        // Shapeless Recipe for Enchanted Kelp
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_kelp_sl"), item);
        slr.addIngredient(9, Material.KELP);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Dried Kelp
    private static void create_se_kelp() {
        ItemStack item = new ItemStack(Material.DRIED_KELP, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Dried Kelp");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        sekelp = item;

        // Shapeless Recipe for Enchanted Dried Kelp
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_kelp_s"), item);
        sr.shape("KKK",
                 "KKK",
                 "KKK");
        sr.setIngredient('K', new RecipeChoice.ExactChoice(ekelp));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Kelp Block
    private static void create_vse_kelp() {
        ItemStack item = new ItemStack(Material.DRIED_KELP_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Enchanted Kelp Block");
        List<String> lore = new ArrayList<>();
        lore.add("§5§lEPIC");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        vsekelp = item;

        // Shapeless Recipe for Enchanted Kelp Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("vse_kelp_s"), item);
        sr.shape("KKK",
                 "KKK",
                 "KKK");
        sr.setIngredient('K', new RecipeChoice.ExactChoice(sekelp));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Lapis
    private static void create_e_lapis() {
        ItemStack item = new ItemStack(Material.LAPIS_LAZULI, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Lapis");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        elapis = item;

        // Shapeless Recipe for Enchanted Redstone
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_lapis_sl"), item);
        slr.addIngredient(8, Material.LAPIS_LAZULI);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Lapis Block
    private static void create_se_lapis() {
        ItemStack item = new ItemStack(Material.LAPIS_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Lapis Block");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        selapis = item;

        // Shapeless Recipe for Enchanted Lapis Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_lapis_s"), item);
        sr.shape("LLL",
                 "LLL",
                 "LLL");
        sr.setIngredient('L', new RecipeChoice.ExactChoice(elapis));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Redstone
    private static void create_e_redstone() {
        ItemStack item = new ItemStack(Material.REDSTONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Redstone");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        eredstone = item;

        // Shapeless Recipe for Enchanted Redstone
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_redstone_sl"), item);
        slr.addIngredient(8, Material.REDSTONE);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Redstone Block
    private static void create_se_redstone() {
        ItemStack item = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Redstone Block");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        seredstone = item;

        // Shapeless Recipe for Enchanted Redstone Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_redstone_s"), item);
        sr.shape("RRR",
                 "RRR",
                 "RRR");
        sr.setIngredient('R', new RecipeChoice.ExactChoice(eredstone));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Kelp
    private static void create_e_netherite() {
        ItemStack item = new ItemStack(Material.NETHERITE_SCRAP, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Netherite Scrap");
        List<String> lore = new ArrayList<>();
        lore.add("§a§lUNCOMMON");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        enetherite = item;

        // Shapeless Recipe for Enchanted Netherite Scrap
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("e_netherite_sl"), item);
        slr.addIngredient(5, Material.NETHERITE_SCRAP);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Enchanted Netherite Ingot
    private static void create_se_netherite() {
        ItemStack item = new ItemStack(Material.NETHERITE_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Enchanted Netherite Ingot");
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        senetherite = item;

        // Shapeless Recipe for Enchanted Netherite Ingot
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("se_netherite_s"), item);
        sr.shape("NNN",
                 "N G",
                 "GGG");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(enetherite));
        sr.setIngredient('G', new RecipeChoice.ExactChoice(egold));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Enchanted Netherite Block
    private static void create_vse_netherite() {
        ItemStack item = new ItemStack(Material.NETHERITE_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Enchanted Netherite Block");
        List<String> lore = new ArrayList<>();
        lore.add("§5§lEPIC");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        vsenetherite = item;

        // Shapeless Recipe for Enchanted Netherite Block
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("vse_netherite_s"), item);
        sr.shape(" N ",
                 "NNN",
                 " N ");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(senetherite));
        Bukkit.getServer().addRecipe(sr);
    }


//-------------------------------------------MISC SECTION c:item, c:misc------------------------------------------------

    //This is Tomato
    private static void create_tomato() {
        ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQyNDlmNDhjNWMwMjUzZGI2N2U5MWM3ZDJhNzc0NTVmOTMwOTM4OGJlNTBmOGQ4NWQ0NzE4ZTYyYzkifX19");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aTomato");
        List<String> lore = new ArrayList<>();
        lore.add("§7§oOh cool, a tomato!");
        lore.add("§a§lUNCOMMON TROPHY");
        meta.setLore(lore);
        item.setItemMeta(meta);
        tomato = item;
    }

    //This is Feather Charm
    private static void create_fcharm() {
        ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZmMzNiMjk3YTk4MWI1MjdiZWMzOTMxNjg0MDFkOGEyZWNhZGViOWYxNjAzYmE1ZTI3NmY0MmQ2NDQ3NTExNiJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Feather Charm");
        List<String> lore = new ArrayList<>();
        lore.add("§7Crouch to slow your decent");
        lore.add(" ");
        lore.add("§9§lRARE");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Feather Charm");
        meta.setLore(lore);
        item.setItemMeta(meta);
        fcharm = item;

        //Shaped recipe for Feather Charm
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("fcharm_s"), item);
        sr.shape("FFF",
                 "F F",
                 "FFF");
        sr.setIngredient('F', new RecipeChoice.ExactChoice(efeather));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Echo Stone
    private static void create_echo_stone() {
        ItemStack item = new ItemStack(Material.LAPIS_LAZULI, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Echo Stone");
        List<String> lore = new ArrayList<>();
        lore.add("§6Item Ability: Echo " + "§e§lRIGHT-CLICK");
        lore.add("§7Teleport to your last " + "§becho ward");
        lore.add("§7if you have one available.");
        lore.add(" ");
        lore.add("§6Item Ability: Echo Ward " + "§e§lSHIFT");
        lore.add("§7Place an " + "§becho ward" + "§7 at");
        lore.add("§7your location. " + "§bEcho wards");
        lore.add("§7are removed when you change");
        lore.add("§7dimension, die, log out, or after");
        lore.add("§a30s" + "§7 have passed");
        lore.add(" ");
        lore.add("§9§lRARE");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Echo Stone");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        echostone = item;

    }

    //This is Sower's Will
    private static void create_sower_contract() {
        ItemStack item = new ItemStack(Material.FILLED_MAP, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Sower's Will");
        List<String> lore = new ArrayList<>();
        lore.add("§7One of the minions of a mighty");
        lore.add("§7necromancer, this farmhand's work");
        lore.add("§7still continues after death");
        lore.add(" ");
        lore.add("§5§lEPIC");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Sower's Will");
        meta.setLore(lore);
        item.setItemMeta(meta);
        sower_contract = item;
    }

    //This is Nutri Bar
    private static void create_nutri_bar() {
        ItemStack item = new ItemStack(Material.BRICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Nutri Bar");
        List<String> lore = new ArrayList<>();
        lore.add("§7Can be eaten to get a good");
        lore.add("§7saturation boost for a minute");
        lore.add("§7or two.");
        lore.add(" ");
        lore.add("§9§lRARE");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Nutri Bar");
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

//----------------------------------------WEAPONS SECTION c:weapons-----------------------------------------------------
    //This is Moon Glove
    private static void create_moon_glove() {
        ItemStack item = new ItemStack(Material.CHORUS_FLOWER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Moon Glove");
        List<String> lore = new ArrayList<>();
        lore.add("§7This glove can manipulate gravity");
        lore.add("§7and send enemies you hit flying.");
        lore.add(" ");
        lore.add("§5§lEPIC SWORD");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 100.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Moon Glove");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "sword");
        meta.setLore(lore);
        item.setItemMeta(meta);
        moon_glove = item;
    }

    //This is Pufferfish Canon
    private static void create_puffer_canon() {
        ItemStack item = new ItemStack(Material.IRON_HORSE_ARMOR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§9Pufferfish Canon");
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();
        lore.add("§eItem Ability: Puffy Projectile" + " §6§l§lRIGHT-CLICK");
        lore.add("§7Launch a pufferfish");
        lore.add(" ");
        lore.add("§9§lRARE WAND");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Pufferfish Canon");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "wand");
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setLore(lore);
        item.setItemMeta(meta);
       puffer_gun = item;
    }

    //This is Aspect of The End
    private static void create_aote() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§9Aspect of The End");
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();
        lore.add("§eItem Ability: Instant Transmission" + " §6§l§lRIGHT-CLICK");
        lore.add("§7Teleport forward 8 blocks.");
        lore.add(" ");
        lore.add("§9§lRARE SWORD");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Aspect of The End");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "sword");
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setLore(lore);
        item.setItemMeta(meta);
        aote = item;
    }

    //This is Lesser Wand of Healing
    private static void create_lheal_wand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aLesser Wand of Healing");
        List<String> lore = new ArrayList<>();
        lore.add("§eItem Ability: Minor Heal " + "§6§lRIGHT-CLICK");
        lore.add("§7Heal for 8 hearts.");
        lore.add("§8Cooldown: " + "§a8s");
        lore.add(" ");
        lore.add("§a§lUNCOMMON WAND");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Lesser Heal Wand");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "wand");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        lheal_wand = item;

        // Shapeless Recipe for Lesser Healing Wand
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("lheal_wand_sl"), item);
        slr.addIngredient(2, Material.STICK);
        Bukkit.getServer().addRecipe(slr);
    }

    //This is Stone Scimitar
    private static void create_stone_saber() {
        ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§aStone Scimitar");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: " + "§c+25");
        lore.add("§7Strength: " + "§c+15");
        lore.add(" ");
        lore.add("§a§lUNCOMMON SWORD");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 25.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 15.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "sword");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Stone Scimitar");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        stone_saber = item;

        //Shaped recipe for Stone Scimitar
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("stone_scimitar_s"), item);
        sr.shape("  C",
                 " C ",
                 "S  ");
        sr.setIngredient('C', new RecipeChoice.ExactChoice(ecobble));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Iron Scimitar
    private static void create_iron_saber() {
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§aIron Scimitar");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: " + "§c+20");
        lore.add("§7Crit Chance: " + "§c+10");
        lore.add("§7Crit Damage: " + "§c+20");
        lore.add(" ");
        lore.add("§a§lUNCOMMON SWORD");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 20.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"CC"), PersistentDataType.DOUBLE, 10.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 20.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "sword");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Iron Scimitar");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        iron_saber = item;

        //Shaped recipe for Iron Scimitar
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("iron_scimitar_s"), item);
        sr.shape("  I",
                 " I ",
                 "S  ");
        sr.setIngredient('I', new RecipeChoice.ExactChoice(eiron));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Gold Scimitar
    private static void create_gold_saber() {
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§aGolden Scimitar");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: " + "§c+15");
        lore.add("§7Crit Damage: " + "§c+15");
        lore.add(" ");
        lore.add("§a§lUNCOMMON SWORD");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 15.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 15.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Gold Scimitar");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "sword");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        golden_saber = item;

        //Shaped recipe for Gold Scimitar
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("gold_scimitar_s"), item);
        sr.shape("  G",
                " G ",
                "S  ");
        sr.setIngredient('G', new RecipeChoice.ExactChoice(egold));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Diamond Scimitar
    private static void create_diamond_saber() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§aDiamond Scimitar");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: " + "§c+40");
        lore.add("§7Crit Damage: " + "§c+25");
        lore.add("§7Strength: " + "§c+25");
        lore.add(" ");
        lore.add("§a§lUNCOMMON SWORD");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 40.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Crit"), PersistentDataType.DOUBLE, 25.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "sword");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Diamond Scimitar");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        diamond_saber = item;

        //Shaped recipe for Diamond Scimitar
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("diamond_scimitar_s"), item);
        sr.shape("  D",
                " D ",
                "S  ");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(ediamond));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Netherite Scimitar
    private static void create_netherite_saber() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§aNetherite Scimitar");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: " + "§c+60");
        lore.add("§7Strength: " + "§c+25");
        lore.add(" ");
        lore.add("§a§lUNCOMMON SWORD");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 60.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "sword");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Netherite Scimitar");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        netherite_saber = item;

        //Shaped recipe for Netherite Scimitar
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("netherite_scimitar_s"), item);
        sr.shape("  N",
                 " N ",
                 "S  ");
        sr.setIngredient('N', new RecipeChoice.ExactChoice(enetherite));
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Test Shortbow
    private static void create_test_shortbow() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§cTest Shortbow");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§c§lSPECIAL BOW");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Damage"), PersistentDataType.DOUBLE, 666.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "bow");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Test Shortbow");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        test_shortbow = item;

        //Shaped recipe for Test Shortbow
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("test_bow_s"), item);
        sr.shape("  S",
                 " S ",
                 "S  ");
        sr.setIngredient('S', Material.STRING);
        Bukkit.getServer().addRecipe(sr);
    }
//------------------------------------------ARMOR SECTION c:armor-------------------------------------------------------

    //This is The Drip
    private static void create_the_drip() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
        leatherArmorMeta.setColor(Color.fromBGR(94,175,184));
        meta.setDisplayName("§9The Drip");
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();
        lore.add("§9§lRARE BOOTS");
        meta.setLore(lore);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "The Drip");
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        the_drip = item;

        //Shaped recipe for The Drip
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("the_drip_s"), item);
        sr.shape("   ",
                 "D D",
                 "D D");
        sr.setIngredient('D', new RecipeChoice.ExactChoice(edripstone));
        Bukkit.getServer().addRecipe(sr);
    }


    //This is The Drip™
    private static void create_the_driptm() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
        leatherArmorMeta.setColor(Color.fromBGR(70,126,133));
        meta.setDisplayName("§5Supreme Drip™");
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();
        lore.add("§5§lEPIC BOOTS");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Supreme Drip™");

        item.setItemMeta(meta);
        the_driptm = item;

        //Shaped recipe for The Drip™
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("the_driptm_s"), item);
        sr.shape("AAA",
                 "DBD",
                 "DDD");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(edripstone));
        sr.setIngredient('B', new RecipeChoice.ExactChoice(the_drip));
        sr.setIngredient('D', new RecipeChoice.ExactChoice(sedripstone));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Spectral Wings
    private static void create_spectral_wings() {
        ItemStack item = new ItemStack(Material.ELYTRA, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§5Spectral Wings");
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();
        lore.add("§7Gain a huge burst of " + "§fSpeed");
        lore.add("§7when you land from a glide.");
        lore.add(" ");
        lore.add("§5§lEPIC CHESTPLATE");
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setLore(lore);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Spectral Wings");
        item.setItemMeta(meta);
        sWings = item;

        //Shaped recipe for Spectral Wings
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("spectral_wings_s"), item);
        sr.shape(" P ",
                 "PEP",
                 "P P");
        sr.setIngredient('P', new RecipeChoice.ExactChoice(emembrane));
        sr.setIngredient('E', Material.ELYTRA);
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Alloy Helmet
    private static void create_alloy_helmet() {
        ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§9Alloy Helmet");
        List<String> lore = new ArrayList<>();
        lore.add("§7Health: " + "§c+15");
        lore.add("§7Defense: " + "§c+25");
        lore.add("§7Strength: " + "§c+5");
        lore.add(" ");
        lore.add("§9§lRARE HELMET");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 15.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 35.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 25.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "armor");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Helmet");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        alloy_helmet = item;

        //Shaped recipe for Alloy Helmet
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_helm_s"), item);
        sr.shape("AAA",
                 "A A",
                 "   ");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(alloy));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Alloy Chestplate
    private static void create_alloy_chestplate() {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§9Alloy Chestplate");
        List<String> lore = new ArrayList<>();
        lore.add("§7Health: " + "§c+30");
        lore.add("§7Defense: " + "§c+60");
        lore.add("§7Strength: " + "§c+15");
        lore.add(" ");
        lore.add("§9§lRARE CHESTPLATE");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 30.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 60.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 15.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "armor");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Chestplate");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        alloy_chestplate = item;

        //Shaped recipe for Alloy Chestplate
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_chest_s"), item);
        sr.shape("A A",
                 "AAA",
                 "AAA");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(alloy));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Alloy Leggings
    private static void create_alloy_leggings() {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§9Alloy Leggings");
        List<String> lore = new ArrayList<>();
        lore.add("§7Health: " + "§c+25");
        lore.add("§7Defense: " + "§c+45");
        lore.add("§7Strength: " + "§c+10");
        lore.add(" ");
        lore.add("§9§lRARE LEGGINGS");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 25.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 45.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 10.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "armor");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Leggings");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        alloy_legs = item;

        //Shaped recipe for Alloy Leggings
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_legs_s"), item);
        sr.shape("AAA",
                 "A A",
                 "A A");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(alloy));
        Bukkit.getServer().addRecipe(sr);
    }

    //This is Alloy Boots
    private static void create_alloy_boots() {
        ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§9Alloy Boots");
        List<String> lore = new ArrayList<>();
        lore.add("§7Health: " + "§c+10");
        lore.add("§7Defense: " + "§c+25");
        lore.add("§7Strength: " + "§c+5");
        lore.add(" ");
        lore.add("§9§lRARE BOOTS");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Health"), PersistentDataType.DOUBLE, 10.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Defense"), PersistentDataType.DOUBLE, 25.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Strength"), PersistentDataType.DOUBLE, 5.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"Type"), PersistentDataType.STRING, "armor");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING, "Alloy Boots");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
      alloy_boots = item;

        //Shaped recipe for Alloy Boots
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("alloy_boots_s"), item);
        sr.shape("   ",
                 "A A",
                 "A A");
        sr.setIngredient('A', new RecipeChoice.ExactChoice(alloy));
        Bukkit.getServer().addRecipe(sr);
    }
}

//c:end