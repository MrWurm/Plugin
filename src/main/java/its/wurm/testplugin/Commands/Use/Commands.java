package its.wurm.testplugin.Commands.Use;

import its.wurm.testplugin.Inventories.RecipeSelectGUI;
import its.wurm.testplugin.Items.ItemManager;
import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.Mobs.Mobs;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;


public class Commands implements CommandExecutor {

    Main plugin;

    public Commands(Main plugin) { this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You need to be a player to run this command!");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("giveall")) {
            player.getInventory().addItem(ItemManager.hammerDev);
            player.getInventory().addItem(ItemManager.moon_glove);
            player.getInventory().addItem(ItemManager.echostone);
            player.getInventory().addItem(ItemManager.sower_contract);
        }

        if (cmd.getName().equalsIgnoreCase("testgui")) {
            RecipeSelectGUI gui = new RecipeSelectGUI();
            player.openInventory(gui.getInventory());
            player.sendMessage("Opened Menu");
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/dummy")) {
            Mobs.createDummy(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/chillZombie")) {
            Mobs.createChillZombie(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/fencerZombie")) {
            Mobs.createFencerZombie(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/armorZombie")) {
            Mobs.createArmoredZombie(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/regenZombie")) {
            Mobs.createRegenZombie(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/smolGhast")) {
            Mobs.createSmolGhast(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/bersZombie")) {
            Mobs.createRageZombie(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("marker")) {
            Attacks.createDamageIndicator(player.getLocation(), true, 1000.0);
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/noviceSkele")) {
            Mobs.createNoviceSkele(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("check")) {
            player.sendMessage("" + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING));
        }

        if (cmd.getName().equalsIgnoreCase("defaultStat")) {
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 100.0);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 100.0);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 25.0);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageMod"),
                    PersistentDataType.DOUBLE, 0.0);
        }

        return true;
    }
}
