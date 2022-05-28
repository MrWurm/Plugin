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
import org.bukkit.inventory.meta.LeatherArmorMeta;
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
                    case "Shortbow Cord":
                        if (checkType(item, "bow") &&
                            item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "cord"),
                            PersistentDataType.INTEGER) == null) {
                            meta = item.getItemMeta();
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "cord"),
                                    PersistentDataType.INTEGER, 1);
                            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                                    PersistentDataType.DOUBLE) == null) {
                                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeed"),
                                    PersistentDataType.DOUBLE, 15.0);
                            } else {
                                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeed"),
                                    PersistentDataType.DOUBLE, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                                    PersistentDataType.DOUBLE) + 15);
                            }
                            item.setItemMeta(meta);
                            upgrade.setAmount(upgrade.getAmount() - 1);
                            value.updateItem(plugin, item);
                        } else {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                        }
                        break;
                    case "Armor Dye":
                        if (item != null &&
                            item.getType() == Material.LEATHER_HELMET ||
                            item.getType() == Material.LEATHER_CHESTPLATE ||
                            item.getType() == Material.LEATHER_LEGGINGS ||
                            item.getType() == Material.LEATHER_BOOTS ||
                            item.getType() == Material.LEATHER_HORSE_ARMOR) {
                            ItemMeta leatherMeta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
                            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) leatherMeta;
                            leatherArmorMeta.setColor(Color.fromRGB(inventory.getItem(34).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "color"),
                                    PersistentDataType.INTEGER_ARRAY)[0], inventory.getItem(34).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "color"),
                                    PersistentDataType.INTEGER_ARRAY)[1],inventory.getItem(34).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "color"),
                                    PersistentDataType.INTEGER_ARRAY)[2]));
                            item.setItemMeta(leatherMeta);
                            inventory.getItem(34).setAmount(inventory.getItem(34).getAmount() - 1);
                        } else {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                        }

                        break;
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
                        meta = item.getItemMeta();
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
                        meta = item.getItemMeta();
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
                        meta = item.getItemMeta();
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
                        meta = item.getItemMeta();
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
                        meta = item.getItemMeta();
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
                        meta = item.getItemMeta();
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
                        meta = item.getItemMeta();
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
                        meta = item.getItemMeta();
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
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Venomous");
                        item.setItemMeta(meta);
                        value.updateItem(plugin, item);
                        break;
                    case "Attachable Lantern":
                        //give an item the illuminating reforge

                        if (!checkType(item, "helmet")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }
                        upgrade.setAmount(upgrade.getAmount() - 1);
                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Illuminating");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Stimulating Gland":
                        //give an item the stimulating reforge
                        if (!checkType(item, "shield")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }
                        upgrade.setAmount(upgrade.getAmount() - 1);
                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Stimulating");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Discreet Sludge":
                        //give an item the camouflaged reforge
                        if (!checkType(item, "Armor")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }
                        upgrade.setAmount(upgrade.getAmount() - 1);
                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Camouflaged");
                        item.setItemMeta(meta);

                        value.updateItem(plugin, item);
                        break;
                    case "Relentless Lifeblood":
                        //give an item the tenacious reforge
                        if (!checkType(item, "chestplate")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }
                        upgrade.setAmount(upgrade.getAmount() - 1);
                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Tenacious");
                        item.setItemMeta(meta);
                        value.updateItem(plugin, item);
                        break;
                    case "Shady Augment":
                        //give an item the sawed-off reforge
                        if (!checkType(item, "bow")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }
                        upgrade.setAmount(upgrade.getAmount() - 1);
                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Sawed-Off");
                        item.setItemMeta(meta);
                        value.updateItem(plugin, item);
                        break;
                    case "Giant's Heart":
                        //give an item the sawed-off reforge
                        if (!checkType(item, "Armor")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }
                        upgrade.setAmount(upgrade.getAmount() - 1);
                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Gigantic");
                        item.setItemMeta(meta);
                        value.updateItem(plugin, item);
                        break;
                    case "Vile Blood":
                        //give an item the leaching reforge
                        if (!checkType(item, "bow")) {
                            player.sendMessage(ChatColor.RED + "Invalid option");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 60, 0);
                            return;
                        }
                        upgrade.setAmount(upgrade.getAmount() - 1);
                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"), PersistentDataType.STRING, "Leaching");
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