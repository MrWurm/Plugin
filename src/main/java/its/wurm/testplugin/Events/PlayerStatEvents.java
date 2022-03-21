package its.wurm.testplugin.Events;

import its.wurm.testplugin.Main;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

public class PlayerStatEvents implements Listener {
    Main plugin;
    StatFunctions functions;

    public PlayerStatEvents(Main plugin) {
        this.plugin = plugin;
        this.functions =  new StatFunctions(plugin, null);
    }

    @EventHandler
    public void assign(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        //Define Health
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                PersistentDataType.DOUBLE, 100.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthModifierSet"),
                PersistentDataType.DOUBLE, 0.0);


        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Defense
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Strength
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Crit Chance
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                PersistentDataType.DOUBLE, 20.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Crit Damage
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritBase"),
                PersistentDataType.DOUBLE, 50.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritModifierSet"),
                PersistentDataType.DOUBLE, 0.0);


        //Define Damage
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageBase"),
                PersistentDataType.DOUBLE, 1.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Speed
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBase"),
                PersistentDataType.DOUBLE, 100.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Attack Speed
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Intelligence
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ManaBase"),
                PersistentDataType.DOUBLE, 100.0);

        //Define Thaumaturgy
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgySet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Invocation
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationSet"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationModifierSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Magic Find
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Mining Fortune
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Farming Fortune
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmSet"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Excavating Fortune
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcSet"),
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
                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE));
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE));

        //set a player's class
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING, "adventurer");
        //set a player's rank
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Rank"),
                PersistentDataType.STRING, "");
        //set a player's id
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, "Player");
        //set a player's pacifist mode
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "peace"),
                PersistentDataType.INTEGER, 0);
    }


public static void updateStats(Player player, Main plugin) {

    //take base damage
    double damage = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageBonus"),
            PersistentDataType.DOUBLE);

    //take base damage mod
    double damageMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base strength
    double strength = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
            PersistentDataType.DOUBLE);

    //take base strength mod
    double strengthMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Damage
    double crit = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Damage mod
    double critMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Chance
    double CC = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Chance mod
    double CCMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Attack Speed
    double attackSpeed = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Chance mod
    double attackSpeedMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifierBonus"),
            PersistentDataType.DOUBLE);


    //take base Health
    double health = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBonus"),
            PersistentDataType.DOUBLE);

    //take base Health mod
    double healthMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Heal mod
    double healMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Defense
    double defense = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBonus"),
            PersistentDataType.DOUBLE);

    //take base Defense mod
    double defenseMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Speed
    double speed = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
            PersistentDataType.DOUBLE);

    //take base Speed mod
    double speedMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Intelligence
    double intelligence = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntBonus"),
            PersistentDataType.DOUBLE);

    //take base intelligence mod
    double intelligenceMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Mana
    double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ManaBase"),
            PersistentDataType.DOUBLE);

    //take base Thaumaturgy
    double thaumaturgy = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgySet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyBonus"),
            PersistentDataType.DOUBLE);

    //take base Thaumaturgy mod
    double thaumaturgyMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Invocation
    double invocation = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationBonus"),
            PersistentDataType.DOUBLE);

    //take base Invocation mod
    double invocationMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifierSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Magic Find
    double MF = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicBonus"),
            PersistentDataType.DOUBLE);

    //take base Farming Fortune
    double Farm = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmBonus"),
            PersistentDataType.DOUBLE);

    //take base Mining Fortune
    double Mine = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"),
            PersistentDataType.DOUBLE);

    //take base Excavating Fortune
    double Excavating = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcSet"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcBonus"),
            PersistentDataType.DOUBLE);

    //Check player's main hand item for stats and apply it to stats
    if (player.getInventory().getItemInMainHand() != null &&
        player.getInventory().getItemInMainHand().getItemMeta() != null &&
        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
        (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING) == null ||
        (!(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING).equals("helmet")) &&
            !(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING).equals("chestplate")) &&
            !(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING).equals("leggings")) &&
            !(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING).equals("boots"))))) {

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE) != null) {
            damage += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamage"),
                PersistentDataType.DOUBLE) != null) {
            damage += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamage"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
             MF += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }
    }

    //Check player's off hand item for stats and apply it to stats
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
                PersistentDataType.INTEGER) != null) {

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }
    }

    //Check player's helmet for stats and apply it to stats
    if (player.getInventory().getHelmet() != null &&
        player.getInventory().getHelmet().getItemMeta() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING) != null &&
        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING).equals("helmet")) {

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThauumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }

    }

    //Check player's chest for stats and apply it to stats
    if (player.getInventory().getChestplate() != null &&
        player.getInventory().getChestplate().getItemMeta() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING) != null &&
        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING).equals("chestplate")) {

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThamauturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }


    }

    //Check player's legs for stats and apply it to stats
    if (player.getInventory().getLeggings() != null &&
        player.getInventory().getLeggings().getItemMeta() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING) != null &&
        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING).equals("leggings")) {

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }
    }

    //Check player's boots for stats and apply it to stats
    if (player.getInventory().getBoots() != null &&
        player.getInventory().getBoots().getItemMeta() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING) != null &&
        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                PersistentDataType.STRING).equals("boots")) {

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }


    }

    //Check player's full set bonus for stats
    //Check player for bonus stats

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
            PersistentDataType.DOUBLE, (1 + damageMod) * damage);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Strength"),
            PersistentDataType.DOUBLE, (1 + strengthMod) * strength);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Crit"),
            PersistentDataType.DOUBLE, (1 + critMod) * crit);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritChance"),
            PersistentDataType.DOUBLE, (1 + CCMod) * CC);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeed"),
            PersistentDataType.DOUBLE, (1 + attackSpeedMod) * attackSpeed);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
            PersistentDataType.DOUBLE, (1 + healthMod) * health);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
            PersistentDataType.DOUBLE, (1 + defenseMod) * defense);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Speed"),
            PersistentDataType.DOUBLE, (1 + speedMod) * speed);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Intelligence"),
            PersistentDataType.DOUBLE, (1 + intelligenceMod) * intelligence);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Thaumaturgy"),
            PersistentDataType.DOUBLE, (1 + thaumaturgyMod) * thaumaturgy);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Invocation"),
            PersistentDataType.DOUBLE, (1 + invocationMod) * invocation);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicFind"),
            PersistentDataType.DOUBLE, MF);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmingFortune"),
            PersistentDataType.DOUBLE, Farm);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MiningFortune"),
            PersistentDataType.DOUBLE, Mine);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcavatingFortune"),
            PersistentDataType.DOUBLE, Excavating);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxMana"),
            PersistentDataType.DOUBLE, mana + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE));

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
            PersistentDataType.DOUBLE, healMod + 1);

}

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                PersistentDataType.DOUBLE, 0.0);

        String name = player.getName();
        switch (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Rank"),
                PersistentDataType.STRING)) {
            case "VIP":
                name = ChatColor.GREEN + "[" + ChatColor.GOLD + "V" + ChatColor.GREEN + "I" + ChatColor.GOLD + "P" + ChatColor.GREEN + "] " + player.getName();
                break;
            case "MVP":
                name = ChatColor.GOLD + "[MVP] " + player.getName();
                break;
            case "ADMIN":
                name = ChatColor.RED + "[ADMIN] " + player.getName();
                break;
            case "PATRON":
                name = ChatColor.DARK_BLUE + "[" + ChatColor.BLUE + "P" + ChatColor.DARK_PURPLE + "A" + ChatColor.BLUE + "T" + ChatColor.DARK_PURPLE + "R" + ChatColor.BLUE + "O" + ChatColor.DARK_PURPLE + "N"+ ChatColor.DARK_BLUE + "] " + ChatColor.BLUE + player.getName();
                break;
            case "WURM":
                name = ChatColor.DARK_AQUA + "[WURM] " + player.getName();
                break;
            default:
                break;
        }
        player.setDisplayName(name);
        player.setPlayerListName(name);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {

                PlayerStatEvents.updateStats(player, plugin);

                float speed = (float) (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Speed"),
                                        PersistentDataType.DOUBLE) / 1000);
                if (speed > 0) {
                    player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                } else {
                    player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.001);
                }

                float attack = 4;

                if (player.getInventory().getItemInMainHand() != null) {
                    switch (player.getInventory().getItemInMainHand().getType()) {
                        case WOODEN_SWORD:
                        case STONE_SWORD:
                        case GOLDEN_SWORD:
                        case IRON_SWORD:
                        case DIAMOND_SWORD:
                        case NETHERITE_SWORD:
                            attack += 2.4;
                            break;
                        case WOODEN_PICKAXE:
                        case STONE_PICKAXE:
                        case GOLDEN_PICKAXE:
                        case IRON_PICKAXE:
                        case DIAMOND_PICKAXE:
                        case NETHERITE_PICKAXE:
                            attack += 2.8;
                            break;
                        case TRIDENT:
                            attack += 2.9;
                            break;
                        case WOODEN_HOE:
                        case STONE_HOE:
                        case GOLDEN_HOE:
                        case IRON_HOE:
                        case DIAMOND_HOE:
                        case NETHERITE_HOE:
                        case WOODEN_AXE:
                        case STONE_AXE:
                        case GOLDEN_AXE:
                        case IRON_AXE:
                        case DIAMOND_AXE:
                        case NETHERITE_AXE:
                        case WOODEN_SHOVEL:
                        case STONE_SHOVEL:
                        case GOLDEN_SHOVEL:
                        case IRON_SHOVEL:
                        case DIAMOND_SHOVEL:
                        case NETHERITE_SHOVEL:
                            attack += 3;
                            break;
                    }
                }

                attack += (float) (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                        PersistentDataType.DOUBLE) / 50);

                player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(attack);

                if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CoolDown"),
                    PersistentDataType.DOUBLE) == 0) {
                    functions.ShowStat(player, plugin);
                }
                else {
                    double cd = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CoolDown"),
                            PersistentDataType.DOUBLE) - 1;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                            PersistentDataType.DOUBLE, cd);
                }
            }
        }, 100, 5);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            public void run() {

                functions.heal(plugin, player, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE)/50);

                if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE)) {
                    double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
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