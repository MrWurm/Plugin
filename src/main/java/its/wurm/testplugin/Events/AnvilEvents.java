package its.wurm.testplugin.Events;
import its.wurm.testplugin.Inventories.*;
import its.wurm.testplugin.Items.Items;
import org.bukkit.*;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.AxolotlBucketMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class AnvilEvents implements Listener {

    Plugin plugin;

    public AnvilEvents(Plugin plugin) {
        this.plugin = plugin;
    }

    public void sucess(Player player, ItemStack item, String message) {
        String output = "You " + message + " your " + item.getItemMeta().getLocalizedName() + "";
        if (item.getItemMeta().getPersistentDataContainer() != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
            output = "You " + message + " your " + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING);
        }
        player.sendMessage(ChatColor.GREEN + output);
        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 60, 1);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Inventory inventory = e.getClickedInventory();
        if (e.getClickedInventory() == null) {
            return;
        }

        //Main GUI
        if (e.getClickedInventory().getHolder() instanceof AnvilGUI) {
            if (e.getSlot() != 28 &&
                    e.getSlot() != 34) {

                e.setCancelled(true);
            }

            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getSlot() == 49) {
                //go back
                MainGUI gui = new MainGUI(plugin, player);
                player.openInventory(gui.getInventory());
            }

            if (e.getSlot() == 13 &&
                    inventory.getItem(34) != null &&
                    inventory.getItem(34).getItemMeta() != null &&
                    inventory.getItem(34).getItemMeta().getPersistentDataContainer() != null &&
                    inventory.getItem(34).getItemMeta().getPersistentDataContainer() != null &&
                    inventory.getItem(34).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {

                if (inventory.getItem(28) == null ||
                    inventory.getItem(34) == null) {
                    return;
                }

                ItemStack item = inventory.getItem(28);
                ItemStack upgrade = inventory.getItem(34);

                Items value = Items.values()[1];
                ItemMeta meta = item.getItemMeta();

                if (item.getItemMeta() != null &&
                    item.getItemMeta().getPersistentDataContainer() != null &&
                    item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"),
                        PersistentDataType.INTEGER) != null) {
                    value = Items.values()[item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                }

                //anvil actions
                switch (inventory.getItem(34).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Renegade Crossbow":
                        if (inventory.getItem(28).getItemMeta() != null &&
                                    inventory.getItem(28).getItemMeta().getPersistentDataContainer() != null &&
                            inventory.getItem(28).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                    PersistentDataType.STRING) != null &&
                            inventory.getItem(28).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                    PersistentDataType.STRING).equals("Renegade Crossbow")) {
                            int amount = inventory.getItem(34).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Level"),
                                    PersistentDataType.INTEGER) + 1;
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "Level"),
                                PersistentDataType.INTEGER, amount + meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "Level"),
                                            PersistentDataType.INTEGER));

                            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "Level"),
                                    PersistentDataType.INTEGER) > 10) {
                                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "Level"),
                                        PersistentDataType.INTEGER, 10);
                                amount = 10 - inventory.getItem(34).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Level"),
                                        PersistentDataType.INTEGER);
                            }
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE) + (amount * 10));
                            switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "Level"),
                                    PersistentDataType.INTEGER)) {
                                case 5:
                                case 6:
                                case 7:
                                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"),
                                            PersistentDataType.STRING, "RARE");
                                    break;
                                case 8:
                                case 9:
                                case 10:
                                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"),
                                            PersistentDataType.STRING, "EPIC");
                                    break;
                            }
                            inventory.getItem(28).setItemMeta(meta);

                            inventory.setItem(34, new ItemStack(Material.AIR));
                            value.updateItem(plugin, inventory.getItem(28));

                        }
                        break;
                    case "Pot of Gold":
                        //gild an item
                        switch (item.getType()) {
                            case WOODEN_SWORD:
                            case STONE_SWORD:
                            case IRON_SWORD:
                            case DIAMOND_SWORD:
                            case NETHERITE_SWORD:
                                item.setType(Material.GOLDEN_SWORD);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WOODEN_AXE:
                            case STONE_AXE:
                            case IRON_AXE:
                            case DIAMOND_AXE:
                            case NETHERITE_AXE:
                                item.setType(Material.GOLDEN_AXE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WOODEN_HOE:
                            case STONE_HOE:
                            case IRON_HOE:
                            case DIAMOND_HOE:
                            case NETHERITE_HOE:
                                item.setType(Material.GOLDEN_HOE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WOODEN_SHOVEL:
                            case STONE_SHOVEL:
                            case IRON_SHOVEL:
                            case DIAMOND_SHOVEL:
                            case NETHERITE_SHOVEL:
                                item.setType(Material.GOLDEN_SHOVEL);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WOODEN_PICKAXE:
                            case STONE_PICKAXE:
                            case IRON_PICKAXE:
                            case DIAMOND_PICKAXE:
                            case NETHERITE_PICKAXE:
                                item.setType(Material.GOLDEN_PICKAXE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case LEATHER_HELMET:
                            case CHAINMAIL_HELMET:
                            case IRON_HELMET:
                            case DIAMOND_HELMET:
                            case NETHERITE_HELMET:
                                item.setType(Material.GOLDEN_HELMET);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case LEATHER_CHESTPLATE:
                            case CHAINMAIL_CHESTPLATE:
                            case IRON_CHESTPLATE:
                            case DIAMOND_CHESTPLATE:
                            case NETHERITE_CHESTPLATE:
                                item.setType(Material.GOLDEN_CHESTPLATE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case LEATHER_LEGGINGS:
                            case CHAINMAIL_LEGGINGS:
                            case IRON_LEGGINGS:
                            case DIAMOND_LEGGINGS:
                            case NETHERITE_LEGGINGS:
                                item.setType(Material.GOLDEN_LEGGINGS);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case LEATHER_BOOTS:
                            case CHAINMAIL_BOOTS:
                            case IRON_BOOTS:
                            case DIAMOND_BOOTS:
                            case NETHERITE_BOOTS:
                                item.setType(Material.GOLDEN_BOOTS);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case LEATHER_HORSE_ARMOR:
                            case IRON_HORSE_ARMOR:
                            case DIAMOND_HORSE_ARMOR:
                                item.setType(Material.GOLDEN_HORSE_ARMOR);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case ARROW:
                            case TIPPED_ARROW:
                                item.setType(Material.SPECTRAL_ARROW);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case STICK:
                            case BONE:
                                item.setType(Material.BLAZE_ROD);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case APPLE:
                                item.setType(Material.GOLDEN_APPLE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case SWEET_BERRIES:
                                item.setType(Material.GLOW_BERRIES);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case IRON_INGOT:
                            case COPPER_INGOT:
                            case NETHERITE_INGOT:
                            case BRICK:
                            case NETHER_BRICK:
                                item.setType(Material.GOLD_INGOT);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case RAW_COPPER:
                            case RAW_IRON:
                            case NETHERITE_SCRAP:
                                item.setType(Material.RAW_GOLD);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case CARROT:
                                item.setType(Material.GOLDEN_CARROT);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case MELON_SLICE:
                                item.setType(Material.GLISTERING_MELON_SLICE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case SLIME_BALL:
                                item.setType(Material.MAGMA_CREAM);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case SUGAR:
                            case REDSTONE:
                            case GUNPOWDER:
                                item.setType(Material.GLOWSTONE_DUST);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case GHAST_TEAR:
                            case IRON_NUGGET:
                                item.setType(Material.GOLD_NUGGET);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case BONE_MEAL:
                            case COCOA_BEANS:
                                item.setType(Material.BLAZE_POWDER);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case GLASS_BOTTLE:
                            case POTION:
                            case SPLASH_POTION:
                            case LINGERING_POTION:
                            case DRAGON_BREATH:
                                item.setType(Material.HONEY_BOTTLE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case MILK_BUCKET:
                            case WATER_BUCKET:
                            case POWDER_SNOW_BUCKET:
                            case COD_BUCKET:
                            case SALMON_BUCKET:
                            case TROPICAL_FISH_BUCKET:
                            case PUFFERFISH_BUCKET:
                            case BUCKET:
                                item.setType(Material.LAVA_BUCKET);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case AXOLOTL_BUCKET:
                                ItemStack axolotl = item;
                                AxolotlBucketMeta axolotlBucketMeta = (AxolotlBucketMeta) item.getItemMeta();
                                axolotlBucketMeta.setVariant(Axolotl.Variant.GOLD);
                                item.setItemMeta(meta);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case ANCIENT_DEBRIS:
                            case RAW_IRON_BLOCK:
                            case RAW_COPPER_BLOCK:
                                item.setType(Material.RAW_GOLD_BLOCK);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WHITE_WOOL:
                            case RED_WOOL:
                            case BLACK_WOOL:
                            case PURPLE_WOOL:
                            case PINK_WOOL:
                            case MAGENTA_WOOL:
                            case BLUE_WOOL:
                            case LIGHT_BLUE_WOOL:
                            case GRAY_WOOL:
                            case LIGHT_GRAY_WOOL:
                            case LIME_WOOL:
                            case GREEN_WOOL:
                            case BROWN_WOOL:
                            case CYAN_WOOL:
                            case ORANGE_WOOL:
                                item.setType(Material.YELLOW_WOOL);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WHITE_CARPET:
                            case RED_CARPET:
                            case BLACK_CARPET:
                            case PURPLE_CARPET:
                            case PINK_CARPET:
                            case MAGENTA_CARPET:
                            case BLUE_CARPET:
                            case LIGHT_BLUE_CARPET:
                            case GRAY_CARPET:
                            case LIGHT_GRAY_CARPET:
                            case LIME_CARPET:
                            case GREEN_CARPET:
                            case BROWN_CARPET:
                            case CYAN_CARPET:
                            case ORANGE_CARPET:
                                item.setType(Material.YELLOW_CARPET);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WHITE_STAINED_GLASS:
                            case RED_STAINED_GLASS:
                            case BLACK_STAINED_GLASS:
                            case PURPLE_STAINED_GLASS:
                            case PINK_STAINED_GLASS:
                            case MAGENTA_STAINED_GLASS:
                            case BLUE_STAINED_GLASS:
                            case LIGHT_BLUE_STAINED_GLASS:
                            case GRAY_STAINED_GLASS:
                            case LIGHT_GRAY_STAINED_GLASS:
                            case LIME_STAINED_GLASS:
                            case GREEN_STAINED_GLASS:
                            case BROWN_STAINED_GLASS:
                            case CYAN_STAINED_GLASS:
                            case ORANGE_STAINED_GLASS:
                                item.setType(Material.YELLOW_STAINED_GLASS);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WHITE_STAINED_GLASS_PANE:
                            case RED_STAINED_GLASS_PANE:
                            case BLACK_STAINED_GLASS_PANE:
                            case PURPLE_STAINED_GLASS_PANE:
                            case PINK_STAINED_GLASS_PANE:
                            case MAGENTA_STAINED_GLASS_PANE:
                            case BLUE_STAINED_GLASS_PANE:
                            case LIGHT_BLUE_STAINED_GLASS_PANE:
                            case GRAY_STAINED_GLASS_PANE:
                            case LIGHT_GRAY_STAINED_GLASS_PANE:
                            case LIME_STAINED_GLASS_PANE:
                            case GREEN_STAINED_GLASS_PANE:
                            case BROWN_STAINED_GLASS_PANE:
                            case CYAN_STAINED_GLASS_PANE:
                            case ORANGE_STAINED_GLASS_PANE:
                                item.setType(Material.YELLOW_STAINED_GLASS_PANE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WHITE_CONCRETE:
                            case RED_CONCRETE:
                            case BLACK_CONCRETE:
                            case PURPLE_CONCRETE:
                            case PINK_CONCRETE:
                            case MAGENTA_CONCRETE:
                            case BLUE_CONCRETE:
                            case LIGHT_BLUE_CONCRETE:
                            case GRAY_CONCRETE:
                            case LIGHT_GRAY_CONCRETE:
                            case LIME_CONCRETE:
                            case GREEN_CONCRETE:
                            case BROWN_CONCRETE:
                            case CYAN_CONCRETE:
                            case ORANGE_CONCRETE:
                                item.setType(Material.YELLOW_CONCRETE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WHITE_CONCRETE_POWDER:
                            case RED_CONCRETE_POWDER:
                            case BLACK_CONCRETE_POWDER:
                            case PURPLE_CONCRETE_POWDER:
                            case PINK_CONCRETE_POWDER:
                            case MAGENTA_CONCRETE_POWDER:
                            case BLUE_CONCRETE_POWDER:
                            case LIGHT_BLUE_CONCRETE_POWDER:
                            case GRAY_CONCRETE_POWDER:
                            case LIGHT_GRAY_CONCRETE_POWDER:
                            case LIME_CONCRETE_POWDER:
                            case GREEN_CONCRETE_POWDER:
                            case BROWN_CONCRETE_POWDER:
                            case CYAN_CONCRETE_POWDER:
                            case ORANGE_CONCRETE_POWDER:
                                item.setType(Material.YELLOW_CONCRETE_POWDER);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case WHITE_BED:
                            case RED_BED:
                            case BLACK_BED:
                            case PURPLE_BED:
                            case PINK_BED:
                            case MAGENTA_BED:
                            case BLUE_BED:
                            case LIGHT_BLUE_BED:
                            case GRAY_BED:
                            case LIGHT_GRAY_BED:
                            case LIME_BED:
                            case GREEN_BED:
                            case BROWN_BED:
                            case CYAN_BED:
                            case ORANGE_BED:
                                item.setType(Material.YELLOW_BED);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case CANDLE:
                            case WHITE_CANDLE:
                            case RED_CANDLE:
                            case BLACK_CANDLE:
                            case PURPLE_CANDLE:
                            case PINK_CANDLE:
                            case MAGENTA_CANDLE:
                            case BLUE_CANDLE:
                            case LIGHT_BLUE_CANDLE:
                            case GRAY_CANDLE:
                            case LIGHT_GRAY_CANDLE:
                            case LIME_CANDLE:
                            case GREEN_CANDLE:
                            case BROWN_CANDLE:
                            case CYAN_CANDLE:
                            case ORANGE_CANDLE:
                                item.setType(Material.YELLOW_CANDLE);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            case SLIME_BLOCK:
                                item.setType(Material.HONEY_BLOCK);
                                sucess(player, inventory.getItem(28), "gilded");
                                upgrade.setAmount(upgrade.getAmount() - 1);
                                break;
                            default:
                                player.sendMessage(ChatColor.RED + "You cannot gild that item!");
                                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                                return;
                        }
                        break;
                    case "Test Stone":
                        //give an item the reforged reforge

                        upgrade.setAmount(upgrade.getAmount() - 1);

                        refreshStats(item);

                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDamage"), PersistentDataType.DOUBLE, 1.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, 1.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, 1.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, 1.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, 1.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, 1.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, 0.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, 1.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, 1.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, 1.0);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeMagic"), PersistentDataType.DOUBLE, 1.0);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Reforged");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;

                    case "Prismatic Stone":
                        //give an item the prismatic reforge

                        if (!(checkType(item, "Armor"))) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }

                        upgrade.setAmount(upgrade.getAmount() - 1);

                        double intelligencePrismatic;
                        double thaumaturgyPrismatic;

                        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING)) {
                            case "COMMON":
                                intelligencePrismatic = 25;
                                thaumaturgyPrismatic = 5;
                                break;
                            case "UNCOMMON":
                                intelligencePrismatic = 40;
                                thaumaturgyPrismatic = 10;
                                break;
                            case "RARE":
                                intelligencePrismatic = 75;
                                thaumaturgyPrismatic = 16;
                                break;
                            case "EPIC":
                                intelligencePrismatic = 120;
                                thaumaturgyPrismatic = 25;
                                break;
                            case "LEGENDARY":
                                intelligencePrismatic = 160;
                                thaumaturgyPrismatic = 40;
                                break;
                            case "MYTHIC":
                                intelligencePrismatic = 210;
                                thaumaturgyPrismatic = 65;
                                break;
                            default:
                                intelligencePrismatic = 10;
                                thaumaturgyPrismatic = 3;
                                break;
                        }

                        refreshStats(item);

                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, intelligencePrismatic);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeThaumaturgy"), PersistentDataType.DOUBLE, thaumaturgyPrismatic);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Prismatic");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Whetstone":
                        //give an item the sharp reforge

                        if (!checkType(item, "sword")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }

                        upgrade.setAmount(upgrade.getAmount() - 1);

                        double critSharp;
                        double ccSharp;

                        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING)) {
                            case "COMMON":
                                critSharp = 7;
                                ccSharp = 1;
                                break;
                            case "UNCOMMON":
                                critSharp = 12;
                                ccSharp = 2;
                                break;
                            case "RARE":
                                critSharp = 16;
                                ccSharp = 3;
                                break;
                            case "EPIC":
                                critSharp = 21;
                                ccSharp = 5;
                                break;
                            case "LEGENDARY":
                                critSharp = 27;
                                ccSharp = 7;
                                break;
                            case "MYTHIC":
                                critSharp = 35;
                                ccSharp = 12;
                                break;
                            default:
                                critSharp = 3;
                                ccSharp = 1;
                                break;
                        }

                        refreshStats(item);

                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, critSharp);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, ccSharp);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Sharp");
                            item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Chunk of Meat":
                        //give an item the meaty reforge

                        if (!checkType(item, "Armor")) {
                            player.sendMessage(ChatColor.RED + "Invalid option1");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }

                        upgrade.setAmount(upgrade.getAmount() - 1);

                        double healthMeaty;
                        double strengthMeaty;

                        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING)) {
                            case "COMMON":
                                healthMeaty = 9;
                                strengthMeaty = 0;
                                break;
                            case "UNCOMMON":
                                healthMeaty = 15;
                                strengthMeaty = 0;
                                break;
                            case "RARE":
                                healthMeaty = 23;
                                strengthMeaty = 0;
                                break;
                            case "EPIC":
                                healthMeaty = 31;
                                strengthMeaty = 4;
                                break;
                            case "LEGENDARY":
                                healthMeaty = 47;
                                strengthMeaty = 7;
                                break;
                            case "MYTHIC":
                                healthMeaty = 55;
                                strengthMeaty = 13;
                                break;
                            default:
                                healthMeaty = 2;
                                strengthMeaty = 0;
                                break;
                        }

                        refreshStats(item);

                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, healthMeaty);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, strengthMeaty);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Meaty");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Old Vase":
                        //give an item the antique reforge
                        if (checkType(inventory.getItem(28), "wand") == false) {
                            player.sendMessage(ChatColor.RED + "Invalid option1");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }

                        upgrade.setAmount(upgrade.getAmount() - 1);

                        double intAntique;
                        double invocationAntique;

                        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING)) {
                            case "COMMON":
                                intAntique = 12;
                                invocationAntique = 5;
                                break;
                            case "UNCOMMON":
                                intAntique = 18;
                                invocationAntique = 8;
                                break;
                            case "RARE":
                                intAntique = 35;
                                invocationAntique = 13;
                                break;
                            case "EPIC":
                                intAntique = 44;
                                invocationAntique = 18;
                                break;
                            case "LEGENDARY":
                                intAntique = 60;
                                invocationAntique = 25;
                                break;
                            case "MYTHIC":
                                intAntique = 74;
                                invocationAntique = 31;
                                break;
                            default:
                                intAntique = 4;
                                invocationAntique = 1;
                                break;
                        }

                        refreshStats(item);

                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeIntelligence"), PersistentDataType.DOUBLE, intAntique);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeInvocation"), PersistentDataType.DOUBLE, invocationAntique);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Antique");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Hair Trigger":
                        //give an item the repeating reforge

                        if (!checkType(item, "bow")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }

                        upgrade.setAmount(upgrade.getAmount() - 1);

                        double critRepeating;
                        double strengthRepeating;

                        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING)) {
                            case "COMMON":
                                critRepeating = 4;
                                strengthRepeating = 6;
                                break;
                            case "UNCOMMON":
                                critRepeating = 7;
                                strengthRepeating = 11;
                                break;
                            case "RARE":
                                critRepeating = 10;
                                strengthRepeating = 17;
                                break;
                            case "EPIC":
                                critRepeating = 16;
                                strengthRepeating = 25;
                                break;
                            case "LEGENDARY":
                                critRepeating = 21;
                                strengthRepeating = 34;
                                break;
                            case "MYTHIC":
                                critRepeating = 27;
                                strengthRepeating = 46;
                                break;
                            default:
                                critRepeating = 2;
                                strengthRepeating = 5;
                                break;
                        }

                        refreshStats(item);

                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, critRepeating);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, strengthRepeating);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Repeating");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Living Honey":
                        //give an item the gooey reforge

                        if (!checkType(item, "Armor")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }

                        upgrade.setAmount(upgrade.getAmount() - 1);

                        double healthGooey;
                        double strengthGooey;
                        double speedGooey;

                        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING)) {
                            case "COMMON":
                                healthGooey = 10;
                                strengthGooey = 4;
                                speedGooey = -3;
                                break;
                            case "UNCOMMON":
                                healthGooey = 14;
                                strengthGooey = 6;
                                speedGooey = -5;
                                break;
                            case "RARE":
                                healthGooey = 21;
                                strengthGooey = 10;
                                speedGooey = -8;
                                break;
                            case "EPIC":
                                healthGooey = 34;
                                strengthGooey = 16;
                                speedGooey = -13;
                                break;
                            case "LEGENDARY":
                                healthGooey = 47;
                                strengthGooey = 22;
                                speedGooey = -17;
                                break;
                            case "MYTHIC":
                                healthGooey = 72;
                                strengthGooey = 31;
                                speedGooey = -22;
                                break;
                            default:
                                healthGooey = 4;
                                strengthGooey = 2;
                                speedGooey = -1;
                                break;
                        }

                        refreshStats(item);

                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeHealth"), PersistentDataType.DOUBLE, healthGooey);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, strengthGooey);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeSpeed"), PersistentDataType.DOUBLE, speedGooey);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Gooey");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Rusty Cog":
                        //give an item the rusty reforge

                        if (!checkType(item, "Armor")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }

                        upgrade.setAmount(upgrade.getAmount() - 1);

                        double defenseRusty;
                        double strengthRusty;
                        double critRusty;

                        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING)) {
                            case "COMMON":
                                defenseRusty = 4;
                                strengthRusty = 1;
                                critRusty = 2;
                                break;
                            case "UNCOMMON":
                                defenseRusty = 6;
                                strengthRusty = 2;
                                critRusty = 3;
                                break;
                            case "RARE":
                                defenseRusty = 9;
                                strengthRusty = 3;
                                critRusty = 5;
                                break;
                            case "EPIC":
                                defenseRusty = 13;
                                strengthRusty = 6;
                                critRusty = 8;
                                break;
                            case "LEGENDARY":
                                defenseRusty = 20;
                                strengthRusty = 9;
                                critRusty = 11;
                                break;
                            case "MYTHIC":
                                defenseRusty = 26;
                                strengthRusty = 13;
                                critRusty = 15;
                                break;
                            default:
                                defenseRusty = 2;
                                strengthRusty = 1;
                                critRusty = 1;
                                break;
                        }

                        refreshStats(item);

                        meta = item.getItemMeta();
                        if (item.getType() == Material.IRON_HELMET || item.getType() == Material.IRON_CHESTPLATE ||
                            item.getType() == Material.IRON_LEGGINGS || item.getType() == Material.IRON_BOOTS ||
                            item.getType() == Material.CHAINMAIL_HELMET || item.getType() == Material.CHAINMAIL_CHESTPLATE ||
                            item.getType() == Material.CHAINMAIL_LEGGINGS || item.getType() == Material.CHAINMAIL_BOOTS) {
                            defenseRusty *= 2;
                            strengthRusty *= 2;
                            critRusty *= 2;
                        }
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeDefense"), PersistentDataType.DOUBLE, defenseRusty);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeStrength"), PersistentDataType.DOUBLE, strengthRusty);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, critRusty);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Rusty");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Venomous Fang":
                        //give an item the venomous reforge

                        if (!checkType(item, "sword")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }

                        upgrade.setAmount(upgrade.getAmount() - 1);

                        double attackSpeedVenomous;
                        double CCVenomous;
                        double critVenomous;

                        switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING)) {
                            case "COMMON":
                                attackSpeedVenomous = 7;
                                CCVenomous = 1;
                                critVenomous = 4;
                                break;
                            case "UNCOMMON":
                                attackSpeedVenomous = 11;
                                CCVenomous = 3;
                                critVenomous = 6;
                                break;
                            case "RARE":
                                attackSpeedVenomous = 15;
                                CCVenomous = 5;
                                critVenomous = 9;
                                break;
                            case "EPIC":
                                attackSpeedVenomous = 21;
                                CCVenomous = 8;
                                critVenomous = 14;
                                break;
                            case "LEGENDARY":
                                attackSpeedVenomous = 37;
                                CCVenomous = 11;
                                critVenomous = 19;
                                break;
                            case "MYTHIC":
                                attackSpeedVenomous = 53;
                                CCVenomous = 16;
                                critVenomous = 26;
                                break;
                            default:
                                attackSpeedVenomous = 4;
                                CCVenomous = 0;
                                critVenomous = 2;
                                break;
                        }

                        refreshStats(item);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeAttackSpeed"), PersistentDataType.DOUBLE, attackSpeedVenomous);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCC"), PersistentDataType.DOUBLE, CCVenomous);
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeCrit"), PersistentDataType.DOUBLE, critVenomous);

                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Venomous");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "Invalid option");
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                        break;
                }
            }
        }
    }

    public void refreshStats(ItemStack item) {
        ItemMeta meta = item.getItemMeta();

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
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeManaModifier"), PersistentDataType.DOUBLE, 0.0);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "ReforgeManaSave"), PersistentDataType.DOUBLE, 0.0);

        item.setItemMeta(meta);

    }

    public boolean checkType(ItemStack item, String category) {
        String type = "null";
        boolean True = false;
        if (item.getItemMeta() != null &&
            item.getItemMeta() != null &&
            item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                    PersistentDataType.STRING) != null) {
            type = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                    PersistentDataType.STRING);
        }

        if (category.equals("Armor")) {
            switch (type) {
                case "helmet":
                case "chestplate":
                case "leggings":
                case "boots":
                    True = true;
                    break;
                default:
                    break;
            }
        }

        if (type .equals(category)) {
            True = true;
        }

        return True;
    }
}