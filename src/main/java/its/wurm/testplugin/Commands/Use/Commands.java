package its.wurm.testplugin.Commands.Use;

import its.wurm.testplugin.Inventories.RecipeSelectGUI;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.Mobs.Mobs;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
            player.getInventory().addItem(Items.DEV_HAMMER.getItem(plugin));
            player.getInventory().addItem(Items.MOON_GLOVE.getItem(plugin));
            player.getInventory().addItem(Items.ECHO_STONE.getItem(plugin));
            player.getInventory().addItem(Items.SWOERS_WILL.getItem(plugin));
        }

        if (cmd.getName().equalsIgnoreCase("testgui")) {
            RecipeSelectGUI gui = new RecipeSelectGUI(plugin);
            player.openInventory(gui.getInventory());
            player.sendMessage("Opened Menu");
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/dummy")) {
            Mobs.createDummy(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("summonzombie")) {
            Mobs.createChillZombie(player.getLocation());
            Mobs.createFencerZombie(player.getLocation());
            Mobs.createArmoredZombie(player.getLocation());
            Mobs.createRegenZombie(player.getLocation());
            Mobs.createRageZombie(player.getLocation());
            Mobs.createRelentless(player.getLocation());
        }

        if (cmd.getName().equalsIgnoreCase("customsummon/smolGhast")) {
            Mobs.createSmolGhast(player.getLocation());
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

        return true;
    }
}
