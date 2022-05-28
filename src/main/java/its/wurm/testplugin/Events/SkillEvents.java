package its.wurm.testplugin.Events;

import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Mobs.Mobs;
import its.wurm.testplugin.persistentDataContainers.stringList;
import its.wurm.testplugin.statFunctions.StatFunctions;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.SerializationUtils;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class SkillEvents implements Listener {


    Plugin plugin;
    StatFunctions functions;

    public SkillEvents(Plugin plugin) {
        this.plugin = plugin;
        this.functions = new StatFunctions(plugin, null);
    }

    Map<UUID, PlayerSkillData> skills = new HashMap<>();

    public class SkillData implements Serializable {
         int level = 0;
         double xp = 0.0;
         double xpNext = 10.0;
    }


    public class PlayerSkillData implements Serializable {

        SkillData mining = new SkillData();
        SkillData farming = new SkillData();
        SkillData foraging = new SkillData();
        SkillData excavating = new SkillData();
        SkillData combat = new SkillData();

    }

    public void SaveSkillData() {
        try {
            FileOutputStream file = new FileOutputStream("Skills.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(skills);

            out.close();
            file.close();

        }
        catch(IOException ex)
        {
            System.out.println("Say good bye to everyone's skill xp :(");
        }
    }

    public void SkillLoadData() {
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("Skills.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            skills = (HashMap)in.readObject();

            in.close();
            file.close();
        }

        catch(IOException ex)
        {
            System.out.println("Didn't load skill data (so sorry)");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("What are you asking for again?");
        }
    }

    public void doubleDrop(Player player, Block block) {

        if (!(block.getMetadata("placed").isEmpty())) {
            return;
        }

        double fortuneMine = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE);
        double fortuneFarm = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE);
        double fortuneExc = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE)/100) + 1;

        Random random = new Random();
        PlayerSkillData csd = skills.get(player.getUniqueId());
        List<ItemStack> loot = (List) block.getDrops();
        if (loot.isEmpty()) {
            return;
        }

        ItemStack pet = null;
        if (functions.getPets().get(player) != null) {
            pet = functions.getPets().get(player);
        }
        String main = "";
        List<Object> mainEnchant = new ArrayList<>();
        String off = "";
        List<Object> offEnchant = new ArrayList<>();
        String helmet = "";
        List<Object> helmetEnchant = new ArrayList<>();
        String chest = "";
        List<Object> chestEnchant = new ArrayList<>();
        String legs = "";
        List<Object> legsEnchant = new ArrayList<>();
        String boots = "";
        List<Object> bootsEnchant = new ArrayList<>();

        if (player.getInventory().getItemInMainHand() != null &&
            player.getInventory().getItemInMainHand().getItemMeta() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
            main = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            mainEnchant.add(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                    new stringList()));
            mainEnchant.add(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                    PersistentDataType.INTEGER_ARRAY));

        }

        if (player.getInventory().getItemInOffHand() != null &&
            player.getInventory().getItemInOffHand().getItemMeta() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
            off = player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            offEnchant.add(player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                    new stringList()));
            offEnchant.add(player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                    PersistentDataType.INTEGER_ARRAY));
        }

        if (player.getInventory().getHelmet() != null &&
            player.getInventory().getHelmet().getItemMeta() != null &&
            player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
            helmet = player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            helmetEnchant.add(player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                    new stringList()));
            helmetEnchant.add(player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                    PersistentDataType.INTEGER_ARRAY));
        }

        if (player.getInventory().getChestplate() != null &&
            player.getInventory().getChestplate().getItemMeta() != null &&
            player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
            chest = player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            chestEnchant.add(player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                    new stringList()));
            chestEnchant.add(player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                    PersistentDataType.INTEGER_ARRAY));
        }

        if (player.getInventory().getLeggings() != null &&
            player.getInventory().getLeggings().getItemMeta() != null &&
            player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
            legs = player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            legsEnchant.add(player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                    new stringList()));
            legsEnchant.add(player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                    PersistentDataType.INTEGER_ARRAY));
        }

        if (player.getInventory().getBoots() != null &&
            player.getInventory().getBoots().getItemMeta() != null &&
            player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
            boots = player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            bootsEnchant.add(player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                    new stringList()));
            bootsEnchant.add(player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                    PersistentDataType.INTEGER_ARRAY));
        }

        ItemStack item = new ItemStack(loot.get(0).getType(), loot.get(0).getAmount());
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        switch (item.getType()) {
            case EMERALD:
            case DIAMOND:
            case ANCIENT_DEBRIS:
                lore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON");
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
                break;
            default:
                lore.add(ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON");
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "COMMON");
                break;
        }

        if (pet != null &&
            pet.hasItemMeta()) {
            switch (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "Cow":
                    if (block.getType() == Material.WHEAT) {
                        switch (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                                PersistentDataType.STRING)) {
                            case "MYTHIC":
                            case "LEGENDARY":
                                fortuneFarm += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .5;
                                break;
                            case "EPIC":
                                fortuneFarm += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .35;
                                break;
                            case "RARE":
                                fortuneFarm += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .25;
                                break;
                            case "UNCOMMON":
                                fortuneFarm += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .15;
                                break;
                            default:
                                fortuneFarm += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .1;
                                break;
                        }
                    }

                    if (block.getType() == Material.GRASS_BLOCK) {
                        switch (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                                PersistentDataType.STRING)) {
                            case "MYTHIC":
                            case "LEGENDARY":
                                fortuneExc += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .6;
                                break;
                            case "EPIC":
                                fortuneExc += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .42;
                                break;
                            case "RARE":
                                fortuneExc += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .3;
                                break;
                            case "UNCOMMON":
                                fortuneExc += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .18;
                                break;
                            default:
                                fortuneExc += pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                        PersistentDataType.INTEGER) * .12;
                                break;
                        }
                    }
                    break;
            }
        }
        meta.setLore(lore);
        if (mainEnchant.size() > 0 && Arrays.asList((String[])mainEnchant.get(0)).indexOf("Smelt") != -1) {
            boolean smelt = false;
            if ((item.getType() == Material.RAW_COPPER ||
                item.getType() == Material.RAW_COPPER_BLOCK ||
                item.getType() == Material.RAW_IRON ||
                item.getType() == Material.RAW_IRON_BLOCK ||
                item.getType() == Material.RAW_GOLD ||
                item.getType() == Material.RAW_GOLD_BLOCK ||
                item.getType() == Material.ANCIENT_DEBRIS) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[0] == 1) {
                smelt = true;
            }
            if ((item.getType() == Material.OAK_WOOD ||
                item.getType() == Material.OAK_LOG ||
                item.getType() == Material.STRIPPED_OAK_WOOD ||
                item.getType() == Material.STRIPPED_OAK_LOG ||
                item.getType() == Material.DARK_OAK_WOOD ||
                item.getType() == Material.DARK_OAK_LOG ||
                item.getType() == Material.STRIPPED_DARK_OAK_WOOD ||
                item.getType() == Material.STRIPPED_DARK_OAK_LOG ||
                item.getType() == Material.BIRCH_WOOD ||
                item.getType() == Material.BIRCH_LOG ||
                item.getType() == Material.STRIPPED_BIRCH_WOOD ||
                item.getType() == Material.STRIPPED_BIRCH_LOG ||
                item.getType() == Material.ACACIA_WOOD ||
                item.getType() == Material.ACACIA_LOG ||
                item.getType() == Material.STRIPPED_ACACIA_WOOD ||
                item.getType() == Material.STRIPPED_ACACIA_LOG ||
                item.getType() == Material.SPRUCE_WOOD ||
                item.getType() == Material.SPRUCE_LOG ||
                item.getType() == Material.STRIPPED_SPRUCE_WOOD ||
                item.getType() == Material.STRIPPED_SPRUCE_LOG ||
                item.getType() == Material.JUNGLE_WOOD ||
                item.getType() == Material.JUNGLE_LOG ||
                item.getType() == Material.STRIPPED_JUNGLE_WOOD ||
                item.getType() == Material.STRIPPED_JUNGLE_LOG) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[1] == 1) {
                smelt = true;
            }
            if ((item.getType() == Material.CLAY ||
                item.getType() == Material.YELLOW_TERRACOTTA ||
                item.getType() == Material.BLACK_TERRACOTTA ||
                item.getType() == Material.BLUE_TERRACOTTA ||
                item.getType() == Material.BROWN_TERRACOTTA ||
                item.getType() == Material.CYAN_TERRACOTTA ||
                item.getType() == Material.GRAY_TERRACOTTA ||
                item.getType() == Material.GREEN_TERRACOTTA ||
                item.getType() == Material.LIGHT_BLUE_TERRACOTTA ||
                item.getType() == Material.LIGHT_GRAY_TERRACOTTA ||
                item.getType() == Material.LIME_GLAZED_TERRACOTTA ||
                item.getType() == Material.MAGENTA_TERRACOTTA ||
                item.getType() == Material.ORANGE_TERRACOTTA ||
                item.getType() == Material.PINK_TERRACOTTA ||
                item.getType() == Material.PURPLE_TERRACOTTA ||
                item.getType() == Material.RED_TERRACOTTA ||
                item.getType() == Material.WHITE_TERRACOTTA) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[2] == 1) {
                smelt = true;
            }
            if ((item.getType() == Material.SAND ||
                item.getType() == Material.RED_SAND) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[3] == 1) {
                smelt = true;
            }
            if ((item.getType() == Material.CHORUS_FRUIT) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[4] == 1) {
                smelt = true;
            }
            if ((item.getType() == Material.COBBLESTONE ||
                item.getType() == Material.COBBLESTONE_STAIRS ||
                item.getType() == Material.COBBLESTONE_SLAB ||
                item.getType() == Material.SANDSTONE ||
                item.getType() == Material.SANDSTONE_SLAB ||
                item.getType() == Material.SANDSTONE_STAIRS ||
                item.getType() == Material.RED_SANDSTONE ||
                item.getType() == Material.RED_SANDSTONE_SLAB ||
                item.getType() == Material.RED_SANDSTONE_STAIRS ||
                item.getType() == Material.QUARTZ_BLOCK ||
                item.getType() == Material.QUARTZ_SLAB ||
                item.getType() == Material.QUARTZ_STAIRS ||
                item.getType() == Material.STONE ||
                item.getType() == Material.STONE_SLAB ||
                item.getType() == Material.STONE_STAIRS ||
                item.getType() == Material.COBBLED_DEEPSLATE ||
                item.getType() == Material.DEEPSLATE ||
                item.getType() == Material.NETHER_BRICKS ||
                item.getType() == Material.BASALT ||
                item.getType() == Material.STONE_BRICKS ||
                item.getType() == Material.POLISHED_BLACKSTONE_BRICKS ||
                item.getType() == Material.DEEPSLATE_BRICKS ||
                item.getType() == Material.DEEPSLATE_TILES) &&
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                        PersistentDataType.INTEGER_ARRAY)[5] == 1) {
                smelt = true;
            }
            if (item.getType() == Material.NETHERRACK &&
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                        PersistentDataType.INTEGER_ARRAY)[6] == 1) {
                smelt = true;
            }
            if ((item.getType() == Material.CACTUS ||
                item.getType() == Material.KELP) &&
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                        PersistentDataType.INTEGER_ARRAY)[7] == 1) {
                smelt = true;
            }
            if (item.getType() == Material.WET_SPONGE &&
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                        PersistentDataType.INTEGER_ARRAY)[8] == 1) {
                smelt = true;
            }
            if (item.getType() == Material.SEA_PICKLE &&
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                        PersistentDataType.INTEGER_ARRAY)[9] == 1) {
                smelt = true;
            }

            if (smelt) {
                switch (item.getType()) {
                    case RAW_COPPER:
                        item.setType(Material.COPPER_INGOT);
                        break;
                    case RAW_COPPER_BLOCK:
                        item.setType(Material.COPPER_BLOCK);
                        break;
                    case RAW_IRON:
                        item.setType(Material.IRON_INGOT);
                        break;
                    case RAW_IRON_BLOCK:
                        item.setType(Material.IRON_BLOCK);
                        break;
                    case RAW_GOLD:
                        item.setType(Material.GOLD_INGOT);
                        break;
                    case RAW_GOLD_BLOCK:
                        item.setType(Material.GOLD_BLOCK);
                        break;
                    case ANCIENT_DEBRIS:
                        item.setType(Material.NETHERITE_SCRAP);
                        break;
                    case SAND:
                    case RED_SAND:
                        item.setType(Material.GLASS);
                        break;
                    case CLAY:
                        item.setType(Material.TERRACOTTA);
                        break;
                    case NETHERRACK:
                        item.setType(Material.NETHER_BRICK);
                        break;
                    case COBBLESTONE:
                        item.setType(Material.STONE);
                        break;
                    case COBBLESTONE_SLAB:
                        item.setType(Material.STONE_SLAB);
                        break;
                    case COBBLESTONE_STAIRS:
                        item.setType(Material.STONE_STAIRS);
                        break;
                    case STONE:
                        item.setType(Material.SMOOTH_STONE);
                        break;
                    case STONE_SLAB:
                        item.setType(Material.SMOOTH_STONE_SLAB);
                        break;
                    case QUARTZ_BLOCK:
                        item.setType(Material.SMOOTH_QUARTZ);
                        break;
                    case QUARTZ_SLAB:
                        item.setType(Material.SMOOTH_QUARTZ_SLAB);
                        break;
                    case QUARTZ_STAIRS:
                        item.setType(Material.SMOOTH_QUARTZ_STAIRS);
                        break;
                    case NETHER_BRICKS:
                        item.setType(Material.CRACKED_NETHER_BRICKS);
                        break;
                    case BASALT:
                        item.setType(Material.SMOOTH_BASALT);
                        break;
                    case STONE_BRICKS:
                        item.setType(Material.CRACKED_STONE_BRICKS);
                        break;
                    case COBBLED_DEEPSLATE:
                        item.setType(Material.DEEPSLATE);
                        break;
                    case DEEPSLATE_BRICKS:
                        item.setType(Material.CRACKED_DEEPSLATE_BRICKS);
                        break;
                    case DEEPSLATE_TILES:
                        item.setType(Material.CRACKED_DEEPSLATE_TILES);
                        break;
                    case SANDSTONE:
                        item.setType(Material.SMOOTH_SANDSTONE);
                        break;
                    case SANDSTONE_SLAB:
                        item.setType(Material.SMOOTH_SANDSTONE_SLAB);
                        break;
                    case SANDSTONE_STAIRS:
                        item.setType(Material.SMOOTH_SANDSTONE_STAIRS);
                        break;
                    case RED_SANDSTONE:
                        item.setType(Material.SMOOTH_RED_SANDSTONE);
                        break;
                    case RED_SANDSTONE_SLAB:
                        item.setType(Material.SMOOTH_RED_SANDSTONE_SLAB);
                        break;
                    case RED_SANDSTONE_STAIRS:
                        item.setType(Material.SMOOTH_RED_SANDSTONE_STAIRS);
                        break;
                    case KELP:
                        item.setType(Material.DRIED_KELP);
                        break;
                    case CHORUS_FRUIT:
                        item.setType(Material.POPPED_CHORUS_FRUIT);
                        break;
                    case OAK_LOG:
                    case STRIPPED_OAK_LOG:
                    case OAK_WOOD:
                    case STRIPPED_OAK_WOOD:
                    case DARK_OAK_LOG:
                    case STRIPPED_DARK_OAK_LOG:
                    case DARK_OAK_WOOD:
                    case STRIPPED_DARK_OAK_WOOD:
                    case BIRCH_LOG:
                    case STRIPPED_BIRCH_LOG:
                    case BIRCH_WOOD:
                    case STRIPPED_BIRCH_WOOD:
                    case SPRUCE_LOG:
                    case STRIPPED_SPRUCE_LOG:
                    case SPRUCE_WOOD:
                    case STRIPPED_SPRUCE_WOOD:
                    case ACACIA_LOG:
                    case STRIPPED_ACACIA_LOG:
                    case ACACIA_WOOD:
                    case STRIPPED_ACACIA_WOOD:
                    case JUNGLE_LOG:
                    case STRIPPED_JUNGLE_LOG:
                    case JUNGLE_WOOD:
                    case STRIPPED_JUNGLE_WOOD:
                        item.setType(Material.CHARCOAL);
                        break;
                    case WET_SPONGE:
                        item.setType(Material.SPONGE);
                        break;
                    case SEA_PICKLE:
                        item.setType(Material.LIME_DYE);
                        break;
                    case CACTUS:
                        item.setType(Material.GREEN_DYE);
                        break;
                    case BLACK_TERRACOTTA:
                        item.setType(Material.BLACK_GLAZED_TERRACOTTA);
                        break;
                    case BROWN_TERRACOTTA:
                        item.setType(Material.BROWN_GLAZED_TERRACOTTA);
                        break;
                    case BLUE_TERRACOTTA:
                        item.setType(Material.BLUE_GLAZED_TERRACOTTA);
                        break;
                    case RED_TERRACOTTA:
                        item.setType(Material.RED_GLAZED_TERRACOTTA);
                        break;
                    case WHITE_TERRACOTTA:
                        item.setType(Material.WHITE_GLAZED_TERRACOTTA);
                        break;
                    case CYAN_TERRACOTTA:
                        item.setType(Material.CYAN_GLAZED_TERRACOTTA);
                        break;
                    case PINK_TERRACOTTA:
                        item.setType(Material.PINK_GLAZED_TERRACOTTA);
                        break;
                    case PURPLE_TERRACOTTA:
                        item.setType(Material.PURPLE_GLAZED_TERRACOTTA);
                        break;
                    case MAGENTA_TERRACOTTA:
                        item.setType(Material.MAGENTA_GLAZED_TERRACOTTA);
                        break;
                    case GREEN_TERRACOTTA:
                        item.setType(Material.GREEN_GLAZED_TERRACOTTA);
                        break;
                    case LIME_TERRACOTTA:
                        item.setType(Material.LIME_GLAZED_TERRACOTTA);
                        break;
                    case YELLOW_TERRACOTTA:
                        item.setType(Material.YELLOW_GLAZED_TERRACOTTA);
                        break;
                    case ORANGE_TERRACOTTA:
                        item.setType(Material.ORANGE_GLAZED_TERRACOTTA);
                        break;
                    case GRAY_TERRACOTTA:
                        item.setType(Material.GRAY_GLAZED_TERRACOTTA);
                        break;
                    case LIGHT_GRAY_TERRACOTTA:
                        item.setType(Material.LIGHT_GRAY_GLAZED_TERRACOTTA);
                        break;
                    case LIGHT_BLUE_TERRACOTTA:
                        item.setType(Material.LIGHT_BLUE_GLAZED_TERRACOTTA);
                        break;
                }
            }
        }
        item.setItemMeta(meta);


        if (helmet.equals("Terracotta Helmet") &&
            chest.equals("Terracotta Chestplate") &&
            legs.equals("Terracotta Leggings") &&
            boots.equals("Terracotta Boots")) {
            ItemStack clay = new ItemStack(Material.CLAY_BALL);
            ItemMeta clayMeta = clay.getItemMeta();
            List clayLore = new ArrayList();
            clayLore.add(ChatColor.WHITE.toString() + ChatColor.BOLD + "COMMON");
            clayMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "COMMON");
            clayMeta.setLore(clayLore);
            clay.setItemMeta(clayMeta);
            doChance(fortuneExc, .02f, player, clay);
        }

        if (main.equals("Imbalanced Pickaxe")) {
                meta = player.getInventory().getItemInMainHand().getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "broken"),
                        PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "broken"),
                                PersistentDataType.INTEGER) + 1);
                player.getInventory().getItemInMainHand().setItemMeta(meta);
        }

        if (main.equals("Notched Pick") &&
            (block.getType() == Material.COAL_ORE || block.getType() == Material.DEEPSLATE_COAL_ORE ||
            block.getType() == Material.COPPER_ORE || block.getType() == Material.DEEPSLATE_COPPER_ORE ||
            block.getType() == Material.IRON_ORE || block.getType() == Material.DEEPSLATE_IRON_ORE ||
            block.getType() == Material.REDSTONE_ORE || block.getType() == Material.DEEPSLATE_REDSTONE_ORE ||
            block.getType() == Material.LAPIS_ORE || block.getType() == Material.DEEPSLATE_LAPIS_ORE ||
            block.getType() == Material.GOLD_ORE || block.getType() == Material.DEEPSLATE_GOLD_ORE ||
            block.getType() == Material.DIAMOND_ORE || block.getType() == Material.DEEPSLATE_DIAMOND_ORE ||
            block.getType() == Material.NETHER_QUARTZ_ORE || block.getType() == Material.NETHER_GOLD_ORE ||
            block.getType() == Material.ANCIENT_DEBRIS)) {
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"),
                    PersistentDataType.DOUBLE) + 3);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"),
                            PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"),
                            PersistentDataType.DOUBLE) - 3));
                }
            }, 320);
        }

        if ((block.getType() == Material.DIAMOND_ORE || block.getType() == Material.DEEPSLATE_DIAMOND_ORE) && random.nextInt(86) * (fortuneMine/100 + 1) > 85) {
            player.getInventory().addItem(Items.DIAMOND_POWDER.getItem(plugin));
        }
        if (main.equals("Steel Hoe") && (block.getType() == Material.WHEAT || block.getType() == Material.POTATOES)) {
            fortuneFarm += 40;
        }

        if (main.equals("Logger's Axe") && (block.getType() == Material.OAK_LOG || block.getType() == Material.DARK_OAK_LOG ||
            block.getType() == Material.BIRCH_LOG || block.getType() == Material.ACACIA_LOG ||
            block.getType() == Material.SPRUCE_LOG || block.getType() == Material.JUNGLE_LOG)) {
            player.getInventory().addItem(item);
        }

        if (main.equals("Forester's Axe") && (block.getType() == Material.OAK_LOG || block.getType() == Material.DARK_OAK_LOG ||
                block.getType() == Material.BIRCH_LOG || block.getType() == Material.ACACIA_LOG ||
                block.getType() == Material.SPRUCE_LOG || block.getType() == Material.JUNGLE_LOG)) {
            player.getInventory().addItem(item);
            player.getInventory().addItem(item);
        }


        while (fortuneMine > 0 && (
                block.getType() == Material.AMETHYST_CLUSTER ||
                block.getType() == Material.COAL_ORE ||
                block.getType() == Material.DEEPSLATE_COAL_ORE ||
                block.getType() == Material.COPPER_ORE ||
                block.getType() == Material.DEEPSLATE_COPPER_ORE ||
                block.getType() == Material.IRON_ORE ||
                block.getType() == Material.DEEPSLATE_IRON_ORE ||
                block.getType() == Material.GOLD_ORE ||
                block.getType() == Material.DEEPSLATE_GOLD_ORE ||
                block.getType() == Material.LAPIS_ORE ||
                block.getType() == Material.DEEPSLATE_LAPIS_ORE ||
                block.getType() == Material.REDSTONE_ORE ||
                block.getType() == Material.DEEPSLATE_REDSTONE_ORE ||
                block.getType() == Material.DIAMOND_ORE ||
                block.getType() == Material.DEEPSLATE_DIAMOND_ORE ||
                block.getType() == Material.EMERALD_ORE ||
                block.getType() == Material.DEEPSLATE_EMERALD_ORE ||
                block.getType() == Material.NETHER_GOLD_ORE ||
                block.getType() == Material.NETHER_QUARTZ_ORE ||
                block.getType() == Material.GLOWSTONE ||
                block.getType() == Material.OBSIDIAN ||
                block.getType() == Material.ANCIENT_DEBRIS
                )) {

            if (fortuneMine > 100) {
                if (main.equals("Devourer")) {
                    switch (item.getType()) {
                        case COAL:
                            csd.mining.xp += 8.0 * item.getAmount();
                            skills.put(player.getUniqueId(), csd);
                            break;
                        case RAW_COPPER:
                            csd.mining.xp += 3.0 * item.getAmount();
                            skills.put(player.getUniqueId(), csd);
                            break;
                        case RAW_IRON:
                            csd.mining.xp += 16.0 * item.getAmount();
                            skills.put(player.getUniqueId(), csd);
                            break;
                        case RAW_GOLD:
                            csd.mining.xp += 18.0 * item.getAmount();
                            skills.put(player.getUniqueId(), csd);
                            break;
                        case REDSTONE:
                        case LAPIS_LAZULI:
                            csd.mining.xp += 5.0 * item.getAmount();
                            skills.put(player.getUniqueId(), csd);
                            break;
                        case DIAMOND:
                            csd.mining.xp += 42.0 * item.getAmount();
                            skills.put(player.getUniqueId(), csd);
                            break;
                        case EMERALD:
                            csd.mining.xp += 56.0 * item.getAmount();
                            skills.put(player.getUniqueId(), csd);
                            break;
                        case GOLD_NUGGET:
                            csd.mining.xp += 2.0 * item.getAmount();
                            skills.put(player.getUniqueId(), csd);
                            break;
                        case ANCIENT_DEBRIS:
                            csd.mining.xp += 300.0 * item.getAmount();
                            skills.put(player.getUniqueId(), csd);
                            break;
                    }
                } else {
                    player.getInventory().addItem(item);
                    fortuneMine -= 100;
                }
            }
            else {
                int choice = random.nextInt(100) + 1;
                if (choice <= fortuneMine) {
                    if (main.equals("Devourer")) {
                        switch (item.getType()) {
                            case COAL:
                                csd.mining.xp += 8.0 * item.getAmount();
                                skills.put(player.getUniqueId(), csd);
                                break;
                            case RAW_COPPER:
                                csd.mining.xp += 3.0 * item.getAmount();
                                skills.put(player.getUniqueId(), csd);
                                break;
                            case RAW_IRON:
                                csd.mining.xp += 16.0 * item.getAmount();
                                skills.put(player.getUniqueId(), csd);
                                break;
                            case RAW_GOLD:
                                csd.mining.xp += 18.0 * item.getAmount();
                                skills.put(player.getUniqueId(), csd);
                                break;
                            case REDSTONE:
                            case LAPIS_LAZULI:
                                csd.mining.xp += 5.0 * item.getAmount();
                                skills.put(player.getUniqueId(), csd);
                                break;
                            case DIAMOND:
                                csd.mining.xp += 42.0 * item.getAmount();
                                skills.put(player.getUniqueId(), csd);
                                break;
                            case EMERALD:
                                csd.mining.xp += 56.0 * item.getAmount();
                                skills.put(player.getUniqueId(), csd);
                                break;
                            case GOLD_NUGGET:
                                csd.mining.xp += 2.0 * item.getAmount();
                                skills.put(player.getUniqueId(), csd);
                                break;
                            case ANCIENT_DEBRIS:
                                csd.mining.xp += 300.0 * item.getAmount();
                                skills.put(player.getUniqueId(), csd);
                                break;
                        }
                    } else {
                        player.getInventory().addItem(item);
                    }
                }
                fortuneMine = 0;
            }
        }

        while (fortuneFarm > 0 && (
                block.getType() == Material.PUMPKIN ||
                block.getType() == Material.MELON ||
                block.getType() == Material.RED_MUSHROOM ||
                block.getType() == Material.BROWN_MUSHROOM ||
                block.getType() == Material.RED_MUSHROOM_BLOCK ||
                block.getType() == Material.BROWN_MUSHROOM_BLOCK ||
                block.getType() == Material.KELP_PLANT ||
                block.getType() == Material.BAMBOO ||
                block.getType() == Material.SUGAR_CANE ||
                block.getType() == Material.CACTUS ||
                block.getType() == Material.CHORUS_PLANT ||
                block.getBlockData() instanceof Ageable &&
                ((Ageable) block.getBlockData()).getAge() == ((Ageable) block.getBlockData()).getMaximumAge() && (
                    block.getType() == Material.WHEAT ||
                    block.getType() == Material.POTATOES ||
                    block.getType() == Material.CARROTS ||
                    block.getType() == Material.BEETROOTS ||
                    block.getType() == Material.SWEET_BERRY_BUSH
                )
        )) {
            if (fortuneFarm > 100) {
                player.getInventory().addItem(item);
                fortuneFarm -= 100;
            }
            else {
                int choice = random.nextInt(100) + 1;
                if (choice <= fortuneFarm) {
                    player.getInventory().addItem(item);
                }
                fortuneFarm = 0;
            }
        }

        //Dirt Loot
        Biome biome = block.getBiome();
        int level = skills.get(player.getUniqueId()).excavating.level;
        switch (block.getType()) {
            case DIRT:
            case GRASS_BLOCK:
                if (level >= 1) {
                    doChance(fortuneExc, 0.02f, player, Items.ENCHANTED_SAND.getItem(plugin));
                }
                if (level >= 2) {
                    doChance(fortuneExc, 0.012f, player, Items.ENCHANTED_FLINT.getItem(plugin));
                }
                if (level >= 3 && (
                    biome == Biome.JUNGLE ||
                    biome == Biome.JUNGLE_EDGE ||
                    biome == Biome.JUNGLE_HILLS ||
                    biome == Biome.BAMBOO_JUNGLE ||
                    biome == Biome.BAMBOO_JUNGLE_HILLS ||
                    biome == Biome.MODIFIED_JUNGLE ||
                    biome == Biome.MODIFIED_JUNGLE_EDGE
                )) {
                    doChance(fortuneExc, 0.024f, player, Items.ENCHANTED_BAMBOO.getItem(plugin));
                }
                break;
            case SAND:
            case RED_SAND:
                if (level >= 1) {
                    doChance(fortuneExc, 0.05f, player, Items.ENCHANTED_SAND.getItem(plugin));
                }
                break;
            case SNOW:
            case SNOW_BLOCK:
            case POWDER_SNOW:
                if (level >= 2) {
                    doChance(fortuneExc, 0.015f, player, Items.ENCHANTED_FLINT.getItem(plugin));
                }
                if (level >= 3) {
                    doChance(fortuneExc, 0.06f, player, Items.ENCHANTED_SNOWBALL.getItem(plugin));
                }
                break;
            case CLAY:
                if (level >= 2) {
                    doChance(fortuneExc, 0.075f, player, Items.ENCHANTED_FLINT.getItem(plugin));
                }
                break;
            case PODZOL:
            case COARSE_DIRT:
                if (level >= 2) {
                    doChance(fortuneExc, 0.04f, player, Items.ENCHANTED_FLINT.getItem(plugin));
                }
                break;
            case SOUL_SAND:
            case SOUL_SOIL:
                break;
            case GRAVEL:
                if (level >= 2) {
                    doChance(fortuneExc, 0.03f, player, Items.ENCHANTED_FLINT.getItem(plugin));
                }
                break;
        }
    }

    public void doChance(double fortune, float chance, Player player, ItemStack item) {
        float choice = (float) Math.random();
        if (((choice / fortune) <= chance)) {
            ChatColor color = ChatColor.WHITE;
            if (item.getItemMeta().getPersistentDataContainer() != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                        PersistentDataType.STRING) != null) {
                switch (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                        PersistentDataType.STRING)) {
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
                    case "UNIQUE":
                        color = ChatColor.RED;
                        break;
                }
            }

            DecimalFormat round = new DecimalFormat("0.##");

            player.sendMessage(ChatColor.BLUE + "§lRARE DROP! " + color + "" + item.getItemMeta().getDisplayName() + " " + ChatColor.GOLD + "(" + round.format(chance * 100 * fortune) + "% chance)");
            player.getInventory().addItem(item);
        }
        return;
    }

    public void checkSkill(Player player, int level, String type) {
        PlayerSkillData csd = skills.get(player.getUniqueId());
        SkillData skill = skills.get(player.getUniqueId()).mining;
        switch (type) {
            case "Farming":
                skill = skills.get(player.getUniqueId()).farming;
                break;
            case "Foraging":
                skill = skills.get(player.getUniqueId()).foraging;
                break;
            case "Excavating":
                skill = skills.get(player.getUniqueId()).excavating;
                break;
            case "Combat":
                skill = skills.get(player.getUniqueId()).combat;
                break;

        }

        if (skill.level == 30) {
            return;
        }
        int amount = 0;
        switch (level) {
            case 1:
                amount = 50;
                break;
            case 2:
                amount = 80;
                break;
            case 3:
                amount = 120;
                break;
            case 4:
                amount = 250;
                break;
            case 5:
                amount = 500;
                break;
            case 6:
                amount = 1200;
                break;
            case 7:
                amount = 2000;
                break;
            case 8:
                amount = 3000;
                break;
            case 9:
                amount = 5000;
                break;
            case 10:
                amount = 6500;
                break;
            case 11:
                amount = 8200;
                break;
            case 12:
                amount = 10000;
                break;
            case 13:
                amount = 12500;
                break;
            case 14:
                amount = 14000;
                break;
            case 15:
                amount = 17000;
                break;
            case 16:
                amount = 20500;
                break;
            case 17:
                amount = 23000;
                break;
            case 18:
                amount = 25000;
                break;
            case 19:
                amount = 28000;
                break;
            case 20:
                amount = 32000;
                break;
            case 21:
                amount = 36800;
                break;
            case 22:
                amount = 41000;
                break;
            case 23:
                amount = 50000;
                break;
            case 24:
                amount = 60000;
                break;
            case 25:
                amount = 75000;
                break;
            case 26:
                amount = 115000;
                break;
            case 27:
                amount = 145000;
                break;
            case 28:
                amount = 200000;
                break;
            case 29:
                amount = 0;
                break;
        }

        if (skill.xp >= skill.xpNext) {

            switch (type) {
                case "Mining":
                    csd.mining.xp -= csd.mining.xpNext;
                    csd.mining.level += 1;
                    csd.mining.xpNext = amount;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBase"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBase"),
                                    PersistentDataType.DOUBLE) + 2.0);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                                    PersistentDataType.DOUBLE) + 1.0);
                    skills.put(player.getUniqueId(), csd);
                    if (skill.level != 0) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.BLUE + "Mining " + "§e" + level + "§f ➡ " + "§e" + (level + 1));
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GOLD + "+2 ⛏ Mining Fortune");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                    }
                    checkSkill(player, skills.get(player.getUniqueId()).mining.level, type);
                    break;
                case "Farming":
                    csd.farming.xp -= csd.farming.xpNext;
                    csd.farming.level += 1;
                    csd.farming.xpNext = amount;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmBase"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmBase"),
                                    PersistentDataType.DOUBLE) + 2.0);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                                    PersistentDataType.DOUBLE) + 2.0);
                    skills.put(player.getUniqueId(), csd);
                    if (skill.level != 0) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GOLD + "Farming " + "§e" + level + "§f ➡ " + "§e" + (level + 1));
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GOLD + "+2 ☘ Farming Fortune");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.RED + "+2 ❤ Health");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                    }
                    checkSkill(player, skills.get(player.getUniqueId()).farming.level, type);
                    break;
                case "Foraging":
                    csd.foraging.xp -= csd.foraging.xpNext;
                    csd.foraging.level += 1;
                    csd.foraging.xpNext = amount;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                                    PersistentDataType.DOUBLE) + 2.0);
                    skills.put(player.getUniqueId(), csd);
                    if (skill.level != 0) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e" + level + "§f ➡ " + "§e" + (level + 1));
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                    }
                    checkSkill(player, skills.get(player.getUniqueId()).foraging.level, type);
                    break;
                case "Excavating":
                    csd.excavating.xp -= csd.excavating.xpNext;
                    csd.excavating.level += 1;
                    csd.excavating.xpNext = amount;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcBase"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcBase"),
                                    PersistentDataType.DOUBLE) + 2.0);
                    skills.put(player.getUniqueId(), csd);
                    if (skill.level != 0) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
                        player.sendMessage(" ");
                        player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e" + level + "§f ➡ " + "§e" + (level + 1));
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GOLD + "+2 ♠ Excavating Fortune");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                    }
                    checkSkill(player, skills.get(player.getUniqueId()).excavating.level, type);
                    break;
                case "Combat":
                    csd.combat.xp -= csd.combat.xpNext;
                    csd.combat.level += 1;
                    csd.combat.xpNext = amount;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                                    PersistentDataType.DOUBLE) + 1.0);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                                    PersistentDataType.DOUBLE) + 0.05);
                    skills.put(player.getUniqueId(), csd);
                    if (skill.level != 0) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e" + level + "§f ➡ " + "§e" + (level + 1));
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GRAY + "Deal 5% more damage");
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.GOLD + "-----------------------------------");
                    }
                    checkSkill(player, skills.get(player.getUniqueId()).combat.level, type);
                    break;
            }
        }
    }

    @EventHandler
    public void setSkill(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!skills.containsKey(player.getUniqueId())) {
            skills.put(player.getUniqueId(), new PlayerSkillData());
        }
    }

    @EventHandler
    //Block Break events and how much xp they give
    public void breakBlock(BlockBreakEvent event) {
        blockXp(event.getBlock(), event.getPlayer());
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand() != null &&
            player.getInventory().getItemInMainHand().getItemMeta() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
            PlayerSkillData csd = skills.get(player.getUniqueId());
            if (event.getBlock().getDrops().isEmpty()) {
                return;
            }

            ItemStack item = new ItemStack(Material.AIR);
            if (event.getBlock().getDrops().size() > 0) {
                item = ((List<ItemStack>)event.getBlock().getDrops()).get(0);
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING).equals("Devourer")) {
                switch (item.getType()) {
                    case COAL:
                        csd.mining.xp += 8.0 * item.getAmount();
                        skills.put(player.getUniqueId(), csd);
                        event.setDropItems(false);
                        break;
                    case RAW_COPPER:
                        csd.mining.xp += 3.0 * item.getAmount();
                        skills.put(player.getUniqueId(), csd);
                        event.setDropItems(false);
                        break;
                    case RAW_IRON:
                        csd.mining.xp += 16.0 * item.getAmount();
                        skills.put(player.getUniqueId(), csd);
                        event.setDropItems(false);
                        break;
                    case RAW_GOLD:
                        csd.mining.xp += 18.0 * item.getAmount();
                        skills.put(player.getUniqueId(), csd);
                        event.setDropItems(false);
                        break;
                    case REDSTONE:
                    case LAPIS_LAZULI:
                        csd.mining.xp += 5.0 * item.getAmount();
                        skills.put(player.getUniqueId(), csd);
                        event.setDropItems(false);
                        break;
                    case DIAMOND:
                        csd.mining.xp += 42.0 * item.getAmount();
                        skills.put(player.getUniqueId(), csd);
                        event.setDropItems(false);
                        break;
                    case EMERALD:
                        csd.mining.xp += 56.0 * item.getAmount();
                        skills.put(player.getUniqueId(), csd);
                        event.setDropItems(false);
                        break;
                    case GOLD_NUGGET:
                        csd.mining.xp += 2.0 * item.getAmount();
                        skills.put(player.getUniqueId(), csd);
                        event.setDropItems(false);
                        break;
                    case ANCIENT_DEBRIS:
                        csd.mining.xp += 300.0 * item.getAmount();
                        skills.put(player.getUniqueId(), csd);
                        event.setDropItems(false);
                        break;
                }
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                    new stringList()).length > 0 &&
                Arrays.asList(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                    new stringList())).indexOf("Smelt") != -1) {
                ItemMeta meta = item.getItemMeta();
                List<String> lore = new ArrayList<>();
                switch (item.getType()) {
                    case EMERALD:
                    case DIAMOND:
                    case ANCIENT_DEBRIS:
                        lore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON");
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
                        break;
                    default:
                        lore.add(ChatColor.WHITE + "" + ChatColor.BOLD + "COMMON");
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "COMMON");
                        break;
                }
                meta.setLore(lore);
                boolean smelt = false;
                if ((item.getType() == Material.RAW_COPPER ||
                    item.getType() == Material.RAW_COPPER_BLOCK ||
                    item.getType() == Material.RAW_IRON ||
                    item.getType() == Material.RAW_IRON_BLOCK ||
                    item.getType() == Material.RAW_GOLD ||
                    item.getType() == Material.RAW_GOLD_BLOCK ||
                    item.getType() == Material.ANCIENT_DEBRIS) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[0] == 1) {
                    smelt = true;
                }
                if ((item.getType() == Material.OAK_WOOD ||
                    item.getType() == Material.OAK_LOG ||
                    item.getType() == Material.STRIPPED_OAK_WOOD ||
                    item.getType() == Material.STRIPPED_OAK_LOG ||
                    item.getType() == Material.DARK_OAK_WOOD ||
                    item.getType() == Material.DARK_OAK_LOG ||
                    item.getType() == Material.STRIPPED_DARK_OAK_WOOD ||
                    item.getType() == Material.STRIPPED_DARK_OAK_LOG ||
                    item.getType() == Material.BIRCH_WOOD ||
                    item.getType() == Material.BIRCH_LOG ||
                    item.getType() == Material.STRIPPED_BIRCH_WOOD ||
                    item.getType() == Material.STRIPPED_BIRCH_LOG ||
                    item.getType() == Material.ACACIA_WOOD ||
                    item.getType() == Material.ACACIA_LOG ||
                    item.getType() == Material.STRIPPED_ACACIA_WOOD ||
                    item.getType() == Material.STRIPPED_ACACIA_LOG ||
                    item.getType() == Material.SPRUCE_WOOD ||
                    item.getType() == Material.SPRUCE_LOG ||
                    item.getType() == Material.STRIPPED_SPRUCE_WOOD ||
                    item.getType() == Material.STRIPPED_SPRUCE_LOG ||
                    item.getType() == Material.JUNGLE_WOOD ||
                    item.getType() == Material.JUNGLE_LOG ||
                    item.getType() == Material.STRIPPED_JUNGLE_WOOD ||
                    item.getType() == Material.STRIPPED_JUNGLE_LOG) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[1] == 1) {
                    smelt = true;
                }
                if ((item.getType() == Material.CLAY ||
                    item.getType() == Material.YELLOW_TERRACOTTA ||
                    item.getType() == Material.BLACK_TERRACOTTA ||
                    item.getType() == Material.BLUE_TERRACOTTA ||
                    item.getType() == Material.BROWN_TERRACOTTA ||
                    item.getType() == Material.CYAN_TERRACOTTA ||
                    item.getType() == Material.GRAY_TERRACOTTA ||
                    item.getType() == Material.GREEN_TERRACOTTA ||
                    item.getType() == Material.LIGHT_BLUE_TERRACOTTA ||
                    item.getType() == Material.LIGHT_GRAY_TERRACOTTA ||
                    item.getType() == Material.LIME_GLAZED_TERRACOTTA ||
                    item.getType() == Material.MAGENTA_TERRACOTTA ||
                    item.getType() == Material.ORANGE_TERRACOTTA ||
                    item.getType() == Material.PINK_TERRACOTTA ||
                    item.getType() == Material.PURPLE_TERRACOTTA ||
                    item.getType() == Material.RED_TERRACOTTA ||
                    item.getType() == Material.WHITE_TERRACOTTA) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[2] == 1) {
                    smelt = true;
                }
                if ((item.getType() == Material.SAND ||
                    item.getType() == Material.RED_SAND) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[3] == 1) {
                    smelt = true;
                }
                if ((item.getType() == Material.CHORUS_FRUIT) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[4] == 1) {
                    smelt = true;
                }
                if ((item.getType() == Material.COBBLESTONE ||
                    item.getType() == Material.COBBLESTONE_STAIRS ||
                    item.getType() == Material.COBBLESTONE_SLAB ||
                    item.getType() == Material.SANDSTONE ||
                    item.getType() == Material.SANDSTONE_SLAB ||
                    item.getType() == Material.SANDSTONE_STAIRS ||
                    item.getType() == Material.RED_SANDSTONE ||
                    item.getType() == Material.RED_SANDSTONE_SLAB ||
                    item.getType() == Material.RED_SANDSTONE_STAIRS ||
                    item.getType() == Material.QUARTZ_BLOCK ||
                    item.getType() == Material.QUARTZ_SLAB ||
                    item.getType() == Material.QUARTZ_STAIRS ||
                    item.getType() == Material.STONE ||
                    item.getType() == Material.STONE_SLAB ||
                    item.getType() == Material.STONE_STAIRS ||
                    item.getType() == Material.COBBLED_DEEPSLATE ||
                    item.getType() == Material.DEEPSLATE ||
                    item.getType() == Material.NETHER_BRICKS ||
                    item.getType() == Material.BASALT ||
                    item.getType() == Material.STONE_BRICKS ||
                    item.getType() == Material.POLISHED_BLACKSTONE_BRICKS ||
                    item.getType() == Material.DEEPSLATE_BRICKS ||
                    item.getType() == Material.DEEPSLATE_TILES) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[5] == 1) {
                    smelt = true;
                }
                if (item.getType() == Material.NETHERRACK &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[6] == 1) {
                    smelt = true;
                }
                if ((item.getType() == Material.CACTUS ||
                        item.getType() == Material.KELP) &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[7] == 1) {
                    smelt = true;
                }
                if (item.getType() == Material.WET_SPONGE &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[8] == 1) {
                    smelt = true;
                }
                if (item.getType() == Material.SEA_PICKLE &&
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY)[9] == 1) {
                    smelt = true;
                }

                if (smelt) {
                    event.setDropItems(false);
                    switch (item.getType()) {
                        case RAW_COPPER:
                            item.setType(Material.COPPER_INGOT);
                            break;
                        case RAW_COPPER_BLOCK:
                            item.setType(Material.COPPER_BLOCK);
                            break;
                        case RAW_IRON:
                            item.setType(Material.IRON_INGOT);
                            break;
                        case RAW_IRON_BLOCK:
                            item.setType(Material.IRON_BLOCK);
                            break;
                        case RAW_GOLD:
                            item.setType(Material.GOLD_INGOT);
                            break;
                        case RAW_GOLD_BLOCK:
                            item.setType(Material.GOLD_BLOCK);
                            break;
                        case ANCIENT_DEBRIS:
                            item.setType(Material.NETHERITE_SCRAP);
                            break;
                        case SAND:
                        case RED_SAND:
                            item.setType(Material.GLASS);
                            break;
                        case CLAY:
                            item.setType(Material.TERRACOTTA);
                            break;
                        case NETHERRACK:
                            item.setType(Material.NETHER_BRICK);
                            break;
                        case COBBLESTONE:
                            item.setType(Material.STONE);
                            break;
                        case COBBLESTONE_SLAB:
                            item.setType(Material.STONE_SLAB);
                            break;
                        case COBBLESTONE_STAIRS:
                            item.setType(Material.STONE_STAIRS);
                            break;
                        case STONE:
                            item.setType(Material.SMOOTH_STONE);
                            break;
                        case STONE_SLAB:
                            item.setType(Material.SMOOTH_STONE_SLAB);
                            break;
                        case QUARTZ_BLOCK:
                            item.setType(Material.SMOOTH_QUARTZ);
                            break;
                        case QUARTZ_SLAB:
                            item.setType(Material.SMOOTH_QUARTZ_SLAB);
                            break;
                        case QUARTZ_STAIRS:
                            item.setType(Material.SMOOTH_QUARTZ_STAIRS);
                            break;
                        case NETHER_BRICKS:
                            item.setType(Material.CRACKED_NETHER_BRICKS);
                            break;
                        case BASALT:
                            item.setType(Material.SMOOTH_BASALT);
                            break;
                        case STONE_BRICKS:
                            item.setType(Material.CRACKED_STONE_BRICKS);
                            break;
                        case COBBLED_DEEPSLATE:
                            item.setType(Material.DEEPSLATE);
                            break;
                        case DEEPSLATE_BRICKS:
                            item.setType(Material.CRACKED_DEEPSLATE_BRICKS);
                            break;
                        case DEEPSLATE_TILES:
                            item.setType(Material.CRACKED_DEEPSLATE_TILES);
                            break;
                        case SANDSTONE:
                            item.setType(Material.SMOOTH_SANDSTONE);
                            break;
                        case SANDSTONE_SLAB:
                            item.setType(Material.SMOOTH_SANDSTONE_SLAB);
                            break;
                        case SANDSTONE_STAIRS:
                            item.setType(Material.SMOOTH_SANDSTONE_STAIRS);
                            break;
                        case RED_SANDSTONE:
                            item.setType(Material.SMOOTH_RED_SANDSTONE);
                            break;
                        case RED_SANDSTONE_SLAB:
                            item.setType(Material.SMOOTH_RED_SANDSTONE_SLAB);
                            break;
                        case RED_SANDSTONE_STAIRS:
                            item.setType(Material.SMOOTH_RED_SANDSTONE_STAIRS);
                            break;
                        case KELP:
                            item.setType(Material.DRIED_KELP);
                            break;
                        case CHORUS_FRUIT:
                            item.setType(Material.POPPED_CHORUS_FRUIT);
                            break;
                        case OAK_LOG:
                        case STRIPPED_OAK_LOG:
                        case OAK_WOOD:
                        case STRIPPED_OAK_WOOD:
                        case DARK_OAK_LOG:
                        case STRIPPED_DARK_OAK_LOG:
                        case DARK_OAK_WOOD:
                        case STRIPPED_DARK_OAK_WOOD:
                        case BIRCH_LOG:
                        case STRIPPED_BIRCH_LOG:
                        case BIRCH_WOOD:
                        case STRIPPED_BIRCH_WOOD:
                        case SPRUCE_LOG:
                        case STRIPPED_SPRUCE_LOG:
                        case SPRUCE_WOOD:
                        case STRIPPED_SPRUCE_WOOD:
                        case ACACIA_LOG:
                        case STRIPPED_ACACIA_LOG:
                        case ACACIA_WOOD:
                        case STRIPPED_ACACIA_WOOD:
                        case JUNGLE_LOG:
                        case STRIPPED_JUNGLE_LOG:
                        case JUNGLE_WOOD:
                        case STRIPPED_JUNGLE_WOOD:
                            item.setType(Material.CHARCOAL);
                            break;
                        case WET_SPONGE:
                            item.setType(Material.SPONGE);
                            break;
                        case SEA_PICKLE:
                            item.setType(Material.LIME_DYE);
                            break;
                        case CACTUS:
                            item.setType(Material.GREEN_DYE);
                            break;
                        case BLACK_TERRACOTTA:
                            item.setType(Material.BLACK_GLAZED_TERRACOTTA);
                            break;
                        case BROWN_TERRACOTTA:
                            item.setType(Material.BROWN_GLAZED_TERRACOTTA);
                            break;
                        case BLUE_TERRACOTTA:
                            item.setType(Material.BLUE_GLAZED_TERRACOTTA);
                            break;
                        case RED_TERRACOTTA:
                            item.setType(Material.RED_GLAZED_TERRACOTTA);
                            break;
                        case WHITE_TERRACOTTA:
                            item.setType(Material.WHITE_GLAZED_TERRACOTTA);
                            break;
                        case CYAN_TERRACOTTA:
                            item.setType(Material.CYAN_GLAZED_TERRACOTTA);
                            break;
                        case PINK_TERRACOTTA:
                            item.setType(Material.PINK_GLAZED_TERRACOTTA);
                            break;
                        case PURPLE_TERRACOTTA:
                            item.setType(Material.PURPLE_GLAZED_TERRACOTTA);
                            break;
                        case MAGENTA_TERRACOTTA:
                            item.setType(Material.MAGENTA_GLAZED_TERRACOTTA);
                            break;
                        case GREEN_TERRACOTTA:
                            item.setType(Material.GREEN_GLAZED_TERRACOTTA);
                            break;
                        case LIME_TERRACOTTA:
                            item.setType(Material.LIME_GLAZED_TERRACOTTA);
                            break;
                        case YELLOW_TERRACOTTA:
                            item.setType(Material.YELLOW_GLAZED_TERRACOTTA);
                            break;
                        case ORANGE_TERRACOTTA:
                            item.setType(Material.ORANGE_GLAZED_TERRACOTTA);
                            break;
                        case GRAY_TERRACOTTA:
                            item.setType(Material.GRAY_GLAZED_TERRACOTTA);
                            break;
                        case LIGHT_GRAY_TERRACOTTA:
                            item.setType(Material.LIGHT_GRAY_GLAZED_TERRACOTTA);
                            break;
                        case LIGHT_BLUE_TERRACOTTA:
                            item.setType(Material.LIGHT_BLUE_GLAZED_TERRACOTTA);
                            break;
                    }
                    item.setItemMeta(meta);
                    Item drop = event.getBlock().getWorld().spawn(event.getBlock().getLocation(), Item.class);
                    drop.setItemStack(item);
                }
            }
        }
    }

    public void blockXp(Block block, Player player) {

        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            BukkitObjectOutputStream outputStream = new BukkitObjectOutputStream(stream);
            outputStream.writeObject(new ItemStack[] {});
            outputStream.flush();
            byte[] serialized = stream.toByteArray();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(serialized);
            BukkitObjectInputStream objectInputStream = new BukkitObjectInputStream(inputStream);

            ItemStack[] item = (ItemStack[])objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(ChatColor.RED + "Failed to load item");
        }

        PlayerSkillData csd = skills.get(player.getUniqueId());
        String lastMined = "none";

        if (block.getMetadata("placed").isEmpty()) {
            String main = "";
            String off = "";
            String set = "";
            String helmet = "";
            String chest = "";
            String legs = "";
            String boots = "";

            double foragingBoost = 1.0;
            double farmingBoost = 1.0;
            double miningBoost = 1.0;
            double excavatingBoost = 1.0;

            if (player.getInventory().getItemInMainHand() != null &&
                    player.getInventory().getItemInMainHand().getItemMeta() != null &&
                    player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
                    player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
                main = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            }

            if (player.getInventory().getItemInOffHand() != null &&
                    player.getInventory().getItemInOffHand().getItemMeta() != null &&
                    player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
                    player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
                off = player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            }

            if (player.getInventory().getHelmet() != null &&
                    player.getInventory().getHelmet().getItemMeta() != null &&
                    player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
                    player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
                helmet = player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            }

            if (player.getInventory().getChestplate() != null &&
                    player.getInventory().getChestplate().getItemMeta() != null &&
                    player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
                    player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
                chest = player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            }

            if (player.getInventory().getLeggings() != null &&
                    player.getInventory().getLeggings().getItemMeta() != null &&
                    player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
                    player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
                legs = player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            }

            if (player.getInventory().getBoots() != null &&
                    player.getInventory().getBoots().getItemMeta() != null &&
                    player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
                    player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
                boots = player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING);
            }

            switch (main) {
                case "Lumberjack's Axe":
                    foragingBoost += 0.25;
                    break;
                case "Forester's Axe":
                    foragingBoost += 0.4;
                    break;
            }
            //Mining xp section
            if (block.getType() == Material.BEDROCK && player.isOp() == true) {

                csd.mining.xp += 10000000.0;
                skills.put(player.getUniqueId(), csd);
                csd.excavating.xp += 10000000.0;
                skills.put(player.getUniqueId(), csd);
                csd.foraging.xp += 10000000.0;
                skills.put(player.getUniqueId(), csd);
                csd.farming.xp += 10000000.0;
                skills.put(player.getUniqueId(), csd);
            }

            if (block.getType() == Material.STONE || block.getType() == Material.COBBLESTONE ||
                    block.getType() == Material.MOSSY_COBBLESTONE) {

                csd.mining.xp += 1.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.CALCITE || block.getType() == Material.GRANITE ||
                    block.getType() == Material.ANDESITE || block.getType() == Material.DIORITE) {

                csd.mining.xp += 4.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE || block.getType() == Material.BLACKSTONE ||
                    block.getType() == Material.BASALT || block.getType() == Material.SMOOTH_BASALT) {

                csd.mining.xp += 6.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.NETHERRACK) {

                csd.mining.xp += 0.2 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.COAL_ORE || block.getType() == Material.AMETHYST_CLUSTER || block.getType() == Material.END_STONE) {

                csd.mining.xp += 8.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_COAL_ORE || block.getType() == Material.NETHER_QUARTZ_ORE ||
                    block.getType() == Material.GLOWSTONE) {

                csd.mining.xp += 12.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.COPPER_ORE) {

                csd.mining.xp += 10.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_COPPER_ORE || block.getType() == Material.AMETHYST_BLOCK) {

                csd.mining.xp += 15.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.IRON_ORE) {

                csd.mining.xp += 16.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_IRON_ORE) {

                csd.mining.xp += 24.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.LAPIS_ORE || block.getType() == Material.REDSTONE_ORE) {

                csd.mining.xp += 20.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_LAPIS_ORE || block.getType() == Material.DEEPSLATE_REDSTONE_ORE) {

                csd.mining.xp += 32.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.GOLD_ORE) {

                csd.mining.xp += 18.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_GOLD_ORE) {

                csd.mining.xp += 25.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DIAMOND_ORE) {

                csd.mining.xp += 42.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_DIAMOND_ORE) {

                csd.mining.xp += 68.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.NETHER_GOLD_ORE) {

                csd.mining.xp += 7.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.EMERALD_ORE) {

                csd.mining.xp += 56.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_EMERALD_ORE) {

                csd.mining.xp += 92.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.TUFF) {

                csd.mining.xp += 1.2 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DRIPSTONE_BLOCK) {

                csd.mining.xp += 2.4 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.POINTED_DRIPSTONE) {

                csd.mining.xp += 0.6 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.OBSIDIAN) {

                csd.mining.xp += 60.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.MAGMA_BLOCK) {

                csd.mining.xp += 2.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.BRAIN_CORAL_BLOCK || block.getType() == Material.FIRE_CORAL_BLOCK ||
                    block.getType() == Material.HORN_CORAL_BLOCK || block.getType() == Material.TUBE_CORAL_BLOCK) {

                csd.mining.xp += 0.1 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.SANDSTONE) {

                csd.mining.xp += 0.8 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.ANCIENT_DEBRIS) {

                csd.mining.xp += 300.0 * miningBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }


            //Excavating xp section
            if (block.getType() == Material.DIRT) {

                csd.excavating.xp += 1 * excavatingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.SAND || block.getType() == Material.RED_SAND) {

                csd.excavating.xp += 2 * excavatingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.GRASS_BLOCK) {

                csd.excavating.xp += 1.2 * excavatingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.COARSE_DIRT || block.getType() == Material.PODZOL ||
                    block.getType() == Material.MYCELIUM) {

                csd.excavating.xp += 6 * excavatingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.GRAVEL) {

                csd.excavating.xp += 3 * excavatingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.CLAY) {

                csd.excavating.xp += 15 * excavatingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.SOUL_SAND || block.getType() == Material.SOUL_SOIL) {

                csd.excavating.xp += 5 * excavatingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.SNOW_BLOCK || block.getType() == Material.SNOW ||
                    block.getType() == Material.POWDER_SNOW) {

                csd.excavating.xp += 0.8 * excavatingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            //Foraging xp section
            if (block.getType() == Material.OAK_LOG || block.getType() == Material.BIRCH_LOG ||
                block.getType() == Material.DARK_OAK_LOG || block.getType() == Material.ACACIA_LOG ||
                block.getType() == Material.SPRUCE_LOG || block.getType() == Material.JUNGLE_LOG ||
                block.getType() == Material.RED_MUSHROOM || block.getType() == Material.BROWN_MUSHROOM) {

                csd.foraging.xp += 6 * foragingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.WARPED_STEM || block.getType() == Material.CRIMSON_STEM) {

                csd.foraging.xp += 10 * foragingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.MUSHROOM_STEM || block.getType() == Material.RED_MUSHROOM_BLOCK ||
                    block.getType() == Material.BROWN_MUSHROOM_BLOCK) {

                csd.foraging.xp += 2 * foragingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.WARPED_FUNGUS || block.getType() == Material.CRIMSON_FUNGUS) {

                csd.foraging.xp += 12 * foragingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.OAK_LEAVES || block.getType() == Material.BIRCH_LEAVES ||
                block.getType() == Material.ACACIA_LEAVES || block.getType() == Material.SPRUCE_LEAVES ||
                block.getType() == Material.JUNGLE_LEAVES || block.getType() == Material.AZALEA_LEAVES ||
                block.getType() == Material.FLOWERING_AZALEA_LEAVES || block.getType() == Material.TALL_GRASS ||
                block.getType() == Material.LARGE_FERN || block.getType() == Material.TALL_SEAGRASS ||
                block.getType() == Material.CRIMSON_ROOTS || block.getType() == Material.WARPED_ROOTS) {

                csd.foraging.xp += 0.2 * foragingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.DANDELION || block.getType() == Material.POPPY ||
                    block.getType() == Material.PINK_TULIP || block.getType() == Material.RED_TULIP ||
                    block.getType() == Material.ORANGE_TULIP || block.getType() == Material.WHITE_TULIP ||
                    block.getType() == Material.BLUE_ORCHID || block.getType() == Material.AZURE_BLUET ||
                    block.getType() == Material.CORNFLOWER || block.getType() == Material.LILY_OF_THE_VALLEY ||
                    block.getType() == Material.ALLIUM || block.getType() == Material.OXEYE_DAISY) {

                csd.foraging.xp += 1 * foragingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.DEAD_BUSH || block.getType() == Material.SEA_PICKLE ||
                    block.getType() == Material.SEAGRASS || block.getType() == Material.GRASS ||
                    block.getType() == Material.FERN || block.getType() == Material.AZALEA_LEAVES) {

                csd.foraging.xp += 0.1 * foragingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.VINE || block.getType() == Material.GLOW_LICHEN) {

                csd.foraging.xp += 0.4 * foragingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.TWISTING_VINES || block.getType() == Material.TWISTING_VINES_PLANT) {

                for (int i = 0; i > 0; --i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.TWISTING_VINES && b.getType() != Material.TWISTING_VINES_PLANT) {
                        break;
                    }
                    csd.foraging.xp += 0.4 * foragingBoost;
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.WEEPING_VINES || block.getType() == Material.WEEPING_VINES_PLANT) {

                for (int i = 0; i > 0; --i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.WEEPING_VINES && b.getType() != Material.WEEPING_VINES_PLANT) {
                        break;
                    }
                    csd.foraging.xp += 0.4 * foragingBoost;
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.ROSE_BUSH || block.getType() == Material.SUNFLOWER ||
                    block.getType() == Material.LILAC || block.getType() == Material.PEONY) {

                csd.foraging.xp += 1 * foragingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.BAMBOO) {

                for (int i = 0; i < 255; ++i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.BAMBOO) {
                        break;
                    }
                    csd.foraging.xp += 3 * foragingBoost;
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.SWEET_BERRY_BUSH) {
                Ageable age = (Ageable) block.getBlockData();
                if (age.getAge() == 3 || age.getAge() == 2) {
                    csd.foraging.xp += 5 * foragingBoost;
                    skills.put(player.getUniqueId(), csd);
                    lastMined = "foraging";
                }
            }

            if (block.getType() == Material.CHORUS_PLANT ||
                    block.getType() == Material.CHORUS_FLOWER
            ) {
                for (int i = 0; i < 255; ++i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() == Material.CHORUS_PLANT ||
                            b.getType() == Material.CHORUS_FLOWER) {
                        break;
                    }
                    csd.foraging.xp += 4.0 * foragingBoost;
                    doubleDrop(player, b);
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            //Farming xp section
            if (block.getType() == Material.POTATOES || block.getType() == Material.CARROTS ||
                    block.getType() == Material.BEETROOTS) {
                if (block.getBlockData() instanceof Ageable) {
                    org.bukkit.block.data.Ageable age = (Ageable) block.getBlockData();
                    if (age.getAge() == age.getMaximumAge()) {
                        csd.farming.xp += 5.0 * farmingBoost;
                        skills.put(player.getUniqueId(), csd);
                        lastMined = "farming";
                    }
                }
            }

            if (block.getType() == Material.WHEAT) {
                if (block.getBlockData() instanceof Ageable) {
                    org.bukkit.block.data.Ageable age = (Ageable) block.getBlockData();
                    if (age.getAge() == age.getMaximumAge()) {
                        csd.farming.xp += 2.0 * farmingBoost;
                        skills.put(player.getUniqueId(), csd);
                        lastMined = "farming";
                    }
                }
            }

            if (block.getType() == Material.COCOA) {
                if (block.getBlockData() instanceof Ageable) {
                    org.bukkit.block.data.Ageable age = (Ageable) block.getBlockData();
                    if (age.getAge() == age.getMaximumAge()) {
                        csd.farming.xp += 12.0 * farmingBoost;
                        skills.put(player.getUniqueId(), csd);
                        lastMined = "farming";
                    }
                }
            }

            if (block.getType() == Material.PUMPKIN || block.getType() == Material.MELON) {
                csd.farming.xp += 8.0 * farmingBoost;
                skills.put(player.getUniqueId(), csd);
                lastMined = "farming";
            }

            if (block.getType() == Material.KELP_PLANT) {
                for (int i = 0; i < 255; ++i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.KELP_PLANT) {
                        break;
                    }
                    csd.farming.xp += 0.8 * farmingBoost;
                    doubleDrop(player, b);
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "farming";
            }

            if (block.getType() == Material.CACTUS) {
                for (int i = 0; i < 255; ++i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.CACTUS) {
                        break;
                    }
                    csd.farming.xp += 8 * farmingBoost;
                    doubleDrop(player, b);
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "farming";
            }

            if (block.getType() == Material.SUGAR_CANE) {
                for (int i = 0; i < 255; ++i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.SUGAR_CANE) {
                        break;
                    }
                    csd.farming.xp += 2.4 * farmingBoost;
                    doubleDrop(player, b);
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "farming";
            }

            doubleDrop(player, block);
            if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "noise"),
                    PersistentDataType.INTEGER) == 0) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 8, 2);
            }

            //What message to send player
            if (lastMined == "mining") {
                checkSkill(player, csd.mining.level, "Mining");
                String message = String.format(
                        "§3+%.1f/%.0f Mining XP",
                        skills.get(player.getUniqueId()).mining.xp,
                        skills.get(player.getUniqueId()).mining.xpNext

                );
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                        PersistentDataType.DOUBLE, 5.0);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }

            if (lastMined == "excavating") {
                checkSkill(player, csd.excavating.level, "Excavating");
                String message = String.format(
                        "§3+%.1f/%.0f Excavating XP",
                        skills.get(player.getUniqueId()).excavating.xp,
                        skills.get(player.getUniqueId()).excavating.xpNext
                );
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                        PersistentDataType.DOUBLE, 5.0);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }

            if (lastMined == "foraging") {
                checkSkill(player, csd.foraging.level, "Foraging");
                String message = String.format(
                        "§3+%.1f/%.0f Foraging XP",
                        skills.get(player.getUniqueId()).foraging.xp,
                        skills.get(player.getUniqueId()).foraging.xpNext
                );
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                        PersistentDataType.DOUBLE, 5.0);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }

            if (lastMined == "farming") {
                checkSkill(player, csd.farming.level, "Farming");
                String message = String.format(
                        "§3+%.1f/%.0f Farming XP",
                        skills.get(player.getUniqueId()).farming.xp,
                        skills.get(player.getUniqueId()).farming.xpNext
                );
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                        PersistentDataType.DOUBLE, 5.0);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }
        }
    }

    public void doDrops(Player player, Mobs mob) {
        if (new Random().nextInt(1000) == 0) {
            player.getInventory().addItem(Items.DRIED_BLOOD.getItem(plugin));
        }
        for (int i = 0; i < mob.item.length; i++) {
            // accessing each element of array
            Items item = mob.item[i];
            float chance = mob.chance[i];
            int amount = mob.amount[i];
            float choice = (float) Math.random();

            ChatColor color = ChatColor.WHITE;
            if (item.getItem(plugin).getItemMeta().getPersistentDataContainer() != null &&
                item.getItem(plugin).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                        PersistentDataType.STRING) != null) {
                switch (item.getItem(plugin).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                        PersistentDataType.STRING)) {
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
            }
            String rarity = "";

            if (chance <= 0.05f && chance > 0.01f) {
                rarity = ChatColor.BLUE.toString() + ChatColor.BOLD + "RARE DROP! ";
            }
            if (chance <= 0.01f && chance > 0.001f) {
                rarity = ChatColor.DARK_RED.toString() + ChatColor.BOLD + "ELUSIVE DROP! ";
            }
            if (chance <= 0.001f) {
                rarity = ChatColor.DARK_AQUA.toString() + ChatColor.BOLD + "IMPOSSIBLE DROP!!! ";
            }

            double magic = ((player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicFind"),
                    PersistentDataType.DOUBLE)/100) + 1);
            if (choice / magic <= chance) {
                Random random = new Random();
                if (rarity != "") {
                    player.sendMessage(rarity + color + "" + item.getItem(plugin).getItemMeta().getDisplayName() + " " + ChatColor.AQUA + "(" + ((chance * 100) * magic) + "% chance)");
                }
                ItemStack dropitem = item.getItem(plugin);
                dropitem.setAmount(amount);
                player.getInventory().addItem(dropitem);
                if (player.getInventory().getItemInMainHand() != null &&
                    player.getInventory().getItemInMainHand().getItemMeta() != null &&
                    player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
                    player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                            new stringList()) != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                            new stringList()).length > 0 &&
                            Arrays.asList(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                                    new stringList())).indexOf("Altruist") != -1 && new Random().nextInt(100) <= (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                            PersistentDataType.INTEGER_ARRAY)[Arrays.asList(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                            new stringList())).indexOf("Altruist")]) * 5) {
                        for (int h = 0; h < player.getNearbyEntities(15, 15, 15).size(); h++) {
                            if (player.getNearbyEntities(15, 15, 15).get(h) instanceof Player &&
                                    player.getNearbyEntities(15, 15, 15).get(h) != player) {
                                player.getNearbyEntities(15, 15, 15).get(h).sendMessage(ChatColor.GOLD + "You were gifted something due to " + player.getDisplayName() + ChatColor.GOLD + "'s altruism!");
                                player.sendMessage(ChatColor.GOLD + "You gifted " + ((Player) player.getNearbyEntities(15, 15, 15).get(h)).getDisplayName() + ChatColor.GOLD + " a copy of your loot!");
                                ((Player) player.getNearbyEntities(15, 15, 15).get(h)).getInventory().addItem(item.getItem(plugin));
                            }
                        }
                    }

                    if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                        new stringList()).length > 0 &&
                        Arrays.asList(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                                new stringList())).indexOf("Looting") != -1 && random.nextInt(100) <= (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                        PersistentDataType.INTEGER_ARRAY)[Arrays.asList(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                        new stringList())).indexOf("Looting")]) * 5) {
                        player.getInventory().addItem(item.getItem(plugin));
                    }
                }
            }
        }
    }

    @EventHandler
    public void combatXP(EntityDamageByEntityEvent event) {
        if (event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) == null) {
            return;
        }

        if (event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) < 1 &&
            functions.CheckDamage(event, plugin) instanceof Player) {

                Player player = (Player) functions.CheckDamage(event, plugin);

                PlayerSkillData csd = skills.get(player.getUniqueId());

                if (event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null &&
                    event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING) != null &&
                    event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING) == "mob") {
                    Mobs mob = Mobs.valueOf(event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING));
                    csd.combat.xp += mob.xp;
                    if (functions.getPets().get(player) != null) {
                        ItemMeta petMeta = functions.getPets().get(player).getItemMeta();
                        double petModifier = 1.0;
                        if (petMeta.getPersistentDataContainer().get(new NamespacedKey(plugin, "petItem"),
                                PersistentDataType.STRING) != null) {
                            switch (petMeta.getPersistentDataContainer().get(new NamespacedKey(plugin, "petItem"),
                                    PersistentDataType.STRING)) {
                                case "Pet xp Boost":
                                    petModifier += 0.08;
                                    break;
                                case "Major xp Boost":
                                    petModifier += 0.2;
                                    break;
                                case "Combat xp Boost":
                                    petModifier += 0.25;
                                    break;
                                case "Greater Combat Boost":
                                    petModifier += 0.4;
                                    break;
                            }
                        }

                        if (petMeta.getPersistentDataContainer().get(new NamespacedKey(plugin, "petType"),
                            PersistentDataType.STRING).equals("Combat")) {
                            petMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "xp"),
                                    PersistentDataType.DOUBLE, petMeta.getPersistentDataContainer().get(new NamespacedKey(plugin, "xp"),
                                    PersistentDataType.DOUBLE) + (mob.xp * petModifier));
                        } else {
                            petMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "xp"),
                                PersistentDataType.DOUBLE, petMeta.getPersistentDataContainer().get(new NamespacedKey(plugin, "xp"),
                                PersistentDataType.DOUBLE) + (mob.xp * petModifier * .25));
                        }
                        functions.getPets().get(player).setItemMeta(petMeta);
                        functions.updatePet(player);
                    }
                    doDrops(player, mob);
                }
                skills.put(player.getUniqueId(), csd);

                String message = String.format(
                        "§3+%.1f/%.0f Combat XP",
                        skills.get(player.getUniqueId()).combat.xp,
                        skills.get(player.getUniqueId()).combat.xpNext
                );
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                        PersistentDataType.DOUBLE, 5.0);
                checkSkill(player, csd.combat.level, "Combat");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
        }
    }
}

