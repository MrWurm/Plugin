package its.wurm.testplugin;

import its.wurm.testplugin.Commands.Use.Commands;
import its.wurm.testplugin.Events.*;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.Mobs.Mobs;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    SkillEvents se = new SkillEvents(this);

    @Override
    public void onEnable() {
        // Plugin startup logic
        se.SkillLoadData();
        Items.registerRecipes(this);
        Commands commands = new Commands(this);
        getServer().getPluginManager().registerEvents(new Mobs(this), this);
        getServer().getPluginManager().registerEvents(new Mobs(this), this);
        getServer().getPluginManager().registerEvents(new Attacks(this), this);
        getServer().getPluginManager().registerEvents(new PlayerStatEvents(this), this);
        getServer().getPluginManager().registerEvents(new ItemEvents(this), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(this), this);
        getServer().getPluginManager().registerEvents(new StatEvents(this), this);
        getServer().getPluginManager().registerEvents(se, this);
        getCommand("giveall").setExecutor(commands);
        getCommand("testgui").setExecutor(commands);
        getCommand("customsummon/dummy").setExecutor(commands);
        getCommand("summonzombie").setExecutor(commands);
        getCommand("check").setExecutor(commands);
        getCommand("marker").setExecutor(commands);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        se.SaveSkillData();

    }
}
