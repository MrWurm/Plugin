package its.wurm.testplugin.Events;

import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.persistentDataContainers.stringList;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class PlayerStatEvents implements Listener {
    Main plugin;
    StatFunctions functions;

    public PlayerStatEvents(Main plugin) {
        this.plugin = plugin;
        this.functions =  new StatFunctions(plugin, null);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void assign(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        //Define Health
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                PersistentDataType.DOUBLE, 100.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Defense
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Strength
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Crit Chance
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                PersistentDataType.DOUBLE, 20.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Crit Damage
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritBase"),
                PersistentDataType.DOUBLE, 50.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CritModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Damage
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageBase"),
                PersistentDataType.DOUBLE, 1.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Speed
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBase"),
                PersistentDataType.DOUBLE, 100.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Attack Speed
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Intelligence
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ManaBase"),
                PersistentDataType.DOUBLE, 100.0);

        //Define Thaumaturgy
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Invocation
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationBonus"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationModifierBonus"),
                PersistentDataType.DOUBLE, 0.0);
        //Define Magic Find
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Mining Fortune
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"),
                PersistentDataType.DOUBLE, 0.0);
        //Define Farming Fortune
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmBonus"),
                PersistentDataType.DOUBLE, 0.0);

        //Define Excavating Fortune
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcBase"),
                PersistentDataType.DOUBLE, 0.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcBonus"),
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
        //set a player's skill noise mode
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "noise"),
                PersistentDataType.INTEGER, 0);
        //set a player's unlocked enchantments
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "enchantmentsAvailable"),
                new stringList(), new String[]{});
        //set a player's unlocked enchantment levels
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "enchantmentsLevel"),
                PersistentDataType.INTEGER_ARRAY, new int[]{});
        //set a player's toggle on if it should be toggled
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "smeltToggles"),
                PersistentDataType.INTEGER_ARRAY, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        //set a player's potion types
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "potionEffects"),
                new stringList(), new String[]{});
        //set a player's potion levels
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "potionLevels"),
                PersistentDataType.INTEGER_ARRAY, new int[]{});
        //set a player's potions durations
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "potionDurations"),
                PersistentDataType.LONG_ARRAY, new long[]{});
        //set a player's unlocked sacks
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sacksUnlocked"),
                new stringList(), new String[]{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"});
        //set a player's sack materials
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sackMaterial"),
                new stringList(), new String[]{});
        //set player's maximum amount for a sack material
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sackMax"),
                PersistentDataType.INTEGER_ARRAY, new int[]{});
        //set a player's amount of sack materials
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sackAmount"),
                PersistentDataType.INTEGER_ARRAY, new int[]{});
        //set a player's pet
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Pet"),
                PersistentDataType.BYTE_ARRAY, new byte[]{});
        //set a player's available pets
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "availablePets"),
                PersistentDataType.BYTE_ARRAY, new byte[]{});
        //set a player's pet selection mode
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "selectionMode"),
                PersistentDataType.INTEGER, 0);
    }


public static void updateStats(Player player, Main plugin, StatFunctions functions) {

    //take base damage
    double damage = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageBonus"),
            PersistentDataType.DOUBLE);

    //take base damage mod
    double damageMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base strength
    double strength = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
            PersistentDataType.DOUBLE);

    //take base strength mod
    double strengthMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Damage
    double crit = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Damage mod
    double critMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Chance
    double CC = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Chance mod
    double CCMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Attack Speed
    double attackSpeed = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBonus"),
            PersistentDataType.DOUBLE);

    //take base Crit Chance mod
    double attackSpeedMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedModifierBonus"),
            PersistentDataType.DOUBLE);


    //take base Health
    double health = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBonus"),
            PersistentDataType.DOUBLE);

    //take base Health mod
    double healthMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Heal mod
    double healMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Defense
    double defense = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBonus"),
            PersistentDataType.DOUBLE);

    //take base Defense mod
    double defenseMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Speed
    double speed = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
            PersistentDataType.DOUBLE);

    //take base Speed mod
    double speedMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Intelligence
    double intelligence = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntBonus"),
            PersistentDataType.DOUBLE);

    //take base intelligence mod
    double intelligenceMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Mana
    double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ManaBase"),
            PersistentDataType.DOUBLE);

    //take base Thaumaturgy
    double thaumaturgy = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyBonus"),
            PersistentDataType.DOUBLE);

    //take base Thaumaturgy mod
    double thaumaturgyMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Invocation
    double invocation = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationBonus"),
            PersistentDataType.DOUBLE);

    //take base Invocation mod
    double invocationMod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifier"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationModifierBonus"),
            PersistentDataType.DOUBLE);

    //take base Magic Find
    double MF = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicBonus"),
            PersistentDataType.DOUBLE);

    //take base Farming Fortune
    double Farm = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmBonus"),
            PersistentDataType.DOUBLE);

    //take base Farming Fortune Modifier
    double FarmMod = 0.0;

    //take base Mining Fortune
    double Mine = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"),
            PersistentDataType.DOUBLE);

    //take base Mining Fortune Modifier
    double MineMod = 0.0;

    //take base Excavating Fortune
    double Excavating = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcBase"),
            PersistentDataType.DOUBLE) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcBonus"),
            PersistentDataType.DOUBLE);

    //take base Excavating Fortune Modifier
    double ExcavatingMod = 0.0;

    //Check a player's pet for stats and apply it to stats
    if (functions.getPets().get(player) != null) {
        PersistentDataContainer pet = functions.getPets().get(player).getItemMeta().getPersistentDataContainer();
        if (pet.get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE) != null) {
            damage += pet.get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemDamage"),
                PersistentDataType.DOUBLE) != null) {
            damage += pet.get(new NamespacedKey(plugin, "ItemDamage"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += pet.get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += pet.get(new NamespacedKey(plugin, "ItemDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += pet.get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += pet.get(new NamespacedKey(plugin, "ItemStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += pet.get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += pet.get(new NamespacedKey(plugin, "ItemStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += pet.get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += pet.get(new NamespacedKey(plugin, "ItemCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += pet.get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += pet.get(new NamespacedKey(plugin, "ItemCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += pet.get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += pet.get(new NamespacedKey(plugin, "ItemCC"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += pet.get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += pet.get(new NamespacedKey(plugin, "ItemCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += pet.get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += pet.get(new NamespacedKey(plugin, "ItemAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += pet.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += pet.get(new NamespacedKey(plugin, "ItemAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += pet.get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += pet.get(new NamespacedKey(plugin, "ItemHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += pet.get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += pet.get(new NamespacedKey(plugin, "ItemHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += pet.get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += pet.get(new NamespacedKey(plugin, "ItemDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += pet.get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += pet.get(new NamespacedKey(plugin, "ItemDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += pet.get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += pet.get(new NamespacedKey(plugin, "ItemSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += pet.get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += pet.get(new NamespacedKey(plugin, "ItemSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += pet.get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += pet.get(new NamespacedKey(plugin, "ItemIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += pet.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += pet.get(new NamespacedKey(plugin, "ItemIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += pet.get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += pet.get(new NamespacedKey(plugin, "ItemThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += pet.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += pet.get(new NamespacedKey(plugin, "ItemThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += pet.get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += pet.get(new NamespacedKey(plugin, "ItemInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += pet.get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += pet.get(new NamespacedKey(plugin, "ItemInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += pet.get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += pet.get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += pet.get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += pet.get(new NamespacedKey(plugin, "ItemFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "FarmingFortuneModifier"),
                PersistentDataType.DOUBLE) != null) {
            FarmMod += pet.get(new NamespacedKey(plugin, "FarmingFortuneModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemFarmingFortuneModifier"),
                PersistentDataType.DOUBLE) != null) {
            FarmMod += pet.get(new NamespacedKey(plugin, "ItemFarmingFortuneModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += pet.get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += pet.get(new NamespacedKey(plugin, "ItemMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "MiningFortuneModifier"),
                PersistentDataType.DOUBLE) != null) {
            MineMod += pet.get(new NamespacedKey(plugin, "MiningFortuneModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemMiningFortuneModifier"),
                PersistentDataType.DOUBLE) != null) {
            MineMod += pet.get(new NamespacedKey(plugin, "ItemMiningFortuneModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += pet.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += pet.get(new NamespacedKey(plugin, "ItemExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ExcavatingFortuneModifier"),
                PersistentDataType.DOUBLE) != null) {
             ExcavatingMod += pet.get(new NamespacedKey(plugin, "ExcavatingFortuneModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemExcavatingFortuneModifier"),
                PersistentDataType.DOUBLE) != null) {
            ExcavatingMod += pet.get(new NamespacedKey(plugin, "ItemExcavatingFortuneModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += pet.get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (pet.get(new NamespacedKey(plugin, "ItemHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += pet.get(new NamespacedKey(plugin, "ItemHealMod"),
                    PersistentDataType.DOUBLE);
        }
    }

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
        
        PersistentDataContainer mainHand = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();

        if (mainHand.get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE) != null) {
            damage += mainHand.get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeDamage"),
                PersistentDataType.DOUBLE) != null) {
            damage += mainHand.get(new NamespacedKey(plugin, "ReforgeDamage"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantDamage"),
                PersistentDataType.DOUBLE) != null) {
            damage += mainHand.get(new NamespacedKey(plugin, "EnchantDamage"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += mainHand.get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += mainHand.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += mainHand.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += mainHand.get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += mainHand.get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += mainHand.get(new NamespacedKey(plugin, "EnchantStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += mainHand.get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += mainHand.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += mainHand.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += mainHand.get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += mainHand.get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += mainHand.get(new NamespacedKey(plugin, "EnchantCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += mainHand.get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += mainHand.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += mainHand.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += mainHand.get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += mainHand.get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += mainHand.get(new NamespacedKey(plugin, "EnchantCC"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += mainHand.get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += mainHand.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += mainHand.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += mainHand.get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += mainHand.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += mainHand.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += mainHand.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += mainHand.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += mainHand.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += mainHand.get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += mainHand.get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += mainHand.get(new NamespacedKey(plugin, "EnchantHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += mainHand.get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += mainHand.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += mainHand.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += mainHand.get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += mainHand.get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += mainHand.get(new NamespacedKey(plugin, "EnchantDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += mainHand.get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += mainHand.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += mainHand.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += mainHand.get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += mainHand.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += mainHand.get(new NamespacedKey(plugin, "EnchantSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += mainHand.get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += mainHand.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += mainHand.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += mainHand.get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += mainHand.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += mainHand.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += mainHand.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += mainHand.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += mainHand.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += mainHand.get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += mainHand.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += mainHand.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += mainHand.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += mainHand.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += mainHand.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += mainHand.get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += mainHand.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += mainHand.get(new NamespacedKey(plugin, "EnchantInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += mainHand.get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += mainHand.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += mainHand.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
             MF += mainHand.get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += mainHand.get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += mainHand.get(new NamespacedKey(plugin, "EnchantMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += mainHand.get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += mainHand.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += mainHand.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += mainHand.get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += mainHand.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += mainHand.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += mainHand.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += mainHand.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += mainHand.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += mainHand.get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += mainHand.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (mainHand.get(new NamespacedKey(plugin, "EnchantHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += mainHand.get(new NamespacedKey(plugin, "EnchantHealMod"),
                    PersistentDataType.DOUBLE);
        }
    }

    //Check player's off hand item for stats and apply it to stats
    if (player.getInventory().getItemInOffHand() != null &&
        player.getInventory().getItemInOffHand().getItemMeta() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Dual"),
            PersistentDataType.INTEGER) != null) {

        PersistentDataContainer offHand = player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer();

        if (offHand.get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += offHand.get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += offHand.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += offHand.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += offHand.get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += offHand.get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += offHand.get(new NamespacedKey(plugin, "EnchantStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += offHand.get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += offHand.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += offHand.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += offHand.get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += offHand.get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += offHand.get(new NamespacedKey(plugin, "EnchantCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += offHand.get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += offHand.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += offHand.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += offHand.get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += offHand.get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += offHand.get(new NamespacedKey(plugin, "EnchantCC"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += offHand.get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += offHand.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += offHand.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += offHand.get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += offHand.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += offHand.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += offHand.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += offHand.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += offHand.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += offHand.get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += offHand.get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += offHand.get(new NamespacedKey(plugin, "EnchantHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += offHand.get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += offHand.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += offHand.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += offHand.get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += offHand.get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += offHand.get(new NamespacedKey(plugin, "EnchantDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += offHand.get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += offHand.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += offHand.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += offHand.get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += offHand.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += offHand.get(new NamespacedKey(plugin, "EnchantSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += offHand.get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += offHand.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += offHand.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += offHand.get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += offHand.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += offHand.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += offHand.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += offHand.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += offHand.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += offHand.get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += offHand.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += offHand.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += offHand.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += offHand.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += offHand.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += offHand.get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += offHand.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += offHand.get(new NamespacedKey(plugin, "EnchantInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += offHand.get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += offHand.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += offHand.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += offHand.get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += offHand.get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += offHand.get(new NamespacedKey(plugin, "EnchantMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += offHand.get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += offHand.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += offHand.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += offHand.get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += offHand.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += offHand.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += offHand.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += offHand.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += offHand.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += offHand.get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += offHand.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (offHand.get(new NamespacedKey(plugin, "EnchantHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += offHand.get(new NamespacedKey(plugin, "EnchantHealMod"),
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

        PersistentDataContainer helmet = player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer();

        if (helmet.get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += helmet.get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += helmet.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += helmet.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += helmet.get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += helmet.get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += helmet.get(new NamespacedKey(plugin, "EnchantStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += helmet.get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += helmet.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += helmet.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += helmet.get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += helmet.get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += helmet.get(new NamespacedKey(plugin, "EnchantCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += helmet.get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += helmet.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += helmet.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += helmet.get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += helmet.get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += helmet.get(new NamespacedKey(plugin, "EnchantCC"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += helmet.get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += helmet.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += helmet.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += helmet.get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += helmet.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += helmet.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += helmet.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += helmet.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += helmet.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += helmet.get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += helmet.get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += helmet.get(new NamespacedKey(plugin, "EnchantHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += helmet.get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += helmet.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += helmet.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += helmet.get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += helmet.get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += helmet.get(new NamespacedKey(plugin, "EnchantDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += helmet.get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += helmet.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += helmet.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += helmet.get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += helmet.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += helmet.get(new NamespacedKey(plugin, "EnchantSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += helmet.get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += helmet.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += helmet.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += helmet.get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += helmet.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += helmet.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += helmet.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += helmet.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += helmet.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += helmet.get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeThauumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += helmet.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantThauumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += helmet.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += helmet.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += helmet.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += helmet.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += helmet.get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += helmet.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += helmet.get(new NamespacedKey(plugin, "EnchantInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += helmet.get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += helmet.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += helmet.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += helmet.get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += helmet.get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += helmet.get(new NamespacedKey(plugin, "EnchantMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += helmet.get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += helmet.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += helmet.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += helmet.get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += helmet.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += helmet.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += helmet.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += helmet.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += helmet.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += helmet.get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += helmet.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (helmet.get(new NamespacedKey(plugin, "EnchantHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += helmet.get(new NamespacedKey(plugin, "EnchantHealMod"),
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

        PersistentDataContainer chest = player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer();
        
        if (chest.get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += chest.get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += chest.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += chest.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += chest.get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += chest.get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += chest.get(new NamespacedKey(plugin, "EnchantStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += chest.get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += chest.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += chest.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += chest.get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += chest.get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += chest.get(new NamespacedKey(plugin, "EnchantCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += chest.get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += chest.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += chest.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += chest.get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += chest.get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += chest.get(new NamespacedKey(plugin, "EnchantCC"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += chest.get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += chest.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += chest.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += chest.get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += chest.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += chest.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += chest.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += chest.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += chest.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += chest.get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += chest.get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += chest.get(new NamespacedKey(plugin, "EnchantHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += chest.get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += chest.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += chest.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += chest.get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += chest.get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += chest.get(new NamespacedKey(plugin, "EnchantDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += chest.get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += chest.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += chest.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += chest.get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += chest.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += chest.get(new NamespacedKey(plugin, "EnchantSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += chest.get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += chest.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += chest.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += chest.get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += chest.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += chest.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += chest.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += chest.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += chest.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += chest.get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += chest.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += chest.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ThamauturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += chest.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += chest.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += chest.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += chest.get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += chest.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += chest.get(new NamespacedKey(plugin, "EnchantInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += chest.get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += chest.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += chest.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += chest.get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += chest.get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += chest.get(new NamespacedKey(plugin, "EnchantMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += chest.get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += chest.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += chest.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += chest.get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += chest.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += chest.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += chest.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += chest.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += chest.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += chest.get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += chest.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (chest.get(new NamespacedKey(plugin, "EnchantHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += chest.get(new NamespacedKey(plugin, "EnchantHealMod"),
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

        PersistentDataContainer legs = player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer();

        if (legs.get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += legs.get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += legs.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += legs.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += legs.get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += legs.get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += legs.get(new NamespacedKey(plugin, "EnchantStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += legs.get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += legs.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += legs.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += legs.get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += legs.get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += legs.get(new NamespacedKey(plugin, "EnchantCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += legs.get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += legs.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += legs.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += legs.get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += legs.get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += legs.get(new NamespacedKey(plugin, "EnchantCC"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += legs.get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += legs.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += legs.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += legs.get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += legs.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += legs.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += legs.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += legs.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += legs.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += legs.get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += legs.get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += legs.get(new NamespacedKey(plugin, "EnchantHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += legs.get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += legs.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += legs.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += legs.get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += legs.get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += legs.get(new NamespacedKey(plugin, "EnchantDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += legs.get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += legs.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += legs.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += legs.get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += legs.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += legs.get(new NamespacedKey(plugin, "EnchantSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += legs.get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += legs.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += legs.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += legs.get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += legs.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += legs.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += legs.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += legs.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += legs.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += legs.get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += legs.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += legs.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += legs.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += legs.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += legs.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += legs.get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += legs.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += legs.get(new NamespacedKey(plugin, "EnchantInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += legs.get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += legs.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += legs.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += legs.get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += legs.get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += legs.get(new NamespacedKey(plugin, "EnchantMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += legs.get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += legs.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += legs.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += legs.get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += legs.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += legs.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += legs.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += legs.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += legs.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += legs.get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += legs.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (legs.get(new NamespacedKey(plugin, "EnchantHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += legs.get(new NamespacedKey(plugin, "EnchantHealMod"),
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

        PersistentDataContainer boots = player.getInventory().getBoots().getItemMeta().getPersistentDataContainer();

        if (boots.get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += boots.get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += boots.get(new NamespacedKey(plugin, "ReforgeDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                PersistentDataType.DOUBLE) != null) {
            damageMod += boots.get(new NamespacedKey(plugin, "EnchantDamageModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE) != null) {
            strength += boots.get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += boots.get(new NamespacedKey(plugin, "ReforgeStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantStrength"),
                PersistentDataType.DOUBLE) != null) {
            strength += boots.get(new NamespacedKey(plugin, "EnchantStrength"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "StrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += boots.get(new NamespacedKey(plugin, "StrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += boots.get(new NamespacedKey(plugin, "ReforgeStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                PersistentDataType.DOUBLE) != null) {
            strengthMod += boots.get(new NamespacedKey(plugin, "EnchantStrengthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "Crit"),
                PersistentDataType.DOUBLE) != null) {
            crit += boots.get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += boots.get(new NamespacedKey(plugin, "ReforgeCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantCrit"),
                PersistentDataType.DOUBLE) != null) {
            crit += boots.get(new NamespacedKey(plugin, "EnchantCrit"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "CritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += boots.get(new NamespacedKey(plugin, "CritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += boots.get(new NamespacedKey(plugin, "ReforgeCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                PersistentDataType.DOUBLE) != null) {
            critMod += boots.get(new NamespacedKey(plugin, "EnchantCritModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "CC"),
                PersistentDataType.DOUBLE) != null) {
            CC += boots.get(new NamespacedKey(plugin, "CC"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += boots.get(new NamespacedKey(plugin, "ReforgeCC"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantCC"),
                PersistentDataType.DOUBLE) != null) {
            CC += boots.get(new NamespacedKey(plugin, "EnchantCC"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "CCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += boots.get(new NamespacedKey(plugin, "CCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += boots.get(new NamespacedKey(plugin, "ReforgeCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                PersistentDataType.DOUBLE) != null) {
            CCMod += boots.get(new NamespacedKey(plugin, "EnchantCCModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += boots.get(new NamespacedKey(plugin, "AttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += boots.get(new NamespacedKey(plugin, "ReforgeAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeed += boots.get(new NamespacedKey(plugin, "EnchantAttackSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += boots.get(new NamespacedKey(plugin, "AttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += boots.get(new NamespacedKey(plugin, "ReforgeAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            attackSpeedMod += boots.get(new NamespacedKey(plugin, "EnchantAttackSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != null) {
            health += boots.get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += boots.get(new NamespacedKey(plugin, "ReforgeHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantHealth"),
                PersistentDataType.DOUBLE) != null) {
            health += boots.get(new NamespacedKey(plugin, "EnchantHealth"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "HealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += boots.get(new NamespacedKey(plugin, "HealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += boots.get(new NamespacedKey(plugin, "ReforgeHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                PersistentDataType.DOUBLE) != null) {
            healthMod += boots.get(new NamespacedKey(plugin, "EnchantHealthModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) != null) {
            defense += boots.get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += boots.get(new NamespacedKey(plugin, "ReforgeDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantDefense"),
                PersistentDataType.DOUBLE) != null) {
            defense += boots.get(new NamespacedKey(plugin, "EnchantDefense"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "DefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += boots.get(new NamespacedKey(plugin, "DefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += boots.get(new NamespacedKey(plugin, "ReforgeDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                PersistentDataType.DOUBLE) != null) {
            defenseMod += boots.get(new NamespacedKey(plugin, "EnchantDefenseModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "Speed"),
                PersistentDataType.DOUBLE) != null) {
            speed += boots.get(new NamespacedKey(plugin, "Speed"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += boots.get(new NamespacedKey(plugin, "ReforgeSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantSpeed"),
                PersistentDataType.DOUBLE) != null) {
            speed += boots.get(new NamespacedKey(plugin, "EnchantSpeed"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "SpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += boots.get(new NamespacedKey(plugin, "SpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += boots.get(new NamespacedKey(plugin, "ReforgeSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                PersistentDataType.DOUBLE) != null) {
            speedMod += boots.get(new NamespacedKey(plugin, "EnchantSpeedModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += boots.get(new NamespacedKey(plugin, "Intelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += boots.get(new NamespacedKey(plugin, "ReforgeIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                PersistentDataType.DOUBLE) != null) {
            intelligence += boots.get(new NamespacedKey(plugin, "EnchantIntelligence"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += boots.get(new NamespacedKey(plugin, "IntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += boots.get(new NamespacedKey(plugin, "ReforgeIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                PersistentDataType.DOUBLE) != null) {
            intelligenceMod += boots.get(new NamespacedKey(plugin, "EnchantIntelligenceModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += boots.get(new NamespacedKey(plugin, "Thaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += boots.get(new NamespacedKey(plugin, "ReforgeThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgy += boots.get(new NamespacedKey(plugin, "EnchantThaumaturgy"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += boots.get(new NamespacedKey(plugin, "ThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += boots.get(new NamespacedKey(plugin, "ReforgeThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                PersistentDataType.DOUBLE) != null) {
            thaumaturgyMod += boots.get(new NamespacedKey(plugin, "EnchantThaumaturgyModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += boots.get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += boots.get(new NamespacedKey(plugin, "ReforgeInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantInvocation"),
                PersistentDataType.DOUBLE) != null) {
            invocation += boots.get(new NamespacedKey(plugin, "EnchantInvocation"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "InvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += boots.get(new NamespacedKey(plugin, "InvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += boots.get(new NamespacedKey(plugin, "ReforgeInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                PersistentDataType.DOUBLE) != null) {
            invocationMod += boots.get(new NamespacedKey(plugin, "EnchantInvocationModifier"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "Magic"),
                PersistentDataType.DOUBLE) != null) {
            MF += boots.get(new NamespacedKey(plugin, "Magic"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += boots.get(new NamespacedKey(plugin, "ReforgeMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantMagic"),
                PersistentDataType.DOUBLE) != null) {
            MF += boots.get(new NamespacedKey(plugin, "EnchantMagic"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "FarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += boots.get(new NamespacedKey(plugin, "FarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += boots.get(new NamespacedKey(plugin, "ReforgeFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Farm += boots.get(new NamespacedKey(plugin, "EnchantFarmingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "MiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += boots.get(new NamespacedKey(plugin, "MiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += boots.get(new NamespacedKey(plugin, "ReforgeMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                PersistentDataType.DOUBLE) != null) {
            Mine += boots.get(new NamespacedKey(plugin, "EnchantMiningFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += boots.get(new NamespacedKey(plugin, "ExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += boots.get(new NamespacedKey(plugin, "ReforgeExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                PersistentDataType.DOUBLE) != null) {
            Excavating += boots.get(new NamespacedKey(plugin, "EnchantExcavatingFortune"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += boots.get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += boots.get(new NamespacedKey(plugin, "ReforgeHealMod"),
                    PersistentDataType.DOUBLE);
        }

        if (boots.get(new NamespacedKey(plugin, "EnchantHealMod"),
                PersistentDataType.DOUBLE) != null) {
            healMod += boots.get(new NamespacedKey(plugin, "EnchantHealMod"),
                    PersistentDataType.DOUBLE);
        }
    }

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
            PersistentDataType.DOUBLE, (1 + FarmMod) * Farm);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MiningFortune"),
            PersistentDataType.DOUBLE, (1 + MineMod) * Mine);

    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcavatingFortune"),
            PersistentDataType.DOUBLE, (1 + ExcavatingMod) * Excavating);

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
        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Rank"),
                PersistentDataType.STRING) != null) {
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
                    name = ChatColor.DARK_BLUE + "[" + ChatColor.BLUE + "P" + ChatColor.DARK_PURPLE + "A" + ChatColor.BLUE + "T" + ChatColor.DARK_PURPLE + "R" + ChatColor.BLUE + "O" + ChatColor.DARK_PURPLE + "N" + ChatColor.DARK_BLUE + "] " + ChatColor.BLUE + player.getName();
                    break;
                case "WURM":
                    name = ChatColor.DARK_AQUA + "[WURM] " + player.getName();
                    break;
                default:
                    break;
            }
        }
        player.setDisplayName(name);
        player.setPlayerListName(name);

        new BukkitRunnable() {
            int iterations = 0;
            public void run()
            {
                iterations += 1;
                if (!player.isOnline()) {
                    this.cancel();
                    return;
                }

                if (iterations % 4 == 0) {
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

                PlayerStatEvents.updateStats(player, plugin, functions);

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
        }.runTaskTimer(plugin, 100, 5);
    }
}