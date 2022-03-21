package its.wurm.testplugin.Bosses;

import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;


public class Dragon implements Listener {
    Main plugin;

    Attacks attacks;
    StatFunctions functions;

    public Dragon(Main plugin) {
        this.dragonFight = false;
        this.plugin = plugin;
        this.dragonBossBar = Bukkit.getServer().createBossBar(new NamespacedKey(plugin, "EnderDragon"), "", BarColor.PURPLE, BarStyle.SOLID);
        this.attacks = new Attacks(plugin);
        this.functions = new StatFunctions(plugin, attacks);
        Map<Player, Double> bossDamage;
        List<Player> players;
        dragonBossBar.setVisible(false);
    }

    BossBar dragonBossBar;
    boolean dragonFight;
    Map<Player, Double> bossDamage = new HashMap<>();
    List<Player> players = new ArrayList<>();
    Random random = new Random();

    public void playerDamage(Player player, Double damage) {
        bossDamage.put(player, damage + bossDamage.getOrDefault(player, 0.0));
        Bukkit.broadcastMessage(bossDamage.toString());
    }


    @EventHandler
    public void fightStart(EntitySpawnEvent event) {
        if (!(event.getEntity() instanceof EnderDragon)) {
            return;
        }

        double health = 0.0;
        double defense = 0.0;
        double healmod = 1;
        double damage = 0.0;
        String name = "";
        String id = "";

        EnderDragon dragon = (EnderDragon) event.getEntity();

        dragonFight = true;
        BossBar bar = dragon.getBossBar();

        switch (random.nextInt(1) + 1) {
            case 1:
                health = 100000;
                damage = 270;
                name = ChatColor.LIGHT_PURPLE + "ENDER DRAGON";
                break;
        }

        dragon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, name);
        dragon.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);
        dragon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        dragon.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE, health);
        dragon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, health);
        dragon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, defense);
        dragon.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, healmod);
        dragon.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING, "boss");

        dragonBossBar.setTitle(dragon.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING));
        dragonBossBar.setProgress(1f);

    }

    @EventHandler
    public void onHeal(EntityRegainHealthEvent event) {

        if (event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING) != null &&
            event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals("boss")) {
            functions.heal(plugin, event.getEntity(), (event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE) / 250));
            event.getEntity().setCustomName(ChatColor.GOLD + "" + event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING) + "" + ChatColor.RED + " ❤" +
                event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) + "/" + event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE));

            int value = (int) Math.round(event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE)/event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE) * ((LivingEntity)event.getEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            if (value < 0) {
                value = 0;
            }
            ((LivingEntity) event.getEntity()).setHealth(value);
        }

        event.setCancelled(true);
    }

    @EventHandler
    public void bossDamage(EntityDamageEvent event) {
        if (event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING) != null &&
            event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING).equals("boss")) {

            int value = (int) Math.round(event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE)/event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE) * ((LivingEntity)event.getEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            if (value <= 0) {
                Bukkit.broadcastMessage(bossDamage.toString());
                for (Player key: bossDamage.keySet()) {
                    key.getInventory().addItem(Items.MENU_GLASS.getItem(plugin));
                    Bukkit.broadcastMessage("Player: " + key + " Damage: " + bossDamage.get(key));
                }
                dragonFight = false;
                return;
            }
            ((LivingEntity) event.getEntity()).setHealth(value);

        }
    }
}