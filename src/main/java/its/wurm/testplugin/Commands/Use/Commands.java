package its.wurm.testplugin.Commands.Use;

import its.wurm.testplugin.Inventories.MainGUI;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.Mobs.Mobs;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
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
            player.getInventory().addItem(Items.GOLD_POT.getItem(plugin));
            player.getInventory().addItem(Items.DEV_HAMMER.getItem(plugin));
            player.getInventory().addItem(Items.SUPER_PICK.getItem(plugin));
            player.getInventory().addItem(Items.ECHO_STONE.getItem(plugin));
            player.getInventory().addItem(Items.ALLMIGHTY.getItem(plugin));
            player.getInventory().addItem(Items.DIMENSIONAL_ROD.getItem(plugin));
        }

        if (cmd.getName().equalsIgnoreCase("testgui")) {
            MainGUI gui = new MainGUI(plugin, player);
            player.openInventory(gui.getInventory());
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/dummy")) {
            Mobs.DUMMY.createMob(plugin, player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("summonnew")) {
            Silverfish summon = player.getLocation().getWorld().spawn(player.getLocation(), Silverfish.class);
            Attacks.createSummon(player.getLocation(), 1200, player, summon, 25.0, 125.0, 0.0, "Test");
        }

        if (cmd.getName().equalsIgnoreCase("summonall")) {
            Mobs.NOVICE_SKELETON.createMob(plugin, player.getLocation());
            Mobs.FROST_ZOMBIE.createMob(plugin, player.getLocation());
            Mobs.REGEN_ZOMBIE.createMob(plugin, player.getLocation());
            Mobs.FENCER_ZOMBIE.createMob(plugin, player.getLocation());
            Mobs.BERZERK_ZOMBIE.createMob(plugin, player.getLocation());
            Mobs.ARMOR_ZOMBIE.createMob(plugin, player.getLocation());
            Mobs.HOST.createMob(plugin, player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("check")) {
            player.sendMessage("" + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING));
        }

        return true;
    }
}
