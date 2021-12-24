package its.wurm.testplugin.Events;

import its.wurm.testplugin.Main;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

public class PlayerStatEvents implements Listener {
    static Main plugin;

    public PlayerStatEvents(Main plugin) { this.plugin = plugin;}

    @EventHandler
    public void assign(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        //Define Health
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                PersistentDataType.DOUBLE, 100.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE, 0.0);

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Defense
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Strength
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Crit Chance
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                PersistentDataType.DOUBLE, 20.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Crit Damage
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritBase"),
                PersistentDataType.DOUBLE, 50.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE, 0.0);


        //Define Damage
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageBase"),
                PersistentDataType.DOUBLE, 1.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Speed
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBase"),
                PersistentDataType.DOUBLE, 100.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Intelligence
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE, 0.0);

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ManaBase"),
                PersistentDataType.DOUBLE, 100.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ManaSave"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ManaModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Magic Find
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicBase"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Mining Fortune
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Farming Fortune
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Excavating Fortune
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFModifier"),
                PersistentDataType.DOUBLE, 0.0);

        //Define soup and food limits
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthSoup"),
                PersistentDataType.INTEGER, 0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritSoup"),
                PersistentDataType.INTEGER, 0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthSoup"),
                PersistentDataType.INTEGER, 0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseSoup"),
                PersistentDataType.INTEGER, 0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntSoup"),
                PersistentDataType.INTEGER, 0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FoodMax"),
                PersistentDataType.INTEGER, 10);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Food"),
                PersistentDataType.INTEGER, 0);

        //set current health and mana
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 100.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, 100.0);
    }


public static void updateStats(Player player, Main plugin) {

    //take base damage
    double damage = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageBase"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for damage and apply it to damage
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
        PersistentDataType.DOUBLE) != null) {
        damage = damage + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE);
    }

    //take base damage mod
    double damageMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for damage mod and apply it to damage mod
    if (player.getInventory().getItemInMainHand() != null &&
            player.getInventory().getItemInMainHand().getItemMeta() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) != null) {

        damageMod = damageMod + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for damage mod and apply it to damage mod
    if (player.getInventory().getItemInOffHand() != null &&
            player.getInventory().getItemInOffHand().getItemMeta() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                    PersistentDataType.INTEGER) != null) {

        damageMod = damageMod + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for damage mod and apply it to damage mod
    if (player.getInventory().getHelmet() != null &&
            player.getInventory().getHelmet().getItemMeta() != null &&
            player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) != null) {

        damageMod = damageMod + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for damage mod and apply it to damage mod
    if (player.getInventory().getChestplate() != null &&
            player.getInventory().getChestplate().getItemMeta() != null &&
            player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) != null) {

        damageMod = damageMod + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for damage md and apply it to damage mod
    if (player.getInventory().getLeggings() != null &&
            player.getInventory().getLeggings().getItemMeta() != null &&
            player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) != null) {

        damageMod = damageMod + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for damage mod and apply it to health
    if (player.getInventory().getBoots() != null &&
            player.getInventory().getBoots().getItemMeta() != null &&
            player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) != null) {

        damageMod = damageMod + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "damageModifier"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
            PersistentDataType.DOUBLE, (1 + damageMod) * damage);



    //take base health
    double health = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for health and apply it to health
    if (player.getInventory().getItemInMainHand() != null &&
            player.getInventory().getItemInMainHand().getItemMeta() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
            PersistentDataType.DOUBLE) != null) {

        health = health + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for health and apply it to health
    if (player.getInventory().getItemInOffHand() != null &&
            player.getInventory().getItemInOffHand().getItemMeta() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
            PersistentDataType.DOUBLE) != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
            PersistentDataType.INTEGER) != null) {

        health = health + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for health and apply it to health
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
        PersistentDataType.DOUBLE) != null) {

        health = health + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for health and apply it to health
    if (player.getInventory().getChestplate() != null &&
    player.getInventory().getChestplate().getItemMeta() != null &&
    player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
    player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
    PersistentDataType.DOUBLE) != null) {

        health = health + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for health and apply it to health
    if (player.getInventory().getLeggings() != null &&
    player.getInventory().getLeggings().getItemMeta() != null &&
    player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
    player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
    PersistentDataType.DOUBLE) != null) {

        health = health + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for health and apply it to health
    if (player.getInventory().getBoots() != null &&
            player.getInventory().getBoots().getItemMeta() != null &&
            player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) != null) {

        health = health + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
    }

    //take base health modifier
    double healthMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for health modifier and apply it to health modifier
    if (player.getInventory().getItemInMainHand() != null &&
    player.getInventory().getItemInMainHand().getItemMeta() != null &&
    player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
    player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
    PersistentDataType.DOUBLE) != null) {

        healthMod = healthMod + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for health modifier and apply it to health modifier
    if (player.getInventory().getItemInOffHand() != null &&
            player.getInventory().getItemInOffHand().getItemMeta() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE) != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                    PersistentDataType.INTEGER) != null) {

        healthMod = healthMod + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for health modifier and apply it to health modifier
    if (player.getInventory().getHelmet() != null &&
            player.getInventory().getHelmet().getItemMeta() != null &&
            player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
            PersistentDataType.DOUBLE) != null) {

        healthMod = healthMod + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for health modifier and apply it to health modifier
    if (player.getInventory().getChestplate() != null &&
    player.getInventory().getChestplate().getItemMeta() != null &&
    player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
    player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
    PersistentDataType.DOUBLE) != null) {

        healthMod = healthMod + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for health mod and apply it to health mod
    if (player.getInventory().getLeggings() != null &&
            player.getInventory().getLeggings().getItemMeta() != null &&
            player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE) != null) {

        healthMod = healthMod + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for health modifier and apply it to health modifier
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {

        healthMod = healthMod + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
            PersistentDataType.DOUBLE, (1 + healthMod) * health);


    //take base defense
    double defense = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for defense and apply it to defense
    if (player.getInventory().getItemInMainHand() != null &&
            player.getInventory().getItemInMainHand().getItemMeta() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) != null) {

        defense = defense + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for defense and apply it to defense
    if (player.getInventory().getItemInOffHand() != null &&
            player.getInventory().getItemInOffHand().getItemMeta() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                    PersistentDataType.INTEGER) != null) {

        defense = defense + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for defense and apply it to defense
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {

        defense = defense + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for defense and apply it to defense
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {

        defense = defense + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for defense and apply it to defense
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {

        defense = defense + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for defense and apply it to defense
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {

        defense = defense + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE);
    }

    //take base defense modifier
    double defenseMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for defense modifier and apply it to defense modifier
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {

        defenseMod = defenseMod + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for defense modifier and apply it to defense modifier
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        defenseMod = defenseMod + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for defense modifier and apply it to defense modifier
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {

        defenseMod = defenseMod + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for defense modifier and apply it to defense modifier
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {

        defenseMod = defenseMod + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for defense mod and apply it to defense mod
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {

        defenseMod = defenseMod + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for defense modifier and apply it to defense modifier
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {

        defenseMod = defenseMod + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
            PersistentDataType.DOUBLE, (1 + defenseMod) * defense);

    //take base strength
    double strength = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for strength and apply it to strength
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {

        strength = strength + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for strength and apply it to strength
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        defense = defense + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for strength and apply it to strength
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {

        strength = strength + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for strength and apply it to strength
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {

        strength = strength + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for strength and apply it to strength
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {

        strength = strength + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for strength and apply it to strength
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {

        strength = strength + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE);
    }

    //take base strength modifier
    double strengthMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for strength modifier and apply it to strength modifier
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {

        strengthMod = strengthMod + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for strength modifier and apply it to strength modifier
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        strengthMod = strengthMod + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for strength modifier and apply it to strength modifier
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {

        strengthMod = strengthMod + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for strength modifier and apply it to strength modifier
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {

        strengthMod = strengthMod + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for strength mod and apply it to strength mod
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {

        strengthMod = strengthMod + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for defense strength and apply it to defense strength
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {

        strengthMod = strengthMod + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Strength"),
            PersistentDataType.DOUBLE, (1 + strengthMod) * strength);


    //take base crit chance
    double critChance = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for crit chance and apply it to crit chance
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {

        critChance = critChance + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for crit chance and apply it to crit chance
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        critChance = critChance + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for crit chance and apply it to crit chance
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {

        critChance = critChance + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for crit chance and apply it to crit chance
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {

        critChance = critChance + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for crit chance and apply it to crit chance
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {

        critChance = critChance + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for crit chance and apply it to crit chance
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {

        critChance = critChance + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE);
    }

    //take base crit chance modifier
    double critChanceMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for crit chance modifier and apply it to crit chance modifier
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {

        critChanceMod = critChanceMod + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for crit chance modifier and apply it to crit chance modifier
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        critChanceMod = critChanceMod + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for crit chance modifier and apply it to crit chance modifier
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {

        critChanceMod = critChanceMod + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for crit chance modifier and apply it to crit chance modifier
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {

        critChanceMod = critChanceMod + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for crit chance mod and apply it to crit chance mod
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {

        critChanceMod = critChanceMod + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for crit chance mod and apply it to crit chance mod
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {

        critChanceMod = critChanceMod + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritChance"),
            PersistentDataType.DOUBLE, (1 + critChanceMod) * critChance);


    //take base crit damage
    double crit = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritBase"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for crit and apply it to crit
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {

        crit = crit + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for crit and apply it to crit
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        crit = crit + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for crit and apply it to crit
if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {

        crit = crit + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for crit and apply it to crit
    if (player.getInventory().getChestplate() != null &&
    player.getInventory().getChestplate().getItemMeta() != null &&
    player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
    player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
            PersistentDataType.DOUBLE) != null) {

        crit = crit + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for crit and apply it to crit
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {

        crit = crit + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for crit and apply it to crit
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {

        crit = crit + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE);
    }

    //take base crit modifier
    double critMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for crit modifier and apply it to crit modifier
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {

        critMod = critMod + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for crit modifier and apply it to crit modifier
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        critMod = critMod + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for crit modifier and apply it to crit modifier
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {

        critMod = critMod + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for crit modifier and apply it to crit modifier
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {

        critMod = critMod + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for crit mod and apply it to crit mod
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {

        critMod = critMod + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for crit mod and apply it to crit mod
    if (player.getInventory().getBoots() != null &&
            player.getInventory().getBoots().getItemMeta() != null &&
            player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE) != null) {

        critMod = critMod + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Crit"),
            PersistentDataType.DOUBLE, (1 + critMod) * crit);


    //take base speed
    double speed = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBase"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for speed and apply it to speed
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {

        speed = speed + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for speed and apply it to speed
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        speed = speed + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for speed and apply it to speed
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {

        speed = speed + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for speed and apply it to speed
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {

        speed = speed + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for speed and apply it to speed
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {

        speed = speed + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for speed and apply it to speed
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {

        speed = speed + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE);
    }

    //take base speed modifier
    double speedMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for speed modifier and apply it to speed modifier
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {

        speedMod = speedMod + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for crit modifier and apply it to crit modifier
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        speedMod = speedMod + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for speed modifier and apply it to speed modifier
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {

        speedMod = speedMod + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for speed modifier and apply it to speed modifier
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {

        speedMod = speedMod + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for speed mod and apply it to speed mod
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {

        speedMod = speedMod + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for speed mod and apply it to speed mod
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {

        speedMod = speedMod + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Speed"),
            PersistentDataType.DOUBLE, (1 + speedMod) * speed);

    //take base intelligence
    double intelligence = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntBase"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for intelligence and apply it to intelligence
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {

        intelligence = intelligence + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for intelligence and apply it to intelligence
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        intelligence = intelligence + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for intelligence and apply it to intelligence
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {

        intelligence = intelligence + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for intelligence and apply it to intelligence
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {

        intelligence = intelligence + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for intelligence and apply it to intelligence
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {

        intelligence = intelligence + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for intelligence and apply it to intelligence
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {

        intelligence = intelligence + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE);
    }

    //take base intelligence modifier
    double intMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for intelligence modifier and apply it to intelligence modifier
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        intMod = intMod + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for intelligence modifier and apply it to intelligence modifier
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        intMod = intMod + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for intelligence modifier and apply it to intelligence modifier
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        intMod = intMod + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for intelligence modifier and apply it to intelligence modifier
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        intMod = intMod + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for intelligence mod and apply it to intelligence mod
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        intMod = intMod + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for intelligence mod and apply it to intelligence mod
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        intMod = intMod + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Intelligence"),
            PersistentDataType.DOUBLE, (1 + intMod) * intelligence);

    //take base mana
    double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ManaBase"),
            PersistentDataType.DOUBLE);

    //take base mana modifier
    double manaMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for mana modifier and apply it to mana modifier
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        manaMod = manaMod + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for mana modifier and apply it to mana modifier
    if (player.getInventory().getItemInOffHand() != null &&
            player.getInventory().getItemInOffHand().getItemMeta() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                    PersistentDataType.DOUBLE) != null &&
            player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                    PersistentDataType.INTEGER) != null) {

        manaMod = manaMod + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for mana modifier and apply it to mana modifier
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        manaMod = manaMod + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for mana modifier and apply it to mana modifier
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        manaMod = manaMod + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for mana mod and apply it to mana mod
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        manaMod = manaMod + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for mana mod and apply it to mana mod
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE) != null) {

        manaMod = manaMod + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxMana"),
            PersistentDataType.DOUBLE, (1 + manaMod) * (mana + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE)));

    //take base magic find
    double magic = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicBase"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for speed and apply it to magic find
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {

        magic = magic + player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE);
    }

    //Check player's off hand item for speed and apply it to magic find
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        magic = magic + player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE);
    }

    //Check player's helmet for speed and apply it to magic find
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {

        magic = magic + player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE);
    }

    //Check player's chest for speed and apply it to magic find
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {

        magic = magic + player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE);
    }

    //Check player's legs for speed and apply it to magic find
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {

        magic = magic + player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE);
    }

    //Check player's boots for speed and apply it to magic find
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {

        magic = magic + player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE);
    }

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicFind"),
            PersistentDataType.DOUBLE, magic);

}

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                PersistentDataType.DOUBLE, 0.0);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {

                PlayerStatEvents.updateStats(player, plugin);

                float speed = (float) (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                                        PersistentDataType.DOUBLE) / 1000);
                player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);

                if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CoolDown"),
                    PersistentDataType.DOUBLE) == 0) {
                    StatFunctions.ShowStat(player, plugin);
                }
                else {
                    Double cd = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CoolDown"),
                            PersistentDataType.DOUBLE) - 1;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                            PersistentDataType.DOUBLE, cd);
                }
            }
        }, 100, 5);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {

                if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE)) {
                    Double heal = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE)/100;
                    heal = heal * 2;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) + heal);

                }
                if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE) < player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE)) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                    PersistentDataType.DOUBLE));
                }

                if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE)) {
                    Double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                            PersistentDataType.DOUBLE)/100;
                    mana = mana * 2;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                                    PersistentDataType.DOUBLE) + mana);

                }
                if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE) < player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE)) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                                    PersistentDataType.DOUBLE));
                }
            }
        }, 100, 20);
    }
}