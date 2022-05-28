package its.wurm.testplugin.Inventories;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.persistentDataContainers.stringList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatSackGUI implements InventoryHolder {

    private Inventory main;
    private Inventory backArrow;
    private List<Object> elements;

    public FormatSackGUI(
            // Define the plugin
            Plugin plugin,
            // The GUI clicking the back arrow will return
            InventoryHolder back,
            // The player opening this menu
            Player player,
            // The items the sack will have
            List<ItemStack> items,
            // Define the name of the gui
            String name
    ) {
        // Define a main and create a gui
        main = Bukkit.createInventory(this, 36, name);
        String[] materials = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMaterial"), new stringList());
        int[] amounts = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackAmount"), PersistentDataType.INTEGER_ARRAY);
        int[] max = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMax"), PersistentDataType.INTEGER_ARRAY);
        ItemStack item;
        ItemMeta meta;
        String index;
        for (int h = 0; h < items.size(); h++) {
            item = items.get(h);
            index = item.getType().toString();
            meta = item.getItemMeta();
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "name"), PersistentDataType.STRING) != null) {
                index = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "name"), PersistentDataType.STRING);
            }
            meta.setLore(new ArrayList<>(Arrays.asList(ChatColor.YELLOW.toString() + amounts[Arrays.asList(materials).indexOf(index)] + "/" + ChatColor.GREEN + max[Arrays.asList(materials).indexOf(index)])));
            item.setItemMeta(meta);
            main.setItem(h, item);
        }
        for (int i = 27; i < 36; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        main.setItem(31, Items.BACK_ARROW.getItem(plugin));
        backArrow = back.getInventory();
        elements = new ArrayList<>(Arrays.asList(plugin, player, items));
    }

    @Override
    public Inventory getInventory() {
        return main;
    }

    public Inventory getBackArrow() {
        return backArrow;
    }

    public void reloadInventory() {
        Plugin plugin = (Plugin) elements.get(0);
        Player player = (Player) elements.get(1);
        List<ItemStack> items = (List<ItemStack>) elements.get(2);
        String[] materials = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMaterial"), new stringList());
        int[] amounts = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackAmount"), PersistentDataType.INTEGER_ARRAY);
        int[] max = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMax"), PersistentDataType.INTEGER_ARRAY);
        ItemStack item;
        ItemMeta meta;
        String index;
        for (int h = 0; h < items.size(); h++) {
            item = items.get(h);
            index = item.getType().toString();
            meta = item.getItemMeta();
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "name"), PersistentDataType.STRING) != null) {
                index = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "name"), PersistentDataType.STRING);
            }
            meta.setLore(new ArrayList<>(Arrays.asList(ChatColor.YELLOW.toString() + amounts[Arrays.asList(materials).indexOf(index)] + "/" + ChatColor.GREEN + max[Arrays.asList(materials).indexOf(index)])));
            item.setItemMeta(meta);
            main.setItem(h, item);
        }
        for (int i = 27; i < 36; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        main.setItem(31, Items.BACK_ARROW.getItem(plugin));
    }

    // Rock Sack GUI
    public static FormatSackGUI newRockSackGUI(Plugin plugin, InventoryHolder back, Player player) {
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.STONE));
        items.add(new ItemStack(Material.GRANITE));
        items.add(new ItemStack(Material.DIORITE));
        items.add(new ItemStack(Material.ANDESITE));
        items.add(new ItemStack(Material.DEEPSLATE));
        items.add(new ItemStack(Material.COBBLED_DEEPSLATE));
        items.add(new ItemStack(Material.CALCITE));
        items.add(new ItemStack(Material.TUFF));
        items.add(new ItemStack(Material.COBBLESTONE));
        items.add(new ItemStack(Material.DRIPSTONE_BLOCK));
        items.add(new ItemStack(Material.POINTED_DRIPSTONE));
        items.add(new ItemStack(Material.NETHERRACK));
        items.add(new ItemStack(Material.BASALT));
        items.add(new ItemStack(Material.POLISHED_BASALT));
        items.add(new ItemStack(Material.SMOOTH_BASALT));
        items.add(new ItemStack(Material.MAGMA_BLOCK));
        items.add(new ItemStack(Material.BLACKSTONE));
        items.add(new ItemStack(Material.OBSIDIAN));
        items.add(new ItemStack(Material.END_STONE));
        items.add(new ItemStack(Material.SANDSTONE));
        items.add(new ItemStack(Material.RED_SANDSTONE));
        return new FormatSackGUI(plugin, back, player, items, "Rock Sack");
    }

    // Mineral Sack GUI
    public static FormatSackGUI newMineralSackGUI(Plugin plugin, InventoryHolder back, Player player) {
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.COAL));
        items.add(new ItemStack(Material.DIAMOND));
        items.add(new ItemStack(Material.EMERALD));
        items.add(new ItemStack(Material.LAPIS_LAZULI));
        items.add(new ItemStack(Material.REDSTONE));
        items.add(new ItemStack(Material.QUARTZ));
        items.add(new ItemStack(Material.AMETHYST_BLOCK));
        items.add(new ItemStack(Material.AMETHYST_BLOCK));
        items.add(new ItemStack(Material.RAW_IRON));
        items.add(new ItemStack(Material.IRON_INGOT));
        items.add(new ItemStack(Material.RAW_COPPER));
        items.add(new ItemStack(Material.COPPER_INGOT));
        items.add(new ItemStack(Material.RAW_GOLD));
        items.add(new ItemStack(Material.GOLD_INGOT));
        items.add(new ItemStack(Material.GOLD_NUGGET));
        items.add(new ItemStack(Material.GLOWSTONE_DUST));
        items.add(new ItemStack(Material.ANCIENT_DEBRIS));
        items.add(new ItemStack(Material.NETHERITE_SCRAP));
        return new FormatSackGUI(plugin, back, player, items, "Mineral Sack");
    }

    // Lumber Sack GUI
    public static FormatSackGUI newLumberSackGUI(Plugin plugin, InventoryHolder back, Player player) {
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.OAK_LOG));
        items.add(new ItemStack(Material.SPRUCE_LOG));
        items.add(new ItemStack(Material.BIRCH_LOG));
        items.add(new ItemStack(Material.JUNGLE_LOG));
        items.add(new ItemStack(Material.ACACIA_LOG));
        items.add(new ItemStack(Material.DARK_OAK_LOG));
        items.add(new ItemStack(Material.CRIMSON_STEM));
        items.add(new ItemStack(Material.WARPED_STEM));
        items.add(new ItemStack(Material.OAK_LEAVES));
        items.add(new ItemStack(Material.SPRUCE_LEAVES));
        items.add(new ItemStack(Material.BIRCH_LEAVES));
        items.add(new ItemStack(Material.JUNGLE_LEAVES));
        items.add(new ItemStack(Material.ACACIA_LEAVES));
        items.add(new ItemStack(Material.DARK_OAK_LEAVES));
        items.add(new ItemStack(Material.WARPED_WART_BLOCK));
        items.add(new ItemStack(Material.NETHER_WART_BLOCK));
        items.add(new ItemStack(Material.RED_MUSHROOM_BLOCK));
        items.add(new ItemStack(Material.BROWN_MUSHROOM_BLOCK));
        items.add(new ItemStack(Material.MUSHROOM_STEM));
        items.add(new ItemStack(Material.SHROOMLIGHT));
        return new FormatSackGUI(plugin, back, player, items, "Lumber Sack");
    }

    // Foraging Sack GUI
    public static FormatSackGUI newForagingSackGUI(Plugin plugin, InventoryHolder back, Player player) {
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.RED_MUSHROOM));
        items.add(new ItemStack(Material.BROWN_MUSHROOM));
        items.add(new ItemStack(Material.BAMBOO));
        items.add(new ItemStack(Material.STICK));
        items.add(new ItemStack(Material.SWEET_BERRIES));
        items.add(new ItemStack(Material.GLOW_BERRIES));
        items.add(new ItemStack(Material.MOSS_BLOCK));
        items.add(new ItemStack(Material.CHORUS_FLOWER));
        items.add(new ItemStack(Material.CHORUS_FRUIT));
        items.add(new ItemStack(Material.APPLE));
        items.add(new ItemStack(Material.WARPED_FUNGUS));
        items.add(new ItemStack(Material.CRIMSON_FUNGUS));
        items.add(new ItemStack(Material.OAK_SAPLING));
        items.add(new ItemStack(Material.SPRUCE_SAPLING));
        items.add(new ItemStack(Material.BIRCH_SAPLING));
        items.add(new ItemStack(Material.JUNGLE_SAPLING));
        items.add(new ItemStack(Material.ACACIA_SAPLING));
        items.add(new ItemStack(Material.DARK_OAK_SAPLING));
        items.add(new ItemStack(Material.AZALEA));
        items.add(new ItemStack(Material.FLOWERING_AZALEA));
        items.add(new ItemStack(Material.SMALL_DRIPLEAF));
        items.add(new ItemStack(Material.BIG_DRIPLEAF));
        items.add(new ItemStack(Material.VINE));
        items.add(new ItemStack(Material.GLOW_LICHEN));
        return new FormatSackGUI(plugin, back, player, items, "Foraging Sack");
    }

    // Agriculture Sack GUI
    public static FormatSackGUI newAgricultureSackGUI(Plugin plugin, InventoryHolder back, Player player) {
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.CARROT));
        items.add(new ItemStack(Material.POTATO));
        items.add(new ItemStack(Material.BEETROOT));
        items.add(new ItemStack(Material.BEETROOT_SEEDS));
        items.add(new ItemStack(Material.WHEAT));
        items.add(new ItemStack(Material.WHEAT_SEEDS));
        items.add(new ItemStack(Material.MELON_SLICE));
        items.add(new ItemStack(Material.MELON));
        items.add(new ItemStack(Material.COCOA_BEANS));
        items.add(new ItemStack(Material.PUMPKIN));
        items.add(new ItemStack(Material.KELP));
        items.add(new ItemStack(Material.SUGAR_CANE));
        items.add(new ItemStack(Material.CACTUS));
        items.add(new ItemStack(Material.NETHER_WART));
        return new FormatSackGUI(plugin, back, player, items, "Agriculture Sack");
    }

    // Husbandry Sack GUI
    public static FormatSackGUI newHusbandrySackGUI(Plugin plugin, InventoryHolder back, Player player) {
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.CHICKEN));
        items.add(new ItemStack(Material.FEATHER));
        items.add(new ItemStack(Material.EGG));
        items.add(new ItemStack(Material.BEEF));
        items.add(new ItemStack(Material.LEATHER));
        items.add(new ItemStack(Material.PORKCHOP));
        items.add(new ItemStack(Material.WHITE_WOOL));
        items.add(new ItemStack(Material.MUTTON));
        items.add(new ItemStack(Material.RABBIT));
        items.add(new ItemStack(Material.RABBIT_FOOT));
        items.add(new ItemStack(Material.RABBIT_HIDE));
        items.add(new ItemStack(Material.SCUTE));
        items.add(new ItemStack(Material.TURTLE_EGG));
        items.add(new ItemStack(Material.HONEY_BOTTLE));
        items.add(new ItemStack(Material.HONEYCOMB));
        return new FormatSackGUI(plugin, back, player, items, "Husbandry Sack");
    }

    // Cryptozoology Sack GUI
    public static FormatSackGUI newCryptozoologySackGUI(Plugin plugin, InventoryHolder back, Player player) {
        ItemStack item;
        ItemMeta meta;
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.STRING));
        items.add(new ItemStack(Material.SPIDER_EYE));
        items.add(new ItemStack(Material.ROTTEN_FLESH));
        items.add(new ItemStack(Material.BONE));
        items.add(new ItemStack(Material.BONE_BLOCK));
        items.add(new ItemStack(Material.GUNPOWDER));
        items.add(new ItemStack(Material.SLIME_BALL));
        item = new ItemStack(Material.BEEF);
        meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"name"), PersistentDataType.STRING, "Monster Meat");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"number"), PersistentDataType.INTEGER, 129);
        meta.setDisplayName(ChatColor.WHITE + "Monster Meat");
        item.setItemMeta(meta);
        items.add(item);
        item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmFmZmNkYjA3MjkyYjY2ODY3MzYyM2NlNjNhNjEzZjQ1NzFlZjg1YzFlZmM5MjVmYTJmOGYyZmY4OTUzMzg1OSJ9fX0=");
        meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"name"), PersistentDataType.STRING, "Pulsing Tumor");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"number"), PersistentDataType.INTEGER, 119);
        meta.setDisplayName(ChatColor.GREEN + "Pulsing Tumor");
        item.setItemMeta(meta);
        items.add(item);
        return new FormatSackGUI(plugin, back, player, items, "Cryptozoology Sack");
    }

    // Demonology Sack GUI
    public static FormatSackGUI newDemonologySackGUI(Plugin plugin, InventoryHolder back, Player player) {
        ItemStack item;
        ItemMeta meta;
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.BLAZE_ROD));
        items.add(new ItemStack(Material.GHAST_TEAR));
        items.add(new ItemStack(Material.BLAZE_POWDER));
        items.add(new ItemStack(Material.MAGMA_CREAM));
        item = new ItemStack(Material.LEATHER);
        meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"name"), PersistentDataType.STRING, "Hide");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"number"), PersistentDataType.INTEGER, 125);
        meta.setDisplayName(ChatColor.GREEN + "Hide");
        item.setItemMeta(meta);
        items.add(item);
        return new FormatSackGUI(plugin, back, player, items, "Demonology Sack");
    }

    // Xenoarchaeology Sack GUI
    public static FormatSackGUI newXenoarchaeologySackGUI(Plugin plugin, InventoryHolder back, Player player) {
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.ENDER_PEARL));
        items.add(new ItemStack(Material.ENDER_EYE));
        items.add(new ItemStack(Material.SHULKER_SHELL));
        items.add(new ItemStack(Material.PHANTOM_MEMBRANE));
        return new FormatSackGUI(plugin, back, player, items, "Xenoarchaeology Sack");
    }

    // Fishing Sack GUI
    public static FormatSackGUI newFishingSackGUI(Plugin plugin, InventoryHolder back, Player player) {
        ItemStack item;
        ItemMeta meta;
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.COD));
        items.add(new ItemStack(Material.SALMON));
        items.add(new ItemStack(Material.TROPICAL_FISH));
        items.add(new ItemStack(Material.PUFFERFISH));
        items.add(new ItemStack(Material.NAUTILUS_SHELL));
        items.add(new ItemStack(Material.INK_SAC));
        items.add(new ItemStack(Material.GLOW_INK_SAC));
        item = new ItemStack(Material.PRISMARINE_SHARD);
        meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"name"), PersistentDataType.STRING, "Seastone Shard");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"number"), PersistentDataType.INTEGER, 154);
        meta.setDisplayName(ChatColor.GREEN + "Seastone Shard");
        item.setItemMeta(meta);
        items.add(item);
        return new FormatSackGUI(plugin, back, player, items, "Fishing Sack");
    }

    // Excavating Sack GUI
    public static FormatSackGUI newExcavatingSackGUI(Plugin plugin, InventoryHolder back, Player player) {
        ItemStack item;
        ItemMeta meta;
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.SAND));
        items.add(new ItemStack(Material.RED_SAND));
        items.add(new ItemStack(Material.SOUL_SAND));
        items.add(new ItemStack(Material.SOUL_SOIL));
        items.add(new ItemStack(Material.FLINT));
        items.add(new ItemStack(Material.GRAVEL));
        items.add(new ItemStack(Material.SNOWBALL));
        items.add(new ItemStack(Material.SNOW));
        items.add(new ItemStack(Material.PODZOL));
        items.add(new ItemStack(Material.MYCELIUM));
        items.add(new ItemStack(Material.GRASS_BLOCK));
        items.add(new ItemStack(Material.DIRT));
        items.add(new ItemStack(Material.COARSE_DIRT));
        items.add(new ItemStack(Material.ROOTED_DIRT));
        item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTM0ZDhiZGU5ODU3ZDg3MmU1MjEyNGQ5OTgyMTU0Y2YzZDI4Yjc3MDJmYmFjZDE5ODMzYzUxMWZlNmMxY2RmNSJ9fX0=");
        meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"name"), PersistentDataType.STRING, "Mud Ball");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"number"), PersistentDataType.INTEGER, 134);
        meta.setDisplayName(ChatColor.GREEN + "Mud Ball");
        item.setItemMeta(meta);
        items.add(item);
        items.add(new ItemStack(Material.CLAY_BALL));
        items.add(new ItemStack(Material.CLAY));
        return new FormatSackGUI(plugin, back, player, items, "Excavating Sack");
    }
}
