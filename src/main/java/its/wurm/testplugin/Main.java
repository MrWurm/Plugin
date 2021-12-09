package its.wurm.testplugin;

import its.wurm.testplugin.Commands.Use.Commands;
import its.wurm.testplugin.Events.*;
import its.wurm.testplugin.Items.ItemManager;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.Mobs.Mobs;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    SkillEvents se = new SkillEvents(this);
    ItemManager Items = new ItemManager(this);

    @Override
    public void onEnable() {
        // Plugin startup logic
        se.SkillLoadData();
        Commands commands = new Commands(this);
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new Mobs(this), this);
        getServer().getPluginManager().registerEvents(new Attacks(this), this);
        getServer().getPluginManager().registerEvents(new PlayerStatEvents(this), this);
        getServer().getPluginManager().registerEvents(Items, this);
        getServer().getPluginManager().registerEvents(new ItemEvents(this), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        getServer().getPluginManager().registerEvents(new StatEvents(this), this);
        getServer().getPluginManager().registerEvents(se, this);
        getCommand("giveall").setExecutor(commands);
        getCommand("testgui").setExecutor(commands);
        getCommand("customsummon/dummy").setExecutor(commands);
        getCommand("customsummon/chillZombie").setExecutor(commands);
        getCommand("customsummon/fencerZombie").setExecutor(commands);
        getCommand("customsummon/armorZombie").setExecutor(commands);
        getCommand("customsummon/regenZombie").setExecutor(commands);
        getCommand("customsummon/smolGhast").setExecutor(commands);
        getCommand("customsummon/bersZombie").setExecutor(commands);
        getCommand("customsummon/noviceSkele").setExecutor(commands);
        getCommand("check").setExecutor(commands);
        getCommand("marker").setExecutor(commands);
        getCommand("defaultStat").setExecutor(commands);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        se.SaveSkillData();

    }
}
