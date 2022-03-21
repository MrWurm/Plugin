package its.wurm.testplugin;

import its.wurm.testplugin.Bosses.Dragon;
import its.wurm.testplugin.Commands.Use.Commands;
import its.wurm.testplugin.Events.*;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public final class Main extends JavaPlugin implements Listener {

    SkillEvents se = new SkillEvents(this);
    Attacks attacks = new Attacks(this);
    InventoryEvents inventoryEvents = new InventoryEvents(this);

    @Override
    public void onEnable() {
        // Plugin startup logic
        se.SkillLoadData();
        Dragon dragon = new Dragon(this);
        Items.registerRecipes(this);
        Commands commands = new Commands(this, inventoryEvents);
        StatFunctions functions = new StatFunctions(this, attacks);
        getServer().getPluginManager().registerEvents(new PlayerStatEvents(this), this);
        getServer().getPluginManager().registerEvents(new AnvilEvents(this), this);
        getServer().getPluginManager().registerEvents(new ItemEvents(this), this);
        getServer().getPluginManager().registerEvents(new StatEvents(this, dragon), this);
        getServer().getPluginManager().registerEvents(new VillagerEvents(this), this);
        getServer().getPluginManager().registerEvents(dragon, this);
        getServer().getPluginManager().registerEvents(se, this);
        getServer().getPluginManager().registerEvents(inventoryEvents, this);
        getCommand("giveitem").setExecutor(commands);
        getCommand("rank").setExecutor(commands);
        getCommand("menu").setExecutor(commands);
        getCommand("summonnew").setExecutor(commands);
        getCommand("editinventory").setExecutor(commands);
        getCommand("inventory").setExecutor(commands);
        getCommand("check").setExecutor(commands);
        getCommand("anvil").setExecutor(commands);
        getCommand("recipes").setExecutor(commands);
        getCommand("marker").setExecutor(commands);

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();

        functions.createTeam(board, "white", ChatColor.WHITE);
        functions.createTeam(board, "black", ChatColor.BLACK);
        functions.createTeam(board, "dark_blue", ChatColor.DARK_BLUE);
        functions.createTeam(board, "dark_green", ChatColor.DARK_GREEN);
        functions.createTeam(board, "dark_aqua", ChatColor.DARK_AQUA);
        functions.createTeam(board, "dark_red", ChatColor.DARK_RED);
        functions.createTeam(board, "dark_purple", ChatColor.DARK_PURPLE);
        functions.createTeam(board, "gold", ChatColor.GOLD);
        functions.createTeam(board, "gray", ChatColor.GRAY);
        functions.createTeam(board, "dark_gray", ChatColor.DARK_GRAY);
        functions.createTeam(board, "blue", ChatColor.BLUE);
        functions.createTeam(board, "green", ChatColor.GREEN);
        functions.createTeam(board, "aqua", ChatColor.AQUA);
        functions.createTeam(board, "red", ChatColor.RED);
        functions.createTeam(board, "light_purple", ChatColor.LIGHT_PURPLE);
        functions.createTeam(board, "yellow", ChatColor.YELLOW);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        se.SaveSkillData();

    }
}
