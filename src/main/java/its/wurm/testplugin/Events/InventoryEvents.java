package its.wurm.testplugin.Events;
import its.wurm.testplugin.Inventories.FormatRecipesGUI;
import its.wurm.testplugin.Inventories.*;
import its.wurm.testplugin.Items.Items;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InventoryEvents implements Listener {

    Plugin plugin;
    Map<UUID, PlayerInventoryGUI> player_inventory = new HashMap<>();

    public InventoryEvents(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (e.getClickedInventory() == null) {
            return;
        }
        InventoryHolder holder = e.getClickedInventory().getHolder();

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
                case 25:
                    //open Ender Chest GUI
                    player.openInventory(player.getEnderChest());
                    return;
                case 29:
                    //open Anvil GUI
                    AnvilGUI gui = new AnvilGUI(plugin);
                    player.openInventory(gui.getInventory());
                    return;
                case 30:
                    //open Recipes gui
                    RecipeSelectGUI gui1 = new RecipeSelectGUI(plugin);
                    player.openInventory(gui1.getInventory());
                    return;
                case 46:
                    if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "peace"),
                            PersistentDataType.INTEGER) == 0) {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "peace"),
                                PersistentDataType.INTEGER, 1);
                    } else {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "peace"),
                                PersistentDataType.INTEGER, 0);
                    }
                    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 40, 0.4f);
                    MainGUI mainGUI = new MainGUI(plugin, player);
                    player.openInventory(mainGUI.getInventory());
                    return;
                case 49:
                    //close the gui
                    player.closeInventory();
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
                Items value = Items.values()[e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                if (value == null || value.recipeGUI.apply(plugin, holder).getInventory() == null) {
                    return;
                }
                player.openInventory(value.recipeGUI.apply(plugin, holder).getInventory());
            }
            if (e.getSlot() == 49) {
                if (holder instanceof FormatRecipesGUI) {
                    player.openInventory(((FormatRecipesGUI) holder).getBackArrow());
                } else {
                    player.openInventory(new RecipeSelectGUI(plugin).getInventory());
                }
            }
        }
    }
}