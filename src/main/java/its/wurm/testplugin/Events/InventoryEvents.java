package its.wurm.testplugin.Events;
import its.wurm.testplugin.Inventories.FormatRecipesGUI;
import its.wurm.testplugin.Inventories.*;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.persistentDataContainers.stringList;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

public class InventoryEvents implements Listener {

    Plugin plugin;
    StatFunctions functions;
    Map<UUID, PlayerInventoryGUI> player_inventory = new HashMap<>();

    public InventoryEvents(Plugin plugin, StatFunctions functions) {
        this.plugin = plugin;
        this.functions = functions;
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        if (event.getInventory() == null || !(event.getPlayer() instanceof Player)) {
            return;
        }
        Inventory inventory = event.getInventory();
        InventoryHolder holder = inventory.getHolder();
        Player player = (Player)event.getPlayer();

        if (holder instanceof AnvilGUI) {
            if (inventory.getItem(28) != null) {
                player.getInventory().addItem(inventory.getItem(28));
            }
            if (inventory.getItem(34) != null) {
                player.getInventory().addItem(inventory.getItem(34));
            }
        }

        if (holder instanceof FormatEnchantmentGUI) {
            if (inventory.getItem(31) != null) {
                player.getInventory().addItem(inventory.getItem(31));
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (e.getClickedInventory() == null) {
            return;
        }
        InventoryHolder holder = e.getClickedInventory().getHolder();

        if ((e.getAction() == InventoryAction.SWAP_WITH_CURSOR ||
            e.getAction() == InventoryAction.COLLECT_TO_CURSOR) &&
            e.getCurrentItem() != null &&
            e.getCurrentItem().getItemMeta() != null &&
            e.getCurrentItem().getItemMeta().getPersistentDataContainer() != null &&
            e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                PersistentDataType.INTEGER) != null &&
            e.getCursor() != null) {
            e.setCancelled(true);
            ItemStack pick = e.getCurrentItem();
            ItemStack fuel = e.getCursor();
            String id = "";
            int value = 0;
            boolean consume = true;
            ItemMeta meta;
            Items itemValue;
            switch (pick.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "Magmaton Furnace F2713":
                    if (fuel.getItemMeta() != null &&
                        fuel.getItemMeta().getPersistentDataContainer() != null &&
                        fuel.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        id = fuel.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }

                    switch (fuel.getType()) {
                        case COAL:
                            switch (id) {
                                case "":
                                    value += 6;
                                    break;
                                case "Enchanted Coal":
                                    value += 52;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case CHARCOAL:
                            switch (id) {
                                case "":
                                    value += 8;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case COAL_BLOCK:
                            switch (id) {
                                case "":
                                    value += 60;
                                    break;
                                case "Enchanted Coal Block":
                                    value += 620;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case BLAZE_POWDER:
                            switch (id) {
                                case "":
                                    value += 6;
                                    break;
                                case "Enchanted Blaze Powder":
                                    value += 72;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case BLAZE_ROD:
                            switch (id) {
                                case "":
                                    value += 12;
                                    break;
                                case "Enchanted Blaze Rod":
                                    value += 1080;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case MAGMA_CREAM:
                            switch (id) {
                                case "":
                                    value += 7;
                                    break;
                                case "Enchanted Magma Cream":
                                    value += 70;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case MAGMA_BLOCK:
                            switch (id) {
                                case "":
                                    value += 10;
                                case "Enchanted Magma Block":
                                    value += 900;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case LAVA_BUCKET:
                            switch (id) {
                                case "":
                                    value += 30;
                                    consume = false;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        default:
                            return;
                    }

                    value *= fuel.getAmount();
                    meta = pick.getItemMeta();
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "fuel"),
                        PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                            PersistentDataType.INTEGER) + value);
                    if (consume) {
                        fuel.setAmount(0);
                    } else {
                        fuel.setType(Material.BUCKET);
                    }
                    pick.setItemMeta(meta);
                    itemValue = Items.values()[pick.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                    itemValue.updateItem(plugin, pick);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ITEM_FIRECHARGE_USE, 40, 1);
                    break;
                case "Aether Drive F117":
                    if (fuel.getItemMeta() != null &&
                        fuel.getItemMeta().getPersistentDataContainer() != null &&
                        fuel.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        id = fuel.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING);
                    }

                    switch (fuel.getType()) {
                        case END_STONE:
                            switch (id) {
                                case "":
                                    value += 1;
                                    break;
                                case "Enchanted End Stone":
                                    value += 11;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case ENDER_PEARL:
                            switch (id) {
                                case "":
                                    value += 3;
                                    break;
                                case "Enchanted Ender Pearl":
                                    value += 32;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case ENDER_EYE:
                            switch (id) {
                                case "":
                                    value += 5;
                                    break;
                                case "Enchanted Eye of Ender":
                                    value += 144;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case CHORUS_FRUIT:
                            switch (id) {
                                case "":
                                    value += 2;
                                    break;
                                case "Enchanted Chorus Fruit":
                                    value += 10;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case POPPED_CHORUS_FRUIT:
                            switch (id) {
                                case "":
                                    value += 3;
                                    break;
                                case "Enchanted Popped Chorus Fruit":
                                    value += 110;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case CHORUS_FLOWER:
                            switch (id) {
                                case "":
                                    value += 5;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        default:
                            return;
                    }

                    value *= fuel.getAmount();
                    meta = pick.getItemMeta();
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "fuel"),
                        PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                        PersistentDataType.INTEGER) + value);
                    fuel.setAmount(0);
                    pick.setItemMeta(meta);
                    itemValue = Items.values()[pick.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                    itemValue.updateItem(plugin, pick);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_ENDER_EYE_DEATH, 40, 0);
                    break;
                case "Compacted Peat Moss":
                    if (fuel.getItemMeta() != null &&
                        fuel.getItemMeta().getPersistentDataContainer() != null &&
                        fuel.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        id = fuel.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }

                    switch (fuel.getType()) {
                        case MOSS_BLOCK:
                            switch (id) {
                                case "":
                                    value += 1;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case BONE_MEAL:
                            switch (id) {
                                case "":
                                    value += 2;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case BONE:
                            switch (id) {
                                case "":
                                    value += 8;
                                    break;
                                case "Enchanted Bone":
                                    value += 72;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case BONE_BLOCK:
                            switch (id) {
                                case "":
                                    value += 20;
                                    break;
                                case "Enchanted Bone Block":
                                    value += 792;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        case MOSS_CARPET:
                            switch (id) {
                                case "":
                                    value += 1;
                                    break;
                                default:
                                    return;
                            }
                            break;
                        default:
                            return;
                    }

                    value *= fuel.getAmount();
                    meta = pick.getItemMeta();
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "fuel"),
                            PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                                    PersistentDataType.INTEGER) + value);
                    fuel.setAmount(0);
                    pick.setItemMeta(meta);
                    itemValue = Items.values()[pick.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                    itemValue.updateItem(plugin, pick);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ITEM_BONE_MEAL_USE, 40, 1);
                    break;
            }
        }
        //Player Inventory GUI
        if (holder instanceof PlayerInventoryGUI) {
            e.setCancelled(true);
        }

        //Main GUI
        if (holder instanceof MainGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            switch (e.getSlot()) {
                case 20:
                    //open Pets GUI
                    player.openInventory(new PetsGUI(plugin, player).getInventory());
                    break;
                case 25:
                    //open Ender Chest GUI
                    player.openInventory(player.getEnderChest());
                    return;
                case 29:
                    //open Anvil GUI
                    player.openInventory(new AnvilGUI(plugin).getInventory());
                    return;
                case 30:
                    //open Recipes gui
                    player.openInventory(new RecipeSelectGUI(plugin).getInventory());
                    return;
                case 31:
                    //open Enchantments gui
                    player.openInventory(new EnchantmentsGUI1(plugin).getInventory());
                    return;
                case 46:
                    player.openInventory(new SettingsGUI(plugin, player).getInventory());
                    return;
                case 49:
                    //close the gui
                    player.closeInventory();
                    return;
                case 51:
                    //open the sacks gui
                    player.openInventory(new SacksGUI(plugin, player).getInventory());
                    return;
                default:
                    return;
            }

        }

        //Settings GUI
        if (holder instanceof SettingsGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            switch (e.getSlot()) {
                case 0:
                    if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "peace"),
                            PersistentDataType.INTEGER) == 0) {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "peace"),
                                PersistentDataType.INTEGER, 1);
                    } else {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "peace"),
                                PersistentDataType.INTEGER, 0);
                    }
                    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 40, 0.4f);
                    player.openInventory(new SettingsGUI(plugin, player).getInventory());
                    return;
                case 1:
                    if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "noise"),
                            PersistentDataType.INTEGER) == 0) {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "noise"),
                                PersistentDataType.INTEGER, 1);
                    } else {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "noise"),
                                PersistentDataType.INTEGER, 0);
                    }
                    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 40, 2f);
                    player.openInventory(new SettingsGUI(plugin, player).getInventory());
                    return;
                case 2:
                    //open smelt settings gui
                    player.openInventory(new SmeltToggles(plugin, player).getInventory());
                    return;
                case 8:
                    //go back
                    player.openInventory(new MainGUI(plugin, player).getInventory());
                    return;
                default:
                    return;
            }
        }

        //Smelt Toggles GUI
        if (holder instanceof SmeltToggles) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            int[] toggles = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "smeltToggles"),
                    PersistentDataType.INTEGER_ARRAY);
            switch (e.getSlot()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    if (toggles[e.getSlot()] == 1) {
                        toggles[e.getSlot()] = 0;
                    } else {
                        toggles[e.getSlot()] = 1;
                    }
                    player.getWorld().playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, 40, 1);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "smeltToggles"),
                            PersistentDataType.INTEGER_ARRAY, toggles);
                    player.openInventory(new SmeltToggles(plugin, player).getInventory());
                    return;
                case 17:
                    //go back
                    player.openInventory(new SettingsGUI(plugin, player).getInventory());
                    return;
                default:
                    return;
            }
        }

        if (holder instanceof RecipeSelectGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case IRON_SWORD:
                    //open weapon gui
                    WeaponsSelectGUI weaponsSelectGUI = new WeaponsSelectGUI(plugin);
                    player.openInventory(weaponsSelectGUI.getInventory());
                    return;
                case CHAINMAIL_CHESTPLATE:
                    //open armor gui
                    ArmorSelectGUI armorSelectGUI = new ArmorSelectGUI(plugin);
                    player.openInventory(armorSelectGUI.getInventory());
                    return;
                case POWDER_SNOW_BUCKET:
                    //open misc gui
                    MiscSelectGUI miscSelectGUI = new MiscSelectGUI(plugin);
                    player.openInventory(miscSelectGUI.getInventory());
                    return;
                case COAL:
                    //open materials gui
                    MaterialsSelectGUI materialsSelectGUI = new MaterialsSelectGUI(plugin);
                    player.openInventory(materialsSelectGUI.getInventory());
                    return;
                case PLAYER_HEAD:
                    //open materials gui
                    StonesSelectGUI stonesGUI = new StonesSelectGUI(plugin);
                    player.openInventory(stonesGUI.getInventory());
                    return;
                case ARROW:
                    MainGUI mainGUI = new MainGUI(plugin, player);
                    player.openInventory(mainGUI.getInventory());
                default:
                    return;
            }
        }

        //misc gui recipes
        if (holder instanceof MiscSelectGUI ||
            holder instanceof MaterialsSelectGUI ||
            holder instanceof MaterialsSelectGUI2 ||
            holder instanceof MaterialsSelectGUI3 ||
            holder instanceof MaterialsSelectGUI4 ||
            holder instanceof WeaponsSelectGUI ||
            holder instanceof ArmorSelectGUI ||
            holder instanceof StonesSelectGUI ||
            holder instanceof FormatRecipesGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }

            if (e.getSlot() < 45) {
                if (Items.values()[e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)] == null) {
                    return;
                }
                Items value = Items.values()[e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                if (value.recipeGUI == null) {
                    return;
                }

                player.openInventory(value.recipeGUI.apply(plugin, holder).getInventory());
            }

            if (e.getSlot() == 45) {
                if (holder instanceof MaterialsSelectGUI2) {
                    player.openInventory(new MaterialsSelectGUI(plugin).getInventory());
                }
                if (holder instanceof MaterialsSelectGUI3) {
                    player.openInventory(new MaterialsSelectGUI2(plugin).getInventory());
                }
                if (holder instanceof MaterialsSelectGUI4) {
                    player.openInventory(new MaterialsSelectGUI3(plugin).getInventory());
                }
            }

            if (e.getSlot() == 49) {
                if (holder instanceof FormatRecipesGUI) {
                    player.openInventory(((FormatRecipesGUI) holder).getBackArrow());
                } else {
                    player.openInventory(new RecipeSelectGUI(plugin).getInventory());
                }
            }

            if (e.getSlot() == 53) {
                if (holder instanceof MaterialsSelectGUI) {
                    player.openInventory(new MaterialsSelectGUI2(plugin).getInventory());
                }
                if (holder instanceof MaterialsSelectGUI2) {
                    player.openInventory(new MaterialsSelectGUI3(plugin).getInventory());
                }
                if (holder instanceof MaterialsSelectGUI3) {
                    player.openInventory(new MaterialsSelectGUI4(plugin).getInventory());
                }
            }
        }

        if (holder instanceof EnchantmentsGUI1) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null) {
                return;
            }
            switch (e.getSlot()) {
                case 28:
                    player.openInventory(FormatEnchantmentGUI.newEfficiencyGUI(plugin, player, holder).getInventory());
                    return;
                case 49:
                    player.openInventory(new MainGUI(plugin, player).getInventory());
                    return;
                case 53:
                    player.openInventory(new EnchantmentsGUI2(plugin).getInventory());
                    return;
                default:
                    player.sendMessage(ChatColor.RED + "Looks like wurm has not added a way to obtain this enchantment yet!");
                    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 120, 0);
                    return;
            }
        }

        if (holder instanceof EnchantmentsGUI2) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null) {
                return;
            }
            switch (e.getSlot()) {
                case 31:
                    player.openInventory(FormatEnchantmentGUI.newSmeltGUI(plugin, player, holder).getInventory());
                    return;
                case 45:
                    player.openInventory(new EnchantmentsGUI1(plugin).getInventory());
                    return;
                case 49:
                    player.openInventory(new MainGUI(plugin, player).getInventory());
                    return;
                default:
                    player.sendMessage(ChatColor.RED + "Looks like wurm has not added a way to obtain this enchantment yet!");
                    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 120, 0);
                    return;
            }
        }

        if (holder instanceof FormatEnchantmentGUI) {
            if (e.getSlot() != 31) {
                e.setCancelled(true);
            }
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getSlot() == 49) {
                player.openInventory(((FormatEnchantmentGUI)holder).getBackArrow());
                return;
            }

            if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
                String[] enchantments = player.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentsAvailable"), new stringList());
                int[] levels = player.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentsLevel"), PersistentDataType.INTEGER_ARRAY);
                String name = ((FormatEnchantmentGUI)holder).getEnchantment();
                int index = Arrays.asList(enchantments).indexOf(name);
                if (index != - 1) {
                    index = levels[index] - 1;
                }

                if (index == e.getSlot() - 12) {
                    List<String> idList = new ArrayList<>();
                    for (int i = 0; i < ((FormatEnchantmentGUI)holder).getMaterials().get(index + 1).size(); i++) {
                        idList.add(((FormatEnchantmentGUI)holder).getMaterials().get(index + 1).get(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING));
                    }
                    boolean afford = checkMats(player, idList,
                        ((FormatEnchantmentGUI)holder).getStackSize().get(e.getSlot() - 11), true);
                    if (afford) {
                        player.sendMessage(ChatColor.GREEN + "You have unlocked " + e.getCurrentItem().getItemMeta().getDisplayName() + ChatColor.GREEN + "!");
                        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 120, 1);

                        if (index != -1) {
                            levels[Arrays.asList(enchantments).indexOf(name)] = 1 + levels[Arrays.asList(enchantments).indexOf(name)];
                        } else {
                            levels = Arrays.copyOf(levels, levels.length + 1);
                            levels[levels.length - 1] = 1;
                            enchantments = Arrays.copyOf(enchantments, enchantments.length + 1);
                            enchantments[enchantments.length - 1] = name;
                        }
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin,"enchantmentsAvailable"), new stringList(), enchantments);
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin,"enchantmentsLevel"), PersistentDataType.INTEGER_ARRAY, levels);
                        ((FormatEnchantmentGUI)holder).reloadInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have enough resources to unlock this enchantment!");
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 120, 0);
                    }
                }

                if (index > e.getSlot() - 12) {
                    List<String> types = new ArrayList<>();
                    switch (((FormatEnchantmentGUI)holder).getReturnType()) {
                        case "Armor":
                            types.add("helmet");
                            types.add("chestplate");
                            types.add("leggings");
                            types.add("boots");
                            break;
                        case "Tools":
                            types.add("pickaxe");
                            types.add("hoe");
                            types.add("shovel");
                            types.add("axe");
                            break;
                        case "Shields":
                            types.add("shield");
                            break;
                        case "Helmets":
                            types.add("helmet");
                            break;
                        case "Chestplates":
                            types.add("chestplate");
                            break;
                        case "Leggings":
                            types.add("leggings");
                            break;
                        case "Boots":
                            types.add("boots");
                            break;
                        case "Bows":
                            types.add("bow");
                            break;
                        case "Swords":
                            types.add("sword");
                            break;
                        case "Hoes":
                            types.add("hoe");
                            break;
                        case "Pickaxes":
                            types.add("pickaxes");
                            break;
                        case "Shovels":
                            types.add("shovel");
                            break;
                        case "Axes":
                            types.add("axe");
                            break;
                    }
                    if (e.getInventory().getItem(31) == null ||
                        e.getInventory().getItem(31).getItemMeta() == null ||
                        e.getInventory().getItem(31).getItemMeta().getPersistentDataContainer() == null ||
                        e.getInventory().getItem(31).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING) == null ||
                        !(types.contains(e.getInventory().getItem(31).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"type"), PersistentDataType.STRING)))) {
                        player.sendMessage(ChatColor.RED + "You must put in a valid item to enchant!");
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 120, 0);
                        return;
                    }
                    ItemStack item = e.getInventory().getItem(31);
                    int cost = 0;
                    switch (e.getSlot() - 12) {
                        case 0:
                            cost = 3;
                            break;
                        case 1:
                            cost = 8;
                            break;
                        case 2:
                            cost = 15;
                            break;
                        case 3:
                            cost = 24;
                            break;
                        case 4:
                            cost = 30;
                            break;
                    }

                    if (player.getLevel() < cost) {
                        player.sendMessage(ChatColor.RED + "You do not have enough experience to apply this enchantment!");
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 120, 0);
                        return;
                    }

                    functions.addEnchant(item, ((FormatEnchantmentGUI)holder).getEnchantment(), e.getSlot() - 10);
                    player.setLevel(player.getLevel() - cost);
                    ChatColor color = ChatColor.WHITE;
                    switch(e.getInventory().getItem(31).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"rarity"), PersistentDataType.STRING)) {
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
                    player.sendMessage(ChatColor.GREEN + "You enchanted your " + color + e.getInventory().getItem(31).getItemMeta().getDisplayName() + " with "
                        + ChatColor.BLUE + ((FormatEnchantmentGUI)holder).getEnchantment() + " " + (e.getSlot() - 10) + "");
                    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 120, 1);
                }

                if (index < e.getSlot() - 12) {
                    player.sendMessage(ChatColor.RED + "You do not have access to this enchantment yet!");
                    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 120, 0);
                }
            }
        }

        if (holder instanceof BrewingStandGUI) {
            if (e.getSlot() != 13 &&
                e.getSlot() != 38 &&
                e.getSlot() != 40 &&
                e.getSlot() != 42) {
                e.setCancelled(true);
            }
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            ItemStack item = new ItemStack(Material.BROWN_CARPET);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<>();
            switch (e.getSlot()) {
                case 2:
                    if (!(e.getInventory().getItem(2).getType() == Material.YELLOW_STAINED_GLASS_PANE)) {
                        player.getInventory().addItem(e.getInventory().getItem(e.getSlot()));
                        item.setType(Material.YELLOW_STAINED_GLASS_PANE);
                        meta.setDisplayName(ChatColor.YELLOW + "Amplifier");
                        lore.add(ChatColor.YELLOW + "Click an appropriate item to insert it!");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        e.getInventory().setItem(2, item);
                    }
                    break;
                case 4:
                    if (!(e.getInventory().getItem(4).getType() == Material.GREEN_STAINED_GLASS_PANE)) {
                        player.getInventory().addItem(e.getInventory().getItem(e.getSlot()));
                        item.setType(Material.GREEN_STAINED_GLASS_PANE);
                        meta.setDisplayName(ChatColor.DARK_GREEN + "Base");
                        lore.add(ChatColor.YELLOW + "Click an appropriate item to insert it!");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        e.getInventory().setItem(4, item);
                    }
                    break;
                case 6:
                    if (!(e.getInventory().getItem(6).getType() == Material.RED_STAINED_GLASS_PANE)) {
                        player.getInventory().addItem(e.getInventory().getItem(e.getSlot()));
                        item.setType(Material.RED_STAINED_GLASS_PANE);
                        meta.setDisplayName(ChatColor.RED + "Inhibitor");
                        lore.add(ChatColor.YELLOW + "Click an appropriate item to insert it!");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        e.getInventory().setItem(6, item);
                    }
                    break;
                case 19:
                    if (!(e.getInventory().getItem(19).getType() == Material.CYAN_STAINED_GLASS_PANE)) {
                        player.getInventory().addItem(e.getInventory().getItem(e.getSlot()));
                        item.setType(Material.CYAN_STAINED_GLASS_PANE);
                        meta.setDisplayName(ChatColor.DARK_AQUA + "Additive");
                        lore.add(ChatColor.YELLOW + "Click an appropriate item to insert it!");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        e.getInventory().setItem(19, item);
                    }
                    break;
                case 25:
                    if (!(e.getInventory().getItem(25).getType() == Material.PURPLE_STAINED_GLASS_PANE)) {
                        player.getInventory().addItem(e.getInventory().getItem(e.getSlot()));
                        item.setType(Material.PURPLE_STAINED_GLASS_PANE);
                        meta.setDisplayName(ChatColor.DARK_PURPLE + "Configuration");
                        lore.add(ChatColor.YELLOW + "Click an appropriate item to insert it!");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        e.getInventory().setItem(25, item);
                    }
                    break;
                case 44:
                    Inventory inventory = e.getInventory();
                    if (inventory.getItem(20).getType() != Material.RED_STAINED_GLASS_PANE) {
                        return;
                    }
                    String ingredient = "";
                    if (inventory.getItem(13) != null &&
                        inventory.getItem(13).getItemMeta() != null &&
                        inventory.getItem(13).getItemMeta().getPersistentDataContainer() != null &&
                        inventory.getItem(13).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                        ingredient = inventory.getItem(13).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    } else {
                        if (inventory.getItem(13) != null) {
                            ingredient = inventory.getItem(13).getType().toString();
                        }
                    }
                    String base = "";
                    if (inventory.getItem(4).getItemMeta() != null &&
                        inventory.getItem(4).getItemMeta().getPersistentDataContainer() != null &&
                        inventory.getItem(4).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                        base = inventory.getItem(4).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    } else {
                        base = inventory.getItem(4).getType().toString();
                    }
                    String inhibitor = "";
                    if (inventory.getItem(6).getItemMeta() != null &&
                        inventory.getItem(6).getItemMeta().getPersistentDataContainer() != null &&
                        inventory.getItem(6).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                        inhibitor = inventory.getItem(6).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    } else {
                        inhibitor = inventory.getItem(6).getType().toString();
                    }
                    String amplifier = "";
                    if (inventory.getItem(2).getItemMeta() != null &&
                        inventory.getItem(2).getItemMeta().getPersistentDataContainer() != null &&
                        inventory.getItem(2).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                        amplifier = inventory.getItem(2).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    } else {
                        amplifier = inventory.getItem(2).getType().toString();
                    }
                    String additive = "";
                    if (inventory.getItem(19).getItemMeta() != null &&
                        inventory.getItem(19).getItemMeta().getPersistentDataContainer() != null &&
                        inventory.getItem(19).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null &&
                        inventory.getItem(19).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                            PersistentDataType.STRING) != null &&
                        inventory.getItem(19).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                            PersistentDataType.STRING).equals("additive")) {
                        additive = inventory.getItem(19).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }
                    String configuration = "";
                    if (inventory.getItem(25).getItemMeta() != null &&
                        inventory.getItem(25).getItemMeta().getPersistentDataContainer() != null &&
                        inventory.getItem(25).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                        configuration = inventory.getItem(25).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    } else {
                        configuration = inventory.getItem(25).getType().toString();
                    }

                    ItemStack potion = functions.createPotions(ingredient, base, inhibitor, amplifier, additive, configuration);
                    new BukkitRunnable() {
                        int iterations = 0;
                        ItemStack red = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                        ItemStack yellow = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemStack orange = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                        ItemMeta meta = red.getItemMeta();
                        public void run()
                        {
                            meta.setDisplayName(" ");
                            red.setItemMeta(meta);
                            yellow.setItemMeta(meta);
                            orange.setItemMeta(meta);
                            iterations += 1;
                            if (iterations >= 20) {
                                if (inventory.getItem(38) != null &&
                                    inventory.getItem(38).getType() == Material.POTION &&
                                    ((PotionMeta)inventory.getItem(38).getItemMeta()).getBasePotionData().getType() == PotionType.WATER) {
                                    inventory.setItem(38, potion);
                                }
                                if (inventory.getItem(40) != null &&
                                    inventory.getItem(40).getType() == Material.POTION &&
                                    ((PotionMeta)inventory.getItem(40).getItemMeta()).getBasePotionData().getType() == PotionType.WATER) {
                                    inventory.setItem(40, potion);
                                }
                                if (inventory.getItem(42) != null &&
                                    inventory.getItem(42).getType() == Material.POTION &&
                                    ((PotionMeta)inventory.getItem(42).getItemMeta()).getBasePotionData().getType() == PotionType.WATER) {
                                    inventory.setItem(42, potion);
                                }
                                ItemStack glass = new ItemStack(Material.GLASS_PANE);
                                ItemMeta glassMeta = glass.getItemMeta();
                                glassMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click an appropriate item to insert it!"));
                                if (inventory.getItem(2).getType() != Material.YELLOW_STAINED_GLASS_PANE) {
                                    inventory.getItem(2).setAmount(inventory.getItem(2).getAmount() - 1);
                                    if (inventory.getItem(2) == null) {
                                        glass.setType(Material.YELLOW_STAINED_GLASS_PANE);
                                        glassMeta.setDisplayName(ChatColor.YELLOW + "Amplifier");
                                        glass.setItemMeta(glassMeta);
                                        inventory.setItem(2, glass);
                                    }
                                }
                                if (inventory.getItem(4).getType() != Material.GREEN_STAINED_GLASS_PANE) {
                                    if (inventory.getItem(4).getType() != Material.GREEN_STAINED_GLASS_PANE) {
                                        inventory.getItem(4).setAmount(inventory.getItem(4).getAmount() - 1);
                                        if (inventory.getItem(4) == null) {
                                            glass.setType(Material.GREEN_STAINED_GLASS_PANE);
                                            glassMeta.setDisplayName(ChatColor.DARK_GREEN + "Base");
                                            glass.setItemMeta(glassMeta);
                                            inventory.setItem(4, glass);
                                        }
                                    }
                                }
                                if (inventory.getItem(6).getType() != Material.RED_STAINED_GLASS_PANE) {
                                    if (inventory.getItem(6).getType() != Material.RED_STAINED_GLASS_PANE) {
                                        inventory.getItem(6).setAmount(inventory.getItem(6).getAmount() - 1);
                                        if (inventory.getItem(6) == null) {
                                            glass.setType(Material.RED_STAINED_GLASS_PANE);
                                            glassMeta.setDisplayName(ChatColor.RED + "Inhibitor");
                                            glass.setItemMeta(glassMeta);
                                            inventory.setItem(6, glass);
                                        }
                                    }
                                }
                                if (inventory.getItem(19).getType() != Material.CYAN_STAINED_GLASS_PANE) {
                                    if (inventory.getItem(19).getType() != Material.CYAN_STAINED_GLASS_PANE) {
                                        inventory.getItem(19).setAmount(inventory.getItem(19).getAmount() - 1);
                                        if (inventory.getItem(19) == null) {
                                            glass.setType(Material.CYAN_STAINED_GLASS_PANE);
                                            glassMeta.setDisplayName(ChatColor.DARK_AQUA + "Additive");
                                            glass.setItemMeta(glassMeta);
                                            inventory.setItem(19, glass);
                                        }
                                    }
                                }
                                if (inventory.getItem(25).getType() != Material.PURPLE_STAINED_GLASS_PANE) {
                                    if (inventory.getItem(25).getType() != Material.PURPLE_STAINED_GLASS_PANE) {
                                        inventory.getItem(25).setAmount(inventory.getItem(25).getAmount() - 1);
                                        if (inventory.getItem(25) == null) {
                                            glassMeta.setDisplayName(ChatColor.DARK_PURPLE + "Configuration");
                                            glass.setItemMeta(glassMeta);
                                            glass.setType(Material.PURPLE_STAINED_GLASS_PANE);
                                            inventory.setItem(25, glass);
                                        }
                                    }
                                }

                                if (inventory.getItem(13) != null) {
                                    inventory.getItem(13).setAmount(inventory.getItem(13).getAmount() - 1);
                                }
                                inventory.setItem(20, red);
                                inventory.setItem(21, red);
                                inventory.setItem(22, red);
                                inventory.setItem(23, red);
                                inventory.setItem(24, red);
                                inventory.setItem(29, red);
                                inventory.setItem(31, red);
                                inventory.setItem(33, red);
                                this.cancel();
                                return;
                            }

                            if (iterations % 2 == 0) {
                                inventory.setItem(20, yellow);
                                inventory.setItem(21, orange);
                                inventory.setItem(22, yellow);
                                inventory.setItem(23, orange);
                                inventory.setItem(24, yellow);
                                inventory.setItem(29, orange);
                                inventory.setItem(31, orange);
                                inventory.setItem(33, orange);
                            } else {
                                inventory.setItem(20, orange);
                                inventory.setItem(21, yellow);
                                inventory.setItem(22, orange);
                                inventory.setItem(23, yellow);
                                inventory.setItem(24, orange);
                                inventory.setItem(29, yellow);
                                inventory.setItem(31, yellow);
                                inventory.setItem(33, yellow);
                            }
                        }
                    }.runTaskTimer(plugin, 0, 20);
                    break;
                case 53:
                    player.closeInventory();
                    break;
            }
        }

        if (holder instanceof PetsGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }

            switch (e.getSlot()) {
                case 48:
                    switch(player.getPersistentDataContainer().get(new NamespacedKey(plugin, "selectionMode"),
                            PersistentDataType.INTEGER)) {
                        case 0:
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "selectionMode"),
                                    PersistentDataType.INTEGER, 1);
                            break;
                        case 1:
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "selectionMode"),
                                    PersistentDataType.INTEGER, 2);
                            break;
                        case 2:
                        default:
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "selectionMode"),
                                    PersistentDataType.INTEGER, 0);
                            break;
                    }
                    player.openInventory(new PetsGUI(plugin, player).getInventory());
                    break;
                case 49:
                    player.openInventory(new MainGUI(plugin, player).getInventory());
                    break;
                default:
                    if (e.getCurrentItem().getType() != Material.BLACK_STAINED_GLASS_PANE) {
                        switch(player.getPersistentDataContainer().get(new NamespacedKey(plugin, "selectionMode"),
                                PersistentDataType.INTEGER)) {
                            case 0:
                                try {
                                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                    BukkitObjectOutputStream outputStream = new BukkitObjectOutputStream(stream);
                                    if (e.getCurrentItem().equals(functions.getPets().get(player))) {
                                        outputStream.writeObject(new ItemStack(Material.AIR));
                                    } else {
                                        outputStream.writeObject(e.getCurrentItem());
                                    }
                                    outputStream.flush();
                                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Pet"),
                                            PersistentDataType.BYTE_ARRAY, stream.toByteArray());

                                } catch (IOException exception) {
                                    System.out.println(ChatColor.RED + "Failed to save pet");
                                }
                                functions.updatePet(player);
                                player.openInventory(new PetsGUI(plugin, player).getInventory());
                                return;
                            case 1:
                                ItemStack[] pets1 = new ItemStack[]{};
                                try {
                                    ByteArrayInputStream inputStream = new ByteArrayInputStream(player.getPersistentDataContainer().get(new NamespacedKey(plugin, "availablePets"),
                                            PersistentDataType.BYTE_ARRAY));
                                    BukkitObjectInputStream objectInputStream = new BukkitObjectInputStream(inputStream);
                                    pets1 = (ItemStack[])objectInputStream.readObject();
                                } catch (IOException | ClassNotFoundException exception) {
                                    System.out.println(ChatColor.RED + "Failed to load pets");
                                }
                                List<ItemStack> list1 = new LinkedList<>(Arrays.asList(pets1));
                                list1.remove(e.getCurrentItem());
                                pets1 = list1.toArray(ItemStack[]::new);
                                player.getInventory().addItem(e.getCurrentItem());
                                try {
                                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                    BukkitObjectOutputStream outputStream = new BukkitObjectOutputStream(stream);
                                    if (e.getCurrentItem().equals(functions.getPets().get(player))) {
                                        outputStream.writeObject(new ItemStack(Material.AIR));
                                        outputStream.flush();
                                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Pet"),
                                                PersistentDataType.BYTE_ARRAY, stream.toByteArray());
                                    }

                                    stream = new ByteArrayOutputStream();
                                    outputStream = new BukkitObjectOutputStream(stream);
                                    outputStream.writeObject(pets1);
                                    outputStream.flush();
                                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "availablePets"),
                                            PersistentDataType.BYTE_ARRAY, stream.toByteArray());
                                } catch (IOException exception) {
                                    System.out.println(ChatColor.RED + "Failed to save pet");
                                }
                                functions.updatePet(player);
                                player.openInventory(new PetsGUI(plugin, player).getInventory());
                                return;
                            case 2:
                            default:
                                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "selectionMode"),
                                        PersistentDataType.INTEGER, 0);
                                break;
                        }
                    }
                    break;
            }
        }

        if (holder instanceof SacksGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            switch (e.getSlot()) {
                case 0:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newRockSackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 1:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newMineralSackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 2:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newLumberSackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 3:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newForagingSackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 4:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newAgricultureSackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 5:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newHusbandrySackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 6:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newCryptozoologySackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 7:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newDemonologySackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 8:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newXenoarchaeologySackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 9:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newFishingSackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 10:
                    if (e.getCurrentItem().getType() != Material.GRAY_DYE) {
                        player.openInventory(FormatSackGUI.newExcavatingSackGUI(plugin, holder, player).getInventory());
                    }
                    return;
                case 17:
                    player.openInventory(new MainGUI(plugin, player).getInventory());
                    return;
            }
        }

        if (holder instanceof FormatSackGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getSlot() == 31) {
                player.openInventory(((FormatSackGUI)holder).getBackArrow());
                return;
            } else {
                String[] materials = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMaterial"), new stringList());
                int[] amounts = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackAmount"), PersistentDataType.INTEGER_ARRAY);
                int[] max = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMax"), PersistentDataType.INTEGER_ARRAY);
                String name = e.getCurrentItem().getType().toString();
                if (e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "name"), PersistentDataType.STRING) != null) {
                    name = e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "name"), PersistentDataType.STRING);
                }
                if (e.getClick() == ClickType.LEFT &&
                    amounts[Arrays.asList(materials).indexOf(name)] > 0) {
                    int supply = amounts[Arrays.asList(materials).indexOf(name)];
                    ItemStack item = new ItemStack(Material.DIRT);
                    ItemMeta meta = item.getItemMeta();
                    switch (e.getCurrentItem().getType()) {
                        case DIAMOND:
                        case EMERALD:
                        case ANCIENT_DEBRIS:
                        case NETHERITE_SCRAP:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
                            meta.setLore(new ArrayList<>(Arrays.asList(ChatColor.GREEN.toString() + ChatColor.BOLD + "UNCOMMON")));
                            break;
                        default:
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "COMMON");
                            meta.setLore(new ArrayList<>(Arrays.asList(ChatColor.WHITE.toString() + ChatColor.BOLD + "COMMON")));
                            break;
                    }
                    item.setItemMeta(meta);
                    if (e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "name"), PersistentDataType.STRING) != null) {
                        item = Items.values()[e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "number"),
                                PersistentDataType.INTEGER)].getItem(plugin);
                    } else {
                        item.setType(Material.valueOf(name));
                    }

                    for (int i = 0; i < 36; i++) {
                        if (player.getInventory().getItem(i) == null) {
                            if (supply >= item.getMaxStackSize()) {
                                item.setAmount(item.getMaxStackSize());
                                player.getInventory().addItem(item);
                                supply -= item.getMaxStackSize();
                            } else {
                                item.setAmount(supply);
                                player.getInventory().addItem(item);
                                supply = 0;
                            }
                        } else {
                            if (item.isSimilar(player.getInventory().getItem(i)) &&
                                player.getInventory().getItem(i).getMaxStackSize() != player.getInventory().getItem(i).getAmount()) {
                                if (supply >= player.getInventory().getItem(i).getMaxStackSize() - player.getInventory().getItem(i).getAmount()) {
                                    item.setAmount(item.getMaxStackSize() - player.getInventory().getItem(i).getAmount());
                                    supply -= item.getMaxStackSize() - player.getInventory().getItem(i).getAmount();
                                    player.getInventory().addItem(item);
                                } else {
                                    item.setAmount(supply);
                                    player.getInventory().addItem(item);
                                    supply = 0;
                                }
                            }
                        }
                    }
                    amounts[Arrays.asList(materials).indexOf(name)] = supply;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sackAmount"), PersistentDataType.INTEGER_ARRAY, amounts);
                    ((FormatSackGUI)holder).reloadInventory();
                }
            }
        }

        if (e.getClickedInventory() instanceof PlayerInventory) {
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta() != null &&
                e.getCurrentItem().getItemMeta().getPersistentDataContainer() != null &&
                e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING) != null) {
                switch (e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.STRING)) {
                    case "Drawstring Bag":
                        player.openInventory(new SacksGUI(plugin, player).getInventory());
                        e.setCancelled(true);
                        break;
                    default:
                        break;
                }
            }

            if (player.getOpenInventory().getTopInventory() != null) {
                if ((e.getClick() == ClickType.DOUBLE_CLICK ||
                    e.getClick() == ClickType.SHIFT_LEFT ||
                    e.getClick() == ClickType.SHIFT_RIGHT) &&
                    (player.getOpenInventory().getTopInventory().getHolder() instanceof ArmorSelectGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof BrewingStandGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof EnchantmentsGUI1 ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof EnchantmentsGUI2 ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof FormatEnchantmentGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof FormatRecipesGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof MainGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof MaterialsSelectGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof MaterialsSelectGUI2 ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof MaterialsSelectGUI3 ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof MaterialsSelectGUI4 ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof MiscSelectGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof PetsGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof PlayerInventoryGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof RecipeSelectGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof SettingsGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof SmeltToggles ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof StonesSelectGUI ||
                    player.getOpenInventory().getTopInventory().getHolder() instanceof WeaponsSelectGUI)) {
                    e.setCancelled(true);
                }
                if (player.getOpenInventory().getTopInventory().getHolder() instanceof BrewingStandGUI) {
                    String id = e.getCurrentItem().getType().toString();
                    if (e.getCurrentItem().getItemMeta() != null &&
                            e.getCurrentItem().getItemMeta().getPersistentDataContainer() != null &&
                            e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                    PersistentDataType.STRING) != null) {
                        id = e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }
                    ItemStack item = e.getCurrentItem();
                    switch (id) {
                        case "GLOWSTONE_DUST":
                        case "Enchanted Glowstone Dust":
                        case "Enchanted Glowstone":
                        case "Lumanous Quartz":
                            if (player.getOpenInventory().getTopInventory().getItem(2).getType() == Material.YELLOW_STAINED_GLASS_PANE) {
                                player.getOpenInventory().getTopInventory().setItem(2, item);
                                e.getCurrentItem().setAmount(0);
                            }
                            break;
                        case "NETHER_WART":
                        case "Enchanted Nether Wart":
                            if (player.getOpenInventory().getTopInventory().getItem(4).getType() == Material.GREEN_STAINED_GLASS_PANE) {
                                player.getOpenInventory().getTopInventory().setItem(4, item);
                                e.getCurrentItem().setAmount(0);
                            }
                            break;
                        case "REDSTONE":
                        case "Enchanted Redstone":
                        case "Enchanted Redstone Block":
                        case "Mineral Cluster":
                            if (player.getOpenInventory().getTopInventory().getItem(6).getType() == Material.RED_STAINED_GLASS_PANE) {
                                player.getOpenInventory().getTopInventory().setItem(6, item);
                                e.getCurrentItem().setAmount(0);
                            }
                            break;
                        case "Sugar Cube":
                        case "COMT Froot Juice™":
                            if (player.getOpenInventory().getTopInventory().getItem(19).getType() == Material.CYAN_STAINED_GLASS_PANE) {
                                player.getOpenInventory().getTopInventory().setItem(19, item);
                                e.getCurrentItem().setAmount(0);
                            }
                            break;
                    }
                }
            }
        }
    }

    public boolean checkMats(Player player, List<String> materials, List<Integer> amounts, boolean consume) {
        List<Integer> copy = new ArrayList<>();
        for (int i = 0; i < amounts.size(); i++) {
            copy.add(amounts.get(i));
        }
        for (int i = 0; i < 36; i++) {
            if (player.getInventory().getItem(i) != null &&
                player.getInventory().getItem(i).getItemMeta() != null &&
                player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer() != null &&
                player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                        PersistentDataType.STRING) != null &&
                materials.contains(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                        PersistentDataType.STRING)) &&
                copy.get(materials.indexOf(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                        PersistentDataType.STRING))) > 0) {
                copy.set(materials.indexOf(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                        PersistentDataType.STRING)),
                        copy.get(materials.indexOf(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                        PersistentDataType.STRING))) - player.getInventory().getItem(i).getAmount());
            }
        }

        for (int i = 0; i < copy.size(); i++) {
            if (copy.get(i) > 0) {
                return false;
            }
        }

        if (consume) {
            for (int i = 0; i < 36; i++) {
                if (player.getInventory().getItem(i) != null &&
                    player.getInventory().getItem(i).getItemMeta() != null &&
                    player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer() != null &&
                    player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                            PersistentDataType.STRING) != null &&
                    materials.contains(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                            PersistentDataType.STRING)) &&
                    amounts.get(materials.indexOf(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                            PersistentDataType.STRING))) > 0) {
                    if (amounts.get(materials.indexOf(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                            PersistentDataType.STRING))) >= player.getInventory().getItem(i).getAmount()) {
                        amounts.set(materials.indexOf(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                                        PersistentDataType.STRING)),
                        amounts.get(materials.indexOf(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                                PersistentDataType.STRING))) - player.getInventory().getItem(i).getAmount());
                        player.getInventory().setItem(i, new ItemStack(Material.AIR));
                    } else {
                        ItemStack item = player.getInventory().getItem(i);
                        item.setAmount(item.getAmount() - amounts.get(materials.indexOf(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                                PersistentDataType.STRING))));
                        amounts.set(materials.indexOf(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"id"),
                                PersistentDataType.STRING)), 0);
                    }
                }
            }
        }
        return true;
    }
}