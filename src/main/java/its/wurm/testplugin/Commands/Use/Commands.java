package its.wurm.testplugin.Commands.Use;

import its.wurm.testplugin.Events.InventoryEvents;
import its.wurm.testplugin.Inventories.AnvilGUI;
import its.wurm.testplugin.Inventories.MainGUI;
import its.wurm.testplugin.Inventories.PlayerInventoryGUI;
import its.wurm.testplugin.Inventories.RecipeSelectGUI;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Mobs;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;



public class Commands implements CommandExecutor {

    Main plugin;
    InventoryEvents inventoryEvents;

    public Commands(Main plugin, InventoryEvents inventoryEvents) {
        this.plugin = plugin;
        this.inventoryEvents = inventoryEvents;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You need to be a player to run this command!");
            return true;
        }
        Player player = (Player) sender;

        if (player.isOp()) {
            if (cmd.getName().equalsIgnoreCase("giveitem")) {
                ItemStack item;
                switch (strings.length) {
                    case 0:
                        player.sendMessage(ChatColor.RED + "You must state what item you want");
                        return true;
                    case 1:
                        if (Items.valueOf(strings[0]) == null) {
                            player.sendMessage(ChatColor.RED + "Invalid item");
                            return false;
                        } else {
                            player.getInventory().addItem(Items.valueOf(strings[0]).getItem(plugin));
                            return true;
                        }
                    case 2:
                        if (Items.valueOf(strings[0]) == null) {
                            player.sendMessage(ChatColor.RED + "Invalid item");
                            return false;
                        }

                        if (Bukkit.getPlayer(strings[1]) != null) {
                            Bukkit.getPlayer(strings[1]).getInventory().addItem(Items.valueOf(strings[0]).getItem(plugin));
                        } else {
                            try {
                                if (Integer.valueOf(strings[1]) != null) {
                                    item = Items.valueOf(strings[0]).getItem(plugin);
                                    item.setAmount(Integer.valueOf(strings[1]));
                                    player.getInventory().addItem(item);
                                }
                            } catch (RuntimeException error) {
                                player.sendMessage(ChatColor.RED + "Invalid name/amount");
                                return false;
                            }
                        }

                        break;
                    case 3:
                        if (Items.valueOf(strings[0]) == null) {
                            player.sendMessage(ChatColor.RED + "Invalid item");
                            return false;
                        }
                        if (String.valueOf(strings[2]) == null) {
                            player.sendMessage(ChatColor.RED + "Invalid player");
                            return false;
                        }

                        try {
                            item = Items.valueOf(strings[0]).getItem(plugin);
                            item.setAmount(Integer.valueOf(strings[1]));
                            Bukkit.getPlayer(strings[2]).getInventory().addItem(item);
                        } catch (RuntimeException error) {
                            player.sendMessage(ChatColor.RED + "Invalid amount");
                            return false;
                        }
                        break;
                }
                return true;
            }

            if (cmd.getName().equalsIgnoreCase("rank")) {
                Player target = player;
                switch (strings.length) {
                    case 1:
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Rank"),
                                PersistentDataType.STRING, strings[0]);
                        break;
                    case 2:
                        Bukkit.getPlayer(strings[1]).getPersistentDataContainer().set(new NamespacedKey(plugin, "Rank"),
                                PersistentDataType.STRING, strings[0]);
                        target = Bukkit.getPlayer(strings[1]);
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "Invalid input");
                        break;
                }

                String name = target.getName();
                switch (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Rank"),
                        PersistentDataType.STRING)) {
                    case "VIP":
                        name = ChatColor.GREEN + "[" + ChatColor.GOLD + "V" + ChatColor.GREEN + "I" + ChatColor.GOLD + "P" + ChatColor.GREEN + "] " + target.getName();
                        break;
                    case "MVP":
                        name = ChatColor.GOLD + "[MVP] " + target.getName();
                        break;
                    case "ADMIN":
                        name = ChatColor.RED + "[ADMIN] " + target.getName();
                        break;
                    case "PATRON":
                        name = ChatColor.DARK_BLUE + "[" + ChatColor.BLUE + "P" + ChatColor.DARK_PURPLE + "A" + ChatColor.BLUE + "T" + ChatColor.DARK_PURPLE + "R" + ChatColor.BLUE + "O" + ChatColor.DARK_PURPLE + "N" + ChatColor.DARK_BLUE + "] " + ChatColor.BLUE + target.getName();
                        break;
                    case "WURM":
                        name = ChatColor.DARK_AQUA + "[WURM] " + target.getName();
                        break;
                    default:
                        break;
                }
                player.setDisplayName(name);
                player.setPlayerListName(name);
                return true;
            }

            if (cmd.getName().equalsIgnoreCase("summonnew")) {
                if (strings.length == 0) {
                    return true;
                }

                Mobs.valueOf(strings[0]).createMob(plugin, player.getLocation());
                return true;
            }

            if (cmd.getName().equalsIgnoreCase("editinventory")) {
                if (strings.length == 0) {
                    return true;
                }

                if (Bukkit.getPlayer(strings[0]) == null) {
                    player.sendMessage(ChatColor.RED + "You must state a player to view the inventory of");
                    return true;
                }

                player.openInventory(Bukkit.getPlayer(strings[0]).getInventory());
                return true;
            }
        }

        if (cmd.getName().equalsIgnoreCase("menu")) {
            MainGUI gui = new MainGUI(plugin, player);
            player.openInventory(gui.getInventory());
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("inventory")) {
            if (strings.length == 0) {
                return true;
            }

            if (Bukkit.getPlayer(strings[0]) == null) {
                player.sendMessage(ChatColor.RED + "You must state a player to view the inventory of");
                return true;
            }

            player.openInventory(new PlayerInventoryGUI(plugin, Bukkit.getPlayer(strings[0])).getInventory());
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("anvil")) {
            AnvilGUI gui = new AnvilGUI(plugin);
            player.openInventory(gui.getInventory());
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("recipes")) {
            RecipeSelectGUI gui = new RecipeSelectGUI(plugin);
            player.openInventory(gui.getInventory());
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("check")) {
            player.sendMessage("" + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                    PersistentDataType.STRING));
            return true;
        }

        return true;
    }
}
